package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Dns.GetRecordScope;
import sh.basaltic.sdk.models.Dns.GetZoneScope;
import sh.basaltic.sdk.models.Dns.ListRecordsQuery;
import sh.basaltic.sdk.models.Dns.ListZoneVPCAssociationsQuery;
import sh.basaltic.sdk.models.Dns.ListZonesQuery;
import sh.basaltic.sdk.models.Dns.Record;
import sh.basaltic.sdk.models.Dns.RecordCreateRequestInput;
import sh.basaltic.sdk.models.Dns.RecordListResponse;
import sh.basaltic.sdk.models.Dns.RecordResponse;
import sh.basaltic.sdk.models.Dns.RecordUpdateRequestInput;
import sh.basaltic.sdk.models.Dns.VPCAssociationAccepted;
import sh.basaltic.sdk.models.Dns.VPCAssociationRequestInput;
import sh.basaltic.sdk.models.Dns.VPCAssociationsResponse;
import sh.basaltic.sdk.models.Dns.Zone;
import sh.basaltic.sdk.models.Dns.ZoneCreateRequestInput;
import sh.basaltic.sdk.models.Dns.ZoneImportRequestInput;
import sh.basaltic.sdk.models.Dns.ZoneImportResponse;
import sh.basaltic.sdk.models.Dns.ZoneListResponse;
import sh.basaltic.sdk.models.Dns.ZoneRecordImportResponse;
import sh.basaltic.sdk.models.Dns.ZoneResponse;
import sh.basaltic.sdk.models.Dns.ZoneUpdateRequestInput;

/** Typed dns API methods. */
public final class DnsService {
  private final Transport transport;

