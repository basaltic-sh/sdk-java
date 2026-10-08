package sh.basaltic.sdk;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.net.httpserver.HttpServer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.models.Compute;
import sh.basaltic.sdk.models.Iam;

final class ClientTest {
  private static byte[] bytes(String value) {
    return value.getBytes(StandardCharsets.UTF_8);
  }

  private static String image(String id) {
    return "{\"id\":\"" + id + "\",\"status\":\"active\",\"created_at\":\"2026-01-01T00:00:00Z\"}";
  }

  private static Reply imageReply(String id) {
    return new Reply(200, "{\"image\":" + image(id) + "}");
  }

  record Incoming(String method, URI uri, Map<String, List<String>> headers, byte[] body) {
    String header(String key) {
      return headers.entrySet().stream()
          .filter(e -> e.getKey().equalsIgnoreCase(key))
          .map(e -> e.getValue().get(0))
          .findFirst()
          .orElse(null);
    }
  }

  record Reply(int status, String body, Map<String, String> headers, long delay, long bodyDelay) {
    Reply(int status, String body) {
      this(status, body, Map.of(), 0, 0);
    }

    Reply withHeaders(Map<String, String> value) {
      return new Reply(status, body, value, delay, bodyDelay);
    }

    Reply delay(long value) {
      return new Reply(status, body, headers, value, bodyDelay);
    }

    Reply bodyDelay(long value) {
      return new Reply(status, body, headers, delay, value);
    }
  }

  static final class Fixture implements AutoCloseable {
    final HttpServer server;
    final ExecutorService executor = Executors.newCachedThreadPool();
    final List<Incoming> requests = new CopyOnWriteArrayList<>();
    final List<Throwable> errors = new CopyOnWriteArrayList<>();

    Fixture(Function<Incoming, Reply> handler) throws IOException {
      server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
      server.setExecutor(executor);
      server.createContext(
          "/",
          exchange -> {
            try {
              Incoming request =
                  new Incoming(
                      exchange.getRequestMethod(),
                      exchange.getRequestURI(),
                      Map.copyOf(exchange.getRequestHeaders()),
                      exchange.getRequestBody().readAllBytes());
              requests.add(request);
              Reply reply = handler.apply(request);
              if (reply.delay > 0) Thread.sleep(reply.delay);
              reply.headers.forEach((k, v) -> exchange.getResponseHeaders().add(k, v));
              boolean empty = request.method.equals("HEAD") || reply.status == 204;
              byte[] body = bytes(reply.body);
              exchange.sendResponseHeaders(reply.status, empty ? -1 : body.length);
              if (reply.bodyDelay > 0) Thread.sleep(reply.bodyDelay);
              if (!empty) exchange.getResponseBody().write(body);
            } catch (IOException ignored) {
              /* Clients intentionally cancel timeout and cancellation fixtures. */
            } catch (InterruptedException e) {
              Thread.currentThread().interrupt();
            } catch (Throwable e) {
              errors.add(e);
            } finally {
              exchange.close();
            }
          });
      server.start();
    }

    String url() {
      return "http://127.0.0.1:" + server.getAddress().getPort();
    }

    Config.Builder config() {
      return Config.builder()
          .credentials(Credentials.bearer("fixture-token"))
          .region("test-1")
          .accountId("account")
          .endpoint("compute", url())
          .endpoint("storage", url())
          .endpoint("iam", url())
          .baseDelay(Duration.ZERO)
          .maxAttempts(3);
    }

    Client client() {
      return new Client(config().build());
    }

    @Override
    public void close() {
      server.stop(0);
      executor.shutdownNow();
      assertTrue(errors.isEmpty(), errors.toString());
    }
  }

  @Test
  void typedEnvelopeAndHeaders() throws Exception {
    try (Fixture f =
            new Fixture(r -> imageReply("one").withHeaders(Map.of("x-request-id", "request-one")));
        Client c = f.client()) {
      var response =
          c.compute()
              .getImage("one")
              .options(
                  RequestOptions.builder().accountId("other").header("x-custom", "value").build())
              .send();
      assertEquals("one", response.data().getImage().getId());
      assertEquals(Compute.ImageStatus.ACTIVE, response.data().getImage().getStatus());
      assertEquals(200, response.status());
      assertEquals("request-one", response.requestId());
      Incoming r = f.requests.get(0);
      assertEquals("Bearer fixture-token", r.header("authorization"));
      assertEquals("other", r.header("x-account-id"));
      assertEquals("value", r.header("x-custom"));
      assertNull(r.header("cookie"));
      assertFalse(response.toString().contains("fixture-token"));
    }
  }

