package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.models.Telemetry.CreateLogGroupRequestInput;
import sh.basaltic.sdk.models.Telemetry.GetLogGroupScope;
import sh.basaltic.sdk.models.Telemetry.GetRetainedTelemetryPresenceResponse;
import sh.basaltic.sdk.models.Telemetry.IngestRequestInput;
import sh.basaltic.sdk.models.Telemetry.IngestResult;
import sh.basaltic.sdk.models.Telemetry.IngestSpansRequestInput;
import sh.basaltic.sdk.models.Telemetry.ListLogGroupsQuery;
import sh.basaltic.sdk.models.Telemetry.ListMetricNamesPostBody;
import sh.basaltic.sdk.models.Telemetry.ListMetricNamesPostResponse;
import sh.basaltic.sdk.models.Telemetry.ListMetricNamesQuery;
import sh.basaltic.sdk.models.Telemetry.ListMetricNamesResponse;
import sh.basaltic.sdk.models.Telemetry.ListMetricSeriesPostBody;
import sh.basaltic.sdk.models.Telemetry.ListMetricSeriesQuery;
import sh.basaltic.sdk.models.Telemetry.LogGroup;
import sh.basaltic.sdk.models.Telemetry.LogGroupListResponse;
import sh.basaltic.sdk.models.Telemetry.LogGroupResponse;
import sh.basaltic.sdk.models.Telemetry.LogListResponse;
import sh.basaltic.sdk.models.Telemetry.LogResponse;
import sh.basaltic.sdk.models.Telemetry.QueryMetricsInstantPostBody;
import sh.basaltic.sdk.models.Telemetry.QueryMetricsInstantQuery;
import sh.basaltic.sdk.models.Telemetry.QueryMetricsRangePostBody;
import sh.basaltic.sdk.models.Telemetry.QueryMetricsRangeQuery;
import sh.basaltic.sdk.models.Telemetry.SearchLogsQuery;
import sh.basaltic.sdk.models.Telemetry.SearchTracesQuery;
import sh.basaltic.sdk.models.Telemetry.TraceListResponse;
import sh.basaltic.sdk.models.Telemetry.TraceResponse;
import sh.basaltic.sdk.models.Telemetry.TraceSettingsResponse;
import sh.basaltic.sdk.models.Telemetry.UpdateLogGroupRequestInput;
import sh.basaltic.sdk.models.Telemetry.UpdateTraceSettingsRequestInput;

/** Typed telemetry API methods. */
public final class TelemetryService {
  private final Transport transport;

