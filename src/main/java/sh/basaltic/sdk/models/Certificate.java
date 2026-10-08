package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

/** Typed certificate wire models. Unknown string enum values are retained. */
public final class Certificate {

  private Certificate() {}

  public static final class CertificateIssueRequestInput extends Model {
    public CertificateIssueRequestInput() {}

    /**
     * Unique per account. Surfaces in the CRN
     * (`crn:certificate::&lt;account&gt;:certificate/&lt;name&gt;`), so it must be URL-safe —
     * letters, digits, dot, dash, underscore. Resource names must not start with the literal crn:
     * prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CertificateIssueRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    /** Capped at 100 to stay inside the certificate authority's per-order limits. */
    @JsonProperty(value = "domains", required = true)
    private List<String> domains;

    @JsonProperty("domains")
    public List<String> getDomains() {
      return domains;
    }

    public CertificateIssueRequestInput withDomains(List<String> value) {
      this.domains = value;
      return this;
    }

    @JsonProperty(value = "key_algorithm", required = false)
    private CertificateKeyAlgorithmInput key_algorithm;

    @JsonProperty("key_algorithm")
    public CertificateKeyAlgorithmInput getKeyAlgorithm() {
      return key_algorithm;
    }

    public CertificateIssueRequestInput withKeyAlgorithm(CertificateKeyAlgorithmInput value) {
      this.key_algorithm = value;
      return this;
    }

    /**
     * Defaults to "acme" — issued by the platform CA. Set to "uploaded" to store customer-supplied
     * PEM material instead; certificate_pem + private_key_pem must then be provided.
     */
    @JsonProperty(value = "source", required = false)
    private CertificateSourceInput source;

    @JsonProperty("source")
    public CertificateSourceInput getSource() {
      return source;
    }

    public CertificateIssueRequestInput withSource(CertificateSourceInput value) {
      this.source = value;
      return this;
    }

    /** PEM-encoded leaf certificate. Required when source=uploaded. */
    @JsonProperty(value = "certificate_pem", required = false)
    private String certificate_pem;

    @JsonProperty("certificate_pem")
    public String getCertificatePem() {
      return certificate_pem;
    }

    public CertificateIssueRequestInput withCertificatePem(String value) {
      this.certificate_pem = value;
      return this;
    }

    /** PEM-encoded intermediate chain (optional when source=uploaded). */
    @JsonProperty(value = "chain_pem", required = false)
    private String chain_pem;

    @JsonProperty("chain_pem")
    public String getChainPem() {
      return chain_pem;
    }

    public CertificateIssueRequestInput withChainPem(String value) {
      this.chain_pem = value;
      return this;
    }

    /** PEM-encoded private key. Required when source=uploaded. */
    @JsonProperty(value = "private_key_pem", required = false)
    private String private_key_pem;

    @JsonProperty("private_key_pem")
    public String getPrivateKeyPem() {
      return private_key_pem;
    }

