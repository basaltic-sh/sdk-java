package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

/** Typed catalog wire models. Unknown string enum values are retained. */
public final class Catalog {

  private Catalog() {}

  public static final class GetCountryResponse extends Model {
    public GetCountryResponse() {}

    @JsonProperty(value = "country", required = true)
    private CountryDetail country;

    @JsonProperty("country")
    public CountryDetail getCountry() {
      return country;
    }
  }

  public static final class CountryDetail extends Model {
    public CountryDetail() {}

    /** Stable in every environment. */
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

    /** ISO 3166-1 alpha-2 code. Also accepted wherever a country selector is. */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    /** ISO 3166-1 alpha-3 code. */
    @JsonProperty(value = "iso3", required = true)
    private String iso3;

    @JsonProperty("iso3")
    public String getIso3() {
      return iso3;
    }

    /** English short name. Clients localize it from `code`. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /**
     * International calling code without the plus sign. Several countries share one (1 covers the
     * United States and Canada). Empty when none is assigned.
     */
    @JsonProperty(value = "calling_code", required = true)
    private String calling_code;

    @JsonProperty("calling_code")
    public String getCallingCode() {
      return calling_code;
    }

    @JsonProperty(value = "rules", required = true)
    private CountryRules rules;

    @JsonProperty("rules")
    public CountryRules getRules() {
      return rules;
    }

    /** True when `GET /v1/postal-codes/{code}` can resolve this country's postal codes. */
    @JsonProperty(value = "postal_lookup", required = true)
    private Boolean postal_lookup;

    @JsonProperty("postal_lookup")
    public Boolean getPostalLookup() {
      return postal_lookup;
    }
  }

  public static final class CountryRules extends Model {
    public CountryRules() {}

    @JsonProperty(value = "customer_types", required = true)
    private List<CountryRulesCustomerTypesItem> customer_types;

    @JsonProperty("customer_types")
    public List<CountryRulesCustomerTypesItem> getCustomerTypes() {
      return customer_types;
    }

    /** Label for the recipient name, keyed by customer type. */
    @JsonProperty(value = "name_labels", required = true)
    private Map<String, String> name_labels;

    @JsonProperty("name_labels")
    public Map<String, String> getNameLabels() {
      return name_labels;
    }

    /** Accepted tax identifier kinds, keyed by customer type. */
    @JsonProperty(value = "tax_ids", required = true)
    private Map<String, List<TaxIDRule>> tax_ids;

    @JsonProperty("tax_ids")
    public Map<String, List<TaxIDRule>> getTaxIds() {
      return tax_ids;
    }

    /** Address fields in form order. A key that is absent is not asked for in this country. */
    @JsonProperty(value = "fields", required = true)
    private List<AddressField> fields;

    @JsonProperty("fields")
    public List<AddressField> getFields() {
      return fields;
    }
  }

  public static final class CountryRulesCustomerTypesItem {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CountryRulesCustomerTypesItem(String value) {
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
      return other instanceof CountryRulesCustomerTypesItem v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CountryRulesCustomerTypesItem INDIVIDUAL =
        new CountryRulesCustomerTypesItem("individual");
    public static final CountryRulesCustomerTypesItem COMPANY =
        new CountryRulesCustomerTypesItem("company");
  }

  public static final class TaxIDRule extends Model {
    public TaxIDRule() {}

    /**
     * Identifier kind, returned as `tax_id_kind` on the billing profile. `other` is free text in a
     * country without curated rules.
     */
    @JsonProperty(value = "kind", required = true)
    private String kind;

    @JsonProperty("kind")
    public String getKind() {
      return kind;
    }

    @JsonProperty(value = "label", required = true)
    private String label;

    @JsonProperty("label")
    public String getLabel() {
      return label;
    }

    @JsonProperty(value = "mask", required = false)
    private String mask;

    @JsonProperty("mask")
    public String getMask() {
      return mask;
    }

