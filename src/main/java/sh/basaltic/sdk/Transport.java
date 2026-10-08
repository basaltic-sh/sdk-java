package sh.basaltic.sdk;

import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpTimeoutException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Flow;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sh.basaltic.sdk.internal.Json;

final class Transport implements AutoCloseable {
  final Config config;
  final HttpClient http;
  final Tokens tokens;
  private final ScheduledThreadPoolExecutor scheduler;
  private final Set<CompletableFuture<?>> active = ConcurrentHashMap.newKeySet();
  private final AtomicBoolean closed = new AtomicBoolean();

  Transport(Config config) {
    this.config = config;
    scheduler =
        new ScheduledThreadPoolExecutor(
            1,
            r -> {
              Thread t = new Thread(r, "basaltic-sdk-timer");
              t.setDaemon(true);
              return t;
            });
    scheduler.setRemoveOnCancelPolicy(true);
    http =
        HttpClient.newBuilder()
            .connectTimeout(config.timeout)
            .followRedirects(HttpClient.Redirect.NEVER)
            .proxy(
                new ProxySelector() {
                  @Override
                  public List<Proxy> select(URI uri) {
                    return List.of(Proxy.NO_PROXY);
                  }

                  @Override
                  public void connectFailed(URI uri, SocketAddress address, IOException error) {}
                })
            .build();
    tokens = new Tokens(this);
  }

  private <T> CompletableFuture<T> track(CompletableFuture<T> future) {
    active.add(future);
    future.whenComplete((value, error) -> active.remove(future));
    if (closed.get())
      future.completeExceptionally(new SdkException(SdkException.Kind.CLOSED, "Client is closed"));
    return future;
  }

  CompletableFuture<Raw> exchange(HttpRequest request, boolean binary, Duration timeout) {
    return exchange(request, binary, timeout, 32 * 1024 * 1024);
  }

  CompletableFuture<Raw> exchange(
      HttpRequest request, boolean binary, Duration timeout, int successLimit) {
    if (closed.get())
      return CompletableFuture.failedFuture(
          new SdkException(SdkException.Kind.CLOSED, "Client is closed"));
    CompletableFuture<Raw> result = track(new CompletableFuture<>());
    if (result.isDone()) return result;
    final CompletableFuture<HttpResponse<Object>> network;
    try {
      network =
          http.sendAsync(
              request,
              info -> {
                if (binary && info.statusCode() >= 200 && info.statusCode() < 300)
                  return HttpResponse.BodySubscribers.mapping(
                      HttpResponse.BodySubscribers.ofInputStream(), stream -> (Object) stream);
                return HttpResponse.BodySubscribers.mapping(
                    new LimitedBody(
                        info.statusCode() >= 200 && info.statusCode() < 300
                            ? successLimit
                            : 1024 * 1024),
                    bytes -> (Object) bytes);
              });
    } catch (RuntimeException error) {
      result.completeExceptionally(
          new SdkException(SdkException.Kind.TRANSPORT, "HTTP request could not be started"));
      return result;
    }
    result.whenComplete(
        (value, error) -> {
          if (error != null) network.cancel(true);
        });
    ScheduledFuture<?> timer;
    try {
      timer =
          scheduler.schedule(
              () -> {
                if (result.completeExceptionally(
                    new SdkException(SdkException.Kind.TIMEOUT, "HTTP attempt timed out")))
                  network.cancel(true);
              },
              timeout.toNanos(),
              TimeUnit.NANOSECONDS);
    } catch (java.util.concurrent.RejectedExecutionException error) {
      result.completeExceptionally(new SdkException(SdkException.Kind.CLOSED, "Client is closed"));
      network.whenComplete(
          (response, failure) -> {
            if (response != null && response.body() instanceof InputStream stream) {
              try {
                stream.close();
              } catch (IOException ignored) {
              }
            }
          });
      return result;
    }
    result.whenComplete(
        (value, error) -> {
          timer.cancel(false);
          if (error != null) network.cancel(true);
        });
    network.whenComplete(
        (response, error) -> {
          if (error != null) {
            Throwable cause = Async.unwrap(error);
            result.completeExceptionally(
                cause instanceof SdkException
                    ? cause
                    : new SdkException(
                        cause instanceof HttpTimeoutException
                            ? SdkException.Kind.TIMEOUT
                            : SdkException.Kind.TRANSPORT,
                        "HTTP request failed"));
          } else {
            Raw raw = new Raw(response.statusCode(), response.headers(), response.body());
            if (!result.complete(raw)) raw.close();
          }
        });
    return result;
  }

