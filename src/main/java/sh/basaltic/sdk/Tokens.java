package sh.basaltic.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;

final class Tokens {
  private final Transport transport;
  private final Credentials credentials;
  private CompletableFuture<String> refreshing;
  private String cached;
  private long expires;

  Tokens(Transport transport) {
    this.transport = transport;
    credentials = transport.config.credentials;
  }

  synchronized CompletableFuture<String> get() {
    return switch (credentials.kind) {
      case ANONYMOUS -> CompletableFuture.completedFuture(null);
      case BEARER -> CompletableFuture.completedFuture(credentials.first);
      case PROVIDER -> provider();
      case ACCESS_KEY -> oauth().thenApply(value -> value);
    };
  }

  private CompletableFuture<String> provider() {
    try {
      return credentials
          .provider
          .token()
          .handle(
              (token, error) -> {
                if (error != null)
                  throw new SdkException(SdkException.Kind.AUTHENTICATION, "Token provider failed");
                return Credentials.validateToken(token);
              });
    } catch (Exception e) {
      return CompletableFuture.failedFuture(
          new SdkException(SdkException.Kind.AUTHENTICATION, "Token provider failed"));
    }
  }

  private CompletableFuture<String> oauth() {
    if (cached != null && System.nanoTime() - expires < 0)
      return CompletableFuture.completedFuture(cached);
    if (refreshing != null) return refreshing;
    CompletableFuture<String> result = new CompletableFuture<>();
    refreshing = result;
    try {
      String endpoint =
          transport.config.tokenUrl == null
              ? transport.config.endpoint("iam", "https://iam.basaltic.sh") + "/v1/oauth/token"
              : transport.config.tokenUrl;
      String basic =
          Base64.getEncoder()
              .encodeToString(
                  (credentials.first + ":" + credentials.second).getBytes(StandardCharsets.UTF_8));
      HttpRequest request =
          HttpRequest.newBuilder(Config.validateUrl(endpoint))
              .timeout(transport.config.timeout)
              .header("Authorization", "Basic " + basic)
              .header("Content-Type", "application/x-www-form-urlencoded")
              .header("Accept", "application/json")
              .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
              .build();
      transport
          .exchange(request, false, transport.config.timeout, 1024 * 1024)
          .whenComplete(
              (response, error) -> {
                synchronized (this) {
                  try {
                    if (error != null || response.status < 200 || response.status >= 300)
                      throw new IllegalArgumentException();
                    JsonNode node = response.json();
                    String token = Credentials.validateToken(node.path("access_token").asText(""));
                    if (!node.path("token_type").asText("").equalsIgnoreCase("bearer")
                        || !node.path("expires_in").canConvertToLong()
                        || !node.path("expires_in").isIntegralNumber())
                      throw new IllegalArgumentException();
                    long seconds = node.path("expires_in").longValue();
                    if (seconds <= 0 || seconds > 31_536_000) throw new IllegalArgumentException();
                    long nanos = seconds * 1_000_000_000L;
                    long margin = Math.min(nanos / 10, 300_000_000_000L);
                    cached = token;
                    expires = System.nanoTime() + nanos - margin;
                    result.complete(token);
                  } catch (Exception e) {
                    result.completeExceptionally(
                        new SdkException(
                            SdkException.Kind.AUTHENTICATION, "Client credential exchange failed"));
                  } finally {
                    if (refreshing == result) refreshing = null;
                    if (response != null) response.close();
                  }
                }
              });
    } catch (Exception e) {
      refreshing = null;
      result.completeExceptionally(
          new SdkException(SdkException.Kind.AUTHENTICATION, "Client credential exchange failed"));
    }
    return result;
  }

  boolean canRefresh() {
    return credentials.kind == Credentials.Kind.ACCESS_KEY
        || credentials.kind == Credentials.Kind.PROVIDER;
  }

  synchronized void invalidate(String token) {
    if (credentials.kind == Credentials.Kind.PROVIDER) {
      try {
        credentials.provider.invalidate(token);
      } catch (Exception e) {
        throw new SdkException(
            SdkException.Kind.AUTHENTICATION, "Token provider invalidation failed");
      }
    } else if (java.util.Objects.equals(cached, token)) {
      cached = null;
      expires = 0;
    }
  }
}
