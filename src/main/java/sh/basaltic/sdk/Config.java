package sh.basaltic.sdk;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/** Immutable client settings. Environment variables are read only by fromEnv(). */
public final class Config {
  final Credentials credentials;
  final String region, accountId, domain;
  final Map<String, String> endpoints;
  final String tokenUrl;
  final Duration timeout, baseDelay, maxDelay;
  final int maxAttempts;

  private Config(Builder b) {
    credentials =
        Objects.requireNonNull(b.credentials, "Provide credentials or explicit anonymous access");
    region = Objects.requireNonNull(b.region);
    accountId = Objects.requireNonNull(b.accountId);
    domain = Objects.requireNonNull(b.domain);
    endpoints = Map.copyOf(b.endpoints);
    tokenUrl = b.tokenUrl;
    timeout = b.timeout;
    baseDelay = b.baseDelay;
    maxDelay = b.maxDelay;
    maxAttempts = b.maxAttempts;
    if (!domain.matches(
        "[A-Za-z0-9]+(?:[A-Za-z0-9-]*[A-Za-z0-9])?(?:\\.[A-Za-z0-9]+(?:[A-Za-z0-9-]*[A-Za-z0-9])?)*"))
      invalid("Invalid API domain");
    validateLimits(timeout, maxAttempts);
    if (baseDelay == null
        || maxDelay == null
        || baseDelay.isNegative()
        || maxDelay.isNegative()
        || baseDelay.compareTo(Duration.ofDays(1)) > 0
        || maxDelay.compareTo(Duration.ofDays(1)) > 0) invalid("Invalid retry delay");
    for (String endpoint : endpoints.values()) validateUrl(endpoint);
    if (tokenUrl != null) validateUrl(tokenUrl);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Config fromEnv() {
    return fromEnv(System.getenv());
  }

  static Config fromEnv(Map<String, String> env) {
    Builder b = builder();
    String token = env.getOrDefault("BASALTIC_ACCESS_TOKEN", "");
    String id = env.getOrDefault("BASALTIC_ACCESS_KEY_ID", "");
    String secret = env.getOrDefault("BASALTIC_SECRET_ACCESS_KEY", "");
    if (!token.isEmpty()) b.credentials(Credentials.bearer(token));
    else if (!id.isEmpty() || !secret.isEmpty()) b.credentials(Credentials.accessKey(id, secret));
    b.region(env.getOrDefault("BASALTIC_REGION", ""));
    b.accountId(env.getOrDefault("BASALTIC_ACCOUNT_ID", ""));
    if (!env.getOrDefault("BASALTIC_DOMAIN", "").isEmpty()) b.domain(env.get("BASALTIC_DOMAIN"));
    env.forEach(
        (key, value) -> {
          if (key.startsWith("BASALTIC_ENDPOINT_URL_") && !value.isEmpty())
            b.endpoint(key.substring(22).toLowerCase(Locale.ROOT), value);
        });
    return b.build();
  }

  String endpoint(String service, String template) {
    String value = endpoints.get(service);
    if (value == null) {
      if (template.contains("{region}") && !region.matches("[a-z0-9]+(?:-[a-z0-9]+)*"))
        invalid("A valid region is required for this service");
      value = template.replace("basaltic.sh", domain).replace("{region}", region);
    }
    validateUrl(value);
    return value.replaceFirst("/+$", "");
  }

  static URI validateUrl(String value) {
    try {
      URI uri = URI.create(value);
      if (!("https".equals(uri.getScheme()) || "http".equals(uri.getScheme()))
          || uri.getHost() == null
          || uri.getRawUserInfo() != null
          || uri.getRawQuery() != null
          || uri.getRawFragment() != null
          || uri.getPort() == 0
          || value.chars().anyMatch(c -> Character.isWhitespace(c) || Character.isISOControl(c)))
        invalid("Endpoint must be an absolute HTTP(S) URL without credentials, query or fragment");
      return uri;
    } catch (IllegalArgumentException e) {
      throw new SdkException(SdkException.Kind.VALIDATION, "Invalid endpoint URL");
    }
  }

  static void validateLimits(Duration timeout, int attempts) {
    if (timeout == null
        || timeout.isZero()
        || timeout.isNegative()
        || timeout.compareTo(Duration.ofDays(1)) > 0
        || attempts < 1
        || attempts > 10)
      invalid("Timeout must be positive and at most one day; maxAttempts must be between 1 and 10");
  }

  static void invalid(String message) {
    throw new SdkException(SdkException.Kind.VALIDATION, message);
  }

  @Override
  public String toString() {
    return "Config{credentials=[REDACTED]}";
  }

  public static final class Builder {
    private Credentials credentials;
    private String region = "", accountId = "", domain = "basaltic.sh", tokenUrl;
    private final Map<String, String> endpoints = new HashMap<>();
    private Duration timeout = Duration.ofSeconds(30),
        baseDelay = Duration.ofMillis(200),
        maxDelay = Duration.ofSeconds(20);
    private int maxAttempts = 4;

    private Builder() {}

    public Builder credentials(Credentials value) {
      credentials = value;
      return this;
    }

    public Builder region(String value) {
      region = value;
      return this;
    }

    public Builder accountId(String value) {
      accountId = value;
      return this;
    }

    public Builder domain(String value) {
      domain = value;
      return this;
    }

    public Builder endpoint(String service, String value) {
      endpoints.put(service, value);
      return this;
    }

    public Builder tokenUrl(String value) {
      tokenUrl = value;
      return this;
    }

    public Builder timeout(Duration value) {
      timeout = value;
      return this;
    }

    public Builder maxAttempts(int value) {
      maxAttempts = value;
      return this;
    }

    public Builder baseDelay(Duration value) {
      baseDelay = value;
      return this;
    }

    public Builder maxDelay(Duration value) {
      maxDelay = value;
      return this;
    }

    public Config build() {
      return new Config(this);
    }
  }
}
