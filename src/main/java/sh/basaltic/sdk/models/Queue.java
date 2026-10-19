package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed queue wire models. Unknown string enum values are retained. */
public final class Queue {

  private Queue() {}

  public static final class ChangeVisibilityRequestInput extends Model {
    public ChangeVisibilityRequestInput() {}

    @JsonProperty(value = "receipt_handle", required = true)
    private String receipt_handle;

    @JsonProperty("receipt_handle")
    public String getReceiptHandle() {
      return receipt_handle;
    }

    public ChangeVisibilityRequestInput withReceiptHandle(String value) {
      this.receipt_handle = value;
      return this;
    }

    /** Measured from now, not from the original lease. 0 releases the message immediately. */
    @JsonProperty(value = "visibility_timeout_seconds", required = true)
    private Long visibility_timeout_seconds;

    @JsonProperty("visibility_timeout_seconds")
    public Long getVisibilityTimeoutSeconds() {
      return visibility_timeout_seconds;
    }

    public ChangeVisibilityRequestInput withVisibilityTimeoutSeconds(Long value) {
      this.visibility_timeout_seconds = value;
      return this;
    }
  }

  public static final class ChangeVisibilityBatchRequestInput extends Model {
    public ChangeVisibilityBatchRequestInput() {}

    @JsonProperty(value = "entries", required = true)
    private List<ChangeVisibilityBatchRequestInputEntriesItem> entries;

    @JsonProperty("entries")
    public List<ChangeVisibilityBatchRequestInputEntriesItem> getEntries() {
      return entries;
    }

    public ChangeVisibilityBatchRequestInput withEntries(
        List<ChangeVisibilityBatchRequestInputEntriesItem> value) {
      this.entries = value;
      return this;
    }
  }

  public static final class ChangeVisibilityBatchRequestInputEntriesItem extends Model {
    public ChangeVisibilityBatchRequestInputEntriesItem() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    public ChangeVisibilityBatchRequestInputEntriesItem withId(String value) {
      this.id = value;
      return this;
    }

    @JsonProperty(value = "receipt_handle", required = true)
    private String receipt_handle;

    @JsonProperty("receipt_handle")
    public String getReceiptHandle() {
      return receipt_handle;
    }

    public ChangeVisibilityBatchRequestInputEntriesItem withReceiptHandle(String value) {
      this.receipt_handle = value;
      return this;
    }

    @JsonProperty(value = "visibility_timeout_seconds", required = true)
    private Long visibility_timeout_seconds;

    @JsonProperty("visibility_timeout_seconds")
    public Long getVisibilityTimeoutSeconds() {
      return visibility_timeout_seconds;
    }

    public ChangeVisibilityBatchRequestInputEntriesItem withVisibilityTimeoutSeconds(Long value) {
      this.visibility_timeout_seconds = value;
      return this;
    }
  }

  public static final class BatchResponse extends Model {
    public BatchResponse() {}

    @JsonProperty(value = "results", required = true)
    private List<BatchResult> results;

    @JsonProperty("results")
    public List<BatchResult> getResults() {
      return results;
    }
  }

  public static final class BatchResult extends Model {
    public BatchResult() {}

    /** The entry id from the request. */
    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "message_id", required = false)
    private String message_id;

    @JsonProperty("message_id")
    public String getMessageId() {
      return message_id;
    }

    @JsonProperty(value = "duplicate", required = false)
    private Boolean duplicate;

    @JsonProperty("duplicate")
    public Boolean getDuplicate() {
      return duplicate;
    }

    /** Machine-readable code when this entry failed. */
    @JsonProperty(value = "error", required = false)
    private String error;

    @JsonProperty("error")
    public String getError() {
      return error;
    }

