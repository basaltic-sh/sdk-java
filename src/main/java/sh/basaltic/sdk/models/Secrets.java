package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed secrets wire models. Unknown string enum values are retained. */
public final class Secrets {

  private Secrets() {}

  public static final class CreateSecretRequestInput extends Model {
    public CreateSecretRequestInput() {}

    /**
     * Unique within the calling account. Resource names must not start with the literal crn: prefix
     * or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateSecretRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public CreateSecretRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateSecretRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /** Base64 of the initial value bytes (1 byte - 64 KiB). */
    @JsonProperty(value = "value", required = true)
    private String value;

    @JsonProperty("value")
    public String getValue() {
      return value;
    }

    public CreateSecretRequestInput withValue(String value) {
      this.value = value;
      return this;
    }

    @JsonProperty(value = "recovery_window_days", required = false)
    private Long recovery_window_days;

    @JsonProperty("recovery_window_days")
    public Long getRecoveryWindowDays() {
      return recovery_window_days;
    }

    public CreateSecretRequestInput withRecoveryWindowDays(Long value) {
      this.recovery_window_days = value;
      return this;
    }

    /**
     * UUID, CRN or account-scoped name of a customer-managed KMS key to encrypt this secret under.
     * Omit to use the platform-managed default key. The key must be enabled and have
     * encrypt/decrypt usage.
     */
    @JsonProperty(value = "kms_key", required = false)
    private String kms_key;

    @JsonProperty("kms_key")
    public String getKmsKey() {
      return kms_key;
    }

    public CreateSecretRequestInput withKmsKey(String value) {
      this.kms_key = value;
      return this;
    }
  }

  public static final class SecretResponse extends Model {
    public SecretResponse() {}

    @JsonProperty(value = "secret", required = true)
    private Secret secret;

    @JsonProperty("secret")
    public Secret getSecret() {
      return secret;
    }
  }

  public static final class Secret extends Model {
    public Secret() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
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

