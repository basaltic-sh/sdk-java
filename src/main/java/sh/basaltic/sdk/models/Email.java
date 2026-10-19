package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

/** Typed email wire models. Unknown string enum values are retained. */
public final class Email {

  private Email() {}

  public static final class SuppressionOverrideRequestInput extends Model {
    public SuppressionOverrideRequestInput() {}

    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    public SuppressionOverrideRequestInput withAddress(String value) {
      this.address = value;
      return this;
    }
  }

  public static final class ConfigurationSetResponse extends Model {
    public ConfigurationSetResponse() {}

    @JsonProperty(value = "configuration_set", required = true)
    private ConfigurationSet configuration_set;

    @JsonProperty("configuration_set")
    public ConfigurationSet getConfigurationSet() {
      return configuration_set;
    }
  }

  public static final class ConfigurationSet extends Model {
    public ConfigurationSet() {}

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

    @JsonProperty(value = "sending_enabled", required = true)
    private Boolean sending_enabled;

    @JsonProperty("sending_enabled")
    public Boolean getSendingEnabled() {
      return sending_enabled;
    }

    @JsonProperty(value = "suppression_overrides", required = true)
    private List<String> suppression_overrides;

    @JsonProperty("suppression_overrides")
    public List<String> getSuppressionOverrides() {
      return suppression_overrides;
    }

    @JsonProperty(value = "ip_pool", required = false)
    private ResourceRef ip_pool;

    @JsonProperty("ip_pool")
    public ResourceRef getIpPool() {
      return ip_pool;
    }

    @JsonProperty(value = "tracking_open", required = false)
    private Boolean tracking_open;

    @JsonProperty("tracking_open")
    public Boolean getTrackingOpen() {
      return tracking_open;
    }

    @JsonProperty(value = "tracking_click", required = false)
    private Boolean tracking_click;

