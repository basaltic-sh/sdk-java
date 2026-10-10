package sh.basaltic.sdk;

import java.util.Objects;

/** Thread-safe client. Close it to cancel outstanding requests and release its timer. */
public final class Client extends GeneratedClient implements AutoCloseable {
  public static final String VERSION = "0.3.1";
  private final Transport transport;

  public Client(Config config) {
    transport = new Transport(Objects.requireNonNull(config));
  }

  public static Client fromEnv() {
    return new Client(Config.fromEnv());
  }

  @Override
  Transport transport() {
    return transport;
  }

  @Override
  public void close() {
    transport.close();
  }

  @Override
  public String toString() {
    return "Client{credentials=[REDACTED]}";
  }
}
