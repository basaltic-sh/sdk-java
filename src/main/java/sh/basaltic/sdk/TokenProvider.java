package sh.basaltic.sdk;

import java.util.concurrent.CompletableFuture;

/** Supplies a bearer token. Implementations own their token caching and refresh policy. */
@FunctionalInterface
public interface TokenProvider {
  CompletableFuture<String> token();

  /** Called once after the server rejects a token with HTTP 401. */
  default void invalidate(String rejectedToken) {}
}
