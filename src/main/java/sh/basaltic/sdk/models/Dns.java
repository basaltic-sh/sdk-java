package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed dns wire models. Unknown string enum values are retained. */
public final class Dns {

  private Dns() {}

  public static final class VPCAssociationRequestInput extends Model {
    public VPCAssociationRequestInput() {}

    /**
     * Account-owned VPC UUID or network/vpc CRN to associate with this private zone. Bare names
     * return 400 with "VPC references on DNS zones must be a UUID or a CRN, which carries the
     * region". CRNs resolve in their named region; UUIDs search all regions enabled for DNS.
     * Missing, foreign-account or unconfigured-region VPCs return 404. Incomplete UUID searches or
     * duplicate regional UUID identities fail with a server error. The response contains the
     * canonical VPC UUID.
     */
    @JsonProperty(value = "vpc", required = true)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public VPCAssociationRequestInput withVpc(String value) {
      this.vpc = value;
      return this;
    }
  }

  public static final class VPCAssociationAccepted extends Model {
    public VPCAssociationAccepted() {}

    @JsonProperty(value = "zone_id", required = true)
    private String zone_id;

    @JsonProperty("zone_id")
    public String getZoneId() {
      return zone_id;
    }

    @JsonProperty(value = "vpc_id", required = true)
    private String vpc_id;

    @JsonProperty("vpc_id")
    public String getVpcId() {
      return vpc_id;
    }
  }

  public static final class RecordCreateRequestInput extends Model {
    public RecordCreateRequestInput() {}

    /** Record name (FQDN). */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public RecordCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "type", required = true)
    private RecordTypeInput type;

    @JsonProperty("type")
    public RecordTypeInput getType() {
      return type;
    }

    public RecordCreateRequestInput withType(RecordTypeInput value) {
      this.type = value;
      return this;
    }

    @JsonProperty(value = "ttl", required = false)
    private Long ttl;

    @JsonProperty("ttl")
    public Long getTtl() {
      return ttl;
    }

    public RecordCreateRequestInput withTtl(Long value) {
      this.ttl = value;
      return this;
    }

    @JsonProperty(value = "values", required = true)
    private List<RecordValueInput> values;

    @JsonProperty("values")
    public List<RecordValueInput> getValues() {
      return values;
    }

