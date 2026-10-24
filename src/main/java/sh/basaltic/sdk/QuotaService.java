package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Quota.ListQuotasQuery;
import sh.basaltic.sdk.models.Quota.QuotaListResponse;

/** Typed quota API methods. */
public final class QuotaService {
  private final Transport transport;

  QuotaService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "listQuotas",
          "GET",
          "/v1/quotas",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(Map.entry("region", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");

  /** List quotas */
  public Request<QuotaListResponse> listQuotas(ListQuotasQuery query) {
    return new Request<>(
        new Core(
            transport, "quota", "https://quota.basaltic.sh", OP_0, Map.ofEntries(), null, query),
        new TypeReference<QuotaListResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<QuotaListResponse> listQuotas() {
    return listQuotas(null);
  }
}
