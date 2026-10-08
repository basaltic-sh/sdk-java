package sh.basaltic.sdk;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/** Immutable per-request overrides. Custom headers cannot replace SDK-managed headers. */
public final class RequestOptions {
  final String accountId, idempotencyKey;
  final Duration timeout;
  final Integer maxAttempts;
  final Map<String, String> headers;

  private RequestOptions(Builder b) {
    accountId = b.accountId;
    idempotencyKey = b.idempotencyKey;
    timeout = b.timeout;
    maxAttempts = b.maxAttempts;
    headers = Map.copyOf(b.headers);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static RequestOptions defaults() {
    return builder().build();
  }

  public static String newIdempotencyKey() {
    return UUID.randomUUID().toString();
  }

  @Override
  public String toString() {
    return "RequestOptions{[REDACTED]}";
  }

  public static final class Builder {
    private String accountId, idempotencyKey;
    private Duration timeout;
    private Integer maxAttempts;
    private final Map<String, String> headers = new HashMap<>();

    private Builder() {}

    public Builder accountId(String value) {
      accountId = value;
      return this;
    }

    public Builder idempotencyKey(String value) {
      idempotencyKey = value;
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

    public Builder header(String name, String value) {
      headers.put(name, value);
      return this;
    }

    public RequestOptions build() {
      return new RequestOptions(this);
    }
  }
}