    public RecordCreateRequestInput withValues(List<RecordValueInput> value) {
      this.values = value;
      return this;
    }
  }

  public static final class RecordTypeInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RecordTypeInput(String value) {
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
      return other instanceof RecordTypeInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RecordTypeInput A = new RecordTypeInput("A");
    public static final RecordTypeInput AAAA = new RecordTypeInput("AAAA");
    public static final RecordTypeInput AFSDB = new RecordTypeInput("AFSDB");
    public static final RecordTypeInput APL = new RecordTypeInput("APL");
    public static final RecordTypeInput CAA = new RecordTypeInput("CAA");
    public static final RecordTypeInput CERT = new RecordTypeInput("CERT");
    public static final RecordTypeInput CNAME = new RecordTypeInput("CNAME");
    public static final RecordTypeInput CSYNC = new RecordTypeInput("CSYNC");
    public static final RecordTypeInput DHCID = new RecordTypeInput("DHCID");
    public static final RecordTypeInput DNAME = new RecordTypeInput("DNAME");
    public static final RecordTypeInput EUI48 = new RecordTypeInput("EUI48");
    public static final RecordTypeInput EUI64 = new RecordTypeInput("EUI64");
    public static final RecordTypeInput HINFO = new RecordTypeInput("HINFO");
    public static final RecordTypeInput HTTPS = new RecordTypeInput("HTTPS");
    public static final RecordTypeInput IPSECKEY = new RecordTypeInput("IPSECKEY");
    public static final RecordTypeInput KX = new RecordTypeInput("KX");
    public static final RecordTypeInput L32 = new RecordTypeInput("L32");
    public static final RecordTypeInput L64 = new RecordTypeInput("L64");
    public static final RecordTypeInput LOC = new RecordTypeInput("LOC");
    public static final RecordTypeInput LP = new RecordTypeInput("LP");
    public static final RecordTypeInput MX = new RecordTypeInput("MX");
    public static final RecordTypeInput NAPTR = new RecordTypeInput("NAPTR");
    public static final RecordTypeInput NID = new RecordTypeInput("NID");
    public static final RecordTypeInput NS = new RecordTypeInput("NS");
    public static final RecordTypeInput OPENPGPKEY = new RecordTypeInput("OPENPGPKEY");
    public static final RecordTypeInput PTR = new RecordTypeInput("PTR");
    public static final RecordTypeInput RKEY = new RecordTypeInput("RKEY");
    public static final RecordTypeInput RP = new RecordTypeInput("RP");
    public static final RecordTypeInput SMIMEA = new RecordTypeInput("SMIMEA");
    public static final RecordTypeInput SPF = new RecordTypeInput("SPF");
    public static final RecordTypeInput SRV = new RecordTypeInput("SRV");
    public static final RecordTypeInput SSHFP = new RecordTypeInput("SSHFP");
    public static final RecordTypeInput SVCB = new RecordTypeInput("SVCB");
    public static final RecordTypeInput TLSA = new RecordTypeInput("TLSA");
    public static final RecordTypeInput TXT = new RecordTypeInput("TXT");
    public static final RecordTypeInput URI = new RecordTypeInput("URI");
  }

  public static final class RecordValueInput extends Model {
    public RecordValueInput() {}

    /** RDATA — wire representation per record type. */
    @JsonProperty(value = "content", required = true)
    private String content;

    @JsonProperty("content")
    public String getContent() {
      return content;
    }

    public RecordValueInput withContent(String value) {
      this.content = value;
      return this;
    }

    /**
     * Must be `false`. `true` is **refused**. There is nowhere to keep a value that is not served,
     * so a disabled value used to be accepted, echoed back in the response, and then dropped — the
     * staged value was gone by the next read, with the write having reported success. Refusing is
     * the honest version. The field remains on the schema because the console and CLI send it on
     * every value; only `true` is rejected. To take a value out of an RRset, remove it from
     * `values`.
     */
    @JsonProperty(value = "disabled", required = false)
    private Boolean disabled;

    @JsonProperty("disabled")
    public Boolean getDisabled() {
      return disabled;
    }

    public RecordValueInput withDisabled(Boolean value) {
      this.disabled = value;
      return this;
    }
  }

  public static final class RecordResponse extends Model {
    public RecordResponse() {}

    @JsonProperty(value = "record", required = false)
    private Record recordValue;

    @JsonProperty("record")
    public Record getRecordValue() {
      return recordValue;
    }
  }

  public static final class Record extends Model {
    public Record() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "zone_id", required = false)
    private String zone_id;

    @JsonProperty("zone_id")
    public String getZoneId() {
      return zone_id;
    }

    /** Record name (FQDN). */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /**
     * Record type. Customer records use one of the creatable RecordType values; reads also surface
     * the platform-managed apex/DNSSEC types (SOA, NS, DNSKEY, DS, NSEC, RRSIG).
     */
    @JsonProperty(value = "type", required = false)
    private String type;

    @JsonProperty("type")
    public String getType() {
      return type;
    }

    @JsonProperty(value = "ttl", required = false)
    private Long ttl;

    @JsonProperty("ttl")
    public Long getTtl() {
      return ttl;
    }

    /**
     * True for platform-managed records (SOA, apex NS, and the DNSSEC set). Managed records are
     * read-only — they cannot be updated or deleted through the API.
     */
    @JsonProperty(value = "managed", required = false)
    private Boolean managed;

    @JsonProperty("managed")
    public Boolean getManaged() {
      return managed;
    }

    @JsonProperty(value = "values", required = false)
    private List<RecordValue> values;

    @JsonProperty("values")
    public List<RecordValue> getValues() {
      return values;
    }
  }

  public static final class RecordValue extends Model {
    public RecordValue() {}

    /** RDATA — wire representation per record type. */
    @JsonProperty(value = "content", required = true)
    private String content;

    @JsonProperty("content")
    public String getContent() {
      return content;
    }

    /**
     * Must be `false`. `true` is **refused**. There is nowhere to keep a value that is not served,
     * so a disabled value used to be accepted, echoed back in the response, and then dropped — the
     * staged value was gone by the next read, with the write having reported success. Refusing is
     * the honest version. The field remains on the schema because the console and CLI send it on
     * every value; only `true` is rejected. To take a value out of an RRset, remove it from
     * `values`.
     */
    @JsonProperty(value = "disabled", required = false)
    private Boolean disabled;

    @JsonProperty("disabled")
    public Boolean getDisabled() {
      return disabled;
    }
  }

  public static final class ZoneCreateRequestInput extends Model {
    public ZoneCreateRequestInput() {}

    /**
     * Zone FQDN. Resource names must not start with the literal crn: prefix or be UUIDs (canonical,
     * compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ZoneCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    /** Free-form note stored with and returned on the zone. */
    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public ZoneCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * `private` restricts the zone to the VPCs named in `vpcs` and requires at least one; `public`
     * (the default) rejects `vpcs` outright rather than ignoring them. Cannot be changed
     * afterwards.
     */
    @JsonProperty(value = "visibility", required = false)
    private ZoneCreateRequestInputVisibility visibility;

    @JsonProperty("visibility")
    public ZoneCreateRequestInputVisibility getVisibility() {
      return visibility;
    }

    public ZoneCreateRequestInput withVisibility(ZoneCreateRequestInputVisibility value) {
      this.visibility = value;
      return this;
    }

    /**
     * Sign the zone with DNSSEC. On unless you say otherwise, and almost every zone should leave it
     * on. **Turn it off only if this domain is served by another DNS provider at the same time as
     * us.** A signed zone puts our DS record at the parent, and that DS covers only the answers WE
     * sign — so a validating resolver that happens to ask the other provider gets a signature it
     * cannot verify and fails the lookup. Roughly half your queries, unpredictably, which is worse
     * than either provider on its own. Unsigned is the only configuration that works for that setup
     * today. Fixed at creation. Turning signing off later breaks the domain until the DS is
     * withdrawn at the registrar and that withdrawal has propagated, which is a sequence this API
     * cannot drive for you.
     */
    @JsonProperty(value = "dnssec", required = false)
    private Boolean dnssec;

    @JsonProperty("dnssec")
    public Boolean getDnssec() {
      return dnssec;
    }

    public ZoneCreateRequestInput withDnssec(Boolean value) {
      this.dnssec = value;
      return this;
    }

    /**
     * Read the domain's records from the nameservers that serve it TODAY and copy them into this
     * zone, before you move the delegation here. Worth asking for when you are migrating a live
     * domain. The delegation is the ownership proof, so the moment you point your registrar at this
     * zone is the moment we start answering for it — and an empty zone answers with nothing, which
     * takes the site and the mail down until you have retyped everything. Runs in the background;
     * the zone is created immediately. Poll GET /v1/zones/{zone_id}/record-import for the outcome.
     * Best effort, and the result says how good it was. A zone transfer is exhaustive and almost
     * always refused; the fallback queries a list of common names and cannot find a record it did
     * not think to ask for. Check `record_import.complete` before you switch your old provider off.
     * Records you have already created are never overwritten, and records this platform manages
     * itself — the SOA, the DNSSEC chain, the zone's nameservers — are never imported.
     */
    @JsonProperty(value = "import_existing_records", required = false)
    private Boolean import_existing_records;

    @JsonProperty("import_existing_records")
    public Boolean getImportExistingRecords() {
      return import_existing_records;
    }

    public ZoneCreateRequestInput withImportExistingRecords(Boolean value) {
      this.import_existing_records = value;
      return this;
    }

    /**
     * Account-owned VPC UUIDs or network/vpc CRNs the zone resolves in. Bare names are rejected
     * with 400 because the request fixes no region. CRNs resolve in their named region; UUIDs
     * search all regions enabled for DNS. Missing, foreign-account or unconfigured-region VPCs
     * return 404. Incomplete UUID searches or duplicate regional UUID identities fail with a server
     * error. References are deduplicated by UUID. Required when visibility=private, rejected when
     * visibility=public. More can be associated later via POST
     * /v1/zones/{zone_id}/vpc-associations.
     */
    @JsonProperty(value = "vpcs", required = false)
    private List<String> vpcs;

    @JsonProperty("vpcs")
    public List<String> getVpcs() {
      return vpcs;
    }

    public ZoneCreateRequestInput withVpcs(List<String> value) {
      this.vpcs = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public ZoneCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class ZoneCreateRequestInputVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ZoneCreateRequestInputVisibility(String value) {
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
      return other instanceof ZoneCreateRequestInputVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ZoneCreateRequestInputVisibility PUBLIC =
        new ZoneCreateRequestInputVisibility("public");
    public static final ZoneCreateRequestInputVisibility PRIVATE =
        new ZoneCreateRequestInputVisibility("private");
  }

  public static final class ZoneResponse extends Model {
    public ZoneResponse() {}

    @JsonProperty(value = "zone", required = false)
    private Zone zone;

    @JsonProperty("zone")
    public Zone getZone() {
      return zone;
    }
  }

  public static final class Zone extends Model {
    public Zone() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Zone FQDN. Resource names must not start with the literal crn: prefix or be UUIDs (canonical,
     * compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /** Free-form description, editable with PATCH. */
    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    /**
     * Authoritative nameservers for the zone — the apex NS set. Copy this list verbatim into your
     * registrar's nameserver configuration to delegate the zone to the platform. These names are
     * unique to THIS zone: each carries a per-zone label, which is what makes the delegation double
     * as the ownership proof (see `ownership`). Two zones for the same domain get different names,
     * and the one the registrar points at is the one that serves. Use them exactly as written —
     * Basaltic's bare nameserver names will not verify the zone.
     */
    @JsonProperty(value = "nameservers", required = false)
    private List<String> nameservers;

    @JsonProperty("nameservers")
    public List<String> getNameservers() {
      return nameservers;
    }

    @JsonProperty(value = "soa", required = false)
    private SOA soa;

    @JsonProperty("soa")
    public SOA getSoa() {
      return soa;
    }

    /**
     * `public` zones answer on the internet-facing nameservers; `private` zones answer only inside
     * the VPCs associated with them (see the vpc-associations endpoints). Fixed at creation.
     */
    @JsonProperty(value = "visibility", required = false)
    private ZoneVisibility visibility;

    @JsonProperty("visibility")
    public ZoneVisibility getVisibility() {
      return visibility;
    }

    @JsonProperty(value = "dnssec", required = false)
    private ZoneDNSSEC dnssec;

    @JsonProperty("dnssec")
    public ZoneDNSSEC getDnssec() {
      return dnssec;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "ownership", required = false)
    private ZoneOwnership ownership;

    @JsonProperty("ownership")
    public ZoneOwnership getOwnership() {
      return ownership;
    }
  }

  public static final class SOA extends Model {
    public SOA() {}

    /** SOA `mname` — first authoritative nameserver for the zone. */
    @JsonProperty(value = "primary_ns", required = false)
    private String primary_ns;

    @JsonProperty("primary_ns")
    public String getPrimaryNs() {
      return primary_ns;
    }

    /**
     * SOA `rname` — the platform's DNS-operations contact. Stamped server-side; not
     * customer-configurable.
     */
    @JsonProperty(value = "admin_email", required = false)
    private String admin_email;

    @JsonProperty("admin_email")
    public String getAdminEmail() {
      return admin_email;
    }

    @JsonProperty(value = "refresh", required = false)
    private Long refresh;

    @JsonProperty("refresh")
    public Long getRefresh() {
      return refresh;
    }

    @JsonProperty(value = "retry", required = false)
    private Long retry;

    @JsonProperty("retry")
    public Long getRetry() {
      return retry;
    }

    @JsonProperty(value = "expire", required = false)
    private Long expire;

    @JsonProperty("expire")
    public Long getExpire() {
      return expire;
    }

    /** NXDOMAIN cache TTL. */
    @JsonProperty(value = "minimum", required = false)
    private Long minimum;

    @JsonProperty("minimum")
    public Long getMinimum() {
      return minimum;
    }
  }

  public static final class ZoneVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ZoneVisibility(String value) {
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
      return other instanceof ZoneVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ZoneVisibility PUBLIC = new ZoneVisibility("public");
    public static final ZoneVisibility PRIVATE = new ZoneVisibility("private");
  }

  public static final class ZoneDNSSEC extends Model {
    public ZoneDNSSEC() {}

    @JsonProperty(value = "enabled", required = true)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    /** Key tag of the key-signing key — matches the DS records below. */
    @JsonProperty(value = "ksk_key_tag", required = false)
    private Long ksk_key_tag;

    @JsonProperty("ksk_key_tag")
    public Long getKskKeyTag() {
      return ksk_key_tag;
    }

    /** Key tag of the zone-signing key. */
    @JsonProperty(value = "zsk_key_tag", required = false)
    private Long zsk_key_tag;

    @JsonProperty("zsk_key_tag")
    public Long getZskKeyTag() {
      return zsk_key_tag;
    }

    /** DNSSEC algorithm number. 13 = ECDSA P-256 SHA-256. */
    @JsonProperty(value = "algorithm", required = false)
    private Long algorithm;

    @JsonProperty("algorithm")
    public Long getAlgorithm() {
      return algorithm;
    }

    @JsonProperty(value = "ds_records", required = false)
    private List<ZoneDSRecord> ds_records;

    @JsonProperty("ds_records")
    public List<ZoneDSRecord> getDsRecords() {
      return ds_records;
    }
  }

  public static final class ZoneDSRecord extends Model {
    public ZoneDSRecord() {}

    @JsonProperty(value = "key_tag", required = true)
    private Long key_tag;

    @JsonProperty("key_tag")
    public Long getKeyTag() {
      return key_tag;
    }

    @JsonProperty(value = "algorithm", required = true)
    private Long algorithm;

    @JsonProperty("algorithm")
    public Long getAlgorithm() {
      return algorithm;
    }

    /** 2 = SHA-256. */
    @JsonProperty(value = "digest_type", required = true)
    private Long digest_type;

    @JsonProperty("digest_type")
    public Long getDigestType() {
      return digest_type;
    }

    @JsonProperty(value = "digest", required = true)
    private String digest;

    @JsonProperty("digest")
    public String getDigest() {
      return digest;
    }

    /**
     * Full zone-file form — `&lt;key_tag&gt; &lt;algorithm&gt; &lt;digest_type&gt; &lt;digest&gt;`.
     */
    @JsonProperty(value = "rdata", required = true)
    private String rdata;

    @JsonProperty("rdata")
    public String getRdata() {
      return rdata;
    }
  }

  public static final class ZoneOwnership extends Model {
    public ZoneOwnership() {}

    /** Whether the zone has proved ownership. Unverified zones do not resolve. */
    @JsonProperty(value = "verified", required = false)
    private Boolean verified;

    @JsonProperty("verified")
    public Boolean getVerified() {
      return verified;
    }

    /** When ownership was first proved. Absent while unverified. */
    @JsonProperty(value = "verified_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> verified_at = JsonField.missing();

    @JsonProperty("verified_at")
    public JsonField<String> getVerifiedAt() {
      return verified_at;
    }

    /**
     * When the proof was last re-confirmed. `verified_at` keeps meaning "first demonstrated" and
     * does not move; this does, on every pass that passes. Absent until the zone has been
     * re-confirmed at least once.
     */
    @JsonProperty(value = "checked_at", required = false)
    private String checked_at;

    @JsonProperty("checked_at")
    public String getCheckedAt() {
      return checked_at;
    }

    /**
     * Present ONLY while the periodic re-proof is failing: the instant the zone stops answering
     * unless it passes again. Absent means healthy. Each pass re-checks a failing zone, so reaching
     * this date takes sustained failure, not one bad afternoon — a transient resolver problem
     * clears itself on the next pass. To clear it deliberately, point the domain's delegation back
     * at this zone's `nameservers` and POST /v1/zones/{zone_id}/verify-ownership. The
     * organization's owner is emailed when this date is set, and again if the zone does stop
     * resolving. A zone is never taken off the air before that message has gone out, so the date
     * here is the earliest the zone can stop answering and never the only warning.
     */
    @JsonProperty(value = "recheck_deadline", required = false)
    private String recheck_deadline;

    @JsonProperty("recheck_deadline")
    public String getRecheckDeadline() {
      return recheck_deadline;
    }
  }

  public static final class GetRecordScope extends Model {
    public GetRecordScope() {}

    @JsonProperty(value = "type", required = false)
    private String type;

    @JsonProperty("type")
    public String getType() {
      return type;
    }

    public GetRecordScope withType(String value) {
      this.type = value;
      return this;
    }

    @JsonProperty(value = "include_managed", required = false)
    private Boolean include_managed;

    @JsonProperty("include_managed")
    public Boolean getIncludeManaged() {
      return include_managed;
    }

    public GetRecordScope withIncludeManaged(Boolean value) {
      this.include_managed = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetRecordScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetZoneScope extends Model {
    public GetZoneScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetZoneScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ZoneRecordImportResponse extends Model {
    public ZoneRecordImportResponse() {}

    @JsonProperty(value = "record_import", required = false)
    private ZoneRecordImport record_import;

    @JsonProperty("record_import")
    public ZoneRecordImport getRecordImport() {
      return record_import;
    }
  }

  public static final class ZoneRecordImport extends Model {
    public ZoneRecordImport() {}

    /**
     * `pending` while the background job runs. `complete` means the scan ran and what it found was
     * applied — not that everything the domain has is now here; see `complete`. `pending` is
     * bounded. A scan is capped well below the point at which this stops reporting it, so a job
     * that dies without recording an outcome is reported as `failed` rather than staying `pending`
     * for the life of the zone. There is no state that means "still importing" after that bound,
     * and nothing you can poll for that would ever change.
     */
    @JsonProperty(value = "state", required = false)
    private ZoneRecordImportState state;

    @JsonProperty("state")
    public ZoneRecordImportState getState() {
      return state;
    }

    /**
     * How the records were found, in descending order of how much the result is worth. `axfr` is a
     * zone transfer: the whole zone, exactly. `nsec-walk` follows the zone's own DNSSEC NSEC chain,
     * which names every record set in it — also exact, and available on signed zones whose provider
     * refuses transfers. `query` is a list of common names, which finds what it thought to ask for
     * and cannot know what it missed. Absent while pending.
     */
    @JsonProperty(value = "source", required = false)
    private ZoneRecordImportSource source;

    @JsonProperty("source")
    public ZoneRecordImportSource getSource() {
      return source;
    }

    /**
     * True for the two sources that enumerate the zone — `axfr` and `nsec-walk` — and false for
     * `query`. **This is the field to read before switching your old provider off.** A false here
     * means records may exist that we did not find, not that none do.
     */
    @JsonProperty(value = "complete", required = false)
    private Boolean complete;

    @JsonProperty("complete")
    public Boolean getComplete() {
      return complete;
    }

    /** Record sets the scan turned up. */
    @JsonProperty(value = "found", required = false)
    private Long found;

    @JsonProperty("found")
    public Long getFound() {
      return found;
    }

    /**
     * Record sets actually written. Lower than `found` for records you had already created — yours
     * win — and for the ones this platform manages itself.
     */
    @JsonProperty(value = "imported", required = false)
    private Long imported;

    @JsonProperty("imported")
    public Long getImported() {
      return imported;
    }

    /** What could not be established, and what was deliberately not imported. */
    @JsonProperty(value = "notes", required = false)
    private List<String> notes;

    @JsonProperty("notes")
    public List<String> getNotes() {
      return notes;
    }

    /** Present only when state is `failed`, and says what could not be done. */
    @JsonProperty(value = "error", required = false)
    private String error;

    @JsonProperty("error")
    public String getError() {
      return error;
    }

    @JsonProperty(value = "updated_at", required = false)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class ZoneRecordImportState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ZoneRecordImportState(String value) {
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
      return other instanceof ZoneRecordImportState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ZoneRecordImportState PENDING = new ZoneRecordImportState("pending");
    public static final ZoneRecordImportState COMPLETE = new ZoneRecordImportState("complete");
    public static final ZoneRecordImportState FAILED = new ZoneRecordImportState("failed");
  }

  public static final class ZoneRecordImportSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ZoneRecordImportSource(String value) {
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
      return other instanceof ZoneRecordImportSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ZoneRecordImportSource AXFR = new ZoneRecordImportSource("axfr");
    public static final ZoneRecordImportSource NSEC_WALK = new ZoneRecordImportSource("nsec-walk");
    public static final ZoneRecordImportSource QUERY = new ZoneRecordImportSource("query");
  }

  public static final class ZoneImportRequestInput extends Model {
    public ZoneImportRequestInput() {}

    /**
     * The zone file, as text. `$ORIGIN`, `$TTL`, `$GENERATE`, relative names and parenthesised
     * multi-line records are all honoured; `$INCLUDE` is refused, because the path it names would
     * be read on our filesystem rather than yours.
     */
    @JsonProperty(value = "zone_file", required = true)
    private String zone_file;

    @JsonProperty("zone_file")
    public String getZoneFile() {
      return zone_file;
    }

    public ZoneImportRequestInput withZoneFile(String value) {
      this.zone_file = value;
      return this;
    }
  }

  public static final class ZoneImportResponse extends Model {
    public ZoneImportResponse() {}

    @JsonProperty(value = "import", required = false)
    private ZoneImportResult importValue;

    @JsonProperty("import")
    public ZoneImportResult getImportValue() {
      return importValue;
    }
  }

  public static final class ZoneImportResult extends Model {
    public ZoneImportResult() {}

    /** RRsets in the file that the zone did not already have. */
    @JsonProperty(value = "records_created", required = false)
    private Long records_created;

    @JsonProperty("records_created")
    public Long getRecordsCreated() {
      return records_created;
    }

    /**
     * RRsets that existed at the same name and type and were replaced wholesale by the file's
     * values.
     */
    @JsonProperty(value = "records_replaced", required = false)
    private Long records_replaced;

    @JsonProperty("records_replaced")
    public Long getRecordsReplaced() {
      return records_replaced;
    }

    /** Imported RRset count per record type. */
    @JsonProperty(value = "records_by_type", required = false)
    private Map<String, Long> records_by_type;

    @JsonProperty("records_by_type")
    public Map<String, Long> getRecordsByType() {
      return records_by_type;
    }

    @JsonProperty(value = "skipped", required = false)
    private List<ZoneImportSkipped> skipped;

    @JsonProperty("skipped")
    public List<ZoneImportSkipped> getSkipped() {
      return skipped;
    }

    /**
     * Records that were imported, but not exactly as written — an RRset the file gave more than one
     * TTL, for instance.
     */
    @JsonProperty(value = "warnings", required = false)
    private List<String> warnings;

    @JsonProperty("warnings")
    public List<String> getWarnings() {
      return warnings;
    }
  }

  public static final class ZoneImportSkipped extends Model {
    public ZoneImportSkipped() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "type", required = false)
    private String type;

    @JsonProperty("type")
    public String getType() {
      return type;
    }

    @JsonProperty(value = "reason", required = false)
    private String reason;

    @JsonProperty("reason")
    public String getReason() {
      return reason;
    }
  }

  public static final class ListRecordsQuery extends Model {
    public ListRecordsQuery() {}

    @JsonProperty(value = "type", required = false)
    private String type;

    @JsonProperty("type")
    public String getType() {
      return type;
    }

    public ListRecordsQuery withType(String value) {
      this.type = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRecordsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRecordsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "include_managed", required = false)
    private Boolean include_managed;

    @JsonProperty("include_managed")
    public Boolean getIncludeManaged() {
      return include_managed;
    }

    public ListRecordsQuery withIncludeManaged(Boolean value) {
      this.include_managed = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListRecordsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListRecordsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class RecordListResponse extends Model {
    public RecordListResponse() {}

    @JsonProperty(value = "records", required = false)
    private List<Record> records;

    @JsonProperty("records")
    public List<Record> getRecords() {
      return records;
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

  public static final class ListZoneVPCAssociationsQuery extends Model {
    public ListZoneVPCAssociationsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListZoneVPCAssociationsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListZoneVPCAssociationsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class VPCAssociationsResponse extends Model {
    public VPCAssociationsResponse() {}

    @JsonProperty(value = "vpc_ids", required = true)
    private List<String> vpc_ids;

    @JsonProperty("vpc_ids")
    public List<String> getVpcIds() {
      return vpc_ids;
    }
  }

  public static final class ListZonesQuery extends Model {
    public ListZonesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListZonesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListZonesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListZonesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListZonesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ZoneListResponse extends Model {
    public ZoneListResponse() {}

    @JsonProperty(value = "zones", required = false)
    private List<Zone> zones;

    @JsonProperty("zones")
    public List<Zone> getZones() {
      return zones;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class RecordUpdateRequestInput extends Model {
    public RecordUpdateRequestInput() {}

    @JsonProperty(value = "ttl", required = false)
    private Long ttl;

    @JsonProperty("ttl")
    public Long getTtl() {
      return ttl;
    }

    public RecordUpdateRequestInput withTtl(Long value) {
      this.ttl = value;
      return this;
    }

    @JsonProperty(value = "values", required = false)
    private List<RecordValueInput> values;

    @JsonProperty("values")
    public List<RecordValueInput> getValues() {
      return values;
    }

    public RecordUpdateRequestInput withValues(List<RecordValueInput> value) {
      this.values = value;
      return this;
    }
  }

  public static final class ZoneUpdateRequestInput extends Model {
    public ZoneUpdateRequestInput() {}

    /** Omit to preserve the description; send an empty string to clear it. */
    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public ZoneUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, JsonNode> tags;

    @JsonProperty("tags")
    public Map<String, JsonNode> getTags() {
      return tags;
    }

    public ZoneUpdateRequestInput withTags(Map<String, JsonNode> value) {
      this.tags = value;
      return this;
    }
  }
}