  TelemetryService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "createLogGroup",
          "POST",
          "/v1/log-groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "deleteLogGroup",
          "DELETE",
          "/v1/log-groups/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "deleteTraceSettings",
          "DELETE",
          "/v1/trace-settings",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "getLog",
          "GET",
          "/v1/logs/{log_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "getLogGroup",
          "GET",
          "/v1/log-groups/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "getRetainedTelemetryPresence",
          "GET",
          "/v1/trace-settings/retained-data",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "getTrace",
          "GET",
          "/v1/traces/{trace_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "getTraceSettings",
          "GET",
          "/v1/trace-settings",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "ingestLogs",
          "POST",
          "/v1/logs",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "ingestSpans",
          "POST",
          "/v1/spans",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "listLogGroups",
          "GET",
          "/v1/log-groups",
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
  private static final Operation OP_11 =
      new Operation(
          "listMetricNames",
          "GET",
          "/v1/metrics/names",
          true,
          List.of("start", "end"),
          List.of(),
          Map.ofEntries(
              Map.entry("start", new Operation.Encoding("form", true)),
              Map.entry("end", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "listMetricNamesPost",
          "POST",
          "/v1/metrics/names",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/x-www-form-urlencoded",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "listMetricSeries",
          "GET",
          "/v1/metrics/series",
          true,
          List.of("metric", "start", "end"),
          List.of(),
          Map.ofEntries(
              Map.entry("metric", new Operation.Encoding("form", true)),
              Map.entry("start", new Operation.Encoding("form", true)),
              Map.entry("end", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "listMetricSeriesPost",
          "POST",
          "/v1/metrics/series",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/x-www-form-urlencoded",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "putTraceSettings",
          "PUT",
          "/v1/trace-settings",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "queryMetricsInstant",
          "GET",
          "/v1/metrics/query",
          true,
          List.of("metric", "agg"),
          List.of(),
          Map.ofEntries(
              Map.entry("metric", new Operation.Encoding("form", true)),
              Map.entry("agg", new Operation.Encoding("form", true)),
              Map.entry("match[]", new Operation.Encoding("form", true)),
              Map.entry("by[]", new Operation.Encoding("form", true)),
              Map.entry("step", new Operation.Encoding("form", true)),
              Map.entry("time", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "queryMetricsInstantPost",
          "POST",
          "/v1/metrics/query",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/x-www-form-urlencoded",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "queryMetricsRange",
          "GET",
          "/v1/metrics/query_range",
          true,
          List.of("metric", "agg", "start", "end"),
          List.of(),
          Map.ofEntries(
              Map.entry("metric", new Operation.Encoding("form", true)),
              Map.entry("agg", new Operation.Encoding("form", true)),
              Map.entry("match[]", new Operation.Encoding("form", true)),
              Map.entry("by[]", new Operation.Encoding("form", true)),
              Map.entry("start", new Operation.Encoding("form", true)),
              Map.entry("end", new Operation.Encoding("form", true)),
              Map.entry("step", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "queryMetricsRangePost",
          "POST",
          "/v1/metrics/query_range",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/x-www-form-urlencoded",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "searchLogs",
          "GET",
          "/v1/logs",
          true,
          List.of("from", "to"),
          List.of(),
          Map.ofEntries(
              Map.entry("from", new Operation.Encoding("form", true)),
              Map.entry("to", new Operation.Encoding("form", true)),
              Map.entry("log_group", new Operation.Encoding("form", true)),
              Map.entry("log_stream", new Operation.Encoding("form", true)),
              Map.entry("min_severity", new Operation.Encoding("form", true)),
              Map.entry("region", new Operation.Encoding("form", true)),
              Map.entry("q", new Operation.Encoding("form", true)),
              Map.entry("trace_id", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "searchTraces",
          "GET",
          "/v1/traces",
          true,
          List.of("from", "to"),
          List.of(),
          Map.ofEntries(
              Map.entry("from", new Operation.Encoding("form", true)),
              Map.entry("to", new Operation.Encoding("form", true)),
              Map.entry("service", new Operation.Encoding("form", true)),
              Map.entry("operation", new Operation.Encoding("form", true)),
              Map.entry("status_code", new Operation.Encoding("form", true)),
              Map.entry("min_duration_ms", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "updateLogGroup",
          "PATCH",
          "/v1/log-groups/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_23 =
      new Operation(
          "writeMetrics",
          "POST",
          "/v1/metrics/write",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/x-protobuf",
          "application/json");

  /** Create a log group */
  public Request<LogGroupResponse> createLogGroup(CreateLogGroupRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<LogGroupResponse>() {});
  }

  /** Delete a log group */
  public EmptyRequest deleteLogGroup(String id) {
    return new EmptyRequest(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("id", id)),
            null,
            null));
  }

  /** Delete trace settings */
  public EmptyRequest deleteTraceSettings() {
    return new EmptyRequest(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(),
            null,
            null));
  }

  /** Get a single log record by id */
  public Request<LogResponse> getLog(String log_id) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("log_id", log_id)),
            null,
            null),
        new TypeReference<LogResponse>() {});
  }

  /** Get a log group by id */
  public Request<LogGroupResponse> getLogGroup(String id) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("id", id)),
            null,
            null),
        new TypeReference<LogGroupResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<LogGroup> getLogGroupByReference(String reference, GetLogGroupScope scope) {
    return Request.reference(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("id", reference)),
            null,
            null),
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "log_group",
        "log_groups",
        new TypeReference<LogGroup>() {});
  }

  public Request<LogGroup> getLogGroupByReference(String reference) {
    return getLogGroupByReference(reference, null);
  }

  /** Check retained telemetry presence */
  public Request<GetRetainedTelemetryPresenceResponse> getRetainedTelemetryPresence() {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(),
            null,
            null),
        new TypeReference<GetRetainedTelemetryPresenceResponse>() {});
  }

  /** Get all spans for a trace */
  public Request<TraceResponse> getTrace(String trace_id) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("trace_id", trace_id)),
            null,
            null),
        new TypeReference<TraceResponse>() {});
  }

  /** Get the caller account's trace settings */
  public Request<TraceSettingsResponse> getTraceSettings() {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(),
            null,
            null),
        new TypeReference<TraceSettingsResponse>() {});
  }

  /** Ingest a batch of log records */
  public Request<IngestResult> ingestLogs(IngestRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<IngestResult>() {});
  }

  /** Ingest a batch of trace spans */
  public Request<IngestResult> ingestSpans(IngestSpansRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<IngestResult>() {});
  }

  /** List log groups (or look up one by name) */
  public PagedRequest<LogGroupListResponse, LogGroup> listLogGroups(ListLogGroupsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<LogGroupListResponse>() {},
        new TypeReference<LogGroup>() {},
        "log_groups");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<LogGroupListResponse, LogGroup> listLogGroups() {
    return listLogGroups(null);
  }

  /** List the distinct metric names emitted in a time window */
  public PagedRequest<ListMetricNamesResponse, String> listMetricNames(ListMetricNamesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ListMetricNamesResponse>() {},
        new TypeReference<String>() {},
        "data");
  }

  /** List the distinct metric names emitted in a time window (form body) */
  public Request<ListMetricNamesPostResponse> listMetricNamesPost(ListMetricNamesPostBody body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<ListMetricNamesPostResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<ListMetricNamesPostResponse> listMetricNamesPost() {
    return listMetricNamesPost(null);
  }

  /** List distinct label sets for a metric */
  public Request<Map<String, JsonNode>> listMetricSeries(ListMetricSeriesQuery query) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<Map<String, JsonNode>>() {});
  }

  /** List distinct label sets for a metric (form body) */
  public Request<Map<String, JsonNode>> listMetricSeriesPost(ListMetricSeriesPostBody body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<Map<String, JsonNode>>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<Map<String, JsonNode>> listMetricSeriesPost() {
    return listMetricSeriesPost(null);
  }

  /** Update the caller account's trace settings */
  public Request<TraceSettingsResponse> putTraceSettings(UpdateTraceSettingsRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<TraceSettingsResponse>() {});
  }

  /** Instant structured metric query */
  public Request<Map<String, JsonNode>> queryMetricsInstant(QueryMetricsInstantQuery query) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<Map<String, JsonNode>>() {});
  }

  /** Instant structured metric query (form body) */
  public Request<Map<String, JsonNode>> queryMetricsInstantPost(QueryMetricsInstantPostBody body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<Map<String, JsonNode>>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<Map<String, JsonNode>> queryMetricsInstantPost() {
    return queryMetricsInstantPost(null);
  }

  /** Range structured metric query */
  public Request<Map<String, JsonNode>> queryMetricsRange(QueryMetricsRangeQuery query) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<Map<String, JsonNode>>() {});
  }

  /** Range structured metric query (form body) */
  public Request<Map<String, JsonNode>> queryMetricsRangePost(QueryMetricsRangePostBody body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<Map<String, JsonNode>>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<Map<String, JsonNode>> queryMetricsRangePost() {
    return queryMetricsRangePost(null);
  }

  /** Search log records */
  public Request<LogListResponse> searchLogs(SearchLogsQuery query) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<LogListResponse>() {});
  }

  /** List traces */
  public Request<TraceListResponse> searchTraces(SearchTracesQuery query) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<TraceListResponse>() {});
  }

  /** Update a log group */
  public Request<LogGroupResponse> updateLogGroup(String id, UpdateLogGroupRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("id", id)),
            body,
            null),
        new TypeReference<LogGroupResponse>() {});
  }

  /** Prometheus remote_write ingest */
  public EmptyRequest writeMetrics(BinaryBody body) {
    return new EmptyRequest(
        new Core(
            transport,
            "telemetry",
            "https://telemetry.{region}.basaltic.sh",
            OP_23,
            Map.ofEntries(),
            body,
            null));
  }
}
