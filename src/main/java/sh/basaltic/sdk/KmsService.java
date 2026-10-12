package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Kms.CreateKeyRequestInput;
import sh.basaltic.sdk.models.Kms.DecryptRequestInput;
import sh.basaltic.sdk.models.Kms.DecryptResponse;
import sh.basaltic.sdk.models.Kms.EncryptRequestInput;
import sh.basaltic.sdk.models.Kms.EncryptResponse;
import sh.basaltic.sdk.models.Kms.GenerateDataKeyRequestInput;
import sh.basaltic.sdk.models.Kms.GenerateDataKeyResponse;
import sh.basaltic.sdk.models.Kms.GetKeyScope;
import sh.basaltic.sdk.models.Kms.GetPublicKeyQuery;
import sh.basaltic.sdk.models.Kms.Key;
import sh.basaltic.sdk.models.Kms.KeyListResponse;
import sh.basaltic.sdk.models.Kms.KeyResponse;
import sh.basaltic.sdk.models.Kms.KeyRotation;
import sh.basaltic.sdk.models.Kms.KeyRotationListResponse;
import sh.basaltic.sdk.models.Kms.KeyRotationPolicyResponse;
import sh.basaltic.sdk.models.Kms.KeyRotationResponse;
import sh.basaltic.sdk.models.Kms.KeyRotationStatusResponse;
import sh.basaltic.sdk.models.Kms.ListKeyRotationsQuery;
import sh.basaltic.sdk.models.Kms.ListKeysQuery;
import sh.basaltic.sdk.models.Kms.PublicKeyResponse;
import sh.basaltic.sdk.models.Kms.RewrapRequestInput;
import sh.basaltic.sdk.models.Kms.ScheduleKeyDeletionRequestInput;
import sh.basaltic.sdk.models.Kms.SetKeyRotationRequestInput;
import sh.basaltic.sdk.models.Kms.SignRequestInput;
import sh.basaltic.sdk.models.Kms.SignResponse;
import sh.basaltic.sdk.models.Kms.UpdateKeyRequestInput;
import sh.basaltic.sdk.models.Kms.VerifyRequestInput;
import sh.basaltic.sdk.models.Kms.VerifyResponse;

/** Typed kms API methods. */
public final class KmsService {
  private final Transport transport;

  KmsService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "cancelKeyDeletion",
          "POST",
          "/v1/keys/{key_id}/cancel-deletion",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "createKey",
          "POST",
          "/v1/keys",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "decrypt",
          "POST",
          "/v1/keys/{key_id}/decrypt",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "disableKey",
          "POST",
          "/v1/keys/{key_id}/disable",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "enableKey",
          "POST",
          "/v1/keys/{key_id}/enable",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "encrypt",
          "POST",
          "/v1/keys/{key_id}/encrypt",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "generateDataKey",
          "POST",
          "/v1/keys/{key_id}/generate-data-key",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "getKey",
          "GET",
          "/v1/keys/{key_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "getKeyRotation",
          "GET",
          "/v1/keys/{key_id}/rotations/{rotation_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "getKeyRotationStatus",
          "GET",
          "/v1/keys/{key_id}/rotation",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "getPublicKey",
          "GET",
          "/v1/keys/{key_id}/public-key",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(Map.entry("key_version", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "listKeyRotations",
          "GET",
          "/v1/keys/{key_id}/rotations",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "listKeys",
          "GET",
          "/v1/keys",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("state", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "rewrap",
          "POST",
          "/v1/keys/{key_id}/rewrap",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "rotateKeyOnDemand",
          "POST",
          "/v1/keys/{key_id}/rotate",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "scheduleKeyDeletion",
          "POST",
          "/v1/keys/{key_id}/schedule-deletion",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "setKeyRotation",
          "PUT",
          "/v1/keys/{key_id}/rotation",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "sign",
          "POST",
          "/v1/keys/{key_id}/sign",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "updateKey",
          "PATCH",
          "/v1/keys/{key_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "verify",
          "POST",
          "/v1/keys/{key_id}/verify",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Cancel a scheduled deletion */
  public Request<KeyResponse> cancelKeyDeletion(String key_id) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            null),
        new TypeReference<KeyResponse>() {});
  }

