package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.math.BigDecimal;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed telemetry wire models. Unknown string enum values are retained. */
public final class Telemetry {

  private Telemetry() {}

  public static final class CreateLogGroupRequestInput extends Model {
    public CreateLogGroupRequestInput() {}

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateLogGroupRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public CreateLogGroupRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /** 1..3650, or omit for never expire */
    @JsonProperty(value = "retention_days", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> retention_days = JsonField.missing();

    @JsonProperty("retention_days")
    public JsonField<Long> getRetentionDays() {
      return retention_days;
    }

    public CreateLogGroupRequestInput withRetentionDays(JsonField<Long> value) {
      this.retention_days = value;
      return this;
    }

    /**
     * KMS key UUID, CRN or exact name in the authenticated account and serving region. The resolved
     * UUID is pinned; deleting a key and reusing its name never retargets existing data. An empty
     * string selects plaintext.
     */
    @JsonProperty(value = "kms_key", required = false)
    private String kms_key;

    @JsonProperty("kms_key")
    public String getKmsKey() {
      return kms_key;
    }

    public CreateLogGroupRequestInput withKmsKey(String value) {
      this.kms_key = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateLogGroupRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class LogGroupResponse extends Model {
    public LogGroupResponse() {}

    @JsonProperty(value = "log_group", required = false)
    private LogGroup log_group;

    @JsonProperty("log_group")
    public LogGroup getLogGroup() {
      return log_group;
    }
  }

  public static final class LogGroup extends Model {
    public LogGroup() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** CRN of the log group (used as the IAM resource ARN) */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** Owning account — the tenant fence for this group */
    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }

    /**
     * 1..512 chars, [A-Za-z0-9_./#-]. Leading "/" not allowed. Resource names must not start with
     * the literal crn: prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in
     * either case).
     */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    /** 1..3650 days, or null for never expire */
    @JsonProperty(value = "retention_days", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> retention_days = JsonField.missing();

    @JsonProperty("retention_days")
    public JsonField<Long> getRetentionDays() {
      return retention_days;
    }

    /**
     * True when the bound key has been deleted. The CRN is omitted, but the binding remains
     * encrypted under its original key identity; this does not select platform encryption or
     * plaintext.
     */
    @JsonProperty(value = "kms_key_unavailable", required = false)
    private Boolean kms_key_unavailable;

    @JsonProperty("kms_key_unavailable")
    public Boolean getKmsKeyUnavailable() {
      return kms_key_unavailable;
    }

    /** KMS key CRN. Omitted for plaintext or when kms_key_unavailable is true. */
    @JsonProperty(value = "kms_key_crn", required = false)
    private String kms_key_crn;

    @JsonProperty("kms_key_crn")
    public String getKmsKeyCrn() {
      return kms_key_crn;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = false)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class LogResponse extends Model {
    public LogResponse() {}

    @JsonProperty(value = "log", required = false)
    private LogRecord log;

    @JsonProperty("log")
    public LogRecord getLog() {
      return log;
    }
  }

  public static final class LogRecord extends Model {
    public LogRecord() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Producer-stamped event time */
    @JsonProperty(value = "timestamp", required = false)
    private String timestamp;

    @JsonProperty("timestamp")
    public String getTimestamp() {
      return timestamp;
    }

    @JsonProperty(value = "organization_id", required = false)
    private String organization_id;

    @JsonProperty("organization_id")
    public String getOrganizationId() {
      return organization_id;
    }

    /** Owning account, empty for org-scoped events */
    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }

    @JsonProperty(value = "log_group_id", required = false)
    private String log_group_id;

    @JsonProperty("log_group_id")
    public String getLogGroupId() {
      return log_group_id;
    }

    /** Name of the parent log group */
    @JsonProperty(value = "log_group", required = false)
    private String log_group;

    @JsonProperty("log_group")
    public String getLogGroup() {
      return log_group;
    }

    /** Within-group stream name (typically the producer host) */
    @JsonProperty(value = "log_stream", required = false)
    private String log_stream;

    @JsonProperty("log_stream")
    public String getLogStream() {
      return log_stream;
    }

    @JsonProperty(value = "severity", required = false)
    private LogRecordSeverity severity;

    @JsonProperty("severity")
    public LogRecordSeverity getSeverity() {
      return severity;
    }

    /** OTel numeric severity band (1..24) */
    @JsonProperty(value = "severity_number", required = false)
    private Long severity_number;

    @JsonProperty("severity_number")
    public Long getSeverityNumber() {
      return severity_number;
    }

    @JsonProperty(value = "body", required = false)
    private String body;

    @JsonProperty("body")
    public String getBody() {
      return body;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }

    @JsonProperty(value = "resource", required = false)
    private Map<String, String> resource;

    @JsonProperty("resource")
    public Map<String, String> getResource() {
      return resource;
    }

    @JsonProperty(value = "trace_id", required = false)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    @JsonProperty(value = "span_id", required = false)
    private String span_id;

    @JsonProperty("span_id")
    public String getSpanId() {
      return span_id;
    }
  }

  public static final class LogRecordSeverity {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LogRecordSeverity(String value) {
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
      return other instanceof LogRecordSeverity v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LogRecordSeverity TRACE = new LogRecordSeverity("TRACE");
    public static final LogRecordSeverity DEBUG = new LogRecordSeverity("DEBUG");
    public static final LogRecordSeverity INFO = new LogRecordSeverity("INFO");
    public static final LogRecordSeverity WARN = new LogRecordSeverity("WARN");
    public static final LogRecordSeverity ERROR = new LogRecordSeverity("ERROR");
    public static final LogRecordSeverity FATAL = new LogRecordSeverity("FATAL");
  }

  public static final class GetLogGroupScope extends Model {
    public GetLogGroupScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetLogGroupScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetRetainedTelemetryPresenceResponse extends Model {
    public GetRetainedTelemetryPresenceResponse() {}

    @JsonProperty(value = "has_resources", required = true)
    private Boolean has_resources;

    @JsonProperty("has_resources")
    public Boolean getHasResources() {
      return has_resources;
    }
  }

  public static final class TraceResponse extends Model {
    public TraceResponse() {}

    @JsonProperty(value = "trace_id", required = false)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    @JsonProperty(value = "spans", required = false)
    private List<Span> spans;

    @JsonProperty("spans")
    public List<Span> getSpans() {
      return spans;
    }
  }

  public static final class Span extends Model {
    public Span() {}

    @JsonProperty(value = "trace_id", required = false)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    @JsonProperty(value = "span_id", required = false)
    private String span_id;

    @JsonProperty("span_id")
    public String getSpanId() {
      return span_id;
    }

    @JsonProperty(value = "parent_span_id", required = false)
    private String parent_span_id;

    @JsonProperty("parent_span_id")
    public String getParentSpanId() {
      return parent_span_id;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "kind", required = false)
    private SpanKind kind;

    @JsonProperty("kind")
    public SpanKind getKind() {
      return kind;
    }

    @JsonProperty(value = "service_name", required = false)
    private String service_name;

    @JsonProperty("service_name")
    public String getServiceName() {
      return service_name;
    }

    @JsonProperty(value = "start_time", required = false)
    private String start_time;

    @JsonProperty("start_time")
    public String getStartTime() {
      return start_time;
    }

    @JsonProperty(value = "end_time", required = false)
    private String end_time;

    @JsonProperty("end_time")
    public String getEndTime() {
      return end_time;
    }

    @JsonProperty(value = "duration_ms", required = false)
    private BigDecimal duration_ms;

    @JsonProperty("duration_ms")
    public BigDecimal getDurationMs() {
      return duration_ms;
    }

    @JsonProperty(value = "status_code", required = false)
    private SpanStatusCode status_code;

    @JsonProperty("status_code")
    public SpanStatusCode getStatusCode() {
      return status_code;
    }

    @JsonProperty(value = "status_message", required = false)
    private String status_message;

    @JsonProperty("status_message")
    public String getStatusMessage() {
      return status_message;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }

    @JsonProperty(value = "resource", required = false)
    private Map<String, String> resource;

    @JsonProperty("resource")
    public Map<String, String> getResource() {
      return resource;
    }

    @JsonProperty(value = "events", required = false)
    private List<SpanEvent> events;

    @JsonProperty("events")
    public List<SpanEvent> getEvents() {
      return events;
    }

    @JsonProperty(value = "links", required = false)
    private List<SpanLink> links;

    @JsonProperty("links")
    public List<SpanLink> getLinks() {
      return links;
    }
  }

  public static final class SpanKind {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SpanKind(String value) {
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
      return other instanceof SpanKind v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SpanKind INTERNAL = new SpanKind("INTERNAL");
    public static final SpanKind SERVER = new SpanKind("SERVER");
    public static final SpanKind CLIENT = new SpanKind("CLIENT");
    public static final SpanKind PRODUCER = new SpanKind("PRODUCER");
    public static final SpanKind CONSUMER = new SpanKind("CONSUMER");
  }

  public static final class SpanStatusCode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SpanStatusCode(String value) {
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
      return other instanceof SpanStatusCode v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SpanStatusCode UNSET = new SpanStatusCode("UNSET");
    public static final SpanStatusCode OK = new SpanStatusCode("OK");
    public static final SpanStatusCode ERROR = new SpanStatusCode("ERROR");
  }

  public static final class SpanEvent extends Model {
    public SpanEvent() {}

    @JsonProperty(value = "timestamp", required = false)
    private String timestamp;

    @JsonProperty("timestamp")
    public String getTimestamp() {
      return timestamp;
    }

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }
  }

  public static final class SpanLink extends Model {
    public SpanLink() {}

    @JsonProperty(value = "trace_id", required = true)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    @JsonProperty(value = "span_id", required = true)
    private String span_id;

    @JsonProperty("span_id")
    public String getSpanId() {
      return span_id;
    }
  }

  public static final class TraceSettingsResponse extends Model {
    public TraceSettingsResponse() {}

    @JsonProperty(value = "trace_settings", required = false)
    private TraceSettings trace_settings;

    @JsonProperty("trace_settings")
    public TraceSettings getTraceSettings() {
      return trace_settings;
    }
  }

  public static final class TraceSettings extends Model {
    public TraceSettings() {}

    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }

    /** 1..3650, or null for never-expire */
    @JsonProperty(value = "retention_days", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> retention_days = JsonField.missing();

    @JsonProperty("retention_days")
    public JsonField<Long> getRetentionDays() {
      return retention_days;
    }

    /**
     * True when the bound key has been deleted. The CRN is omitted, but the binding remains
     * encrypted under its original key identity; this does not select platform encryption or
     * plaintext.
     */
    @JsonProperty(value = "kms_key_unavailable", required = false)
    private Boolean kms_key_unavailable;

    @JsonProperty("kms_key_unavailable")
    public Boolean getKmsKeyUnavailable() {
      return kms_key_unavailable;
    }

    /** KMS key CRN. Omitted for plaintext or when kms_key_unavailable is true. */
    @JsonProperty(value = "kms_key_crn", required = false)
    private String kms_key_crn;

    @JsonProperty("kms_key_crn")
    public String getKmsKeyCrn() {
      return kms_key_crn;
    }

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = false)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class IngestRequestInput extends Model {
    public IngestRequestInput() {}

    @JsonProperty(value = "logs", required = true)
    private List<IngestRecordInput> logs;

    @JsonProperty("logs")
    public List<IngestRecordInput> getLogs() {
      return logs;
    }

    public IngestRequestInput withLogs(List<IngestRecordInput> value) {
      this.logs = value;
      return this;
    }
  }

  public static final class IngestRecordInput extends Model {
    public IngestRecordInput() {}

    /** Optional — defaults to ingest time */
    @JsonProperty(value = "timestamp", required = false)
    private String timestamp;

    @JsonProperty("timestamp")
    public String getTimestamp() {
      return timestamp;
    }

    public IngestRecordInput withTimestamp(String value) {
      this.timestamp = value;
      return this;
    }

    /**
     * Reference to an existing log group by UUID, CRN or exact name in the authenticated account.
     * CRNs must identify telemetry/log-group in the serving region and account handle.
     * Classification is by syntax with no lookup fallback; slash-bearing names are preserved.
     */
    @JsonProperty(value = "log_group", required = true)
    private String log_group;

    @JsonProperty("log_group")
    public String getLogGroup() {
      return log_group;
    }

    public IngestRecordInput withLogGroup(String value) {
      this.log_group = value;
      return this;
    }

    /** Within-group stream name (free-form, customer choice) */
    @JsonProperty(value = "log_stream", required = true)
    private String log_stream;

    @JsonProperty("log_stream")
    public String getLogStream() {
      return log_stream;
    }

    public IngestRecordInput withLogStream(String value) {
      this.log_stream = value;
      return this;
    }

    /** One of TRACE/DEBUG/INFO/WARN/ERROR/FATAL (defaults to INFO) */
    @JsonProperty(value = "severity", required = false)
    private String severity;

    @JsonProperty("severity")
    public String getSeverity() {
      return severity;
    }

    public IngestRecordInput withSeverity(String value) {
      this.severity = value;
      return this;
    }

    @JsonProperty(value = "body", required = true)
    private String body;

    @JsonProperty("body")
    public String getBody() {
      return body;
    }

    public IngestRecordInput withBody(String value) {
      this.body = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }

    public IngestRecordInput withAttributes(Map<String, String> value) {
      this.attributes = value;
      return this;
    }

    @JsonProperty(value = "resource", required = false)
    private Map<String, String> resource;

    @JsonProperty("resource")
    public Map<String, String> getResource() {
      return resource;
    }

    public IngestRecordInput withResource(Map<String, String> value) {
      this.resource = value;
      return this;
    }

    @JsonProperty(value = "trace_id", required = false)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    public IngestRecordInput withTraceId(String value) {
      this.trace_id = value;
      return this;
    }

    @JsonProperty(value = "span_id", required = false)
    private String span_id;

    @JsonProperty("span_id")
    public String getSpanId() {
      return span_id;
    }

    public IngestRecordInput withSpanId(String value) {
      this.span_id = value;
      return this;
    }
  }

  public static final class IngestResult extends Model {
    public IngestResult() {}

    @JsonProperty(value = "accepted", required = false)
    private Long accepted;

    @JsonProperty("accepted")
    public Long getAccepted() {
      return accepted;
    }

    @JsonProperty(value = "rejected", required = false)
    private Long rejected;

    @JsonProperty("rejected")
    public Long getRejected() {
      return rejected;
    }

    @JsonProperty(value = "errors", required = false)
    private List<String> errors;

    @JsonProperty("errors")
    public List<String> getErrors() {
      return errors;
    }
  }

  public static final class IngestSpansRequestInput extends Model {
    public IngestSpansRequestInput() {}

    @JsonProperty(value = "spans", required = true)
    private List<SpanIngestRecordInput> spans;

    @JsonProperty("spans")
    public List<SpanIngestRecordInput> getSpans() {
      return spans;
    }

    public IngestSpansRequestInput withSpans(List<SpanIngestRecordInput> value) {
      this.spans = value;
      return this;
    }
  }

  public static final class SpanIngestRecordInput extends Model {
    public SpanIngestRecordInput() {}

    /** 32 lower-hex chars (OTel TraceId) */
    @JsonProperty(value = "trace_id", required = true)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    public SpanIngestRecordInput withTraceId(String value) {
      this.trace_id = value;
      return this;
    }

    /** 16 lower-hex chars (OTel SpanId) */
    @JsonProperty(value = "span_id", required = true)
    private String span_id;

    @JsonProperty("span_id")
    public String getSpanId() {
      return span_id;
    }

    public SpanIngestRecordInput withSpanId(String value) {
      this.span_id = value;
      return this;
    }

    /** 16 lower-hex chars or empty for root */
    @JsonProperty(value = "parent_span_id", required = false)
    private String parent_span_id;

    @JsonProperty("parent_span_id")
    public String getParentSpanId() {
      return parent_span_id;
    }

    public SpanIngestRecordInput withParentSpanId(String value) {
      this.parent_span_id = value;
      return this;
    }

    /** Operation name (e.g. "GET /api/users") */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public SpanIngestRecordInput withName(String value) {
      this.name = value;
      return this;
    }

    /** Defaults to INTERNAL */
    @JsonProperty(value = "kind", required = false)
    private SpanIngestRecordInputKind kind;

    @JsonProperty("kind")
    public SpanIngestRecordInputKind getKind() {
      return kind;
    }

    public SpanIngestRecordInput withKind(SpanIngestRecordInputKind value) {
      this.kind = value;
      return this;
    }

    /** Defaults to resource[service.name] */
    @JsonProperty(value = "service_name", required = false)
    private String service_name;

    @JsonProperty("service_name")
    public String getServiceName() {
      return service_name;
    }

    public SpanIngestRecordInput withServiceName(String value) {
      this.service_name = value;
      return this;
    }

    @JsonProperty(value = "start_time", required = true)
    private String start_time;

    @JsonProperty("start_time")
    public String getStartTime() {
      return start_time;
    }

    public SpanIngestRecordInput withStartTime(String value) {
      this.start_time = value;
      return this;
    }

    @JsonProperty(value = "end_time", required = true)
    private String end_time;

    @JsonProperty("end_time")
    public String getEndTime() {
      return end_time;
    }

    public SpanIngestRecordInput withEndTime(String value) {
      this.end_time = value;
      return this;
    }

    @JsonProperty(value = "status_code", required = false)
    private SpanIngestRecordInputStatusCode status_code;

    @JsonProperty("status_code")
    public SpanIngestRecordInputStatusCode getStatusCode() {
      return status_code;
    }

    public SpanIngestRecordInput withStatusCode(SpanIngestRecordInputStatusCode value) {
      this.status_code = value;
      return this;
    }

    @JsonProperty(value = "status_message", required = false)
    private String status_message;

    @JsonProperty("status_message")
    public String getStatusMessage() {
      return status_message;
    }

    public SpanIngestRecordInput withStatusMessage(String value) {
      this.status_message = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }

    public SpanIngestRecordInput withAttributes(Map<String, String> value) {
      this.attributes = value;
      return this;
    }

    @JsonProperty(value = "resource", required = false)
    private Map<String, String> resource;

    @JsonProperty("resource")
    public Map<String, String> getResource() {
      return resource;
    }

    public SpanIngestRecordInput withResource(Map<String, String> value) {
      this.resource = value;
      return this;
    }

    @JsonProperty(value = "events", required = false)
    private List<SpanEventInput> events;

    @JsonProperty("events")
    public List<SpanEventInput> getEvents() {
      return events;
    }

    public SpanIngestRecordInput withEvents(List<SpanEventInput> value) {
      this.events = value;
      return this;
    }

    @JsonProperty(value = "links", required = false)
    private List<SpanLinkInput> links;

    @JsonProperty("links")
    public List<SpanLinkInput> getLinks() {
      return links;
    }

    public SpanIngestRecordInput withLinks(List<SpanLinkInput> value) {
      this.links = value;
      return this;
    }
  }

  public static final class SpanIngestRecordInputKind {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SpanIngestRecordInputKind(String value) {
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
      return other instanceof SpanIngestRecordInputKind v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SpanIngestRecordInputKind INTERNAL =
        new SpanIngestRecordInputKind("INTERNAL");
    public static final SpanIngestRecordInputKind SERVER = new SpanIngestRecordInputKind("SERVER");
    public static final SpanIngestRecordInputKind CLIENT = new SpanIngestRecordInputKind("CLIENT");
    public static final SpanIngestRecordInputKind PRODUCER =
        new SpanIngestRecordInputKind("PRODUCER");
    public static final SpanIngestRecordInputKind CONSUMER =
        new SpanIngestRecordInputKind("CONSUMER");
  }

  public static final class SpanIngestRecordInputStatusCode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SpanIngestRecordInputStatusCode(String value) {
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
      return other instanceof SpanIngestRecordInputStatusCode v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SpanIngestRecordInputStatusCode UNSET =
        new SpanIngestRecordInputStatusCode("UNSET");
    public static final SpanIngestRecordInputStatusCode OK =
        new SpanIngestRecordInputStatusCode("OK");
    public static final SpanIngestRecordInputStatusCode ERROR =
        new SpanIngestRecordInputStatusCode("ERROR");
  }

  public static final class SpanEventInput extends Model {
    public SpanEventInput() {}

    @JsonProperty(value = "timestamp", required = false)
    private String timestamp;

    @JsonProperty("timestamp")
    public String getTimestamp() {
      return timestamp;
    }

    public SpanEventInput withTimestamp(String value) {
      this.timestamp = value;
      return this;
    }

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public SpanEventInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }

    public SpanEventInput withAttributes(Map<String, String> value) {
      this.attributes = value;
      return this;
    }
  }

  public static final class SpanLinkInput extends Model {
    public SpanLinkInput() {}

    @JsonProperty(value = "trace_id", required = true)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    public SpanLinkInput withTraceId(String value) {
      this.trace_id = value;
      return this;
    }

    @JsonProperty(value = "span_id", required = true)
    private String span_id;

    @JsonProperty("span_id")
    public String getSpanId() {
      return span_id;
    }

    public SpanLinkInput withSpanId(String value) {
      this.span_id = value;
      return this;
    }
  }

  public static final class ListLogGroupsQuery extends Model {
    public ListLogGroupsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListLogGroupsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListLogGroupsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListLogGroupsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListLogGroupsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class LogGroupListResponse extends Model {
    public LogGroupListResponse() {}

    @JsonProperty(value = "log_groups", required = false)
    private List<LogGroup> log_groups;

    @JsonProperty("log_groups")
    public List<LogGroup> getLogGroups() {
      return log_groups;
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

  public static final class ListMetricNamesQuery extends Model {
    public ListMetricNamesQuery() {}

    @JsonProperty(value = "start", required = true)
    private String start;

    @JsonProperty("start")
    public String getStart() {
      return start;
    }

    public ListMetricNamesQuery withStart(String value) {
      this.start = value;
      return this;
    }

    @JsonProperty(value = "end", required = true)
    private String end;

    @JsonProperty("end")
    public String getEnd() {
      return end;
    }

    public ListMetricNamesQuery withEnd(String value) {
      this.end = value;
      return this;
    }
  }

  public static final class ListMetricNamesResponse extends Model {
    public ListMetricNamesResponse() {}

    @JsonProperty(value = "status", required = false)
    private String status;

    @JsonProperty("status")
    public String getStatus() {
      return status;
    }

    @JsonProperty(value = "data", required = false)
    private List<String> data;

    @JsonProperty("data")
    public List<String> getData() {
      return data;
    }
  }

  public static final class ListMetricNamesPostBody extends Model {
    public ListMetricNamesPostBody() {}

    @JsonProperty(value = "start", required = true)
    private String start;

    @JsonProperty("start")
    public String getStart() {
      return start;
    }

    public ListMetricNamesPostBody withStart(String value) {
      this.start = value;
      return this;
    }

    @JsonProperty(value = "end", required = true)
    private String end;

    @JsonProperty("end")
    public String getEnd() {
      return end;
    }

    public ListMetricNamesPostBody withEnd(String value) {
      this.end = value;
      return this;
    }
  }

  public static final class ListMetricNamesPostResponse extends Model {
    public ListMetricNamesPostResponse() {}

    @JsonProperty(value = "status", required = false)
    private String status;

    @JsonProperty("status")
    public String getStatus() {
      return status;
    }

    @JsonProperty(value = "data", required = false)
    private List<String> data;

    @JsonProperty("data")
    public List<String> getData() {
      return data;
    }
  }

  public static final class ListMetricSeriesQuery extends Model {
    public ListMetricSeriesQuery() {}

    @JsonProperty(value = "metric", required = true)
    private String metric;

    @JsonProperty("metric")
    public String getMetric() {
      return metric;
    }

    public ListMetricSeriesQuery withMetric(String value) {
      this.metric = value;
      return this;
    }

    @JsonProperty(value = "start", required = true)
    private String start;

    @JsonProperty("start")
    public String getStart() {
      return start;
    }

    public ListMetricSeriesQuery withStart(String value) {
      this.start = value;
      return this;
    }

    @JsonProperty(value = "end", required = true)
    private String end;

    @JsonProperty("end")
    public String getEnd() {
      return end;
    }

    public ListMetricSeriesQuery withEnd(String value) {
      this.end = value;
      return this;
    }
  }

  public static final class ListMetricSeriesPostBody extends Model {
    public ListMetricSeriesPostBody() {}

    @JsonProperty(value = "metric", required = true)
    private String metric;

    @JsonProperty("metric")
    public String getMetric() {
      return metric;
    }

    public ListMetricSeriesPostBody withMetric(String value) {
      this.metric = value;
      return this;
    }

    @JsonProperty(value = "start", required = true)
    private String start;

    @JsonProperty("start")
    public String getStart() {
      return start;
    }

    public ListMetricSeriesPostBody withStart(String value) {
      this.start = value;
      return this;
    }

    @JsonProperty(value = "end", required = true)
    private String end;

    @JsonProperty("end")
    public String getEnd() {
      return end;
    }

    public ListMetricSeriesPostBody withEnd(String value) {
      this.end = value;
      return this;
    }
  }

  public static final class UpdateTraceSettingsRequestInput extends Model {
    public UpdateTraceSettingsRequestInput() {}

    /** 1..3650; pass clear_retention=true to switch to never-expire */
    @JsonProperty(value = "retention_days", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> retention_days = JsonField.missing();

    @JsonProperty("retention_days")
    public JsonField<Long> getRetentionDays() {
      return retention_days;
    }

    public UpdateTraceSettingsRequestInput withRetentionDays(JsonField<Long> value) {
      this.retention_days = value;
      return this;
    }

    /** When true, sets retention to never-expire (ignores retention_days) */
    @JsonProperty(value = "clear_retention", required = false)
    private Boolean clear_retention;

    @JsonProperty("clear_retention")
    public Boolean getClearRetention() {
      return clear_retention;
    }

    public UpdateTraceSettingsRequestInput withClearRetention(Boolean value) {
      this.clear_retention = value;
      return this;
    }

    /**
     * KMS key UUID, CRN or exact name in the authenticated account and serving region. PUT replaces
     * settings; omission or an empty string selects plaintext for future spans. Historical
     * ciphertext retains its original key UUID.
     */
    @JsonProperty(value = "kms_key", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> kms_key = JsonField.missing();

    @JsonProperty("kms_key")
    public JsonField<String> getKmsKey() {
      return kms_key;
    }

    public UpdateTraceSettingsRequestInput withKmsKey(JsonField<String> value) {
      this.kms_key = value;
      return this;
    }
  }

  public static final class QueryMetricsInstantQuery extends Model {
    public QueryMetricsInstantQuery() {}

    @JsonProperty(value = "metric", required = true)
    private String metric;

    @JsonProperty("metric")
    public String getMetric() {
      return metric;
    }

    public QueryMetricsInstantQuery withMetric(String value) {
      this.metric = value;
      return this;
    }

    @JsonProperty(value = "agg", required = true)
    private QueryMetricsInstantQueryAgg agg;

    @JsonProperty("agg")
    public QueryMetricsInstantQueryAgg getAgg() {
      return agg;
    }

    public QueryMetricsInstantQuery withAgg(QueryMetricsInstantQueryAgg value) {
      this.agg = value;
      return this;
    }

    @JsonProperty(value = "match[]", required = false)
    private List<String> match;

    @JsonProperty("match[]")
    public List<String> getMatch() {
      return match;
    }

    public QueryMetricsInstantQuery withMatch(List<String> value) {
      this.match = value;
      return this;
    }

    @JsonProperty(value = "by[]", required = false)
    private List<String> by;

    @JsonProperty("by[]")
    public List<String> getBy() {
      return by;
    }

    public QueryMetricsInstantQuery withBy(List<String> value) {
      this.by = value;
      return this;
    }

    @JsonProperty(value = "step", required = false)
    private String step;

    @JsonProperty("step")
    public String getStep() {
      return step;
    }

    public QueryMetricsInstantQuery withStep(String value) {
      this.step = value;
      return this;
    }

    @JsonProperty(value = "time", required = false)
    private String time;

    @JsonProperty("time")
    public String getTime() {
      return time;
    }

    public QueryMetricsInstantQuery withTime(String value) {
      this.time = value;
      return this;
    }
  }

  public static final class QueryMetricsInstantQueryAgg {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QueryMetricsInstantQueryAgg(String value) {
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
      return other instanceof QueryMetricsInstantQueryAgg v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QueryMetricsInstantQueryAgg AVG = new QueryMetricsInstantQueryAgg("avg");
    public static final QueryMetricsInstantQueryAgg SUM = new QueryMetricsInstantQueryAgg("sum");
    public static final QueryMetricsInstantQueryAgg MIN = new QueryMetricsInstantQueryAgg("min");
    public static final QueryMetricsInstantQueryAgg MAX = new QueryMetricsInstantQueryAgg("max");
    public static final QueryMetricsInstantQueryAgg COUNT =
        new QueryMetricsInstantQueryAgg("count");
    public static final QueryMetricsInstantQueryAgg LAST = new QueryMetricsInstantQueryAgg("last");
    public static final QueryMetricsInstantQueryAgg RATE = new QueryMetricsInstantQueryAgg("rate");
    public static final QueryMetricsInstantQueryAgg INCREASE =
        new QueryMetricsInstantQueryAgg("increase");
  }

  public static final class QueryMetricsInstantPostBody extends Model {
    public QueryMetricsInstantPostBody() {}

    @JsonProperty(value = "metric", required = true)
    private String metric;

    @JsonProperty("metric")
    public String getMetric() {
      return metric;
    }

    public QueryMetricsInstantPostBody withMetric(String value) {
      this.metric = value;
      return this;
    }

    @JsonProperty(value = "agg", required = true)
    private QueryMetricsInstantPostBodyAgg agg;

    @JsonProperty("agg")
    public QueryMetricsInstantPostBodyAgg getAgg() {
      return agg;
    }

    public QueryMetricsInstantPostBody withAgg(QueryMetricsInstantPostBodyAgg value) {
      this.agg = value;
      return this;
    }

    @JsonProperty(value = "match[]", required = false)
    private List<String> match;

    @JsonProperty("match[]")
    public List<String> getMatch() {
      return match;
    }

    public QueryMetricsInstantPostBody withMatch(List<String> value) {
      this.match = value;
      return this;
    }

    @JsonProperty(value = "by[]", required = false)
    private List<String> by;

    @JsonProperty("by[]")
    public List<String> getBy() {
      return by;
    }

    public QueryMetricsInstantPostBody withBy(List<String> value) {
      this.by = value;
      return this;
    }

    @JsonProperty(value = "step", required = false)
    private String step;

    @JsonProperty("step")
    public String getStep() {
      return step;
    }

    public QueryMetricsInstantPostBody withStep(String value) {
      this.step = value;
      return this;
    }

    @JsonProperty(value = "time", required = false)
    private String time;

    @JsonProperty("time")
    public String getTime() {
      return time;
    }

    public QueryMetricsInstantPostBody withTime(String value) {
      this.time = value;
      return this;
    }
  }

  public static final class QueryMetricsInstantPostBodyAgg {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QueryMetricsInstantPostBodyAgg(String value) {
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
      return other instanceof QueryMetricsInstantPostBodyAgg v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QueryMetricsInstantPostBodyAgg AVG =
        new QueryMetricsInstantPostBodyAgg("avg");
    public static final QueryMetricsInstantPostBodyAgg SUM =
        new QueryMetricsInstantPostBodyAgg("sum");
    public static final QueryMetricsInstantPostBodyAgg MIN =
        new QueryMetricsInstantPostBodyAgg("min");
    public static final QueryMetricsInstantPostBodyAgg MAX =
        new QueryMetricsInstantPostBodyAgg("max");
    public static final QueryMetricsInstantPostBodyAgg COUNT =
        new QueryMetricsInstantPostBodyAgg("count");
    public static final QueryMetricsInstantPostBodyAgg LAST =
        new QueryMetricsInstantPostBodyAgg("last");
    public static final QueryMetricsInstantPostBodyAgg RATE =
        new QueryMetricsInstantPostBodyAgg("rate");
    public static final QueryMetricsInstantPostBodyAgg INCREASE =
        new QueryMetricsInstantPostBodyAgg("increase");
  }

  public static final class QueryMetricsRangeQuery extends Model {
    public QueryMetricsRangeQuery() {}

    @JsonProperty(value = "metric", required = true)
    private String metric;

    @JsonProperty("metric")
    public String getMetric() {
      return metric;
    }

    public QueryMetricsRangeQuery withMetric(String value) {
      this.metric = value;
      return this;
    }

    @JsonProperty(value = "agg", required = true)
    private QueryMetricsRangeQueryAgg agg;

    @JsonProperty("agg")
    public QueryMetricsRangeQueryAgg getAgg() {
      return agg;
    }

    public QueryMetricsRangeQuery withAgg(QueryMetricsRangeQueryAgg value) {
      this.agg = value;
      return this;
    }

    @JsonProperty(value = "match[]", required = false)
    private List<String> match;

    @JsonProperty("match[]")
    public List<String> getMatch() {
      return match;
    }

    public QueryMetricsRangeQuery withMatch(List<String> value) {
      this.match = value;
      return this;
    }

    @JsonProperty(value = "by[]", required = false)
    private List<String> by;

    @JsonProperty("by[]")
    public List<String> getBy() {
      return by;
    }

    public QueryMetricsRangeQuery withBy(List<String> value) {
      this.by = value;
      return this;
    }

    @JsonProperty(value = "start", required = true)
    private String start;

    @JsonProperty("start")
    public String getStart() {
      return start;
    }

    public QueryMetricsRangeQuery withStart(String value) {
      this.start = value;
      return this;
    }

    @JsonProperty(value = "end", required = true)
    private String end;

    @JsonProperty("end")
    public String getEnd() {
      return end;
    }

    public QueryMetricsRangeQuery withEnd(String value) {
      this.end = value;
      return this;
    }

    @JsonProperty(value = "step", required = false)
    private String step;

    @JsonProperty("step")
    public String getStep() {
      return step;
    }

    public QueryMetricsRangeQuery withStep(String value) {
      this.step = value;
      return this;
    }
  }

  public static final class QueryMetricsRangeQueryAgg {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QueryMetricsRangeQueryAgg(String value) {
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
      return other instanceof QueryMetricsRangeQueryAgg v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QueryMetricsRangeQueryAgg AVG = new QueryMetricsRangeQueryAgg("avg");
    public static final QueryMetricsRangeQueryAgg SUM = new QueryMetricsRangeQueryAgg("sum");
    public static final QueryMetricsRangeQueryAgg MIN = new QueryMetricsRangeQueryAgg("min");
    public static final QueryMetricsRangeQueryAgg MAX = new QueryMetricsRangeQueryAgg("max");
    public static final QueryMetricsRangeQueryAgg COUNT = new QueryMetricsRangeQueryAgg("count");
    public static final QueryMetricsRangeQueryAgg LAST = new QueryMetricsRangeQueryAgg("last");
    public static final QueryMetricsRangeQueryAgg RATE = new QueryMetricsRangeQueryAgg("rate");
    public static final QueryMetricsRangeQueryAgg INCREASE =
        new QueryMetricsRangeQueryAgg("increase");
  }

  public static final class QueryMetricsRangePostBody extends Model {
    public QueryMetricsRangePostBody() {}

    @JsonProperty(value = "metric", required = true)
    private String metric;

    @JsonProperty("metric")
    public String getMetric() {
      return metric;
    }

    public QueryMetricsRangePostBody withMetric(String value) {
      this.metric = value;
      return this;
    }

    @JsonProperty(value = "agg", required = true)
    private QueryMetricsRangePostBodyAgg agg;

    @JsonProperty("agg")
    public QueryMetricsRangePostBodyAgg getAgg() {
      return agg;
    }

    public QueryMetricsRangePostBody withAgg(QueryMetricsRangePostBodyAgg value) {
      this.agg = value;
      return this;
    }

    @JsonProperty(value = "match[]", required = false)
    private List<String> match;

    @JsonProperty("match[]")
    public List<String> getMatch() {
      return match;
    }

    public QueryMetricsRangePostBody withMatch(List<String> value) {
      this.match = value;
      return this;
    }

    @JsonProperty(value = "by[]", required = false)
    private List<String> by;

    @JsonProperty("by[]")
    public List<String> getBy() {
      return by;
    }

    public QueryMetricsRangePostBody withBy(List<String> value) {
      this.by = value;
      return this;
    }

    @JsonProperty(value = "start", required = true)
    private String start;

    @JsonProperty("start")
    public String getStart() {
      return start;
    }

    public QueryMetricsRangePostBody withStart(String value) {
      this.start = value;
      return this;
    }

    @JsonProperty(value = "end", required = true)
    private String end;

    @JsonProperty("end")
    public String getEnd() {
      return end;
    }

    public QueryMetricsRangePostBody withEnd(String value) {
      this.end = value;
      return this;
    }

    @JsonProperty(value = "step", required = false)
    private String step;

    @JsonProperty("step")
    public String getStep() {
      return step;
    }

    public QueryMetricsRangePostBody withStep(String value) {
      this.step = value;
      return this;
    }
  }

  public static final class QueryMetricsRangePostBodyAgg {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QueryMetricsRangePostBodyAgg(String value) {
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
      return other instanceof QueryMetricsRangePostBodyAgg v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QueryMetricsRangePostBodyAgg AVG = new QueryMetricsRangePostBodyAgg("avg");
    public static final QueryMetricsRangePostBodyAgg SUM = new QueryMetricsRangePostBodyAgg("sum");
    public static final QueryMetricsRangePostBodyAgg MIN = new QueryMetricsRangePostBodyAgg("min");
    public static final QueryMetricsRangePostBodyAgg MAX = new QueryMetricsRangePostBodyAgg("max");
    public static final QueryMetricsRangePostBodyAgg COUNT =
        new QueryMetricsRangePostBodyAgg("count");
    public static final QueryMetricsRangePostBodyAgg LAST =
        new QueryMetricsRangePostBodyAgg("last");
    public static final QueryMetricsRangePostBodyAgg RATE =
        new QueryMetricsRangePostBodyAgg("rate");
    public static final QueryMetricsRangePostBodyAgg INCREASE =
        new QueryMetricsRangePostBodyAgg("increase");
  }

  public static final class SearchLogsQuery extends Model {
    public SearchLogsQuery() {}

    @JsonProperty(value = "from", required = true)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    public SearchLogsQuery withFrom(String value) {
      this.from = value;
      return this;
    }

    @JsonProperty(value = "to", required = true)
    private String to;

    @JsonProperty("to")
    public String getTo() {
      return to;
    }

    public SearchLogsQuery withTo(String value) {
      this.to = value;
      return this;
    }

    @JsonProperty(value = "log_group", required = false)
    private String log_group;

    @JsonProperty("log_group")
    public String getLogGroup() {
      return log_group;
    }

    public SearchLogsQuery withLogGroup(String value) {
      this.log_group = value;
      return this;
    }

    @JsonProperty(value = "log_stream", required = false)
    private String log_stream;

    @JsonProperty("log_stream")
    public String getLogStream() {
      return log_stream;
    }

    public SearchLogsQuery withLogStream(String value) {
      this.log_stream = value;
      return this;
    }

    @JsonProperty(value = "min_severity", required = false)
    private SearchLogsQueryMinSeverity min_severity;

    @JsonProperty("min_severity")
    public SearchLogsQueryMinSeverity getMinSeverity() {
      return min_severity;
    }

    public SearchLogsQuery withMinSeverity(SearchLogsQueryMinSeverity value) {
      this.min_severity = value;
      return this;
    }

    @JsonProperty(value = "region", required = false)
    private String region;

    @JsonProperty("region")
    public String getRegion() {
      return region;
    }

    public SearchLogsQuery withRegion(String value) {
      this.region = value;
      return this;
    }

    @JsonProperty(value = "q", required = false)
    private String q;

    @JsonProperty("q")
    public String getQ() {
      return q;
    }

    public SearchLogsQuery withQ(String value) {
      this.q = value;
      return this;
    }

    @JsonProperty(value = "trace_id", required = false)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    public SearchLogsQuery withTraceId(String value) {
      this.trace_id = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public SearchLogsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public SearchLogsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class SearchLogsQueryMinSeverity {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SearchLogsQueryMinSeverity(String value) {
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
      return other instanceof SearchLogsQueryMinSeverity v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SearchLogsQueryMinSeverity TRACE = new SearchLogsQueryMinSeverity("TRACE");
    public static final SearchLogsQueryMinSeverity DEBUG = new SearchLogsQueryMinSeverity("DEBUG");
    public static final SearchLogsQueryMinSeverity INFO = new SearchLogsQueryMinSeverity("INFO");
    public static final SearchLogsQueryMinSeverity WARN = new SearchLogsQueryMinSeverity("WARN");
    public static final SearchLogsQueryMinSeverity ERROR = new SearchLogsQueryMinSeverity("ERROR");
    public static final SearchLogsQueryMinSeverity FATAL = new SearchLogsQueryMinSeverity("FATAL");
  }

  public static final class LogListResponse extends Model {
    public LogListResponse() {}

    @JsonProperty(value = "logs", required = false)
    private List<LogRecord> logs;

    @JsonProperty("logs")
    public List<LogRecord> getLogs() {
      return logs;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class SearchTracesQuery extends Model {
    public SearchTracesQuery() {}

    @JsonProperty(value = "from", required = true)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    public SearchTracesQuery withFrom(String value) {
      this.from = value;
      return this;
    }

    @JsonProperty(value = "to", required = true)
    private String to;

    @JsonProperty("to")
    public String getTo() {
      return to;
    }

    public SearchTracesQuery withTo(String value) {
      this.to = value;
      return this;
    }

    @JsonProperty(value = "service", required = false)
    private String service;

    @JsonProperty("service")
    public String getService() {
      return service;
    }

    public SearchTracesQuery withService(String value) {
      this.service = value;
      return this;
    }

    @JsonProperty(value = "operation", required = false)
    private String operation;

    @JsonProperty("operation")
    public String getOperation() {
      return operation;
    }

    public SearchTracesQuery withOperation(String value) {
      this.operation = value;
      return this;
    }

    @JsonProperty(value = "status_code", required = false)
    private SearchTracesQueryStatusCode status_code;

    @JsonProperty("status_code")
    public SearchTracesQueryStatusCode getStatusCode() {
      return status_code;
    }

    public SearchTracesQuery withStatusCode(SearchTracesQueryStatusCode value) {
      this.status_code = value;
      return this;
    }

    @JsonProperty(value = "min_duration_ms", required = false)
    private BigDecimal min_duration_ms;

    @JsonProperty("min_duration_ms")
    public BigDecimal getMinDurationMs() {
      return min_duration_ms;
    }

    public SearchTracesQuery withMinDurationMs(BigDecimal value) {
      this.min_duration_ms = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public SearchTracesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public SearchTracesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class SearchTracesQueryStatusCode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SearchTracesQueryStatusCode(String value) {
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
      return other instanceof SearchTracesQueryStatusCode v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SearchTracesQueryStatusCode UNSET =
        new SearchTracesQueryStatusCode("UNSET");
    public static final SearchTracesQueryStatusCode OK = new SearchTracesQueryStatusCode("OK");
    public static final SearchTracesQueryStatusCode ERROR =
        new SearchTracesQueryStatusCode("ERROR");
  }

  public static final class TraceListResponse extends Model {
    public TraceListResponse() {}

    @JsonProperty(value = "traces", required = false)
    private List<TraceSummary> traces;

    @JsonProperty("traces")
    public List<TraceSummary> getTraces() {
      return traces;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class TraceSummary extends Model {
    public TraceSummary() {}

    @JsonProperty(value = "trace_id", required = false)
    private String trace_id;

    @JsonProperty("trace_id")
    public String getTraceId() {
      return trace_id;
    }

    @JsonProperty(value = "root_span_id", required = false)
    private String root_span_id;

    @JsonProperty("root_span_id")
    public String getRootSpanId() {
      return root_span_id;
    }

    @JsonProperty(value = "root_name", required = false)
    private String root_name;

    @JsonProperty("root_name")
    public String getRootName() {
      return root_name;
    }

    @JsonProperty(value = "root_service", required = false)
    private String root_service;

    @JsonProperty("root_service")
    public String getRootService() {
      return root_service;
    }

    @JsonProperty(value = "start_time", required = false)
    private String start_time;

    @JsonProperty("start_time")
    public String getStartTime() {
      return start_time;
    }

    @JsonProperty(value = "duration_ms", required = false)
    private BigDecimal duration_ms;

    @JsonProperty("duration_ms")
    public BigDecimal getDurationMs() {
      return duration_ms;
    }

    @JsonProperty(value = "span_count", required = false)
    private Long span_count;

    @JsonProperty("span_count")
    public Long getSpanCount() {
      return span_count;
    }

    @JsonProperty(value = "error_count", required = false)
    private Long error_count;

    @JsonProperty("error_count")
    public Long getErrorCount() {
      return error_count;
    }

    @JsonProperty(value = "service_count", required = false)
    private Long service_count;

    @JsonProperty("service_count")
    public Long getServiceCount() {
      return service_count;
    }
  }

  public static final class UpdateLogGroupRequestInput extends Model {
    public UpdateLogGroupRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public UpdateLogGroupRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    /** 1..3650; pass clear_retention to switch to never expire */
    @JsonProperty(value = "retention_days", required = false)
    private Long retention_days;

    @JsonProperty("retention_days")
    public Long getRetentionDays() {
      return retention_days;
    }

    public UpdateLogGroupRequestInput withRetentionDays(Long value) {
      this.retention_days = value;
      return this;
    }

    /** When true, sets retention to never-expire (ignores retention_days) */
    @JsonProperty(value = "clear_retention", required = false)
    private Boolean clear_retention;

    @JsonProperty("clear_retention")
    public Boolean getClearRetention() {
      return clear_retention;
    }

    public UpdateLogGroupRequestInput withClearRetention(Boolean value) {
      this.clear_retention = value;
      return this;
    }

    /**
     * KMS key UUID, CRN or exact name in the authenticated account and serving region. Omission
     * preserves the pinned UUID; an empty string clears encryption for future records. Unavailable
     * key metadata does not clear the binding.
     */
    @JsonProperty(value = "kms_key", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> kms_key = JsonField.missing();

    @JsonProperty("kms_key")
    public JsonField<String> getKmsKey() {
      return kms_key;
    }

    public UpdateLogGroupRequestInput withKmsKey(JsonField<String> value) {
      this.kms_key = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateLogGroupRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }
}
