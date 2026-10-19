package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Notifications.CreateTopicRequestInput;
import sh.basaltic.sdk.models.Notifications.Delivery;
import sh.basaltic.sdk.models.Notifications.DeliveryListResponse;
import sh.basaltic.sdk.models.Notifications.ListDeliveriesQuery;
import sh.basaltic.sdk.models.Notifications.ListMessagesQuery;
import sh.basaltic.sdk.models.Notifications.ListSubscriptionsQuery;
import sh.basaltic.sdk.models.Notifications.ListTopicsQuery;
import sh.basaltic.sdk.models.Notifications.Message;
import sh.basaltic.sdk.models.Notifications.MessageListResponse;
import sh.basaltic.sdk.models.Notifications.MessageResponse;
import sh.basaltic.sdk.models.Notifications.PublishBatchRequestInput;
import sh.basaltic.sdk.models.Notifications.PublishBatchResponse;
import sh.basaltic.sdk.models.Notifications.PublishRequestInput;
import sh.basaltic.sdk.models.Notifications.PublishResponse;
import sh.basaltic.sdk.models.Notifications.PutTopicPolicyRequestInput;
import sh.basaltic.sdk.models.Notifications.SigningSecretResponse;
import sh.basaltic.sdk.models.Notifications.SubscribeRequestInput;
import sh.basaltic.sdk.models.Notifications.SubscribeResponse;
import sh.basaltic.sdk.models.Notifications.Subscription;
import sh.basaltic.sdk.models.Notifications.SubscriptionListResponse;
import sh.basaltic.sdk.models.Notifications.SubscriptionResponse;
import sh.basaltic.sdk.models.Notifications.Topic;
import sh.basaltic.sdk.models.Notifications.TopicListResponse;
import sh.basaltic.sdk.models.Notifications.TopicPolicyResponse;
import sh.basaltic.sdk.models.Notifications.TopicResponse;
import sh.basaltic.sdk.models.Notifications.UpdateSubscriptionRequestInput;
import sh.basaltic.sdk.models.Notifications.UpdateTopicRequestInput;

/** Typed notifications API methods. */
public final class NotificationsService {
  private final Transport transport;

  NotificationsService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "createTopic",
          "POST",
          "/v1/topics",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "deleteTopic",
          "DELETE",
          "/v1/topics/{topic_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "deleteTopicPolicy",
          "DELETE",
          "/v1/topics/{topic_id}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "describeMessage",
          "GET",
          "/v1/topics/{topic_id}/messages/{message_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "describeSubscription",
          "GET",
          "/v1/topics/{topic_id}/subscriptions/{subscription_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "describeTopic",
          "GET",
          "/v1/topics/{topic_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "getSubscriptionSigningSecret",
          "GET",
          "/v1/topics/{topic_id}/subscriptions/{subscription_id}/signing-secret",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "getTopicPolicy",
          "GET",
          "/v1/topics/{topic_id}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "listDeliveries",
          "GET",
          "/v1/topics/{topic_id}/deliveries",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("message", new Operation.Encoding("form", true)),
              Map.entry("subscription", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "listMessages",
          "GET",
          "/v1/topics/{topic_id}/messages",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("fanout_state", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "listSubscriptions",
          "GET",
          "/v1/topics/{topic_id}/subscriptions",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "listTopics",
          "GET",
          "/v1/topics",
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
  private static final Operation OP_12 =
      new Operation(
          "publish",
          "POST",
          "/v1/topics/{topic_id}/publish",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "publishBatch",
          "POST",
          "/v1/topics/{topic_id}/publish-batch",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "putTopicPolicy",
          "PUT",
          "/v1/topics/{topic_id}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "resendConfirmation",
          "POST",
          "/v1/topics/{topic_id}/subscriptions/{subscription_id}/resend-confirmation",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "rotateSubscriptionSigningSecret",
          "POST",
          "/v1/topics/{topic_id}/subscriptions/{subscription_id}/signing-secret/rotate",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "subscribe",
          "POST",
          "/v1/topics/{topic_id}/subscriptions",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "unsubscribe",
          "DELETE",
          "/v1/topics/{topic_id}/subscriptions/{subscription_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "updateSubscription",
          "PATCH",
          "/v1/topics/{topic_id}/subscriptions/{subscription_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "updateTopic",
          "PATCH",
          "/v1/topics/{topic_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Create a topic */
  public Request<TopicResponse> createTopic(CreateTopicRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<TopicResponse>() {});
  }

  /** Delete a topic */
  public EmptyRequest deleteTopic(String topic_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            null,
            null));
  }

