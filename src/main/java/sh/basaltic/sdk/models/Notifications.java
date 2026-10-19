package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed notifications wire models. Unknown string enum values are retained. */
public final class Notifications {

  private Notifications() {}

  public static final class CreateTopicRequestInput extends Model {
    public CreateTopicRequestInput() {}

    /**
     * 1-256 characters of letters, digits, dot, dash, or underscore. Resource names must not start
     * with the literal crn: prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in
     * either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateTopicRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "display_name", required = false)
    private String display_name;

    @JsonProperty("display_name")
    public String getDisplayName() {
      return display_name;
    }

    public CreateTopicRequestInput withDisplayName(String value) {
      this.display_name = value;
      return this;
    }

    @JsonProperty(value = "delivery_policy", required = false)
    private DeliveryPolicyInput delivery_policy;

    @JsonProperty("delivery_policy")
    public DeliveryPolicyInput getDeliveryPolicy() {
      return delivery_policy;
    }

    public CreateTopicRequestInput withDeliveryPolicy(DeliveryPolicyInput value) {
      this.delivery_policy = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateTopicRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class DeliveryPolicyInput extends Model {
    public DeliveryPolicyInput() {}

    /** Total attempts including the first. 1 disables retries. */
    @JsonProperty(value = "max_attempts", required = false)
    private Long max_attempts;

    @JsonProperty("max_attempts")
    public Long getMaxAttempts() {
      return max_attempts;
    }

    public DeliveryPolicyInput withMaxAttempts(Long value) {
      this.max_attempts = value;
      return this;
    }

    /** Backoff before the second attempt. */
    @JsonProperty(value = "min_delay_seconds", required = false)
    private Long min_delay_seconds;

    @JsonProperty("min_delay_seconds")
    public Long getMinDelaySeconds() {
      return min_delay_seconds;
    }

    public DeliveryPolicyInput withMinDelaySeconds(Long value) {
      this.min_delay_seconds = value;
      return this;
    }

    /** Cap on the exponential curve. */
    @JsonProperty(value = "max_delay_seconds", required = false)
    private Long max_delay_seconds;

    @JsonProperty("max_delay_seconds")
    public Long getMaxDelaySeconds() {
      return max_delay_seconds;
    }

    public DeliveryPolicyInput withMaxDelaySeconds(Long value) {
      this.max_delay_seconds = value;
      return this;
    }

    /** Per-request timeout. Ignored for email. */
    @JsonProperty(value = "timeout_seconds", required = false)
    private Long timeout_seconds;

    @JsonProperty("timeout_seconds")
    public Long getTimeoutSeconds() {
      return timeout_seconds;
    }

    public DeliveryPolicyInput withTimeoutSeconds(Long value) {
      this.timeout_seconds = value;
      return this;
    }
  }

  public static final class TopicResponse extends Model {
    public TopicResponse() {}

    @JsonProperty(value = "topic", required = true)
    private Topic topic;

    @JsonProperty("topic")
    public Topic getTopic() {
      return topic;
    }
  }

  public static final class Topic extends Model {
    public Topic() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Unique within the calling account. Immutable. Resource names must not start with the literal
     * crn: prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /** Human-facing label; used as the email subject when a notification carries none. */
    @JsonProperty(value = "display_name", required = false)
    private String display_name;

    @JsonProperty("display_name")
    public String getDisplayName() {
      return display_name;
    }

    @JsonProperty(value = "delivery_policy", required = false)
    private DeliveryPolicy delivery_policy;

