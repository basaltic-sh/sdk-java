package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.internal.Model;

/** Typed catalog wire models. Unknown string enum values are retained. */
public final class Catalog {

  private Catalog() {}

  public static final class Region extends Model {
    public Region() {}

    /** Catalog lifecycle, independent of health and capacity. Retired codes are never reused. */
    @JsonProperty(value = "state", required = true)
    private RegionState state;

    @JsonProperty("state")
    public RegionState getState() {
      return state;
    }

    /**
     * True only for active regions. Product services still enforce eligibility, quotas, placement
     * and capacity.
     */
    @JsonProperty(value = "accepting_new_resources", required = true)
    private Boolean accepting_new_resources;

    @JsonProperty("accepting_new_resources")
    public Boolean getAcceptingNewResources() {
      return accepting_new_resources;
    }

    /** Platform-owned global region identity, using the immutable region code. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** Unique region code used in API calls and CRNs */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    /** Human-readable region name */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /** Geographic location of the region */
    @JsonProperty(value = "location", required = true)
    private String location;

    @JsonProperty("location")
    public String getLocation() {
      return location;
    }

    /** ISO 3166-1 alpha-2 country code (used to display flag in UI) */
    @JsonProperty(value = "country_code", required = true)
    private String country_code;

    @JsonProperty("country_code")
    public String getCountryCode() {
      return country_code;
    }

    /** Compatibility alias for accepting_new_resources; not a live health signal */
    @JsonProperty(value = "available", required = true)
    private Boolean available;

    @JsonProperty("available")
    public Boolean getAvailable() {
      return available;
    }

    /** Compatibility flag that is true only when state is planned */
    @JsonProperty(value = "coming_soon", required = true)
    private Boolean coming_soon;

    @JsonProperty("coming_soon")
    public Boolean getComingSoon() {
      return coming_soon;
    }
  }

  public static final class RegionState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RegionState(String value) {
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
      return other instanceof RegionState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RegionState PLANNED = new RegionState("planned");
    public static final RegionState ACTIVE = new RegionState("active");
    public static final RegionState RESTRICTED = new RegionState("restricted");
    public static final RegionState RETIRING = new RegionState("retiring");
    public static final RegionState RETIRED = new RegionState("retired");
  }

  public static final class GetRegionScope extends Model {
    public GetRegionScope() {}
  }

  public static final class ListRegionsQuery extends Model {
    public ListRegionsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRegionsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRegionsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListRegionsResponse extends Model {
    public ListRegionsResponse() {}

    @JsonProperty(value = "regions", required = true)
    private List<Region> regions;

    @JsonProperty("regions")
    public List<Region> getRegions() {
      return regions;
    }

    /** Default accepting region code, or an empty string. */
    @JsonProperty(value = "default", required = true)
    private String defaultValue;

    @JsonProperty("default")
    public String getDefaultValue() {
      return defaultValue;
    }
  }
}
