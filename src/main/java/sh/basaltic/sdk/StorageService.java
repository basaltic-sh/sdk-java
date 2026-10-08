package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Storage.Bucket;
import sh.basaltic.sdk.models.Storage.BucketCORSResponse;
import sh.basaltic.sdk.models.Storage.BucketEncryptionResponse;
import sh.basaltic.sdk.models.Storage.BucketLifecycleResponse;
import sh.basaltic.sdk.models.Storage.BucketListResponse;
import sh.basaltic.sdk.models.Storage.BucketObjectLockResponse;
import sh.basaltic.sdk.models.Storage.BucketPolicyResponse;
import sh.basaltic.sdk.models.Storage.BucketResponse;
import sh.basaltic.sdk.models.Storage.BucketTaggingResponse;
import sh.basaltic.sdk.models.Storage.BucketVersioningResponse;
import sh.basaltic.sdk.models.Storage.CompleteMultipartUploadRequestInput;
import sh.basaltic.sdk.models.Storage.CompleteMultipartUploadResponse;
import sh.basaltic.sdk.models.Storage.CreateBucketRequestInput;
import sh.basaltic.sdk.models.Storage.DeleteBucketResponse;
import sh.basaltic.sdk.models.Storage.GetSnapshotPolicyScope;
import sh.basaltic.sdk.models.Storage.GetSnapshotScope;
import sh.basaltic.sdk.models.Storage.GetVolumeScope;
import sh.basaltic.sdk.models.Storage.InitiateMultipartUploadRequestInput;
import sh.basaltic.sdk.models.Storage.ListBucketsQuery;
import sh.basaltic.sdk.models.Storage.ListMultipartUploadsQuery;
import sh.basaltic.sdk.models.Storage.ListMultipartUploadsResponse;
import sh.basaltic.sdk.models.Storage.ListObjectVersionsQuery;
import sh.basaltic.sdk.models.Storage.ListObjectVersionsResponse;
import sh.basaltic.sdk.models.Storage.ListObjectsQuery;
import sh.basaltic.sdk.models.Storage.ListPartsResponse;
import sh.basaltic.sdk.models.Storage.ListSnapshotPoliciesQuery;
import sh.basaltic.sdk.models.Storage.ListSnapshotsQuery;
import sh.basaltic.sdk.models.Storage.ListVolumeTypesQuery;
import sh.basaltic.sdk.models.Storage.ListVolumesQuery;
import sh.basaltic.sdk.models.Storage.MultipartPart;
import sh.basaltic.sdk.models.Storage.MultipartUpload;
import sh.basaltic.sdk.models.Storage.MultipartUploadResponse;
import sh.basaltic.sdk.models.Storage.ObjectListResponse;
import sh.basaltic.sdk.models.Storage.ObjectVersion;
import sh.basaltic.sdk.models.Storage.PutBucketCORSRequestInput;
import sh.basaltic.sdk.models.Storage.PutBucketDeletionProtectionRequestInput;
import sh.basaltic.sdk.models.Storage.PutBucketEncryptionRequestInput;
import sh.basaltic.sdk.models.Storage.PutBucketLifecycleRequestInput;
import sh.basaltic.sdk.models.Storage.PutBucketObjectLockRequestInput;
import sh.basaltic.sdk.models.Storage.PutBucketPolicyRequestInput;
import sh.basaltic.sdk.models.Storage.PutBucketTaggingRequestInput;
import sh.basaltic.sdk.models.Storage.PutBucketVersioningRequestInput;
import sh.basaltic.sdk.models.Storage.PutObjectResponse2;
import sh.basaltic.sdk.models.Storage.Snapshot;
import sh.basaltic.sdk.models.Storage.SnapshotCreateRequestInput;
import sh.basaltic.sdk.models.Storage.SnapshotListResponse;
import sh.basaltic.sdk.models.Storage.SnapshotPolicy;
import sh.basaltic.sdk.models.Storage.SnapshotPolicyCreateRequestInput;
import sh.basaltic.sdk.models.Storage.SnapshotPolicyListResponse;
import sh.basaltic.sdk.models.Storage.SnapshotPolicyResponse;
import sh.basaltic.sdk.models.Storage.SnapshotPolicyUpdateRequestInput;
import sh.basaltic.sdk.models.Storage.SnapshotResponse;
import sh.basaltic.sdk.models.Storage.SnapshotUpdateRequestInput;
import sh.basaltic.sdk.models.Storage.UploadPartResponse;
import sh.basaltic.sdk.models.Storage.Volume;
import sh.basaltic.sdk.models.Storage.VolumeCreateRequestInput;
import sh.basaltic.sdk.models.Storage.VolumeExtendRequestInput;
import sh.basaltic.sdk.models.Storage.VolumeListResponse;
import sh.basaltic.sdk.models.Storage.VolumePerformanceRequestInput;
import sh.basaltic.sdk.models.Storage.VolumeResponse;
import sh.basaltic.sdk.models.Storage.VolumeType;
import sh.basaltic.sdk.models.Storage.VolumeTypeListResponse;
import sh.basaltic.sdk.models.Storage.VolumeUpdateRequestInput;