    @JsonProperty(value = "pattern", required = false)
    private String pattern;

    @JsonProperty("pattern")
    public String getPattern() {
      return pattern;
    }

    /** Named check-digit algorithm the server applies. */
    @JsonProperty(value = "validator", required = false)
    private TaxIDRuleValidator validator;

    @JsonProperty("validator")
    public TaxIDRuleValidator getValidator() {
      return validator;
    }

    @JsonProperty(value = "example", required = false)
    private String example;

    @JsonProperty("example")
    public String getExample() {
      return example;
    }

    /** When true, `no_tax_id_reason` is not accepted instead. */
    @JsonProperty(value = "required", required = true)
    private Boolean required;

    @JsonProperty("required")
    public Boolean getRequired() {
      return required;
    }
  }

  public static final class TaxIDRuleValidator {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TaxIDRuleValidator(String value) {
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
      return other instanceof TaxIDRuleValidator v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TaxIDRuleValidator BR_CPF = new TaxIDRuleValidator("br_cpf");
    public static final TaxIDRuleValidator BR_CNPJ = new TaxIDRuleValidator("br_cnpj");
    public static final TaxIDRuleValidator AR_CUIT = new TaxIDRuleValidator("ar_cuit");
    public static final TaxIDRuleValidator CL_RUT = new TaxIDRuleValidator("cl_rut");
  }

  public static final class AddressField extends Model {
    public AddressField() {}

    @JsonProperty(value = "key", required = true)
    private AddressFieldKey key;

    @JsonProperty("key")
    public AddressFieldKey getKey() {
      return key;
    }

    @JsonProperty(value = "label", required = true)
    private String label;

    @JsonProperty("label")
    public String getLabel() {
      return label;
    }

    @JsonProperty(value = "required", required = true)
    private Boolean required;

    @JsonProperty("required")
    public Boolean getRequired() {
      return required;
    }

    /** Maximum length in characters. */
    @JsonProperty(value = "max", required = false)
    private Long max;

    @JsonProperty("max")
    public Long getMax() {
      return max;
    }

    /**
     * Display mask: `9` a digit, `A` a letter, `*` a letter or digit, `?` makes the previous symbol
     * optional, anything else is a literal. Values are stored without the literals.
     */
    @JsonProperty(value = "mask", required = false)
    private String mask;

    @JsonProperty("mask")
    public String getMask() {
      return mask;
    }

    /** Regular expression the stored value must match in full. */
    @JsonProperty(value = "pattern", required = false)
    private String pattern;

    @JsonProperty("pattern")
    public String getPattern() {
      return pattern;
    }

    @JsonProperty(value = "example", required = false)
    private String example;

    @JsonProperty("example")
    public String getExample() {
      return example;
    }

    /**
     * For state and city only. `list` means pick a catalog row and send its selector; `free` means
     * type the value under the address key.
     */
    @JsonProperty(value = "source", required = false)
    private AddressFieldSource source;

    @JsonProperty("source")
    public AddressFieldSource getSource() {
      return source;
    }

    /**
     * For a listed city, an internal attribute the city must carry for the profile to be complete.
     */
    @JsonProperty(value = "require_metadata", required = false)
    private String require_metadata;

    @JsonProperty("require_metadata")
    public String getRequireMetadata() {
      return require_metadata;
    }
  }

  public static final class AddressFieldKey {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AddressFieldKey(String value) {
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
      return other instanceof AddressFieldKey v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AddressFieldKey STREET_NAME = new AddressFieldKey("street_name");
    public static final AddressFieldKey STREET_NUMBER = new AddressFieldKey("street_number");
    public static final AddressFieldKey COMPLEMENT = new AddressFieldKey("complement");
    public static final AddressFieldKey NEIGHBORHOOD = new AddressFieldKey("neighborhood");
    public static final AddressFieldKey CITY = new AddressFieldKey("city");
    public static final AddressFieldKey STATE = new AddressFieldKey("state");
    public static final AddressFieldKey POSTAL_CODE = new AddressFieldKey("postal_code");
  }

