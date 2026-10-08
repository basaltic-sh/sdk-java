package sh.basaltic.sdk;

import java.util.concurrent.CompletableFuture;

/** A request whose successful response has no JSON body. */
public final class EmptyRequest {
  private final Core core;

  EmptyRequest(Core core) {
    this.core = core;
  }

  public EmptyRequest options(RequestOptions value) {
    return new EmptyRequest(core.options(value));
  }

  public ApiResponse<Void> send() {
    return Async.await(sendAsync());
  }

  public CompletableFuture<ApiResponse<Void>> sendAsync() {
    return Async.map(
        core.transport.execute(core, false), r -> new ApiResponse<>(null, r.status, r.headers));
  }

  @Override
  public String toString() {
    return "EmptyRequest{" + core.operation.id() + "}";
  }
}
