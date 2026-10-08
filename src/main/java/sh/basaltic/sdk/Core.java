package sh.basaltic.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

final class Core {
  final Transport transport;
  final Operation operation;
  final String url;
  final ObjectNode query;
  final BinaryBody body;
  final RequestOptions options;

  Core(
      Transport transport,
      String service,
      String endpoint,
      Operation operation,
      Map<String, String> paths,
      Object body,
      Object query) {
    this.transport = transport;
    this.operation = operation;
    this.options = RequestOptions.defaults();
    String route = operation.path();
    for (var entry : paths.entrySet()) {
      String value = entry.getValue();
      if (value == null || value.isEmpty() || value.equals(".") || value.equals(".."))
        Config.invalid("Path segments must not be empty or dot segments");
      route = route.replace("{" + entry.getKey() + "}", encode(value));
    }
    if (route.contains("{") || !route.startsWith("/")) Config.invalid("Invalid operation route");
    url = transport.config.endpoint(service, endpoint) + route;
    Model.validate(query);
    this.query = object(query);
    if (operation.bodyRequired() && body == null) Config.invalid("A request body is required");
    if (body instanceof BinaryBody binary) this.body = binary;
    else if (body == null) this.body = null;
    else {
      Model.validate(body);
      this.body =
          BinaryBody.bytes(
              operation.contentType().equals("application/x-www-form-urlencoded")
                  ? encodeQuery(object(body), Map.of()).getBytes(StandardCharsets.UTF_8)
                  : Json.bytes(body));
    }
  }

  private Core(Core other, RequestOptions options, ObjectNode query) {
    transport = other.transport;
    operation = other.operation;
    url = other.url;
    body = other.body;
    this.options = options;
    this.query = query;
  }

  Core options(RequestOptions value) {
    return new Core(this, Objects.requireNonNull(value), query.deepCopy());
  }

  Core query(String name, String value) {
    ObjectNode copy = query.deepCopy();
    copy.put(name, value);
    return new Core(this, options, copy);
  }

  Core reference(String name, String value) {
    return query(name, value).query("limit", "2");
  }

  Duration timeout() {
    return options.timeout == null ? transport.config.timeout : options.timeout;
  }

  int attempts() {
    return options.maxAttempts == null ? transport.config.maxAttempts : options.maxAttempts;
  }

  boolean replayable() {
    return body == null || body.replayable();
  }

  boolean retryable() {
    return replayable()
        && (Set.of("GET", "HEAD", "OPTIONS", "PUT", "DELETE").contains(operation.method())
            || options.idempotencyKey != null && !options.idempotencyKey.isEmpty());
  }

  URI uri() {
    for (String field : operation.requiredQuery())
      if (!query.hasNonNull(field)) Config.invalid("Missing required query parameter: " + field);
    String encoded = encodeQuery(query, operation.queryEncoding());
    return URI.create(url + (encoded.isEmpty() ? "" : "?" + encoded));
  }

  Map<String, String> headers(String token) {
    TreeMap<String, String> result = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    result.put("User-Agent", "basaltic-sdk-java/" + Client.VERSION);
    result.put("Accept", operation.accept());
    if (body != null && !operation.contentType().isEmpty())
      result.put("Content-Type", operation.contentType());
    if (token != null && operation.authenticated())
      result.put("Authorization", "Bearer " + Credentials.validateToken(token));
    String account = options.accountId == null ? transport.config.accountId : options.accountId;
    if (!account.isEmpty()) result.put("X-Account-ID", account);
    if (options.idempotencyKey != null) {
      if (options.idempotencyKey.isEmpty()) Config.invalid("Idempotency key must not be empty");
      result.put("Idempotency-Key", options.idempotencyKey);
    }
    Set<String> managed =
        Set.of(
            "authorization",
            "proxy-authorization",
            "cookie",
            "host",
            "content-length",
            "connection",
            "upgrade",
            "expect",
            "accept",
            "content-type",
            "user-agent",
            "x-account-id",
            "idempotency-key",
            "transfer-encoding");
    for (var entry : options.headers.entrySet()) {
      String name = entry.getKey();
      if (!name.matches("[!#$%&'*+.^_`|~0-9A-Za-z-]+")
          || managed.contains(name.toLowerCase(Locale.ROOT)))
        Config.invalid("Cannot override a managed or invalid header");
      if (result.put(name, entry.getValue()) != null) Config.invalid("Duplicate header");
    }
    for (String field : operation.requiredHeaders())
      if (!result.containsKey(field) || result.get(field).isEmpty())
        Config.invalid("Missing required header: " + field);
    for (String value : result.values())
      if (value.chars().anyMatch(c -> c < 32 || c > 126))
        Config.invalid("Header values must be printable ASCII");
    return Map.copyOf(result);
  }

  HttpRequest request(String token) {
    Config.validateLimits(timeout(), attempts());
    HttpRequest.Builder request = HttpRequest.newBuilder(uri()).timeout(timeout());
    headers(token).forEach(request::header);
    return request
        .method(
            operation.method(),
            body == null ? HttpRequest.BodyPublishers.noBody() : body.publisher())
        .build();
  }

  static ObjectNode object(Object value) {
    JsonNode node = Json.tree(value == null ? Map.of() : value);
    if (!(node instanceof ObjectNode object))
      throw new SdkException(SdkException.Kind.VALIDATION, "Expected an object");
    return object;
  }

  static String encode(String value) {
    return URLEncoder.encode(value, StandardCharsets.UTF_8).replace("+", "%20");
  }

  private static String scalar(JsonNode node) {
    if (node.isTextual()) return node.textValue();
    if (node.isNumber() || node.isBoolean()) return node.asText();
    throw new SdkException(
        SdkException.Kind.VALIDATION, "Query and form values must be scalar or flat collections");
  }

  static String encodeQuery(ObjectNode value, Map<String, Operation.Encoding> encodings) {
    List<String> output = new ArrayList<>();
    value
        .properties()
        .forEach(
            entry -> {
              String key = entry.getKey();
              JsonNode node = entry.getValue();
              if (node.isNull()) return;
              Operation.Encoding encoding =
                  encodings.getOrDefault(key, new Operation.Encoding("form", true));
              List<String> items = new ArrayList<>();
              if (node.isArray()) {
                for (JsonNode item : node) items.add(scalar(item));
                if (encoding.explode() && encoding.style().equals("form")) {
                  for (String item : items) output.add(encode(key) + "=" + encode(item));
                  return;
                }
              } else if (node.isObject()) {
                node.properties()
                    .forEach(
                        e -> {
                          if (encoding.explode())
                            output.add(encode(e.getKey()) + "=" + encode(scalar(e.getValue())));
                          else {
                            items.add(e.getKey());
                            items.add(scalar(e.getValue()));
                          }
                        });
                if (encoding.explode()) return;
              } else items.add(scalar(node));
              String separator =
                  switch (encoding.style()) {
                    case "spaceDelimited" -> " ";
                    case "pipeDelimited" -> "|";
                    default -> ",";
                  };
              output.add(encode(key) + "=" + encode(String.join(separator, items)));
            });
    return String.join("&", output);
  }
}
