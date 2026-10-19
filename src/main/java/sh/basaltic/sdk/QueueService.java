package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Queue.BatchResponse;
import sh.basaltic.sdk.models.Queue.ChangeVisibilityBatchRequestInput;
import sh.basaltic.sdk.models.Queue.ChangeVisibilityRequestInput;
import sh.basaltic.sdk.models.Queue.CreateQueueRequestInput;
import sh.basaltic.sdk.models.Queue.DeleteMessageBatchRequestInput;
import sh.basaltic.sdk.models.Queue.DeleteMessageQuery;
import sh.basaltic.sdk.models.Queue.ListQueuesQuery;
import sh.basaltic.sdk.models.Queue.PeekMessagesQuery;
import sh.basaltic.sdk.models.Queue.PeekResponse;
import sh.basaltic.sdk.models.Queue.PurgeQueueResponse;
import sh.basaltic.sdk.models.Queue.Queue2;
import sh.basaltic.sdk.models.Queue.QueueListResponse;
import sh.basaltic.sdk.models.Queue.QueueResponse;
import sh.basaltic.sdk.models.Queue.ReceiveRequestInput;
import sh.basaltic.sdk.models.Queue.ReceiveResponse;
import sh.basaltic.sdk.models.Queue.SendMessageBatchRequestInput;
import sh.basaltic.sdk.models.Queue.SendMessageRequestInput;
import sh.basaltic.sdk.models.Queue.SendMessageResponse;
import sh.basaltic.sdk.models.Queue.UpdateQueueRequestInput;

/** Typed queue API methods. */
public final class QueueService {
  private final Transport transport;

  QueueService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "changeMessageVisibility",
          "POST",
          "/v1/queues/{queue_id}/messages/visibility",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "changeMessageVisibilityBatch",
          "POST",
          "/v1/queues/{queue_id}/messages/visibility-batch",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "createQueue",
          "POST",
          "/v1/queues",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "deleteMessage",
          "DELETE",
          "/v1/queues/{queue_id}/messages",
          true,
          List.of("receipt_handle"),
          List.of(),
          Map.ofEntries(Map.entry("receipt_handle", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "deleteMessageBatch",
          "POST",
          "/v1/queues/{queue_id}/messages/delete-batch",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "deleteQueue",
          "DELETE",
          "/v1/queues/{queue_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "describeQueue",
          "GET",
          "/v1/queues/{queue_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "listQueues",
          "GET",
          "/v1/queues",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "peekMessages",
          "GET",
          "/v1/queues/{queue_id}/messages",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("visibility", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "purgeQueue",
          "POST",
          "/v1/queues/{queue_id}/purge",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "receiveMessages",
          "POST",
          "/v1/queues/{queue_id}/messages/receive",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "sendMessage",
          "POST",
          "/v1/queues/{queue_id}/messages",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "sendMessageBatch",
          "POST",
          "/v1/queues/{queue_id}/messages/batch",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "updateQueue",
          "PATCH",
          "/v1/queues/{queue_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Extend or shorten a lease */
  public EmptyRequest changeMessageVisibility(String queue_id, ChangeVisibilityRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            body,
            null));
  }

  /** Extend or shorten up to ten leases */
  public Request<BatchResponse> changeMessageVisibilityBatch(
      String queue_id, ChangeVisibilityBatchRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            body,
            null),
        new TypeReference<BatchResponse>() {});
  }

  /** Create a queue */
  public Request<QueueResponse> createQueue(CreateQueueRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<QueueResponse>() {});
  }

  /** Delete a leased message */
  public EmptyRequest deleteMessage(String queue_id, DeleteMessageQuery query) {
    return new EmptyRequest(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            null,
            query));
  }

  /** Delete up to ten leased messages */
  public Request<BatchResponse> deleteMessageBatch(
      String queue_id, DeleteMessageBatchRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            body,
            null),
        new TypeReference<BatchResponse>() {});
  }

  /** Delete a queue */
  public EmptyRequest deleteQueue(String queue_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            null,
            null));
  }

  /** Describe a queue */
  public Request<QueueResponse> describeQueue(String queue_id) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            null,
            null),
        new TypeReference<QueueResponse>() {});
  }

  /** List queues */
  public PagedRequest<QueueListResponse, Queue2> listQueues(ListQueuesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<QueueListResponse>() {},
        new TypeReference<Queue2>() {},
        "queues");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<QueueListResponse, Queue2> listQueues() {
    return listQueues(null);
  }

  /** Peek at a queue's messages */
  public Request<PeekResponse> peekMessages(String queue_id, PeekMessagesQuery query) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            null,
            query),
        new TypeReference<PeekResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<PeekResponse> peekMessages(String queue_id) {
    return peekMessages(queue_id, null);
  }

  /** Delete every message on a queue */
  public Request<PurgeQueueResponse> purgeQueue(String queue_id) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            null,
            null),
        new TypeReference<PurgeQueueResponse>() {});
  }

  /** Lease messages */
  public Request<ReceiveResponse> receiveMessages(String queue_id, ReceiveRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            body,
            null),
        new TypeReference<ReceiveResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<ReceiveResponse> receiveMessages(String queue_id) {
    return receiveMessages(queue_id, null);
  }

  /** Send a message */
  public Request<SendMessageResponse> sendMessage(String queue_id, SendMessageRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            body,
            null),
        new TypeReference<SendMessageResponse>() {});
  }

  /** Send up to ten messages */
  public Request<BatchResponse> sendMessageBatch(
      String queue_id, SendMessageBatchRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            body,
            null),
        new TypeReference<BatchResponse>() {});
  }

  /** Update queue attributes */
  public Request<QueueResponse> updateQueue(String queue_id, UpdateQueueRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "queue",
            "https://queue.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("queue_id", queue_id)),
            body,
            null),
        new TypeReference<QueueResponse>() {});
  }
}