  CompletableFuture<Raw> execute(Core core, boolean binary) {
    if (closed.get())
      return CompletableFuture.failedFuture(
          new SdkException(SdkException.Kind.CLOSED, "Client is closed"));
    CompletableFuture<Raw> result = track(new CompletableFuture<>());
    AtomicReference<CompletableFuture<Raw>> pending = new AtomicReference<>();
    AtomicReference<ScheduledFuture<?>> delayed = new AtomicReference<>();
    result.whenComplete(
        (value, error) -> {
          if (error != null && pending.get() != null) pending.get().cancel(true);
          if (delayed.get() != null) delayed.get().cancel(false);
        });
    class Attempt {
      void start(int number, boolean refreshed) {
        if (result.isDone()) return;
        try {
          // Validate input before any credential exchange.
          core.request(null);
          CompletableFuture<String> token =
              core.operation.authenticated()
                  ? tokens.get()
                  : CompletableFuture.completedFuture(null);
          token.whenComplete(
              (bearer, authError) -> {
                if (result.isDone()) return;
                if (authError != null) {
                  result.completeExceptionally(Async.unwrap(authError));
                  return;
                }
                try {
                  CompletableFuture<Raw> call =
                      exchange(core.request(bearer), binary, core.timeout());
                  pending.set(call);
                  if (result.isDone()) {
                    call.cancel(true);
                    return;
                  }
                  call.whenComplete(
                      (response, error) -> {
                        if (result.isDone()) {
                          if (response != null) response.close();
                          return;
                        }
                        try {
                          if (error != null) {
                            Throwable cause = Async.unwrap(error);
                            if (core.retryable()
                                && number < core.attempts()
                                && cause instanceof SdkException e
                                && (e.kind() == SdkException.Kind.TRANSPORT
                                    || e.kind() == SdkException.Kind.TIMEOUT)) {
                              retry(number, refreshed, null);
                              return;
                            }
                            result.completeExceptionally(cause);
                            return;
                          }
                          if (response.status == 401
                              && !refreshed
                              && core.replayable()
                              && core.operation.authenticated()
                              && tokens.canRefresh()) {
                            response.close();
                            tokens.invalidate(bearer);
                            start(number, true);
                            return;
                          }
                          if (Set.of(429, 500, 502, 503, 504).contains(response.status)
                              && core.retryable()
                              && number < core.attempts()) {
                            Long delay = retryDelay(response.headers, number);
                            if (delay != null) {
                              response.close();
                              schedule(number, refreshed, delay);
                              return;
                            }
                          }
                          if (response.status < 200 || response.status >= 300) {
                            ApiException api = response.error(core.operation.id());
                            response.close();
                            result.completeExceptionally(api);
                          } else if (!result.complete(response)) response.close();
                        } catch (Exception e) {
                          if (response != null) response.close();
                          result.completeExceptionally(e);
                        }
                      });
                } catch (Exception e) {
                  result.completeExceptionally(e);
                }
              });
        } catch (Exception e) {
          result.completeExceptionally(e);
        }
      }

      void retry(int number, boolean refreshed, HttpHeaders headers) {
        schedule(number, refreshed, retryDelay(headers, number));
      }

      void schedule(int number, boolean refreshed, long delay) {
        ScheduledFuture<?> task =
            scheduler.schedule(() -> start(number + 1, refreshed), delay, TimeUnit.MILLISECONDS);
        delayed.set(task);
        if (result.isDone()) task.cancel(false);
      }
    }
    new Attempt().start(1, false);
    return result;
  }

