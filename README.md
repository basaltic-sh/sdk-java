# Basaltic Java SDK

Typed Java 17+ client for the Basaltic Cloud API: 15 services and 401 operations.
Uses the JDK HTTP client and Jackson. Synchronous calls, asynchronous calls and
backpressure-aware pagination share the same request builders and models.

Maven coordinates: `sh.basaltic:sdk-java:0.1.0`.

```xml
<dependency>
  <groupId>sh.basaltic</groupId>
  <artifactId>sdk-java</artifactId>
  <version>0.1.0</version>
</dependency>
```

Gradle:

```kotlin
implementation("sh.basaltic:sdk-java:0.1.0")
```

You can also build and install a source checkout with `mvn -B -ntp install`.

## Getting started

Set `BASALTIC_ACCESS_TOKEN`, or both `BASALTIC_ACCESS_KEY_ID` and
`BASALTIC_SECRET_ACCESS_KEY`. Regional services also need `BASALTIC_REGION`.
`BASALTIC_ACCOUNT_ID` selects the account when required by the operation.

```java
import sh.basaltic.sdk.Client;
import sh.basaltic.sdk.models.Compute;

public class ListImagesExample {
  public static void main(String[] args) {
    try (Client client = Client.fromEnv()) {
      var query = new Compute.ListImagesQuery().withLimit(50L);
      for (Compute.Image image : client.compute().listImages(query).items()) {
        System.out.println(image.getId() + " " + image.getName());
      }
    }
  }
}
```

Configuration is explicit unless you call `Config.fromEnv()` or `Client.fromEnv()`.
`Config.builder()` accepts credentials, region, account ID, API domain, per-service
endpoints, OAuth token URL, timeout and retry settings. Environment endpoint overrides
use `BASALTIC_ENDPOINT_URL_<SERVICE>`; `BASALTIC_DOMAIN` changes the API domain.
No credentials are read from the environment by an explicitly configured client.
Use `Credentials.anonymous()` explicitly for an unauthenticated endpoint.

## Asynchronous calls and per-request settings

```java
import java.time.Duration;
import sh.basaltic.sdk.Client;
import sh.basaltic.sdk.RequestOptions;

public class AsyncExample {
  public static void main(String[] args) {
    try (Client client = Client.fromEnv()) {
      var options = RequestOptions.builder()
          .timeout(Duration.ofSeconds(10))
          .maxAttempts(2)
          .build();
      client.compute().getImage("00000000-0000-4000-8000-000000000000")
          .options(options)
          .sendAsync()
          .thenAccept(response -> System.out.println(response.data().getImage().getId()))
          .join();
    }
  }
}
```

The client is thread-safe. Build mutable input models before sharing requests;
request builders capture JSON inputs when constructed and are immutable afterward.
Every `send()` or `sendAsync()` executes a new call. Cancel the future returned by
`sendAsync()` to cancel that call. Cancelling a derived future created with standard
`thenApply` or `thenAccept` does not automatically cancel its parent. Closing the
client cancels outstanding calls and stops its timer. Already returned binary streams
belong to the caller and must be closed separately.

`ApiResponse<T>` contains the API's actual typed response envelope, HTTP status,
headers and request ID. `ApiException` exposes status, API code, message, operation,
headers and request ID. `SdkException.kind()` distinguishes configuration, authentication,
transport, timeout, protocol and ambiguous-reference failures. Async failures are
available through the future; `join()` wraps them in `CompletionException`.

## Models and pagination

Models are grouped under `sh.basaltic.sdk.models.<Service>`. Request models use fluent
`with...` methods; responses use typed `get...` accessors. Required request properties
are checked before network IO. Unknown response fields are ignored and unknown string
enum values are retained by their `value()` accessor. Union models expose typed
`ofVariant...` factories and `asVariant...` views, plus a defensive `json()` copy for
unknown future variants. Date/time and base64 fields retain their wire strings;
decimal numbers use `BigDecimal`.

Nullable properties use `JsonField<T>`: `missing()` omits the property, `nullValue()`
sends explicit JSON null, and `of(value)` sends a value. `isPresent()` and `isNull()`
preserve that distinction in responses. Nonnullable optional properties use Java null
to mean omitted. Models and response wrappers redact their contents from `toString()`.

List methods return `PagedRequest<T, I>`:

- `send()` and `sendAsync()` return one `Page<T, I>` with its typed envelope and items.
- `pages()` and `items()` fetch lazily, one page at a time.
- `pagesAsync()` is a cold `Flow.Publisher<Page<T, I>>`: each subscription starts independently,
  honors requested demand, performs at most one request at a time, and supports cancellation.

Pagination rejects missing or repeated continuation markers. Resource helpers named
`get...ByReference` resolve UUIDs directly and CRNs or names through scoped list calls;
missing results produce HTTP-style 404 errors and ambiguous names fail explicitly.
Pass the generated scope model when an account or workspace filter is needed.

## Authentication, retries and transfers

Access keys use the IAM client-credentials exchange, with a shared cached token and
single concurrent refresh. Refresh occurs before expiry or once after a 401 response.
`Credentials.provider(TokenProvider)` supports a custom asynchronous token provider.
Provider implementations own their caching and receive rejected tokens through `invalidate`.
Credential values and token-exchange response bodies are excluded from diagnostics.

Defaults are a 30-second timeout per HTTP attempt and up to four attempts. Retries use
jittered exponential backoff for transport failures, timeouts, 429 and selected 5xx
responses. Automatic retries require GET, HEAD, OPTIONS, PUT or DELETE, or an explicit
idempotency key. Use `RequestOptions.newIdempotencyKey()` and keep the same key for the
same logical mutation. A Retry-After exceeding the configured maximum delay returns
the error without retrying early. Redirects, ambient proxies and cookies are disabled.

`BinaryBody.bytes(...)` is replayable; `BinaryBody.stream(...)` is one-shot and is
never retried, including after 401. Downloads return an `AutoCloseable` `BinaryResponse`
with an `InputStream`. Always consume or close it. The request timeout covers receipt
of streaming response headers; manage stream consumption timeouts in your application.
Buffered JSON responses are limited to 32 MiB, and errors and OAuth responses to 1 MiB.
WebSocket methods prepare authenticated `WebSocketConnection` descriptors without
opening a connection; use `prepare()` or `prepareAsync()` with your chosen WebSocket client.

Custom request headers support features such as `If-Match`, but cannot replace
SDK-managed authentication, routing, content or idempotency headers.

## Reference and checks

See the [complete operation reference](https://github.com/basaltic-sh/sdk-java/blob/main/docs/api.md)
and [Basaltic documentation](https://docs.basaltic.sh).
Public checks cover Java 17, 21 and 25, compilation with warnings denied, formatting,
runtime tests, Javadoc, archive contents, source-JAR correspondence, README compilation
and a separate consumer using the built JAR. Formatting uses a checksum-pinned
official native formatter on Linux, Windows x64 and Apple Silicon. Other platforms
need JDK 21+ for formatting (set `FORMAT_JAVA_HOME`), while the SDK still targets Java 17. Run `python3 scripts/check.py` followed by
`python3 scripts/check_package.py` with Java, Maven and Python 3 installed.

This repository contains official release snapshots for reference and use. Development
is private; pull requests and code contributions are not accepted. Security reports go
to [security@basaltic.sh](mailto:security@basaltic.sh); see
[SECURITY.md](https://github.com/basaltic-sh/sdk-java/blob/main/SECURITY.md).

Licensed under Apache-2.0.
