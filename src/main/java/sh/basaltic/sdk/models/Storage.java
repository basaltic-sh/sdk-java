package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

/** Typed storage wire models. Unknown string enum values are retained. */
public final class Storage {

  private Storage() {}

  public static final class CompleteMultipartUploadRequestInput extends Model {
    public CompleteMultipartUploadRequestInput() {}

    /**
     * Every part the assembled object is made of, in ascending part_number order. Each etag must
     * match the one that part's upload returned.
     */
    @JsonProperty(value = "parts", required = true)
    private List<CompleteMultipartUploadRequestInputPartsItem> parts;

    @JsonProperty("parts")
    public List<CompleteMultipartUploadRequestInputPartsItem> getParts() {
      return parts;
    }

    public CompleteMultipartUploadRequestInput withParts(
        List<CompleteMultipartUploadRequestInputPartsItem> value) {
      this.parts = value;
      return this;
    }
  }

  public static final class CompleteMultipartUploadRequestInputPartsItem extends Model {
    public CompleteMultipartUploadRequestInputPartsItem() {}

    @JsonProperty(value = "part_number", required = true)
    private Long part_number;

    @JsonProperty("part_number")
    public Long getPartNumber() {
      return part_number;
    }

    public CompleteMultipartUploadRequestInputPartsItem withPartNumber(Long value) {
      this.part_number = value;
      return this;
    }

    @JsonProperty(value = "etag", required = true)
    private String etag;

    @JsonProperty("etag")
    public String getEtag() {
      return etag;
    }

    public CompleteMultipartUploadRequestInputPartsItem withEtag(String value) {
      this.etag = value;
      return this;
    }
  }

  public static final class CompleteMultipartUploadResponse extends Model {
    public CompleteMultipartUploadResponse() {}

    @JsonProperty(value = "etag", required = true)
    private String etag;

    @JsonProperty("etag")
    public String getEtag() {
      return etag;
    }

    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonProperty("size")
    public Long getSize() {
      return size;
    }

    @JsonProperty(value = "version_id", required = false)
    private String version_id;

    @JsonProperty("version_id")
    public String getVersionId() {
      return version_id;
    }

    @JsonProperty(value = "storage_class", required = false)
    private String storage_class;

    @JsonProperty("storage_class")
    public String getStorageClass() {
      return storage_class;
    }
  }

  public static final class CreateBucketRequestInput extends Model {
    public CreateBucketRequestInput() {}

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

    public CreateBucketRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    /**
     * When true, enables S3 Object Lock on the bucket at creation time and turns versioning on.
     * Object Lock cannot be enabled later.
     */
    @JsonProperty(value = "object_lock_enabled", required = false)
    private Boolean object_lock_enabled;

    @JsonProperty("object_lock_enabled")
    public Boolean getObjectLockEnabled() {
      return object_lock_enabled;
    }

    public CreateBucketRequestInput withObjectLockEnabled(Boolean value) {
      this.object_lock_enabled = value;
      return this;
    }
  }

  public static final class BucketResponse extends Model {
    public BucketResponse() {}

    @JsonProperty(value = "bucket", required = false)
    private Bucket bucket;

    @JsonProperty("bucket")
    public Bucket getBucket() {
      return bucket;
    }
  }

  public static final class Bucket extends Model {
    public Bucket() {}

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

    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "acl", required = true)
    private String acl;

    @JsonProperty("acl")
    public String getAcl() {
      return acl;
    }

    /**
     * Versioning state. `suspended` means versioning was on and was turned off — existing versions
     * are kept, new writes stop creating them — which is distinct from `disabled`, a bucket that
     * never had it enabled. The S3-compatible endpoint spells the same states `Enabled` /
     * `Suspended` in its XML, and reports `disabled` by omitting the element.
     */
    @JsonProperty(value = "versioning", required = true)
    private BucketVersioning versioning;

    @JsonProperty("versioning")
    public BucketVersioning getVersioning() {
      return versioning;
    }

    /**
     * When true, DeleteBucket schedules deletion instead of removing the bucket immediately.
     * Default false deliberately preserves S3 immediate deletion.
     */
    @JsonProperty(value = "deletion_protection", required = true)
    private Boolean deletion_protection;

    @JsonProperty("deletion_protection")
    public Boolean getDeletionProtection() {
      return deletion_protection;
    }

    /**
     * Configured recovery window in whole days (default 7). New writes require 1–30; disabled
     * historical buckets can retain legacy out-of-range values.
     */
    @JsonProperty(value = "recovery_window_days", required = true)
    private Long recovery_window_days;

    @JsonProperty("recovery_window_days")
    public Long getRecoveryWindowDays() {
      return recovery_window_days;
    }

