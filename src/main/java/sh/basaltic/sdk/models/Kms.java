package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed kms wire models. Unknown string enum values are retained. */
public final class Kms {

  private Kms() {}

  public static final class KeyResponse extends Model {
    public KeyResponse() {}

    @JsonProperty(value = "key", required = false)
    private Key key;

    @JsonProperty("key")
    public Key getKey() {
      return key;
    }
  }

  public static final class Key extends Model {
    public Key() {}

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

    @JsonProperty(value = "tags", required = true)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "key_spec", required = true)
    private KeySpec key_spec;

    @JsonProperty("key_spec")
    public KeySpec getKeySpec() {
      return key_spec;
    }

    @JsonProperty(value = "key_usage", required = true)
    private KeyUsage key_usage;

    @JsonProperty("key_usage")
    public KeyUsage getKeyUsage() {
      return key_usage;
    }

    @JsonProperty(value = "state", required = true)
    private KeyState state;

    @JsonProperty("state")
    public KeyState getState() {
      return state;
    }

    /**
     * Present and true on platform-owned envelope keys (credential master, JWT signer, …), which
     * are visible but not yours to operate on. Omitted on customer keys. Console and CLI read it to
     * hide the destructive actions.
     */
    @JsonProperty(value = "system", required = false)
    private Boolean system;

    @JsonProperty("system")
    public Boolean getSystem() {
      return system;
    }

