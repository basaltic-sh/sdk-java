package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.internal.Model;

/** Typed quota wire models. Unknown string enum values are retained. */
public final class Quota {

  private Quota() {}

  public static final class ListQuotasQuery extends Model {
    public ListQuotasQuery() {}

    @JsonProperty(value = "region", required = false)
    private String region;

    @JsonProperty("region")
    public String getRegion() {
      return region;
    }

    public ListQuotasQuery withRegion(String value) {
      this.region = value;
      return this;
    }
  }

  public static final class QuotaListResponse extends Model {
    public QuotaListResponse() {}

    @JsonProperty(value = "quotas", required = true)
    private List<QuotaItem> quotas;

    @JsonProperty("quotas")
    public List<QuotaItem> getQuotas() {
      return quotas;
    }

    /**
     * Non-reservation policies for the organization in the requested region. Currently contains the
     * four Email size and recipient policies. Empty when region is omitted. Older servers may omit
     * this additive field.
     */
    @JsonProperty(value = "policies", required = false)
    private List<QuotaPolicy> policies;

    @JsonProperty("policies")
    public List<QuotaPolicy> getPolicies() {
      return policies;
    }
  }

  public static final class QuotaItem extends Model {
    public QuotaItem() {}

    /**
     * The service that owns the quota. Together with resource_type it identifies the quota —
     * resource_type alone is not unique (e.g. both compute and database have an `instances` quota).
     */
    @JsonProperty(value = "service", required = true)
    private String service;

    @JsonProperty("service")
    public String getService() {
      return service;
    }

    /**
     * The resource the cap applies to. See migrations/quota/001_quotas.sql for the seeded list
     * (instances, vcpus, ram_mb, volumes, …, domains_per_certificate, records_per_zone, …).
     */
    @JsonProperty(value = "resource_type", required = true)
    private String resource_type;

    @JsonProperty("resource_type")
    public String getResourceType() {
      return resource_type;
    }

    @JsonProperty(value = "scope", required = true)
    private QuotaItemScope scope;

    @JsonProperty("scope")
    public QuotaItemScope getScope() {
      return scope;
    }

    /** Effective limit (-1 = unlimited). Override if set, otherwise default. */
    @JsonProperty(value = "limit", required = true)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    /**
     * Resources currently consuming this quota. Zero for per_resource quotas (no running counter —
     * the cap applies per parent resource).
     */
    @JsonProperty(value = "in_use", required = true)
    private Long in_use;

    @JsonProperty("in_use")
    public Long getInUse() {
      return in_use;
    }

    /** Resources temporarily reserved during async creation. Zero for per_resource quotas. */
    @JsonProperty(value = "reserved", required = true)
    private Long reserved;

    @JsonProperty("reserved")
    public Long getReserved() {
      return reserved;
    }

    /** limit - in_use - reserved, floored at 0; -1 if unlimited. */
    @JsonProperty(value = "available", required = true)
    private Long available;

    @JsonProperty("available")
    public Long getAvailable() {
      return available;
    }

    /** True if the limit comes from the system default; false if there is a per-org override. */
    @JsonProperty(value = "is_default", required = true)
    private Boolean is_default;

    @JsonProperty("is_default")
    public Boolean getIsDefault() {
      return is_default;
    }

