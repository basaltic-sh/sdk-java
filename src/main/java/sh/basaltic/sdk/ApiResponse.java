package sh.basaltic.sdk;

import java.net.http.HttpHeaders;
import java.util.function.Function;

/** A typed response envelope and its HTTP metadata. */
public record ApiResponse<T>(T data, int status, HttpHeaders headers) {
  public String requestId() {
    return headers.firstValue("x-request-id").orElse("");
  }

  public <U> ApiResponse<U> map(Function<T, U> mapper) {
    return new ApiResponse<>(mapper.apply(data), status, headers);
  }

  @Override
  public String toString() {
    return "ApiResponse{status=" + status + ", data=[REDACTED]}";
  }
}
