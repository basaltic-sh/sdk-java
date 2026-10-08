package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Loadbalancer.AttachListenerCertificateRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.AttachTargetRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.CreateListenerRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.CreateLoadBalancerRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.CreateRuleRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.CreateTargetGroupRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.GetListenerScope;
import sh.basaltic.sdk.models.Loadbalancer.GetLoadBalancerScope;
import sh.basaltic.sdk.models.Loadbalancer.GetRuleScope;
import sh.basaltic.sdk.models.Loadbalancer.GetTargetGroupScope;
import sh.basaltic.sdk.models.Loadbalancer.GetTargetScope;
import sh.basaltic.sdk.models.Loadbalancer.ListListenersQuery;
import sh.basaltic.sdk.models.Loadbalancer.ListLoadBalancerReplicasQuery;
import sh.basaltic.sdk.models.Loadbalancer.ListLoadBalancersQuery;
import sh.basaltic.sdk.models.Loadbalancer.ListRulesQuery;
import sh.basaltic.sdk.models.Loadbalancer.ListTargetGroupsQuery;
import sh.basaltic.sdk.models.Loadbalancer.ListTargetsQuery;
import sh.basaltic.sdk.models.Loadbalancer.Listener;
import sh.basaltic.sdk.models.Loadbalancer.ListenerListResponse;
import sh.basaltic.sdk.models.Loadbalancer.ListenerResponse;
import sh.basaltic.sdk.models.Loadbalancer.LoadBalancer;
import sh.basaltic.sdk.models.Loadbalancer.LoadBalancerListResponse;
import sh.basaltic.sdk.models.Loadbalancer.LoadBalancerReplica;
import sh.basaltic.sdk.models.Loadbalancer.LoadBalancerReplicasResponse;
import sh.basaltic.sdk.models.Loadbalancer.LoadBalancerResponse;
import sh.basaltic.sdk.models.Loadbalancer.Rule;
import sh.basaltic.sdk.models.Loadbalancer.RuleListResponse;
import sh.basaltic.sdk.models.Loadbalancer.RuleResponse;
import sh.basaltic.sdk.models.Loadbalancer.Target;
import sh.basaltic.sdk.models.Loadbalancer.TargetGroup;
import sh.basaltic.sdk.models.Loadbalancer.TargetGroupListResponse;
import sh.basaltic.sdk.models.Loadbalancer.TargetGroupResponse;
import sh.basaltic.sdk.models.Loadbalancer.TargetListResponse;
import sh.basaltic.sdk.models.Loadbalancer.TargetResponse;
import sh.basaltic.sdk.models.Loadbalancer.UpdateListenerRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.UpdateLoadBalancerRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.UpdateRuleRequestInput;
import sh.basaltic.sdk.models.Loadbalancer.UpdateTargetGroupRequestInput;

/** Typed loadbalancer API methods. */
public final class LoadbalancerService {
  private final Transport transport;