    public CertificateIssueRequestInput withPrivateKeyPem(String value) {
      this.private_key_pem = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CertificateIssueRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class CertificateKeyAlgorithmInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateKeyAlgorithmInput(String value) {
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
      return other instanceof CertificateKeyAlgorithmInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateKeyAlgorithmInput ECDSA_P256 =
        new CertificateKeyAlgorithmInput("ecdsa-p256");
    public static final CertificateKeyAlgorithmInput ECDSA_P384 =
        new CertificateKeyAlgorithmInput("ecdsa-p384");
    public static final CertificateKeyAlgorithmInput RSA2048 =
        new CertificateKeyAlgorithmInput("rsa-2048");
    public static final CertificateKeyAlgorithmInput RSA4096 =
        new CertificateKeyAlgorithmInput("rsa-4096");
  }

  public static final class CertificateSourceInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateSourceInput(String value) {
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
      return other instanceof CertificateSourceInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateSourceInput ACME = new CertificateSourceInput("acme");
    public static final CertificateSourceInput UPLOADED = new CertificateSourceInput("uploaded");
  }

  public static final class CertificateResponse extends Model {
    public CertificateResponse() {}

    @JsonProperty(value = "certificate", required = false)
    private Certificate2 certificate;

    @JsonProperty("certificate")
    public Certificate2 getCertificate() {
      return certificate;
    }
  }

  public static final class Certificate2 extends Model {
    public Certificate2() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * Name-based, so an IAM policy can wildcard a naming convention
     * (`crn:certificate::my-account:certificate/prod-*`). The region slot is empty for
     * compatibility; certificate storage and KMS material are regional.
     */
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

    @JsonProperty(value = "domains", required = false)
    private List<String> domains;

    @JsonProperty("domains")
    public List<String> getDomains() {
      return domains;
    }

    @JsonProperty(value = "status", required = false)
    private CertificateStatus status;

    @JsonProperty("status")
    public CertificateStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "source", required = false)
    private CertificateSource source;

    @JsonProperty("source")
    public CertificateSource getSource() {
      return source;
    }

    @JsonProperty(value = "key_algorithm", required = false)
    private CertificateKeyAlgorithm key_algorithm;

    @JsonProperty("key_algorithm")
    public CertificateKeyAlgorithm getKeyAlgorithm() {
      return key_algorithm;
    }

    /**
     * Per-domain CNAME delegation state — one entry per domain on the cert. While
     * status=pending_dns issuance waits for every challenge's `verified` to flip true; use
     * `expected_cname` and `our_dns` to tell which records need to be added at the registrar.
     */
    @JsonProperty(value = "challenges", required = false)
    private List<CertificateChallenge> challenges;

    @JsonProperty("challenges")
    public List<CertificateChallenge> getChallenges() {
      return challenges;
    }

    /** PEM-encoded leaf certificate. Empty until active. */
    @JsonProperty(value = "certificate_pem", required = false)
    private String certificate_pem;

    @JsonProperty("certificate_pem")
    public String getCertificatePem() {
      return certificate_pem;
    }

    /** PEM-encoded intermediate chain. */
    @JsonProperty(value = "chain_pem", required = false)
    private String chain_pem;

    @JsonProperty("chain_pem")
    public String getChainPem() {
      return chain_pem;
    }

    /**
     * Hex SHA-256 of the leaf's DER — the certificate's material version. Changes on every
     * rotation; consumers use it to know when to re-fetch material and to verify they fetched the
     * intended generation. Empty until the cert has a leaf.
     */
    @JsonProperty(value = "fingerprint", required = false)
    private String fingerprint;

    @JsonProperty("fingerprint")
    public String getFingerprint() {
      return fingerprint;
    }

    @JsonProperty(value = "issued_at", required = false)
    private String issued_at;

    @JsonProperty("issued_at")
    public String getIssuedAt() {
      return issued_at;
    }

    @JsonProperty(value = "expires_at", required = false)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    /**
     * Active faults, ordered newest first. Empty when healthy. Renewal failures are warnings while
     * valid certificate material still serves. Codes: CERTIFICATE_ISSUANCE_START_FAILED (issuance
     * could not be scheduled), CERTIFICATE_ISSUANCE_FAILED (the signing request failed),
     * CERTIFICATE_RENEWAL_FAILED (renewal did not complete; a warning while valid material is still
     * serving, an error once it has expired), CERTIFICATE_REVOCATION_FAILED (revocation did not
     * complete).
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
  }

  public static final class CertificateStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateStatus(String value) {
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
      return other instanceof CertificateStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateStatus PENDING_DNS = new CertificateStatus("pending_dns");
    public static final CertificateStatus PENDING = new CertificateStatus("pending");
    public static final CertificateStatus ACTIVE = new CertificateStatus("active");
    public static final CertificateStatus ERROR = new CertificateStatus("error");
    public static final CertificateStatus EXPIRED = new CertificateStatus("expired");
    public static final CertificateStatus REVOKED = new CertificateStatus("revoked");
  }

  public static final class CertificateSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateSource(String value) {
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
      return other instanceof CertificateSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateSource ACME = new CertificateSource("acme");
    public static final CertificateSource UPLOADED = new CertificateSource("uploaded");
  }

  public static final class CertificateKeyAlgorithm {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateKeyAlgorithm(String value) {
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
      return other instanceof CertificateKeyAlgorithm v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateKeyAlgorithm ECDSA_P256 =
        new CertificateKeyAlgorithm("ecdsa-p256");
    public static final CertificateKeyAlgorithm ECDSA_P384 =
        new CertificateKeyAlgorithm("ecdsa-p384");
    public static final CertificateKeyAlgorithm RSA2048 = new CertificateKeyAlgorithm("rsa-2048");
    public static final CertificateKeyAlgorithm RSA4096 = new CertificateKeyAlgorithm("rsa-4096");
  }

  public static final class CertificateChallenge extends Model {
    public CertificateChallenge() {}

    /** The cert SAN this challenge belongs to (as the customer wrote it). */
    @JsonProperty(value = "domain", required = false)
    private String domain;

    @JsonProperty("domain")
    public String getDomain() {
      return domain;
    }

    /**
     * Full LHS of the CNAME record the customer needs to add. For wildcard SANs this is the parent
     * name (`_acme-challenge.example.com.`), not the literal SAN — wildcards validate at their
     * parent under RFC 8555 §8.4.
     */
    @JsonProperty(value = "cname_record_name", required = false)
    private String cname_record_name;

    @JsonProperty("cname_record_name")
    public String getCnameRecordName() {
      return cname_record_name;
    }

    /**
     * Target FQDN (RHS of the CNAME). Hosted in the platform's validation zone, where the per-order
     * TXT is published during issuance.
     */
    @JsonProperty(value = "expected_cname", required = false)
    private String expected_cname;

    @JsonProperty("expected_cname")
    public String getExpectedCname() {
      return expected_cname;
    }

    /**
     * True when the domain is hosted on the platform DNS service and the CNAME was created
     * automatically. False means the customer owns the zone and must add the CNAME at their
     * registrar.
     */
    @JsonProperty(value = "our_dns", required = false)
    private Boolean our_dns;

    @JsonProperty("our_dns")
    public Boolean getOurDns() {
      return our_dns;
    }

    /**
     * True once the CNAME has resolved to expected_cname; cert issuance only proceeds when every
     * challenge is verified.
     */
    @JsonProperty(value = "verified", required = false)
    private Boolean verified;

    @JsonProperty("verified")
    public Boolean getVerified() {
      return verified;
    }

    @JsonProperty(value = "verified_at", required = false)
    private String verified_at;

    @JsonProperty("verified_at")
    public String getVerifiedAt() {
      return verified_at;
    }

    /**
     * Active verification warnings only; empty when healthy. Successful verification resolves
     * verification faults while retaining history. verified records a successful observation and
     * remains true if a later renewal observes a DNS failure. A CNAME mismatch records
     * CERTIFICATE_DNS_VERIFICATION_FAILED as a warning; verified does not move. Internal history
     * uses the parent CRN followed by /challenge/&lt;stored-uuid&gt;; no separate endpoint is
     * exposed.
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
    }
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

  public static final class CreateCertificateResponse {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateCertificateResponse(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "CreateCertificateResponse{[REDACTED]}";
    }

    public static CreateCertificateResponse ofVariant1(CertificateResponse value) {
      Model.validate(value);
      return new CreateCertificateResponse(Json.tree(value));
    }

    public Optional<CertificateResponse> asVariant1() {
      try {
        CertificateResponse result =
            Json.convert(value, new TypeReference<CertificateResponse>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }
  }

  public static final class GetCertificateScope extends Model {
    public GetCertificateScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetCertificateScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class MaterialResponse extends Model {
    public MaterialResponse() {}

    @JsonProperty(value = "material", required = false)
    private Material material;

    @JsonProperty("material")
    public Material getMaterial() {
      return material;
    }
  }

  public static final class Material extends Model {
    public Material() {}

    /** PEM-encoded leaf certificate. */
    @JsonProperty(value = "certificate_pem", required = false)
    private String certificate_pem;

    @JsonProperty("certificate_pem")
    public String getCertificatePem() {
      return certificate_pem;
    }

    /** PEM-encoded intermediate chain. */
    @JsonProperty(value = "chain_pem", required = false)
    private String chain_pem;

    @JsonProperty("chain_pem")
    public String getChainPem() {
      return chain_pem;
    }

    /** PEM-encoded private key (decrypted). */
    @JsonProperty(value = "private_key_pem", required = false)
    private String private_key_pem;

    @JsonProperty("private_key_pem")
    public String getPrivateKeyPem() {
      return private_key_pem;
    }

    /**
     * Hex SHA-256 of the leaf's DER. A caller confirms this matches the version the feed named
     * before installing the material.
     */
    @JsonProperty(value = "fingerprint", required = false)
    private String fingerprint;

    @JsonProperty("fingerprint")
    public String getFingerprint() {
      return fingerprint;
    }
  }

  public static final class ListCertificatesQuery extends Model {
    public ListCertificatesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListCertificatesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListCertificatesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListCertificatesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListCertificatesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class CertificateListResponse extends Model {
    public CertificateListResponse() {}

    @JsonProperty(value = "certificates", required = false)
    private List<Certificate2> certificates;

    @JsonProperty("certificates")
    public List<Certificate2> getCertificates() {
      return certificates;
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