  @Test
  void pathEncodingAndEndpointPrefix() throws Exception {
    try (Fixture f = new Fixture(r -> imageReply("one"));
        Client c = new Client(f.config().endpoint("compute", f.url() + "/api/").build())) {
      c.compute().getImage("a/b ?%ü").send();
      assertEquals("/api/v1/images/a%2Fb%20%3F%25%C3%BC", f.requests.get(0).uri.getRawPath());
      for (String id : List.of("", ".", ".."))
        assertThrows(SdkException.class, () -> c.compute().getImage(id));
    }
  }

  @Test
  void falseZeroEmptyAndSnapshotInputs() throws Exception {
    try (Fixture f = new Fixture(r -> new Reply(200, "{\"images\":[]}"));
        Client c = f.client()) {
      var query = new Compute.ListImagesQuery().withLimit(0L).withAllVersions(false).withName("");
      var call = c.compute().listImages(query);
      query.withName("changed");
      call.send();
      String q = f.requests.get(0).uri.getRawQuery();
      assertTrue(q.contains("limit=0"));
      assertTrue(q.contains("all_versions=false"));
      assertTrue(q.contains("name="));
      assertFalse(q.contains("changed"));
    }
  }

  @Test
  void jsonPropertyNamesDoNotDuplicateSnakeCase() {
    var body =
        new Compute.ImageCreateRequestInput()
            .withName("linux")
            .withSourceUrl("https://example.test/image");
    JsonNode node = Json.tree(body);
    assertEquals(2, node.size());
    assertTrue(node.has("source_url"));
    assertFalse(node.has("sourceUrl"));
    var response =
        Json.convert(Json.parse(bytes(image("one"))), new TypeReference<Compute.Image>() {});
    assertEquals("2026-01-01T00:00:00Z", response.getCreatedAt());
    assertFalse(Json.tree(response).has("createdAt"));
  }

  @Test
  void unknownEnumValuesAreRetained() {
    var status = Json.convert(Json.tree("new-status"), new TypeReference<Compute.ImageStatus>() {});
    assertEquals("new-status", status.value());
    assertEquals(Json.tree("new-status"), Json.tree(status));
  }

  @Test
  void requiredBodiesAreValidatedBeforeNetwork() throws Exception {
    try (Fixture f = new Fixture(r -> imageReply("one"));
        Client c = f.client()) {
      SdkException e =
          assertThrows(
              SdkException.class,
              () -> c.compute().createInstance(new Compute.InstanceCreateRequestInput()));
      assertEquals(SdkException.Kind.VALIDATION, e.kind());
      assertTrue(f.requests.isEmpty());
      assertThrows(SdkException.class, () -> c.compute().createInstance(null));
    }
  }

  @Test
  void managedAndRequiredHeaders() throws Exception {
    try (Fixture f = new Fixture(r -> new Reply(204, ""));
        Client c = f.client()) {
      assertThrows(
          SdkException.class,
          () ->
              c.compute()
                  .startInstance("one")
                  .options(RequestOptions.builder().header("Authorization", "replacement").build())
                  .send());
      assertThrows(
          SdkException.class,
          () ->
              c.compute()
                  .startInstance("one")
                  .options(RequestOptions.builder().header("x-extra", "bad\r\nvalue").build())
                  .send());
      assertThrows(SdkException.class, () -> c.storage().deleteBucketLifecycle("bucket").send());
      assertTrue(f.requests.isEmpty());
      c.storage()
          .deleteBucketLifecycle("bucket")
          .options(RequestOptions.builder().header("If-Match", "etag").build())
          .send();
      assertEquals("etag", f.requests.get(0).header("if-match"));
    }
  }

