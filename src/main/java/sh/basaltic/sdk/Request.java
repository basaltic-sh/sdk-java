package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.concurrent.CompletableFuture;
import sh.basaltic.sdk.internal.Json;

/** Immutable, reusable typed request. Construction performs no network IO. */
public final class Request<T> {
  private final Core core;
  private final TypeReference<T> type;
  private final String envelope, itemsKey;

  Request(Core core, TypeReference<T> type) {
    this(core, type, null, null);
  }

  private Request(Core core, TypeReference<T> type, String envelope, String itemsKey) {
    this.core = core;
    this.type = type;
    this.envelope = envelope;
    this.itemsKey = itemsKey;
  }

  public Request<T> options(RequestOptions value) {
    return new Request<>(core.options(value), type, envelope, itemsKey);
  }

  public ApiResponse<T> send() {
    return Async.await(sendAsync());
  }

  public CompletableFuture<ApiResponse<T>> sendAsync() {
    return Async.map(
        core.transport.execute(core, false),
        response -> {
          JsonNode node = response.json();
          if (itemsKey != null) {
            JsonNode items = node.path(itemsKey);
            if (!items.isArray())
              throw new SdkException(SdkException.Kind.PROTOCOL, "Missing resource collection");
            if (items.size() > 1 || node.path("meta").path("has_more").asBoolean(false))
              throw new SdkException(
                  SdkException.Kind.AMBIGUOUS_REFERENCE,
                  "More than one resource matches the reference");
            if (items.isEmpty())
              throw new ApiException(
                  404,
                  "REFERENCE_NOT_FOUND",
                  "No resource matches the reference",
                  response.headers.firstValue("x-request-id").orElse(""),
                  core.operation.id(),
                  response.headers);
            node = items.get(0);
          } else if (envelope != null) {
            node = node.get(envelope);
            if (node == null || node.isNull())
              throw new SdkException(SdkException.Kind.PROTOCOL, "Missing resource envelope");
          }
          return new ApiResponse<>(Json.convert(node, type), response.status, response.headers);
        });
  }

  static <T> Request<T> reference(
      Core get,
      Core list,
      String reference,
      boolean acceptsName,
      String envelope,
      String itemsKey,
      TypeReference<T> type) {
    if (reference == null || reference.isEmpty())
      Config.invalid("Resource reference must not be empty");
    if (reference.matches(
        "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"))
      return new Request<>(get, type, envelope, null);
    boolean crn = reference.startsWith("crn:");
    if (!crn && !acceptsName) Config.invalid("This resource requires a UUID or CRN");
    return new Request<>(list.reference(crn ? "crn" : "name", reference), type, null, itemsKey);
  }

  @Override
  public String toString() {
    return "Request{" + core.operation.id() + "}";
  }
}
