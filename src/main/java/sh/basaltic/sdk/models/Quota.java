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
}