  @Test
  void retriesOnlySafeOrIdempotentOperations() throws Exception {
    for (int mode = 0; mode < 3; mode++) {
      try (Fixture f =
              new Fixture(
                  r ->
                      new Reply(503, "{\"error\":{\"code\":\"BUSY\",\"message\":\"Try later\"}}"));
          Client c = f.client()) {
        int selected = mode;
        ApiException e =
            assertThrows(
                ApiException.class,
                () -> {
                  if (selected == 0) c.compute().getImage("one").send();
                  else
                    c.compute()
                        .startInstance("one")
                        .options(
                            RequestOptions.builder()
                                .idempotencyKey(selected == 2 ? "stable" : null)
                                .build())
                        .send();
                });
        assertEquals(mode == 1 ? 1 : 3, f.requests.size());
        assertEquals(503, e.status());
        assertEquals("BUSY", e.code());
        if (mode == 2)
          for (Incoming r : f.requests) assertEquals("stable", r.header("idempotency-key"));
      }
    }
  }

  @Test
  void retryAfterWillNotRetryEarlierThanServerRequires() throws Exception {
    for (String delay : List.of("3600", "999999999999999999999999999")) {
      try (Fixture f =
              new Fixture(r -> new Reply(429, "{}").withHeaders(Map.of("retry-after", delay)));
          Client c = f.client()) {
        assertThrows(ApiException.class, () -> c.compute().getImage("one").send());
        assertEquals(1, f.requests.size());
      }
    }
  }

  @Test
  void oneShotUploadIsNotReplayed() throws Exception {
    try (Fixture f = new Fixture(r -> new Reply(503, "{}"));
        Client c = f.client()) {
      var request =
          c.storage()
              .putObject(
                  "bucket", "key", BinaryBody.stream(new ByteArrayInputStream(bytes("payload"))));
      assertThrows(
          ApiException.class,
          () -> request.options(RequestOptions.builder().idempotencyKey("stable").build()).send());
      assertEquals(1, f.requests.size());
      assertEquals("payload", new String(f.requests.get(0).body, StandardCharsets.UTF_8));
    }
  }

  @Test
  void redirectsNeverForwardCredentials() throws Exception {
    try (Fixture target = new Fixture(r -> imageReply("leak"));
        Fixture f =
            new Fixture(
                r -> new Reply(302, "").withHeaders(Map.of("location", target.url() + "/stolen")));
        Client c = f.client()) {
      assertEquals(
          302, assertThrows(ApiException.class, () -> c.compute().getImage("one").send()).status());
      assertTrue(target.requests.isEmpty());
    }
  }

  @Test
  void synchronousAndAsyncBodiesTimeout() throws Exception {
    try (Fixture f = new Fixture(r -> imageReply("one").bodyDelay(500));
        Client c = f.client()) {
      var call =
          c.compute()
              .getImage("one")
              .options(
                  RequestOptions.builder().timeout(Duration.ofMillis(100)).maxAttempts(1).build());
      assertEquals(SdkException.Kind.TIMEOUT, assertThrows(SdkException.class, call::send).kind());
      CompletionException e =
          assertThrows(CompletionException.class, () -> call.sendAsync().join());
      assertEquals(SdkException.Kind.TIMEOUT, ((SdkException) e.getCause()).kind());
    }
  }

