package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Audit.AuditLog;
import sh.basaltic.sdk.models.Audit.AuditLogListResponse;
import sh.basaltic.sdk.models.Audit.AuditLogResponse;
import sh.basaltic.sdk.models.Audit.GetAuditLogScope;
import sh.basaltic.sdk.models.Audit.ListAuditLogsQuery;

/** Typed audit API methods. */
public final class AuditService {
  private final Transport transport;

  AuditService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "getAuditLog",
          "GET",
          "/v1/audit-logs/{log_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "listAuditLogs",
          "GET",
          "/v1/audit-logs",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("actor", new Operation.Encoding("form", true)),
              Map.entry("actor_type", new Operation.Encoding("form", true)),
              Map.entry("action", new Operation.Encoding("form", true)),
              Map.entry("resource_type", new Operation.Encoding("form", true)),
              Map.entry("resource", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("ip_address", new Operation.Encoding("form", true)),
              Map.entry("from", new Operation.Encoding("form", true)),
              Map.entry("to", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");

  /** Get audit log entry */
  public Request<AuditLogResponse> getAuditLog(String log_id) {
    return new Request<>(
        new Core(
            transport,
            "audit",
            "https://audit.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("log_id", log_id)),
            null,
            null),
        new TypeReference<AuditLogResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<AuditLog> getAuditLogByReference(String reference, GetAuditLogScope scope) {
    return Request.reference(
        new Core(
            transport,
            "audit",
            "https://audit.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("log_id", reference)),
            null,
            null),
        new Core(
            transport, "audit", "https://audit.basaltic.sh", OP_1, Map.ofEntries(), null, scope),
        reference,
        false,
        "audit_log",
        "audit_logs",
        new TypeReference<AuditLog>() {});
  }

  public Request<AuditLog> getAuditLogByReference(String reference) {
    return getAuditLogByReference(reference, null);
  }

  /** List audit logs */
  public PagedRequest<AuditLogListResponse, AuditLog> listAuditLogs(ListAuditLogsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport, "audit", "https://audit.basaltic.sh", OP_1, Map.ofEntries(), null, query),
        new TypeReference<AuditLogListResponse>() {},
        new TypeReference<AuditLog>() {},
        "audit_logs");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<AuditLogListResponse, AuditLog> listAuditLogs() {
    return listAuditLogs(null);
  }
}
