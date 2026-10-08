package sh.basaltic.sdk;

import java.net.http.HttpHeaders;

/** An API error with response metadata; raw response bodies are never retained. */
public final class ApiException extends SdkException {
  private static final long serialVersionUID = 1L;
  private final int status;
  private final String code;
  private final String requestId;
  private final String operation;
  private final transient HttpHeaders headers;

  public ApiException(
      int status,
      String code,
      String message,
      String requestId,
      String operation,
      HttpHeaders headers) {
    super(Kind.API, message);
    this.status = status;
    this.code = code;
    this.requestId = requestId;
    this.operation = operation;
    this.headers = headers;
  }

  public int status() {
    return status;
  }

  public String code() {
    return code;
  }

  public String requestId() {
    return requestId;
  }

  public String operation() {
    return operation;
  }

  public HttpHeaders headers() {
    return headers == null ? HttpHeaders.of(java.util.Map.of(), (name, value) -> true) : headers;
  }
}