/** Typed storage API methods. */
public final class StorageService {
  private final Transport transport;

  StorageService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "abortMultipartUpload",
          "DELETE",
          "/v1/buckets/{bucket}/multipart-uploads/{upload_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "completeMultipartUpload",
          "POST",
          "/v1/buckets/{bucket}/multipart-uploads/{upload_id}/complete",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "createBucket",
          "POST",
          "/v1/buckets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "createSnapshot",
          "POST",
          "/v1/snapshots",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "createSnapshotPolicy",
          "POST",
          "/v1/snapshot-policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "createVolume",
          "POST",
          "/v1/volumes",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "deleteBucket",
          "DELETE",
          "/v1/buckets/{bucket}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "deleteBucketCORS",
          "DELETE",
          "/v1/buckets/{bucket}/cors",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "deleteBucketEncryption",
          "DELETE",
          "/v1/buckets/{bucket}/encryption",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "deleteBucketLifecycle",
          "DELETE",
          "/v1/buckets/{bucket}/lifecycle",
          true,
          List.of(),
          List.of("If-Match"),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "deleteBucketObjectLock",
          "DELETE",
          "/v1/buckets/{bucket}/object-lock",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "deleteBucketPolicy",
          "DELETE",
          "/v1/buckets/{bucket}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "deleteBucketTagging",
          "DELETE",
          "/v1/buckets/{bucket}/tagging",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "deleteObject",
          "DELETE",
          "/v1/buckets/{bucket}/objects/{key}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "deleteSnapshot",
          "DELETE",
          "/v1/snapshots/{snapshot_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "deleteSnapshotPolicy",
          "DELETE",
          "/v1/snapshot-policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "deleteVolume",
          "DELETE",
          "/v1/volumes/{volume_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "extendVolume",
          "POST",
          "/v1/volumes/{volume_id}/extend",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "getBucketCORS",
          "GET",
          "/v1/buckets/{bucket}/cors",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "getBucketEncryption",
          "GET",
          "/v1/buckets/{bucket}/encryption",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "getBucketLifecycle",
          "GET",
          "/v1/buckets/{bucket}/lifecycle",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "getBucketObjectLock",
          "GET",
          "/v1/buckets/{bucket}/object-lock",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "getBucketPolicy",
          "GET",
          "/v1/buckets/{bucket}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_23 =
      new Operation(
          "getBucketTagging",
          "GET",
          "/v1/buckets/{bucket}/tagging",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_24 =
      new Operation(
          "getBucketVersioning",
          "GET",
          "/v1/buckets/{bucket}/versioning",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_25 =
      new Operation(
          "getObject",
          "GET",
          "/v1/buckets/{bucket}/objects/{key}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_26 =
      new Operation(
          "getSnapshot",
          "GET",
          "/v1/snapshots/{snapshot_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_27 =
      new Operation(
          "getSnapshotPolicy",
          "GET",
          "/v1/snapshot-policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_28 =
      new Operation(
          "getVolume",
          "GET",
          "/v1/volumes/{volume_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_29 =
      new Operation(
          "headBucket",
          "HEAD",
          "/v1/buckets/{bucket}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_30 =
      new Operation(
          "headObject",
          "HEAD",
          "/v1/buckets/{bucket}/objects/{key}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_31 =
      new Operation(
          "initiateMultipartUpload",
          "POST",
          "/v1/buckets/{bucket}/multipart-uploads",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_32 =
      new Operation(
          "listBuckets",
          "GET",
          "/v1/buckets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_33 =
      new Operation(
          "listMultipartUploads",
          "GET",
          "/v1/buckets/{bucket}/multipart-uploads",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("prefix", new Operation.Encoding("form", true)),
              Map.entry("max_uploads", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_34 =
      new Operation(
          "listObjectVersions",
          "GET",
          "/v1/buckets/{bucket}/object-versions",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("prefix", new Operation.Encoding("form", true)),
              Map.entry("key_marker", new Operation.Encoding("form", true)),
              Map.entry("version_id_marker", new Operation.Encoding("form", true)),
              Map.entry("max_keys", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_35 =
      new Operation(
          "listObjects",
          "GET",
          "/v1/buckets/{bucket}/objects",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("prefix", new Operation.Encoding("form", true)),
              Map.entry("delimiter", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("max_keys", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_36 =
      new Operation(
          "listParts",
          "GET",
          "/v1/buckets/{bucket}/multipart-uploads/{upload_id}/parts",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_37 =
      new Operation(
          "listSnapshotPolicies",
          "GET",
          "/v1/snapshot-policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("volume", new Operation.Encoding("form", true)),
              Map.entry("enabled", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_38 =
      new Operation(
          "listSnapshots",
          "GET",
          "/v1/snapshots",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("volume", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("snapshot_policy", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_39 =
      new Operation(
          "listVolumeTypes",
          "GET",
          "/v1/volume-types",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_40 =
      new Operation(
          "listVolumes",
          "GET",
          "/v1/volumes",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_41 =
      new Operation(
          "putBucketCORS",
          "PUT",
          "/v1/buckets/{bucket}/cors",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_42 =
      new Operation(
          "putBucketDeletionProtection",
          "PUT",
          "/v1/buckets/{bucket}/deletion-protection",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_43 =
      new Operation(
          "putBucketEncryption",
          "PUT",
          "/v1/buckets/{bucket}/encryption",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_44 =
      new Operation(
          "putBucketLifecycle",
          "PUT",
          "/v1/buckets/{bucket}/lifecycle",
          true,
          List.of(),
          List.of("If-Match"),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_45 =
      new Operation(
          "putBucketObjectLock",
          "PUT",
          "/v1/buckets/{bucket}/object-lock",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_46 =
      new Operation(
          "putBucketPolicy",
          "PUT",
          "/v1/buckets/{bucket}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_47 =
      new Operation(
          "putBucketTagging",
          "PUT",
          "/v1/buckets/{bucket}/tagging",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_48 =
      new Operation(
          "putBucketVersioning",
          "PUT",
          "/v1/buckets/{bucket}/versioning",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_49 =
      new Operation(
          "putObject",
          "PUT",
          "/v1/buckets/{bucket}/objects/{key}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/octet-stream",
          "application/json");
  private static final Operation OP_50 =
      new Operation(
          "restoreBucket",
          "POST",
          "/v1/buckets/{bucket}/restore",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_51 =
      new Operation(
          "updateSnapshot",
          "PATCH",
          "/v1/snapshots/{snapshot_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_52 =
      new Operation(
          "updateSnapshotPolicy",
          "PATCH",
          "/v1/snapshot-policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_53 =
      new Operation(
          "updateVolume",
          "PATCH",
          "/v1/volumes/{volume_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_54 =
      new Operation(
          "updateVolumePerformance",
          "POST",
          "/v1/volumes/{volume_id}/performance",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_55 =
      new Operation(
          "uploadPart",
          "PUT",
          "/v1/buckets/{bucket}/multipart-uploads/{upload_id}/parts/{part_number}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/octet-stream",
          "application/json");

  /** Abort a multipart upload */
  public EmptyRequest abortMultipartUpload(String bucket, String upload_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("bucket", bucket), Map.entry("upload_id", upload_id)),
            null,
            null));
  }

  /** Complete a multipart upload */
  public Request<CompleteMultipartUploadResponse> completeMultipartUpload(
      String bucket, String upload_id, CompleteMultipartUploadRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("bucket", bucket), Map.entry("upload_id", upload_id)),
            body,
            null),
        new TypeReference<CompleteMultipartUploadResponse>() {});
  }

  /** Create bucket */
  public Request<BucketResponse> createBucket(CreateBucketRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<BucketResponse>() {});
  }

  /** Create snapshot */
  public Request<SnapshotResponse> createSnapshot(SnapshotCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<SnapshotResponse>() {});
  }

  /** Create snapshot policy */
  public Request<SnapshotPolicyResponse> createSnapshotPolicy(
      SnapshotPolicyCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<SnapshotPolicyResponse>() {});
  }

  /** Create volume */
  public Request<VolumeResponse> createVolume(VolumeCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<VolumeResponse>() {});
  }

  /** Delete bucket */
  public Request<DeleteBucketResponse> deleteBucket(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<DeleteBucketResponse>() {});
  }

  /** Delete bucket CORS configuration */
  public EmptyRequest deleteBucketCORS(String bucket) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Delete bucket encryption configuration */
  public EmptyRequest deleteBucketEncryption(String bucket) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Delete bucket lifecycle configuration */
  public EmptyRequest deleteBucketLifecycle(String bucket) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Delete bucket object-lock configuration */
  public EmptyRequest deleteBucketObjectLock(String bucket) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Delete bucket policy */
  public EmptyRequest deleteBucketPolicy(String bucket) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Delete bucket tag set */
  public EmptyRequest deleteBucketTagging(String bucket) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Delete object */
  public EmptyRequest deleteObject(String bucket, String key) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("bucket", bucket), Map.entry("key", key)),
            null,
            null));
  }

  /** Delete snapshot */
  public EmptyRequest deleteSnapshot(String snapshot_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(Map.entry("snapshot_id", snapshot_id)),
            null,
            null));
  }

  /** Delete snapshot policy */
  public EmptyRequest deleteSnapshotPolicy(String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Delete volume */
  public EmptyRequest deleteVolume(String volume_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("volume_id", volume_id)),
            null,
            null));
  }

  /** Extend volume */
  public Request<VolumeResponse> extendVolume(String volume_id, VolumeExtendRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("volume_id", volume_id)),
            body,
            null),
        new TypeReference<VolumeResponse>() {});
  }

  /** Get bucket CORS configuration */
  public Request<BucketCORSResponse> getBucketCORS(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<BucketCORSResponse>() {});
  }

  /** Get bucket encryption configuration */
  public Request<BucketEncryptionResponse> getBucketEncryption(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<BucketEncryptionResponse>() {});
  }

  /** Get bucket lifecycle configuration */
  public Request<BucketLifecycleResponse> getBucketLifecycle(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<BucketLifecycleResponse>() {});
  }

  /** Get bucket object-lock configuration */
  public Request<BucketObjectLockResponse> getBucketObjectLock(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<BucketObjectLockResponse>() {});
  }

  /** Get bucket policy */
  public Request<BucketPolicyResponse> getBucketPolicy(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<BucketPolicyResponse>() {});
  }

  /** Get bucket tag set */
  public Request<BucketTaggingResponse> getBucketTagging(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<BucketTaggingResponse>() {});
  }

  /** Get bucket versioning state */
  public Request<BucketVersioningResponse> getBucketVersioning(String bucket) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_24,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null),
        new TypeReference<BucketVersioningResponse>() {});
  }

  /** Download object */
  public BinaryRequest getObject(String bucket, String key) {
    return new BinaryRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("bucket", bucket), Map.entry("key", key)),
            null,
            null));
  }

  /** Get snapshot */
  public Request<SnapshotResponse> getSnapshot(String snapshot_id) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_26,
            Map.ofEntries(Map.entry("snapshot_id", snapshot_id)),
            null,
            null),
        new TypeReference<SnapshotResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Snapshot> getSnapshotByReference(String reference, GetSnapshotScope scope) {
    return Request.reference(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_26,
            Map.ofEntries(Map.entry("snapshot_id", reference)),
            null,
            null),
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_38,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "snapshot",
        "snapshots",
        new TypeReference<Snapshot>() {});
  }

  public Request<Snapshot> getSnapshotByReference(String reference) {
    return getSnapshotByReference(reference, null);
  }

  /** Get snapshot policy */
  public Request<SnapshotPolicyResponse> getSnapshotPolicy(String policy_id) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            null),
        new TypeReference<SnapshotPolicyResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<SnapshotPolicy> getSnapshotPolicyByReference(
      String reference, GetSnapshotPolicyScope scope) {
    return Request.reference(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("policy_id", reference)),
            null,
            null),
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_37,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "snapshot_policy",
        "snapshot_policies",
        new TypeReference<SnapshotPolicy>() {});
  }

  public Request<SnapshotPolicy> getSnapshotPolicyByReference(String reference) {
    return getSnapshotPolicyByReference(reference, null);
  }

  /** Get volume */
  public Request<VolumeResponse> getVolume(String volume_id) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("volume_id", volume_id)),
            null,
            null),
        new TypeReference<VolumeResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Volume> getVolumeByReference(String reference, GetVolumeScope scope) {
    return Request.reference(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("volume_id", reference)),
            null,
            null),
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_40,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "volume",
        "volumes",
        new TypeReference<Volume>() {});
  }

  public Request<Volume> getVolumeByReference(String reference) {
    return getVolumeByReference(reference, null);
  }

  /** Head bucket */
  public BinaryRequest headBucket(String bucket) {
    return new BinaryRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_29,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Head object */
  public BinaryRequest headObject(String bucket, String key) {
    return new BinaryRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_30,
            Map.ofEntries(Map.entry("bucket", bucket), Map.entry("key", key)),
            null,
            null));
  }

  /** Initiate a multipart upload */
  public Request<MultipartUploadResponse> initiateMultipartUpload(
      String bucket, InitiateMultipartUploadRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_31,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null),
        new TypeReference<MultipartUploadResponse>() {});
  }

  /** List buckets */
  public PagedRequest<BucketListResponse, Bucket> listBuckets(ListBucketsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_32,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<BucketListResponse>() {},
        new TypeReference<Bucket>() {},
        "buckets");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<BucketListResponse, Bucket> listBuckets() {
    return listBuckets(null);
  }

  /** List in-flight multipart uploads */
  public PagedRequest<ListMultipartUploadsResponse, MultipartUpload> listMultipartUploads(
      String bucket, ListMultipartUploadsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_33,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            query),
        new TypeReference<ListMultipartUploadsResponse>() {},
        new TypeReference<MultipartUpload>() {},
        "uploads");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListMultipartUploadsResponse, MultipartUpload> listMultipartUploads(
      String bucket) {
    return listMultipartUploads(bucket, null);
  }

  /** List object versions */
  public PagedRequest<ListObjectVersionsResponse, ObjectVersion> listObjectVersions(
      String bucket, ListObjectVersionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            query),
        new TypeReference<ListObjectVersionsResponse>() {},
        new TypeReference<ObjectVersion>() {},
        "versions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListObjectVersionsResponse, ObjectVersion> listObjectVersions(String bucket) {
    return listObjectVersions(bucket, null);
  }

  /** List objects */
  public Request<ObjectListResponse> listObjects(String bucket, ListObjectsQuery query) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_35,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            query),
        new TypeReference<ObjectListResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<ObjectListResponse> listObjects(String bucket) {
    return listObjects(bucket, null);
  }

  /** List uploaded parts */
  public PagedRequest<ListPartsResponse, MultipartPart> listParts(String bucket, String upload_id) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_36,
            Map.ofEntries(Map.entry("bucket", bucket), Map.entry("upload_id", upload_id)),
            null,
            null),
        new TypeReference<ListPartsResponse>() {},
        new TypeReference<MultipartPart>() {},
        "parts");
  }

  /** List snapshot policies */
  public PagedRequest<SnapshotPolicyListResponse, SnapshotPolicy> listSnapshotPolicies(
      ListSnapshotPoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_37,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<SnapshotPolicyListResponse>() {},
        new TypeReference<SnapshotPolicy>() {},
        "snapshot_policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SnapshotPolicyListResponse, SnapshotPolicy> listSnapshotPolicies() {
    return listSnapshotPolicies(null);
  }

  /** List snapshots */
  public PagedRequest<SnapshotListResponse, Snapshot> listSnapshots(ListSnapshotsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_38,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<SnapshotListResponse>() {},
        new TypeReference<Snapshot>() {},
        "snapshots");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SnapshotListResponse, Snapshot> listSnapshots() {
    return listSnapshots(null);
  }

  /** List volume types */
  public PagedRequest<VolumeTypeListResponse, VolumeType> listVolumeTypes(
      ListVolumeTypesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_39,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<VolumeTypeListResponse>() {},
        new TypeReference<VolumeType>() {},
        "volume_types");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<VolumeTypeListResponse, VolumeType> listVolumeTypes() {
    return listVolumeTypes(null);
  }

  /** List volumes */
  public PagedRequest<VolumeListResponse, Volume> listVolumes(ListVolumesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_40,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<VolumeListResponse>() {},
        new TypeReference<Volume>() {},
        "volumes");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<VolumeListResponse, Volume> listVolumes() {
    return listVolumes(null);
  }

  /** Put bucket CORS configuration */
  public EmptyRequest putBucketCORS(String bucket, PutBucketCORSRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_41,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Set bucket deletion protection */
  public EmptyRequest putBucketDeletionProtection(
      String bucket, PutBucketDeletionProtectionRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_42,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Put bucket encryption configuration */
  public EmptyRequest putBucketEncryption(String bucket, PutBucketEncryptionRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_43,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Put bucket lifecycle configuration */
  public EmptyRequest putBucketLifecycle(String bucket, PutBucketLifecycleRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_44,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Put bucket object-lock configuration */
  public EmptyRequest putBucketObjectLock(String bucket, PutBucketObjectLockRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_45,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Put bucket policy */
  public EmptyRequest putBucketPolicy(String bucket, PutBucketPolicyRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_46,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Put bucket tag set */
  public EmptyRequest putBucketTagging(String bucket, PutBucketTaggingRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_47,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Set bucket versioning state */
  public EmptyRequest putBucketVersioning(String bucket, PutBucketVersioningRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_48,
            Map.ofEntries(Map.entry("bucket", bucket)),
            body,
            null));
  }

  /** Upload object */
  public Request<PutObjectResponse2> putObject(String bucket, String key, BinaryBody body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_49,
            Map.ofEntries(Map.entry("bucket", bucket), Map.entry("key", key)),
            body,
            null),
        new TypeReference<PutObjectResponse2>() {});
  }

  /** Restore a bucket pending deletion */
  public EmptyRequest restoreBucket(String bucket) {
    return new EmptyRequest(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_50,
            Map.ofEntries(Map.entry("bucket", bucket)),
            null,
            null));
  }

  /** Update snapshot metadata */
  public Request<SnapshotResponse> updateSnapshot(
      String snapshot_id, SnapshotUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_51,
            Map.ofEntries(Map.entry("snapshot_id", snapshot_id)),
            body,
            null),
        new TypeReference<SnapshotResponse>() {});
  }

  /** Update snapshot policy */
  public Request<SnapshotPolicyResponse> updateSnapshotPolicy(
      String policy_id, SnapshotPolicyUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_52,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            body,
            null),
        new TypeReference<SnapshotPolicyResponse>() {});
  }

  /** Update volume metadata */
  public Request<VolumeResponse> updateVolume(String volume_id, VolumeUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_53,
            Map.ofEntries(Map.entry("volume_id", volume_id)),
            body,
            null),
        new TypeReference<VolumeResponse>() {});
  }

  /** Update provisioned performance */
  public Request<VolumeResponse> updateVolumePerformance(
      String volume_id, VolumePerformanceRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_54,
            Map.ofEntries(Map.entry("volume_id", volume_id)),
            body,
            null),
        new TypeReference<VolumeResponse>() {});
  }

  /** Upload a part */
  public Request<UploadPartResponse> uploadPart(
      String bucket, String upload_id, String part_number, BinaryBody body) {
    return new Request<>(
        new Core(
            transport,
            "storage",
            "https://storage.{region}.basaltic.sh",
            OP_55,
            Map.ofEntries(
                Map.entry("bucket", bucket),
                Map.entry("upload_id", upload_id),
                Map.entry("part_number", part_number)),
            body,
            null),
        new TypeReference<UploadPartResponse>() {});
  }
}
