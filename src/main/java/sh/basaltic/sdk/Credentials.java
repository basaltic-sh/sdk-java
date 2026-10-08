package sh.basaltic.sdk;

import java.util.Objects;

/** Explicit credentials; diagnostic output always redacts their values. */
public final class Credentials {
  enum Kind {
    BEARER,
    ACCESS_KEY,
    PROVIDER,
    ANONYMOUS
  }

  final Kind kind;
  final String first;
  final String second;
  final TokenProvider provider;

  private Credentials(Kind kind, String first, String second, TokenProvider provider) {
    this.kind = kind;
    this.first = first;
    this.second = second;
    this.provider = provider;
  }

  public static Credentials bearer(String token) {
    validateToken(token);
    return new Credentials(Kind.BEARER, token, null, null);
  }

  public static Credentials accessKey(String id, String secret) {
    if (id == null
        || id.isBlank()
        || id.contains(":")
        || secret == null
        || secret.isEmpty()
        || id.chars().anyMatch(Character::isISOControl)
        || secret.chars().anyMatch(Character::isISOControl))
      throw new SdkException(
          SdkException.Kind.VALIDATION, "Provide a valid access key ID and secret");
    return new Credentials(Kind.ACCESS_KEY, id, secret, null);
  }

  public static Credentials provider(TokenProvider provider) {
    return new Credentials(Kind.PROVIDER, null, null, Objects.requireNonNull(provider));
  }

  public static Credentials anonymous() {
    return new Credentials(Kind.ANONYMOUS, null, null, null);
  }

  static String validateToken(String token) {
    if (token == null || token.isEmpty() || token.chars().anyMatch(c -> c < 33 || c > 126))
      throw new SdkException(
          SdkException.Kind.AUTHENTICATION, "Token provider returned an invalid bearer token");
    return token;
  }

  @Override
  public String toString() {
    return "Credentials{" + kind + ", [REDACTED]}";
  }
}
