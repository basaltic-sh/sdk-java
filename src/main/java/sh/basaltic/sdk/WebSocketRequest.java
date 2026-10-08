package sh.basaltic.sdk;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

/** Prepares the API's WebSocket URL and headers without opening a socket. */
public final class WebSocketRequest {
  private final Core core;

  WebSocketRequest(Core core) {
    this.core = core;
  }

  public WebSocketRequest options(RequestOptions value) {
    return new WebSocketRequest(core.options(value));
  }

  public WebSocketConnection prepare() {
    return Async.await(prepareAsync());
  }

  public CompletableFuture<WebSocketConnection> prepareAsync() {
    try {
      core.transport.ensureOpen();
      core.request(null);
      CompletableFuture<String> token =
          core.operation.authenticated()
              ? core.transport.tokens.get()
              : CompletableFuture.completedFuture(null);
      return Async.map(
          token,
          t ->
              new WebSocketConnection(
                  URI.create(core.uri().toString().replaceFirst("^http", "ws")), core.headers(t)));
    } catch (Exception e) {
      return CompletableFuture.failedFuture(e);
    }
  }

  @Override
  public String toString() {
    return "WebSocketRequest{" + core.operation.id() + "}";
  }
}