  LoadbalancerService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "attachListenerCertificate",
          "POST",
          "/v1/load-balancers/{id}/listeners/{listener_id}/certificates",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "attachTarget",
          "POST",
          "/v1/target-groups/{id}/targets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "createListener",
          "POST",
          "/v1/load-balancers/{id}/listeners",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "createLoadBalancer",
          "POST",
          "/v1/load-balancers",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "createRule",
          "POST",
          "/v1/load-balancers/{id}/listeners/{listener_id}/rules",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "createTargetGroup",
          "POST",
          "/v1/target-groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "deleteListener",
          "DELETE",
          "/v1/load-balancers/{id}/listeners/{listener_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "deleteLoadBalancer",
          "DELETE",
          "/v1/load-balancers/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "deleteRuleInListener",
          "DELETE",
          "/v1/load-balancers/{id}/listeners/{listener_id}/rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "deleteTargetGroup",
          "DELETE",
          "/v1/target-groups/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "detachListenerCertificate",
          "DELETE",
          "/v1/load-balancers/{id}/listeners/{listener_id}/certificates/{certificate_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "detachTarget",
          "DELETE",
          "/v1/target-groups/{id}/targets/{target_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "getListener",
          "GET",
          "/v1/load-balancers/{id}/listeners/{listener_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "getLoadBalancer",
          "GET",
          "/v1/load-balancers/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "getRule",
          "GET",
          "/v1/load-balancers/{id}/listeners/{listener_id}/rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "getTarget",
          "GET",
          "/v1/target-groups/{id}/targets/{target_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "getTargetGroup",
          "GET",
          "/v1/target-groups/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "listListeners",
          "GET",
          "/v1/load-balancers/{id}/listeners",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "listLoadBalancerReplicas",
          "GET",
          "/v1/load-balancers/{id}/replicas",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "listLoadBalancers",
          "GET",
          "/v1/load-balancers",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "listRules",
          "GET",
          "/v1/load-balancers/{id}/listeners/{listener_id}/rules",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "listTargetGroups",
          "GET",
          "/v1/target-groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("protocol", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "listTargets",
          "GET",
          "/v1/target-groups/{id}/targets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_23 =
      new Operation(
          "updateListener",
          "PATCH",
          "/v1/load-balancers/{id}/listeners/{listener_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_24 =
      new Operation(
          "updateLoadBalancer",
          "PATCH",
          "/v1/load-balancers/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_25 =
      new Operation(
          "updateRule",
          "PATCH",
          "/v1/load-balancers/{id}/listeners/{listener_id}/rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_26 =
      new Operation(
          "updateTargetGroup",
          "PATCH",
          "/v1/target-groups/{id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Attach an additional certificate to an HTTPS listener */
  public Request<ListenerResponse> attachListenerCertificate(
      String id, String listener_id, AttachListenerCertificateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", listener_id)),
            body,
            null),
        new TypeReference<ListenerResponse>() {});
  }

  /** Attach a target to this group */
  public Request<TargetResponse> attachTarget(String id, AttachTargetRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("id", id)),
            body,
            null),
        new TypeReference<TargetResponse>() {});
  }

  /** Create a listener on this load balancer */
  public Request<ListenerResponse> createListener(String id, CreateListenerRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("id", id)),
            body,
            null),
        new TypeReference<ListenerResponse>() {});
  }

  /** Create a load balancer */
  public Request<LoadBalancerResponse> createLoadBalancer(CreateLoadBalancerRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<LoadBalancerResponse>() {});
  }

  /** Create a routing rule on this listener (HTTP/HTTPS only) */
  public Request<RuleResponse> createRule(
      String id, String listener_id, CreateRuleRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", listener_id)),
            body,
            null),
        new TypeReference<RuleResponse>() {});
  }

  /** Create a target group */
  public Request<TargetGroupResponse> createTargetGroup(CreateTargetGroupRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<TargetGroupResponse>() {});
  }

  /** Delete a listener */
  public EmptyRequest deleteListener(String id, String listener_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", listener_id)),
            null,
            null));
  }

  /** Delete a load balancer */
  public EmptyRequest deleteLoadBalancer(String id) {
    return new EmptyRequest(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("id", id)),
            null,
            null));
  }

  /** Delete a routing rule */
  public EmptyRequest deleteRuleInListener(String id, String listener_id, String rule_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(
                Map.entry("id", id),
                Map.entry("listener_id", listener_id),
                Map.entry("rule_id", rule_id)),
            null,
            null));
  }

  /** Delete a target group */
  public EmptyRequest deleteTargetGroup(String id) {
    return new EmptyRequest(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("id", id)),
            null,
            null));
  }

  /** Detach a certificate from an HTTPS listener */
  public EmptyRequest detachListenerCertificate(
      String id, String listener_id, String certificate_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(
                Map.entry("id", id),
                Map.entry("listener_id", listener_id),
                Map.entry("certificate_id", certificate_id)),
            null,
            null));
  }

  /** Detach a target */
  public EmptyRequest detachTarget(String id, String target_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("id", id), Map.entry("target_id", target_id)),
            null,
            null));
  }

  /** Get a listener */
  public Request<ListenerResponse> getListener(String id, String listener_id) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", listener_id)),
            null,
            null),
        new TypeReference<ListenerResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Listener> getListenerByReference(
      String id, String reference, GetListenerScope scope) {
    return Request.reference(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", reference)),
            null,
            null),
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("id", id)),
            null,
            scope),
        reference,
        true,
        "listener",
        "listeners",
        new TypeReference<Listener>() {});
  }

  public Request<Listener> getListenerByReference(String id, String reference) {
    return getListenerByReference(id, reference, null);
  }

  /** Get a load balancer */
  public Request<LoadBalancerResponse> getLoadBalancer(String id) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("id", id)),
            null,
            null),
        new TypeReference<LoadBalancerResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<LoadBalancer> getLoadBalancerByReference(
      String reference, GetLoadBalancerScope scope) {
    return Request.reference(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("id", reference)),
            null,
            null),
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "load_balancer",
        "load_balancers",
        new TypeReference<LoadBalancer>() {});
  }

  public Request<LoadBalancer> getLoadBalancerByReference(String reference) {
    return getLoadBalancerByReference(reference, null);
  }

  /** Get a routing rule */
  public Request<RuleResponse> getRule(String id, String listener_id, String rule_id) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(
                Map.entry("id", id),
                Map.entry("listener_id", listener_id),
                Map.entry("rule_id", rule_id)),
            null,
            null),
        new TypeReference<RuleResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Rule> getRuleByReference(
      String id, String listener_id, String reference, GetRuleScope scope) {
    return Request.reference(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(
                Map.entry("id", id),
                Map.entry("listener_id", listener_id),
                Map.entry("rule_id", reference)),
            null,
            null),
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", listener_id)),
            null,
            scope),
        reference,
        true,
        "rule",
        "rules",
        new TypeReference<Rule>() {});
  }

  public Request<Rule> getRuleByReference(String id, String listener_id, String reference) {
    return getRuleByReference(id, listener_id, reference, null);
  }

  /** Get a target */
  public Request<TargetResponse> getTarget(String id, String target_id) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("id", id), Map.entry("target_id", target_id)),
            null,
            null),
        new TypeReference<TargetResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Target> getTargetByReference(String id, String reference, GetTargetScope scope) {
    return Request.reference(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("id", id), Map.entry("target_id", reference)),
            null,
            null),
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("id", id)),
            null,
            scope),
        reference,
        true,
        "target",
        "targets",
        new TypeReference<Target>() {});
  }

  public Request<Target> getTargetByReference(String id, String reference) {
    return getTargetByReference(id, reference, null);
  }

  /** Get a target group */
  public Request<TargetGroupResponse> getTargetGroup(String id) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("id", id)),
            null,
            null),
        new TypeReference<TargetGroupResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<TargetGroup> getTargetGroupByReference(
      String reference, GetTargetGroupScope scope) {
    return Request.reference(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("id", reference)),
            null,
            null),
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "target_group",
        "target_groups",
        new TypeReference<TargetGroup>() {});
  }

  public Request<TargetGroup> getTargetGroupByReference(String reference) {
    return getTargetGroupByReference(reference, null);
  }

  /** List this load balancer's listeners */
  public PagedRequest<ListenerListResponse, Listener> listListeners(
      String id, ListListenersQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("id", id)),
            null,
            query),
        new TypeReference<ListenerListResponse>() {},
        new TypeReference<Listener>() {},
        "listeners");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListenerListResponse, Listener> listListeners(String id) {
    return listListeners(id, null);
  }

  /** List the LB's instance replicas with live health */
  public PagedRequest<LoadBalancerReplicasResponse, LoadBalancerReplica> listLoadBalancerReplicas(
      String id, ListLoadBalancerReplicasQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("id", id)),
            null,
            query),
        new TypeReference<LoadBalancerReplicasResponse>() {},
        new TypeReference<LoadBalancerReplica>() {},
        "replicas");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<LoadBalancerReplicasResponse, LoadBalancerReplica> listLoadBalancerReplicas(
      String id) {
    return listLoadBalancerReplicas(id, null);
  }

  /** List load balancers */
  public PagedRequest<LoadBalancerListResponse, LoadBalancer> listLoadBalancers(
      ListLoadBalancersQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<LoadBalancerListResponse>() {},
        new TypeReference<LoadBalancer>() {},
        "load_balancers");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<LoadBalancerListResponse, LoadBalancer> listLoadBalancers() {
    return listLoadBalancers(null);
  }

  /** List this listener's rules */
  public PagedRequest<RuleListResponse, Rule> listRules(
      String id, String listener_id, ListRulesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", listener_id)),
            null,
            query),
        new TypeReference<RuleListResponse>() {},
        new TypeReference<Rule>() {},
        "rules");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RuleListResponse, Rule> listRules(String id, String listener_id) {
    return listRules(id, listener_id, null);
  }

  /** List target groups */
  public PagedRequest<TargetGroupListResponse, TargetGroup> listTargetGroups(
      ListTargetGroupsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<TargetGroupListResponse>() {},
        new TypeReference<TargetGroup>() {},
        "target_groups");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<TargetGroupListResponse, TargetGroup> listTargetGroups() {
    return listTargetGroups(null);
  }

  /** List targets in this group */
  public PagedRequest<TargetListResponse, Target> listTargets(String id, ListTargetsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("id", id)),
            null,
            query),
        new TypeReference<TargetListResponse>() {},
        new TypeReference<Target>() {},
        "targets");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<TargetListResponse, Target> listTargets(String id) {
    return listTargets(id, null);
  }

  /** Patch a listener (rotate cert, change default target group) */
  public Request<ListenerResponse> updateListener(
      String id, String listener_id, UpdateListenerRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("id", id), Map.entry("listener_id", listener_id)),
            body,
            null),
        new TypeReference<ListenerResponse>() {});
  }

  /** Scale or resize a load balancer */
  public Request<LoadBalancerResponse> updateLoadBalancer(
      String id, UpdateLoadBalancerRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_24,
            Map.ofEntries(Map.entry("id", id)),
            body,
            null),
        new TypeReference<LoadBalancerResponse>() {});
  }

  /** Update a routing rule (full replace) */
  public Request<RuleResponse> updateRule(
      String id, String listener_id, String rule_id, UpdateRuleRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_25,
            Map.ofEntries(
                Map.entry("id", id),
                Map.entry("listener_id", listener_id),
                Map.entry("rule_id", rule_id)),
            body,
            null),
        new TypeReference<RuleResponse>() {});
  }

  /** Update target group health checks, framing, or stickiness */
  public Request<TargetGroupResponse> updateTargetGroup(
      String id, UpdateTargetGroupRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "loadbalancer",
            "https://loadbalancer.{region}.basaltic.sh",
            OP_26,
            Map.ofEntries(Map.entry("id", id)),
            body,
            null),
        new TypeReference<TargetGroupResponse>() {});
  }
}