  private Long retryDelay(HttpHeaders headers, int number) {
    long max = config.maxDelay.toMillis();
    long delay = Math.min(max, config.baseDelay.toMillis() * (1L << Math.min(number - 1, 20)));
    delay = delay == 0 ? 0 : ThreadLocalRandom.current().nextLong(delay + 1);
    String value = headers == null ? "" : headers.firstValue("retry-after").orElse("").trim();
    if (value.isEmpty()) return delay;
    try {
      long required;
      if (value.matches("[0-9]+")) {
        if (value.length() > 12) return null;
        required = Math.multiplyExact(Long.parseLong(value), 1000);
      } else
        required =
            Math.max(
                0,
                Duration.between(
                        Instant.now(),
                        ZonedDateTime.parse(value, DateTimeFormatter.RFC_1123_DATE_TIME)
                            .toInstant())
                    .toMillis());
      return required > max ? null : Math.max(delay, required);
    } catch (Exception e) {
      return delay;
    }
  }

  void ensureOpen() {
    if (closed.get()) throw new SdkException(SdkException.Kind.CLOSED, "Client is closed");
  }

  @Override
  public void close() {
    if (closed.compareAndSet(false, true)) {
      for (CompletableFuture<?> future : active)
        future.completeExceptionally(
            new SdkException(SdkException.Kind.CLOSED, "Client is closed"));
      scheduler.shutdownNow();
    }
  }

  static final class Raw implements AutoCloseable {
    final int status;
    final HttpHeaders headers;
    final Object body;

    Raw(int status, HttpHeaders headers, Object body) {
      this.status = status;
      this.headers = headers;
      this.body = body;
    }

    JsonNode json() {
      byte[] bytes = (byte[]) body;
      return bytes.length == 0 ? Json.tree(java.util.Map.of()) : Json.parse(bytes);
    }

    ApiException error(String operation) {
      String code = "HTTP_" + status, message = "API request failed with HTTP " + status;
      try {
        JsonNode error = json().path("error");
        if (error.path("code").isTextual()) code = error.path("code").asText();
        if (error.path("message").isTextual()) message = error.path("message").asText();
      } catch (SdkException ignored) {
        /* Non-JSON errors retain only status metadata. */
      }
      return new ApiException(
          status, code, message, headers.firstValue("x-request-id").orElse(""), operation, headers);
    }

    @Override
    public void close() {
      if (body instanceof InputStream stream)
        try {
          stream.close();
        } catch (IOException ignored) {
          /* Best-effort release of a discarded response. */
        }
    }
  }

  private static final class LimitedBody implements HttpResponse.BodySubscriber<byte[]> {
    private final HttpResponse.BodySubscriber<byte[]> delegate =
        HttpResponse.BodySubscribers.ofByteArray();
    private final long maximum;
    private Flow.Subscription subscription;
    private long size;
    private boolean failed;

    LimitedBody(long maximum) {
      this.maximum = maximum;
    }

    @Override
    public CompletionStage<byte[]> getBody() {
      return delegate.getBody();
    }

    @Override
    public void onSubscribe(Flow.Subscription value) {
      subscription = value;
      delegate.onSubscribe(value);
    }

    @Override
    public void onNext(List<ByteBuffer> buffers) {
      if (failed) return;
      for (ByteBuffer buffer : buffers) size += buffer.remaining();
      if (size > maximum) {
        failed = true;
        subscription.cancel();
        delegate.onError(
            new SdkException(
                SdkException.Kind.PROTOCOL, "Response exceeded the buffered body limit"));
      } else delegate.onNext(buffers);
    }

    @Override
    public void onError(Throwable error) {
      if (!failed) delegate.onError(error);
    }

    @Override
    public void onComplete() {
      if (!failed) delegate.onComplete();
    }
  }
}