  /** Delete the topic's resource policy */
  public EmptyRequest deleteTopicPolicy(String topic_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            null,
            null));
  }

  /** Describe a published notification */
  public Request<MessageResponse> describeMessage(String topic_id, String message_id) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("topic_id", topic_id), Map.entry("message_id", message_id)),
            null,
            null),
        new TypeReference<MessageResponse>() {});
  }

  /** Describe a subscription */
  public Request<SubscriptionResponse> describeSubscription(
      String topic_id, String subscription_id) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(
                Map.entry("topic_id", topic_id), Map.entry("subscription_id", subscription_id)),
            null,
            null),
        new TypeReference<SubscriptionResponse>() {});
  }

  /** Describe a topic */
  public Request<TopicResponse> describeTopic(String topic_id) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            null,
            null),
        new TypeReference<TopicResponse>() {});
  }

  /** Read the webhook signing secret */
  public Request<SigningSecretResponse> getSubscriptionSigningSecret(
      String topic_id, String subscription_id) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(
                Map.entry("topic_id", topic_id), Map.entry("subscription_id", subscription_id)),
            null,
            null),
        new TypeReference<SigningSecretResponse>() {});
  }

  /** Read the topic's resource policy */
  public Request<TopicPolicyResponse> getTopicPolicy(String topic_id) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            null,
            null),
        new TypeReference<TopicPolicyResponse>() {});
  }

  /** List delivery records */
  public PagedRequest<DeliveryListResponse, Delivery> listDeliveries(
      String topic_id, ListDeliveriesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            null,
            query),
        new TypeReference<DeliveryListResponse>() {},
        new TypeReference<Delivery>() {},
        "deliveries");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<DeliveryListResponse, Delivery> listDeliveries(String topic_id) {
    return listDeliveries(topic_id, null);
  }

  /** List messages */
  public PagedRequest<MessageListResponse, Message> listMessages(
      String topic_id, ListMessagesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            null,
            query),
        new TypeReference<MessageListResponse>() {},
        new TypeReference<Message>() {},
        "messages");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<MessageListResponse, Message> listMessages(String topic_id) {
    return listMessages(topic_id, null);
  }

  /** List subscriptions */
  public PagedRequest<SubscriptionListResponse, Subscription> listSubscriptions(
      String topic_id, ListSubscriptionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            null,
            query),
        new TypeReference<SubscriptionListResponse>() {},
        new TypeReference<Subscription>() {},
        "subscriptions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SubscriptionListResponse, Subscription> listSubscriptions(String topic_id) {
    return listSubscriptions(topic_id, null);
  }

  /** List topics */
  public PagedRequest<TopicListResponse, Topic> listTopics(ListTopicsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<TopicListResponse>() {},
        new TypeReference<Topic>() {},
        "topics");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<TopicListResponse, Topic> listTopics() {
    return listTopics(null);
  }

  /** Publish a notification */
  public Request<PublishResponse> publish(String topic_id, PublishRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            body,
            null),
        new TypeReference<PublishResponse>() {});
  }

  /** Publish up to 10 notifications */
  public Request<PublishBatchResponse> publishBatch(
      String topic_id, PublishBatchRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            body,
            null),
        new TypeReference<PublishBatchResponse>() {});
  }

  /** Set the topic's resource policy */
  public Request<TopicPolicyResponse> putTopicPolicy(
      String topic_id, PutTopicPolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            body,
            null),
        new TypeReference<TopicPolicyResponse>() {});
  }

  /** Re-send the confirmation handshake */
  public Request<SubscriptionResponse> resendConfirmation(String topic_id, String subscription_id) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(
                Map.entry("topic_id", topic_id), Map.entry("subscription_id", subscription_id)),
            null,
            null),
        new TypeReference<SubscriptionResponse>() {});
  }

  /** Rotate the webhook signing secret */
  public Request<SigningSecretResponse> rotateSubscriptionSigningSecret(
      String topic_id, String subscription_id) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(
                Map.entry("topic_id", topic_id), Map.entry("subscription_id", subscription_id)),
            null,
            null),
        new TypeReference<SigningSecretResponse>() {});
  }

  /** Subscribe an endpoint to a topic */
  public Request<SubscribeResponse> subscribe(String topic_id, SubscribeRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            body,
            null),
        new TypeReference<SubscribeResponse>() {});
  }

  /** Unsubscribe */
  public EmptyRequest unsubscribe(String topic_id, String subscription_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(
                Map.entry("topic_id", topic_id), Map.entry("subscription_id", subscription_id)),
            null,
            null));
  }

  /** Update mutable subscription settings */
  public Request<SubscriptionResponse> updateSubscription(
      String topic_id, String subscription_id, UpdateSubscriptionRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(
                Map.entry("topic_id", topic_id), Map.entry("subscription_id", subscription_id)),
            body,
            null),
        new TypeReference<SubscriptionResponse>() {});
  }

  /** Update mutable topic metadata */
  public Request<TopicResponse> updateTopic(String topic_id, UpdateTopicRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "notifications",
            "https://notifications.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(Map.entry("topic_id", topic_id)),
            body,
            null),
        new TypeReference<TopicResponse>() {});
  }
}
