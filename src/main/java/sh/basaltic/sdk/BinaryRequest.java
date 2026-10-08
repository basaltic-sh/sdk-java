package sh.basaltic.sdk;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

/** A streaming download or HEAD request. Always close the returned response. */
public final class BinaryRequest {
  private final Core core;

  BinaryRequest(Core core) {
    this.core = core;
  }

  public BinaryRequest options(RequestOptions value) {
    return new BinaryRequest(core.options(value));
  }

  public BinaryResponse send() {
    return Async.await(sendAsync());
  }

  public CompletableFuture<BinaryResponse> sendAsync() {
    return Async.map(
        core.transport.execute(core, true),
        r -> new BinaryResponse((InputStream) r.body, r.status, r.headers));
  }

  @Override
  public String toString() {
    return "BinaryRequest{" + core.operation.id() + "}";
  }
}
