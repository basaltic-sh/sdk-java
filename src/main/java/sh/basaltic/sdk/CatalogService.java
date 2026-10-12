package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Catalog.City;
import sh.basaltic.sdk.models.Catalog.Country;
import sh.basaltic.sdk.models.Catalog.GetCountryResponse;
import sh.basaltic.sdk.models.Catalog.GetRegionScope;
import sh.basaltic.sdk.models.Catalog.ListCitiesQuery;
import sh.basaltic.sdk.models.Catalog.ListCitiesResponse;
import sh.basaltic.sdk.models.Catalog.ListCountriesResponse;
import sh.basaltic.sdk.models.Catalog.ListRegionsQuery;
import sh.basaltic.sdk.models.Catalog.ListRegionsResponse;
import sh.basaltic.sdk.models.Catalog.ListStatesQuery;
import sh.basaltic.sdk.models.Catalog.ListStatesResponse;
import sh.basaltic.sdk.models.Catalog.LookupPostalCodeQuery;
import sh.basaltic.sdk.models.Catalog.LookupPostalCodeResponse;
import sh.basaltic.sdk.models.Catalog.Region;
import sh.basaltic.sdk.models.Catalog.State;

/** Typed catalog API methods. */
public final class CatalogService {
  private final Transport transport;

  CatalogService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "getCountry",
          "GET",
          "/v1/countries/{country}",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "getRegion",
          "GET",
          "/v1/regions/{code}",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "listCities",
          "GET",
          "/v1/cities",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("state", new Operation.Encoding("form", true)),
              Map.entry("country", new Operation.Encoding("form", true)),
              Map.entry("q", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "listCountries",
          "GET",
          "/v1/countries",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "listRegions",
          "GET",
          "/v1/regions",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "listStates",
          "GET",
          "/v1/states",
          false,
          List.of("country"),
          List.of(),
          Map.ofEntries(Map.entry("country", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "lookupPostalCode",
          "GET",
          "/v1/postal-codes/{code}",
          false,
          List.of("country"),
          List.of(),
          Map.ofEntries(Map.entry("country", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");

  /** Get a country and its address rules */
  public Request<GetCountryResponse> getCountry(String country) {
    return new Request<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("country", country)),
            null,
            null),
        new TypeReference<GetCountryResponse>() {});
  }

  /** Get a region */
  public Request<Region> getRegion(String code) {
    return new Request<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("code", code)),
            null,
            null),
        new TypeReference<Region>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Region> getRegionByReference(String reference, GetRegionScope scope) {
    return Request.reference(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("code", reference)),
            null,
            null),
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        null,
        "regions",
        new TypeReference<Region>() {});
  }

  public Request<Region> getRegionByReference(String reference) {
    return getRegionByReference(reference, null);
  }

  /** List cities */
  public PagedRequest<ListCitiesResponse, City> listCities(ListCitiesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_2,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ListCitiesResponse>() {},
        new TypeReference<City>() {},
        "cities");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListCitiesResponse, City> listCities() {
    return listCities(null);
  }

  /** List countries */
  public PagedRequest<ListCountriesResponse, Country> listCountries() {
    return new PagedRequest<>(
        new Core(
            transport, "catalog", "https://catalog.basaltic.sh", OP_3, Map.ofEntries(), null, null),
        new TypeReference<ListCountriesResponse>() {},
        new TypeReference<Country>() {},
        "countries");
  }

  /** List regions */
  public PagedRequest<ListRegionsResponse, Region> listRegions(ListRegionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ListRegionsResponse>() {},
        new TypeReference<Region>() {},
        "regions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListRegionsResponse, Region> listRegions() {
    return listRegions(null);
  }

  /** List a country's states */
  public PagedRequest<ListStatesResponse, State> listStates(ListStatesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_5,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ListStatesResponse>() {},
        new TypeReference<State>() {},
        "states");
  }

  /** Look up a postal code */
  public Request<LookupPostalCodeResponse> lookupPostalCode(
      String code, LookupPostalCodeQuery query) {
    return new Request<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("code", code)),
            null,
            query),
        new TypeReference<LookupPostalCodeResponse>() {});
  }
}