  @Test
  void oauthIsSingleFlight() throws Exception {
    AtomicInteger exchanges = new AtomicInteger();
    try (Fixture f =
            new Fixture(
                r -> {
                  if (r.uri.getPath().equals("/v1/oauth/token")) {
                    exchanges.incrementAndGet();
                    assertEquals(
                        "Basic " + Base64.getEncoder().encodeToString(bytes("key:secret")),
                        r.header("authorization"));
                    assertEquals(
                        "grant_type=client_credentials",
                        new String(r.body, StandardCharsets.UTF_8));
                    return new Reply(
                            200,
                            "{\"access_token\":\"issued-token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
                        .delay(100);
                  }
                  assertEquals("Bearer issued-token", r.header("authorization"));
                  return imageReply("one");
                });
        Client c =
            new Client(f.config().credentials(Credentials.accessKey("key", "secret")).build())) {
      List<CompletableFuture<?>> calls = new ArrayList<>();
      for (int i = 0; i < 20; i++) calls.add(c.compute().getImage("one").sendAsync());
      CompletableFuture.allOf(calls.toArray(CompletableFuture<?>[]::new)).get(10, TimeUnit.SECONDS);
      assertEquals(1, exchanges.get());
    }
  }

  @Test
  void oauthRefreshesOnceAfter401() throws Exception {
    AtomicInteger exchanges = new AtomicInteger();
    try (Fixture f =
            new Fixture(
                r -> {
                  if (r.uri.getPath().equals("/v1/oauth/token"))
                    return new Reply(
                        200,
                        "{\"access_token\":\"token-"
                            + exchanges.incrementAndGet()
                            + "\",\"token_type\":\"Bearer\",\"expires_in\":3600}");
                  return "Bearer token-1".equals(r.header("authorization"))
                      ? new Reply(401, "{}")
                      : imageReply("one");
                });
        Client c =
            new Client(f.config().credentials(Credentials.accessKey("key", "secret")).build())) {
      assertEquals("one", c.compute().getImage("one").send().data().getImage().getId());
      assertEquals(2, exchanges.get());
    }
  }

  @Test
  void cancellingOneCallerDoesNotPoisonSharedTokenRefresh() throws Exception {
    CountDownLatch started = new CountDownLatch(1);
    AtomicInteger exchanges = new AtomicInteger();
    try (Fixture f =
            new Fixture(
                r -> {
                  if (r.uri.getPath().equals("/v1/oauth/token")) {
                    exchanges.incrementAndGet();
                    started.countDown();
                    return new Reply(
                            200,
                            "{\"access_token\":\"token\",\"token_type\":\"Bearer\",\"expires_in\":3600}")
                        .delay(200);
                  }
                  return imageReply("one");
                });
        Client c =
            new Client(f.config().credentials(Credentials.accessKey("key", "secret")).build())) {
      var canceled = c.compute().getImage("one").sendAsync();
      assertTrue(started.await(3, TimeUnit.SECONDS));
      var survivor = c.compute().getImage("one").sendAsync();
      canceled.cancel(true);
      assertEquals("one", survivor.get(5, TimeUnit.SECONDS).data().getImage().getId());
      assertEquals(1, exchanges.get());
      assertTrue(canceled.isCancelled());
    }
  }

  @Test
  void customProviderRefreshAndErrorsAreSanitized() throws Exception {
    AtomicInteger number = new AtomicInteger(1);
    TokenProvider provider =
        new TokenProvider() {
          @Override
          public CompletableFuture<String> token() {
            return CompletableFuture.completedFuture("token-" + number.get());
          }

          @Override
          public void invalidate(String rejected) {
            number.incrementAndGet();
          }
        };
    try (Fixture f =
            new Fixture(
                r ->
                    r.header("authorization").equals("Bearer token-1")
                        ? new Reply(401, "{}")
                        : imageReply("one"));
        Client c = new Client(f.config().credentials(Credentials.provider(provider)).build())) {
      c.compute().getImage("one").send();
      assertEquals(2, number.get());
    }
    try (Fixture f = new Fixture(r -> imageReply("one"));
        Client c =
            new Client(
                f.config()
                    .credentials(
                        Credentials.provider(
                            () ->
                                CompletableFuture.failedFuture(
                                    new IllegalStateException("secret-value"))))
                    .build())) {
      SdkException error =
          assertThrows(SdkException.class, () -> c.compute().getImage("one").send());
      assertFalse(error.toString().contains("secret-value"));
      assertNull(error.getCause());
      assertTrue(f.requests.isEmpty());
    }
  }

  @Test
  void oauthFailureDoesNotExposeResponse() throws Exception {
    try (Fixture f = new Fixture(r -> new Reply(400, "private-token-value"));
        Client c =
            new Client(
                f.config().credentials(Credentials.accessKey("key", "private-secret")).build())) {
      SdkException e = assertThrows(SdkException.class, () -> c.compute().getImage("one").send());
      assertEquals(SdkException.Kind.AUTHENTICATION, e.kind());
      assertFalse(e.toString().contains("private"));
      assertNull(e.getCause());
      assertFalse(c.toString().contains("private"));
      assertFalse(
          Credentials.accessKey("key", "private-secret").toString().contains("private-secret"));
    }
  }

  @Test
  void explicitAnonymousSkipsAuthorization() throws Exception {
    try (Fixture f = new Fixture(r -> imageReply("one"));
        Client c = new Client(f.config().credentials(Credentials.anonymous()).build())) {
      c.compute().getImage("one").send();
      assertNull(f.requests.get(0).header("authorization"));
    }
  }

  @Test
  void paginationIsLazyAndDetectsBrokenMarkers() throws Exception {
    try (Fixture f =
            new Fixture(
                r ->
                    r.uri.getRawQuery() == null
                        ? new Reply(
                            200,
                            "{\"images\":["
                                + image("one")
                                + "],\"meta\":{\"has_more\":true,\"marker\":\"next\"}}")
                        : new Reply(200, "{\"images\":[" + image("two") + "]}"));
        Client c = f.client()) {
      var iterator = c.compute().listImages().items().iterator();
      assertTrue(f.requests.isEmpty());
      assertEquals("one", iterator.next().getId());
      assertEquals(1, f.requests.size());
      assertEquals("two", iterator.next().getId());
      assertFalse(iterator.hasNext());
      assertEquals("marker=next", f.requests.get(1).uri.getRawQuery());
    }
    for (String meta : List.of("{\"has_more\":true}", "{\"has_more\":true,\"marker\":\"same\"}")) {
      try (Fixture f = new Fixture(r -> new Reply(200, "{\"images\":[],\"meta\":" + meta + "}"));
          Client c = f.client()) {
        var iterator =
            c.compute()
                .listImages(new Compute.ListImagesQuery().withMarker("same"))
                .pages()
                .iterator();
        assertThrows(SdkException.class, iterator::next);
      }
    }
  }

  @Test
  void asyncPagesHonorDemandAndCancellation() throws Exception {
    AtomicReference<Flow.Subscription> subscription = new AtomicReference<>();
    CompletableFuture<Void> first = new CompletableFuture<>();
    AtomicInteger pages = new AtomicInteger();
    try (Fixture f =
            new Fixture(
                r ->
                    new Reply(
                        200, "{\"images\":[],\"meta\":{\"has_more\":true,\"marker\":\"next\"}}"));
        Client c = f.client()) {
      c.compute()
          .listImages()
          .pagesAsync()
          .subscribe(
              new Flow.Subscriber<>() {
                @Override
                public void onSubscribe(Flow.Subscription value) {
                  subscription.set(value);
                }

                @Override
                public void onNext(Page<Compute.ImageListResponse, Compute.Image> page) {
                  pages.incrementAndGet();
                  first.complete(null);
                }

                @Override
                public void onError(Throwable error) {
                  first.completeExceptionally(error);
                }

                @Override
                public void onComplete() {
                  first.complete(null);
                }
              });
      assertTrue(f.requests.isEmpty());
      subscription.get().request(1);
      first.get(5, TimeUnit.SECONDS);
      subscription.get().cancel();
      subscription.get().request(1);
      assertEquals(1, pages.get());
      assertEquals(1, f.requests.size());
    }
  }

  @Test
  void referencesRejectMissingAndAmbiguousNames() throws Exception {
    for (int count = 0; count <= 2; count++) {
      int size = count;
      try (Fixture f =
              new Fixture(
                  r ->
                      new Reply(
                          200,
                          "{\"images\":["
                              + (size == 0
                                  ? ""
                                  : image("one") + (size == 2 ? "," + image("two") : ""))
                              + "]}"));
          Client c = f.client()) {
        if (size == 1)
          assertEquals("one", c.compute().getImageByReference("linux").send().data().getId());
        else if (size == 0)
          assertEquals(
              404,
              assertThrows(
                      ApiException.class, () -> c.compute().getImageByReference("linux").send())
                  .status());
        else
          assertEquals(
              SdkException.Kind.AMBIGUOUS_REFERENCE,
              assertThrows(
                      SdkException.class, () -> c.compute().getImageByReference("linux").send())
                  .kind());
        assertTrue(f.requests.get(0).uri.getRawQuery().contains("limit=2"));
        assertTrue(f.requests.get(0).uri.getRawQuery().contains("name=linux"));
      }
    }
    try (Fixture f = new Fixture(r -> imageReply("one"));
        Client c = f.client()) {
      c.compute().getImageByReference("00000000-0000-4000-8000-000000000000").send();
      assertNull(f.requests.get(0).uri.getRawQuery());
    }
  }

  @Test
  void binaryResponsesAndHeadMetadata() throws Exception {
    try (Fixture f =
            new Fixture(r -> new Reply(200, "binary-data").withHeaders(Map.of("etag", "hash")));
        Client c = f.client()) {
      try (BinaryResponse response = c.storage().getObject("bucket", "key").send()) {
        assertEquals(
            "binary-data", new String(response.stream().readAllBytes(), StandardCharsets.UTF_8));
        assertEquals("hash", response.headers().firstValue("etag").orElseThrow());
      }
      try (BinaryResponse response = c.storage().headObject("bucket", "key").send()) {
        assertEquals(0, response.stream().readAllBytes().length);
        assertEquals(200, response.status());
      }
    }
  }

  @Test
  void webSocketDescriptorDoesNotConnectOrLeakToken() throws Exception {
    try (Fixture f = new Fixture(r -> imageReply("one"));
        Client c = f.client()) {
      WebSocketConnection connection = c.compute().startSerialConsole("one").prepare();
      assertEquals("ws", connection.uri().getScheme());
      assertEquals("Bearer fixture-token", connection.headers().get("Authorization"));
      assertTrue(f.requests.isEmpty());
      assertFalse(connection.toString().contains("fixture-token"));
    }
  }

  @Test
  void malformedResponsesDoNotRetainSensitiveBody() throws Exception {
    try (Fixture f = new Fixture(r -> new Reply(200, "secret-token-not-json"));
        Client c = f.client()) {
      SdkException e = assertThrows(SdkException.class, () -> c.compute().getImage("one").send());
      assertEquals(SdkException.Kind.PROTOCOL, e.kind());
      assertFalse(e.toString().contains("secret-token"));
      assertNull(e.getCause());
    }
  }

  @Test
  void nullableFieldsDistinguishAbsentAndNull() {
    var absent = Json.convert(Json.tree(Map.of()), new TypeReference<Iam.Credential>() {});
    var explicit =
        Json.convert(
            Json.parse(bytes("{\"last_used_at\":null}")), new TypeReference<Iam.Credential>() {});
    assertFalse(absent.getLastUsedAt().isPresent());
    assertTrue(explicit.getLastUsedAt().isNull());
    assertFalse(Json.tree(absent).has("last_used_at"));
    assertTrue(Json.tree(explicit).get("last_used_at").isNull());
  }

  @Test
  void environmentPrecedenceAndValidation() {
    Config config =
        Config.fromEnv(
            Map.of(
                "BASALTIC_ACCESS_TOKEN",
                "token",
                "BASALTIC_ACCESS_KEY_ID",
                "invalid:id",
                "BASALTIC_SECRET_ACCESS_KEY",
                "secret",
                "BASALTIC_ENDPOINT_URL_COMPUTE",
                "http://127.0.0.1:1234"));
    assertEquals(
        "http://127.0.0.1:1234",
        config.endpoint("compute", "https://compute.{region}.basaltic.sh"));
    for (String endpoint :
        List.of(
            "file:///tmp/test",
            "https://user:pass@example.test",
            "https://example.test?x=y",
            "https://example.test/#x"))
      assertThrows(
          SdkException.class,
          () ->
              Config.builder()
                  .credentials(Credentials.anonymous())
                  .endpoint("compute", endpoint)
                  .build());
    assertThrows(RuntimeException.class, () -> Config.builder().build());
    assertThrows(
        SdkException.class,
        () -> Config.builder().credentials(Credentials.anonymous()).maxAttempts(0).build());
    assertNotEquals(RequestOptions.newIdempotencyKey(), RequestOptions.newIdempotencyKey());
  }

  @Test
  void closedClientRejectsNewAndOutstandingCalls() throws Exception {
    try (Fixture f = new Fixture(r -> imageReply("one").delay(500))) {
      Client c = f.client();
      var call = c.compute().getImage("one");
      var future = call.sendAsync();
      c.close();
      CompletionException e = assertThrows(CompletionException.class, future::join);
      assertEquals(SdkException.Kind.CLOSED, ((SdkException) e.getCause()).kind());
      assertEquals(SdkException.Kind.CLOSED, assertThrows(SdkException.class, call::send).kind());
    }
  }
}