  DnsService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "associateZoneVPC",
          "POST",
          "/v1/zones/{zone_id}/vpc-associations",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "createRecord",
          "POST",
          "/v1/zones/{zone_id}/records",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "createZone",
          "POST",
          "/v1/zones",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "deleteRecord",
          "DELETE",
          "/v1/zones/{zone_id}/records/{record_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "deleteZone",
          "DELETE",
          "/v1/zones/{zone_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "deleteZoneRecordImport",
          "DELETE",
          "/v1/zones/{zone_id}/record-import",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "dissociateZoneVPC",
          "DELETE",
          "/v1/zones/{zone_id}/vpc-associations/{vpc_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "exportZoneFile",
          "GET",
          "/v1/zones/{zone_id}/export",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_8 =
      new Operation(
          "getRecord",
          "GET",
          "/v1/zones/{zone_id}/records/{record_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "getZone",
          "GET",
          "/v1/zones/{zone_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "getZoneRecordImport",
          "GET",
          "/v1/zones/{zone_id}/record-import",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "importZoneFile",
          "POST",
          "/v1/zones/{zone_id}/import",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "listRecords",
          "GET",
          "/v1/zones/{zone_id}/records",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("type", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("include_managed", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "listZoneVPCAssociations",
          "GET",
          "/v1/zones/{zone_id}/vpc-associations",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "listZones",
          "GET",
          "/v1/zones",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "updateRecord",
          "PATCH",
          "/v1/zones/{zone_id}/records/{record_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "updateZone",
          "PATCH",
          "/v1/zones/{zone_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "verifyZoneOwnership",
          "POST",
          "/v1/zones/{zone_id}/verify-ownership",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");

  /** Associate a VPC with a private zone */
  public Request<VPCAssociationAccepted> associateZoneVPC(
      String zone_id, VPCAssociationRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            body,
            null),
        new TypeReference<VPCAssociationAccepted>() {});
  }

  /** Create record */
  public Request<RecordResponse> createRecord(String zone_id, RecordCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            body,
            null),
        new TypeReference<RecordResponse>() {});
  }

  /** Create zone */
  public Request<ZoneResponse> createZone(ZoneCreateRequestInput body) {
    return new Request<>(
        new Core(transport, "dns", "https://dns.basaltic.sh", OP_2, Map.ofEntries(), body, null),
        new TypeReference<ZoneResponse>() {});
  }

  /** Delete record */
  public EmptyRequest deleteRecord(String zone_id, String record_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("zone_id", zone_id), Map.entry("record_id", record_id)),
            null,
            null));
  }

  /** Delete zone */
  public EmptyRequest deleteZone(String zone_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            null));
  }

  /** Discard the record-import outcome */
  public EmptyRequest deleteZoneRecordImport(String zone_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            null));
  }

  /** Dissociate a VPC from a private zone */
  public EmptyRequest dissociateZoneVPC(String zone_id, String vpc_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("zone_id", zone_id), Map.entry("vpc_id", vpc_id)),
            null,
            null));
  }

  /** Export the zone as a zone file */
  public BinaryRequest exportZoneFile(String zone_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            null));
  }

  /** Get record */
  public Request<RecordResponse> getRecord(String zone_id, String record_id) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("zone_id", zone_id), Map.entry("record_id", record_id)),
            null,
            null),
        new TypeReference<RecordResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Record> getRecordByReference(
      String zone_id, String reference, GetRecordScope scope) {
    return Request.reference(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("zone_id", zone_id), Map.entry("record_id", reference)),
            null,
            null),
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            scope),
        reference,
        true,
        "record",
        "records",
        new TypeReference<Record>() {});
  }

  public Request<Record> getRecordByReference(String zone_id, String reference) {
    return getRecordByReference(zone_id, reference, null);
  }

  /** Get zone */
  public Request<ZoneResponse> getZone(String zone_id) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            null),
        new TypeReference<ZoneResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Zone> getZoneByReference(String reference, GetZoneScope scope) {
    return Request.reference(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("zone_id", reference)),
            null,
            null),
        new Core(transport, "dns", "https://dns.basaltic.sh", OP_14, Map.ofEntries(), null, scope),
        reference,
        true,
        "zone",
        "zones",
        new TypeReference<Zone>() {});
  }

  public Request<Zone> getZoneByReference(String reference) {
    return getZoneByReference(reference, null);
  }

  /** Get the record-import outcome */
  public Request<ZoneRecordImportResponse> getZoneRecordImport(String zone_id) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            null),
        new TypeReference<ZoneRecordImportResponse>() {});
  }

  /** Import a zone file */
  public Request<ZoneImportResponse> importZoneFile(String zone_id, ZoneImportRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            body,
            null),
        new TypeReference<ZoneImportResponse>() {});
  }

  /** List records */
  public PagedRequest<RecordListResponse, Record> listRecords(
      String zone_id, ListRecordsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            query),
        new TypeReference<RecordListResponse>() {},
        new TypeReference<Record>() {},
        "records");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RecordListResponse, Record> listRecords(String zone_id) {
    return listRecords(zone_id, null);
  }

  /** List VPC associations */
  public PagedRequest<VPCAssociationsResponse, String> listZoneVPCAssociations(
      String zone_id, ListZoneVPCAssociationsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            query),
        new TypeReference<VPCAssociationsResponse>() {},
        new TypeReference<String>() {},
        "vpc_ids");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<VPCAssociationsResponse, String> listZoneVPCAssociations(String zone_id) {
    return listZoneVPCAssociations(zone_id, null);
  }

  /** List zones */
  public PagedRequest<ZoneListResponse, Zone> listZones(ListZonesQuery query) {
    return new PagedRequest<>(
        new Core(transport, "dns", "https://dns.basaltic.sh", OP_14, Map.ofEntries(), null, query),
        new TypeReference<ZoneListResponse>() {},
        new TypeReference<Zone>() {},
        "zones");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ZoneListResponse, Zone> listZones() {
    return listZones(null);
  }

  /** Update record */
  public Request<RecordResponse> updateRecord(
      String zone_id, String record_id, RecordUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("zone_id", zone_id), Map.entry("record_id", record_id)),
            body,
            null),
        new TypeReference<RecordResponse>() {});
  }

  /** Update zone */
  public Request<ZoneResponse> updateZone(String zone_id, ZoneUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            body,
            null),
        new TypeReference<ZoneResponse>() {});
  }

  /** Verify zone ownership */
  public Request<ZoneResponse> verifyZoneOwnership(String zone_id) {
    return new Request<>(
        new Core(
            transport,
            "dns",
            "https://dns.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("zone_id", zone_id)),
            null,
            null),
        new TypeReference<ZoneResponse>() {});
  }
}