    /** When deletion was requested; null when not pending or for historical windows. */
    @JsonProperty(value = "deleted_at", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> deleted_at = JsonField.missing();

    @JsonProperty("deleted_at")
    public JsonField<String> getDeletedAt() {
      return deleted_at;
    }

    /** Purge deadline, present while deletion is pending. Restore before this time to cancel. */
    @JsonProperty(value = "scheduled_purge_at", required = false)
    private String scheduled_purge_at;

    @JsonProperty("scheduled_purge_at")
    public String getScheduledPurgeAt() {
      return scheduled_purge_at;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class BucketVersioning {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public BucketVersioning(String value) {
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
      return other instanceof BucketVersioning v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final BucketVersioning DISABLED = new BucketVersioning("disabled");
    public static final BucketVersioning ENABLED = new BucketVersioning("enabled");
    public static final BucketVersioning SUSPENDED = new BucketVersioning("suspended");
  }

  public static final class SnapshotCreateRequestInput extends Model {
    public SnapshotCreateRequestInput() {}

    /** Account-owned volume UUID, CRN, or exact name. */
    @JsonProperty(value = "volume", required = true)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public SnapshotCreateRequestInput withVolume(String value) {
      this.volume = value;
      return this;
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

    public SnapshotCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SnapshotCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SnapshotCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SnapshotResponse extends Model {
    public SnapshotResponse() {}

    @JsonProperty(value = "snapshot", required = false)
    private Snapshot snapshot;

    @JsonProperty("snapshot")
    public Snapshot getSnapshot() {
      return snapshot;
    }
  }

  public static final class Snapshot extends Model {
    public Snapshot() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name (name-based, region-scoped). */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** Source volume the snapshot was taken from. */
    @JsonProperty(value = "volume_id", required = false)
    private String volume_id;

    @JsonProperty("volume_id")
    public String getVolumeId() {
      return volume_id;
    }

    /**
     * The snapshot policy that took this snapshot. Absent when a person did. This is also what
     * retention matches on, so its presence is what makes a snapshot eligible for automatic
     * deletion — snapshots taken by hand are never reaped.
     */
    @JsonProperty(value = "snapshot_policy_id", required = false)
    private String snapshot_policy_id;

    @JsonProperty("snapshot_policy_id")
    public String getSnapshotPolicyId() {
      return snapshot_policy_id;
    }

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
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

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    /**
     * Frozen size of the source volume at the time the snapshot was taken — the volume may have
     * been extended since.
     */
    @JsonProperty(value = "size_gb", required = false)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    @JsonProperty(value = "status", required = false)
    private SnapshotStatus status;

    @JsonProperty("status")
    public SnapshotStatus getStatus() {
      return status;
    }

    /**
     * Active faults, newest first. Empty when healthy. Status is error if and only if an active
     * error-severity fault exists. Resolved history is retained internally.
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
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

  public static final class SnapshotStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SnapshotStatus(String value) {
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
      return other instanceof SnapshotStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SnapshotStatus CREATING = new SnapshotStatus("creating");
    public static final SnapshotStatus AVAILABLE = new SnapshotStatus("available");
    public static final SnapshotStatus DELETING = new SnapshotStatus("deleting");
    public static final SnapshotStatus ERROR = new SnapshotStatus("error");
  }

  public static final class Fault extends Model {
    public Fault() {}

    /** Stable machine-readable code owned by the reporting operation. */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    @JsonProperty(value = "severity", required = true)
    private FaultSeverity severity;

    @JsonProperty("severity")
    public FaultSeverity getSeverity() {
      return severity;
    }

    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    /** Structured context; legacy strings are preserved in legacy_text. */
    @JsonProperty(value = "details", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Map<String, JsonNode>> details = JsonField.missing();

    @JsonProperty("details")
    public JsonField<Map<String, JsonNode>> getDetails() {
      return details;
    }

    /** First observation in this active occurrence series. */
    @JsonProperty(value = "first_at", required = true)
    private String first_at;

    @JsonProperty("first_at")
    public String getFirstAt() {
      return first_at;
    }

    /** Latest observation in this active occurrence series. */
    @JsonProperty(value = "last_at", required = true)
    private String last_at;

    @JsonProperty("last_at")
    public String getLastAt() {
      return last_at;
    }

    @JsonProperty(value = "occurrences", required = true)
    private Long occurrences;

    @JsonProperty("occurrences")
    public Long getOccurrences() {
      return occurrences;
    }
  }

  public static final class FaultSeverity {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FaultSeverity(String value) {
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
      return other instanceof FaultSeverity v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FaultSeverity ERROR = new FaultSeverity("error");
    public static final FaultSeverity WARNING = new FaultSeverity("warning");
  }

  public static final class SnapshotPolicyCreateRequestInput extends Model {
    public SnapshotPolicyCreateRequestInput() {}

    /** Account-owned volume UUID, CRN, or exact name. */
    @JsonProperty(value = "volume", required = true)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public SnapshotPolicyCreateRequestInput withVolume(String value) {
      this.volume = value;
      return this;
    }

    /**
     * Unique within the account — it names the policy in its CRN. Scheduled snapshots are named
     * `&lt;policy&gt;-&lt;UTC timestamp&gt;`. Resource names must not start with the literal crn:
     * prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public SnapshotPolicyCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SnapshotPolicyCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "interval_minutes", required = true)
    private Long interval_minutes;

    @JsonProperty("interval_minutes")
    public Long getIntervalMinutes() {
      return interval_minutes;
    }

    public SnapshotPolicyCreateRequestInput withIntervalMinutes(Long value) {
      this.interval_minutes = value;
      return this;
    }

    @JsonProperty(value = "retention_count", required = true)
    private Long retention_count;

    @JsonProperty("retention_count")
    public Long getRetentionCount() {
      return retention_count;
    }

    public SnapshotPolicyCreateRequestInput withRetentionCount(Long value) {
      this.retention_count = value;
      return this;
    }

    @JsonProperty(value = "retention_days", required = false)
    private Long retention_days;

    @JsonProperty("retention_days")
    public Long getRetentionDays() {
      return retention_days;
    }

    public SnapshotPolicyCreateRequestInput withRetentionDays(Long value) {
      this.retention_days = value;
      return this;
    }

    /**
     * Defaults to true. Set false to attach a paused schedule. Pausing stops the whole policy — no
     * snapshots are taken and none are deleted, because a paused schedule that kept reaping would
     * delete history while you were looking at it.
     */
    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public SnapshotPolicyCreateRequestInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SnapshotPolicyCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SnapshotPolicyResponse extends Model {
    public SnapshotPolicyResponse() {}

    @JsonProperty(value = "snapshot_policy", required = false)
    private SnapshotPolicy snapshot_policy;

    @JsonProperty("snapshot_policy")
    public SnapshotPolicy getSnapshotPolicy() {
      return snapshot_policy;
    }
  }

  public static final class SnapshotPolicy extends Model {
    public SnapshotPolicy() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name (name-based, region-scoped). */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** The volume this schedule is attached to. A volume supports up to 16 independent policies. */
    @JsonProperty(value = "volume_id", required = false)
    private String volume_id;

    @JsonProperty("volume_id")
    public String getVolumeId() {
      return volume_id;
    }

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
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

    /**
     * Disabling pauses the whole policy — no scheduled snapshots and no retention. A paused
     * schedule that kept reaping would delete history while you were looking at it.
     */
    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    @JsonProperty(value = "interval_minutes", required = false)
    private Long interval_minutes;

    @JsonProperty("interval_minutes")
    public Long getIntervalMinutes() {
      return interval_minutes;
    }

    @JsonProperty(value = "retention_count", required = false)
    private Long retention_count;

    @JsonProperty("retention_count")
    public Long getRetentionCount() {
      return retention_count;
    }

    @JsonProperty(value = "retention_days", required = false)
    private Long retention_days;

    @JsonProperty("retention_days")
    public Long getRetentionDays() {
      return retention_days;
    }

    /**
     * When the next snapshot is due. Re-stamped to `now + interval_minutes` each time the policy
     * fires — never to `previous + interval` — so a window missed while the region was busy costs
     * one snapshot, not one per window missed.
     */
    @JsonProperty(value = "next_run_at", required = false)
    private String next_run_at;

    @JsonProperty("next_run_at")
    public String getNextRunAt() {
      return next_run_at;
    }

    /** When the policy last fired. Absent until the first fire. */
    @JsonProperty(value = "last_run_at", required = false)
    private String last_run_at;

    @JsonProperty("last_run_at")
    public String getLastRunAt() {
      return last_run_at;
    }

    /**
     * Active warning faults, newest first; empty when healthy. Policies have no error status and
     * faults never change enabled. Execution and retention recover independently; resolved history
     * is retained internally.
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
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

  public static final class VolumeCreateRequestInput extends Model {
    public VolumeCreateRequestInput() {}

    @JsonProperty(value = "performance", required = false)
    private VolumePerformanceRequestInput performance;

    @JsonProperty("performance")
    public VolumePerformanceRequestInput getPerformance() {
      return performance;
    }

    public VolumeCreateRequestInput withPerformance(VolumePerformanceRequestInput value) {
      this.performance = value;
      return this;
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

    public VolumeCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public VolumeCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public VolumeCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "volume_type", required = true)
    private CreatableVolumeTypeNameInput volume_type;

    @JsonProperty("volume_type")
    public CreatableVolumeTypeNameInput getVolumeType() {
      return volume_type;
    }

    public VolumeCreateRequestInput withVolumeType(CreatableVolumeTypeNameInput value) {
      this.volume_type = value;
      return this;
    }

    @JsonProperty(value = "size_gb", required = true)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    public VolumeCreateRequestInput withSizeGb(Long value) {
      this.size_gb = value;
      return this;
    }

    /**
     * Architecture used for source_image name resolution. A full image CRN pins its own
     * architecture.
     */
    @JsonProperty(value = "architecture", required = false)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    public VolumeCreateRequestInput withArchitecture(String value) {
      this.architecture = value;
      return this;
    }

    /**
     * Image UUID, name, name:version, or full CRN
     * image/&lt;name&gt;/architecture/&lt;arch&gt;/version/&lt;version&gt;. Names resolve in the
     * caller account first, then tagged platform catalog images, using architecture (default
     * amd64). Mutually exclusive with source_snapshot. Image tags are not accepted.
     */
    @JsonProperty(value = "source_image", required = false)
    private String source_image;

    @JsonProperty("source_image")
    public String getSourceImage() {
      return source_image;
    }

    public VolumeCreateRequestInput withSourceImage(String value) {
      this.source_image = value;
      return this;
    }

    /**
     * Clone from an available account-owned snapshot UUID or nested CRN
     * volume/&lt;volume-name&gt;/snapshot/&lt;snapshot-name&gt;. Bare snapshot names are rejected
     * because this request has no fixed source volume. Mutually exclusive with source_image;
     * size_gb must be at least the snapshot's frozen size.
     */
    @JsonProperty(value = "source_snapshot", required = false)
    private String source_snapshot;

    @JsonProperty("source_snapshot")
    public String getSourceSnapshot() {
      return source_snapshot;
    }

    public VolumeCreateRequestInput withSourceSnapshot(String value) {
      this.source_snapshot = value;
      return this;
    }

    @JsonProperty(value = "bootable", required = false)
    private Boolean bootable;

    @JsonProperty("bootable")
    public Boolean getBootable() {
      return bootable;
    }

    public VolumeCreateRequestInput withBootable(Boolean value) {
      this.bootable = value;
      return this;
    }
  }

  public static final class VolumePerformanceRequestInput extends Model {
    public VolumePerformanceRequestInput() {}

    @JsonProperty(value = "iops", required = false)
    private Long iops;

    @JsonProperty("iops")
    public Long getIops() {
      return iops;
    }

    public VolumePerformanceRequestInput withIops(Long value) {
      this.iops = value;
      return this;
    }

    @JsonProperty(value = "throughput_mib_s", required = false)
    private BigDecimal throughput_mib_s;

    @JsonProperty("throughput_mib_s")
    public BigDecimal getThroughputMibS() {
      return throughput_mib_s;
    }

    public VolumePerformanceRequestInput withThroughputMibS(BigDecimal value) {
      this.throughput_mib_s = value;
      return this;
    }
  }

  public static final class CreatableVolumeTypeNameInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreatableVolumeTypeNameInput(String value) {
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
      return other instanceof CreatableVolumeTypeNameInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreatableVolumeTypeNameInput SSD = new CreatableVolumeTypeNameInput("ssd");
    public static final CreatableVolumeTypeNameInput NVME =
        new CreatableVolumeTypeNameInput("nvme");
  }

  public static final class VolumeResponse extends Model {
    public VolumeResponse() {}

    @JsonProperty(value = "volume", required = false)
    private Volume volume;

    @JsonProperty("volume")
    public Volume getVolume() {
      return volume;
    }
  }

  public static final class Volume extends Model {
    public Volume() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name (name-based, region-scoped). */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
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

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "volume_type", required = false)
    private VolumeTypeName volume_type;

    @JsonProperty("volume_type")
    public VolumeTypeName getVolumeType() {
      return volume_type;
    }

    @JsonProperty(value = "size_gb", required = false)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    @JsonProperty(value = "performance", required = false)
    private VolumePerformance performance;

    @JsonProperty("performance")
    public VolumePerformance getPerformance() {
      return performance;
    }

    @JsonProperty(value = "included_io_limits", required = false)
    private IncludedIOLimits included_io_limits;

    @JsonProperty("included_io_limits")
    public IncludedIOLimits getIncludedIoLimits() {
      return included_io_limits;
    }

    @JsonProperty(value = "status", required = false)
    private VolumeStatus status;

    @JsonProperty("status")
    public VolumeStatus getStatus() {
      return status;
    }

    /**
     * Set at create time when the volume is provisioned from a bootable image. Immutable after
     * creation.
     */
    @JsonProperty(value = "bootable", required = false)
    private Boolean bootable;

    @JsonProperty("bootable")
    public Boolean getBootable() {
      return bootable;
    }

    /** Image the volume was cloned from, when applicable. */
    @JsonProperty(value = "source_image_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> source_image_id = JsonField.missing();

    @JsonProperty("source_image_id")
    public JsonField<String> getSourceImageId() {
      return source_image_id;
    }

    /** Snapshot the volume was cloned from (restore path), when applicable. */
    @JsonProperty(value = "source_snapshot_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> source_snapshot_id = JsonField.missing();

    @JsonProperty("source_snapshot_id")
    public JsonField<String> getSourceSnapshotId() {
      return source_snapshot_id;
    }

    /**
     * Active faults, newest first. Empty when healthy. Status is error if and only if an active
     * error-severity fault exists. Resolved history is retained internally.
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
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

  public static final class VolumeTypeName {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public VolumeTypeName(String value) {
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
      return other instanceof VolumeTypeName v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final VolumeTypeName HDD = new VolumeTypeName("hdd");
    public static final VolumeTypeName SSD = new VolumeTypeName("ssd");
    public static final VolumeTypeName NVME = new VolumeTypeName("nvme");
  }

  public static final class VolumePerformance extends Model {
    public VolumePerformance() {}

    @JsonProperty(value = "requested", required = true)
    private IncludedIOLimits requested;

    @JsonProperty("requested")
    public IncludedIOLimits getRequested() {
      return requested;
    }

    @JsonProperty(value = "applied", required = true)
    private IncludedIOLimits applied;

    @JsonProperty("applied")
    public IncludedIOLimits getApplied() {
      return applied;
    }

    @JsonProperty(value = "state", required = true)
    private VolumePerformanceState state;

    @JsonProperty("state")
    public VolumePerformanceState getState() {
      return state;
    }

    @JsonProperty(value = "operation_id", required = false)
    private String operation_id;

    @JsonProperty("operation_id")
    public String getOperationId() {
      return operation_id;
    }

    @JsonProperty(value = "applied_at", required = false)
    private String applied_at;

    @JsonProperty("applied_at")
    public String getAppliedAt() {
      return applied_at;
    }

    /** Latest retryable failure; the accepted request remains durable. */
    @JsonProperty(value = "last_error", required = false)
    private String last_error;

    @JsonProperty("last_error")
    public String getLastError() {
      return last_error;
    }
  }

  public static final class IncludedIOLimits extends Model {
    public IncludedIOLimits() {}

    @JsonProperty(value = "iops", required = true)
    private Long iops;

    @JsonProperty("iops")
    public Long getIops() {
      return iops;
    }

    @JsonProperty(value = "bytes_per_sec", required = true)
    private Long bytes_per_sec;

    @JsonProperty("bytes_per_sec")
    public Long getBytesPerSec() {
      return bytes_per_sec;
    }

    /** Always zero for SSD and NVMe volumes; IOPS bursting is disabled. */
    @JsonProperty(value = "burst_iops", required = true)
    private Long burst_iops;

    @JsonProperty("burst_iops")
    public Long getBurstIops() {
      return burst_iops;
    }

    /** Always zero for SSD and NVMe volumes; throughput bursting is disabled. */
    @JsonProperty(value = "burst_bytes_per_sec", required = true)
    private Long burst_bytes_per_sec;

    @JsonProperty("burst_bytes_per_sec")
    public Long getBurstBytesPerSec() {
      return burst_bytes_per_sec;
    }

    /** Always zero for SSD and NVMe volumes; no burst duration applies. */
    @JsonProperty(value = "burst_seconds", required = true)
    private Long burst_seconds;

    @JsonProperty("burst_seconds")
    public Long getBurstSeconds() {
      return burst_seconds;
    }
  }

  public static final class VolumePerformanceState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public VolumePerformanceState(String value) {
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
      return other instanceof VolumePerformanceState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final VolumePerformanceState CREATING = new VolumePerformanceState("creating");
    public static final VolumePerformanceState PENDING = new VolumePerformanceState("pending");
    public static final VolumePerformanceState APPLIED = new VolumePerformanceState("applied");
  }

  public static final class VolumeStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public VolumeStatus(String value) {
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
      return other instanceof VolumeStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final VolumeStatus CREATING = new VolumeStatus("creating");
    public static final VolumeStatus AVAILABLE = new VolumeStatus("available");
    public static final VolumeStatus IN_USE = new VolumeStatus("in_use");
    public static final VolumeStatus EXTENDING = new VolumeStatus("extending");
    public static final VolumeStatus DELETING = new VolumeStatus("deleting");
    public static final VolumeStatus ERROR = new VolumeStatus("error");
  }

  public static final class DeleteBucketVariant1 extends Model {
    public DeleteBucketVariant1() {}

    @JsonProperty(value = "scheduled_purge_at", required = true)
    private String scheduled_purge_at;

    @JsonProperty("scheduled_purge_at")
    public String getScheduledPurgeAt() {
      return scheduled_purge_at;
    }
  }

  public static final class DeleteBucketResponse {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DeleteBucketResponse(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "DeleteBucketResponse{[REDACTED]}";
    }

    public static DeleteBucketResponse ofVariant1(DeleteBucketVariant1 value) {
      Model.validate(value);
      return new DeleteBucketResponse(Json.tree(value));
    }

    public Optional<DeleteBucketVariant1> asVariant1() {
      try {
        DeleteBucketVariant1 result =
            Json.convert(value, new TypeReference<DeleteBucketVariant1>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static DeleteBucketResponse ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new DeleteBucketResponse(Json.tree(value));
    }

    public Optional<Map<String, JsonNode>> asVariant2() {
      try {
        Map<String, JsonNode> result =
            Json.convert(value, new TypeReference<Map<String, JsonNode>>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }
  }

  public static final class VolumeExtendRequestInput extends Model {
    public VolumeExtendRequestInput() {}

    /** New size in GB. Must be strictly greater than the current size. */
    @JsonProperty(value = "new_size_gb", required = true)
    private Long new_size_gb;

    @JsonProperty("new_size_gb")
    public Long getNewSizeGb() {
      return new_size_gb;
    }

    public VolumeExtendRequestInput withNewSizeGb(Long value) {
      this.new_size_gb = value;
      return this;
    }
  }

  public static final class BucketCORSResponse extends Model {
    public BucketCORSResponse() {}

    @JsonProperty(value = "cors", required = true)
    private CORSConfig cors;

    @JsonProperty("cors")
    public CORSConfig getCors() {
      return cors;
    }
  }

  public static final class CORSConfig extends Model {
    public CORSConfig() {}

    @JsonProperty(value = "rules", required = true)
    private List<CORSRule> rules;

    @JsonProperty("rules")
    public List<CORSRule> getRules() {
      return rules;
    }
  }

  public static final class CORSRule extends Model {
    public CORSRule() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "allowed_origins", required = true)
    private List<String> allowed_origins;

    @JsonProperty("allowed_origins")
    public List<String> getAllowedOrigins() {
      return allowed_origins;
    }

    @JsonProperty(value = "allowed_methods", required = true)
    private List<CORSRuleAllowedMethodsItem> allowed_methods;

    @JsonProperty("allowed_methods")
    public List<CORSRuleAllowedMethodsItem> getAllowedMethods() {
      return allowed_methods;
    }

    @JsonProperty(value = "allowed_headers", required = false)
    private List<String> allowed_headers;

    @JsonProperty("allowed_headers")
    public List<String> getAllowedHeaders() {
      return allowed_headers;
    }

    @JsonProperty(value = "expose_headers", required = false)
    private List<String> expose_headers;

    @JsonProperty("expose_headers")
    public List<String> getExposeHeaders() {
      return expose_headers;
    }

    @JsonProperty(value = "max_age_seconds", required = false)
    private Long max_age_seconds;

    @JsonProperty("max_age_seconds")
    public Long getMaxAgeSeconds() {
      return max_age_seconds;
    }
  }

  public static final class CORSRuleAllowedMethodsItem {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CORSRuleAllowedMethodsItem(String value) {
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
      return other instanceof CORSRuleAllowedMethodsItem v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CORSRuleAllowedMethodsItem GET = new CORSRuleAllowedMethodsItem("GET");
    public static final CORSRuleAllowedMethodsItem PUT = new CORSRuleAllowedMethodsItem("PUT");
    public static final CORSRuleAllowedMethodsItem POST = new CORSRuleAllowedMethodsItem("POST");
    public static final CORSRuleAllowedMethodsItem DELETE =
        new CORSRuleAllowedMethodsItem("DELETE");
    public static final CORSRuleAllowedMethodsItem HEAD = new CORSRuleAllowedMethodsItem("HEAD");
  }

  public static final class BucketEncryptionResponse extends Model {
    public BucketEncryptionResponse() {}

    @JsonProperty(value = "encryption", required = true)
    private EncryptionConfig encryption;

    @JsonProperty("encryption")
    public EncryptionConfig getEncryption() {
      return encryption;
    }
  }

  public static final class EncryptionConfig extends Model {
    public EncryptionConfig() {}

    @JsonProperty(value = "rules", required = true)
    private List<EncryptionRule> rules;

    @JsonProperty("rules")
    public List<EncryptionRule> getRules() {
      return rules;
    }
  }

  public static final class EncryptionRule extends Model {
    public EncryptionRule() {}

    @JsonProperty(value = "default", required = false)
    private EncryptionRuleDefault defaultValue;

    @JsonProperty("default")
    public EncryptionRuleDefault getDefaultValue() {
      return defaultValue;
    }

    @JsonProperty(value = "bucket_key_enabled", required = false)
    private Boolean bucket_key_enabled;

    @JsonProperty("bucket_key_enabled")
    public Boolean getBucketKeyEnabled() {
      return bucket_key_enabled;
    }
  }

  public static final class EncryptionRuleDefault extends Model {
    public EncryptionRuleDefault() {}

    @JsonProperty(value = "sse_algorithm", required = true)
    private String sse_algorithm;

    @JsonProperty("sse_algorithm")
    public String getSseAlgorithm() {
      return sse_algorithm;
    }

    /**
     * Accepted but unused S3 placeholder. Only AES256 is supported; this is not a KMS resource
     * reference.
     */
    @JsonProperty(value = "kms_master_key_id", required = false)
    private String kms_master_key_id;

    @JsonProperty("kms_master_key_id")
    public String getKmsMasterKeyId() {
      return kms_master_key_id;
    }
  }

  public static final class BucketLifecycleResponse extends Model {
    public BucketLifecycleResponse() {}

    /**
     * Opaque configuration revision. Supply this value in double quotes as If-Match on PUT or
     * DELETE. The empty configuration has revision none.
     */
    @JsonProperty(value = "revision", required = true)
    private String revision;

    @JsonProperty("revision")
    public String getRevision() {
      return revision;
    }

    @JsonProperty(value = "lifecycle", required = true)
    private LifecycleConfig lifecycle;

    @JsonProperty("lifecycle")
    public LifecycleConfig getLifecycle() {
      return lifecycle;
    }
  }

  public static final class LifecycleConfig extends Model {
    public LifecycleConfig() {}

    @JsonProperty(value = "rules", required = true)
    private List<LifecycleRule> rules;

    @JsonProperty("rules")
    public List<LifecycleRule> getRules() {
      return rules;
    }
  }

  public static final class LifecycleRule extends Model {
    public LifecycleRule() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * `disabled` keeps the rule in the configuration but skips it during evaluation. The
     * S3-compatible endpoint spells the same states `Enabled` / `Disabled` in its XML.
     */
    @JsonProperty(value = "status", required = true)
    private LifecycleRuleStatus status;

    @JsonProperty("status")
    public LifecycleRuleStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "filter", required = false)
    private LifecycleRuleFilter filter;

    @JsonProperty("filter")
    public LifecycleRuleFilter getFilter() {
      return filter;
    }

    /**
     * Move matching objects to another storage class once they are old enough. The object keeps its
     * identity — same key, same version id, same last-modified — and only its bytes move between
     * pools, so pairing a transition with an expiration works: the expiry clock is not restarted by
     * the move. Exactly one of `days` or `date`. When the rule also has an `expiration`, the
     * transition must come strictly first, otherwise the object would be deleted before it ever
     * moved and the rule is rejected. Only one transition per rule: the platform serves two
     * classes, so a second has nowhere to go. The S3-compatible endpoint accepts a single-element
     * `&lt;Transition&gt;` list and rejects longer ones rather than silently applying the first.
     */
    @JsonProperty(value = "transition", required = false)
    private LifecycleRuleTransition transition;

    @JsonProperty("transition")
    public LifecycleRuleTransition getTransition() {
      return transition;
    }

    @JsonProperty(value = "expiration", required = false)
    private LifecycleRuleExpiration expiration;

    @JsonProperty("expiration")
    public LifecycleRuleExpiration getExpiration() {
      return expiration;
    }

    @JsonProperty(value = "noncurrent_version_expiration", required = false)
    private LifecycleRuleNoncurrentVersionExpiration noncurrent_version_expiration;

    @JsonProperty("noncurrent_version_expiration")
    public LifecycleRuleNoncurrentVersionExpiration getNoncurrentVersionExpiration() {
      return noncurrent_version_expiration;
    }

    @JsonProperty(value = "abort_incomplete_multipart_upload", required = false)
    private LifecycleRuleAbortIncompleteMultipartUpload abort_incomplete_multipart_upload;

    @JsonProperty("abort_incomplete_multipart_upload")
    public LifecycleRuleAbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload() {
      return abort_incomplete_multipart_upload;
    }
  }

  public static final class LifecycleRuleStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleRuleStatus(String value) {
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
      return other instanceof LifecycleRuleStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleRuleStatus ENABLED = new LifecycleRuleStatus("enabled");
    public static final LifecycleRuleStatus DISABLED = new LifecycleRuleStatus("disabled");
  }

  public static final class LifecycleRuleFilter extends Model {
    public LifecycleRuleFilter() {}

    @JsonProperty(value = "prefix", required = false)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }
  }

  public static final class LifecycleRuleTransition extends Model {
    public LifecycleRuleTransition() {}

    /** Days after the object's last-modified time. */
    @JsonProperty(value = "days", required = false)
    private Long days;

    @JsonProperty("days")
    public Long getDays() {
      return days;
    }

    /** Absolute cut-off; fires on the next sweep after this instant. */
    @JsonProperty(value = "date", required = false)
    private String date;

    @JsonProperty("date")
    public String getDate() {
      return date;
    }

    /**
     * Destination class. Keeps the S3 standard's casing rather than the platform's lowercase
     * convention, because the class vocabulary is S3's. Unsupported values are rejected — a
     * transition to a class that does not exist would silently never run.
     */
    @JsonProperty(value = "storage_class", required = true)
    private LifecycleRuleTransitionStorageClass storage_class;

    @JsonProperty("storage_class")
    public LifecycleRuleTransitionStorageClass getStorageClass() {
      return storage_class;
    }
  }

  public static final class LifecycleRuleTransitionStorageClass {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleRuleTransitionStorageClass(String value) {
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
      return other instanceof LifecycleRuleTransitionStorageClass v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleRuleTransitionStorageClass STANDARD =
        new LifecycleRuleTransitionStorageClass("STANDARD");
    public static final LifecycleRuleTransitionStorageClass COLD =
        new LifecycleRuleTransitionStorageClass("COLD");
  }

  public static final class LifecycleRuleExpiration extends Model {
    public LifecycleRuleExpiration() {}

    @JsonProperty(value = "days", required = false)
    private Long days;

    @JsonProperty("days")
    public Long getDays() {
      return days;
    }

    @JsonProperty(value = "date", required = false)
    private String date;

    @JsonProperty("date")
    public String getDate() {
      return date;
    }
  }

  public static final class LifecycleRuleNoncurrentVersionExpiration extends Model {
    public LifecycleRuleNoncurrentVersionExpiration() {}

    @JsonProperty(value = "noncurrent_days", required = false)
    private Long noncurrent_days;

    @JsonProperty("noncurrent_days")
    public Long getNoncurrentDays() {
      return noncurrent_days;
    }

    @JsonProperty(value = "newer_noncurrent_versions", required = false)
    private Long newer_noncurrent_versions;

    @JsonProperty("newer_noncurrent_versions")
    public Long getNewerNoncurrentVersions() {
      return newer_noncurrent_versions;
    }
  }

  public static final class LifecycleRuleAbortIncompleteMultipartUpload extends Model {
    public LifecycleRuleAbortIncompleteMultipartUpload() {}

    @JsonProperty(value = "days_after_initiation", required = false)
    private Long days_after_initiation;

    @JsonProperty("days_after_initiation")
    public Long getDaysAfterInitiation() {
      return days_after_initiation;
    }
  }

  public static final class BucketObjectLockResponse extends Model {
    public BucketObjectLockResponse() {}

    @JsonProperty(value = "object_lock", required = true)
    private ObjectLockConfig object_lock;

    @JsonProperty("object_lock")
    public ObjectLockConfig getObjectLock() {
      return object_lock;
    }
  }

  public static final class ObjectLockConfig extends Model {
    public ObjectLockConfig() {}

    @JsonProperty(value = "object_lock_enabled", required = false)
    private String object_lock_enabled;

    @JsonProperty("object_lock_enabled")
    public String getObjectLockEnabled() {
      return object_lock_enabled;
    }

    @JsonProperty(value = "rule", required = false)
    private ObjectLockConfigRule rule;

    @JsonProperty("rule")
    public ObjectLockConfigRule getRule() {
      return rule;
    }
  }

  public static final class ObjectLockConfigRule extends Model {
    public ObjectLockConfigRule() {}

    @JsonProperty(value = "default_retention", required = false)
    private ObjectLockConfigRuleDefaultRetention default_retention;

    @JsonProperty("default_retention")
    public ObjectLockConfigRuleDefaultRetention getDefaultRetention() {
      return default_retention;
    }
  }

  public static final class ObjectLockConfigRuleDefaultRetention extends Model {
    public ObjectLockConfigRuleDefaultRetention() {}

    @JsonProperty(value = "mode", required = false)
    private ObjectLockConfigRuleDefaultRetentionMode mode;

    @JsonProperty("mode")
    public ObjectLockConfigRuleDefaultRetentionMode getMode() {
      return mode;
    }

    @JsonProperty(value = "days", required = false)
    private Long days;

    @JsonProperty("days")
    public Long getDays() {
      return days;
    }

    @JsonProperty(value = "years", required = false)
    private Long years;

    @JsonProperty("years")
    public Long getYears() {
      return years;
    }
  }

  public static final class ObjectLockConfigRuleDefaultRetentionMode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ObjectLockConfigRuleDefaultRetentionMode(String value) {
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
      return other instanceof ObjectLockConfigRuleDefaultRetentionMode v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ObjectLockConfigRuleDefaultRetentionMode GOVERNANCE =
        new ObjectLockConfigRuleDefaultRetentionMode("GOVERNANCE");
    public static final ObjectLockConfigRuleDefaultRetentionMode COMPLIANCE =
        new ObjectLockConfigRuleDefaultRetentionMode("COMPLIANCE");
  }

  public static final class BucketPolicyResponse extends Model {
    public BucketPolicyResponse() {}

    @JsonProperty(value = "document", required = false)
    private Map<String, JsonNode> document;

    @JsonProperty("document")
    public Map<String, JsonNode> getDocument() {
      return document;
    }
  }

  public static final class BucketTaggingResponse extends Model {
    public BucketTaggingResponse() {}

    @JsonProperty(value = "tags", required = true)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }
  }

  public static final class BucketVersioningResponse extends Model {
    public BucketVersioningResponse() {}

    @JsonProperty(value = "status", required = true)
    private BucketVersioningResponseStatus status;

    @JsonProperty("status")
    public BucketVersioningResponseStatus getStatus() {
      return status;
    }
  }

  public static final class BucketVersioningResponseStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public BucketVersioningResponseStatus(String value) {
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
      return other instanceof BucketVersioningResponseStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final BucketVersioningResponseStatus DISABLED =
        new BucketVersioningResponseStatus("disabled");
    public static final BucketVersioningResponseStatus ENABLED =
        new BucketVersioningResponseStatus("enabled");
    public static final BucketVersioningResponseStatus SUSPENDED =
        new BucketVersioningResponseStatus("suspended");
  }

  public static final class GetSnapshotScope extends Model {
    public GetSnapshotScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetSnapshotScope withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "volume", required = false)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public GetSnapshotScope withVolume(String value) {
      this.volume = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private SnapshotStatusInput status;

    @JsonProperty("status")
    public SnapshotStatusInput getStatus() {
      return status;
    }

    public GetSnapshotScope withStatus(SnapshotStatusInput value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "snapshot_policy", required = false)
    private String snapshot_policy;

    @JsonProperty("snapshot_policy")
    public String getSnapshotPolicy() {
      return snapshot_policy;
    }

    public GetSnapshotScope withSnapshotPolicy(String value) {
      this.snapshot_policy = value;
      return this;
    }
  }

  public static final class SnapshotStatusInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SnapshotStatusInput(String value) {
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
      return other instanceof SnapshotStatusInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SnapshotStatusInput CREATING = new SnapshotStatusInput("creating");
    public static final SnapshotStatusInput AVAILABLE = new SnapshotStatusInput("available");
    public static final SnapshotStatusInput DELETING = new SnapshotStatusInput("deleting");
    public static final SnapshotStatusInput ERROR = new SnapshotStatusInput("error");
  }

  public static final class GetSnapshotPolicyScope extends Model {
    public GetSnapshotPolicyScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetSnapshotPolicyScope withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "volume", required = false)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public GetSnapshotPolicyScope withVolume(String value) {
      this.volume = value;
      return this;
    }

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public GetSnapshotPolicyScope withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }
  }

  public static final class GetVolumeScope extends Model {
    public GetVolumeScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetVolumeScope withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private VolumeStatusInput status;

    @JsonProperty("status")
    public VolumeStatusInput getStatus() {
      return status;
    }

    public GetVolumeScope withStatus(VolumeStatusInput value) {
      this.status = value;
      return this;
    }
  }

  public static final class VolumeStatusInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public VolumeStatusInput(String value) {
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
      return other instanceof VolumeStatusInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final VolumeStatusInput CREATING = new VolumeStatusInput("creating");
    public static final VolumeStatusInput AVAILABLE = new VolumeStatusInput("available");
    public static final VolumeStatusInput IN_USE = new VolumeStatusInput("in_use");
    public static final VolumeStatusInput EXTENDING = new VolumeStatusInput("extending");
    public static final VolumeStatusInput DELETING = new VolumeStatusInput("deleting");
    public static final VolumeStatusInput ERROR = new VolumeStatusInput("error");
  }

  public static final class InitiateMultipartUploadRequestInput extends Model {
    public InitiateMultipartUploadRequestInput() {}

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    public InitiateMultipartUploadRequestInput withKey(String value) {
      this.key = value;
      return this;
    }

    @JsonProperty(value = "content_type", required = false)
    private String content_type;

    @JsonProperty("content_type")
    public String getContentType() {
      return content_type;
    }

    public InitiateMultipartUploadRequestInput withContentType(String value) {
      this.content_type = value;
      return this;
    }

    @JsonProperty(value = "storage_class", required = false)
    private String storage_class;

    @JsonProperty("storage_class")
    public String getStorageClass() {
      return storage_class;
    }

    public InitiateMultipartUploadRequestInput withStorageClass(String value) {
      this.storage_class = value;
      return this;
    }

    @JsonProperty(value = "metadata", required = false)
    private Map<String, String> metadata;

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
      return metadata;
    }

    public InitiateMultipartUploadRequestInput withMetadata(Map<String, String> value) {
      this.metadata = value;
      return this;
    }
  }

  public static final class MultipartUploadResponse extends Model {
    public MultipartUploadResponse() {}

    @JsonProperty(value = "upload", required = true)
    private MultipartUpload upload;

    @JsonProperty("upload")
    public MultipartUpload getUpload() {
      return upload;
    }
  }

  public static final class MultipartUpload extends Model {
    public MultipartUpload() {}

    @JsonProperty(value = "upload_id", required = true)
    private String upload_id;

    @JsonProperty("upload_id")
    public String getUploadId() {
      return upload_id;
    }

    @JsonProperty(value = "bucket", required = true)
    private String bucket;

    @JsonProperty("bucket")
    public String getBucket() {
      return bucket;
    }

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    @JsonProperty(value = "content_type", required = false)
    private String content_type;

    @JsonProperty("content_type")
    public String getContentType() {
      return content_type;
    }

    @JsonProperty(value = "storage_class", required = false)
    private String storage_class;

    @JsonProperty("storage_class")
    public String getStorageClass() {
      return storage_class;
    }

    @JsonProperty(value = "metadata", required = false)
    private Map<String, String> metadata;

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
      return metadata;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class ListBucketsQuery extends Model {
    public ListBucketsQuery() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListBucketsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListBucketsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListBucketsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListBucketsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class BucketListResponse extends Model {
    public BucketListResponse() {}

    @JsonProperty(value = "buckets", required = false)
    private List<Bucket> buckets;

    @JsonProperty("buckets")
    public List<Bucket> getBuckets() {
      return buckets;
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

  public static final class ListMultipartUploadsQuery extends Model {
    public ListMultipartUploadsQuery() {}

    @JsonProperty(value = "prefix", required = false)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }

    public ListMultipartUploadsQuery withPrefix(String value) {
      this.prefix = value;
      return this;
    }

    @JsonProperty(value = "max_uploads", required = false)
    private Long max_uploads;

    @JsonProperty("max_uploads")
    public Long getMaxUploads() {
      return max_uploads;
    }

    public ListMultipartUploadsQuery withMaxUploads(Long value) {
      this.max_uploads = value;
      return this;
    }
  }

  public static final class ListMultipartUploadsResponse extends Model {
    public ListMultipartUploadsResponse() {}

    @JsonProperty(value = "uploads", required = true)
    private List<MultipartUpload> uploads;

    @JsonProperty("uploads")
    public List<MultipartUpload> getUploads() {
      return uploads;
    }
  }

  public static final class ListObjectVersionsQuery extends Model {
    public ListObjectVersionsQuery() {}

    @JsonProperty(value = "prefix", required = false)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }

    public ListObjectVersionsQuery withPrefix(String value) {
      this.prefix = value;
      return this;
    }

    @JsonProperty(value = "key_marker", required = false)
    private String key_marker;

    @JsonProperty("key_marker")
    public String getKeyMarker() {
      return key_marker;
    }

    public ListObjectVersionsQuery withKeyMarker(String value) {
      this.key_marker = value;
      return this;
    }

    @JsonProperty(value = "version_id_marker", required = false)
    private String version_id_marker;

    @JsonProperty("version_id_marker")
    public String getVersionIdMarker() {
      return version_id_marker;
    }

    public ListObjectVersionsQuery withVersionIdMarker(String value) {
      this.version_id_marker = value;
      return this;
    }

    @JsonProperty(value = "max_keys", required = false)
    private Long max_keys;

    @JsonProperty("max_keys")
    public Long getMaxKeys() {
      return max_keys;
    }

    public ListObjectVersionsQuery withMaxKeys(Long value) {
      this.max_keys = value;
      return this;
    }
  }

  public static final class ListObjectVersionsResponse extends Model {
    public ListObjectVersionsResponse() {}

    @JsonProperty(value = "versions", required = true)
    private List<ObjectVersion> versions;

    @JsonProperty("versions")
    public List<ObjectVersion> getVersions() {
      return versions;
    }

    @JsonProperty(value = "is_truncated", required = true)
    private Boolean is_truncated;

    @JsonProperty("is_truncated")
    public Boolean getIsTruncated() {
      return is_truncated;
    }

    @JsonProperty(value = "next_key_marker", required = false)
    private String next_key_marker;

    @JsonProperty("next_key_marker")
    public String getNextKeyMarker() {
      return next_key_marker;
    }

    @JsonProperty(value = "next_version_id_marker", required = false)
    private String next_version_id_marker;

    @JsonProperty("next_version_id_marker")
    public String getNextVersionIdMarker() {
      return next_version_id_marker;
    }
  }

  public static final class ObjectVersion extends Model {
    public ObjectVersion() {}

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    @JsonProperty(value = "version_id", required = true)
    private String version_id;

    @JsonProperty("version_id")
    public String getVersionId() {
      return version_id;
    }

    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonProperty("size")
    public Long getSize() {
      return size;
    }

    @JsonProperty(value = "etag", required = true)
    private String etag;

    @JsonProperty("etag")
    public String getEtag() {
      return etag;
    }

    @JsonProperty(value = "content_type", required = false)
    private String content_type;

    @JsonProperty("content_type")
    public String getContentType() {
      return content_type;
    }

    @JsonProperty(value = "storage_class", required = false)
    private String storage_class;

    @JsonProperty("storage_class")
    public String getStorageClass() {
      return storage_class;
    }

    @JsonProperty(value = "last_modified", required = true)
    private String last_modified;

    @JsonProperty("last_modified")
    public String getLastModified() {
      return last_modified;
    }

    @JsonProperty(value = "is_latest", required = true)
    private Boolean is_latest;

    @JsonProperty("is_latest")
    public Boolean getIsLatest() {
      return is_latest;
    }

    @JsonProperty(value = "is_delete_marker", required = true)
    private Boolean is_delete_marker;

    @JsonProperty("is_delete_marker")
    public Boolean getIsDeleteMarker() {
      return is_delete_marker;
    }
  }

  public static final class ListObjectsQuery extends Model {
    public ListObjectsQuery() {}

    @JsonProperty(value = "prefix", required = false)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }

    public ListObjectsQuery withPrefix(String value) {
      this.prefix = value;
      return this;
    }

    @JsonProperty(value = "delimiter", required = false)
    private String delimiter;

    @JsonProperty("delimiter")
    public String getDelimiter() {
      return delimiter;
    }

    public ListObjectsQuery withDelimiter(String value) {
      this.delimiter = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListObjectsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "max_keys", required = false)
    private Long max_keys;

    @JsonProperty("max_keys")
    public Long getMaxKeys() {
      return max_keys;
    }

    public ListObjectsQuery withMaxKeys(Long value) {
      this.max_keys = value;
      return this;
    }
  }

  public static final class ObjectListResponse extends Model {
    public ObjectListResponse() {}

    @JsonProperty(value = "objects", required = false)
    private List<ObjectEntry> objects;

    @JsonProperty("objects")
    public List<ObjectEntry> getObjects() {
      return objects;
    }

    @JsonProperty(value = "common_prefixes", required = false)
    private List<String> common_prefixes;

    @JsonProperty("common_prefixes")
    public List<String> getCommonPrefixes() {
      return common_prefixes;
    }

    @JsonProperty(value = "is_truncated", required = false)
    private Boolean is_truncated;

    @JsonProperty("is_truncated")
    public Boolean getIsTruncated() {
      return is_truncated;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ObjectEntry extends Model {
    public ObjectEntry() {}

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonProperty("size")
    public Long getSize() {
      return size;
    }

    @JsonProperty(value = "etag", required = true)
    private String etag;

    @JsonProperty("etag")
    public String getEtag() {
      return etag;
    }

    @JsonProperty(value = "content_type", required = false)
    private String content_type;

    @JsonProperty("content_type")
    public String getContentType() {
      return content_type;
    }

    @JsonProperty(value = "last_modified", required = true)
    private String last_modified;

    @JsonProperty("last_modified")
    public String getLastModified() {
      return last_modified;
    }
  }

  public static final class ListPartsResponse extends Model {
    public ListPartsResponse() {}

    @JsonProperty(value = "upload", required = true)
    private MultipartUpload upload;

    @JsonProperty("upload")
    public MultipartUpload getUpload() {
      return upload;
    }

    @JsonProperty(value = "parts", required = true)
    private List<MultipartPart> parts;

    @JsonProperty("parts")
    public List<MultipartPart> getParts() {
      return parts;
    }
  }

  public static final class MultipartPart extends Model {
    public MultipartPart() {}

    @JsonProperty(value = "part_number", required = true)
    private Long part_number;

    @JsonProperty("part_number")
    public Long getPartNumber() {
      return part_number;
    }

    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonProperty("size")
    public Long getSize() {
      return size;
    }

    @JsonProperty(value = "etag", required = true)
    private String etag;

    @JsonProperty("etag")
    public String getEtag() {
      return etag;
    }
  }

  public static final class ListSnapshotPoliciesQuery extends Model {
    public ListSnapshotPoliciesQuery() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSnapshotPoliciesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSnapshotPoliciesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "volume", required = false)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public ListSnapshotPoliciesQuery withVolume(String value) {
      this.volume = value;
      return this;
    }

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public ListSnapshotPoliciesQuery withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListSnapshotPoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSnapshotPoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class SnapshotPolicyListResponse extends Model {
    public SnapshotPolicyListResponse() {}

    @JsonProperty(value = "snapshot_policies", required = false)
    private List<SnapshotPolicy> snapshot_policies;

    @JsonProperty("snapshot_policies")
    public List<SnapshotPolicy> getSnapshotPolicies() {
      return snapshot_policies;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListSnapshotsQuery extends Model {
    public ListSnapshotsQuery() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSnapshotsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSnapshotsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "volume", required = false)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public ListSnapshotsQuery withVolume(String value) {
      this.volume = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListSnapshotsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private SnapshotStatusInput status;

    @JsonProperty("status")
    public SnapshotStatusInput getStatus() {
      return status;
    }

    public ListSnapshotsQuery withStatus(SnapshotStatusInput value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSnapshotsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "snapshot_policy", required = false)
    private String snapshot_policy;

    @JsonProperty("snapshot_policy")
    public String getSnapshotPolicy() {
      return snapshot_policy;
    }

    public ListSnapshotsQuery withSnapshotPolicy(String value) {
      this.snapshot_policy = value;
      return this;
    }
  }

  public static final class SnapshotListResponse extends Model {
    public SnapshotListResponse() {}

    @JsonProperty(value = "snapshots", required = false)
    private List<Snapshot> snapshots;

    @JsonProperty("snapshots")
    public List<Snapshot> getSnapshots() {
      return snapshots;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListVolumeTypesQuery extends Model {
    public ListVolumeTypesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListVolumeTypesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListVolumeTypesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class VolumeTypeListResponse extends Model {
    public VolumeTypeListResponse() {}

    @JsonProperty(value = "volume_types", required = false)
    private List<VolumeType> volume_types;

    @JsonProperty("volume_types")
    public List<VolumeType> getVolumeTypes() {
      return volume_types;
    }
  }

  public static final class VolumeType extends Model {
    public VolumeType() {}

    @JsonProperty(value = "included_iops", required = false)
    private Long included_iops;

    @JsonProperty("included_iops")
    public Long getIncludedIops() {
      return included_iops;
    }

    @JsonProperty(value = "included_throughput_mib_s", required = false)
    private Long included_throughput_mib_s;

    @JsonProperty("included_throughput_mib_s")
    public Long getIncludedThroughputMibS() {
      return included_throughput_mib_s;
    }

    @JsonProperty(value = "max_iops", required = false)
    private Long max_iops;

    @JsonProperty("max_iops")
    public Long getMaxIops() {
      return max_iops;
    }

    @JsonProperty(value = "max_throughput_mib_s", required = false)
    private Long max_throughput_mib_s;

    @JsonProperty("max_throughput_mib_s")
    public Long getMaxThroughputMibS() {
      return max_throughput_mib_s;
    }

    /** Regional platform catalog identity, using the immutable type token. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** The type token (matches `volume_type` on a Volume). */
    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
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
  }

  public static final class ListVolumesQuery extends Model {
    public ListVolumesQuery() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListVolumesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListVolumesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListVolumesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private VolumeStatusInput status;

    @JsonProperty("status")
    public VolumeStatusInput getStatus() {
      return status;
    }

    public ListVolumesQuery withStatus(VolumeStatusInput value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListVolumesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class VolumeListResponse extends Model {
    public VolumeListResponse() {}

    @JsonProperty(value = "volumes", required = false)
    private List<Volume> volumes;

    @JsonProperty("volumes")
    public List<Volume> getVolumes() {
      return volumes;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class PutBucketCORSRequestInput extends Model {
    public PutBucketCORSRequestInput() {}

    @JsonProperty(value = "cors", required = true)
    private CORSConfigInput cors;

    @JsonProperty("cors")
    public CORSConfigInput getCors() {
      return cors;
    }

    public PutBucketCORSRequestInput withCors(CORSConfigInput value) {
      this.cors = value;
      return this;
    }
  }

  public static final class CORSConfigInput extends Model {
    public CORSConfigInput() {}

    @JsonProperty(value = "rules", required = true)
    private List<CORSRuleInput> rules;

    @JsonProperty("rules")
    public List<CORSRuleInput> getRules() {
      return rules;
    }

    public CORSConfigInput withRules(List<CORSRuleInput> value) {
      this.rules = value;
      return this;
    }
  }

  public static final class CORSRuleInput extends Model {
    public CORSRuleInput() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    public CORSRuleInput withId(String value) {
      this.id = value;
      return this;
    }

    @JsonProperty(value = "allowed_origins", required = true)
    private List<String> allowed_origins;

    @JsonProperty("allowed_origins")
    public List<String> getAllowedOrigins() {
      return allowed_origins;
    }

    public CORSRuleInput withAllowedOrigins(List<String> value) {
      this.allowed_origins = value;
      return this;
    }

    @JsonProperty(value = "allowed_methods", required = true)
    private List<CORSRuleInputAllowedMethodsItem> allowed_methods;

    @JsonProperty("allowed_methods")
    public List<CORSRuleInputAllowedMethodsItem> getAllowedMethods() {
      return allowed_methods;
    }

    public CORSRuleInput withAllowedMethods(List<CORSRuleInputAllowedMethodsItem> value) {
      this.allowed_methods = value;
      return this;
    }

    @JsonProperty(value = "allowed_headers", required = false)
    private List<String> allowed_headers;

    @JsonProperty("allowed_headers")
    public List<String> getAllowedHeaders() {
      return allowed_headers;
    }

    public CORSRuleInput withAllowedHeaders(List<String> value) {
      this.allowed_headers = value;
      return this;
    }

    @JsonProperty(value = "expose_headers", required = false)
    private List<String> expose_headers;

    @JsonProperty("expose_headers")
    public List<String> getExposeHeaders() {
      return expose_headers;
    }

    public CORSRuleInput withExposeHeaders(List<String> value) {
      this.expose_headers = value;
      return this;
    }

    @JsonProperty(value = "max_age_seconds", required = false)
    private Long max_age_seconds;

    @JsonProperty("max_age_seconds")
    public Long getMaxAgeSeconds() {
      return max_age_seconds;
    }

    public CORSRuleInput withMaxAgeSeconds(Long value) {
      this.max_age_seconds = value;
      return this;
    }
  }

  public static final class CORSRuleInputAllowedMethodsItem {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CORSRuleInputAllowedMethodsItem(String value) {
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
      return other instanceof CORSRuleInputAllowedMethodsItem v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CORSRuleInputAllowedMethodsItem GET =
        new CORSRuleInputAllowedMethodsItem("GET");
    public static final CORSRuleInputAllowedMethodsItem PUT =
        new CORSRuleInputAllowedMethodsItem("PUT");
    public static final CORSRuleInputAllowedMethodsItem POST =
        new CORSRuleInputAllowedMethodsItem("POST");
    public static final CORSRuleInputAllowedMethodsItem DELETE =
        new CORSRuleInputAllowedMethodsItem("DELETE");
    public static final CORSRuleInputAllowedMethodsItem HEAD =
        new CORSRuleInputAllowedMethodsItem("HEAD");
  }

  public static final class PutBucketDeletionProtectionRequestInput extends Model {
    public PutBucketDeletionProtectionRequestInput() {}

    /** When true, DeleteBucket schedules deletion instead of removing immediately. */
    @JsonProperty(value = "enabled", required = true)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public PutBucketDeletionProtectionRequestInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    /**
     * Whole days; omitted defaults to 7. Explicit values outside 1–30 return 400 even when
     * disabling protection.
     */
    @JsonProperty(value = "recovery_window_days", required = false)
    private Long recovery_window_days;

    @JsonProperty("recovery_window_days")
    public Long getRecoveryWindowDays() {
      return recovery_window_days;
    }

    public PutBucketDeletionProtectionRequestInput withRecoveryWindowDays(Long value) {
      this.recovery_window_days = value;
      return this;
    }
  }

  public static final class PutBucketEncryptionRequestInput extends Model {
    public PutBucketEncryptionRequestInput() {}

    @JsonProperty(value = "encryption", required = true)
    private EncryptionConfigInput encryption;

    @JsonProperty("encryption")
    public EncryptionConfigInput getEncryption() {
      return encryption;
    }

    public PutBucketEncryptionRequestInput withEncryption(EncryptionConfigInput value) {
      this.encryption = value;
      return this;
    }
  }

  public static final class EncryptionConfigInput extends Model {
    public EncryptionConfigInput() {}

    @JsonProperty(value = "rules", required = true)
    private List<EncryptionRuleInput> rules;

    @JsonProperty("rules")
    public List<EncryptionRuleInput> getRules() {
      return rules;
    }

    public EncryptionConfigInput withRules(List<EncryptionRuleInput> value) {
      this.rules = value;
      return this;
    }
  }

  public static final class EncryptionRuleInput extends Model {
    public EncryptionRuleInput() {}

    @JsonProperty(value = "default", required = false)
    private EncryptionRuleInputDefault defaultValue;

    @JsonProperty("default")
    public EncryptionRuleInputDefault getDefaultValue() {
      return defaultValue;
    }

    public EncryptionRuleInput withDefaultValue(EncryptionRuleInputDefault value) {
      this.defaultValue = value;
      return this;
    }

    @JsonProperty(value = "bucket_key_enabled", required = false)
    private Boolean bucket_key_enabled;

    @JsonProperty("bucket_key_enabled")
    public Boolean getBucketKeyEnabled() {
      return bucket_key_enabled;
    }

    public EncryptionRuleInput withBucketKeyEnabled(Boolean value) {
      this.bucket_key_enabled = value;
      return this;
    }
  }

  public static final class EncryptionRuleInputDefault extends Model {
    public EncryptionRuleInputDefault() {}

    @JsonProperty(value = "sse_algorithm", required = true)
    private String sse_algorithm;

    @JsonProperty("sse_algorithm")
    public String getSseAlgorithm() {
      return sse_algorithm;
    }

    public EncryptionRuleInputDefault withSseAlgorithm(String value) {
      this.sse_algorithm = value;
      return this;
    }

    /**
     * Accepted but unused S3 placeholder. Only AES256 is supported; this is not a KMS resource
     * reference.
     */
    @JsonProperty(value = "kms_master_key_id", required = false)
    private String kms_master_key_id;

    @JsonProperty("kms_master_key_id")
    public String getKmsMasterKeyId() {
      return kms_master_key_id;
    }

    public EncryptionRuleInputDefault withKmsMasterKeyId(String value) {
      this.kms_master_key_id = value;
      return this;
    }
  }

  public static final class PutBucketLifecycleRequestInput extends Model {
    public PutBucketLifecycleRequestInput() {}

    @JsonProperty(value = "lifecycle", required = true)
    private LifecycleConfigInput lifecycle;

    @JsonProperty("lifecycle")
    public LifecycleConfigInput getLifecycle() {
      return lifecycle;
    }

    public PutBucketLifecycleRequestInput withLifecycle(LifecycleConfigInput value) {
      this.lifecycle = value;
      return this;
    }
  }

  public static final class LifecycleConfigInput extends Model {
    public LifecycleConfigInput() {}

    @JsonProperty(value = "rules", required = true)
    private List<LifecycleRuleInput> rules;

    @JsonProperty("rules")
    public List<LifecycleRuleInput> getRules() {
      return rules;
    }

    public LifecycleConfigInput withRules(List<LifecycleRuleInput> value) {
      this.rules = value;
      return this;
    }
  }

  public static final class LifecycleRuleInput extends Model {
    public LifecycleRuleInput() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    public LifecycleRuleInput withId(String value) {
      this.id = value;
      return this;
    }

    /**
     * `disabled` keeps the rule in the configuration but skips it during evaluation. The
     * S3-compatible endpoint spells the same states `Enabled` / `Disabled` in its XML.
     */
    @JsonProperty(value = "status", required = true)
    private LifecycleRuleInputStatus status;

    @JsonProperty("status")
    public LifecycleRuleInputStatus getStatus() {
      return status;
    }

    public LifecycleRuleInput withStatus(LifecycleRuleInputStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "filter", required = false)
    private LifecycleRuleInputFilter filter;

    @JsonProperty("filter")
    public LifecycleRuleInputFilter getFilter() {
      return filter;
    }

    public LifecycleRuleInput withFilter(LifecycleRuleInputFilter value) {
      this.filter = value;
      return this;
    }

    /**
     * Move matching objects to another storage class once they are old enough. The object keeps its
     * identity — same key, same version id, same last-modified — and only its bytes move between
     * pools, so pairing a transition with an expiration works: the expiry clock is not restarted by
     * the move. Exactly one of `days` or `date`. When the rule also has an `expiration`, the
     * transition must come strictly first, otherwise the object would be deleted before it ever
     * moved and the rule is rejected. Only one transition per rule: the platform serves two
     * classes, so a second has nowhere to go. The S3-compatible endpoint accepts a single-element
     * `&lt;Transition&gt;` list and rejects longer ones rather than silently applying the first.
     */
    @JsonProperty(value = "transition", required = false)
    private LifecycleRuleInputTransition transition;

    @JsonProperty("transition")
    public LifecycleRuleInputTransition getTransition() {
      return transition;
    }

    public LifecycleRuleInput withTransition(LifecycleRuleInputTransition value) {
      this.transition = value;
      return this;
    }

    @JsonProperty(value = "expiration", required = false)
    private LifecycleRuleInputExpiration expiration;

    @JsonProperty("expiration")
    public LifecycleRuleInputExpiration getExpiration() {
      return expiration;
    }

    public LifecycleRuleInput withExpiration(LifecycleRuleInputExpiration value) {
      this.expiration = value;
      return this;
    }

    @JsonProperty(value = "noncurrent_version_expiration", required = false)
    private LifecycleRuleInputNoncurrentVersionExpiration noncurrent_version_expiration;

    @JsonProperty("noncurrent_version_expiration")
    public LifecycleRuleInputNoncurrentVersionExpiration getNoncurrentVersionExpiration() {
      return noncurrent_version_expiration;
    }

    public LifecycleRuleInput withNoncurrentVersionExpiration(
        LifecycleRuleInputNoncurrentVersionExpiration value) {
      this.noncurrent_version_expiration = value;
      return this;
    }

    @JsonProperty(value = "abort_incomplete_multipart_upload", required = false)
    private LifecycleRuleInputAbortIncompleteMultipartUpload abort_incomplete_multipart_upload;

    @JsonProperty("abort_incomplete_multipart_upload")
    public LifecycleRuleInputAbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload() {
      return abort_incomplete_multipart_upload;
    }

    public LifecycleRuleInput withAbortIncompleteMultipartUpload(
        LifecycleRuleInputAbortIncompleteMultipartUpload value) {
      this.abort_incomplete_multipart_upload = value;
      return this;
    }
  }

  public static final class LifecycleRuleInputStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleRuleInputStatus(String value) {
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
      return other instanceof LifecycleRuleInputStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleRuleInputStatus ENABLED = new LifecycleRuleInputStatus("enabled");
    public static final LifecycleRuleInputStatus DISABLED =
        new LifecycleRuleInputStatus("disabled");
  }

  public static final class LifecycleRuleInputFilter extends Model {
    public LifecycleRuleInputFilter() {}

    @JsonProperty(value = "prefix", required = false)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }

    public LifecycleRuleInputFilter withPrefix(String value) {
      this.prefix = value;
      return this;
    }
  }

  public static final class LifecycleRuleInputTransition extends Model {
    public LifecycleRuleInputTransition() {}

    /** Days after the object's last-modified time. */
    @JsonProperty(value = "days", required = false)
    private Long days;

    @JsonProperty("days")
    public Long getDays() {
      return days;
    }

    public LifecycleRuleInputTransition withDays(Long value) {
      this.days = value;
      return this;
    }

    /** Absolute cut-off; fires on the next sweep after this instant. */
    @JsonProperty(value = "date", required = false)
    private String date;

    @JsonProperty("date")
    public String getDate() {
      return date;
    }

    public LifecycleRuleInputTransition withDate(String value) {
      this.date = value;
      return this;
    }

    /**
     * Destination class. Keeps the S3 standard's casing rather than the platform's lowercase
     * convention, because the class vocabulary is S3's. Unsupported values are rejected — a
     * transition to a class that does not exist would silently never run.
     */
    @JsonProperty(value = "storage_class", required = true)
    private LifecycleRuleInputTransitionStorageClass storage_class;

    @JsonProperty("storage_class")
    public LifecycleRuleInputTransitionStorageClass getStorageClass() {
      return storage_class;
    }

    public LifecycleRuleInputTransition withStorageClass(
        LifecycleRuleInputTransitionStorageClass value) {
      this.storage_class = value;
      return this;
    }
  }

  public static final class LifecycleRuleInputTransitionStorageClass {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleRuleInputTransitionStorageClass(String value) {
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
      return other instanceof LifecycleRuleInputTransitionStorageClass v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleRuleInputTransitionStorageClass STANDARD =
        new LifecycleRuleInputTransitionStorageClass("STANDARD");
    public static final LifecycleRuleInputTransitionStorageClass COLD =
        new LifecycleRuleInputTransitionStorageClass("COLD");
  }

  public static final class LifecycleRuleInputExpiration extends Model {
    public LifecycleRuleInputExpiration() {}

    @JsonProperty(value = "days", required = false)
    private Long days;

    @JsonProperty("days")
    public Long getDays() {
      return days;
    }

    public LifecycleRuleInputExpiration withDays(Long value) {
      this.days = value;
      return this;
    }

    @JsonProperty(value = "date", required = false)
    private String date;

    @JsonProperty("date")
    public String getDate() {
      return date;
    }

    public LifecycleRuleInputExpiration withDate(String value) {
      this.date = value;
      return this;
    }
  }

  public static final class LifecycleRuleInputNoncurrentVersionExpiration extends Model {
    public LifecycleRuleInputNoncurrentVersionExpiration() {}

    @JsonProperty(value = "noncurrent_days", required = false)
    private Long noncurrent_days;

    @JsonProperty("noncurrent_days")
    public Long getNoncurrentDays() {
      return noncurrent_days;
    }

    public LifecycleRuleInputNoncurrentVersionExpiration withNoncurrentDays(Long value) {
      this.noncurrent_days = value;
      return this;
    }

    @JsonProperty(value = "newer_noncurrent_versions", required = false)
    private Long newer_noncurrent_versions;

    @JsonProperty("newer_noncurrent_versions")
    public Long getNewerNoncurrentVersions() {
      return newer_noncurrent_versions;
    }

    public LifecycleRuleInputNoncurrentVersionExpiration withNewerNoncurrentVersions(Long value) {
      this.newer_noncurrent_versions = value;
      return this;
    }
  }

  public static final class LifecycleRuleInputAbortIncompleteMultipartUpload extends Model {
    public LifecycleRuleInputAbortIncompleteMultipartUpload() {}

    @JsonProperty(value = "days_after_initiation", required = false)
    private Long days_after_initiation;

    @JsonProperty("days_after_initiation")
    public Long getDaysAfterInitiation() {
      return days_after_initiation;
    }

    public LifecycleRuleInputAbortIncompleteMultipartUpload withDaysAfterInitiation(Long value) {
      this.days_after_initiation = value;
      return this;
    }
  }

  public static final class PutBucketObjectLockRequestInput extends Model {
    public PutBucketObjectLockRequestInput() {}

    @JsonProperty(value = "object_lock", required = true)
    private ObjectLockConfigInput object_lock;

    @JsonProperty("object_lock")
    public ObjectLockConfigInput getObjectLock() {
      return object_lock;
    }

    public PutBucketObjectLockRequestInput withObjectLock(ObjectLockConfigInput value) {
      this.object_lock = value;
      return this;
    }
  }

  public static final class ObjectLockConfigInput extends Model {
    public ObjectLockConfigInput() {}

    @JsonProperty(value = "object_lock_enabled", required = false)
    private String object_lock_enabled;

    @JsonProperty("object_lock_enabled")
    public String getObjectLockEnabled() {
      return object_lock_enabled;
    }

    public ObjectLockConfigInput withObjectLockEnabled(String value) {
      this.object_lock_enabled = value;
      return this;
    }

    @JsonProperty(value = "rule", required = false)
    private ObjectLockConfigInputRule rule;

    @JsonProperty("rule")
    public ObjectLockConfigInputRule getRule() {
      return rule;
    }

    public ObjectLockConfigInput withRule(ObjectLockConfigInputRule value) {
      this.rule = value;
      return this;
    }
  }

  public static final class ObjectLockConfigInputRule extends Model {
    public ObjectLockConfigInputRule() {}

    @JsonProperty(value = "default_retention", required = false)
    private ObjectLockConfigInputRuleDefaultRetention default_retention;

    @JsonProperty("default_retention")
    public ObjectLockConfigInputRuleDefaultRetention getDefaultRetention() {
      return default_retention;
    }

    public ObjectLockConfigInputRule withDefaultRetention(
        ObjectLockConfigInputRuleDefaultRetention value) {
      this.default_retention = value;
      return this;
    }
  }

  public static final class ObjectLockConfigInputRuleDefaultRetention extends Model {
    public ObjectLockConfigInputRuleDefaultRetention() {}

    @JsonProperty(value = "mode", required = false)
    private ObjectLockConfigInputRuleDefaultRetentionMode mode;

    @JsonProperty("mode")
    public ObjectLockConfigInputRuleDefaultRetentionMode getMode() {
      return mode;
    }

    public ObjectLockConfigInputRuleDefaultRetention withMode(
        ObjectLockConfigInputRuleDefaultRetentionMode value) {
      this.mode = value;
      return this;
    }

    @JsonProperty(value = "days", required = false)
    private Long days;

    @JsonProperty("days")
    public Long getDays() {
      return days;
    }

    public ObjectLockConfigInputRuleDefaultRetention withDays(Long value) {
      this.days = value;
      return this;
    }

    @JsonProperty(value = "years", required = false)
    private Long years;

    @JsonProperty("years")
    public Long getYears() {
      return years;
    }

    public ObjectLockConfigInputRuleDefaultRetention withYears(Long value) {
      this.years = value;
      return this;
    }
  }

  public static final class ObjectLockConfigInputRuleDefaultRetentionMode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ObjectLockConfigInputRuleDefaultRetentionMode(String value) {
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
      return other instanceof ObjectLockConfigInputRuleDefaultRetentionMode v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ObjectLockConfigInputRuleDefaultRetentionMode GOVERNANCE =
        new ObjectLockConfigInputRuleDefaultRetentionMode("GOVERNANCE");
    public static final ObjectLockConfigInputRuleDefaultRetentionMode COMPLIANCE =
        new ObjectLockConfigInputRuleDefaultRetentionMode("COMPLIANCE");
  }

  public static final class PutBucketPolicyRequestInput extends Model {
    public PutBucketPolicyRequestInput() {}

    @JsonProperty(value = "document", required = true)
    private Map<String, JsonNode> document;

    @JsonProperty("document")
    public Map<String, JsonNode> getDocument() {
      return document;
    }

    public PutBucketPolicyRequestInput withDocument(Map<String, JsonNode> value) {
      this.document = value;
      return this;
    }
  }

  public static final class PutBucketTaggingRequestInput extends Model {
    public PutBucketTaggingRequestInput() {}

    @JsonProperty(value = "tags", required = true)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public PutBucketTaggingRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class PutBucketVersioningRequestInput extends Model {
    public PutBucketVersioningRequestInput() {}

    @JsonProperty(value = "status", required = true)
    private PutBucketVersioningRequestInputStatus status;

    @JsonProperty("status")
    public PutBucketVersioningRequestInputStatus getStatus() {
      return status;
    }

    public PutBucketVersioningRequestInput withStatus(PutBucketVersioningRequestInputStatus value) {
      this.status = value;
      return this;
    }
  }

  public static final class PutBucketVersioningRequestInputStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PutBucketVersioningRequestInputStatus(String value) {
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
      return other instanceof PutBucketVersioningRequestInputStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PutBucketVersioningRequestInputStatus ENABLED =
        new PutBucketVersioningRequestInputStatus("enabled");
    public static final PutBucketVersioningRequestInputStatus SUSPENDED =
        new PutBucketVersioningRequestInputStatus("suspended");
  }

  public static final class PutObjectResponse extends Model {
    public PutObjectResponse() {}

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    @JsonProperty(value = "etag", required = true)
    private String etag;

    @JsonProperty("etag")
    public String getEtag() {
      return etag;
    }

    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonProperty("size")
    public Long getSize() {
      return size;
    }
  }

  public static final class PutObjectResponse2 {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PutObjectResponse2(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "PutObjectResponse2{[REDACTED]}";
    }

    public static PutObjectResponse2 ofVariant1(PutObjectResponse value) {
      Model.validate(value);
      return new PutObjectResponse2(Json.tree(value));
    }

    public Optional<PutObjectResponse> asVariant1() {
      try {
        PutObjectResponse result = Json.convert(value, new TypeReference<PutObjectResponse>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static PutObjectResponse2 ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new PutObjectResponse2(Json.tree(value));
    }

    public Optional<Map<String, JsonNode>> asVariant2() {
      try {
        Map<String, JsonNode> result =
            Json.convert(value, new TypeReference<Map<String, JsonNode>>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }
  }

  public static final class SnapshotUpdateRequestInput extends Model {
    public SnapshotUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SnapshotUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SnapshotUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SnapshotPolicyUpdateRequestInput extends Model {
    public SnapshotPolicyUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SnapshotPolicyUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * false pauses the policy, true resumes it. Pausing stops the whole policy — no snapshots are
     * taken and none are deleted, so a paused schedule cannot lose you history. Resuming applies
     * the retention window again on the next run, so anything sitting outside it by then — because
     * you lowered `retention_count` while paused, say — is reaped on that run.
     */
    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public SnapshotPolicyUpdateRequestInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    @JsonProperty(value = "interval_minutes", required = false)
    private Long interval_minutes;

    @JsonProperty("interval_minutes")
    public Long getIntervalMinutes() {
      return interval_minutes;
    }

    public SnapshotPolicyUpdateRequestInput withIntervalMinutes(Long value) {
      this.interval_minutes = value;
      return this;
    }

    @JsonProperty(value = "retention_count", required = false)
    private Long retention_count;

    @JsonProperty("retention_count")
    public Long getRetentionCount() {
      return retention_count;
    }

    public SnapshotPolicyUpdateRequestInput withRetentionCount(Long value) {
      this.retention_count = value;
      return this;
    }

    @JsonProperty(value = "retention_days", required = false)
    private Long retention_days;

    @JsonProperty("retention_days")
    public Long getRetentionDays() {
      return retention_days;
    }

    public SnapshotPolicyUpdateRequestInput withRetentionDays(Long value) {
      this.retention_days = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SnapshotPolicyUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class VolumeUpdateRequestInput extends Model {
    public VolumeUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public VolumeUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public VolumeUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UploadPartResponse extends Model {
    public UploadPartResponse() {}

    @JsonProperty(value = "part_number", required = true)
    private Long part_number;

    @JsonProperty("part_number")
    public Long getPartNumber() {
      return part_number;
    }

    @JsonProperty(value = "etag", required = true)
    private String etag;

    @JsonProperty("etag")
    public String getEtag() {
      return etag;
    }

    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonProperty("size")
    public Long getSize() {
      return size;
    }
  }
}