    /**
     * When deletion was requested. Null for active keys and historical pending deletions whose
     * request time is unknown.
     */
    @JsonProperty(value = "deleted_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> deleted_at = JsonField.missing();

    @JsonProperty("deleted_at")
    public JsonField<String> getDeletedAt() {
      return deleted_at;
    }

    /**
     * Chosen whole-day window. Null for active keys and historical pending deletions whose window
     * is unknown.
     */
    @JsonProperty(value = "recovery_window_days", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> recovery_window_days = JsonField.missing();

    @JsonProperty("recovery_window_days")
    public JsonField<Long> getRecoveryWindowDays() {
      return recovery_window_days;
    }

    /**
     * Set only while state=pending_deletion. The key (and its cryptographic material) is
     * hard-deleted once now() reaches this timestamp; CancelKeyDeletion before then returns the key
     * to state=disabled.
     */
    @JsonProperty(value = "scheduled_purge_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> scheduled_purge_at = JsonField.missing();

    @JsonProperty("scheduled_purge_at")
    public JsonField<String> getScheduledPurgeAt() {
      return scheduled_purge_at;
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

  public static final class KeySpec {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public KeySpec(String value) {
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
      return other instanceof KeySpec v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final KeySpec AES256 = new KeySpec("aes-256");
    public static final KeySpec RSA2048 = new KeySpec("rsa-2048");
    public static final KeySpec RSA4096 = new KeySpec("rsa-4096");
    public static final KeySpec ECDSA_P256 = new KeySpec("ecdsa-p256");
  }

  public static final class KeyUsage {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public KeyUsage(String value) {
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
      return other instanceof KeyUsage v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final KeyUsage ENCRYPT_DECRYPT = new KeyUsage("encrypt_decrypt");
    public static final KeyUsage SIGN_VERIFY = new KeyUsage("sign_verify");
  }

  public static final class KeyState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public KeyState(String value) {
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
      return other instanceof KeyState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final KeyState ENABLED = new KeyState("enabled");
    public static final KeyState DISABLED = new KeyState("disabled");
    public static final KeyState PENDING_DELETION = new KeyState("pending_deletion");
  }

  public static final class CreateKeyRequestInput extends Model {
    public CreateKeyRequestInput() {}

    /**
     * Unique per account. Surfaces in the CRN
     * (crn:kms:&lt;region&gt;:&lt;account&gt;:key/&lt;name&gt;) — letters, digits, dot, dash,
     * underscore. Resource names must not start with the literal crn: prefix or be UUIDs
     * (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateKeyRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public CreateKeyRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateKeyRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "key_spec", required = true)
    private KeySpecInput key_spec;

    @JsonProperty("key_spec")
    public KeySpecInput getKeySpec() {
      return key_spec;
    }

    public CreateKeyRequestInput withKeySpec(KeySpecInput value) {
      this.key_spec = value;
      return this;
    }

    /**
     * Required for RSA specs (both encrypt_decrypt and sign_verify are valid). Defaults to
     * encrypt_decrypt for AES, sign_verify for ECDSA.
     */
    @JsonProperty(value = "key_usage", required = false)
    private KeyUsageInput key_usage;

    @JsonProperty("key_usage")
    public KeyUsageInput getKeyUsage() {
      return key_usage;
    }

    public CreateKeyRequestInput withKeyUsage(KeyUsageInput value) {
      this.key_usage = value;
      return this;
    }
  }

  public static final class KeySpecInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public KeySpecInput(String value) {
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
      return other instanceof KeySpecInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final KeySpecInput AES256 = new KeySpecInput("aes-256");
    public static final KeySpecInput RSA2048 = new KeySpecInput("rsa-2048");
    public static final KeySpecInput RSA4096 = new KeySpecInput("rsa-4096");
    public static final KeySpecInput ECDSA_P256 = new KeySpecInput("ecdsa-p256");
  }

  public static final class KeyUsageInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public KeyUsageInput(String value) {
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
      return other instanceof KeyUsageInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final KeyUsageInput ENCRYPT_DECRYPT = new KeyUsageInput("encrypt_decrypt");
    public static final KeyUsageInput SIGN_VERIFY = new KeyUsageInput("sign_verify");
  }

  public static final class DecryptRequestInput extends Model {
    public DecryptRequestInput() {}

    /** Base64-encoded ciphertext produced by Encrypt. */
    @JsonProperty(value = "ciphertext", required = true)
    private String ciphertext;

    @JsonProperty("ciphertext")
    public String getCiphertext() {
      return ciphertext;
    }

    public DecryptRequestInput withCiphertext(String value) {
      this.ciphertext = value;
      return this;
    }

    /**
     * Optional base64-encoded AAD. Must match what was supplied at Encrypt — different value fails
     * the tag check.
     */
    @JsonProperty(value = "aad", required = false)
    private String aad;

    @JsonProperty("aad")
    public String getAad() {
      return aad;
    }

    public DecryptRequestInput withAad(String value) {
      this.aad = value;
      return this;
    }
  }

  public static final class DecryptResponse extends Model {
    public DecryptResponse() {}

    /** Base64-encoded plaintext. */
    @JsonProperty(value = "plaintext", required = false)
    private String plaintext;

    @JsonProperty("plaintext")
    public String getPlaintext() {
      return plaintext;
    }
  }

  public static final class EncryptRequestInput extends Model {
    public EncryptRequestInput() {}

    /** Base64-encoded plaintext. */
    @JsonProperty(value = "plaintext", required = true)
    private String plaintext;

    @JsonProperty("plaintext")
    public String getPlaintext() {
      return plaintext;
    }

    public EncryptRequestInput withPlaintext(String value) {
      this.plaintext = value;
      return this;
    }

    /**
     * Optional base64-encoded additional authenticated data (AES-GCM AEAD). Must be supplied
     * verbatim to Decrypt; mismatch fails the auth tag check. Ignored for asymmetric keys.
     */
    @JsonProperty(value = "aad", required = false)
    private String aad;

    @JsonProperty("aad")
    public String getAad() {
      return aad;
    }

    public EncryptRequestInput withAad(String value) {
      this.aad = value;
      return this;
    }
  }

  public static final class EncryptResponse extends Model {
    public EncryptResponse() {}

    /**
     * Base64-encoded ciphertext. Opaque — store verbatim. For AES-GCM the layout is nonce(12) || ct
     * || tag; for RSA-OAEP the standard PKCS#1 RSAES output.
     */
    @JsonProperty(value = "ciphertext", required = false)
    private String ciphertext;

    @JsonProperty("ciphertext")
    public String getCiphertext() {
      return ciphertext;
    }

    /** CRN of the key the ciphertext was sealed under. */
    @JsonProperty(value = "key_crn", required = false)
    private String key_crn;

    @JsonProperty("key_crn")
    public String getKeyCrn() {
      return key_crn;
    }
  }

  public static final class GenerateDataKeyRequestInput extends Model {
    public GenerateDataKeyRequestInput() {}

    /**
     * Size of the generated data key in bytes: 16 (AES-128), 32 (AES-256, the default) or 64
     * (HMAC-SHA512). No other size is supported — the HSM mints data keys at those three widths
     * only, and any other value fails the operation.
     */
    @JsonProperty(value = "number_of_bytes", required = false)
    private Long number_of_bytes;

    @JsonProperty("number_of_bytes")
    public Long getNumberOfBytes() {
      return number_of_bytes;
    }

    public GenerateDataKeyRequestInput withNumberOfBytes(Long value) {
      this.number_of_bytes = value;
      return this;
    }
  }

  public static final class GenerateDataKeyResponse extends Model {
    public GenerateDataKeyResponse() {}

    /**
     * Base64-encoded plaintext data key. Use immediately, then drop — callers must NOT persist
     * this. Re-derive it on demand by calling Decrypt with the stored ciphertext.
     */
    @JsonProperty(value = "plaintext", required = false)
    private String plaintext;

    @JsonProperty("plaintext")
    public String getPlaintext() {
      return plaintext;
    }

    /**
     * Base64-encoded data key wrapped under the KMS key. Safe to store at rest alongside the data
     * the key protects.
     */
    @JsonProperty(value = "ciphertext", required = false)
    private String ciphertext;

    @JsonProperty("ciphertext")
    public String getCiphertext() {
      return ciphertext;
    }
  }

  public static final class GetKeyScope extends Model {
    public GetKeyScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetKeyScope withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "state", required = false)
    private KeyStateInput state;

    @JsonProperty("state")
    public KeyStateInput getState() {
      return state;
    }

    public GetKeyScope withState(KeyStateInput value) {
      this.state = value;
      return this;
    }
  }

  public static final class KeyStateInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public KeyStateInput(String value) {
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
      return other instanceof KeyStateInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final KeyStateInput ENABLED = new KeyStateInput("enabled");
    public static final KeyStateInput DISABLED = new KeyStateInput("disabled");
    public static final KeyStateInput PENDING_DELETION = new KeyStateInput("pending_deletion");
  }

  public static final class ListKeysQuery extends Model {
    public ListKeysQuery() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListKeysQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListKeysQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "state", required = false)
    private KeyStateInput state;

    @JsonProperty("state")
    public KeyStateInput getState() {
      return state;
    }

    public ListKeysQuery withState(KeyStateInput value) {
      this.state = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListKeysQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListKeysQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class KeyListResponse extends Model {
    public KeyListResponse() {}

    @JsonProperty(value = "keys", required = false)
    private List<Key> keys;

    @JsonProperty("keys")
    public List<Key> getKeys() {
      return keys;
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

  public static final class ScheduleKeyDeletionRequestInput extends Model {
    public ScheduleKeyDeletionRequestInput() {}

    /**
     * How long the key sits in pending_deletion before it is hard-deleted. Matches AWS KMS bounds;
     * the deletion can be cancelled at any point inside the window.
     */
    @JsonProperty(value = "recovery_window_days", required = false)
    private Long recovery_window_days;

    @JsonProperty("recovery_window_days")
    public Long getRecoveryWindowDays() {
      return recovery_window_days;
    }

    public ScheduleKeyDeletionRequestInput withRecoveryWindowDays(Long value) {
      this.recovery_window_days = value;
      return this;
    }
  }

  public static final class SignRequestInput extends Model {
    public SignRequestInput() {}

    /**
     * Base64-encoded message to sign. The service hashes it via SHA-256 server-side, so pass the
     * raw payload — do not pre-hash.
     */
    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    public SignRequestInput withMessage(String value) {
      this.message = value;
      return this;
    }

    @JsonProperty(value = "signing_algorithm", required = false)
    private SigningAlgorithmInput signing_algorithm;

    @JsonProperty("signing_algorithm")
    public SigningAlgorithmInput getSigningAlgorithm() {
      return signing_algorithm;
    }

    public SignRequestInput withSigningAlgorithm(SigningAlgorithmInput value) {
      this.signing_algorithm = value;
      return this;
    }
  }

  public static final class SigningAlgorithmInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SigningAlgorithmInput(String value) {
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
      return other instanceof SigningAlgorithmInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SigningAlgorithmInput RSASSAPSSSHA256 =
        new SigningAlgorithmInput("RSASSA_PSS_SHA_256");
    public static final SigningAlgorithmInput RSASSAPKCS1_V15_SHA256 =
        new SigningAlgorithmInput("RSASSA_PKCS1_V1_5_SHA_256");
    public static final SigningAlgorithmInput ECDSASHA256 =
        new SigningAlgorithmInput("ECDSA_SHA_256");
  }

  public static final class SignResponse extends Model {
    public SignResponse() {}

    /**
     * Base64-encoded signature. RSA-PSS: PKCS#1 octet string with saltLen=hashLen=32. ECDSA: ASN.1
     * DER (r,s) tuple per ANSI X9.62.
     */
    @JsonProperty(value = "signature", required = false)
    private String signature;

    @JsonProperty("signature")
    public String getSignature() {
      return signature;
    }

    @JsonProperty(value = "signing_algorithm", required = false)
    private SigningAlgorithm signing_algorithm;

    @JsonProperty("signing_algorithm")
    public SigningAlgorithm getSigningAlgorithm() {
      return signing_algorithm;
    }
  }

  public static final class SigningAlgorithm {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SigningAlgorithm(String value) {
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
      return other instanceof SigningAlgorithm v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SigningAlgorithm RSASSAPSSSHA256 =
        new SigningAlgorithm("RSASSA_PSS_SHA_256");
    public static final SigningAlgorithm RSASSAPKCS1_V15_SHA256 =
        new SigningAlgorithm("RSASSA_PKCS1_V1_5_SHA_256");
    public static final SigningAlgorithm ECDSASHA256 = new SigningAlgorithm("ECDSA_SHA_256");
  }

  public static final class UpdateKeyRequestInput extends Model {
    public UpdateKeyRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public UpdateKeyRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateKeyRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class VerifyRequestInput extends Model {
    public VerifyRequestInput() {}

    /** Base64-encoded original message. */
    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    public VerifyRequestInput withMessage(String value) {
      this.message = value;
      return this;
    }

    /** Base64-encoded signature produced by Sign. */
    @JsonProperty(value = "signature", required = true)
    private String signature;

    @JsonProperty("signature")
    public String getSignature() {
      return signature;
    }

    public VerifyRequestInput withSignature(String value) {
      this.signature = value;
      return this;
    }

    @JsonProperty(value = "signing_algorithm", required = false)
    private SigningAlgorithmInput signing_algorithm;

    @JsonProperty("signing_algorithm")
    public SigningAlgorithmInput getSigningAlgorithm() {
      return signing_algorithm;
    }

    public VerifyRequestInput withSigningAlgorithm(SigningAlgorithmInput value) {
      this.signing_algorithm = value;
      return this;
    }
  }

  public static final class VerifyResponse extends Model {
    public VerifyResponse() {}

    /**
     * True if the signature verifies against the supplied message under the key's public half. A
     * clean mismatch returns false with no error; backend / parameter failures surface as a normal
     * error response.
     */
    @JsonProperty(value = "signature_valid", required = false)
    private Boolean signature_valid;

    @JsonProperty("signature_valid")
    public Boolean getSignatureValid() {
      return signature_valid;
    }
  }
}
