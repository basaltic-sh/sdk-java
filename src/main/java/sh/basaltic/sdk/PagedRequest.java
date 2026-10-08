package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Flow;
import sh.basaltic.sdk.internal.Json;

/** Typed list request with lazy iteration and asynchronous pages with backpressure. */
public final class PagedRequest<T, I> {
  private final Core core;
  private final TypeReference<T> type;
  private final TypeReference<I> itemType;
  private final String itemsKey;

  PagedRequest(Core core, TypeReference<T> type, TypeReference<I> itemType, String itemsKey) {
    this.core = core;
    this.type = type;
    this.itemType = itemType;
    this.itemsKey = itemsKey;
  }

  public PagedRequest<T, I> options(RequestOptions value) {
    return new PagedRequest<>(core.options(value), type, itemType, itemsKey);
  }

  private PagedRequest<T, I> next(Core value) {
    return new PagedRequest<>(value, type, itemType, itemsKey);
  }

  public Page<T, I> send() {
    return Async.await(sendAsync());
  }

  public CompletableFuture<Page<T, I>> sendAsync() {
    return Async.map(
        core.transport.execute(core, false),
        response -> {
          JsonNode node = response.json();
          JsonNode array = node.path(itemsKey);
          if (!array.isArray())
            throw new SdkException(
                SdkException.Kind.PROTOCOL, "List response is missing its items array");
          List<I> items = new ArrayList<>();
          for (JsonNode item : array) items.add(Json.convert(item, itemType));
          return new Page<>(
              new ApiResponse<>(Json.convert(node, type), response.status, response.headers),
              items,
              node.path("meta").path("has_more").asBoolean(false),
              node.path("meta").path("marker").asText(null));
        });
  }

  private Set<String> markers() {
    Set<String> result = new HashSet<>();
    result.add(core.query.path("marker").asText(""));
    return result;
  }

  /** Each iterator starts independently and only requests a page when advanced. */
  public Iterable<Page<T, I>> pages() {
    return () ->
        new Iterator<>() {
          private Core current = core;
          private final Set<String> seen = markers();
          private boolean done;

          @Override
          public boolean hasNext() {
            return !done;
          }

          @Override
          public Page<T, I> next() {
            if (done) throw new NoSuchElementException();
            Page<T, I> page = PagedRequest.this.next(current).send();
            String marker = page.nextMarker(seen);
            done = marker == null;
            if (!done) current = current.query("marker", marker);
            return page;
          }
        };
  }

  public Iterable<I> items() {
    return () ->
        new Iterator<>() {
          private final Iterator<Page<T, I>> pages = pages().iterator();
          private Iterator<I> items = List.<I>of().iterator();

          @Override
          public boolean hasNext() {
            while (!items.hasNext() && pages.hasNext()) items = pages.next().items().iterator();
            return items.hasNext();
          }

          @Override
          public I next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items.next();
          }
        };
  }

  /** A cold publisher: one HTTP request at a time, no prefetch, cancellation propagates. */
  public Flow.Publisher<Page<T, I>> pagesAsync() {
    return subscriber -> {
      java.util.Objects.requireNonNull(subscriber);
      class Subscription implements Flow.Subscription {
        private final Set<String> seen = markers();
        private Core current = core;
        private long demand;
        private boolean stopped, busy;
        private CompletableFuture<Page<T, I>> pending;

        @Override
        public synchronized void request(long count) {
          if (stopped) return;
          if (count <= 0) {
            fail(new IllegalArgumentException("Demand must be positive"));
            return;
          }
          demand = count > Long.MAX_VALUE - demand ? Long.MAX_VALUE : demand + count;
          advance();
        }

        @Override
        public synchronized void cancel() {
          stopped = true;
          if (pending != null) pending.cancel(true);
        }

        private synchronized void fail(Throwable error) {
          if (stopped) return;
          cancel();
          subscriber.onError(error);
        }

        private synchronized void advance() {
          if (stopped || busy || demand == 0) return;
          busy = true;
          pending = PagedRequest.this.next(current).sendAsync();
          pending.whenComplete(
              (page, error) -> {
                synchronized (this) {
                  if (stopped) return;
                  if (error != null) {
                    fail(Async.unwrap(error));
                    return;
                  }
                  try {
                    String marker = page.nextMarker(seen);
                    if (marker != null) current = current.query("marker", marker);
                    demand--;
                    subscriber.onNext(page);
                    busy = false;
                    if (stopped) return;
                    if (marker == null) {
                      stopped = true;
                      subscriber.onComplete();
                    } else advance();
                  } catch (Exception e) {
                    fail(e);
                  }
                }
              });
        }
      }
      subscriber.onSubscribe(new Subscription());
    };
  }

  @Override
  public String toString() {
    return "PagedRequest{" + core.operation.id() + "}";
  }
}