  /** Create a KMS key */
  public Request<KeyResponse> createKey(CreateKeyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<KeyResponse>() {});
  }

  /** Decrypt a ciphertext */
  public Request<DecryptResponse> decrypt(String key_id, DecryptRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<DecryptResponse>() {});
  }

  /** Disable a key */
  public Request<KeyResponse> disableKey(String key_id) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            null),
        new TypeReference<KeyResponse>() {});
  }

  /** Enable a disabled key */
  public Request<KeyResponse> enableKey(String key_id) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            null),
        new TypeReference<KeyResponse>() {});
  }

  /** Encrypt a payload */
  public Request<EncryptResponse> encrypt(String key_id, EncryptRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<EncryptResponse>() {});
  }

  /** Generate a fresh data key */
  public Request<GenerateDataKeyResponse> generateDataKey(
      String key_id, GenerateDataKeyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<GenerateDataKeyResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<GenerateDataKeyResponse> generateDataKey(String key_id) {
    return generateDataKey(key_id, null);
  }

  /** Get a KMS key */
  public Request<KeyResponse> getKey(String key_id) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            null),
        new TypeReference<KeyResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Key> getKeyByReference(String reference, GetKeyScope scope) {
    return Request.reference(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("key_id", reference)),
            null,
            null),
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "key",
        "keys",
        new TypeReference<Key>() {});
  }

  public Request<Key> getKeyByReference(String reference) {
    return getKeyByReference(reference, null);
  }

  /** Get a key rotation */
  public Request<KeyRotationResponse> getKeyRotation(String key_id, String rotation_id) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("key_id", key_id), Map.entry("rotation_id", rotation_id)),
            null,
            null),
        new TypeReference<KeyRotationResponse>() {});
  }

  /** Get key rotation status */
  public Request<KeyRotationStatusResponse> getKeyRotationStatus(String key_id) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            null),
        new TypeReference<KeyRotationStatusResponse>() {});
  }

  /** Get a versioned public key */
  public Request<PublicKeyResponse> getPublicKey(String key_id, GetPublicKeyQuery query) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            query),
        new TypeReference<PublicKeyResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<PublicKeyResponse> getPublicKey(String key_id) {
    return getPublicKey(key_id, null);
  }

  /** List key rotation history */
  public PagedRequest<KeyRotationListResponse, KeyRotation> listKeyRotations(
      String key_id, ListKeyRotationsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            query),
        new TypeReference<KeyRotationListResponse>() {},
        new TypeReference<KeyRotation>() {},
        "rotations");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<KeyRotationListResponse, KeyRotation> listKeyRotations(String key_id) {
    return listKeyRotations(key_id, null);
  }

  /** List KMS keys */
  public PagedRequest<KeyListResponse, Key> listKeys(ListKeysQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<KeyListResponse>() {},
        new TypeReference<Key>() {},
        "keys");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<KeyListResponse, Key> listKeys() {
    return listKeys(null);
  }

  /** Rewrap ciphertext with current key material */
  public Request<EncryptResponse> rewrap(String key_id, RewrapRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<EncryptResponse>() {});
  }

  /** Rotate key material now */
  public Request<KeyRotationResponse> rotateKeyOnDemand(String key_id) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(Map.entry("key_id", key_id)),
            null,
            null),
        new TypeReference<KeyRotationResponse>() {});
  }

  /** Schedule key for deletion */
  public Request<KeyResponse> scheduleKeyDeletion(
      String key_id, ScheduleKeyDeletionRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<KeyResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<KeyResponse> scheduleKeyDeletion(String key_id) {
    return scheduleKeyDeletion(key_id, null);
  }

  /** Configure automatic key rotation */
  public Request<KeyRotationPolicyResponse> setKeyRotation(
      String key_id, SetKeyRotationRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<KeyRotationPolicyResponse>() {});
  }

  /** Sign a message */
  public Request<SignResponse> sign(String key_id, SignRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<SignResponse>() {});
  }

  /** Update key metadata */
  public Request<KeyResponse> updateKey(String key_id, UpdateKeyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<KeyResponse>() {});
  }

  /** Verify a signature */
  public Request<VerifyResponse> verify(String key_id, VerifyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "kms",
            "https://kms.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(Map.entry("key_id", key_id)),
            body,
            null),
        new TypeReference<VerifyResponse>() {});
  }
}