    @JsonProperty("delivery_policy")
    public DeliveryPolicy getDeliveryPolicy() {
      return delivery_policy;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class DeliveryPolicy extends Model {
    public DeliveryPolicy() {}

    /** Total attempts including the first. 1 disables retries. */
    @JsonProperty(value = "max_attempts", required = false)
    private Long max_attempts;

    @JsonProperty("max_attempts")
    public Long getMaxAttempts() {
      return max_attempts;
    }

    /** Backoff before the second attempt. */
    @JsonProperty(value = "min_delay_seconds", required = false)
    private Long min_delay_seconds;

    @JsonProperty("min_delay_seconds")
    public Long getMinDelaySeconds() {
      return min_delay_seconds;
    }

    /** Cap on the exponential curve. */
    @JsonProperty(value = "max_delay_seconds", required = false)
    private Long max_delay_seconds;

    @JsonProperty("max_delay_seconds")
    public Long getMaxDelaySeconds() {
      return max_delay_seconds;
    }

    /** Per-request timeout. Ignored for email. */
    @JsonProperty(value = "timeout_seconds", required = false)
    private Long timeout_seconds;

    @JsonProperty("timeout_seconds")
    public Long getTimeoutSeconds() {
      return timeout_seconds;
    }
  }

  public static final class MessageResponse extends Model {
    public MessageResponse() {}

    @JsonProperty(value = "message", required = true)
    private Message message;

    @JsonProperty("message")
    public Message getMessage() {
      return message;
    }
  }

  public static final class Message extends Model {
    public Message() {}

    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    @JsonProperty(value = "message_structure", required = false)
    private MessageMessageStructure message_structure;

    @JsonProperty("message_structure")
    public MessageMessageStructure getMessageStructure() {
      return message_structure;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, MessageAttributesValue> attributes;

    @JsonProperty("attributes")
    public Map<String, MessageAttributesValue> getAttributes() {
      return attributes;
    }

    /** `pending` until the worker has expanded the message into deliveries. */
    @JsonProperty(value = "fanout_state", required = true)
    private MessageFanoutState fanout_state;

    @JsonProperty("fanout_state")
    public MessageFanoutState getFanoutState() {
      return fanout_state;
    }

    /** Deliveries fan-out produced. Meaningful only once fanout_state is complete. */
    @JsonProperty(value = "delivery_count", required = true)
    private Long delivery_count;

    @JsonProperty("delivery_count")
    public Long getDeliveryCount() {
      return delivery_count;
    }

    @JsonProperty(value = "published_at", required = true)
    private String published_at;

    @JsonProperty("published_at")
    public String getPublishedAt() {
      return published_at;
    }

    @JsonProperty(value = "fanned_out_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> fanned_out_at = JsonField.missing();

    @JsonProperty("fanned_out_at")
    public JsonField<String> getFannedOutAt() {
      return fanned_out_at;
    }
  }

  public static final class MessageMessageStructure {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public MessageMessageStructure(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof MessageMessageStructure v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final MessageMessageStructure VALUE = new MessageMessageStructure("");
    public static final MessageMessageStructure JSON = new MessageMessageStructure("json");
  }

  public static final class MessageAttributesValue extends Model {
    public MessageAttributesValue() {}

    @JsonProperty(value = "type", required = true)
    private MessageAttributesValueType type;

    @JsonProperty("type")
    public MessageAttributesValueType getType() {
      return type;
    }

    @JsonProperty(value = "value", required = true)
    private String value;

    @JsonProperty("value")
    public String getValue() {
      return value;
    }
  }

  public static final class MessageAttributesValueType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public MessageAttributesValueType(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof MessageAttributesValueType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final MessageAttributesValueType STRING =
        new MessageAttributesValueType("String");
    public static final MessageAttributesValueType NUMBER =
        new MessageAttributesValueType("Number");
  }

  public static final class MessageFanoutState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public MessageFanoutState(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof MessageFanoutState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final MessageFanoutState PENDING = new MessageFanoutState("pending");
    public static final MessageFanoutState COMPLETE = new MessageFanoutState("complete");
  }

  public static final class SubscriptionResponse extends Model {
    public SubscriptionResponse() {}

    @JsonProperty(value = "subscription", required = true)
    private Subscription subscription;

    @JsonProperty("subscription")
    public Subscription getSubscription() {
      return subscription;
    }
  }

  public static final class Subscription extends Model {
    public Subscription() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * Nested under the actual topic name and owner account, including cross-account subscriptions.
     */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "protocol", required = true)
    private SubscriptionProtocol protocol;

    @JsonProperty("protocol")
    public SubscriptionProtocol getProtocol() {
      return protocol;
    }

    /**
     * Immutable. An email address, an http/https URL, or a canonical queue CRN when protocol is
     * queue.
     */
    @JsonProperty(value = "endpoint", required = true)
    private String endpoint;

    @JsonProperty("endpoint")
    public String getEndpoint() {
      return endpoint;
    }

    @JsonProperty(value = "status", required = true)
    private SubscriptionStatus status;

    @JsonProperty("status")
    public SubscriptionStatus getStatus() {
      return status;
    }

    /**
     * http/https only. Deliver the published payload verbatim instead of the notification envelope;
     * the metadata moves into headers.
     */
    @JsonProperty(value = "raw_message_delivery", required = true)
    private Boolean raw_message_delivery;

    @JsonProperty("raw_message_delivery")
    public Boolean getRawMessageDelivery() {
      return raw_message_delivery;
    }

    @JsonProperty(value = "filter_policy", required = false)
    private Map<String, List<JsonNode>> filter_policy;

    @JsonProperty("filter_policy")
    public Map<String, List<JsonNode>> getFilterPolicy() {
      return filter_policy;
    }

    @JsonProperty(value = "delivery_policy", required = false)
    private DeliveryPolicy delivery_policy;

    @JsonProperty("delivery_policy")
    public DeliveryPolicy getDeliveryPolicy() {
      return delivery_policy;
    }

    @JsonProperty(value = "redrive_policy", required = false)
    private RedrivePolicy redrive_policy;

    @JsonProperty("redrive_policy")
    public RedrivePolicy getRedrivePolicy() {
      return redrive_policy;
    }

    /** When the pending confirmation lapses. Absent once confirmed. */
    @JsonProperty(value = "confirmation_expires_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> confirmation_expires_at = JsonField.missing();

    @JsonProperty("confirmation_expires_at")
    public JsonField<String> getConfirmationExpiresAt() {
      return confirmation_expires_at;
    }

    @JsonProperty(value = "confirmed_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> confirmed_at = JsonField.missing();

    @JsonProperty("confirmed_at")
    public JsonField<String> getConfirmedAt() {
      return confirmed_at;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class SubscriptionProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SubscriptionProtocol(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof SubscriptionProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SubscriptionProtocol EMAIL = new SubscriptionProtocol("email");
    public static final SubscriptionProtocol HTTPS = new SubscriptionProtocol("https");
    public static final SubscriptionProtocol HTTP = new SubscriptionProtocol("http");
    public static final SubscriptionProtocol QUEUE = new SubscriptionProtocol("queue");
  }

  public static final class SubscriptionStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SubscriptionStatus(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof SubscriptionStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SubscriptionStatus PENDING_CONFIRMATION =
        new SubscriptionStatus("pending_confirmation");
    public static final SubscriptionStatus CONFIRMED = new SubscriptionStatus("confirmed");
  }

  public static final class RedrivePolicy extends Model {
    public RedrivePolicy() {}

    /** The bound queue. A deleted target retains its stored ID and CRN without a name. */
    @JsonProperty(value = "dead_letter_queue", required = true)
    private ResourceRef dead_letter_queue;

    @JsonProperty("dead_letter_queue")
    public ResourceRef getDeadLetterQueue() {
      return dead_letter_queue;
    }
  }

  public static final class ResourceRef extends Model {
    public ResourceRef() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Display label at response time — the resource's name where it has one, otherwise its human
     * label (an invoice number, an account display name). Absent when the target is gone. Not a
     * lookup key.
     */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }
  }

  public static final class SigningSecretResponse extends Model {
    public SigningSecretResponse() {}

    @JsonProperty(value = "subscription", required = true)
    private ResourceRef subscription;

    @JsonProperty("subscription")
    public ResourceRef getSubscription() {
      return subscription;
    }

    @JsonProperty(value = "signing_secret", required = true)
    private String signing_secret;

    @JsonProperty("signing_secret")
    public String getSigningSecret() {
      return signing_secret;
    }
  }

  public static final class TopicPolicyResponse extends Model {
    public TopicPolicyResponse() {}

    @JsonProperty(value = "document", required = true)
    private Map<String, JsonNode> document;

    @JsonProperty("document")
    public Map<String, JsonNode> getDocument() {
      return document;
    }
  }

  public static final class ListDeliveriesQuery extends Model {
    public ListDeliveriesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListDeliveriesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "message", required = false)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    public ListDeliveriesQuery withMessage(String value) {
      this.message = value;
      return this;
    }

    @JsonProperty(value = "subscription", required = false)
    private String subscription;

    @JsonProperty("subscription")
    public String getSubscription() {
      return subscription;
    }

    public ListDeliveriesQuery withSubscription(String value) {
      this.subscription = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private ListDeliveriesQueryStatus status;

    @JsonProperty("status")
    public ListDeliveriesQueryStatus getStatus() {
      return status;
    }

    public ListDeliveriesQuery withStatus(ListDeliveriesQueryStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListDeliveriesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListDeliveriesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListDeliveriesQueryStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListDeliveriesQueryStatus(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof ListDeliveriesQueryStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListDeliveriesQueryStatus PENDING =
        new ListDeliveriesQueryStatus("pending");
    public static final ListDeliveriesQueryStatus DELIVERED =
        new ListDeliveriesQueryStatus("delivered");
    public static final ListDeliveriesQueryStatus FAILED = new ListDeliveriesQueryStatus("failed");
  }

  public static final class DeliveryListResponse extends Model {
    public DeliveryListResponse() {}

    @JsonProperty(value = "deliveries", required = true)
    private List<Delivery> deliveries;

    @JsonProperty("deliveries")
    public List<Delivery> getDeliveries() {
      return deliveries;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Delivery extends Model {
    public Delivery() {}

    /** Canonical message/UUID/delivery/UUID CRN. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "message", required = true)
    private ResourceRef message;

    @JsonProperty("message")
    public ResourceRef getMessage() {
      return message;
    }

    @JsonProperty(value = "subscription", required = true)
    private ResourceRef subscription;

    @JsonProperty("subscription")
    public ResourceRef getSubscription() {
      return subscription;
    }

    @JsonProperty(value = "protocol", required = true)
    private DeliveryProtocol protocol;

    @JsonProperty("protocol")
    public DeliveryProtocol getProtocol() {
      return protocol;
    }

    /** Endpoint recorded at fan-out. */
    @JsonProperty(value = "endpoint", required = true)
    private String endpoint;

    @JsonProperty("endpoint")
    public String getEndpoint() {
      return endpoint;
    }

    @JsonProperty(value = "status", required = true)
    private DeliveryStatus status;

    @JsonProperty("status")
    public DeliveryStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "attempts", required = true)
    private Long attempts;

    @JsonProperty("attempts")
    public Long getAttempts() {
      return attempts;
    }

    /**
     * HTTP status of the last attempt. Absent for a transport-level failure or an email delivery.
     */
    @JsonProperty(value = "last_status_code", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> last_status_code = JsonField.missing();

    @JsonProperty("last_status_code")
    public JsonField<Long> getLastStatusCode() {
      return last_status_code;
    }

    /** Truncated to 1024 characters. */
    @JsonProperty(value = "last_error", required = false)
    private String last_error;

    @JsonProperty("last_error")
    public String getLastError() {
      return last_error;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "last_attempt_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_attempt_at = JsonField.missing();

    @JsonProperty("last_attempt_at")
    public JsonField<String> getLastAttemptAt() {
      return last_attempt_at;
    }

    @JsonProperty(value = "completed_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> completed_at = JsonField.missing();

    @JsonProperty("completed_at")
    public JsonField<String> getCompletedAt() {
      return completed_at;
    }
  }

  public static final class DeliveryProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DeliveryProtocol(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof DeliveryProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final DeliveryProtocol EMAIL = new DeliveryProtocol("email");
    public static final DeliveryProtocol HTTPS = new DeliveryProtocol("https");
    public static final DeliveryProtocol HTTP = new DeliveryProtocol("http");
    public static final DeliveryProtocol QUEUE = new DeliveryProtocol("queue");
  }

  public static final class DeliveryStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DeliveryStatus(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof DeliveryStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final DeliveryStatus PENDING = new DeliveryStatus("pending");
    public static final DeliveryStatus DELIVERED = new DeliveryStatus("delivered");
    public static final DeliveryStatus FAILED = new DeliveryStatus("failed");
  }

  public static final class PaginationMeta extends Model {
    public PaginationMeta() {}

    /** Total number of items */
    @JsonProperty(value = "total", required = false)
    private Long total;

    @JsonProperty("total")
    public Long getTotal() {
      return total;
    }

    /** Number of items per page */
    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    /**
     * Opaque cursor for the next page. Pass it back as the `marker` query parameter; treat it as a
     * token, not a value to parse.
     */
    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    /** Whether there are more items */
    @JsonProperty(value = "has_more", required = false)
    private Boolean has_more;

    @JsonProperty("has_more")
    public Boolean getHasMore() {
      return has_more;
    }
  }

  public static final class ListMessagesQuery extends Model {
    public ListMessagesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListMessagesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "fanout_state", required = false)
    private ListMessagesQueryFanoutState fanout_state;

    @JsonProperty("fanout_state")
    public ListMessagesQueryFanoutState getFanoutState() {
      return fanout_state;
    }

    public ListMessagesQuery withFanoutState(ListMessagesQueryFanoutState value) {
      this.fanout_state = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListMessagesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListMessagesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListMessagesQueryFanoutState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListMessagesQueryFanoutState(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof ListMessagesQueryFanoutState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListMessagesQueryFanoutState PENDING =
        new ListMessagesQueryFanoutState("pending");
    public static final ListMessagesQueryFanoutState COMPLETE =
        new ListMessagesQueryFanoutState("complete");
  }

  public static final class MessageListResponse extends Model {
    public MessageListResponse() {}

    @JsonProperty(value = "messages", required = true)
    private List<Message> messages;

    @JsonProperty("messages")
    public List<Message> getMessages() {
      return messages;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListSubscriptionsQuery extends Model {
    public ListSubscriptionsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSubscriptionsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private ListSubscriptionsQueryStatus status;

    @JsonProperty("status")
    public ListSubscriptionsQueryStatus getStatus() {
      return status;
    }

    public ListSubscriptionsQuery withStatus(ListSubscriptionsQueryStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSubscriptionsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSubscriptionsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListSubscriptionsQueryStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListSubscriptionsQueryStatus(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof ListSubscriptionsQueryStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListSubscriptionsQueryStatus PENDING_CONFIRMATION =
        new ListSubscriptionsQueryStatus("pending_confirmation");
    public static final ListSubscriptionsQueryStatus CONFIRMED =
        new ListSubscriptionsQueryStatus("confirmed");
  }

  public static final class SubscriptionListResponse extends Model {
    public SubscriptionListResponse() {}

    @JsonProperty(value = "subscriptions", required = true)
    private List<Subscription> subscriptions;

    @JsonProperty("subscriptions")
    public List<Subscription> getSubscriptions() {
      return subscriptions;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListTopicsQuery extends Model {
    public ListTopicsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListTopicsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListTopicsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListTopicsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListTopicsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class TopicListResponse extends Model {
    public TopicListResponse() {}

    @JsonProperty(value = "topics", required = true)
    private List<Topic> topics;

    @JsonProperty("topics")
    public List<Topic> getTopics() {
      return topics;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class PublishRequestInput extends Model {
    public PublishRequestInput() {}

    /** Used as the email subject. No line breaks. */
    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    public PublishRequestInput withSubject(String value) {
      this.subject = value;
      return this;
    }

    /** The payload. Up to 256 KiB. */
    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    public PublishRequestInput withMessage(String value) {
      this.message = value;
      return this;
    }

    /**
     * Omit to deliver `message` verbatim to every protocol. Set to `json` to have `message` read as
     * an object of protocol keys (`default`, `email`, `https`, `http`), letting one publish carry a
     * different payload per transport. A `default` key is required — it is what a protocol with no
     * explicit entry gets.
     */
    @JsonProperty(value = "message_structure", required = false)
    private PublishRequestInputMessageStructure message_structure;

    @JsonProperty("message_structure")
    public PublishRequestInputMessageStructure getMessageStructure() {
      return message_structure;
    }

    public PublishRequestInput withMessageStructure(PublishRequestInputMessageStructure value) {
      this.message_structure = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, MessageAttributesInputValue> attributes;

    @JsonProperty("attributes")
    public Map<String, MessageAttributesInputValue> getAttributes() {
      return attributes;
    }

    public PublishRequestInput withAttributes(Map<String, MessageAttributesInputValue> value) {
      this.attributes = value;
      return this;
    }
  }

  public static final class PublishRequestInputMessageStructure {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PublishRequestInputMessageStructure(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof PublishRequestInputMessageStructure v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PublishRequestInputMessageStructure VALUE =
        new PublishRequestInputMessageStructure("");
    public static final PublishRequestInputMessageStructure JSON =
        new PublishRequestInputMessageStructure("json");
  }

  public static final class MessageAttributesInputValue extends Model {
    public MessageAttributesInputValue() {}

    @JsonProperty(value = "type", required = true)
    private MessageAttributesInputValueType type;

    @JsonProperty("type")
    public MessageAttributesInputValueType getType() {
      return type;
    }

    public MessageAttributesInputValue withType(MessageAttributesInputValueType value) {
      this.type = value;
      return this;
    }

    @JsonProperty(value = "value", required = true)
    private String value;

    @JsonProperty("value")
    public String getValue() {
      return value;
    }

    public MessageAttributesInputValue withValue(String value) {
      this.value = value;
      return this;
    }
  }

  public static final class MessageAttributesInputValueType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public MessageAttributesInputValueType(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof MessageAttributesInputValueType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final MessageAttributesInputValueType STRING =
        new MessageAttributesInputValueType("String");
    public static final MessageAttributesInputValueType NUMBER =
        new MessageAttributesInputValueType("Number");
  }

  public static final class PublishResponse extends Model {
    public PublishResponse() {}

    @JsonProperty(value = "message_id", required = true)
    private String message_id;

    @JsonProperty("message_id")
    public String getMessageId() {
      return message_id;
    }
  }

  public static final class PublishBatchRequestInput extends Model {
    public PublishBatchRequestInput() {}

    @JsonProperty(value = "entries", required = true)
    private List<PublishBatchRequestInputEntriesItem> entries;

    @JsonProperty("entries")
    public List<PublishBatchRequestInputEntriesItem> getEntries() {
      return entries;
    }

    public PublishBatchRequestInput withEntries(List<PublishBatchRequestInputEntriesItem> value) {
      this.entries = value;
      return this;
    }
  }

  public static final class PublishBatchRequestInputEntriesItem extends Model {
    public PublishBatchRequestInputEntriesItem() {}

    /** Caller-supplied correlation id, unique within the batch. Echoed back in the result. */
    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    public PublishBatchRequestInputEntriesItem withId(String value) {
      this.id = value;
      return this;
    }

    /** Used as the email subject. No line breaks. */
    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    public PublishBatchRequestInputEntriesItem withSubject(String value) {
      this.subject = value;
      return this;
    }

    /** The payload. Up to 256 KiB. */
    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    public PublishBatchRequestInputEntriesItem withMessage(String value) {
      this.message = value;
      return this;
    }

    /**
     * Omit to deliver `message` verbatim to every protocol. Set to `json` to have `message` read as
     * an object of protocol keys (`default`, `email`, `https`, `http`), letting one publish carry a
     * different payload per transport. A `default` key is required — it is what a protocol with no
     * explicit entry gets.
     */
    @JsonProperty(value = "message_structure", required = false)
    private PublishBatchRequestInputEntriesItemMessageStructure message_structure;

    @JsonProperty("message_structure")
    public PublishBatchRequestInputEntriesItemMessageStructure getMessageStructure() {
      return message_structure;
    }

    public PublishBatchRequestInputEntriesItem withMessageStructure(
        PublishBatchRequestInputEntriesItemMessageStructure value) {
      this.message_structure = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, MessageAttributesInputValue> attributes;

    @JsonProperty("attributes")
    public Map<String, MessageAttributesInputValue> getAttributes() {
      return attributes;
    }

    public PublishBatchRequestInputEntriesItem withAttributes(
        Map<String, MessageAttributesInputValue> value) {
      this.attributes = value;
      return this;
    }
  }

  public static final class PublishBatchRequestInputEntriesItemMessageStructure {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PublishBatchRequestInputEntriesItemMessageStructure(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof PublishBatchRequestInputEntriesItemMessageStructure v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PublishBatchRequestInputEntriesItemMessageStructure VALUE =
        new PublishBatchRequestInputEntriesItemMessageStructure("");
    public static final PublishBatchRequestInputEntriesItemMessageStructure JSON =
        new PublishBatchRequestInputEntriesItemMessageStructure("json");
  }

  public static final class PublishBatchResponse extends Model {
    public PublishBatchResponse() {}

    @JsonProperty(value = "successful", required = false)
    private List<PublishBatchResponseSuccessfulItem> successful;

    @JsonProperty("successful")
    public List<PublishBatchResponseSuccessfulItem> getSuccessful() {
      return successful;
    }

    @JsonProperty(value = "failed", required = false)
    private List<PublishBatchResponseFailedItem> failed;

    @JsonProperty("failed")
    public List<PublishBatchResponseFailedItem> getFailed() {
      return failed;
    }
  }

  public static final class PublishBatchResponseSuccessfulItem extends Model {
    public PublishBatchResponseSuccessfulItem() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "message_id", required = true)
    private String message_id;

    @JsonProperty("message_id")
    public String getMessageId() {
      return message_id;
    }
  }

  public static final class PublishBatchResponseFailedItem extends Model {
    public PublishBatchResponseFailedItem() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }
  }

  public static final class PutTopicPolicyRequestInput extends Model {
    public PutTopicPolicyRequestInput() {}

    @JsonProperty(value = "document", required = true)
    private Map<String, JsonNode> document;

    @JsonProperty("document")
    public Map<String, JsonNode> getDocument() {
      return document;
    }

    public PutTopicPolicyRequestInput withDocument(Map<String, JsonNode> value) {
      this.document = value;
      return this;
    }
  }

  public static final class SubscribeRequestInput extends Model {
    public SubscribeRequestInput() {}

    @JsonProperty(value = "protocol", required = true)
    private SubscribeRequestInputProtocol protocol;

    @JsonProperty("protocol")
    public SubscribeRequestInputProtocol getProtocol() {
      return protocol;
    }

    public SubscribeRequestInput withProtocol(SubscribeRequestInputProtocol value) {
      this.protocol = value;
      return this;
    }

    /**
     * An email address; an http/https URL whose scheme matches the protocol and resolves to a
     * publicly-routable address; or, for `queue`, a queue UUID, CRN or exact name in the subscriber
     * account and serving region. Queue targets are stored and returned as canonical CRNs. A
     * `queue` subscription skips the confirmation handshake and is created already confirmed. The
     * handshake exists to prove that whoever controls the endpoint consents to receive, which is
     * necessary for an address or a URL you may not own. A queue is your own resource, so consent
     * is established instead by requiring `queue:SendMessage` on it at subscribe time — an
     * authorization decision rather than a demonstration of reachability.
     */
    @JsonProperty(value = "endpoint", required = true)
    private String endpoint;

    @JsonProperty("endpoint")
    public String getEndpoint() {
      return endpoint;
    }

    public SubscribeRequestInput withEndpoint(String value) {
      this.endpoint = value;
      return this;
    }

    /** http/https only. */
    @JsonProperty(value = "raw_message_delivery", required = false)
    private Boolean raw_message_delivery;

    @JsonProperty("raw_message_delivery")
    public Boolean getRawMessageDelivery() {
      return raw_message_delivery;
    }

    public SubscribeRequestInput withRawMessageDelivery(Boolean value) {
      this.raw_message_delivery = value;
      return this;
    }

    @JsonProperty(value = "filter_policy", required = false)
    private Map<String, List<JsonNode>> filter_policy;

    @JsonProperty("filter_policy")
    public Map<String, List<JsonNode>> getFilterPolicy() {
      return filter_policy;
    }

    public SubscribeRequestInput withFilterPolicy(Map<String, List<JsonNode>> value) {
      this.filter_policy = value;
      return this;
    }

    @JsonProperty(value = "delivery_policy", required = false)
    private DeliveryPolicyInput delivery_policy;

    @JsonProperty("delivery_policy")
    public DeliveryPolicyInput getDeliveryPolicy() {
      return delivery_policy;
    }

    public SubscribeRequestInput withDeliveryPolicy(DeliveryPolicyInput value) {
      this.delivery_policy = value;
      return this;
    }

    @JsonProperty(value = "redrive_policy", required = false)
    private RedrivePolicyInputInput redrive_policy;

    @JsonProperty("redrive_policy")
    public RedrivePolicyInputInput getRedrivePolicy() {
      return redrive_policy;
    }

    public SubscribeRequestInput withRedrivePolicy(RedrivePolicyInputInput value) {
      this.redrive_policy = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SubscribeRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SubscribeRequestInputProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SubscribeRequestInputProtocol(String value) {
      this.value = Objects.requireNonNull(value);
    }

    @JsonValue
    public String value() {
      return value;
    }

    @Override
    public String toString() {
      return value;
    }

    @Override
    public boolean equals(Object other) {
      return other instanceof SubscribeRequestInputProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SubscribeRequestInputProtocol EMAIL =
        new SubscribeRequestInputProtocol("email");
    public static final SubscribeRequestInputProtocol HTTPS =
        new SubscribeRequestInputProtocol("https");
    public static final SubscribeRequestInputProtocol HTTP =
        new SubscribeRequestInputProtocol("http");
    public static final SubscribeRequestInputProtocol QUEUE =
        new SubscribeRequestInputProtocol("queue");
  }

  public static final class RedrivePolicyInputInput extends Model {
    public RedrivePolicyInputInput() {}

    /**
     * Queue UUID, CRN or exact name on input, scoped to the subscriber account and serving region.
     * Empty on PATCH clears the target.
     */
    @JsonProperty(value = "dead_letter_queue", required = true)
    private String dead_letter_queue;

    @JsonProperty("dead_letter_queue")
    public String getDeadLetterQueue() {
      return dead_letter_queue;
    }

    public RedrivePolicyInputInput withDeadLetterQueue(String value) {
      this.dead_letter_queue = value;
      return this;
    }
  }

  public static final class SubscribeResponse extends Model {
    public SubscribeResponse() {}

    @JsonProperty(value = "subscription", required = true)
    private Subscription subscription;

    @JsonProperty("subscription")
    public Subscription getSubscription() {
      return subscription;
    }

    /**
     * The HMAC key for verifying webhook deliveries. Returned only on the first create of an
     * http/https subscription — absent for email, and absent when an existing subscription is
     * returned.
     */
    @JsonProperty(value = "signing_secret", required = false)
    private String signing_secret;

    @JsonProperty("signing_secret")
    public String getSigningSecret() {
      return signing_secret;
    }
  }

  public static final class UpdateSubscriptionRequestInput extends Model {
    public UpdateSubscriptionRequestInput() {}

    @JsonProperty(value = "raw_message_delivery", required = false)
    private Boolean raw_message_delivery;

    @JsonProperty("raw_message_delivery")
    public Boolean getRawMessageDelivery() {
      return raw_message_delivery;
    }

    public UpdateSubscriptionRequestInput withRawMessageDelivery(Boolean value) {
      this.raw_message_delivery = value;
      return this;
    }

    @JsonProperty(value = "filter_policy", required = false)
    private Map<String, List<JsonNode>> filter_policy;

    @JsonProperty("filter_policy")
    public Map<String, List<JsonNode>> getFilterPolicy() {
      return filter_policy;
    }

    public UpdateSubscriptionRequestInput withFilterPolicy(Map<String, List<JsonNode>> value) {
      this.filter_policy = value;
      return this;
    }

    @JsonProperty(value = "delivery_policy", required = false)
    private DeliveryPolicyInput delivery_policy;

    @JsonProperty("delivery_policy")
    public DeliveryPolicyInput getDeliveryPolicy() {
      return delivery_policy;
    }

    public UpdateSubscriptionRequestInput withDeliveryPolicy(DeliveryPolicyInput value) {
      this.delivery_policy = value;
      return this;
    }

    /**
     * Omitted leaves the dead-letter queue unchanged. Present with an empty `dead_letter_queue`
     * clears it. Setting a new target re-checks `queue:SendMessage` on it.
     */
    @JsonProperty(value = "redrive_policy", required = false)
    private RedrivePolicyInputInput redrive_policy;

    @JsonProperty("redrive_policy")
    public RedrivePolicyInputInput getRedrivePolicy() {
      return redrive_policy;
    }

    public UpdateSubscriptionRequestInput withRedrivePolicy(RedrivePolicyInputInput value) {
      this.redrive_policy = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateSubscriptionRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UpdateTopicRequestInput extends Model {
    public UpdateTopicRequestInput() {}

    @JsonProperty(value = "display_name", required = false)
    private String display_name;

    @JsonProperty("display_name")
    public String getDisplayName() {
      return display_name;
    }

    public UpdateTopicRequestInput withDisplayName(String value) {
      this.display_name = value;
      return this;
    }

    @JsonProperty(value = "delivery_policy", required = false)
    private DeliveryPolicyInput delivery_policy;

    @JsonProperty("delivery_policy")
    public DeliveryPolicyInput getDeliveryPolicy() {
      return delivery_policy;
    }

    public UpdateTopicRequestInput withDeliveryPolicy(DeliveryPolicyInput value) {
      this.delivery_policy = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateTopicRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }
}