    @JsonProperty(value = "description", required = true)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }
  }

  public static final class QuotaItemScope {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QuotaItemScope(String value) {
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
      return other instanceof QuotaItemScope v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QuotaItemScope REGIONAL = new QuotaItemScope("regional");
    public static final QuotaItemScope GLOBAL = new QuotaItemScope("global");
    public static final QuotaItemScope PER_RESOURCE = new QuotaItemScope("per_resource");
  }

  public static final class QuotaPolicy extends Model {
    public QuotaPolicy() {}

    @JsonProperty(value = "service", required = true)
    private QuotaPolicyService service;

    @JsonProperty("service")
    public QuotaPolicyService getService() {
      return service;
    }

    @JsonProperty(value = "resource_type", required = true)
    private QuotaPolicyResourceType resource_type;

    @JsonProperty("resource_type")
    public QuotaPolicyResourceType getResourceType() {
      return resource_type;
    }

    /**
     * The policy applies to the caller's organization in region, even if its value comes from an
     * organization-wide override.
     */
    @JsonProperty(value = "scope", required = true)
    private QuotaPolicyScope scope;

    @JsonProperty("scope")
    public QuotaPolicyScope getScope() {
      return scope;
    }

    @JsonProperty(value = "region", required = true)
    private String region;

    @JsonProperty("region")
    public String getRegion() {
      return region;
    }

    /**
     * Effective policy value after regional and organization overrides; -1 means unlimited by this
     * policy and 0 permits none. The separate Email message ceiling of 52428800 bytes (50 MiB)
     * applies even when the size policy is unlimited or larger than the ceiling.
     */
    @JsonProperty(value = "limit", required = true)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    /** Bytes per complete encoded sending message, or accepted recipients per rolling window. */
    @JsonProperty(value = "unit", required = true)
    private QuotaPolicyUnit unit;

    @JsonProperty("unit")
    public QuotaPolicyUnit getUnit() {
      return unit;
    }

    /**
     * Rolling window length for recipient policies. Omitted for message size; 86400 means rolling
     * 24 hours.
     */
    @JsonProperty(value = "window_seconds", required = false)
    private Long window_seconds;

    @JsonProperty("window_seconds")
    public Long getWindowSeconds() {
      return window_seconds;
    }

    /** Platform default, organization-wide override, or override for the requested region. */
    @JsonProperty(value = "limit_source", required = true)
    private QuotaPolicyLimitSource limit_source;

    @JsonProperty("limit_source")
    public QuotaPolicyLimitSource getLimitSource() {
      return limit_source;
    }

    @JsonProperty(value = "description", required = true)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }
  }

  public static final class QuotaPolicyService {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QuotaPolicyService(String value) {
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
      return other instanceof QuotaPolicyService v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QuotaPolicyService EMAIL = new QuotaPolicyService("email");
  }

  public static final class QuotaPolicyResourceType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QuotaPolicyResourceType(String value) {
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
      return other instanceof QuotaPolicyResourceType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QuotaPolicyResourceType MESSAGE_SIZE_BYTES =
        new QuotaPolicyResourceType("message_size_bytes");
    public static final QuotaPolicyResourceType SENT_RECIPIENTS_PER_SECOND =
        new QuotaPolicyResourceType("sent_recipients_per_second");
    public static final QuotaPolicyResourceType SENT_RECIPIENTS_PER_DAY =
        new QuotaPolicyResourceType("sent_recipients_per_day");
    public static final QuotaPolicyResourceType RECEIVED_RECIPIENTS_PER_SECOND =
        new QuotaPolicyResourceType("received_recipients_per_second");
  }

  public static final class QuotaPolicyScope {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QuotaPolicyScope(String value) {
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
      return other instanceof QuotaPolicyScope v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QuotaPolicyScope REGIONAL = new QuotaPolicyScope("regional");
  }

  public static final class QuotaPolicyUnit {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QuotaPolicyUnit(String value) {
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
      return other instanceof QuotaPolicyUnit v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QuotaPolicyUnit BYTES = new QuotaPolicyUnit("bytes");
    public static final QuotaPolicyUnit RECIPIENTS = new QuotaPolicyUnit("recipients");
  }

  public static final class QuotaPolicyLimitSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public QuotaPolicyLimitSource(String value) {
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
      return other instanceof QuotaPolicyLimitSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final QuotaPolicyLimitSource DEFAULT = new QuotaPolicyLimitSource("default");
    public static final QuotaPolicyLimitSource ORGANIZATION =
        new QuotaPolicyLimitSource("organization");
    public static final QuotaPolicyLimitSource REGION = new QuotaPolicyLimitSource("region");
  }
}