    /** Human-readable reason accompanying error. */
    @JsonProperty(value = "message", required = false)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }
  }

  public static final class CreateQueueRequestInput extends Model {
    public CreateQueueRequestInput() {}

    /**
     * Letters, digits, dot, dash, or underscore, starting with a letter or digit. A name ending in
     * `.fifo` creates a FIFO queue. Resource names must not start with the literal crn: prefix or
     * be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateQueueRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "visibility_timeout_seconds", required = false)
    private Long visibility_timeout_seconds;

    @JsonProperty("visibility_timeout_seconds")
    public Long getVisibilityTimeoutSeconds() {
      return visibility_timeout_seconds;
    }

    public CreateQueueRequestInput withVisibilityTimeoutSeconds(Long value) {
      this.visibility_timeout_seconds = value;
      return this;
    }

    @JsonProperty(value = "message_retention_seconds", required = false)
    private Long message_retention_seconds;

    @JsonProperty("message_retention_seconds")
    public Long getMessageRetentionSeconds() {
      return message_retention_seconds;
    }

    public CreateQueueRequestInput withMessageRetentionSeconds(Long value) {
      this.message_retention_seconds = value;
      return this;
    }

    @JsonProperty(value = "max_message_bytes", required = false)
    private Long max_message_bytes;

    @JsonProperty("max_message_bytes")
    public Long getMaxMessageBytes() {
      return max_message_bytes;
    }

    public CreateQueueRequestInput withMaxMessageBytes(Long value) {
      this.max_message_bytes = value;
      return this;
    }

    @JsonProperty(value = "delay_seconds", required = false)
    private Long delay_seconds;

    @JsonProperty("delay_seconds")
    public Long getDelaySeconds() {
      return delay_seconds;
    }

    public CreateQueueRequestInput withDelaySeconds(Long value) {
      this.delay_seconds = value;
      return this;
    }

    @JsonProperty(value = "receive_wait_time_seconds", required = false)
    private Long receive_wait_time_seconds;

    @JsonProperty("receive_wait_time_seconds")
    public Long getReceiveWaitTimeSeconds() {
      return receive_wait_time_seconds;
    }

    public CreateQueueRequestInput withReceiveWaitTimeSeconds(Long value) {
      this.receive_wait_time_seconds = value;
      return this;
    }

    @JsonProperty(value = "kms_data_key_reuse_period_seconds", required = false)
    private Long kms_data_key_reuse_period_seconds;

    @JsonProperty("kms_data_key_reuse_period_seconds")
    public Long getKmsDataKeyReusePeriodSeconds() {
      return kms_data_key_reuse_period_seconds;
    }

    public CreateQueueRequestInput withKmsDataKeyReusePeriodSeconds(Long value) {
      this.kms_data_key_reuse_period_seconds = value;
      return this;
    }

    /** FIFO queues only. */
    @JsonProperty(value = "content_based_deduplication", required = false)
    private Boolean content_based_deduplication;

    @JsonProperty("content_based_deduplication")
    public Boolean getContentBasedDeduplication() {
      return content_based_deduplication;
    }

    public CreateQueueRequestInput withContentBasedDeduplication(Boolean value) {
      this.content_based_deduplication = value;
      return this;
    }

    /** KMS key UUID, CRN or account-scoped name. Omit to use the platform key. */
    @JsonProperty(value = "kms_key", required = false)
    private String kms_key;

    @JsonProperty("kms_key")
    public String getKmsKey() {
      return kms_key;
    }

    public CreateQueueRequestInput withKmsKey(String value) {
      this.kms_key = value;
      return this;
    }

    @JsonProperty(value = "redrive_policy", required = false)
    private RedrivePolicyInputInput redrive_policy;

    @JsonProperty("redrive_policy")
    public RedrivePolicyInputInput getRedrivePolicy() {
      return redrive_policy;
    }

    public CreateQueueRequestInput withRedrivePolicy(RedrivePolicyInputInput value) {
      this.redrive_policy = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateQueueRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class RedrivePolicyInputInput extends Model {
    public RedrivePolicyInputInput() {}

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

    @JsonProperty(value = "max_receive_count", required = true)
    private Long max_receive_count;

    @JsonProperty("max_receive_count")
    public Long getMaxReceiveCount() {
      return max_receive_count;
    }

    public RedrivePolicyInputInput withMaxReceiveCount(Long value) {
      this.max_receive_count = value;
      return this;
    }
  }

  public static final class QueueResponse extends Model {
    public QueueResponse() {}

    @JsonProperty(value = "queue", required = true)
    private Queue2 queue;

    @JsonProperty("queue")
    public Queue2 getQueue() {
      return queue;
    }
  }

  public static final class Queue2 extends Model {
    public Queue2() {}

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

    /** Derived from the name and immutable. */
    @JsonProperty(value = "kind", required = true)
    private Queue2Kind kind;

    @JsonProperty("kind")
    public Queue2Kind getKind() {
      return kind;
    }

    @JsonProperty(value = "attributes", required = true)
    private QueueAttributes attributes;

    @JsonProperty("attributes")
    public QueueAttributes getAttributes() {
      return attributes;
    }

    @JsonProperty(value = "redrive_policy", required = false)
    private RedrivePolicy redrive_policy;

    @JsonProperty("redrive_policy")
    public RedrivePolicy getRedrivePolicy() {
      return redrive_policy;
    }

    /**
     * FIFO only. Derives a deduplication id from a hash of the body when the sender supplies none.
     */
    @JsonProperty(value = "content_based_deduplication", required = false)
    private Boolean content_based_deduplication;

    @JsonProperty("content_based_deduplication")
    public Boolean getContentBasedDeduplication() {
      return content_based_deduplication;
    }

    /**
     * Customer-managed key wrapping the queue data key. Omitted for platform encryption. If key
     * metadata is unavailable, the reference retains its stored ID and CRN without a name.
     */
    @JsonProperty(value = "kms_key", required = false)
    private ResourceRef kms_key;

    @JsonProperty("kms_key")
    public ResourceRef getKmsKey() {
      return kms_key;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "depth", required = false)
    private QueueDepth depth;

    @JsonProperty("depth")
    public QueueDepth getDepth() {
      return depth;
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

  public static final class Queue2Kind {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Queue2Kind(String value) {
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
      return other instanceof Queue2Kind v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final Queue2Kind STANDARD = new Queue2Kind("standard");
    public static final Queue2Kind FIFO = new Queue2Kind("fifo");
  }

  public static final class QueueAttributes extends Model {
    public QueueAttributes() {}

    /** How long a received message stays invisible before redelivery. 0 redelivers immediately. */
    @JsonProperty(value = "visibility_timeout_seconds", required = false)
    private Long visibility_timeout_seconds;

    @JsonProperty("visibility_timeout_seconds")
    public Long getVisibilityTimeoutSeconds() {
      return visibility_timeout_seconds;
    }

    /** How long an undeleted message survives before it is discarded. */
    @JsonProperty(value = "message_retention_seconds", required = false)
    private Long message_retention_seconds;

    @JsonProperty("message_retention_seconds")
    public Long getMessageRetentionSeconds() {
      return message_retention_seconds;
    }

    /** Largest accepted message. Attributes count against this alongside the body. */
    @JsonProperty(value = "max_message_bytes", required = false)
    private Long max_message_bytes;

    @JsonProperty("max_message_bytes")
    public Long getMaxMessageBytes() {
      return max_message_bytes;
    }

    /**
     * Default delay applied to every send that does not override it. Not supported on FIFO queues.
     */
    @JsonProperty(value = "delay_seconds", required = false)
    private Long delay_seconds;

    @JsonProperty("delay_seconds")
    public Long getDelaySeconds() {
      return delay_seconds;
    }

    /** Default long-poll window for a receive that does not override it. */
    @JsonProperty(value = "receive_wait_time_seconds", required = false)
    private Long receive_wait_time_seconds;

    @JsonProperty("receive_wait_time_seconds")
    public Long getReceiveWaitTimeSeconds() {
      return receive_wait_time_seconds;
    }

    /**
     * How long an unwrapped data key is cached. Sends and receives keep working for up to this long
     * after the wrapping key is disabled; lower it to tighten that window at the cost of more KMS
     * round-trips.
     */
    @JsonProperty(value = "kms_data_key_reuse_period_seconds", required = false)
    private Long kms_data_key_reuse_period_seconds;

    @JsonProperty("kms_data_key_reuse_period_seconds")
    public Long getKmsDataKeyReusePeriodSeconds() {
      return kms_data_key_reuse_period_seconds;
    }
  }

  public static final class RedrivePolicy extends Model {
    public RedrivePolicy() {}

    @JsonProperty(value = "dead_letter_queue", required = true)
    private ResourceRef dead_letter_queue;

    @JsonProperty("dead_letter_queue")
    public ResourceRef getDeadLetterQueue() {
      return dead_letter_queue;
    }

    @JsonProperty(value = "max_receive_count", required = true)
    private Long max_receive_count;

    @JsonProperty("max_receive_count")
    public Long getMaxReceiveCount() {
      return max_receive_count;
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

  public static final class QueueDepth extends Model {
    public QueueDepth() {}

    @JsonProperty(value = "approximate_available", required = false)
    private Long approximate_available;

    @JsonProperty("approximate_available")
    public Long getApproximateAvailable() {
      return approximate_available;
    }

    @JsonProperty(value = "approximate_in_flight", required = false)
    private Long approximate_in_flight;

    @JsonProperty("approximate_in_flight")
    public Long getApproximateInFlight() {
      return approximate_in_flight;
    }

    @JsonProperty(value = "approximate_delayed", required = false)
    private Long approximate_delayed;

    @JsonProperty("approximate_delayed")
    public Long getApproximateDelayed() {
      return approximate_delayed;
    }

    @JsonProperty(value = "counts_capped", required = false)
    private Boolean counts_capped;

    @JsonProperty("counts_capped")
    public Boolean getCountsCapped() {
      return counts_capped;
    }
  }

  public static final class DeleteMessageQuery extends Model {
    public DeleteMessageQuery() {}

    @JsonProperty(value = "receipt_handle", required = true)
    private String receipt_handle;

    @JsonProperty("receipt_handle")
    public String getReceiptHandle() {
      return receipt_handle;
    }

    public DeleteMessageQuery withReceiptHandle(String value) {
      this.receipt_handle = value;
      return this;
    }
  }

  public static final class DeleteMessageBatchRequestInput extends Model {
    public DeleteMessageBatchRequestInput() {}

    @JsonProperty(value = "entries", required = true)
    private List<DeleteMessageBatchRequestInputEntriesItem> entries;

    @JsonProperty("entries")
    public List<DeleteMessageBatchRequestInputEntriesItem> getEntries() {
      return entries;
    }

    public DeleteMessageBatchRequestInput withEntries(
        List<DeleteMessageBatchRequestInputEntriesItem> value) {
      this.entries = value;
      return this;
    }
  }

  public static final class DeleteMessageBatchRequestInputEntriesItem extends Model {
    public DeleteMessageBatchRequestInputEntriesItem() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    public DeleteMessageBatchRequestInputEntriesItem withId(String value) {
      this.id = value;
      return this;
    }

    @JsonProperty(value = "receipt_handle", required = true)
    private String receipt_handle;

    @JsonProperty("receipt_handle")
    public String getReceiptHandle() {
      return receipt_handle;
    }

    public DeleteMessageBatchRequestInputEntriesItem withReceiptHandle(String value) {
      this.receipt_handle = value;
      return this;
    }
  }

  public static final class ListQueuesQuery extends Model {
    public ListQueuesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListQueuesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListQueuesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListQueuesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListQueuesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class QueueListResponse extends Model {
    public QueueListResponse() {}

    @JsonProperty(value = "queues", required = true)
    private List<Queue2> queues;

    @JsonProperty("queues")
    public List<Queue2> getQueues() {
      return queues;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
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

  public static final class PeekMessagesQuery extends Model {
    public PeekMessagesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public PeekMessagesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "visibility", required = false)
    private PeekMessagesQueryVisibility visibility;

    @JsonProperty("visibility")
    public PeekMessagesQueryVisibility getVisibility() {
      return visibility;
    }

    public PeekMessagesQuery withVisibility(PeekMessagesQueryVisibility value) {
      this.visibility = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public PeekMessagesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public PeekMessagesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class PeekMessagesQueryVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PeekMessagesQueryVisibility(String value) {
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
      return other instanceof PeekMessagesQueryVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PeekMessagesQueryVisibility AVAILABLE =
        new PeekMessagesQueryVisibility("available");
    public static final PeekMessagesQueryVisibility IN_FLIGHT =
        new PeekMessagesQueryVisibility("in_flight");
    public static final PeekMessagesQueryVisibility DELAYED =
        new PeekMessagesQueryVisibility("delayed");
  }

  public static final class PeekResponse extends Model {
    public PeekResponse() {}

    @JsonProperty(value = "messages", required = true)
    private List<Message> messages;

    @JsonProperty("messages")
    public List<Message> getMessages() {
      return messages;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Message extends Model {
    public Message() {}

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

    @JsonProperty(value = "queue_id", required = true)
    private String queue_id;

    @JsonProperty("queue_id")
    public String getQueueId() {
      return queue_id;
    }

    /** Absent when the body could not be decrypted — the rest of the row is still reported. */
    @JsonProperty(value = "body", required = false)
    private String body;

    @JsonProperty("body")
    public String getBody() {
      return body;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, MessageAttributesValue> attributes;

    @JsonProperty("attributes")
    public Map<String, MessageAttributesValue> getAttributes() {
      return attributes;
    }

    @JsonProperty(value = "visibility", required = true)
    private MessageVisibility visibility;

    @JsonProperty("visibility")
    public MessageVisibility getVisibility() {
      return visibility;
    }

    @JsonProperty(value = "receive_count", required = true)
    private Long receive_count;

    @JsonProperty("receive_count")
    public Long getReceiveCount() {
      return receive_count;
    }

    /** Plaintext size, counted against the queue's max_message_bytes. */
    @JsonProperty(value = "body_bytes", required = false)
    private Long body_bytes;

    @JsonProperty("body_bytes")
    public Long getBodyBytes() {
      return body_bytes;
    }

    @JsonProperty(value = "message_group_id", required = false)
    private String message_group_id;

    @JsonProperty("message_group_id")
    public String getMessageGroupId() {
      return message_group_id;
    }

    @JsonProperty(value = "enqueued_at", required = true)
    private String enqueued_at;

    @JsonProperty("enqueued_at")
    public String getEnqueuedAt() {
      return enqueued_at;
    }

    @JsonProperty(value = "visible_at", required = true)
    private String visible_at;

    @JsonProperty("visible_at")
    public String getVisibleAt() {
      return visible_at;
    }

    /** When retention discards this message. */
    @JsonProperty(value = "expires_at", required = true)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    @JsonProperty(value = "first_received_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> first_received_at = JsonField.missing();

    @JsonProperty("first_received_at")
    public JsonField<String> getFirstReceivedAt() {
      return first_received_at;
    }
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
    public static final MessageAttributesValueType BINARY =
        new MessageAttributesValueType("Binary");
  }

  public static final class MessageVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public MessageVisibility(String value) {
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
      return other instanceof MessageVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final MessageVisibility AVAILABLE = new MessageVisibility("available");
    public static final MessageVisibility IN_FLIGHT = new MessageVisibility("in_flight");
    public static final MessageVisibility DELAYED = new MessageVisibility("delayed");
  }

  public static final class PurgeQueueResponse extends Model {
    public PurgeQueueResponse() {}

    @JsonProperty(value = "messages_deleted", required = true)
    private Long messages_deleted;

    @JsonProperty("messages_deleted")
    public Long getMessagesDeleted() {
      return messages_deleted;
    }
  }

  public static final class ReceiveRequestInput extends Model {
    public ReceiveRequestInput() {}

    /** How many messages to lease. Fewer may be returned even when more are available. */
    @JsonProperty(value = "max_messages", required = false)
    private Long max_messages;

    @JsonProperty("max_messages")
    public Long getMaxMessages() {
      return max_messages;
    }

    public ReceiveRequestInput withMaxMessages(Long value) {
      this.max_messages = value;
      return this;
    }

    /** Overrides the queue's default for this lease only. */
    @JsonProperty(value = "visibility_timeout_seconds", required = false)
    private Long visibility_timeout_seconds;

    @JsonProperty("visibility_timeout_seconds")
    public Long getVisibilityTimeoutSeconds() {
      return visibility_timeout_seconds;
    }

    public ReceiveRequestInput withVisibilityTimeoutSeconds(Long value) {
      this.visibility_timeout_seconds = value;
      return this;
    }

    /**
     * Block up to this long for a message rather than returning empty. Defaults to the queue's
     * receive_wait_time_seconds.
     */
    @JsonProperty(value = "wait_time_seconds", required = false)
    private Long wait_time_seconds;

    @JsonProperty("wait_time_seconds")
    public Long getWaitTimeSeconds() {
      return wait_time_seconds;
    }

    public ReceiveRequestInput withWaitTimeSeconds(Long value) {
      this.wait_time_seconds = value;
      return this;
    }
  }

  public static final class ReceiveResponse extends Model {
    public ReceiveResponse() {}

    @JsonProperty(value = "messages", required = true)
    private List<ReceivedMessage> messages;

    @JsonProperty("messages")
    public List<ReceivedMessage> getMessages() {
      return messages;
    }
  }

  public static final class ReceivedMessage extends Model {
    public ReceivedMessage() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * The credential for this lease. Required to delete the message or extend its lease, and valid
     * only until the lease lapses.
     */
    @JsonProperty(value = "receipt_handle", required = true)
    private String receipt_handle;

    @JsonProperty("receipt_handle")
    public String getReceiptHandle() {
      return receipt_handle;
    }

    @JsonProperty(value = "body", required = true)
    private String body;

    @JsonProperty("body")
    public String getBody() {
      return body;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, MessageAttributesValue> attributes;

    @JsonProperty("attributes")
    public Map<String, MessageAttributesValue> getAttributes() {
      return attributes;
    }

    /**
     * How many times this message has been leased, including now. Compare against the redrive
     * policy to spot a poison message.
     */
    @JsonProperty(value = "receive_count", required = true)
    private Long receive_count;

    @JsonProperty("receive_count")
    public Long getReceiveCount() {
      return receive_count;
    }

    @JsonProperty(value = "message_group_id", required = false)
    private String message_group_id;

    @JsonProperty("message_group_id")
    public String getMessageGroupId() {
      return message_group_id;
    }

    @JsonProperty(value = "enqueued_at", required = true)
    private String enqueued_at;

    @JsonProperty("enqueued_at")
    public String getEnqueuedAt() {
      return enqueued_at;
    }

    /** When this lease lapses and the message is redelivered. */
    @JsonProperty(value = "visible_at", required = true)
    private String visible_at;

    @JsonProperty("visible_at")
    public String getVisibleAt() {
      return visible_at;
    }
  }

  public static final class SendMessageRequestInput extends Model {
    public SendMessageRequestInput() {}

    /** The payload. Counted against the queue's max_message_bytes together with the attributes. */
    @JsonProperty(value = "body", required = true)
    private String body;

    @JsonProperty("body")
    public String getBody() {
      return body;
    }

    public SendMessageRequestInput withBody(String value) {
      this.body = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, MessageAttributesInputValue> attributes;

    @JsonProperty("attributes")
    public Map<String, MessageAttributesInputValue> getAttributes() {
      return attributes;
    }

    public SendMessageRequestInput withAttributes(Map<String, MessageAttributesInputValue> value) {
      this.attributes = value;
      return this;
    }

    /**
     * Overrides the queue's default for this message. Rejected on FIFO queues, where it would let a
     * later message become visible before an earlier one in the same group.
     */
    @JsonProperty(value = "delay_seconds", required = false)
    private Long delay_seconds;

    @JsonProperty("delay_seconds")
    public Long getDelaySeconds() {
      return delay_seconds;
    }

    public SendMessageRequestInput withDelaySeconds(Long value) {
      this.delay_seconds = value;
      return this;
    }

    /**
     * Required on FIFO queues, rejected on standard ones. Messages sharing a group are delivered in
     * order, and a group's next message is withheld while an earlier one is in flight.
     */
    @JsonProperty(value = "message_group_id", required = false)
    private String message_group_id;

    @JsonProperty("message_group_id")
    public String getMessageGroupId() {
      return message_group_id;
    }

    public SendMessageRequestInput withMessageGroupId(String value) {
      this.message_group_id = value;
      return this;
    }

    /**
     * FIFO only. A repeat within five minutes is suppressed and the original message's id is
     * returned. Omit on a queue with `content_based_deduplication` to derive it from the body.
     */
    @JsonProperty(value = "message_deduplication_id", required = false)
    private String message_deduplication_id;

    @JsonProperty("message_deduplication_id")
    public String getMessageDeduplicationId() {
      return message_deduplication_id;
    }

    public SendMessageRequestInput withMessageDeduplicationId(String value) {
      this.message_deduplication_id = value;
      return this;
    }
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
    public static final MessageAttributesInputValueType BINARY =
        new MessageAttributesInputValueType("Binary");
  }

  public static final class SendMessageResponse extends Model {
    public SendMessageResponse() {}

    @JsonProperty(value = "result", required = true)
    private SendResult result;

    @JsonProperty("result")
    public SendResult getResult() {
      return result;
    }
  }

  public static final class SendResult extends Model {
    public SendResult() {}

    @JsonProperty(value = "message_id", required = true)
    private String message_id;

    @JsonProperty("message_id")
    public String getMessageId() {
      return message_id;
    }

    /**
     * A live deduplication entry suppressed this send; message_id names the message the original
     * produced.
     */
    @JsonProperty(value = "duplicate", required = false)
    private Boolean duplicate;

    @JsonProperty("duplicate")
    public Boolean getDuplicate() {
      return duplicate;
    }
  }

  public static final class SendMessageBatchRequestInput extends Model {
    public SendMessageBatchRequestInput() {}

    @JsonProperty(value = "entries", required = true)
    private List<SendMessageBatchRequestInputEntriesItem> entries;

    @JsonProperty("entries")
    public List<SendMessageBatchRequestInputEntriesItem> getEntries() {
      return entries;
    }

    public SendMessageBatchRequestInput withEntries(
        List<SendMessageBatchRequestInputEntriesItem> value) {
      this.entries = value;
      return this;
    }
  }

  public static final class SendMessageBatchRequestInputEntriesItem extends Model {
    public SendMessageBatchRequestInputEntriesItem() {}

    /**
     * Your own identifier for this entry, echoed back in the result. Must be unique within the
     * request.
     */
    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    public SendMessageBatchRequestInputEntriesItem withId(String value) {
      this.id = value;
      return this;
    }

    /** The payload. Counted against the queue's max_message_bytes together with the attributes. */
    @JsonProperty(value = "body", required = true)
    private String body;

    @JsonProperty("body")
    public String getBody() {
      return body;
    }

    public SendMessageBatchRequestInputEntriesItem withBody(String value) {
      this.body = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, MessageAttributesInputValue> attributes;

    @JsonProperty("attributes")
    public Map<String, MessageAttributesInputValue> getAttributes() {
      return attributes;
    }

    public SendMessageBatchRequestInputEntriesItem withAttributes(
        Map<String, MessageAttributesInputValue> value) {
      this.attributes = value;
      return this;
    }

    /**
     * Overrides the queue's default for this message. Rejected on FIFO queues, where it would let a
     * later message become visible before an earlier one in the same group.
     */
    @JsonProperty(value = "delay_seconds", required = false)
    private Long delay_seconds;

    @JsonProperty("delay_seconds")
    public Long getDelaySeconds() {
      return delay_seconds;
    }

    public SendMessageBatchRequestInputEntriesItem withDelaySeconds(Long value) {
      this.delay_seconds = value;
      return this;
    }

    /**
     * Required on FIFO queues, rejected on standard ones. Messages sharing a group are delivered in
     * order, and a group's next message is withheld while an earlier one is in flight.
     */
    @JsonProperty(value = "message_group_id", required = false)
    private String message_group_id;

    @JsonProperty("message_group_id")
    public String getMessageGroupId() {
      return message_group_id;
    }

    public SendMessageBatchRequestInputEntriesItem withMessageGroupId(String value) {
      this.message_group_id = value;
      return this;
    }

    /**
     * FIFO only. A repeat within five minutes is suppressed and the original message's id is
     * returned. Omit on a queue with `content_based_deduplication` to derive it from the body.
     */
    @JsonProperty(value = "message_deduplication_id", required = false)
    private String message_deduplication_id;

    @JsonProperty("message_deduplication_id")
    public String getMessageDeduplicationId() {
      return message_deduplication_id;
    }

    public SendMessageBatchRequestInputEntriesItem withMessageDeduplicationId(String value) {
      this.message_deduplication_id = value;
      return this;
    }
  }

  public static final class UpdateQueueRequestInput extends Model {
    public UpdateQueueRequestInput() {}

    @JsonProperty(value = "visibility_timeout_seconds", required = false)
    private Long visibility_timeout_seconds;

    @JsonProperty("visibility_timeout_seconds")
    public Long getVisibilityTimeoutSeconds() {
      return visibility_timeout_seconds;
    }

    public UpdateQueueRequestInput withVisibilityTimeoutSeconds(Long value) {
      this.visibility_timeout_seconds = value;
      return this;
    }

    @JsonProperty(value = "message_retention_seconds", required = false)
    private Long message_retention_seconds;

    @JsonProperty("message_retention_seconds")
    public Long getMessageRetentionSeconds() {
      return message_retention_seconds;
    }

    public UpdateQueueRequestInput withMessageRetentionSeconds(Long value) {
      this.message_retention_seconds = value;
      return this;
    }

    @JsonProperty(value = "max_message_bytes", required = false)
    private Long max_message_bytes;

    @JsonProperty("max_message_bytes")
    public Long getMaxMessageBytes() {
      return max_message_bytes;
    }

    public UpdateQueueRequestInput withMaxMessageBytes(Long value) {
      this.max_message_bytes = value;
      return this;
    }

    @JsonProperty(value = "delay_seconds", required = false)
    private Long delay_seconds;

    @JsonProperty("delay_seconds")
    public Long getDelaySeconds() {
      return delay_seconds;
    }

    public UpdateQueueRequestInput withDelaySeconds(Long value) {
      this.delay_seconds = value;
      return this;
    }

    @JsonProperty(value = "receive_wait_time_seconds", required = false)
    private Long receive_wait_time_seconds;

    @JsonProperty("receive_wait_time_seconds")
    public Long getReceiveWaitTimeSeconds() {
      return receive_wait_time_seconds;
    }

    public UpdateQueueRequestInput withReceiveWaitTimeSeconds(Long value) {
      this.receive_wait_time_seconds = value;
      return this;
    }

    @JsonProperty(value = "kms_data_key_reuse_period_seconds", required = false)
    private Long kms_data_key_reuse_period_seconds;

    @JsonProperty("kms_data_key_reuse_period_seconds")
    public Long getKmsDataKeyReusePeriodSeconds() {
      return kms_data_key_reuse_period_seconds;
    }

    public UpdateQueueRequestInput withKmsDataKeyReusePeriodSeconds(Long value) {
      this.kms_data_key_reuse_period_seconds = value;
      return this;
    }

    /** Omit to keep the current policy; null removes it. An object replaces the policy. */
    @JsonProperty(value = "redrive_policy", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<UpdateQueueRequestInputRedrivePolicy> redrive_policy = JsonField.missing();

    @JsonProperty("redrive_policy")
    public JsonField<UpdateQueueRequestInputRedrivePolicy> getRedrivePolicy() {
      return redrive_policy;
    }

    public UpdateQueueRequestInput withRedrivePolicy(
        JsonField<UpdateQueueRequestInputRedrivePolicy> value) {
      this.redrive_policy = value;
      return this;
    }

    /**
     * KMS key UUID, CRN or account-scoped name. Omit to keep the current key; null restores the
     * platform key. Existing messages keep the key that sealed them.
     */
    @JsonProperty(value = "kms_key", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> kms_key = JsonField.missing();

    @JsonProperty("kms_key")
    public JsonField<String> getKmsKey() {
      return kms_key;
    }

    public UpdateQueueRequestInput withKmsKey(JsonField<String> value) {
      this.kms_key = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateQueueRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UpdateQueueRequestInputRedrivePolicy extends Model {
    public UpdateQueueRequestInputRedrivePolicy() {}

    /** Queue UUID, CRN or account-scoped name. */
    @JsonProperty(value = "dead_letter_queue", required = true)
    private String dead_letter_queue;

    @JsonProperty("dead_letter_queue")
    public String getDeadLetterQueue() {
      return dead_letter_queue;
    }

    public UpdateQueueRequestInputRedrivePolicy withDeadLetterQueue(String value) {
      this.dead_letter_queue = value;
      return this;
    }

    @JsonProperty(value = "max_receive_count", required = true)
    private Long max_receive_count;

    @JsonProperty("max_receive_count")
    public Long getMaxReceiveCount() {
      return max_receive_count;
    }

    public UpdateQueueRequestInputRedrivePolicy withMaxReceiveCount(Long value) {
      this.max_receive_count = value;
      return this;
    }
  }
}