    @JsonProperty("tracking_click")
    public Boolean getTrackingClick() {
      return tracking_click;
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

  public static final class IdentityResponse extends Model {
    public IdentityResponse() {}

    @JsonProperty(value = "identity", required = true)
    private Identity identity;

    @JsonProperty("identity")
    public Identity getIdentity() {
      return identity;
    }
  }

  public static final class Identity extends Model {
    public Identity() {}

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
     * Sender domain. Resource names must not start with the literal crn: prefix or be UUIDs
     * (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "type", required = true)
    private IdentityType type;

    @JsonProperty("type")
    public IdentityType getType() {
      return type;
    }

    @JsonProperty(value = "status", required = true)
    private IdentityStatus status;

    @JsonProperty("status")
    public IdentityStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "dkim_selector", required = true)
    private String dkim_selector;

    @JsonProperty("dkim_selector")
    public String getDkimSelector() {
      return dkim_selector;
    }

    @JsonProperty(value = "dkim_pending_selector", required = false)
    private String dkim_pending_selector;

    @JsonProperty("dkim_pending_selector")
    public String getDkimPendingSelector() {
      return dkim_pending_selector;
    }

    @JsonProperty(value = "dkim_selector_old", required = false)
    private String dkim_selector_old;

    @JsonProperty("dkim_selector_old")
    public String getDkimSelectorOld() {
      return dkim_selector_old;
    }

    @JsonProperty(value = "dkim_old_expires_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> dkim_old_expires_at = JsonField.missing();

    @JsonProperty("dkim_old_expires_at")
    public JsonField<String> getDkimOldExpiresAt() {
      return dkim_old_expires_at;
    }

    @JsonProperty(value = "mail_from_domain", required = false)
    private String mail_from_domain;

    @JsonProperty("mail_from_domain")
    public String getMailFromDomain() {
      return mail_from_domain;
    }

    @JsonProperty(value = "mail_from_status", required = false)
    private IdentityMailFromStatus mail_from_status;

    @JsonProperty("mail_from_status")
    public IdentityMailFromStatus getMailFromStatus() {
      return mail_from_status;
    }

    @JsonProperty(value = "mail_from_verified_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> mail_from_verified_at = JsonField.missing();

    @JsonProperty("mail_from_verified_at")
    public JsonField<String> getMailFromVerifiedAt() {
      return mail_from_verified_at;
    }

    @JsonProperty(value = "bimi_logo_url", required = false)
    private String bimi_logo_url;

    @JsonProperty("bimi_logo_url")
    public String getBimiLogoUrl() {
      return bimi_logo_url;
    }

    @JsonProperty(value = "bimi_vmc_url", required = false)
    private String bimi_vmc_url;

    @JsonProperty("bimi_vmc_url")
    public String getBimiVmcUrl() {
      return bimi_vmc_url;
    }

    @JsonProperty(value = "bimi_status", required = false)
    private IdentityBimiStatus bimi_status;

    @JsonProperty("bimi_status")
    public IdentityBimiStatus getBimiStatus() {
      return bimi_status;
    }

    @JsonProperty(value = "bimi_verified_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> bimi_verified_at = JsonField.missing();

    @JsonProperty("bimi_verified_at")
    public JsonField<String> getBimiVerifiedAt() {
      return bimi_verified_at;
    }

    @JsonProperty(value = "verified_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> verified_at = JsonField.missing();

    @JsonProperty("verified_at")
    public JsonField<String> getVerifiedAt() {
      return verified_at;
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

    @JsonProperty(value = "suspended_reason", required = false)
    private String suspended_reason;

    @JsonProperty("suspended_reason")
    public String getSuspendedReason() {
      return suspended_reason;
    }

    @JsonProperty(value = "suspended_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> suspended_at = JsonField.missing();

    @JsonProperty("suspended_at")
    public JsonField<String> getSuspendedAt() {
      return suspended_at;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "dns_records", required = false)
    private List<DNSRecord> dns_records;

    @JsonProperty("dns_records")
    public List<DNSRecord> getDnsRecords() {
      return dns_records;
    }
  }

  public static final class IdentityType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public IdentityType(String value) {
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
      return other instanceof IdentityType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final IdentityType DOMAIN = new IdentityType("domain");
  }

  public static final class IdentityStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public IdentityStatus(String value) {
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
      return other instanceof IdentityStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final IdentityStatus PENDING = new IdentityStatus("pending");
    public static final IdentityStatus VERIFIED = new IdentityStatus("verified");
    public static final IdentityStatus FAILED = new IdentityStatus("failed");
    public static final IdentityStatus SUSPENDED = new IdentityStatus("suspended");
  }

  public static final class IdentityMailFromStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public IdentityMailFromStatus(String value) {
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
      return other instanceof IdentityMailFromStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final IdentityMailFromStatus PENDING = new IdentityMailFromStatus("pending");
    public static final IdentityMailFromStatus VERIFIED = new IdentityMailFromStatus("verified");
    public static final IdentityMailFromStatus FAILED = new IdentityMailFromStatus("failed");
  }

  public static final class IdentityBimiStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public IdentityBimiStatus(String value) {
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
      return other instanceof IdentityBimiStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final IdentityBimiStatus PENDING = new IdentityBimiStatus("pending");
    public static final IdentityBimiStatus VERIFIED = new IdentityBimiStatus("verified");
    public static final IdentityBimiStatus FAILED = new IdentityBimiStatus("failed");
  }

  public static final class DNSRecord extends Model {
    public DNSRecord() {}

    @JsonProperty(value = "purpose", required = true)
    private DNSRecordPurpose purpose;

    @JsonProperty("purpose")
    public DNSRecordPurpose getPurpose() {
      return purpose;
    }

    @JsonProperty(value = "type", required = true)
    private DNSRecordType type;

    @JsonProperty("type")
    public DNSRecordType getType() {
      return type;
    }

    /** FQDN to publish the record at. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /**
     * Complete copyable record data: unquoted TXT content, CNAME target, or MX priority followed by
     * host.
     */
    @JsonProperty(value = "value", required = true)
    private String value;

    @JsonProperty("value")
    public String getValue() {
      return value;
    }

    /**
     * Required for this sending/receiving function. For an alternative_group, one alternative
     * satisfies the requirement.
     */
    @JsonProperty(value = "required", required = true)
    private Boolean required;

    @JsonProperty("required")
    public Boolean getRequired() {
      return required;
    }

    @JsonProperty(value = "group", required = true)
    private DNSRecordGroup group;

    @JsonProperty("group")
    public DNSRecordGroup getGroup() {
      return group;
    }

    /**
     * Records sharing this value are alternatives. Publish exactly one record from a required
     * alternative group; TXT and CNAME cannot coexist at the same name.
     */
    @JsonProperty(value = "alternative_group", required = false)
    private String alternative_group;

    @JsonProperty("alternative_group")
    public String getAlternativeGroup() {
      return alternative_group;
    }
  }

  public static final class DNSRecordPurpose {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DNSRecordPurpose(String value) {
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
      return other instanceof DNSRecordPurpose v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final DNSRecordPurpose OWNERSHIP = new DNSRecordPurpose("ownership");
    public static final DNSRecordPurpose DKIM = new DNSRecordPurpose("dkim");
    public static final DNSRecordPurpose DKIM_CNAME = new DNSRecordPurpose("dkim_cname");
    public static final DNSRecordPurpose DKIM_PENDING = new DNSRecordPurpose("dkim_pending");
    public static final DNSRecordPurpose DKIM_PENDING_CNAME =
        new DNSRecordPurpose("dkim_pending_cname");
    public static final DNSRecordPurpose DKIM_ROTATED_OUT =
        new DNSRecordPurpose("dkim_rotated_out");
    public static final DNSRecordPurpose SPF = new DNSRecordPurpose("spf");
    public static final DNSRecordPurpose DMARC = new DNSRecordPurpose("dmarc");
    public static final DNSRecordPurpose RETURN_PATH = new DNSRecordPurpose("return_path");
    public static final DNSRecordPurpose MAIL_FROM_MX = new DNSRecordPurpose("mail_from_mx");
    public static final DNSRecordPurpose MAIL_FROM_SPF = new DNSRecordPurpose("mail_from_spf");
    public static final DNSRecordPurpose BIMI = new DNSRecordPurpose("bimi");
    public static final DNSRecordPurpose RECEIVING_MX = new DNSRecordPurpose("receiving_mx");
  }

  public static final class DNSRecordType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DNSRecordType(String value) {
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
      return other instanceof DNSRecordType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final DNSRecordType TXT = new DNSRecordType("TXT");
    public static final DNSRecordType CNAME = new DNSRecordType("CNAME");
    public static final DNSRecordType MX = new DNSRecordType("MX");
  }

  public static final class DNSRecordGroup {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DNSRecordGroup(String value) {
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
      return other instanceof DNSRecordGroup v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final DNSRecordGroup SENDING = new DNSRecordGroup("sending");
    public static final DNSRecordGroup RECEIVING = new DNSRecordGroup("receiving");
  }

  public static final class CreateConfigurationSetRequestInput extends Model {
    public CreateConfigurationSetRequestInput() {}

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

    public CreateConfigurationSetRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "sending_enabled", required = false)
    private Boolean sending_enabled;

    @JsonProperty("sending_enabled")
    public Boolean getSendingEnabled() {
      return sending_enabled;
    }

    public CreateConfigurationSetRequestInput withSendingEnabled(Boolean value) {
      this.sending_enabled = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateConfigurationSetRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /** UUID, CRN or account-unique name. Omit to preserve; null detaches the pool. */
    @JsonProperty(value = "ip_pool", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> ip_pool = JsonField.missing();

    @JsonProperty("ip_pool")
    public JsonField<String> getIpPool() {
      return ip_pool;
    }

    public CreateConfigurationSetRequestInput withIpPool(JsonField<String> value) {
      this.ip_pool = value;
      return this;
    }

    @JsonProperty(value = "tracking_open", required = false)
    private Boolean tracking_open;

    @JsonProperty("tracking_open")
    public Boolean getTrackingOpen() {
      return tracking_open;
    }

    public CreateConfigurationSetRequestInput withTrackingOpen(Boolean value) {
      this.tracking_open = value;
      return this;
    }

    @JsonProperty(value = "tracking_click", required = false)
    private Boolean tracking_click;

    @JsonProperty("tracking_click")
    public Boolean getTrackingClick() {
      return tracking_click;
    }

    public CreateConfigurationSetRequestInput withTrackingClick(Boolean value) {
      this.tracking_click = value;
      return this;
    }

    @JsonProperty(value = "suppression_overrides", required = false)
    private List<String> suppression_overrides;

    @JsonProperty("suppression_overrides")
    public List<String> getSuppressionOverrides() {
      return suppression_overrides;
    }

    public CreateConfigurationSetRequestInput withSuppressionOverrides(List<String> value) {
      this.suppression_overrides = value;
      return this;
    }
  }

  public static final class CreateIPPoolRequestInput extends Model {
    public CreateIPPoolRequestInput() {}

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

    public CreateIPPoolRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public CreateIPPoolRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }
  }

  public static final class IPPoolResponse extends Model {
    public IPPoolResponse() {}

    @JsonProperty(value = "ip_pool", required = true)
    private IPPool ip_pool;

    @JsonProperty("ip_pool")
    public IPPool getIpPool() {
      return ip_pool;
    }
  }

  public static final class IPPool extends Model {
    public IPPool() {}

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

  public static final class CreateIdentityRequestInput extends Model {
    public CreateIdentityRequestInput() {}

    /**
     * Sender domain (FQDN, lowercase). Resource names must not start with the literal crn: prefix
     * or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateIdentityRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateIdentityRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class CreateRecipientRuleRequestInput extends Model {
    public CreateRecipientRuleRequestInput() {}

    /**
     * Exact local part, local-part prefix, or catch-all for this identity. Exact matches take
     * precedence, then the longest prefix, then catch-all.
     */
    @JsonProperty(value = "match_type", required = true)
    private CreateRecipientRuleRequestInputMatchType match_type;

    @JsonProperty("match_type")
    public CreateRecipientRuleRequestInputMatchType getMatchType() {
      return match_type;
    }

    public CreateRecipientRuleRequestInput withMatchType(
        CreateRecipientRuleRequestInputMatchType value) {
      this.match_type = value;
      return this;
    }

    /** Required for exact and prefix; empty or omitted for all. */
    @JsonProperty(value = "local_part", required = false)
    private String local_part;

    @JsonProperty("local_part")
    public String getLocalPart() {
      return local_part;
    }

    public CreateRecipientRuleRequestInput withLocalPart(String value) {
      this.local_part = value;
      return this;
    }

    /**
     * Notifications topic name, UUID or CRN. Requires notifications:Publish on the same-account
     * topic.
     */
    @JsonProperty(value = "topic", required = true)
    private String topic;

    @JsonProperty("topic")
    public String getTopic() {
      return topic;
    }

    public CreateRecipientRuleRequestInput withTopic(String value) {
      this.topic = value;
      return this;
    }

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public CreateRecipientRuleRequestInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }
  }

  public static final class CreateRecipientRuleRequestInputMatchType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateRecipientRuleRequestInputMatchType(String value) {
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
      return other instanceof CreateRecipientRuleRequestInputMatchType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateRecipientRuleRequestInputMatchType EXACT =
        new CreateRecipientRuleRequestInputMatchType("exact");
    public static final CreateRecipientRuleRequestInputMatchType PREFIX =
        new CreateRecipientRuleRequestInputMatchType("prefix");
    public static final CreateRecipientRuleRequestInputMatchType ALL =
        new CreateRecipientRuleRequestInputMatchType("all");
  }

  public static final class RecipientRuleResponse extends Model {
    public RecipientRuleResponse() {}

    @JsonProperty(value = "rule", required = true)
    private RecipientRule rule;

    @JsonProperty("rule")
    public RecipientRule getRule() {
      return rule;
    }
  }

  public static final class RecipientRule extends Model {
    public RecipientRule() {}

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

    @JsonProperty(value = "local_part", required = true)
    private String local_part;

    @JsonProperty("local_part")
    public String getLocalPart() {
      return local_part;
    }

    @JsonProperty(value = "topic", required = true)
    private ResourceRef topic;

    @JsonProperty("topic")
    public ResourceRef getTopic() {
      return topic;
    }

    @JsonProperty(value = "enabled", required = true)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    /**
     * Exact local part, local-part prefix, or catch-all for this identity. Exact matches take
     * precedence, then the longest prefix, then catch-all.
     */
    @JsonProperty(value = "match_type", required = true)
    private RecipientRuleMatchType match_type;

    @JsonProperty("match_type")
    public RecipientRuleMatchType getMatchType() {
      return match_type;
    }
  }

  public static final class RecipientRuleMatchType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RecipientRuleMatchType(String value) {
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
      return other instanceof RecipientRuleMatchType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RecipientRuleMatchType EXACT = new RecipientRuleMatchType("exact");
    public static final RecipientRuleMatchType PREFIX = new RecipientRuleMatchType("prefix");
    public static final RecipientRuleMatchType ALL = new RecipientRuleMatchType("all");
  }

  public static final class CreateSuppressionRequestInput extends Model {
    public CreateSuppressionRequestInput() {}

    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    public CreateSuppressionRequestInput withAddress(String value) {
      this.address = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public CreateSuppressionRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "expires_at", required = false)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    public CreateSuppressionRequestInput withExpiresAt(String value) {
      this.expires_at = value;
      return this;
    }
  }

  public static final class SuppressionResponse extends Model {
    public SuppressionResponse() {}

    @JsonProperty(value = "suppression", required = true)
    private Suppression suppression;

    @JsonProperty("suppression")
    public Suppression getSuppression() {
      return suppression;
    }
  }

  public static final class Suppression extends Model {
    public Suppression() {}

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

    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    @JsonProperty(value = "reason", required = true)
    private SuppressionReason reason;

    @JsonProperty("reason")
    public SuppressionReason getReason() {
      return reason;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "source_message", required = false)
    private ResourceRef source_message;

    @JsonProperty("source_message")
    public ResourceRef getSourceMessage() {
      return source_message;
    }

    @JsonProperty(value = "expires_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> expires_at = JsonField.missing();

    @JsonProperty("expires_at")
    public JsonField<String> getExpiresAt() {
      return expires_at;
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

  public static final class SuppressionReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SuppressionReason(String value) {
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
      return other instanceof SuppressionReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SuppressionReason AUTO_BOUNCE = new SuppressionReason("auto_bounce");
    public static final SuppressionReason AUTO_COMPLAINT = new SuppressionReason("auto_complaint");
    public static final SuppressionReason MANUAL = new SuppressionReason("manual");
  }

  public static final class CreateTemplateRequestInput extends Model {
    public CreateTemplateRequestInput() {}

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

    public CreateTemplateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "subject_template", required = false)
    private String subject_template;

    @JsonProperty("subject_template")
    public String getSubjectTemplate() {
      return subject_template;
    }

    public CreateTemplateRequestInput withSubjectTemplate(String value) {
      this.subject_template = value;
      return this;
    }

    @JsonProperty(value = "body_template", required = true)
    private String body_template;

    @JsonProperty("body_template")
    public String getBodyTemplate() {
      return body_template;
    }

    public CreateTemplateRequestInput withBodyTemplate(String value) {
      this.body_template = value;
      return this;
    }

    @JsonProperty(value = "body_type", required = false)
    private CreateTemplateRequestInputBodyType body_type;

    @JsonProperty("body_type")
    public CreateTemplateRequestInputBodyType getBodyType() {
      return body_type;
    }

    public CreateTemplateRequestInput withBodyType(CreateTemplateRequestInputBodyType value) {
      this.body_type = value;
      return this;
    }
  }

  public static final class CreateTemplateRequestInputBodyType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateTemplateRequestInputBodyType(String value) {
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
      return other instanceof CreateTemplateRequestInputBodyType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateTemplateRequestInputBodyType TEXT =
        new CreateTemplateRequestInputBodyType("text");
    public static final CreateTemplateRequestInputBodyType HTML =
        new CreateTemplateRequestInputBodyType("html");
  }

  public static final class TemplateResponse extends Model {
    public TemplateResponse() {}

    @JsonProperty(value = "template", required = true)
    private Template template;

    @JsonProperty("template")
    public Template getTemplate() {
      return template;
    }
  }

  public static final class Template extends Model {
    public Template() {}

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

    @JsonProperty(value = "subject_template", required = true)
    private String subject_template;

    @JsonProperty("subject_template")
    public String getSubjectTemplate() {
      return subject_template;
    }

    @JsonProperty(value = "body_template", required = true)
    private String body_template;

    @JsonProperty("body_template")
    public String getBodyTemplate() {
      return body_template;
    }

    @JsonProperty(value = "body_type", required = true)
    private TemplateBodyType body_type;

    @JsonProperty("body_type")
    public TemplateBodyType getBodyType() {
      return body_type;
    }

    @JsonProperty(value = "variables", required = true)
    private List<String> variables;

    @JsonProperty("variables")
    public List<String> getVariables() {
      return variables;
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

  public static final class TemplateBodyType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TemplateBodyType(String value) {
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
      return other instanceof TemplateBodyType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TemplateBodyType TEXT = new TemplateBodyType("text");
    public static final TemplateBodyType HTML = new TemplateBodyType("html");
  }

  public static final class DedicatedIPResponse extends Model {
    public DedicatedIPResponse() {}

    @JsonProperty(value = "dedicated_ip", required = true)
    private DedicatedIP dedicated_ip;

    @JsonProperty("dedicated_ip")
    public DedicatedIP getDedicatedIp() {
      return dedicated_ip;
    }
  }

  public static final class DedicatedIP extends Model {
    public DedicatedIP() {}

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

    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    @JsonProperty(value = "warmup_status", required = true)
    private DedicatedIPWarmupStatus warmup_status;

    @JsonProperty("warmup_status")
    public DedicatedIPWarmupStatus getWarmupStatus() {
      return warmup_status;
    }

    /** Progress computed by the warmup worker; cannot be edited. */
    @JsonProperty(value = "warmup_percentage", required = true)
    private Long warmup_percentage;

    @JsonProperty("warmup_percentage")
    public Long getWarmupPercentage() {
      return warmup_percentage;
    }

    @JsonProperty(value = "warmup_started_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> warmup_started_at = JsonField.missing();

    @JsonProperty("warmup_started_at")
    public JsonField<String> getWarmupStartedAt() {
      return warmup_started_at;
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

    @JsonProperty(value = "ip_pool", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<ResourceRef> ip_pool = JsonField.missing();

    @JsonProperty("ip_pool")
    public JsonField<ResourceRef> getIpPool() {
      return ip_pool;
    }
  }

  public static final class DedicatedIPWarmupStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DedicatedIPWarmupStatus(String value) {
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
      return other instanceof DedicatedIPWarmupStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final DedicatedIPWarmupStatus NEW = new DedicatedIPWarmupStatus("new");
    public static final DedicatedIPWarmupStatus WARMING = new DedicatedIPWarmupStatus("warming");
    public static final DedicatedIPWarmupStatus WARM = new DedicatedIPWarmupStatus("warm");
  }

  public static final class ReceivedMessageResponse extends Model {
    public ReceivedMessageResponse() {}

    @JsonProperty(value = "message", required = true)
    private ReceivedMessage message;

    @JsonProperty("message")
    public ReceivedMessage getMessage() {
      return message;
    }
  }

  public static final class ReceivedMessage extends Model {
    public ReceivedMessage() {}

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

    @JsonProperty(value = "recipient", required = true)
    private String recipient;

    @JsonProperty("recipient")
    public String getRecipient() {
      return recipient;
    }

    @JsonProperty(value = "from", required = true)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    @JsonProperty(value = "subject", required = true)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    @JsonProperty(value = "received_at", required = true)
    private String received_at;

    @JsonProperty("received_at")
    public String getReceivedAt() {
      return received_at;
    }

    @JsonProperty(value = "expires_at", required = true)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    @JsonProperty(value = "published_at", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> published_at = JsonField.missing();

    @JsonProperty("published_at")
    public JsonField<String> getPublishedAt() {
      return published_at;
    }

    @JsonProperty(value = "content_available", required = true)
    private Boolean content_available;

    @JsonProperty("content_available")
    public Boolean getContentAvailable() {
      return content_available;
    }

    @JsonProperty(value = "review_reason", required = true)
    private ReceivedMessageReviewReason review_reason;

    @JsonProperty("review_reason")
    public ReceivedMessageReviewReason getReviewReason() {
      return review_reason;
    }

    @JsonProperty(value = "authenticated", required = true)
    private Boolean authenticated;

    @JsonProperty("authenticated")
    public Boolean getAuthenticated() {
      return authenticated;
    }

    @JsonProperty(value = "attachments", required = true)
    private List<Attachment> attachments;

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
      return attachments;
    }

    /** Receiving identity; null only when the original identity no longer exists. */
    @JsonProperty(value = "identity", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<ResourceRef> identity = JsonField.missing();

    @JsonProperty("identity")
    public JsonField<ResourceRef> getIdentity() {
      return identity;
    }

    @JsonProperty(value = "notification_status", required = true)
    private ReceivedMessageNotificationStatus notification_status;

    @JsonProperty("notification_status")
    public ReceivedMessageNotificationStatus getNotificationStatus() {
      return notification_status;
    }

    /** Safe publication failure detail. Retried automatically while content is retained. */
    @JsonProperty(value = "notification_error", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> notification_error = JsonField.missing();

    @JsonProperty("notification_error")
    public JsonField<String> getNotificationError() {
      return notification_error;
    }

    /** RFC Message-ID header, distinct from the Email resource UUID. */
    @JsonProperty(value = "rfc_message_id", required = false)
    private String rfc_message_id;

    @JsonProperty("rfc_message_id")
    public String getRfcMessageId() {
      return rfc_message_id;
    }
  }

  public static final class ReceivedMessageReviewReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ReceivedMessageReviewReason(String value) {
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
      return other instanceof ReceivedMessageReviewReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ReceivedMessageReviewReason VALUE = new ReceivedMessageReviewReason("");
    public static final ReceivedMessageReviewReason SPAM = new ReceivedMessageReviewReason("spam");
    public static final ReceivedMessageReviewReason SENDER_UNVERIFIED =
        new ReceivedMessageReviewReason("sender_unverified");
    public static final ReceivedMessageReviewReason MALWARE =
        new ReceivedMessageReviewReason("malware");
  }

  public static final class Attachment extends Model {
    public Attachment() {}

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "content_type", required = true)
    private String content_type;

    @JsonProperty("content_type")
    public String getContentType() {
      return content_type;
    }

    @JsonProperty(value = "size", required = true)
    private Long size;

    @JsonProperty("size")
    public Long getSize() {
      return size;
    }

    @JsonProperty(value = "bucket", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<ResourceRef> bucket = JsonField.missing();

    @JsonProperty("bucket")
    public JsonField<ResourceRef> getBucket() {
      return bucket;
    }

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    /** Opaque Storage object version token, when versioning is enabled. */
    @JsonProperty(value = "version_id", required = false)
    private String version_id;

    @JsonProperty("version_id")
    public String getVersionId() {
      return version_id;
    }

    /** SHA-256 of the decoded attachment bytes. */
    @JsonProperty(value = "sha256", required = true)
    private String sha256;

    @JsonProperty("sha256")
    public String getSha256() {
      return sha256;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }
  }

  public static final class ReceivedMessageNotificationStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ReceivedMessageNotificationStatus(String value) {
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
      return other instanceof ReceivedMessageNotificationStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ReceivedMessageNotificationStatus PENDING =
        new ReceivedMessageNotificationStatus("pending");
    public static final ReceivedMessageNotificationStatus RETRYING =
        new ReceivedMessageNotificationStatus("retrying");
    public static final ReceivedMessageNotificationStatus PUBLISHED =
        new ReceivedMessageNotificationStatus("published");
  }

  public static final class MessageResponse extends Model {
    public MessageResponse() {}

    @JsonProperty(value = "message", required = true)
    private Message message;

    @JsonProperty("message")
    public Message getMessage() {
      return message;
    }
  }

  public static final class Message extends Model {
    public Message() {}

    /** Message content expires 30 days after acceptance. */
    @JsonProperty(value = "expires_at", required = true)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    @JsonProperty(value = "attachments", required = true)
    private List<Attachment> attachments;

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
      return attachments;
    }

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

    @JsonProperty(value = "identity", required = true)
    private ResourceRef identity;

    @JsonProperty("identity")
    public ResourceRef getIdentity() {
      return identity;
    }

    @JsonProperty(value = "from", required = true)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    @JsonProperty(value = "to", required = true)
    private List<String> to;

    @JsonProperty("to")
    public List<String> getTo() {
      return to;
    }

    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    @JsonProperty(value = "status", required = true)
    private MessageStatus status;

    @JsonProperty("status")
    public MessageStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "smtp_response", required = false)
    private String smtp_response;

    @JsonProperty("smtp_response")
    public String getSmtpResponse() {
      return smtp_response;
    }

    @JsonProperty(value = "error_message", required = false)
    private String error_message;

    @JsonProperty("error_message")
    public String getErrorMessage() {
      return error_message;
    }

    @JsonProperty(value = "outbound_ip", required = false)
    private String outbound_ip;

    @JsonProperty("outbound_ip")
    public String getOutboundIp() {
      return outbound_ip;
    }

    @JsonProperty(value = "queued_at", required = true)
    private String queued_at;

    @JsonProperty("queued_at")
    public String getQueuedAt() {
      return queued_at;
    }

    @JsonProperty(value = "sent_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> sent_at = JsonField.missing();

    @JsonProperty("sent_at")
    public JsonField<String> getSentAt() {
      return sent_at;
    }

    @JsonProperty(value = "failed_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> failed_at = JsonField.missing();

    @JsonProperty("failed_at")
    public JsonField<String> getFailedAt() {
      return failed_at;
    }
  }

  public static final class MessageStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public MessageStatus(String value) {
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
      return other instanceof MessageStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final MessageStatus QUEUED = new MessageStatus("queued");
    public static final MessageStatus SENDING = new MessageStatus("sending");
    public static final MessageStatus SENT = new MessageStatus("sent");
    public static final MessageStatus FAILED = new MessageStatus("failed");
    public static final MessageStatus BOUNCED = new MessageStatus("bounced");
    public static final MessageStatus COMPLAINED = new MessageStatus("complained");
  }

  public static final class MessageContentResponse extends Model {
    public MessageContentResponse() {}

    @JsonProperty(value = "content", required = true)
    private MessageContent content;

    @JsonProperty("content")
    public MessageContent getContent() {
      return content;
    }
  }

  public static final class MessageContent extends Model {
    public MessageContent() {}

    @JsonProperty(value = "from", required = true)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    @JsonProperty(value = "to", required = true)
    private List<String> to;

    @JsonProperty("to")
    public List<String> getTo() {
      return to;
    }

    @JsonProperty(value = "subject", required = true)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    /** Full decoded plain-text body. */
    @JsonProperty(value = "text", required = true)
    private String text;

    @JsonProperty("text")
    public String getText() {
      return text;
    }

    /**
     * Full decoded HTML. Untrusted content: sanitize before rendering; do not load remote resources
     * automatically.
     */
    @JsonProperty(value = "html", required = true)
    private String html;

    @JsonProperty("html")
    public String getHtml() {
      return html;
    }

    /** RFC Message-ID header, distinct from the Email resource UUID. */
    @JsonProperty(value = "rfc_message_id", required = false)
    private String rfc_message_id;

    @JsonProperty("rfc_message_id")
    public String getRfcMessageId() {
      return rfc_message_id;
    }

    @JsonProperty(value = "attachments", required = true)
    private List<Attachment> attachments;

    @JsonProperty("attachments")
    public List<Attachment> getAttachments() {
      return attachments;
    }
  }

  public static final class ReceivingConfigurationResponse extends Model {
    public ReceivingConfigurationResponse() {}

    @JsonProperty(value = "receiving", required = true)
    private ReceivingConfiguration receiving;

    @JsonProperty("receiving")
    public ReceivingConfiguration getReceiving() {
      return receiving;
    }
  }

  public static final class ReceivingConfiguration extends Model {
    public ReceivingConfiguration() {}

    @JsonProperty(value = "enabled", required = true)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    @JsonProperty(value = "attachments_bucket", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<ResourceRef> attachments_bucket = JsonField.missing();

    @JsonProperty("attachments_bucket")
    public JsonField<ResourceRef> getAttachmentsBucket() {
      return attachments_bucket;
    }
  }

  public static final class MessageEngagementResponse extends Model {
    public MessageEngagementResponse() {}

    @JsonProperty(value = "engagement", required = true)
    private MessageEngagement engagement;

    @JsonProperty("engagement")
    public MessageEngagement getEngagement() {
      return engagement;
    }
  }

  public static final class MessageEngagement extends Model {
    public MessageEngagement() {}

    @JsonProperty(value = "generated_at", required = true)
    private String generated_at;

    @JsonProperty("generated_at")
    public String getGeneratedAt() {
      return generated_at;
    }

    @JsonProperty(value = "open_count", required = true)
    private Long open_count;

    @JsonProperty("open_count")
    public Long getOpenCount() {
      return open_count;
    }

    @JsonProperty(value = "unique_opens", required = true)
    private Long unique_opens;

    @JsonProperty("unique_opens")
    public Long getUniqueOpens() {
      return unique_opens;
    }

    @JsonProperty(value = "click_count", required = true)
    private Long click_count;

    @JsonProperty("click_count")
    public Long getClickCount() {
      return click_count;
    }

    @JsonProperty(value = "unique_clicks", required = true)
    private Long unique_clicks;

    @JsonProperty("unique_clicks")
    public Long getUniqueClicks() {
      return unique_clicks;
    }

    @JsonProperty(value = "first_open_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> first_open_at = JsonField.missing();

    @JsonProperty("first_open_at")
    public JsonField<String> getFirstOpenAt() {
      return first_open_at;
    }

    @JsonProperty(value = "last_open_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_open_at = JsonField.missing();

    @JsonProperty("last_open_at")
    public JsonField<String> getLastOpenAt() {
      return last_open_at;
    }

    @JsonProperty(value = "first_click_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> first_click_at = JsonField.missing();

    @JsonProperty("first_click_at")
    public JsonField<String> getFirstClickAt() {
      return first_click_at;
    }

    @JsonProperty(value = "last_click_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_click_at = JsonField.missing();

    @JsonProperty("last_click_at")
    public JsonField<String> getLastClickAt() {
      return last_click_at;
    }
  }

  public static final class ListConfigurationSetsQuery extends Model {
    public ListConfigurationSetsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListConfigurationSetsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListConfigurationSetsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListConfigurationSetsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListConfigurationSetsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ConfigurationSetListResponse extends Model {
    public ConfigurationSetListResponse() {}

    @JsonProperty(value = "configuration_sets", required = true)
    private List<ConfigurationSet> configuration_sets;

    @JsonProperty("configuration_sets")
    public List<ConfigurationSet> getConfigurationSets() {
      return configuration_sets;
    }

    @JsonProperty(value = "meta", required = true)
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

  public static final class ListDMARCReportsQuery extends Model {
    public ListDMARCReportsQuery() {}

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListDMARCReportsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListDMARCReportsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "from", required = false)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    public ListDMARCReportsQuery withFrom(String value) {
      this.from = value;
      return this;
    }

    @JsonProperty(value = "to", required = false)
    private String to;

    @JsonProperty("to")
    public String getTo() {
      return to;
    }

    public ListDMARCReportsQuery withTo(String value) {
      this.to = value;
      return this;
    }
  }

  public static final class DMARCReportListResponse extends Model {
    public DMARCReportListResponse() {}

    @JsonProperty(value = "records", required = true)
    private List<DMARCReportRecord> records;

    @JsonProperty("records")
    public List<DMARCReportRecord> getRecords() {
      return records;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class DMARCReportRecord extends Model {
    public DMARCReportRecord() {}

    @JsonProperty(value = "reporter", required = true)
    private String reporter;

    @JsonProperty("reporter")
    public String getReporter() {
      return reporter;
    }

    @JsonProperty(value = "report_id", required = true)
    private String report_id;

    @JsonProperty("report_id")
    public String getReportId() {
      return report_id;
    }

    @JsonProperty(value = "period_start", required = true)
    private String period_start;

    @JsonProperty("period_start")
    public String getPeriodStart() {
      return period_start;
    }

    @JsonProperty(value = "period_end", required = true)
    private String period_end;

    @JsonProperty("period_end")
    public String getPeriodEnd() {
      return period_end;
    }

    @JsonProperty(value = "received_at", required = true)
    private String received_at;

    @JsonProperty("received_at")
    public String getReceivedAt() {
      return received_at;
    }

    @JsonProperty(value = "source_ip", required = true)
    private String source_ip;

    @JsonProperty("source_ip")
    public String getSourceIp() {
      return source_ip;
    }

    @JsonProperty(value = "message_count", required = true)
    private Long message_count;

    @JsonProperty("message_count")
    public Long getMessageCount() {
      return message_count;
    }

    @JsonProperty(value = "disposition", required = true)
    private String disposition;

    @JsonProperty("disposition")
    public String getDisposition() {
      return disposition;
    }

    @JsonProperty(value = "dkim_aligned", required = true)
    private Boolean dkim_aligned;

    @JsonProperty("dkim_aligned")
    public Boolean getDkimAligned() {
      return dkim_aligned;
    }

    @JsonProperty(value = "spf_aligned", required = true)
    private Boolean spf_aligned;

    @JsonProperty("spf_aligned")
    public Boolean getSpfAligned() {
      return spf_aligned;
    }

    @JsonProperty(value = "dkim_domain", required = true)
    private String dkim_domain;

    @JsonProperty("dkim_domain")
    public String getDkimDomain() {
      return dkim_domain;
    }

    @JsonProperty(value = "dkim_result", required = true)
    private String dkim_result;

    @JsonProperty("dkim_result")
    public String getDkimResult() {
      return dkim_result;
    }

    @JsonProperty(value = "spf_domain", required = true)
    private String spf_domain;

    @JsonProperty("spf_domain")
    public String getSpfDomain() {
      return spf_domain;
    }

    @JsonProperty(value = "spf_result", required = true)
    private String spf_result;

    @JsonProperty("spf_result")
    public String getSpfResult() {
      return spf_result;
    }

    @JsonProperty(value = "header_from", required = true)
    private String header_from;

    @JsonProperty("header_from")
    public String getHeaderFrom() {
      return header_from;
    }
  }

  public static final class ListDedicatedIPsQuery extends Model {
    public ListDedicatedIPsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListDedicatedIPsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListDedicatedIPsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListDedicatedIPsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "ip_pool", required = false)
    private String ip_pool;

    @JsonProperty("ip_pool")
    public String getIpPool() {
      return ip_pool;
    }

    public ListDedicatedIPsQuery withIpPool(String value) {
      this.ip_pool = value;
      return this;
    }
  }

  public static final class DedicatedIPListResponse extends Model {
    public DedicatedIPListResponse() {}

    @JsonProperty(value = "dedicated_ips", required = true)
    private List<DedicatedIP> dedicated_ips;

    @JsonProperty("dedicated_ips")
    public List<DedicatedIP> getDedicatedIps() {
      return dedicated_ips;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListIPPoolsQuery extends Model {
    public ListIPPoolsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListIPPoolsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListIPPoolsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListIPPoolsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListIPPoolsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class IPPoolListResponse extends Model {
    public IPPoolListResponse() {}

    @JsonProperty(value = "ip_pools", required = true)
    private List<IPPool> ip_pools;

    @JsonProperty("ip_pools")
    public List<IPPool> getIpPools() {
      return ip_pools;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListIdentitiesQuery extends Model {
    public ListIdentitiesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListIdentitiesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListIdentitiesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListIdentitiesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListIdentitiesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class IdentityListResponse extends Model {
    public IdentityListResponse() {}

    @JsonProperty(value = "identities", required = true)
    private List<Identity> identities;

    @JsonProperty("identities")
    public List<Identity> getIdentities() {
      return identities;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListReceivedMessagesQuery extends Model {
    public ListReceivedMessagesQuery() {}

    @JsonProperty(value = "identity", required = false)
    private String identity;

    @JsonProperty("identity")
    public String getIdentity() {
      return identity;
    }

    public ListReceivedMessagesQuery withIdentity(String value) {
      this.identity = value;
      return this;
    }

    @JsonProperty(value = "recipient", required = false)
    private String recipient;

    @JsonProperty("recipient")
    public String getRecipient() {
      return recipient;
    }

    public ListReceivedMessagesQuery withRecipient(String value) {
      this.recipient = value;
      return this;
    }

    @JsonProperty(value = "review_reason", required = false)
    private ListReceivedMessagesQueryReviewReason review_reason;

    @JsonProperty("review_reason")
    public ListReceivedMessagesQueryReviewReason getReviewReason() {
      return review_reason;
    }

    public ListReceivedMessagesQuery withReviewReason(ListReceivedMessagesQueryReviewReason value) {
      this.review_reason = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListReceivedMessagesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListReceivedMessagesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListReceivedMessagesQueryReviewReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListReceivedMessagesQueryReviewReason(String value) {
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
      return other instanceof ListReceivedMessagesQueryReviewReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListReceivedMessagesQueryReviewReason CLEAR =
        new ListReceivedMessagesQueryReviewReason("clear");
    public static final ListReceivedMessagesQueryReviewReason SPAM =
        new ListReceivedMessagesQueryReviewReason("spam");
    public static final ListReceivedMessagesQueryReviewReason SENDER_UNVERIFIED =
        new ListReceivedMessagesQueryReviewReason("sender_unverified");
    public static final ListReceivedMessagesQueryReviewReason MALWARE =
        new ListReceivedMessagesQueryReviewReason("malware");
  }

  public static final class ReceivedMessageListResponse extends Model {
    public ReceivedMessageListResponse() {}

    @JsonProperty(value = "messages", required = true)
    private List<ReceivedMessage> messages;

    @JsonProperty("messages")
    public List<ReceivedMessage> getMessages() {
      return messages;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListRecipientRulesQuery extends Model {
    public ListRecipientRulesQuery() {}

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListRecipientRulesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListRecipientRulesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class RecipientRuleListResponse extends Model {
    public RecipientRuleListResponse() {}

    @JsonProperty(value = "rules", required = true)
    private List<RecipientRule> rules;

    @JsonProperty("rules")
    public List<RecipientRule> getRules() {
      return rules;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListRejectionsQuery extends Model {
    public ListRejectionsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRejectionsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "before", required = false)
    private String before;

    @JsonProperty("before")
    public String getBefore() {
      return before;
    }

    public ListRejectionsQuery withBefore(String value) {
      this.before = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListRejectionsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "identity", required = false)
    private String identity;

    @JsonProperty("identity")
    public String getIdentity() {
      return identity;
    }

    public ListRejectionsQuery withIdentity(String value) {
      this.identity = value;
      return this;
    }

    @JsonProperty(value = "reason", required = false)
    private ListRejectionsQueryReason reason;

    @JsonProperty("reason")
    public ListRejectionsQueryReason getReason() {
      return reason;
    }

    public ListRejectionsQuery withReason(ListRejectionsQueryReason value) {
      this.reason = value;
      return this;
    }
  }

  public static final class ListRejectionsQueryReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListRejectionsQueryReason(String value) {
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
      return other instanceof ListRejectionsQueryReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListRejectionsQueryReason ALLRECIPIENTSSUPPRESSED =
        new ListRejectionsQueryReason("ALL_RECIPIENTS_SUPPRESSED");
    public static final ListRejectionsQueryReason IDENTITYSUSPENDED =
        new ListRejectionsQueryReason("IDENTITY_SUSPENDED");
    public static final ListRejectionsQueryReason IDENTITYNOTVERIFIED =
        new ListRejectionsQueryReason("IDENTITY_NOT_VERIFIED");
    public static final ListRejectionsQueryReason FROMDOMAINMISMATCH =
        new ListRejectionsQueryReason("FROM_DOMAIN_MISMATCH");
    public static final ListRejectionsQueryReason RATELIMIT =
        new ListRejectionsQueryReason("RATE_LIMIT");
  }

  public static final class RejectionListResponse extends Model {
    public RejectionListResponse() {}

    @JsonProperty(value = "rejections", required = true)
    private List<Rejection> rejections;

    @JsonProperty("rejections")
    public List<Rejection> getRejections() {
      return rejections;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Rejection extends Model {
    public Rejection() {}

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

    @JsonProperty(value = "identity", required = false)
    private ResourceRef identity;

    @JsonProperty("identity")
    public ResourceRef getIdentity() {
      return identity;
    }

    @JsonProperty(value = "from", required = false)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    @JsonProperty(value = "to", required = true)
    private List<String> to;

    @JsonProperty("to")
    public List<String> getTo() {
      return to;
    }

    @JsonProperty(value = "reason", required = true)
    private RejectionReason reason;

    @JsonProperty("reason")
    public RejectionReason getReason() {
      return reason;
    }

    @JsonProperty(value = "detail", required = false)
    private String detail;

    @JsonProperty("detail")
    public String getDetail() {
      return detail;
    }

    @JsonProperty(value = "rejected_at", required = true)
    private String rejected_at;

    @JsonProperty("rejected_at")
    public String getRejectedAt() {
      return rejected_at;
    }
  }

  public static final class RejectionReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RejectionReason(String value) {
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
      return other instanceof RejectionReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RejectionReason ALLRECIPIENTSSUPPRESSED =
        new RejectionReason("ALL_RECIPIENTS_SUPPRESSED");
    public static final RejectionReason IDENTITYSUSPENDED =
        new RejectionReason("IDENTITY_SUSPENDED");
    public static final RejectionReason IDENTITYNOTVERIFIED =
        new RejectionReason("IDENTITY_NOT_VERIFIED");
    public static final RejectionReason FROMDOMAINMISMATCH =
        new RejectionReason("FROM_DOMAIN_MISMATCH");
    public static final RejectionReason RATELIMIT = new RejectionReason("RATE_LIMIT");
  }

  public static final class ListSentMessagesQuery extends Model {
    public ListSentMessagesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSentMessagesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSentMessagesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSentMessagesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "identity", required = false)
    private String identity;

    @JsonProperty("identity")
    public String getIdentity() {
      return identity;
    }

    public ListSentMessagesQuery withIdentity(String value) {
      this.identity = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private String status;

    @JsonProperty("status")
    public String getStatus() {
      return status;
    }

    public ListSentMessagesQuery withStatus(String value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "recipient", required = false)
    private String recipient;

    @JsonProperty("recipient")
    public String getRecipient() {
      return recipient;
    }

    public ListSentMessagesQuery withRecipient(String value) {
      this.recipient = value;
      return this;
    }
  }

  public static final class MessageListResponse extends Model {
    public MessageListResponse() {}

    @JsonProperty(value = "messages", required = true)
    private List<Message> messages;

    @JsonProperty("messages")
    public List<Message> getMessages() {
      return messages;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListSuppressionsQuery extends Model {
    public ListSuppressionsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSuppressionsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "reason", required = false)
    private ListSuppressionsQueryReason reason;

    @JsonProperty("reason")
    public ListSuppressionsQueryReason getReason() {
      return reason;
    }

    public ListSuppressionsQuery withReason(ListSuppressionsQueryReason value) {
      this.reason = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSuppressionsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSuppressionsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListSuppressionsQueryReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListSuppressionsQueryReason(String value) {
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
      return other instanceof ListSuppressionsQueryReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListSuppressionsQueryReason AUTO_BOUNCE =
        new ListSuppressionsQueryReason("auto_bounce");
    public static final ListSuppressionsQueryReason AUTO_COMPLAINT =
        new ListSuppressionsQueryReason("auto_complaint");
    public static final ListSuppressionsQueryReason MANUAL =
        new ListSuppressionsQueryReason("manual");
  }

  public static final class SuppressionListResponse extends Model {
    public SuppressionListResponse() {}

    @JsonProperty(value = "suppressions", required = true)
    private List<Suppression> suppressions;

    @JsonProperty("suppressions")
    public List<Suppression> getSuppressions() {
      return suppressions;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListTemplatesQuery extends Model {
    public ListTemplatesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListTemplatesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListTemplatesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListTemplatesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListTemplatesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class TemplateListResponse extends Model {
    public TemplateListResponse() {}

    @JsonProperty(value = "templates", required = true)
    private List<Template> templates;

    @JsonProperty("templates")
    public List<Template> getTemplates() {
      return templates;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class RequestDedicatedIPRequestInput extends Model {
    public RequestDedicatedIPRequestInput() {}

    /** UUID, CRN or account-unique pool name; empty leaves unassigned. */
    @JsonProperty(value = "ip_pool", required = false)
    private String ip_pool;

    @JsonProperty("ip_pool")
    public String getIpPool() {
      return ip_pool;
    }

    public RequestDedicatedIPRequestInput withIpPool(String value) {
      this.ip_pool = value;
      return this;
    }
  }

  public static final class SendMessageRequestInput extends Model {
    public SendMessageRequestInput() {}

    /**
     * Bucket UUID, CRN or name for attachments embedded in raw MIME. Objects are written under
     * email/{identity_id}/sent/{message_id}/. Separate attachments entries reference existing
     * bucket objects.
     */
    @JsonProperty(value = "attachments_bucket", required = false)
    private String attachments_bucket;

    @JsonProperty("attachments_bucket")
    public String getAttachmentsBucket() {
      return attachments_bucket;
    }

    public SendMessageRequestInput withAttachmentsBucket(String value) {
      this.attachments_bucket = value;
      return this;
    }

    /**
     * Bucket objects to attach. GetObject permission is required; version and checksum are pinned
     * at acceptance.
     */
    @JsonProperty(value = "attachments", required = false)
    private List<AttachmentInputInput> attachments;

    @JsonProperty("attachments")
    public List<AttachmentInputInput> getAttachments() {
      return attachments;
    }

    public SendMessageRequestInput withAttachments(List<AttachmentInputInput> value) {
      this.attachments = value;
      return this;
    }

    /** UUID, CRN or account-unique name. */
    @JsonProperty(value = "identity", required = true)
    private String identity;

    @JsonProperty("identity")
    public String getIdentity() {
      return identity;
    }

    public SendMessageRequestInput withIdentity(String value) {
      this.identity = value;
      return this;
    }

    @JsonProperty(value = "from", required = true)
    private String from;

    @JsonProperty("from")
    public String getFrom() {
      return from;
    }

    public SendMessageRequestInput withFrom(String value) {
      this.from = value;
      return this;
    }

    @JsonProperty(value = "to", required = true)
    private List<String> to;

    @JsonProperty("to")
    public List<String> getTo() {
      return to;
    }

    public SendMessageRequestInput withTo(List<String> value) {
      this.to = value;
      return this;
    }

    /**
     * Subject for text/HTML content. For raw or template content, the subject is supplied by that
     * content.
     */
    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    public SendMessageRequestInput withSubject(String value) {
      this.subject = value;
      return this;
    }

    /** UUID, CRN or account-unique name. */
    @JsonProperty(value = "configuration_set", required = false)
    private String configuration_set;

    @JsonProperty("configuration_set")
    public String getConfigurationSet() {
      return configuration_set;
    }

    public SendMessageRequestInput withConfigurationSet(String value) {
      this.configuration_set = value;
      return this;
    }

    @JsonProperty(value = "content", required = true)
    private SendContentInput content;

    @JsonProperty("content")
    public SendContentInput getContent() {
      return content;
    }

    public SendMessageRequestInput withContent(SendContentInput value) {
      this.content = value;
      return this;
    }
  }

  public static final class AttachmentInputInput extends Model {
    public AttachmentInputInput() {}

    /** Same-account, same-region bucket name, UUID or CRN. */
    @JsonProperty(value = "bucket", required = true)
    private String bucket;

    @JsonProperty("bucket")
    public String getBucket() {
      return bucket;
    }

    public AttachmentInputInput withBucket(String value) {
      this.bucket = value;
      return this;
    }

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    public AttachmentInputInput withKey(String value) {
      this.key = value;
      return this;
    }

    /** Optional opaque Storage object version token. */
    @JsonProperty(value = "version_id", required = false)
    private String version_id;

    @JsonProperty("version_id")
    public String getVersionId() {
      return version_id;
    }

    public AttachmentInputInput withVersionId(String value) {
      this.version_id = value;
      return this;
    }

    /** Attachment filename. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public AttachmentInputInput withName(String value) {
      this.name = value;
      return this;
    }

    /** MIME type; defaults to the object content type. */
    @JsonProperty(value = "content_type", required = false)
    private String content_type;

    @JsonProperty("content_type")
    public String getContentType() {
      return content_type;
    }

    public AttachmentInputInput withContentType(String value) {
      this.content_type = value;
      return this;
    }
  }

  public static final class SendContentInput {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SendContentInput(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "SendContentInput{[REDACTED]}";
    }

    public static SendContentInput ofVariant1(SendContentInputVariant1 value) {
      Model.validate(value);
      return new SendContentInput(Json.tree(value));
    }

    public Optional<SendContentInputVariant1> asVariant1() {
      try {
        SendContentInputVariant1 result =
            Json.convert(value, new TypeReference<SendContentInputVariant1>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static SendContentInput ofVariant2(SendContentInputVariant2 value) {
      Model.validate(value);
      return new SendContentInput(Json.tree(value));
    }

    public Optional<SendContentInputVariant2> asVariant2() {
      try {
        SendContentInputVariant2 result =
            Json.convert(value, new TypeReference<SendContentInputVariant2>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static SendContentInput ofVariant3(SendContentInputVariant3 value) {
      Model.validate(value);
      return new SendContentInput(Json.tree(value));
    }

    public Optional<SendContentInputVariant3> asVariant3() {
      try {
        SendContentInputVariant3 result =
            Json.convert(value, new TypeReference<SendContentInputVariant3>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }
  }

  public static final class SendContentInputVariant1 extends Model {
    public SendContentInputVariant1() {}

    @JsonProperty(value = "text", required = false)
    private String text;

    @JsonProperty("text")
    public String getText() {
      return text;
    }

    public SendContentInputVariant1 withText(String value) {
      this.text = value;
      return this;
    }

    @JsonProperty(value = "html", required = false)
    private String html;

    @JsonProperty("html")
    public String getHtml() {
      return html;
    }

    public SendContentInputVariant1 withHtml(String value) {
      this.html = value;
      return this;
    }

    /** Complete RFC 5322 message. Its From header must belong to the authorized identity domain. */
    @JsonProperty(value = "raw", required = false)
    private String raw;

    @JsonProperty("raw")
    public String getRaw() {
      return raw;
    }

    public SendContentInputVariant1 withRaw(String value) {
      this.raw = value;
      return this;
    }

    /** Template UUID, CRN or name; requires email:SendTemplatedMessage on that template. */
    @JsonProperty(value = "template", required = false)
    private String template;

    @JsonProperty("template")
    public String getTemplate() {
      return template;
    }

    public SendContentInputVariant1 withTemplate(String value) {
      this.template = value;
      return this;
    }

    @JsonProperty(value = "template_data", required = false)
    private Map<String, String> template_data;

    @JsonProperty("template_data")
    public Map<String, String> getTemplateData() {
      return template_data;
    }

    public SendContentInputVariant1 withTemplateData(Map<String, String> value) {
      this.template_data = value;
      return this;
    }
  }

  public static final class SendContentInputVariant2 extends Model {
    public SendContentInputVariant2() {}

    @JsonProperty(value = "text", required = false)
    private String text;

    @JsonProperty("text")
    public String getText() {
      return text;
    }

    public SendContentInputVariant2 withText(String value) {
      this.text = value;
      return this;
    }

    @JsonProperty(value = "html", required = false)
    private String html;

    @JsonProperty("html")
    public String getHtml() {
      return html;
    }

    public SendContentInputVariant2 withHtml(String value) {
      this.html = value;
      return this;
    }

    /** Complete RFC 5322 message. Its From header must belong to the authorized identity domain. */
    @JsonProperty(value = "raw", required = true)
    private String raw;

    @JsonProperty("raw")
    public String getRaw() {
      return raw;
    }

    public SendContentInputVariant2 withRaw(String value) {
      this.raw = value;
      return this;
    }

    /** Template UUID, CRN or name; requires email:SendTemplatedMessage on that template. */
    @JsonProperty(value = "template", required = false)
    private String template;

    @JsonProperty("template")
    public String getTemplate() {
      return template;
    }

    public SendContentInputVariant2 withTemplate(String value) {
      this.template = value;
      return this;
    }

    @JsonProperty(value = "template_data", required = false)
    private Map<String, String> template_data;

    @JsonProperty("template_data")
    public Map<String, String> getTemplateData() {
      return template_data;
    }

    public SendContentInputVariant2 withTemplateData(Map<String, String> value) {
      this.template_data = value;
      return this;
    }
  }

  public static final class SendContentInputVariant3 extends Model {
    public SendContentInputVariant3() {}

    @JsonProperty(value = "text", required = false)
    private String text;

    @JsonProperty("text")
    public String getText() {
      return text;
    }

    public SendContentInputVariant3 withText(String value) {
      this.text = value;
      return this;
    }

    @JsonProperty(value = "html", required = false)
    private String html;

    @JsonProperty("html")
    public String getHtml() {
      return html;
    }

    public SendContentInputVariant3 withHtml(String value) {
      this.html = value;
      return this;
    }

    /** Complete RFC 5322 message. Its From header must belong to the authorized identity domain. */
    @JsonProperty(value = "raw", required = false)
    private String raw;

    @JsonProperty("raw")
    public String getRaw() {
      return raw;
    }

    public SendContentInputVariant3 withRaw(String value) {
      this.raw = value;
      return this;
    }

    /** Template UUID, CRN or name; requires email:SendTemplatedMessage on that template. */
    @JsonProperty(value = "template", required = true)
    private String template;

    @JsonProperty("template")
    public String getTemplate() {
      return template;
    }

    public SendContentInputVariant3 withTemplate(String value) {
      this.template = value;
      return this;
    }

    @JsonProperty(value = "template_data", required = false)
    private Map<String, String> template_data;

    @JsonProperty("template_data")
    public Map<String, String> getTemplateData() {
      return template_data;
    }

    public SendContentInputVariant3 withTemplateData(Map<String, String> value) {
      this.template_data = value;
      return this;
    }
  }

  public static final class BatchSendRequestInput extends Model {
    public BatchSendRequestInput() {}

    @JsonProperty(value = "messages", required = true)
    private List<SendMessageRequestInput> messages;

    @JsonProperty("messages")
    public List<SendMessageRequestInput> getMessages() {
      return messages;
    }

    public BatchSendRequestInput withMessages(List<SendMessageRequestInput> value) {
      this.messages = value;
      return this;
    }
  }

  public static final class BatchSendResponse extends Model {
    public BatchSendResponse() {}

    @JsonProperty(value = "results", required = true)
    private List<BatchSendResult> results;

    @JsonProperty("results")
    public List<BatchSendResult> getResults() {
      return results;
    }
  }

  public static final class BatchSendResult extends Model {
    public BatchSendResult() {}

    @JsonProperty(value = "index", required = true)
    private Long index;

    @JsonProperty("index")
    public Long getIndex() {
      return index;
    }

    @JsonProperty(value = "status", required = true)
    private BatchSendResultStatus status;

    @JsonProperty("status")
    public BatchSendResultStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "message", required = false)
    private ResourceRef message;

    @JsonProperty("message")
    public ResourceRef getMessage() {
      return message;
    }

    @JsonProperty(value = "error", required = false)
    private Error error;

    @JsonProperty("error")
    public Error getError() {
      return error;
    }
  }

  public static final class BatchSendResultStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public BatchSendResultStatus(String value) {
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
      return other instanceof BatchSendResultStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final BatchSendResultStatus QUEUED = new BatchSendResultStatus("queued");
    public static final BatchSendResultStatus REJECTED = new BatchSendResultStatus("rejected");
  }

  public static final class Error extends Model {
    public Error() {}

    /** Error code identifying the type of error */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    /** Human-readable error message */
    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    /**
     * Optional non-sensitive values for interpolation of localized errors, keyed by error code.
     * Never present for server errors.
     */
    @JsonProperty(value = "params", required = false)
    private Map<String, JsonNode> params;

    @JsonProperty("params")
    public Map<String, JsonNode> getParams() {
      return params;
    }

    /** Request ID for debugging */
    @JsonProperty(value = "request_id", required = true)
    private String request_id;

    @JsonProperty("request_id")
    public String getRequestId() {
      return request_id;
    }
  }

  public static final class SetBIMIRequestInput extends Model {
    public SetBIMIRequestInput() {}

    /** HTTPS SVG Tiny PS URL; null clears BIMI. */
    @JsonProperty(value = "logo_url", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> logo_url = JsonField.missing();

    @JsonProperty("logo_url")
    public JsonField<String> getLogoUrl() {
      return logo_url;
    }

    public SetBIMIRequestInput withLogoUrl(JsonField<String> value) {
      this.logo_url = value;
      return this;
    }

    /** Optional HTTPS VMC URL; omission preserves it and null removes the certificate. */
    @JsonProperty(value = "vmc_url", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> vmc_url = JsonField.missing();

    @JsonProperty("vmc_url")
    public JsonField<String> getVmcUrl() {
      return vmc_url;
    }

    public SetBIMIRequestInput withVmcUrl(JsonField<String> value) {
      this.vmc_url = value;
      return this;
    }
  }

  public static final class SetMailFromDomainRequestInput extends Model {
    public SetMailFromDomainRequestInput() {}

    /** Mail-from domain; null clears the binding. */
    @JsonProperty(value = "domain", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> domain = JsonField.missing();

    @JsonProperty("domain")
    public JsonField<String> getDomain() {
      return domain;
    }

    public SetMailFromDomainRequestInput withDomain(JsonField<String> value) {
      this.domain = value;
      return this;
    }
  }

  public static final class UpdateConfigurationSetRequestInput extends Model {
    public UpdateConfigurationSetRequestInput() {}

    @JsonProperty(value = "sending_enabled", required = false)
    private Boolean sending_enabled;

    @JsonProperty("sending_enabled")
    public Boolean getSendingEnabled() {
      return sending_enabled;
    }

    public UpdateConfigurationSetRequestInput withSendingEnabled(Boolean value) {
      this.sending_enabled = value;
      return this;
    }

    @JsonProperty(value = "suppression_overrides", required = false)
    private List<String> suppression_overrides;

    @JsonProperty("suppression_overrides")
    public List<String> getSuppressionOverrides() {
      return suppression_overrides;
    }

    public UpdateConfigurationSetRequestInput withSuppressionOverrides(List<String> value) {
      this.suppression_overrides = value;
      return this;
    }

    /** UUID, CRN or account-unique name. Omit to preserve; null detaches the pool. */
    @JsonProperty(value = "ip_pool", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> ip_pool = JsonField.missing();

    @JsonProperty("ip_pool")
    public JsonField<String> getIpPool() {
      return ip_pool;
    }

    public UpdateConfigurationSetRequestInput withIpPool(JsonField<String> value) {
      this.ip_pool = value;
      return this;
    }

    @JsonProperty(value = "tracking_open", required = false)
    private Boolean tracking_open;

    @JsonProperty("tracking_open")
    public Boolean getTrackingOpen() {
      return tracking_open;
    }

    public UpdateConfigurationSetRequestInput withTrackingOpen(Boolean value) {
      this.tracking_open = value;
      return this;
    }

    @JsonProperty(value = "tracking_click", required = false)
    private Boolean tracking_click;

    @JsonProperty("tracking_click")
    public Boolean getTrackingClick() {
      return tracking_click;
    }

    public UpdateConfigurationSetRequestInput withTrackingClick(Boolean value) {
      this.tracking_click = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateConfigurationSetRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UpdateDedicatedIPRequestInput extends Model {
    public UpdateDedicatedIPRequestInput() {}

    @JsonProperty(value = "warmup_status", required = false)
    private UpdateDedicatedIPRequestInputWarmupStatus warmup_status;

    @JsonProperty("warmup_status")
    public UpdateDedicatedIPRequestInputWarmupStatus getWarmupStatus() {
      return warmup_status;
    }

    public UpdateDedicatedIPRequestInput withWarmupStatus(
        UpdateDedicatedIPRequestInputWarmupStatus value) {
      this.warmup_status = value;
      return this;
    }

    /** UUID, CRN or account-unique pool name. Null detaches; omission leaves unchanged. */
    @JsonProperty(value = "ip_pool", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> ip_pool = JsonField.missing();

    @JsonProperty("ip_pool")
    public JsonField<String> getIpPool() {
      return ip_pool;
    }

    public UpdateDedicatedIPRequestInput withIpPool(JsonField<String> value) {
      this.ip_pool = value;
      return this;
    }
  }

  public static final class UpdateDedicatedIPRequestInputWarmupStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UpdateDedicatedIPRequestInputWarmupStatus(String value) {
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
      return other instanceof UpdateDedicatedIPRequestInputWarmupStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final UpdateDedicatedIPRequestInputWarmupStatus NEW =
        new UpdateDedicatedIPRequestInputWarmupStatus("new");
    public static final UpdateDedicatedIPRequestInputWarmupStatus WARMING =
        new UpdateDedicatedIPRequestInputWarmupStatus("warming");
    public static final UpdateDedicatedIPRequestInputWarmupStatus WARM =
        new UpdateDedicatedIPRequestInputWarmupStatus("warm");
  }

  public static final class UpdateIPPoolRequestInput extends Model {
    public UpdateIPPoolRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public UpdateIPPoolRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }
  }

  public static final class UpdateIdentityRequestInput extends Model {
    public UpdateIdentityRequestInput() {}

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateIdentityRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UpdateReceivingConfigurationRequestInput extends Model {
    public UpdateReceivingConfigurationRequestInput() {}

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public UpdateReceivingConfigurationRequestInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    /**
     * Same-account, same-region bucket name, UUID or CRN. Omission preserves the current bucket;
     * null clears it while receiving is disabled. Saving requires storage PutObject and GetObject
     * permission under email/{identity_id}/ in this bucket. Changing the bucket affects new
     * messages only.
     */
    @JsonProperty(value = "attachments_bucket", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> attachments_bucket = JsonField.missing();

    @JsonProperty("attachments_bucket")
    public JsonField<String> getAttachmentsBucket() {
      return attachments_bucket;
    }

    public UpdateReceivingConfigurationRequestInput withAttachmentsBucket(JsonField<String> value) {
      this.attachments_bucket = value;
      return this;
    }
  }

  public static final class UpdateRecipientRuleRequestInput extends Model {
    public UpdateRecipientRuleRequestInput() {}

    /**
     * Exact local part, local-part prefix, or catch-all for this identity. Exact matches take
     * precedence, then the longest prefix, then catch-all.
     */
    @JsonProperty(value = "match_type", required = false)
    private UpdateRecipientRuleRequestInputMatchType match_type;

    @JsonProperty("match_type")
    public UpdateRecipientRuleRequestInputMatchType getMatchType() {
      return match_type;
    }

    public UpdateRecipientRuleRequestInput withMatchType(
        UpdateRecipientRuleRequestInputMatchType value) {
      this.match_type = value;
      return this;
    }

    /** Required for exact and prefix; empty or omitted for all. */
    @JsonProperty(value = "local_part", required = false)
    private String local_part;

    @JsonProperty("local_part")
    public String getLocalPart() {
      return local_part;
    }

    public UpdateRecipientRuleRequestInput withLocalPart(String value) {
      this.local_part = value;
      return this;
    }

    /**
     * Notifications topic name, UUID or CRN. Requires notifications:Publish on the same-account
     * topic.
     */
    @JsonProperty(value = "topic", required = false)
    private String topic;

    @JsonProperty("topic")
    public String getTopic() {
      return topic;
    }

    public UpdateRecipientRuleRequestInput withTopic(String value) {
      this.topic = value;
      return this;
    }

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public UpdateRecipientRuleRequestInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }
  }

  public static final class UpdateRecipientRuleRequestInputMatchType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UpdateRecipientRuleRequestInputMatchType(String value) {
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
      return other instanceof UpdateRecipientRuleRequestInputMatchType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final UpdateRecipientRuleRequestInputMatchType EXACT =
        new UpdateRecipientRuleRequestInputMatchType("exact");
    public static final UpdateRecipientRuleRequestInputMatchType PREFIX =
        new UpdateRecipientRuleRequestInputMatchType("prefix");
    public static final UpdateRecipientRuleRequestInputMatchType ALL =
        new UpdateRecipientRuleRequestInputMatchType("all");
  }

  public static final class UpdateSuppressionRequestInput extends Model {
    public UpdateSuppressionRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public UpdateSuppressionRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /** Null makes the suppression permanent; omission preserves its expiry. */
    @JsonProperty(value = "expires_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> expires_at = JsonField.missing();

    @JsonProperty("expires_at")
    public JsonField<String> getExpiresAt() {
      return expires_at;
    }

    public UpdateSuppressionRequestInput withExpiresAt(JsonField<String> value) {
      this.expires_at = value;
      return this;
    }
  }

  public static final class UpdateTemplateRequestInput extends Model {
    public UpdateTemplateRequestInput() {}

    @JsonProperty(value = "subject_template", required = false)
    private String subject_template;

    @JsonProperty("subject_template")
    public String getSubjectTemplate() {
      return subject_template;
    }

    public UpdateTemplateRequestInput withSubjectTemplate(String value) {
      this.subject_template = value;
      return this;
    }

    @JsonProperty(value = "body_template", required = false)
    private String body_template;

    @JsonProperty("body_template")
    public String getBodyTemplate() {
      return body_template;
    }

    public UpdateTemplateRequestInput withBodyTemplate(String value) {
      this.body_template = value;
      return this;
    }

    @JsonProperty(value = "body_type", required = false)
    private UpdateTemplateRequestInputBodyType body_type;

    @JsonProperty("body_type")
    public UpdateTemplateRequestInputBodyType getBodyType() {
      return body_type;
    }

    public UpdateTemplateRequestInput withBodyType(UpdateTemplateRequestInputBodyType value) {
      this.body_type = value;
      return this;
    }
  }

  public static final class UpdateTemplateRequestInputBodyType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UpdateTemplateRequestInputBodyType(String value) {
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
      return other instanceof UpdateTemplateRequestInputBodyType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final UpdateTemplateRequestInputBodyType TEXT =
        new UpdateTemplateRequestInputBodyType("text");
    public static final UpdateTemplateRequestInputBodyType HTML =
        new UpdateTemplateRequestInputBodyType("html");
  }
}
