package sh.basaltic.sdk;

/** A local SDK, authentication, protocol or transport failure. */
public class SdkException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public enum Kind {
    VALIDATION,
    AUTHENTICATION,
    TRANSPORT,
    TIMEOUT,
    PROTOCOL,
    AMBIGUOUS_REFERENCE,
    CLOSED,
    API
  }

  private final Kind kind;

  public SdkException(Kind kind, String message) {
    super(message);
    this.kind = kind;
  }

  public Kind kind() {
    return kind;
  }
}
