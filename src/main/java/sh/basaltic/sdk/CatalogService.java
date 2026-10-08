package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Catalog.GetRegionScope;
import sh.basaltic.sdk.models.Catalog.ListRegionsQuery;
import sh.basaltic.sdk.models.Catalog.ListRegionsResponse;
import sh.basaltic.sdk.models.Catalog.Region;

/** Typed catalog API methods. */
public final class CatalogService {
  private final Transport transport;

  CatalogService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
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
  private static final Operation OP_1 =
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

  /** Get a region */
  public Request<Region> getRegion(String code) {
    return new Request<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_0,
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
            OP_0,
            Map.ofEntries(Map.entry("code", reference)),
            null,
            null),
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_1,
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

  /** List regions */
  public PagedRequest<ListRegionsResponse, Region> listRegions(ListRegionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "catalog",
            "https://catalog.basaltic.sh",
            OP_1,
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
}
