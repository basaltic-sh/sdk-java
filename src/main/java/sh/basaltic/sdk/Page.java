package sh.basaltic.sdk;

import java.util.List;
import java.util.Set;

/** One typed page with its complete API envelope and pagination metadata. */
public record Page<T, I>(ApiResponse<T> response, List<I> items, boolean hasMore, String marker) {
  public Page {
    items = List.copyOf(items);
  }

  String nextMarker(Set<String> seen) {
    if (!hasMore) return null;
    if (marker == null || marker.isEmpty() || !seen.add(marker))
      throw new SdkException(
          SdkException.Kind.PROTOCOL, "Pagination marker is missing or did not advance");
    return marker;
  }

  @Override
  public String toString() {
    return "Page{items=" + items.size() + ", hasMore=" + hasMore + "}";
  }
}
