package sh.basaltic.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;

/** Streaming response. Close it even when you do not consume all bytes. */
public record BinaryResponse(InputStream stream, int status, HttpHeaders headers)
    implements AutoCloseable {
  public String requestId() {
    return headers.firstValue("x-request-id").orElse("");
  }

  @Override
  public void close() throws IOException {
    stream.close();
  }

  @Override
  public String toString() {
    return "BinaryResponse{status=" + status + "}";
  }
}