  public static final class AddressFieldSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AddressFieldSource(String value) {
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
      return other instanceof AddressFieldSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AddressFieldSource LIST = new AddressFieldSource("list");
    public static final AddressFieldSource FREE = new AddressFieldSource("free");
  }

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

  public static final class ListCitiesQuery extends Model {
    public ListCitiesQuery() {}

    @JsonProperty(value = "state", required = false)
    private String state;

    @JsonProperty("state")
    public String getState() {
      return state;
    }

    public ListCitiesQuery withState(String value) {
      this.state = value;
      return this;
    }

    @JsonProperty(value = "country", required = false)
    private String country;

    @JsonProperty("country")
    public String getCountry() {
      return country;
    }

    public ListCitiesQuery withCountry(String value) {
      this.country = value;
      return this;
    }

    @JsonProperty(value = "q", required = false)
    private String q;

    @JsonProperty("q")
    public String getQ() {
      return q;
    }

    public ListCitiesQuery withQ(String value) {
      this.q = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListCitiesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListCitiesResponse extends Model {
    public ListCitiesResponse() {}

    @JsonProperty(value = "cities", required = true)
    private List<City> cities;

    @JsonProperty("cities")
    public List<City> getCities() {
      return cities;
    }

    @JsonProperty(value = "meta", required = true)
    private GeoPage meta;

    @JsonProperty("meta")
    public GeoPage getMeta() {
      return meta;
    }
  }

  public static final class City extends Model {
    public City() {}

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

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "country", required = true)
    private ResourceRef country;

    @JsonProperty("country")
    public ResourceRef getCountry() {
      return country;
    }

    /** Null for countries without states. */
    @JsonProperty(value = "state", required = true)
    private CityState state;

    @JsonProperty("state")
    public CityState getState() {
      return state;
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

  public static final class CityState {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CityState(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "CityState{[REDACTED]}";
    }

    public static CityState ofVariant1(ResourceRef value) {
      Model.validate(value);
      return new CityState(Json.tree(value));
    }

    public Optional<ResourceRef> asVariant1() {
      try {
        ResourceRef result = Json.convert(value, new TypeReference<ResourceRef>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static CityState ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new CityState(Json.tree(value));
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

  public static final class GeoPage extends Model {
    public GeoPage() {}

    /** Items in this response. */
    @JsonProperty(value = "total", required = true)
    private Long total;

    @JsonProperty("total")
    public Long getTotal() {
      return total;
    }

    @JsonProperty(value = "limit", required = true)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    /** True when more rows matched than were returned. Narrow with `q`. */
    @JsonProperty(value = "has_more", required = true)
    private Boolean has_more;

    @JsonProperty("has_more")
    public Boolean getHasMore() {
      return has_more;
    }
  }

  public static final class ListCountriesResponse extends Model {
    public ListCountriesResponse() {}

    @JsonProperty(value = "countries", required = true)
    private List<Country> countries;

    @JsonProperty("countries")
    public List<Country> getCountries() {
      return countries;
    }

    @JsonProperty(value = "meta", required = true)
    private GeoPage meta;

    @JsonProperty("meta")
    public GeoPage getMeta() {
      return meta;
    }
  }

  public static final class Country extends Model {
    public Country() {}

    /** Stable in every environment. */
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

    /** ISO 3166-1 alpha-2 code. Also accepted wherever a country selector is. */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    /** ISO 3166-1 alpha-3 code. */
    @JsonProperty(value = "iso3", required = true)
    private String iso3;

    @JsonProperty("iso3")
    public String getIso3() {
      return iso3;
    }

    /** English short name. Clients localize it from `code`. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /**
     * International calling code without the plus sign. Several countries share one (1 covers the
     * United States and Canada). Empty when none is assigned.
     */
    @JsonProperty(value = "calling_code", required = true)
    private String calling_code;

    @JsonProperty("calling_code")
    public String getCallingCode() {
      return calling_code;
    }
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

  public static final class ListStatesQuery extends Model {
    public ListStatesQuery() {}

    @JsonProperty(value = "country", required = true)
    private String country;

    @JsonProperty("country")
    public String getCountry() {
      return country;
    }

    public ListStatesQuery withCountry(String value) {
      this.country = value;
      return this;
    }
  }

  public static final class ListStatesResponse extends Model {
    public ListStatesResponse() {}

    @JsonProperty(value = "states", required = true)
    private List<State> states;

    @JsonProperty("states")
    public List<State> getStates() {
      return states;
    }

    @JsonProperty(value = "meta", required = true)
    private GeoPage meta;

    @JsonProperty("meta")
    public GeoPage getMeta() {
      return meta;
    }
  }

  public static final class State extends Model {
    public State() {}

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

    /** ISO 3166-2 subdivision code without the country prefix, where one exists. */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "country", required = true)
    private ResourceRef country;

    @JsonProperty("country")
    public ResourceRef getCountry() {
      return country;
    }
  }

  public static final class LookupPostalCodeQuery extends Model {
    public LookupPostalCodeQuery() {}

    @JsonProperty(value = "country", required = true)
    private String country;

    @JsonProperty("country")
    public String getCountry() {
      return country;
    }

    public LookupPostalCodeQuery withCountry(String value) {
      this.country = value;
      return this;
    }
  }

  public static final class LookupPostalCodeResponse extends Model {
    public LookupPostalCodeResponse() {}

    @JsonProperty(value = "postal_code", required = true)
    private PostalCode postal_code;

    @JsonProperty("postal_code")
    public PostalCode getPostalCode() {
      return postal_code;
    }
  }

  public static final class PostalCode extends Model {
    public PostalCode() {}

    /** The postal code as stored, without mask literals. */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    @JsonProperty(value = "country", required = true)
    private ResourceRef country;

    @JsonProperty("country")
    public ResourceRef getCountry() {
      return country;
    }

    /** The resolved catalog state, when the country lists states and the answer matched one. */
    @JsonProperty(value = "state", required = true)
    private PostalCodeState state;

    @JsonProperty("state")
    public PostalCodeState getState() {
      return state;
    }

    /** The resolved catalog city, when the country lists cities and the answer matched one. */
    @JsonProperty(value = "city", required = true)
    private PostalCodeCity city;

    @JsonProperty("city")
    public PostalCodeCity getCity() {
      return city;
    }

    /**
     * Other address values the provider knew, limited to keys the country uses. State and city
     * appear here as text where the country types them.
     */
    @JsonProperty(value = "address", required = true)
    private Map<String, String> address;

    @JsonProperty("address")
    public Map<String, String> getAddress() {
      return address;
    }

    /** The provider that answered. */
    @JsonProperty(value = "source", required = true)
    private String source;

    @JsonProperty("source")
    public String getSource() {
      return source;
    }
  }

  public static final class PostalCodeState {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PostalCodeState(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "PostalCodeState{[REDACTED]}";
    }

    public static PostalCodeState ofVariant1(ResourceRef value) {
      Model.validate(value);
      return new PostalCodeState(Json.tree(value));
    }

    public Optional<ResourceRef> asVariant1() {
      try {
        ResourceRef result = Json.convert(value, new TypeReference<ResourceRef>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static PostalCodeState ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new PostalCodeState(Json.tree(value));
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

  public static final class PostalCodeCity {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PostalCodeCity(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "PostalCodeCity{[REDACTED]}";
    }

    public static PostalCodeCity ofVariant1(ResourceRef value) {
      Model.validate(value);
      return new PostalCodeCity(Json.tree(value));
    }

    public Optional<ResourceRef> asVariant1() {
      try {
        ResourceRef result = Json.convert(value, new TypeReference<ResourceRef>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static PostalCodeCity ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new PostalCodeCity(Json.tree(value));
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
}
