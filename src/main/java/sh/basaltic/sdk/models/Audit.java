package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed audit wire models. Unknown string enum values are retained. */
public final class Audit {

  private Audit() {}

  public static final class AuditLogResponse extends Model {
    public AuditLogResponse() {}

    @JsonProperty(value = "audit_log", required = false)
    private AuditLog audit_log;

    @JsonProperty("audit_log")
    public AuditLog getAuditLog() {
      return audit_log;
    }
  }

  public static final class AuditLog extends Model {
    public AuditLog() {}

    /** Canonical event identity, scoped to the authenticated organization. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** When the event occurred */
    @JsonProperty(value = "timestamp", required = false)
    private String timestamp;

    @JsonProperty("timestamp")
    public String getTimestamp() {
      return timestamp;
    }

    /**
     * Immutable event-time actor identity. Null for historical entries without a snapshot.
     * Authenticated user events use crn:workspace:::user/&lt;username&gt;, with the user UUID as a
     * fallback when a username is unavailable; service accounts use
     * crn:iam::&lt;account-handle&gt;:service-account/&lt;name&gt;; assumed roles use
     * crn:iam::&lt;account-handle&gt;:role/&lt;name&gt;, with the session identity in
     * details.actor_session_crn and verified ancestry in details.auth_chain. Federated assumptions
     * identify the verified provider in actor_crn and the verified subject in actor_name and
     * details.auth_chain. Historical entries retain their original CRNs, including legacy IAM
     * organization identities. System actors use crn:iam::platform:system/&lt;service&gt;, with
     * service names certificate, registry, secrets, queue, notifications and email.
     */
    @JsonProperty(value = "actor_crn", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> actor_crn = JsonField.missing();

    @JsonProperty("actor_crn")
    public JsonField<String> getActorCrn() {
      return actor_crn;
    }

    /**
     * Immutable event-time resource identity. Null for historical entries without a snapshot and
     * enumerated events whose target cannot be identified from event-time data, such as an
     * unknown-email password reset or a lookup that never resolved a row. A known target UUID is
     * retained in details.resource_id; it is never substituted for the immutable name in a CRN.
     * AssumeRole and AssumeRoleWithWebIdentity target the role being assumed. GetToken targets the
     * authenticated service account. These authentication events record the resulting session in
     * details.session_crn.
     */
    @JsonProperty(value = "resource_crn", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> resource_crn = JsonField.missing();

    @JsonProperty("resource_crn")
    public JsonField<String> getResourceCrn() {
      return resource_crn;
    }

    /** Name of the actor at the time of the event */
    @JsonProperty(value = "actor_name", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> actor_name = JsonField.missing();

    @JsonProperty("actor_name")
    public JsonField<String> getActorName() {
      return actor_name;
    }

    /** Email of the actor (for users only) */
    @JsonProperty(value = "actor_email", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> actor_email = JsonField.missing();

    @JsonProperty("actor_email")
    public JsonField<String> getActorEmail() {
      return actor_email;
    }

    /** The action performed (e.g., "iam.policy.create", "instance.start") */
    @JsonProperty(value = "action", required = false)
    private String action;

    @JsonProperty("action")
    public String getAction() {
      return action;
    }

    /** Outcome of the action */
    @JsonProperty(value = "status", required = false)
    private AuditLogStatus status;

    @JsonProperty("status")
    public AuditLogStatus getStatus() {
      return status;
    }

    /** Name of the resource at the time of the event */
    @JsonProperty(value = "resource_name", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> resource_name = JsonField.missing();

    @JsonProperty("resource_name")
    public JsonField<String> getResourceName() {
      return resource_name;
    }

    /** IP address of the request origin */
    @JsonProperty(value = "ip_address", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> ip_address = JsonField.missing();

    @JsonProperty("ip_address")
    public JsonField<String> getIpAddress() {
      return ip_address;
    }

    /** User agent string from the request */
    @JsonProperty(value = "user_agent", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> user_agent = JsonField.missing();

    @JsonProperty("user_agent")
    public JsonField<String> getUserAgent() {
      return user_agent;
    }

    /** Request ID for correlation */
    @JsonProperty(value = "request_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> request_id = JsonField.missing();

    @JsonProperty("request_id")
    public JsonField<String> getRequestId() {
      return request_id;
    }

    /**
     * Additional action-specific details. For assumed-role actors, actor_session_crn records
     * crn:iam::&lt;account-handle&gt;:sts-session/&lt;id&gt; to correlate the event with its
     * AssumeRole call. auth_chain is an immutable snapshot of verified identities, ordered from the
     * original user, service account or workload through every assumed role to the effective actor.
     * It contains identifiers and session metadata, never credentials. Historical events without
     * recorded ancestry omit auth_chain; reads do not reconstruct it from current sessions or
     * identities. Authentication grants include session_id, session_crn, grant_type and expires_at.
     * A federated origin includes its verified issuer and subject independently of the
     * caller-supplied session name. Initiated background work retains the original audit
     * attribution and request correlation.
     */
    @JsonProperty(value = "details", required = false)
    private AuditLogDetails details;

    @JsonProperty("details")
    public AuditLogDetails getDetails() {
      return details;
    }

    /** Error code for failed actions */
    @JsonProperty(value = "error_code", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> error_code = JsonField.missing();

    @JsonProperty("error_code")
    public JsonField<String> getErrorCode() {
      return error_code;
    }

    /** Error message for failed actions */
    @JsonProperty(value = "error_message", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> error_message = JsonField.missing();

    @JsonProperty("error_message")
    public JsonField<String> getErrorMessage() {
      return error_message;
    }
  }

  public static final class AuditLogStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AuditLogStatus(String value) {
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
      return other instanceof AuditLogStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AuditLogStatus SUCCESS = new AuditLogStatus("success");
    public static final AuditLogStatus FAILURE = new AuditLogStatus("failure");
    public static final AuditLogStatus DENIED = new AuditLogStatus("denied");
  }

  public static final class AuditLogDetails extends Model {
    public AuditLogDetails() {}

    @JsonProperty(value = "auth_chain", required = false)
    private List<AuditAuthenticationStep> auth_chain;

    @JsonProperty("auth_chain")
    public List<AuditAuthenticationStep> getAuthChain() {
      return auth_chain;
    }
  }

  public static final class AuditAuthenticationStep extends Model {
    public AuditAuthenticationStep() {}

    /**
     * Stable principal UUID. For a federated workload this is derived from its verified issuer and
     * subject.
     */
    @JsonProperty(value = "principal_id", required = true)
    private String principal_id;

    @JsonProperty("principal_id")
    public String getPrincipalId() {
      return principal_id;
    }

    /** Identity kind, such as user, service_account, assumed_role, instance or web_identity. */
    @JsonProperty(value = "principal_type", required = true)
    private String principal_type;

    @JsonProperty("principal_type")
    public String getPrincipalType() {
      return principal_type;
    }

    /** Recorded principal identity; for web identity this identifies the verified provider. */
    @JsonProperty(value = "principal_crn", required = false)
    private String principal_crn;

    @JsonProperty("principal_crn")
    public String getPrincipalCrn() {
      return principal_crn;
    }

    /** Display name captured when the request was authenticated, when available. */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /** Verified issuer of the originating web identity token, when applicable. */
    @JsonProperty(value = "issuer", required = false)
    private String issuer;

    @JsonProperty("issuer")
    public String getIssuer() {
      return issuer;
    }

    /** Verified subject of the originating web identity token, independent of the session label. */
    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    /** User email captured when the request was authenticated, when available. */
    @JsonProperty(value = "email", required = false)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    @JsonProperty(value = "session_id", required = false)
    private String session_id;

    @JsonProperty("session_id")
    public String getSessionId() {
      return session_id;
    }

    /** Account-qualified STS session identity, when applicable. */
    @JsonProperty(value = "session_crn", required = false)
    private String session_crn;

    @JsonProperty("session_crn")
    public String getSessionCrn() {
      return session_crn;
    }

    /** Caller-supplied session label, not proof of identity. */
    @JsonProperty(value = "session_name", required = false)
    private String session_name;

    @JsonProperty("session_name")
    public String getSessionName() {
      return session_name;
    }

    /**
     * How this session was issued, such as assume_role, client_credentials, imds or web_identity.
     */
    @JsonProperty(value = "grant_type", required = false)
    private String grant_type;

    @JsonProperty("grant_type")
    public String getGrantType() {
      return grant_type;
    }

    /** When this session was created. */
    @JsonProperty(value = "issued_at", required = false)
    private String issued_at;

    @JsonProperty("issued_at")
    public String getIssuedAt() {
      return issued_at;
    }
  }

  public static final class GetAuditLogScope extends Model {
    public GetAuditLogScope() {}

    @JsonProperty(value = "actor", required = false)
    private String actor;

    @JsonProperty("actor")
    public String getActor() {
      return actor;
    }

    public GetAuditLogScope withActor(String value) {
      this.actor = value;
      return this;
    }

    @JsonProperty(value = "actor_type", required = false)
    private GetAuditLogScopeActorType actor_type;

    @JsonProperty("actor_type")
    public GetAuditLogScopeActorType getActorType() {
      return actor_type;
    }

    public GetAuditLogScope withActorType(GetAuditLogScopeActorType value) {
      this.actor_type = value;
      return this;
    }

    @JsonProperty(value = "action", required = false)
    private String action;

    @JsonProperty("action")
    public String getAction() {
      return action;
    }

    public GetAuditLogScope withAction(String value) {
      this.action = value;
      return this;
    }

    @JsonProperty(value = "resource_type", required = false)
    private String resource_type;

    @JsonProperty("resource_type")
    public String getResourceType() {
      return resource_type;
    }

    public GetAuditLogScope withResourceType(String value) {
      this.resource_type = value;
      return this;
    }

    @JsonProperty(value = "resource", required = false)
    private String resource;

    @JsonProperty("resource")
    public String getResource() {
      return resource;
    }

    public GetAuditLogScope withResource(String value) {
      this.resource = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private GetAuditLogScopeStatus status;

    @JsonProperty("status")
    public GetAuditLogScopeStatus getStatus() {
      return status;
    }

    public GetAuditLogScope withStatus(GetAuditLogScopeStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "ip_address", required = false)
    private String ip_address;

    @JsonProperty("ip_address")
    public String getIpAddress() {
      return ip_address;
    }

    public GetAuditLogScope withIpAddress(String value) {
      this.ip_address = value;
      return this;
    }

    @JsonProperty(value = "from", required = false)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    public GetAuditLogScope withFrom(String value) {
      this.from = value;
      return this;
    }

    @JsonProperty(value = "to", required = false)
    private String to;

    @JsonProperty("to")
    public String getTo() {
      return to;
    }

    public GetAuditLogScope withTo(String value) {
      this.to = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetAuditLogScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetAuditLogScopeActorType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GetAuditLogScopeActorType(String value) {
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
      return other instanceof GetAuditLogScopeActorType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final GetAuditLogScopeActorType USER = new GetAuditLogScopeActorType("user");
    public static final GetAuditLogScopeActorType SERVICE_ACCOUNT =
        new GetAuditLogScopeActorType("service_account");
    public static final GetAuditLogScopeActorType SYSTEM = new GetAuditLogScopeActorType("system");
  }

  public static final class GetAuditLogScopeStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GetAuditLogScopeStatus(String value) {
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
      return other instanceof GetAuditLogScopeStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final GetAuditLogScopeStatus SUCCESS = new GetAuditLogScopeStatus("success");
    public static final GetAuditLogScopeStatus FAILURE = new GetAuditLogScopeStatus("failure");
    public static final GetAuditLogScopeStatus DENIED = new GetAuditLogScopeStatus("denied");
  }

  public static final class ListAuditLogsQuery extends Model {
    public ListAuditLogsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListAuditLogsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "actor", required = false)
    private String actor;

    @JsonProperty("actor")
    public String getActor() {
      return actor;
    }

    public ListAuditLogsQuery withActor(String value) {
      this.actor = value;
      return this;
    }

    @JsonProperty(value = "actor_type", required = false)
    private ListAuditLogsQueryActorType actor_type;

    @JsonProperty("actor_type")
    public ListAuditLogsQueryActorType getActorType() {
      return actor_type;
    }

    public ListAuditLogsQuery withActorType(ListAuditLogsQueryActorType value) {
      this.actor_type = value;
      return this;
    }

    @JsonProperty(value = "action", required = false)
    private String action;

    @JsonProperty("action")
    public String getAction() {
      return action;
    }

    public ListAuditLogsQuery withAction(String value) {
      this.action = value;
      return this;
    }

    @JsonProperty(value = "resource_type", required = false)
    private String resource_type;

    @JsonProperty("resource_type")
    public String getResourceType() {
      return resource_type;
    }

    public ListAuditLogsQuery withResourceType(String value) {
      this.resource_type = value;
      return this;
    }

    @JsonProperty(value = "resource", required = false)
    private String resource;

    @JsonProperty("resource")
    public String getResource() {
      return resource;
    }

    public ListAuditLogsQuery withResource(String value) {
      this.resource = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private ListAuditLogsQueryStatus status;

    @JsonProperty("status")
    public ListAuditLogsQueryStatus getStatus() {
      return status;
    }

    public ListAuditLogsQuery withStatus(ListAuditLogsQueryStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "ip_address", required = false)
    private String ip_address;

    @JsonProperty("ip_address")
    public String getIpAddress() {
      return ip_address;
    }

    public ListAuditLogsQuery withIpAddress(String value) {
      this.ip_address = value;
      return this;
    }

    @JsonProperty(value = "from", required = false)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    public ListAuditLogsQuery withFrom(String value) {
      this.from = value;
      return this;
    }

    @JsonProperty(value = "to", required = false)
    private String to;

    @JsonProperty("to")
    public String getTo() {
      return to;
    }

    public ListAuditLogsQuery withTo(String value) {
      this.to = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListAuditLogsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListAuditLogsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ListAuditLogsQueryActorType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListAuditLogsQueryActorType(String value) {
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
      return other instanceof ListAuditLogsQueryActorType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListAuditLogsQueryActorType USER = new ListAuditLogsQueryActorType("user");
    public static final ListAuditLogsQueryActorType SERVICE_ACCOUNT =
        new ListAuditLogsQueryActorType("service_account");
    public static final ListAuditLogsQueryActorType SYSTEM =
        new ListAuditLogsQueryActorType("system");
  }

  public static final class ListAuditLogsQueryStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListAuditLogsQueryStatus(String value) {
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
      return other instanceof ListAuditLogsQueryStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListAuditLogsQueryStatus SUCCESS = new ListAuditLogsQueryStatus("success");
    public static final ListAuditLogsQueryStatus FAILURE = new ListAuditLogsQueryStatus("failure");
    public static final ListAuditLogsQueryStatus DENIED = new ListAuditLogsQueryStatus("denied");
  }

  public static final class AuditLogListResponse extends Model {
    public AuditLogListResponse() {}

    @JsonProperty(value = "audit_logs", required = false)
    private List<AuditLog> audit_logs;

    @JsonProperty("audit_logs")
    public List<AuditLog> getAuditLogs() {
      return audit_logs;
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
}
