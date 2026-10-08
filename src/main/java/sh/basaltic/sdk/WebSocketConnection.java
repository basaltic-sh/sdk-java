package sh.basaltic.sdk;

import java.net.URI;
import java.util.Map;

/** Authenticated descriptor; connect using your chosen WebSocket implementation. */
public record WebSocketConnection(URI uri, Map<String, String> headers) {
  public WebSocketConnection {
    headers = Map.copyOf(headers);
  }

  @Override
  public String toString() {
    return "WebSocketConnection{[REDACTED]}";
  }
}
