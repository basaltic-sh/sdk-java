package sh.basaltic.sdk;

import java.util.List;
import java.util.Map;

record Operation(
    String id,
    String method,
    String path,
    boolean authenticated,
    List<String> requiredQuery,
    List<String> requiredHeaders,
    Map<String, Encoding> queryEncoding,
    boolean bodyRequired,
    String contentType,
    String accept) {
  record Encoding(String style, boolean explode) {}
}
