package sh.basaltic.sdk;

import java.io.InputStream;
import java.net.http.HttpRequest;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;

/** Upload bytes, or a one-shot stream that the SDK will never replay. */
public final class BinaryBody {
  private final byte[] bytes;
  private final Supplier<InputStream> stream;
  private final AtomicBoolean opened = new AtomicBoolean();

  private BinaryBody(byte[] bytes, Supplier<InputStream> stream) {
    this.bytes = bytes;
    this.stream = stream;
  }

  public static BinaryBody bytes(byte[] value) {
    return new BinaryBody(value.clone(), null);
  }

  public static BinaryBody stream(Supplier<InputStream> value) {
    return new BinaryBody(null, Objects.requireNonNull(value));
  }

  public static BinaryBody stream(InputStream value) {
    Objects.requireNonNull(value);
    return stream(() -> value);
  }

  boolean replayable() {
    return bytes != null;
  }

  HttpRequest.BodyPublisher publisher() {
    if (bytes != null) return HttpRequest.BodyPublishers.ofByteArray(bytes);
    return HttpRequest.BodyPublishers.ofInputStream(
        () -> {
          if (!opened.compareAndSet(false, true))
            throw new SdkException(
                SdkException.Kind.VALIDATION, "Upload stream has already been consumed");
          return Objects.requireNonNull(stream.get(), "Upload stream supplier returned null");
        });
  }

  @Override
  public String toString() {
    return "BinaryBody{[REDACTED]}";
  }
}
