package sh.basaltic.sdk;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

final class Async {
  private Async() {}

  static Throwable unwrap(Throwable error) {
    while ((error instanceof CompletionException || error instanceof ExecutionException)
        && error.getCause() != null) error = error.getCause();
    return error;
  }

  static <T, U> CompletableFuture<U> map(CompletableFuture<T> source, Function<T, U> fn) {
    CompletableFuture<U> result = new CompletableFuture<>();
    result.whenComplete(
        (v, e) -> {
          if (result.isCancelled()) source.cancel(true);
        });
    source.whenComplete(
        (value, error) -> {
          if (error != null) {
            result.completeExceptionally(unwrap(error));
            return;
          }
          try {
            U mapped = fn.apply(value);
            if (!result.complete(mapped) && mapped instanceof AutoCloseable closeable)
              closeable.close();
          } catch (Exception e) {
            result.completeExceptionally(e);
          }
        });
    return result;
  }

  static <T> T await(CompletableFuture<T> future) {
    try {
      return future.get();
    } catch (InterruptedException e) {
      future.cancel(true);
      Thread.currentThread().interrupt();
      throw new CancellationException("Request interrupted");
    } catch (ExecutionException e) {
      Throwable cause = unwrap(e);
      if (cause instanceof RuntimeException runtime) throw runtime;
      throw new SdkException(SdkException.Kind.TRANSPORT, "Request failed");
    }
  }
}