    /**
     * Customer-managed KMS key the secret is encrypted under. Omitted for platform encryption or
     * when kms_key_unavailable is true.
     */
    @JsonProperty(value = "kms_key_crn", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> kms_key_crn = JsonField.missing();

    @JsonProperty("kms_key_crn")
    public JsonField<String> getKmsKeyCrn() {
      return kms_key_crn;
    }

    /**
     * True when a platform service generated this value and reads it back to act on. You can read
     * and delete a managed secret, but UpdateSecret and PutSecretValue answer 403
     * SECRET_PLATFORM_MANAGED.
     */
    @JsonProperty(value = "managed", required = true)
    private Boolean managed;

    @JsonProperty("managed")
    public Boolean getManaged() {
      return managed;
    }

    @JsonProperty(value = "deleted_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> deleted_at = JsonField.missing();

    @JsonProperty("deleted_at")
    public JsonField<String> getDeletedAt() {
      return deleted_at;
    }

    @JsonProperty(value = "scheduled_purge_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> scheduled_purge_at = JsonField.missing();

    @JsonProperty("scheduled_purge_at")
    public JsonField<String> getScheduledPurgeAt() {
      return scheduled_purge_at;
    }

    /** Whole-day recovery window. */
    @JsonProperty(value = "recovery_window_days", required = true)
    private Long recovery_window_days;

    @JsonProperty("recovery_window_days")
    public Long getRecoveryWindowDays() {
      return recovery_window_days;
    }

    /** 0 if no version exists yet. */
    @JsonProperty(value = "current_version", required = false)
    private Long current_version;

    @JsonProperty("current_version")
    public Long getCurrentVersion() {
      return current_version;
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

  public static final class DeleteSecretRequestInput extends Model {
    public DeleteSecretRequestInput() {}

    /** Override the secret's stored window. Omit to keep it. */
    @JsonProperty(value = "recovery_window_days", required = false)
    private Long recovery_window_days;

    @JsonProperty("recovery_window_days")
    public Long getRecoveryWindowDays() {
      return recovery_window_days;
    }

    public DeleteSecretRequestInput withRecoveryWindowDays(Long value) {
      this.recovery_window_days = value;
      return this;
    }
  }

  public static final class GetSecretValueQuery extends Model {
    public GetSecretValueQuery() {}

    @JsonProperty(value = "version", required = false)
    private Long version;

    @JsonProperty("version")
    public Long getVersion() {
      return version;
    }

    public GetSecretValueQuery withVersion(Long value) {
      this.version = value;
      return this;
    }
  }

  public static final class SecretValueResponse extends Model {
    public SecretValueResponse() {}

    @JsonProperty(value = "secret", required = true)
    private SecretValue secret;

    @JsonProperty("secret")
    public SecretValue getSecret() {
      return secret;
    }
  }

  public static final class SecretValue extends Model {
    public SecretValue() {}

    @JsonProperty(value = "secret_id", required = true)
    private String secret_id;

    @JsonProperty("secret_id")
    public String getSecretId() {
      return secret_id;
    }

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

    @JsonProperty(value = "version", required = true)
    private Long version;

    @JsonProperty("version")
    public Long getVersion() {
      return version;
    }

    /** Base64 of the plaintext bytes. */
    @JsonProperty(value = "value", required = true)
    private String value;

    @JsonProperty("value")
    public String getValue() {
      return value;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class ListSecretsQuery extends Model {
    public ListSecretsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListSecretsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSecretsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "include_deleted", required = false)
    private Boolean include_deleted;

    @JsonProperty("include_deleted")
    public Boolean getIncludeDeleted() {
      return include_deleted;
    }

    public ListSecretsQuery withIncludeDeleted(Boolean value) {
      this.include_deleted = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSecretsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSecretsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class SecretListResponse extends Model {
    public SecretListResponse() {}

    @JsonProperty(value = "secrets", required = true)
    private List<Secret> secrets;

    @JsonProperty("secrets")
    public List<Secret> getSecrets() {
      return secrets;
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

  public static final class ListVersionsQuery extends Model {
    public ListVersionsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListVersionsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListVersionsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListVersionsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class VersionListResponse extends Model {
    public VersionListResponse() {}

    @JsonProperty(value = "versions", required = true)
    private List<SecretVersion> versions;

    @JsonProperty("versions")
    public List<SecretVersion> getVersions() {
      return versions;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class SecretVersion extends Model {
    public SecretVersion() {}

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

    @JsonProperty(value = "version", required = true)
    private Long version;

    @JsonProperty("version")
    public Long getVersion() {
      return version;
    }

    @JsonProperty(value = "is_current", required = true)
    private Boolean is_current;

    @JsonProperty("is_current")
    public Boolean getIsCurrent() {
      return is_current;
    }

    /**
     * CRN of the principal that created this version (e.g. crn:iam:::user/&lt;id&gt;,
     * crn:iam:::service-account/&lt;id&gt;).
     */
    @JsonProperty(value = "created_by", required = false)
    private String created_by;

    @JsonProperty("created_by")
    public String getCreatedBy() {
      return created_by;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class PutSecretValueRequestInput extends Model {
    public PutSecretValueRequestInput() {}

    /** Base64 of the new value bytes (1 byte - 64 KiB). */
    @JsonProperty(value = "value", required = true)
    private String value;

    @JsonProperty("value")
    public String getValue() {
      return value;
    }

    public PutSecretValueRequestInput withValue(String value) {
      this.value = value;
      return this;
    }
  }

  public static final class VersionResponse extends Model {
    public VersionResponse() {}

    @JsonProperty(value = "version", required = true)
    private SecretVersion version;

    @JsonProperty("version")
    public SecretVersion getVersion() {
      return version;
    }
  }

  public static final class UpdateSecretRequestInput extends Model {
    public UpdateSecretRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public UpdateSecretRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateSecretRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }
}
