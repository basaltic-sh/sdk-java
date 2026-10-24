package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

/** Typed loadbalancer wire models. Unknown string enum values are retained. */
public final class Loadbalancer {

  private Loadbalancer() {}

  public static final class AttachListenerCertificateRequestInput extends Model {
    public AttachListenerCertificateRequestInput() {}

    /**
     * The certificate to serve, by CRN, UUID or exact account-scoped name. Certificate CRNs require
     * an empty region. The listener stores a reference — no key material is sent here, and the
     * replicas fetch it from the certificate service under their own identity.
     */
    @JsonProperty(value = "certificate", required = true)
    private String certificate;

    @JsonProperty("certificate")
    public String getCertificate() {
      return certificate;
    }

    public AttachListenerCertificateRequestInput withCertificate(String value) {
      this.certificate = value;
      return this;
    }

    /**
     * When true, demote whatever's currently default and promote this cert in the same transaction.
     */
    @JsonProperty(value = "is_default", required = false)
    private Boolean is_default;

    @JsonProperty("is_default")
    public Boolean getIsDefault() {
      return is_default;
    }

    public AttachListenerCertificateRequestInput withIsDefault(Boolean value) {
      this.is_default = value;
      return this;
    }
  }

  public static final class ListenerCertificateResponse extends Model {
    public ListenerCertificateResponse() {}

    @JsonProperty(value = "certificate", required = true)
    private ResourceRef certificate;

    @JsonProperty("certificate")
    public ResourceRef getCertificate() {
      return certificate;
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

  public static final class AttachTargetRequestInput extends Model {
    public AttachTargetRequestInput() {}

    /**
     * Must match the group's target_type: an IP address for `ip`, a compute instance UUID, CRN or
     * exact account-scoped name for `instance`. An `ip` ref has to be a routable unicast address —
     * loopback, link-local (including the 169.254.169.254 metadata endpoint), multicast, and
     * unspecified addresses are rejected.
     */
    @JsonProperty(value = "target", required = true)
    private String target;

    @JsonProperty("target")
    public String getTarget() {
      return target;
    }

    public AttachTargetRequestInput withTarget(String value) {
      this.target = value;
      return this;
    }

    /**
     * Per-target backend port override. When omitted, the target inherits the target group port.
     * Pool-derived targets always inherit the group port.
     */
    @JsonProperty(value = "port", required = false)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    public AttachTargetRequestInput withPort(Long value) {
      this.port = value;
      return this;
    }
  }

  public static final class TargetResponse extends Model {
    public TargetResponse() {}

    @JsonProperty(value = "target", required = true)
    private Target target;

    @JsonProperty("target")
    public Target getTarget() {
      return target;
    }
  }

  public static final class Target {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Target(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "Target{[REDACTED]}";
    }

    public static Target ofVariant1(TargetVariant1 value) {
      Model.validate(value);
      return new Target(Json.tree(value));
    }

    public Optional<TargetVariant1> asVariant1() {
      try {
        TargetVariant1 result = Json.convert(value, new TypeReference<TargetVariant1>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static Target ofVariant2(TargetVariant2 value) {
      Model.validate(value);
      return new Target(Json.tree(value));
    }

    public Optional<TargetVariant2> asVariant2() {
      try {
        TargetVariant2 result = Json.convert(value, new TypeReference<TargetVariant2>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }
  }

  public static final class TargetVariant1 extends Model {
    public TargetVariant1() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * Compute instance backing an instance target or a pool-derived target. Omitted for IP targets.
     */
    @JsonProperty(value = "instance", required = true)
    private ResourceRef instance;

    @JsonProperty("instance")
    public ResourceRef getInstance() {
      return instance;
    }

    /** Canonical IPv4 or IPv6 address for an IP target. Omitted for instance targets. */
    @JsonProperty(value = "address", required = false)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    /**
     * Per-target backend port override. When omitted, the target inherits the target group port.
     * Pool-derived targets always inherit the group port.
     */
    @JsonProperty(value = "port", required = false)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    @JsonProperty(value = "health", required = true)
    private TargetVariant1Health health;

    @JsonProperty("health")
    public TargetVariant1Health getHealth() {
      return health;
    }

    @JsonProperty(value = "last_seen_at", required = false)
    private String last_seen_at;

    @JsonProperty("last_seen_at")
    public String getLastSeenAt() {
      return last_seen_at;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class TargetVariant1Health {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TargetVariant1Health(String value) {
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
      return other instanceof TargetVariant1Health v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TargetVariant1Health INITIAL = new TargetVariant1Health("initial");
    public static final TargetVariant1Health HEALTHY = new TargetVariant1Health("healthy");
    public static final TargetVariant1Health UNHEALTHY = new TargetVariant1Health("unhealthy");
    public static final TargetVariant1Health DRAINING = new TargetVariant1Health("draining");
  }

  public static final class TargetVariant2 extends Model {
    public TargetVariant2() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * Compute instance backing an instance target or a pool-derived target. Omitted for IP targets.
     */
    @JsonProperty(value = "instance", required = false)
    private ResourceRef instance;

    @JsonProperty("instance")
    public ResourceRef getInstance() {
      return instance;
    }

    /** Canonical IPv4 or IPv6 address for an IP target. Omitted for instance targets. */
    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    /**
     * Per-target backend port override. When omitted, the target inherits the target group port.
     * Pool-derived targets always inherit the group port.
     */
    @JsonProperty(value = "port", required = false)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    @JsonProperty(value = "health", required = true)
    private TargetVariant2Health health;

    @JsonProperty("health")
    public TargetVariant2Health getHealth() {
      return health;
    }

    @JsonProperty(value = "last_seen_at", required = false)
    private String last_seen_at;

    @JsonProperty("last_seen_at")
    public String getLastSeenAt() {
      return last_seen_at;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class TargetVariant2Health {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TargetVariant2Health(String value) {
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
      return other instanceof TargetVariant2Health v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TargetVariant2Health INITIAL = new TargetVariant2Health("initial");
    public static final TargetVariant2Health HEALTHY = new TargetVariant2Health("healthy");
    public static final TargetVariant2Health UNHEALTHY = new TargetVariant2Health("unhealthy");
    public static final TargetVariant2Health DRAINING = new TargetVariant2Health("draining");
  }

  public static final class CreateListenerRequestInput extends Model {
    public CreateListenerRequestInput() {}

    @JsonProperty(value = "protocol", required = true)
    private CreateListenerRequestInputProtocol protocol;

    @JsonProperty("protocol")
    public CreateListenerRequestInputProtocol getProtocol() {
      return protocol;
    }

    public CreateListenerRequestInput withProtocol(CreateListenerRequestInputProtocol value) {
      this.protocol = value;
      return this;
    }

    @JsonProperty(value = "port", required = true)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    public CreateListenerRequestInput withPort(Long value) {
      this.port = value;
      return this;
    }

    @JsonProperty(value = "certificates", required = false)
    private List<String> certificates;

    @JsonProperty("certificates")
    public List<String> getCertificates() {
      return certificates;
    }

    public CreateListenerRequestInput withCertificates(List<String> value) {
      this.certificates = value;
      return this;
    }

    @JsonProperty(value = "default_target_group", required = false)
    private String default_target_group;

    @JsonProperty("default_target_group")
    public String getDefaultTargetGroup() {
      return default_target_group;
    }

    public CreateListenerRequestInput withDefaultTargetGroup(String value) {
      this.default_target_group = value;
      return this;
    }

    /**
     * Which LB addresses are bound. Defaults to 'both'; pick private_only when the LB has no FIP
     * yet.
     */
    @JsonProperty(value = "exposure", required = false)
    private CreateListenerRequestInputExposure exposure;

    @JsonProperty("exposure")
    public CreateListenerRequestInputExposure getExposure() {
      return exposure;
    }

    public CreateListenerRequestInput withExposure(CreateListenerRequestInputExposure value) {
      this.exposure = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateListenerRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class CreateListenerRequestInputProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateListenerRequestInputProtocol(String value) {
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
      return other instanceof CreateListenerRequestInputProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateListenerRequestInputProtocol HTTP =
        new CreateListenerRequestInputProtocol("http");
    public static final CreateListenerRequestInputProtocol HTTPS =
        new CreateListenerRequestInputProtocol("https");
    public static final CreateListenerRequestInputProtocol TCP =
        new CreateListenerRequestInputProtocol("tcp");
    public static final CreateListenerRequestInputProtocol UDP =
        new CreateListenerRequestInputProtocol("udp");
  }

  public static final class CreateListenerRequestInputExposure {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateListenerRequestInputExposure(String value) {
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
      return other instanceof CreateListenerRequestInputExposure v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateListenerRequestInputExposure PUBLIC_ONLY =
        new CreateListenerRequestInputExposure("public_only");
    public static final CreateListenerRequestInputExposure PRIVATE_ONLY =
        new CreateListenerRequestInputExposure("private_only");
    public static final CreateListenerRequestInputExposure BOTH =
        new CreateListenerRequestInputExposure("both");
  }

  public static final class ListenerResponse extends Model {
    public ListenerResponse() {}

    @JsonProperty(value = "listener", required = true)
    private Listener listener;

    @JsonProperty("listener")
    public Listener getListener() {
      return listener;
    }
  }

  public static final class Listener extends Model {
    public Listener() {}

    /** Parent-scoped CRN with immutable load balancer name and child UUID components. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "protocol", required = true)
    private ListenerProtocol protocol;

    @JsonProperty("protocol")
    public ListenerProtocol getProtocol() {
      return protocol;
    }

    @JsonProperty(value = "port", required = true)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    /**
     * Which LB addresses this listener binds. 'public_only' and 'both' require the LB to carry a
     * floating IP; if the FIP is detached later, the listener is dropped until a FIP is re-attached
     * or exposure is flipped to private_only.
     */
    @JsonProperty(value = "exposure", required = true)
    private ListenerExposure exposure;

    @JsonProperty("exposure")
    public ListenerExposure getExposure() {
      return exposure;
    }

    @JsonProperty(value = "tags", required = true)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }

    /**
     * Default certificate for an HTTPS listener, used when no SNI matches or the client sends none.
     * Null when absent. List all attached certificates through the listener certificates endpoint.
     */
    @JsonProperty(value = "default_certificate", required = true)
    private ListenerDefaultCertificate default_certificate;

    @JsonProperty("default_certificate")
    public ListenerDefaultCertificate getDefaultCertificate() {
      return default_certificate;
    }

    /** Target group used when no routing rule matches, or null when none is configured. */
    @JsonProperty(value = "default_target_group", required = true)
    private ListenerDefaultTargetGroup default_target_group;

    @JsonProperty("default_target_group")
    public ListenerDefaultTargetGroup getDefaultTargetGroup() {
      return default_target_group;
    }
  }

  public static final class ListenerProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListenerProtocol(String value) {
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
      return other instanceof ListenerProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListenerProtocol HTTP = new ListenerProtocol("http");
    public static final ListenerProtocol HTTPS = new ListenerProtocol("https");
    public static final ListenerProtocol TCP = new ListenerProtocol("tcp");
    public static final ListenerProtocol UDP = new ListenerProtocol("udp");
  }

  public static final class ListenerExposure {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListenerExposure(String value) {
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
      return other instanceof ListenerExposure v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListenerExposure PUBLIC_ONLY = new ListenerExposure("public_only");
    public static final ListenerExposure PRIVATE_ONLY = new ListenerExposure("private_only");
    public static final ListenerExposure BOTH = new ListenerExposure("both");
  }

  public static final class ListenerDefaultCertificate {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListenerDefaultCertificate(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "ListenerDefaultCertificate{[REDACTED]}";
    }

    public static ListenerDefaultCertificate ofVariant1(ResourceRef value) {
      Model.validate(value);
      return new ListenerDefaultCertificate(Json.tree(value));
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

    public static ListenerDefaultCertificate ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new ListenerDefaultCertificate(Json.tree(value));
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

  public static final class ListenerDefaultTargetGroup {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListenerDefaultTargetGroup(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "ListenerDefaultTargetGroup{[REDACTED]}";
    }

    public static ListenerDefaultTargetGroup ofVariant1(ResourceRef value) {
      Model.validate(value);
      return new ListenerDefaultTargetGroup(Json.tree(value));
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

    public static ListenerDefaultTargetGroup ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new ListenerDefaultTargetGroup(Json.tree(value));
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

  public static final class CreateLoadBalancerRequestInput extends Model {
    public CreateLoadBalancerRequestInput() {}

    /** Steady target within min_count and max_count. */
    @JsonProperty(value = "desired_count", required = false)
    private Long desired_count;

    @JsonProperty("desired_count")
    public Long getDesiredCount() {
      return desired_count;
    }

    public CreateLoadBalancerRequestInput withDesiredCount(Long value) {
      this.desired_count = value;
      return this;
    }

    /** Lower capacity bound. */
    @JsonProperty(value = "min_count", required = false)
    private Long min_count;

    @JsonProperty("min_count")
    public Long getMinCount() {
      return min_count;
    }

    public CreateLoadBalancerRequestInput withMinCount(Long value) {
      this.min_count = value;
      return this;
    }

    /** Upper capacity bound including rollout surge. */
    @JsonProperty(value = "max_count", required = false)
    private Long max_count;

    @JsonProperty("max_count")
    public Long getMaxCount() {
      return max_count;
    }

    public CreateLoadBalancerRequestInput withMaxCount(Long value) {
      this.max_count = value;
      return this;
    }

    @JsonProperty(value = "autoscaling", required = false)
    private AutoscalingPolicyInput autoscaling;

    @JsonProperty("autoscaling")
    public AutoscalingPolicyInput getAutoscaling() {
      return autoscaling;
    }

    public CreateLoadBalancerRequestInput withAutoscaling(AutoscalingPolicyInput value) {
      this.autoscaling = value;
      return this;
    }

    /**
     * 1..127 chars of [A-Za-z0-9._-] Resource names must not start with the literal crn: prefix or
     * be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateLoadBalancerRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "type", required = true)
    private CreateLoadBalancerRequestInputType type;

    @JsonProperty("type")
    public CreateLoadBalancerRequestInputType getType() {
      return type;
    }

    public CreateLoadBalancerRequestInput withType(CreateLoadBalancerRequestInputType value) {
      this.type = value;
      return this;
    }

    /** VPC the LB will live in. Every selected subnet must belong to this VPC. */
    @JsonProperty(value = "vpc", required = true)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public CreateLoadBalancerRequestInput withVpc(String value) {
      this.vpc = value;
      return this;
    }

    /**
     * One or more subnet selectors in the same VPC, account and region. Each instance has one
     * interface; new instances are placed in the least-populated eligible subnet. The first subnet
     * supplies automatic private floating IP allocations. Placement is fixed at creation.
     */
    @JsonProperty(value = "subnets", required = true)
    private List<String> subnets;

    @JsonProperty("subnets")
    public List<String> getSubnets() {
      return subnets;
    }

    public CreateLoadBalancerRequestInput withSubnets(List<String> value) {
      this.subnets = value;
      return this;
    }

    /** Compute flavor for each LB instance. */
    @JsonProperty(value = "flavor", required = true)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public CreateLoadBalancerRequestInput withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    /**
     * Deprecated input alias of desired_count; send only one. Desired defaults to 1. Omitted bounds
     * default to desired.
     */
    @JsonProperty(value = "replica_count", required = false)
    private Long replica_count;

    @JsonProperty("replica_count")
    public Long getReplicaCount() {
      return replica_count;
    }

    public CreateLoadBalancerRequestInput withReplicaCount(Long value) {
      this.replica_count = value;
      return this;
    }

    /**
     * Existing free floating IPs from this account and region, at most one per family and
     * visibility (private/public, IPv4/IPv6). Private addresses must belong to any selected subnet.
     * Missing private families are allocated automatically from the first selected subnet for each
     * family enabled there. Public addresses are optional and require a matching-family default
     * route to an internet gateway in every selected subnet; NAT and egress-only gateways do not
     * qualify. Public IPv6 requires every selected subnet to support IPv6. Pool-owned or attached
     * addresses are unavailable. On deletion, supplied addresses are detached and retained;
     * automatic private allocations are released.
     */
    @JsonProperty(value = "floating_ips", required = false)
    private List<String> floating_ips;

    @JsonProperty("floating_ips")
    public List<String> getFloatingIps() {
      return floating_ips;
    }

    public CreateLoadBalancerRequestInput withFloatingIps(List<String> value) {
      this.floating_ips = value;
      return this;
    }

    /**
     * Security groups attached to every replica NIC (AWS ALB shape). A VPC NIC with no security
     * group denies all data traffic, so the listener port(s) must be opened by a security group
     * listed here. Re-applied to replacement replicas. The LB's own control-plane path (agent
     * config + heartbeat via the metadata endpoint) is always-allowed and needs none.
     */
    @JsonProperty(value = "security_groups", required = true)
    private List<String> security_groups;

    @JsonProperty("security_groups")
    public List<String> getSecurityGroups() {
      return security_groups;
    }

    public CreateLoadBalancerRequestInput withSecurityGroups(List<String> value) {
      this.security_groups = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateLoadBalancerRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class AutoscalingPolicyInput extends Model {
    public AutoscalingPolicyInput() {}

    @JsonProperty(value = "enabled", required = true)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public AutoscalingPolicyInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    @JsonProperty(value = "metrics", required = true)
    private List<ScalingMetricInput> metrics;

    @JsonProperty("metrics")
    public List<ScalingMetricInput> getMetrics() {
      return metrics;
    }

    public AutoscalingPolicyInput withMetrics(List<ScalingMetricInput> value) {
      this.metrics = value;
      return this;
    }

    @JsonProperty(value = "warmup_seconds", required = false)
    private Long warmup_seconds;

    @JsonProperty("warmup_seconds")
    public Long getWarmupSeconds() {
      return warmup_seconds;
    }

    public AutoscalingPolicyInput withWarmupSeconds(Long value) {
      this.warmup_seconds = value;
      return this;
    }

    @JsonProperty(value = "cooldown_seconds", required = false)
    private Long cooldown_seconds;

    @JsonProperty("cooldown_seconds")
    public Long getCooldownSeconds() {
      return cooldown_seconds;
    }

    public AutoscalingPolicyInput withCooldownSeconds(Long value) {
      this.cooldown_seconds = value;
      return this;
    }

    @JsonProperty(value = "scale_down_stabilization_seconds", required = false)
    private Long scale_down_stabilization_seconds;

    @JsonProperty("scale_down_stabilization_seconds")
    public Long getScaleDownStabilizationSeconds() {
      return scale_down_stabilization_seconds;
    }

    public AutoscalingPolicyInput withScaleDownStabilizationSeconds(Long value) {
      this.scale_down_stabilization_seconds = value;
      return this;
    }

    @JsonProperty(value = "max_scale_out_step", required = false)
    private Long max_scale_out_step;

    @JsonProperty("max_scale_out_step")
    public Long getMaxScaleOutStep() {
      return max_scale_out_step;
    }

    public AutoscalingPolicyInput withMaxScaleOutStep(Long value) {
      this.max_scale_out_step = value;
      return this;
    }

    @JsonProperty(value = "max_scale_in_step", required = false)
    private Long max_scale_in_step;

    @JsonProperty("max_scale_in_step")
    public Long getMaxScaleInStep() {
      return max_scale_in_step;
    }

    public AutoscalingPolicyInput withMaxScaleInStep(Long value) {
      this.max_scale_in_step = value;
      return this;
    }

    /**
     * Grace period after route withdrawal and proxy acknowledgements, before deleting a retiring
     * member. Long-lived TCP/UDP sessions may end at the deadline; arbitrary application shutdown
     * hooks are not supported.
     */
    @JsonProperty(value = "drain_seconds", required = false)
    private Long drain_seconds;

    @JsonProperty("drain_seconds")
    public Long getDrainSeconds() {
      return drain_seconds;
    }

    public AutoscalingPolicyInput withDrainSeconds(Long value) {
      this.drain_seconds = value;
      return this;
    }
  }

  public static final class ScalingMetricInput extends Model {
    public ScalingMetricInput() {}

    @JsonProperty(value = "source", required = true)
    private ScalingMetricInputSource source;

    @JsonProperty("source")
    public ScalingMetricInputSource getSource() {
      return source;
    }

    public ScalingMetricInput withSource(ScalingMetricInputSource value) {
      this.source = value;
      return this;
    }

    @JsonProperty(value = "target_type", required = true)
    private ScalingMetricInputTargetType target_type;

    @JsonProperty("target_type")
    public ScalingMetricInputTargetType getTargetType() {
      return target_type;
    }

    public ScalingMetricInput withTargetType(ScalingMetricInputTargetType value) {
      this.target_type = value;
      return this;
    }

    @JsonProperty(value = "target_value", required = true)
    private BigDecimal target_value;

    @JsonProperty("target_value")
    public BigDecimal getTargetValue() {
      return target_value;
    }

    public ScalingMetricInput withTargetValue(BigDecimal value) {
      this.target_value = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ScalingMetricInput withName(String value) {
      this.name = value;
      return this;
    }

    /** Exact-match labels; tenancy labels and __name__ cannot be supplied. */
    @JsonProperty(value = "labels", required = false)
    private Map<String, String> labels;

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
      return labels;
    }

    public ScalingMetricInput withLabels(Map<String, String> value) {
      this.labels = value;
      return this;
    }

    /**
     * Use last for queue gauges; rate for monotonically increasing counters, with reset handling.
     */
    @JsonProperty(value = "sample_aggregation", required = false)
    private ScalingMetricInputSampleAggregation sample_aggregation;

    @JsonProperty("sample_aggregation")
    public ScalingMetricInputSampleAggregation getSampleAggregation() {
      return sample_aggregation;
    }

    public ScalingMetricInput withSampleAggregation(ScalingMetricInputSampleAggregation value) {
      this.sample_aggregation = value;
      return this;
    }

    @JsonProperty(value = "series_aggregation", required = false)
    private ScalingMetricInputSeriesAggregation series_aggregation;

    @JsonProperty("series_aggregation")
    public ScalingMetricInputSeriesAggregation getSeriesAggregation() {
      return series_aggregation;
    }

    public ScalingMetricInput withSeriesAggregation(ScalingMetricInputSeriesAggregation value) {
      this.series_aggregation = value;
      return this;
    }

    /** Exact expected cardinality; incomplete or ambiguous selectors are unavailable. */
    @JsonProperty(value = "expected_series", required = false)
    private Long expected_series;

    @JsonProperty("expected_series")
    public Long getExpectedSeries() {
      return expected_series;
    }

    public ScalingMetricInput withExpectedSeries(Long value) {
      this.expected_series = value;
      return this;
    }

    @JsonProperty(value = "window_seconds", required = false)
    private Long window_seconds;

    @JsonProperty("window_seconds")
    public Long getWindowSeconds() {
      return window_seconds;
    }

    public ScalingMetricInput withWindowSeconds(Long value) {
      this.window_seconds = value;
      return this;
    }

    /**
     * Actual newest observation age per series; must not exceed window_seconds. Defaults to the
     * smaller of 90 and the window.
     */
    @JsonProperty(value = "max_age_seconds", required = false)
    private Long max_age_seconds;

    @JsonProperty("max_age_seconds")
    public Long getMaxAgeSeconds() {
      return max_age_seconds;
    }

    public ScalingMetricInput withMaxAgeSeconds(Long value) {
      this.max_age_seconds = value;
      return this;
    }
  }

  public static final class ScalingMetricInputSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricInputSource(String value) {
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
      return other instanceof ScalingMetricInputSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricInputSource CPU = new ScalingMetricInputSource("cpu");
    public static final ScalingMetricInputSource TELEMETRY =
        new ScalingMetricInputSource("telemetry");
  }

  public static final class ScalingMetricInputTargetType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricInputTargetType(String value) {
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
      return other instanceof ScalingMetricInputTargetType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricInputTargetType UTILIZATION =
        new ScalingMetricInputTargetType("utilization");
    public static final ScalingMetricInputTargetType AVERAGE_VALUE =
        new ScalingMetricInputTargetType("average_value");
  }

  public static final class ScalingMetricInputSampleAggregation {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricInputSampleAggregation(String value) {
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
      return other instanceof ScalingMetricInputSampleAggregation v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricInputSampleAggregation LAST =
        new ScalingMetricInputSampleAggregation("last");
    public static final ScalingMetricInputSampleAggregation AVG =
        new ScalingMetricInputSampleAggregation("avg");
    public static final ScalingMetricInputSampleAggregation MAX =
        new ScalingMetricInputSampleAggregation("max");
    public static final ScalingMetricInputSampleAggregation RATE =
        new ScalingMetricInputSampleAggregation("rate");
  }

  public static final class ScalingMetricInputSeriesAggregation {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricInputSeriesAggregation(String value) {
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
      return other instanceof ScalingMetricInputSeriesAggregation v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricInputSeriesAggregation SUM =
        new ScalingMetricInputSeriesAggregation("sum");
    public static final ScalingMetricInputSeriesAggregation AVG =
        new ScalingMetricInputSeriesAggregation("avg");
    public static final ScalingMetricInputSeriesAggregation MAX =
        new ScalingMetricInputSeriesAggregation("max");
  }

  public static final class CreateLoadBalancerRequestInputType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateLoadBalancerRequestInputType(String value) {
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
      return other instanceof CreateLoadBalancerRequestInputType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateLoadBalancerRequestInputType APPLICATION =
        new CreateLoadBalancerRequestInputType("application");
    public static final CreateLoadBalancerRequestInputType NETWORK =
        new CreateLoadBalancerRequestInputType("network");
  }

  public static final class LoadBalancerResponse extends Model {
    public LoadBalancerResponse() {}

    @JsonProperty(value = "load_balancer", required = true)
    private LoadBalancer load_balancer;

    @JsonProperty("load_balancer")
    public LoadBalancer getLoadBalancer() {
      return load_balancer;
    }
  }

  public static final class LoadBalancer extends Model {
    public LoadBalancer() {}

    /** Temporary extra capacity within max_count; does not change desired_count. */
    @JsonProperty(value = "rollout_surge", required = false)
    private Boolean rollout_surge;

    @JsonProperty("rollout_surge")
    public Boolean getRolloutSurge() {
      return rollout_surge;
    }

    /** Steady target within min_count and max_count. */
    @JsonProperty(value = "desired_count", required = true)
    private Long desired_count;

    @JsonProperty("desired_count")
    public Long getDesiredCount() {
      return desired_count;
    }

    /** Lower capacity bound. */
    @JsonProperty(value = "min_count", required = true)
    private Long min_count;

    @JsonProperty("min_count")
    public Long getMinCount() {
      return min_count;
    }

    /** Upper capacity bound including rollout surge. */
    @JsonProperty(value = "max_count", required = true)
    private Long max_count;

    @JsonProperty("max_count")
    public Long getMaxCount() {
      return max_count;
    }

    @JsonProperty(value = "autoscaling", required = false)
    private AutoscalingPolicy autoscaling;

    @JsonProperty("autoscaling")
    public AutoscalingPolicy getAutoscaling() {
      return autoscaling;
    }

    @JsonProperty(value = "autoscaling_status", required = false)
    private AutoscalingStatus autoscaling_status;

    @JsonProperty("autoscaling_status")
    public AutoscalingStatus getAutoscalingStatus() {
      return autoscaling_status;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** IAM resource CRN */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /** ALB-shape (L7) vs NLB-shape (L4) */
    @JsonProperty(value = "type", required = true)
    private LoadBalancerType type;

    @JsonProperty("type")
    public LoadBalancerType getType() {
      return type;
    }

    @JsonProperty(value = "status", required = true)
    private LoadBalancerStatus status;

    @JsonProperty("status")
    public LoadBalancerStatus getStatus() {
      return status;
    }

    /** Active faults; status is error exactly when an active error fault remains. */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
    }

    /**
     * Eligible subnets for member placement. Each instance has one interface, and new instances use
     * the least-populated eligible subnet.
     */
    @JsonProperty(value = "subnets", required = true)
    private List<ResourceRef> subnets;

    @JsonProperty("subnets")
    public List<ResourceRef> getSubnets() {
      return subnets;
    }

    /** Deprecated alias of desired_count. */
    @JsonProperty(value = "replica_count", required = true)
    private Long replica_count;

    @JsonProperty("replica_count")
    public Long getReplicaCount() {
      return replica_count;
    }

    /**
     * Public and private floating IP references, including automatic private allocations. Each
     * includes id, crn, visibility, and address. Infer IPv4 or IPv6 from the address.
     */
    @JsonProperty(value = "floating_ips", required = true)
    private List<FloatingIPRef> floating_ips;

    @JsonProperty("floating_ips")
    public List<FloatingIPRef> getFloatingIps() {
      return floating_ips;
    }

    /**
     * Convenience hostname auto-published for the load balancer,
     * `{name}.{account-handle}.lb.{region}.{base-domain}`. Resolves to the floating IP on an
     * internet-facing LB and to the private VIP otherwise. Omitted in regions where auto-DNS is not
     * configured — the VIP and FIP stay authoritative either way.
     */
    @JsonProperty(value = "dns_name", required = false)
    private String dns_name;

    @JsonProperty("dns_name")
    public String getDnsName() {
      return dns_name;
    }

    @JsonProperty(value = "tags", required = true)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }

    /** Regional loadbalancer-family compute flavor assigned to replicas. */
    @JsonProperty(value = "flavor", required = true)
    private ResourceRef flavor;

    @JsonProperty("flavor")
    public ResourceRef getFlavor() {
      return flavor;
    }
  }

  public static final class AutoscalingPolicy extends Model {
    public AutoscalingPolicy() {}

    @JsonProperty(value = "enabled", required = true)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    @JsonProperty(value = "metrics", required = true)
    private List<ScalingMetric> metrics;

    @JsonProperty("metrics")
    public List<ScalingMetric> getMetrics() {
      return metrics;
    }

    @JsonProperty(value = "warmup_seconds", required = false)
    private Long warmup_seconds;

    @JsonProperty("warmup_seconds")
    public Long getWarmupSeconds() {
      return warmup_seconds;
    }

    @JsonProperty(value = "cooldown_seconds", required = false)
    private Long cooldown_seconds;

    @JsonProperty("cooldown_seconds")
    public Long getCooldownSeconds() {
      return cooldown_seconds;
    }

    @JsonProperty(value = "scale_down_stabilization_seconds", required = false)
    private Long scale_down_stabilization_seconds;

    @JsonProperty("scale_down_stabilization_seconds")
    public Long getScaleDownStabilizationSeconds() {
      return scale_down_stabilization_seconds;
    }

    @JsonProperty(value = "max_scale_out_step", required = false)
    private Long max_scale_out_step;

    @JsonProperty("max_scale_out_step")
    public Long getMaxScaleOutStep() {
      return max_scale_out_step;
    }

    @JsonProperty(value = "max_scale_in_step", required = false)
    private Long max_scale_in_step;

    @JsonProperty("max_scale_in_step")
    public Long getMaxScaleInStep() {
      return max_scale_in_step;
    }

    /**
     * Grace period after route withdrawal and proxy acknowledgements, before deleting a retiring
     * member. Long-lived TCP/UDP sessions may end at the deadline; arbitrary application shutdown
     * hooks are not supported.
     */
    @JsonProperty(value = "drain_seconds", required = false)
    private Long drain_seconds;

    @JsonProperty("drain_seconds")
    public Long getDrainSeconds() {
      return drain_seconds;
    }
  }

  public static final class ScalingMetric extends Model {
    public ScalingMetric() {}

    @JsonProperty(value = "source", required = true)
    private ScalingMetricSource source;

    @JsonProperty("source")
    public ScalingMetricSource getSource() {
      return source;
    }

    @JsonProperty(value = "target_type", required = true)
    private ScalingMetricTargetType target_type;

    @JsonProperty("target_type")
    public ScalingMetricTargetType getTargetType() {
      return target_type;
    }

    @JsonProperty(value = "target_value", required = true)
    private BigDecimal target_value;

    @JsonProperty("target_value")
    public BigDecimal getTargetValue() {
      return target_value;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /** Exact-match labels; tenancy labels and __name__ cannot be supplied. */
    @JsonProperty(value = "labels", required = false)
    private Map<String, String> labels;

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
      return labels;
    }

    /**
     * Use last for queue gauges; rate for monotonically increasing counters, with reset handling.
     */
    @JsonProperty(value = "sample_aggregation", required = false)
    private ScalingMetricSampleAggregation sample_aggregation;

    @JsonProperty("sample_aggregation")
    public ScalingMetricSampleAggregation getSampleAggregation() {
      return sample_aggregation;
    }

    @JsonProperty(value = "series_aggregation", required = false)
    private ScalingMetricSeriesAggregation series_aggregation;

    @JsonProperty("series_aggregation")
    public ScalingMetricSeriesAggregation getSeriesAggregation() {
      return series_aggregation;
    }

    /** Exact expected cardinality; incomplete or ambiguous selectors are unavailable. */
    @JsonProperty(value = "expected_series", required = false)
    private Long expected_series;

    @JsonProperty("expected_series")
    public Long getExpectedSeries() {
      return expected_series;
    }

    @JsonProperty(value = "window_seconds", required = false)
    private Long window_seconds;

    @JsonProperty("window_seconds")
    public Long getWindowSeconds() {
      return window_seconds;
    }

    /**
     * Actual newest observation age per series; must not exceed window_seconds. Defaults to the
     * smaller of 90 and the window.
     */
    @JsonProperty(value = "max_age_seconds", required = false)
    private Long max_age_seconds;

    @JsonProperty("max_age_seconds")
    public Long getMaxAgeSeconds() {
      return max_age_seconds;
    }
  }

  public static final class ScalingMetricSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricSource(String value) {
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
      return other instanceof ScalingMetricSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricSource CPU = new ScalingMetricSource("cpu");
    public static final ScalingMetricSource TELEMETRY = new ScalingMetricSource("telemetry");
  }

  public static final class ScalingMetricTargetType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricTargetType(String value) {
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
      return other instanceof ScalingMetricTargetType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricTargetType UTILIZATION =
        new ScalingMetricTargetType("utilization");
    public static final ScalingMetricTargetType AVERAGE_VALUE =
        new ScalingMetricTargetType("average_value");
  }

  public static final class ScalingMetricSampleAggregation {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricSampleAggregation(String value) {
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
      return other instanceof ScalingMetricSampleAggregation v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricSampleAggregation LAST =
        new ScalingMetricSampleAggregation("last");
    public static final ScalingMetricSampleAggregation AVG =
        new ScalingMetricSampleAggregation("avg");
    public static final ScalingMetricSampleAggregation MAX =
        new ScalingMetricSampleAggregation("max");
    public static final ScalingMetricSampleAggregation RATE =
        new ScalingMetricSampleAggregation("rate");
  }

  public static final class ScalingMetricSeriesAggregation {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ScalingMetricSeriesAggregation(String value) {
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
      return other instanceof ScalingMetricSeriesAggregation v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ScalingMetricSeriesAggregation SUM =
        new ScalingMetricSeriesAggregation("sum");
    public static final ScalingMetricSeriesAggregation AVG =
        new ScalingMetricSeriesAggregation("avg");
    public static final ScalingMetricSeriesAggregation MAX =
        new ScalingMetricSeriesAggregation("max");
  }

  public static final class AutoscalingStatus extends Model {
    public AutoscalingStatus() {}

    @JsonProperty(value = "status", required = true)
    private AutoscalingStatusStatus status;

    @JsonProperty("status")
    public AutoscalingStatusStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "reason", required = true)
    private String reason;

    @JsonProperty("reason")
    public String getReason() {
      return reason;
    }

    @JsonProperty(value = "evaluated_at", required = false)
    private String evaluated_at;

    @JsonProperty("evaluated_at")
    public String getEvaluatedAt() {
      return evaluated_at;
    }

    @JsonProperty(value = "last_scaled_at", required = false)
    private String last_scaled_at;

    @JsonProperty("last_scaled_at")
    public String getLastScaledAt() {
      return last_scaled_at;
    }

    @JsonProperty(value = "history", required = true)
    private List<AutoscalingStatusHistoryItem> history;

    @JsonProperty("history")
    public List<AutoscalingStatusHistoryItem> getHistory() {
      return history;
    }
  }

  public static final class AutoscalingStatusStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AutoscalingStatusStatus(String value) {
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
      return other instanceof AutoscalingStatusStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AutoscalingStatusStatus PENDING = new AutoscalingStatusStatus("pending");
    public static final AutoscalingStatusStatus DISABLED = new AutoscalingStatusStatus("disabled");
    public static final AutoscalingStatusStatus STABLE = new AutoscalingStatusStatus("stable");
    public static final AutoscalingStatusStatus SCALING = new AutoscalingStatusStatus("scaling");
    public static final AutoscalingStatusStatus WAITING = new AutoscalingStatusStatus("waiting");
    public static final AutoscalingStatusStatus WARMING_UP =
        new AutoscalingStatusStatus("warming_up");
    public static final AutoscalingStatusStatus METRICS_UNAVAILABLE =
        new AutoscalingStatusStatus("metrics_unavailable");
    public static final AutoscalingStatusStatus STABILIZING =
        new AutoscalingStatusStatus("stabilizing");
    public static final AutoscalingStatusStatus COOLDOWN = new AutoscalingStatusStatus("cooldown");
    public static final AutoscalingStatusStatus DRAINING = new AutoscalingStatusStatus("draining");
    public static final AutoscalingStatusStatus SCALE_IN_BLOCKED =
        new AutoscalingStatusStatus("scale_in_blocked");
  }

  public static final class AutoscalingStatusHistoryItem extends Model {
    public AutoscalingStatusHistoryItem() {}

    @JsonProperty(value = "at", required = true)
    private String at;

    @JsonProperty("at")
    public String getAt() {
      return at;
    }

    @JsonProperty(value = "from", required = true)
    private Long from;

    @JsonProperty("from")
    public Long getFrom() {
      return from;
    }

    @JsonProperty(value = "to", required = true)
    private Long to;

    @JsonProperty("to")
    public Long getTo() {
      return to;
    }

    @JsonProperty(value = "reason", required = true)
    private String reason;

    @JsonProperty("reason")
    public String getReason() {
      return reason;
    }
  }

  public static final class LoadBalancerType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LoadBalancerType(String value) {
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
      return other instanceof LoadBalancerType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LoadBalancerType APPLICATION = new LoadBalancerType("application");
    public static final LoadBalancerType NETWORK = new LoadBalancerType("network");
  }

  public static final class LoadBalancerStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LoadBalancerStatus(String value) {
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
      return other instanceof LoadBalancerStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LoadBalancerStatus PROVISIONING = new LoadBalancerStatus("provisioning");
    public static final LoadBalancerStatus ACTIVE = new LoadBalancerStatus("active");
    public static final LoadBalancerStatus ERROR = new LoadBalancerStatus("error");
    public static final LoadBalancerStatus DELETING = new LoadBalancerStatus("deleting");
  }

  public static final class Fault extends Model {
    public Fault() {}

    /** Stable machine-readable code owned by the reporting operation. */
    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    @JsonProperty(value = "severity", required = true)
    private FaultSeverity severity;

    @JsonProperty("severity")
    public FaultSeverity getSeverity() {
      return severity;
    }

    @JsonProperty(value = "message", required = true)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    /** Structured context; legacy strings are preserved in legacy_text. */
    @JsonProperty(value = "details", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Map<String, JsonNode>> details = JsonField.missing();

    @JsonProperty("details")
    public JsonField<Map<String, JsonNode>> getDetails() {
      return details;
    }

    /** First observation in this active occurrence series. */
    @JsonProperty(value = "first_at", required = true)
    private String first_at;

    @JsonProperty("first_at")
    public String getFirstAt() {
      return first_at;
    }

    /** Latest observation in this active occurrence series. */
    @JsonProperty(value = "last_at", required = true)
    private String last_at;

    @JsonProperty("last_at")
    public String getLastAt() {
      return last_at;
    }

    @JsonProperty(value = "occurrences", required = true)
    private Long occurrences;

    @JsonProperty("occurrences")
    public Long getOccurrences() {
      return occurrences;
    }
  }

  public static final class FaultSeverity {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FaultSeverity(String value) {
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
      return other instanceof FaultSeverity v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FaultSeverity ERROR = new FaultSeverity("error");
    public static final FaultSeverity WARNING = new FaultSeverity("warning");
  }

  public static final class FloatingIPRef extends Model {
    public FloatingIPRef() {}

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

    @JsonProperty(value = "visibility", required = true)
    private FloatingIPRefVisibility visibility;

    @JsonProperty("visibility")
    public FloatingIPRefVisibility getVisibility() {
      return visibility;
    }

    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }
  }

  public static final class FloatingIPRefVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FloatingIPRefVisibility(String value) {
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
      return other instanceof FloatingIPRefVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FloatingIPRefVisibility PUBLIC = new FloatingIPRefVisibility("public");
    public static final FloatingIPRefVisibility PRIVATE = new FloatingIPRefVisibility("private");
  }

  public static final class CreateRuleRequestInput extends Model {
    public CreateRuleRequestInput() {}

    @JsonProperty(value = "priority", required = true)
    private Long priority;

    @JsonProperty("priority")
    public Long getPriority() {
      return priority;
    }

    public CreateRuleRequestInput withPriority(Long value) {
      this.priority = value;
      return this;
    }

    @JsonProperty(value = "conditions", required = true)
    private List<RuleConditionInput> conditions;

    @JsonProperty("conditions")
    public List<RuleConditionInput> getConditions() {
      return conditions;
    }

    public CreateRuleRequestInput withConditions(List<RuleConditionInput> value) {
      this.conditions = value;
      return this;
    }

    @JsonProperty(value = "target_group", required = true)
    private String target_group;

    @JsonProperty("target_group")
    public String getTargetGroup() {
      return target_group;
    }

    public CreateRuleRequestInput withTargetGroup(String value) {
      this.target_group = value;
      return this;
    }
  }

  public static final class RuleConditionInput extends Model {
    public RuleConditionInput() {}

    @JsonProperty(value = "field", required = true)
    private RuleConditionInputField field;

    @JsonProperty("field")
    public RuleConditionInputField getField() {
      return field;
    }

    public RuleConditionInput withField(RuleConditionInputField value) {
      this.field = value;
      return this;
    }

    @JsonProperty(value = "op", required = true)
    private RuleConditionInputOp op;

    @JsonProperty("op")
    public RuleConditionInputOp getOp() {
      return op;
    }

    public RuleConditionInput withOp(RuleConditionInputOp value) {
      this.op = value;
      return this;
    }

    /** header or query key name */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public RuleConditionInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "values", required = true)
    private List<String> values;

    @JsonProperty("values")
    public List<String> getValues() {
      return values;
    }

    public RuleConditionInput withValues(List<String> value) {
      this.values = value;
      return this;
    }
  }

  public static final class RuleConditionInputField {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RuleConditionInputField(String value) {
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
      return other instanceof RuleConditionInputField v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RuleConditionInputField HOST = new RuleConditionInputField("host");
    public static final RuleConditionInputField PATH = new RuleConditionInputField("path");
    public static final RuleConditionInputField HEADER = new RuleConditionInputField("header");
    public static final RuleConditionInputField QUERY = new RuleConditionInputField("query");
    public static final RuleConditionInputField METHOD = new RuleConditionInputField("method");
  }

  public static final class RuleConditionInputOp {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RuleConditionInputOp(String value) {
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
      return other instanceof RuleConditionInputOp v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RuleConditionInputOp EXACT = new RuleConditionInputOp("exact");
    public static final RuleConditionInputOp PREFIX = new RuleConditionInputOp("prefix");
    public static final RuleConditionInputOp GLOB = new RuleConditionInputOp("glob");
    public static final RuleConditionInputOp REGEX = new RuleConditionInputOp("regex");
  }

  public static final class RuleResponse extends Model {
    public RuleResponse() {}

    @JsonProperty(value = "rule", required = true)
    private Rule rule;

    @JsonProperty("rule")
    public Rule getRule() {
      return rule;
    }
  }

  public static final class Rule extends Model {
    public Rule() {}

    /** Parent-scoped CRN with immutable load balancer name and child UUID components. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "priority", required = true)
    private Long priority;

    @JsonProperty("priority")
    public Long getPriority() {
      return priority;
    }

    @JsonProperty(value = "conditions", required = true)
    private List<RuleCondition> conditions;

    @JsonProperty("conditions")
    public List<RuleCondition> getConditions() {
      return conditions;
    }

    @JsonProperty(value = "target_group", required = true)
    private ResourceRef target_group;

    @JsonProperty("target_group")
    public ResourceRef getTargetGroup() {
      return target_group;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class RuleCondition extends Model {
    public RuleCondition() {}

    @JsonProperty(value = "field", required = true)
    private RuleConditionField field;

    @JsonProperty("field")
    public RuleConditionField getField() {
      return field;
    }

    @JsonProperty(value = "op", required = true)
    private RuleConditionOp op;

    @JsonProperty("op")
    public RuleConditionOp getOp() {
      return op;
    }

    /** header or query key name */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "values", required = true)
    private List<String> values;

    @JsonProperty("values")
    public List<String> getValues() {
      return values;
    }
  }

  public static final class RuleConditionField {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RuleConditionField(String value) {
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
      return other instanceof RuleConditionField v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RuleConditionField HOST = new RuleConditionField("host");
    public static final RuleConditionField PATH = new RuleConditionField("path");
    public static final RuleConditionField HEADER = new RuleConditionField("header");
    public static final RuleConditionField QUERY = new RuleConditionField("query");
    public static final RuleConditionField METHOD = new RuleConditionField("method");
  }

  public static final class RuleConditionOp {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RuleConditionOp(String value) {
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
      return other instanceof RuleConditionOp v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RuleConditionOp EXACT = new RuleConditionOp("exact");
    public static final RuleConditionOp PREFIX = new RuleConditionOp("prefix");
    public static final RuleConditionOp GLOB = new RuleConditionOp("glob");
    public static final RuleConditionOp REGEX = new RuleConditionOp("regex");
  }

  public static final class CreateTargetGroupRequestInput extends Model {
    public CreateTargetGroupRequestInput() {}

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateTargetGroupRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "protocol", required = true)
    private CreateTargetGroupRequestInputProtocol protocol;

    @JsonProperty("protocol")
    public CreateTargetGroupRequestInputProtocol getProtocol() {
      return protocol;
    }

    public CreateTargetGroupRequestInput withProtocol(CreateTargetGroupRequestInputProtocol value) {
      this.protocol = value;
      return this;
    }

    @JsonProperty(value = "target_type", required = false)
    private CreateTargetGroupRequestInputTargetType target_type;

    @JsonProperty("target_type")
    public CreateTargetGroupRequestInputTargetType getTargetType() {
      return target_type;
    }

    public CreateTargetGroupRequestInput withTargetType(
        CreateTargetGroupRequestInputTargetType value) {
      this.target_type = value;
      return this;
    }

    @JsonProperty(value = "port", required = true)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    public CreateTargetGroupRequestInput withPort(Long value) {
      this.port = value;
      return this;
    }

    @JsonProperty(value = "health_check", required = false)
    private HealthCheckInput health_check;

    @JsonProperty("health_check")
    public HealthCheckInput getHealthCheck() {
      return health_check;
    }

    public CreateTargetGroupRequestInput withHealthCheck(HealthCheckInput value) {
      this.health_check = value;
      return this;
    }

    @JsonProperty(value = "proxy_protocol", required = false)
    private Boolean proxy_protocol;

    @JsonProperty("proxy_protocol")
    public Boolean getProxyProtocol() {
      return proxy_protocol;
    }

    public CreateTargetGroupRequestInput withProxyProtocol(Boolean value) {
      this.proxy_protocol = value;
      return this;
    }

    @JsonProperty(value = "session_affinity", required = false)
    private SessionAffinityInput session_affinity;

    @JsonProperty("session_affinity")
    public SessionAffinityInput getSessionAffinity() {
      return session_affinity;
    }

    public CreateTargetGroupRequestInput withSessionAffinity(SessionAffinityInput value) {
      this.session_affinity = value;
      return this;
    }

    /**
     * `static` (the default) takes the backends you attach as targets. `pool` takes them from a
     * compute instance pool and requires instance_pool; the group is forced to
     * target_type=instance, and attaching targets to it is rejected.
     */
    @JsonProperty(value = "target_mode", required = false)
    private CreateTargetGroupRequestInputTargetMode target_mode;

    @JsonProperty("target_mode")
    public CreateTargetGroupRequestInputTargetMode getTargetMode() {
      return target_mode;
    }

    public CreateTargetGroupRequestInput withTargetMode(
        CreateTargetGroupRequestInputTargetMode value) {
      this.target_mode = value;
      return this;
    }

    /**
     * Compute instance pool to draw backends from. Required when target_mode=pool and must belong
     * to the calling account; ignored otherwise.
     */
    @JsonProperty(value = "instance_pool", required = false)
    private String instance_pool;

    @JsonProperty("instance_pool")
    public String getInstancePool() {
      return instance_pool;
    }

    public CreateTargetGroupRequestInput withInstancePool(String value) {
      this.instance_pool = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateTargetGroupRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class CreateTargetGroupRequestInputProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateTargetGroupRequestInputProtocol(String value) {
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
      return other instanceof CreateTargetGroupRequestInputProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateTargetGroupRequestInputProtocol HTTP =
        new CreateTargetGroupRequestInputProtocol("http");
    public static final CreateTargetGroupRequestInputProtocol HTTPS =
        new CreateTargetGroupRequestInputProtocol("https");
    public static final CreateTargetGroupRequestInputProtocol TCP =
        new CreateTargetGroupRequestInputProtocol("tcp");
    public static final CreateTargetGroupRequestInputProtocol UDP =
        new CreateTargetGroupRequestInputProtocol("udp");
  }

  public static final class CreateTargetGroupRequestInputTargetType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateTargetGroupRequestInputTargetType(String value) {
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
      return other instanceof CreateTargetGroupRequestInputTargetType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateTargetGroupRequestInputTargetType IP =
        new CreateTargetGroupRequestInputTargetType("ip");
    public static final CreateTargetGroupRequestInputTargetType INSTANCE =
        new CreateTargetGroupRequestInputTargetType("instance");
    public static final CreateTargetGroupRequestInputTargetType FUNCTION =
        new CreateTargetGroupRequestInputTargetType("function");
  }

  public static final class HealthCheckInput extends Model {
    public HealthCheckInput() {}

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public HealthCheckInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    /**
     * Omitted or empty uses the target group protocol. UDP uses a TCP connect probe. HTTPS probes
     * use TLS.
     */
    @JsonProperty(value = "protocol", required = false)
    private HealthCheckInputProtocol protocol;

    @JsonProperty("protocol")
    public HealthCheckInputProtocol getProtocol() {
      return protocol;
    }

    public HealthCheckInput withProtocol(HealthCheckInputProtocol value) {
      this.protocol = value;
      return this;
    }

    @JsonProperty(value = "path", required = false)
    private String path;

    @JsonProperty("path")
    public String getPath() {
      return path;
    }

    public HealthCheckInput withPath(String value) {
      this.path = value;
      return this;
    }

    @JsonProperty(value = "port", required = false)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    public HealthCheckInput withPort(Long value) {
      this.port = value;
      return this;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "interval_sec", required = false)
    private Long interval_sec;

    @JsonProperty("interval_sec")
    public Long getIntervalSec() {
      return interval_sec;
    }

    public HealthCheckInput withIntervalSec(Long value) {
      this.interval_sec = value;
      return this;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "timeout_sec", required = false)
    private Long timeout_sec;

    @JsonProperty("timeout_sec")
    public Long getTimeoutSec() {
      return timeout_sec;
    }

    public HealthCheckInput withTimeoutSec(Long value) {
      this.timeout_sec = value;
      return this;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "healthy_threshold", required = false)
    private Long healthy_threshold;

    @JsonProperty("healthy_threshold")
    public Long getHealthyThreshold() {
      return healthy_threshold;
    }

    public HealthCheckInput withHealthyThreshold(Long value) {
      this.healthy_threshold = value;
      return this;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "unhealthy_threshold", required = false)
    private Long unhealthy_threshold;

    @JsonProperty("unhealthy_threshold")
    public Long getUnhealthyThreshold() {
      return unhealthy_threshold;
    }

    public HealthCheckInput withUnhealthyThreshold(Long value) {
      this.unhealthy_threshold = value;
      return this;
    }

    /**
     * HTTP status codes from 100 to 599; comma-separated codes or inclusive ranges. Empty uses 200.
     */
    @JsonProperty(value = "matcher", required = false)
    private String matcher;

    @JsonProperty("matcher")
    public String getMatcher() {
      return matcher;
    }

    public HealthCheckInput withMatcher(String value) {
      this.matcher = value;
      return this;
    }
  }

  public static final class HealthCheckInputProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public HealthCheckInputProtocol(String value) {
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
      return other instanceof HealthCheckInputProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final HealthCheckInputProtocol HTTP = new HealthCheckInputProtocol("http");
    public static final HealthCheckInputProtocol HTTPS = new HealthCheckInputProtocol("https");
    public static final HealthCheckInputProtocol TCP = new HealthCheckInputProtocol("tcp");
    public static final HealthCheckInputProtocol UDP = new HealthCheckInputProtocol("udp");
    public static final HealthCheckInputProtocol VALUE = new HealthCheckInputProtocol("");
  }

  public static final class SessionAffinityInput extends Model {
    public SessionAffinityInput() {}

    /**
     * `none` balances every request. `cookie` sets an opaque cookie on the first response and
     * routes every later request carrying it to the same backend — http and https groups only.
     * `source_ip` hashes the client address, works on every protocol and is the only option for tcp
     * and udp, but a NAT gateway makes every client behind it a single key.
     */
    @JsonProperty(value = "type", required = true)
    private SessionAffinityInputType type;

    @JsonProperty("type")
    public SessionAffinityInputType getType() {
      return type;
    }

    public SessionAffinityInput withType(SessionAffinityInputType value) {
      this.type = value;
      return this;
    }

    /**
     * Cookie the load balancer sets and hashes. `type=cookie` only; the field is dropped for the
     * other types.
     */
    @JsonProperty(value = "cookie_name", required = false)
    private String cookie_name;

    @JsonProperty("cookie_name")
    public String getCookieName() {
      return cookie_name;
    }

    public SessionAffinityInput withCookieName(String value) {
      this.cookie_name = value;
      return this;
    }

    /** How long that cookie lives, up to 7 days. `type=cookie` only. */
    @JsonProperty(value = "duration_sec", required = false)
    private Long duration_sec;

    @JsonProperty("duration_sec")
    public Long getDurationSec() {
      return duration_sec;
    }

    public SessionAffinityInput withDurationSec(Long value) {
      this.duration_sec = value;
      return this;
    }
  }

  public static final class SessionAffinityInputType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SessionAffinityInputType(String value) {
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
      return other instanceof SessionAffinityInputType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SessionAffinityInputType NONE = new SessionAffinityInputType("none");
    public static final SessionAffinityInputType COOKIE = new SessionAffinityInputType("cookie");
    public static final SessionAffinityInputType SOURCE_IP =
        new SessionAffinityInputType("source_ip");
  }

  public static final class CreateTargetGroupRequestInputTargetMode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateTargetGroupRequestInputTargetMode(String value) {
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
      return other instanceof CreateTargetGroupRequestInputTargetMode v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateTargetGroupRequestInputTargetMode STATIC =
        new CreateTargetGroupRequestInputTargetMode("static");
    public static final CreateTargetGroupRequestInputTargetMode POOL =
        new CreateTargetGroupRequestInputTargetMode("pool");
  }

  public static final class TargetGroupResponse extends Model {
    public TargetGroupResponse() {}

    @JsonProperty(value = "target_group", required = true)
    private TargetGroup target_group;

    @JsonProperty("target_group")
    public TargetGroup getTargetGroup() {
      return target_group;
    }
  }

  public static final class TargetGroup extends Model {
    public TargetGroup() {}

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
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "protocol", required = true)
    private TargetGroupProtocol protocol;

    @JsonProperty("protocol")
    public TargetGroupProtocol getProtocol() {
      return protocol;
    }

    @JsonProperty(value = "target_type", required = true)
    private TargetGroupTargetType target_type;

    @JsonProperty("target_type")
    public TargetGroupTargetType getTargetType() {
      return target_type;
    }

    @JsonProperty(value = "port", required = true)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    @JsonProperty(value = "health_check", required = true)
    private HealthCheck health_check;

    @JsonProperty("health_check")
    public HealthCheck getHealthCheck() {
      return health_check;
    }

    /**
     * When true, upstream connections are wrapped in the PROXY v2 header so backends see the
     * original client IP + port. HTTP backends already get X-Forwarded-For; PROXY is the right pick
     * for TCP/UDP target groups or HTTP backends that prefer the framed envelope.
     */
    @JsonProperty(value = "proxy_protocol", required = true)
    private Boolean proxy_protocol;

    @JsonProperty("proxy_protocol")
    public Boolean getProxyProtocol() {
      return proxy_protocol;
    }

    @JsonProperty(value = "session_affinity", required = true)
    private SessionAffinity session_affinity;

    @JsonProperty("session_affinity")
    public SessionAffinity getSessionAffinity() {
      return session_affinity;
    }

    /**
     * Where the backend set comes from. `static` routes to the targets attached via POST
     * /v1/target-groups/{id}/targets; `pool` resolves live instance addresses from the compute
     * instance pool named by instance_pool, so scaling the pool moves the backends with it.
     */
    @JsonProperty(value = "target_mode", required = true)
    private TargetGroupTargetMode target_mode;

    @JsonProperty("target_mode")
    public TargetGroupTargetMode getTargetMode() {
      return target_mode;
    }

    /** Compute instance pool backing the group. Omitted for static target groups. */
    @JsonProperty(value = "instance_pool", required = false)
    private ResourceRef instance_pool;

    @JsonProperty("instance_pool")
    public ResourceRef getInstancePool() {
      return instance_pool;
    }

    @JsonProperty(value = "tags", required = true)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class TargetGroupProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TargetGroupProtocol(String value) {
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
      return other instanceof TargetGroupProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TargetGroupProtocol HTTP = new TargetGroupProtocol("http");
    public static final TargetGroupProtocol HTTPS = new TargetGroupProtocol("https");
    public static final TargetGroupProtocol TCP = new TargetGroupProtocol("tcp");
    public static final TargetGroupProtocol UDP = new TargetGroupProtocol("udp");
  }

  public static final class TargetGroupTargetType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TargetGroupTargetType(String value) {
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
      return other instanceof TargetGroupTargetType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TargetGroupTargetType IP = new TargetGroupTargetType("ip");
    public static final TargetGroupTargetType INSTANCE = new TargetGroupTargetType("instance");
    public static final TargetGroupTargetType FUNCTION = new TargetGroupTargetType("function");
  }

  public static final class HealthCheck extends Model {
    public HealthCheck() {}

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    /**
     * Omitted or empty uses the target group protocol. UDP uses a TCP connect probe. HTTPS probes
     * use TLS.
     */
    @JsonProperty(value = "protocol", required = false)
    private HealthCheckProtocol protocol;

    @JsonProperty("protocol")
    public HealthCheckProtocol getProtocol() {
      return protocol;
    }

    @JsonProperty(value = "path", required = false)
    private String path;

    @JsonProperty("path")
    public String getPath() {
      return path;
    }

    @JsonProperty(value = "port", required = false)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "interval_sec", required = false)
    private Long interval_sec;

    @JsonProperty("interval_sec")
    public Long getIntervalSec() {
      return interval_sec;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "timeout_sec", required = false)
    private Long timeout_sec;

    @JsonProperty("timeout_sec")
    public Long getTimeoutSec() {
      return timeout_sec;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "healthy_threshold", required = false)
    private Long healthy_threshold;

    @JsonProperty("healthy_threshold")
    public Long getHealthyThreshold() {
      return healthy_threshold;
    }

    /** Zero uses the default. */
    @JsonProperty(value = "unhealthy_threshold", required = false)
    private Long unhealthy_threshold;

    @JsonProperty("unhealthy_threshold")
    public Long getUnhealthyThreshold() {
      return unhealthy_threshold;
    }

    /**
     * HTTP status codes from 100 to 599; comma-separated codes or inclusive ranges. Empty uses 200.
     */
    @JsonProperty(value = "matcher", required = false)
    private String matcher;

    @JsonProperty("matcher")
    public String getMatcher() {
      return matcher;
    }
  }

  public static final class HealthCheckProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public HealthCheckProtocol(String value) {
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
      return other instanceof HealthCheckProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final HealthCheckProtocol HTTP = new HealthCheckProtocol("http");
    public static final HealthCheckProtocol HTTPS = new HealthCheckProtocol("https");
    public static final HealthCheckProtocol TCP = new HealthCheckProtocol("tcp");
    public static final HealthCheckProtocol UDP = new HealthCheckProtocol("udp");
    public static final HealthCheckProtocol VALUE = new HealthCheckProtocol("");
  }

  public static final class SessionAffinity extends Model {
    public SessionAffinity() {}

    /**
     * `none` balances every request. `cookie` sets an opaque cookie on the first response and
     * routes every later request carrying it to the same backend — http and https groups only.
     * `source_ip` hashes the client address, works on every protocol and is the only option for tcp
     * and udp, but a NAT gateway makes every client behind it a single key.
     */
    @JsonProperty(value = "type", required = true)
    private SessionAffinityType type;

    @JsonProperty("type")
    public SessionAffinityType getType() {
      return type;
    }

    /**
     * Cookie the load balancer sets and hashes. `type=cookie` only; the field is dropped for the
     * other types.
     */
    @JsonProperty(value = "cookie_name", required = false)
    private String cookie_name;

    @JsonProperty("cookie_name")
    public String getCookieName() {
      return cookie_name;
    }

    /** How long that cookie lives, up to 7 days. `type=cookie` only. */
    @JsonProperty(value = "duration_sec", required = false)
    private Long duration_sec;

    @JsonProperty("duration_sec")
    public Long getDurationSec() {
      return duration_sec;
    }
  }

  public static final class SessionAffinityType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SessionAffinityType(String value) {
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
      return other instanceof SessionAffinityType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SessionAffinityType NONE = new SessionAffinityType("none");
    public static final SessionAffinityType COOKIE = new SessionAffinityType("cookie");
    public static final SessionAffinityType SOURCE_IP = new SessionAffinityType("source_ip");
  }

  public static final class TargetGroupTargetMode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TargetGroupTargetMode(String value) {
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
      return other instanceof TargetGroupTargetMode v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TargetGroupTargetMode STATIC = new TargetGroupTargetMode("static");
    public static final TargetGroupTargetMode POOL = new TargetGroupTargetMode("pool");
  }

  public static final class GetListenerScope extends Model {
    public GetListenerScope() {}
  }

  public static final class GetLoadBalancerScope extends Model {
    public GetLoadBalancerScope() {}

    @JsonProperty(value = "status", required = false)
    private GetLoadBalancerScopeStatus status;

    @JsonProperty("status")
    public GetLoadBalancerScopeStatus getStatus() {
      return status;
    }

    public GetLoadBalancerScope withStatus(GetLoadBalancerScopeStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetLoadBalancerScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetLoadBalancerScopeStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GetLoadBalancerScopeStatus(String value) {
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
      return other instanceof GetLoadBalancerScopeStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final GetLoadBalancerScopeStatus PROVISIONING =
        new GetLoadBalancerScopeStatus("provisioning");
    public static final GetLoadBalancerScopeStatus ACTIVE =
        new GetLoadBalancerScopeStatus("active");
    public static final GetLoadBalancerScopeStatus ERROR = new GetLoadBalancerScopeStatus("error");
    public static final GetLoadBalancerScopeStatus DELETING =
        new GetLoadBalancerScopeStatus("deleting");
  }

  public static final class GetRuleScope extends Model {
    public GetRuleScope() {}
  }

  public static final class GetTargetScope extends Model {
    public GetTargetScope() {}
  }

  public static final class GetTargetGroupScope extends Model {
    public GetTargetGroupScope() {}

    @JsonProperty(value = "protocol", required = false)
    private GetTargetGroupScopeProtocol protocol;

    @JsonProperty("protocol")
    public GetTargetGroupScopeProtocol getProtocol() {
      return protocol;
    }

    public GetTargetGroupScope withProtocol(GetTargetGroupScopeProtocol value) {
      this.protocol = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetTargetGroupScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetTargetGroupScopeProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GetTargetGroupScopeProtocol(String value) {
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
      return other instanceof GetTargetGroupScopeProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final GetTargetGroupScopeProtocol HTTP = new GetTargetGroupScopeProtocol("http");
    public static final GetTargetGroupScopeProtocol HTTPS =
        new GetTargetGroupScopeProtocol("https");
    public static final GetTargetGroupScopeProtocol TCP = new GetTargetGroupScopeProtocol("tcp");
    public static final GetTargetGroupScopeProtocol UDP = new GetTargetGroupScopeProtocol("udp");
  }

  public static final class ListenerCertificateListResponse extends Model {
    public ListenerCertificateListResponse() {}

    @JsonProperty(value = "certificates", required = true)
    private List<Certificate> certificates;

    @JsonProperty("certificates")
    public List<Certificate> getCertificates() {
      return certificates;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Certificate extends Model {
    public Certificate() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * Name-based, so an IAM policy can wildcard a naming convention
     * (`crn:certificate::my-account:certificate/prod-*`). The region slot is empty for
     * compatibility; certificate storage and KMS material are regional.
     */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "domains", required = false)
    private List<String> domains;

    @JsonProperty("domains")
    public List<String> getDomains() {
      return domains;
    }

    @JsonProperty(value = "status", required = false)
    private CertificateStatus status;

    @JsonProperty("status")
    public CertificateStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "source", required = false)
    private CertificateSource source;

    @JsonProperty("source")
    public CertificateSource getSource() {
      return source;
    }

    @JsonProperty(value = "key_algorithm", required = false)
    private CertificateKeyAlgorithm key_algorithm;

    @JsonProperty("key_algorithm")
    public CertificateKeyAlgorithm getKeyAlgorithm() {
      return key_algorithm;
    }

    /**
     * Per-domain CNAME delegation state — one entry per domain on the cert. While
     * status=pending_dns issuance waits for every challenge's `verified` to flip true; use
     * `expected_cname` and `our_dns` to tell which records need to be added at the registrar.
     */
    @JsonProperty(value = "challenges", required = false)
    private List<CertificateChallenge> challenges;

    @JsonProperty("challenges")
    public List<CertificateChallenge> getChallenges() {
      return challenges;
    }

    /** PEM-encoded leaf certificate. Empty until active. */
    @JsonProperty(value = "certificate_pem", required = false)
    private String certificate_pem;

    @JsonProperty("certificate_pem")
    public String getCertificatePem() {
      return certificate_pem;
    }

    /** PEM-encoded intermediate chain. */
    @JsonProperty(value = "chain_pem", required = false)
    private String chain_pem;

    @JsonProperty("chain_pem")
    public String getChainPem() {
      return chain_pem;
    }

    /**
     * Hex SHA-256 of the leaf's DER — the certificate's material version. Changes on every
     * rotation; consumers use it to know when to re-fetch material and to verify they fetched the
     * intended generation. Empty until the cert has a leaf.
     */
    @JsonProperty(value = "fingerprint", required = false)
    private String fingerprint;

    @JsonProperty("fingerprint")
    public String getFingerprint() {
      return fingerprint;
    }

    @JsonProperty(value = "issued_at", required = false)
    private String issued_at;

    @JsonProperty("issued_at")
    public String getIssuedAt() {
      return issued_at;
    }

    @JsonProperty(value = "expires_at", required = false)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    /**
     * Active faults, ordered newest first. Empty when healthy. Renewal failures are warnings while
     * valid certificate material still serves. Codes: CERTIFICATE_ISSUANCE_START_FAILED (issuance
     * could not be scheduled), CERTIFICATE_ISSUANCE_FAILED (the signing request failed),
     * CERTIFICATE_RENEWAL_FAILED (renewal did not complete; a warning while valid material is still
     * serving, an error once it has expired), CERTIFICATE_REVOCATION_FAILED (revocation did not
     * complete).
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }
  }

  public static final class CertificateStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateStatus(String value) {
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
      return other instanceof CertificateStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateStatus PENDING_DNS = new CertificateStatus("pending_dns");
    public static final CertificateStatus PENDING = new CertificateStatus("pending");
    public static final CertificateStatus ACTIVE = new CertificateStatus("active");
    public static final CertificateStatus ERROR = new CertificateStatus("error");
    public static final CertificateStatus EXPIRED = new CertificateStatus("expired");
    public static final CertificateStatus REVOKED = new CertificateStatus("revoked");
  }

  public static final class CertificateSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateSource(String value) {
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
      return other instanceof CertificateSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateSource ACME = new CertificateSource("acme");
    public static final CertificateSource UPLOADED = new CertificateSource("uploaded");
  }

  public static final class CertificateKeyAlgorithm {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CertificateKeyAlgorithm(String value) {
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
      return other instanceof CertificateKeyAlgorithm v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CertificateKeyAlgorithm ECDSA_P256 =
        new CertificateKeyAlgorithm("ecdsa-p256");
    public static final CertificateKeyAlgorithm ECDSA_P384 =
        new CertificateKeyAlgorithm("ecdsa-p384");
    public static final CertificateKeyAlgorithm RSA2048 = new CertificateKeyAlgorithm("rsa-2048");
    public static final CertificateKeyAlgorithm RSA4096 = new CertificateKeyAlgorithm("rsa-4096");
  }

  public static final class CertificateChallenge extends Model {
    public CertificateChallenge() {}

    /** The cert SAN this challenge belongs to (as the customer wrote it). */
    @JsonProperty(value = "domain", required = false)
    private String domain;

    @JsonProperty("domain")
    public String getDomain() {
      return domain;
    }

    /**
     * Full LHS of the CNAME record the customer needs to add. For wildcard SANs this is the parent
     * name (`_acme-challenge.example.com.`), not the literal SAN — wildcards validate at their
     * parent under RFC 8555 §8.4.
     */
    @JsonProperty(value = "cname_record_name", required = false)
    private String cname_record_name;

    @JsonProperty("cname_record_name")
    public String getCnameRecordName() {
      return cname_record_name;
    }

    /**
     * Target FQDN (RHS of the CNAME). Hosted in the platform's validation zone, where the per-order
     * TXT is published during issuance.
     */
    @JsonProperty(value = "expected_cname", required = false)
    private String expected_cname;

    @JsonProperty("expected_cname")
    public String getExpectedCname() {
      return expected_cname;
    }

    /**
     * True when the domain is hosted on the platform DNS service and the CNAME was created
     * automatically. False means the customer owns the zone and must add the CNAME at their
     * registrar.
     */
    @JsonProperty(value = "our_dns", required = false)
    private Boolean our_dns;

    @JsonProperty("our_dns")
    public Boolean getOurDns() {
      return our_dns;
    }

    /**
     * True once the CNAME has resolved to expected_cname; cert issuance only proceeds when every
     * challenge is verified.
     */
    @JsonProperty(value = "verified", required = false)
    private Boolean verified;

    @JsonProperty("verified")
    public Boolean getVerified() {
      return verified;
    }

    @JsonProperty(value = "verified_at", required = false)
    private String verified_at;

    @JsonProperty("verified_at")
    public String getVerifiedAt() {
      return verified_at;
    }

    /**
     * Active verification warnings only; empty when healthy. Successful verification resolves
     * verification faults while retaining history. verified records a successful observation and
     * remains true if a later renewal observes a DNS failure. A CNAME mismatch records
     * CERTIFICATE_DNS_VERIFICATION_FAILED as a warning; verified does not move. Internal history
     * uses the parent CRN followed by /challenge/&lt;stored-uuid&gt;; no separate endpoint is
     * exposed.
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
    }
  }

  public static final class PaginationMeta extends Model {
    public PaginationMeta() {}

    /** Total number of items */
    @JsonProperty(value = "total", required = false)
    private Long total;

    @JsonProperty("total")
    public Long getTotal() {
      return total;
    }

    /** Number of items per page */
    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    /**
     * Opaque cursor for the next page. Pass it back as the `marker` query parameter; treat it as a
     * token, not a value to parse.
     */
    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    /** Whether there are more items */
    @JsonProperty(value = "has_more", required = false)
    private Boolean has_more;

    @JsonProperty("has_more")
    public Boolean getHasMore() {
      return has_more;
    }
  }

  public static final class ListListenersQuery extends Model {
    public ListListenersQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListListenersQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListListenersQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListenerListResponse extends Model {
    public ListenerListResponse() {}

    @JsonProperty(value = "listeners", required = true)
    private List<Listener> listeners;

    @JsonProperty("listeners")
    public List<Listener> getListeners() {
      return listeners;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListLoadBalancerInstancesQuery extends Model {
    public ListLoadBalancerInstancesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListLoadBalancerInstancesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListLoadBalancerInstancesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListLoadBalancerInstancesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListLoadBalancerInstancesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "current_state", required = false)
    private CurrentStateInput current_state;

    @JsonProperty("current_state")
    public CurrentStateInput getCurrentState() {
      return current_state;
    }

    public ListLoadBalancerInstancesQuery withCurrentState(CurrentStateInput value) {
      this.current_state = value;
      return this;
    }

    @JsonProperty(value = "flavor", required = false)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public ListLoadBalancerInstancesQuery withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    @JsonProperty(value = "image", required = false)
    private String image;

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    public ListLoadBalancerInstancesQuery withImage(String value) {
      this.image = value;
      return this;
    }
  }

  public static final class CurrentStateInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CurrentStateInput(String value) {
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
      return other instanceof CurrentStateInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CurrentStateInput PENDING = new CurrentStateInput("pending");
    public static final CurrentStateInput BUILDING = new CurrentStateInput("building");
    public static final CurrentStateInput RUNNING = new CurrentStateInput("running");
    public static final CurrentStateInput STOPPING = new CurrentStateInput("stopping");
    public static final CurrentStateInput STOPPED = new CurrentStateInput("stopped");
    public static final CurrentStateInput REBOOTING = new CurrentStateInput("rebooting");
    public static final CurrentStateInput MIGRATING = new CurrentStateInput("migrating");
    public static final CurrentStateInput DELETING = new CurrentStateInput("deleting");
    public static final CurrentStateInput DELETED = new CurrentStateInput("deleted");
    public static final CurrentStateInput ERROR = new CurrentStateInput("error");
    public static final CurrentStateInput CRASHED = new CurrentStateInput("crashed");
    public static final CurrentStateInput PAUSED = new CurrentStateInput("paused");
    public static final CurrentStateInput SUSPENDED = new CurrentStateInput("suspended");
  }

  public static final class LoadBalancerInstancesResponse extends Model {
    public LoadBalancerInstancesResponse() {}

    @JsonProperty(value = "instances", required = true)
    private List<LoadBalancerInstance> instances;

    @JsonProperty("instances")
    public List<LoadBalancerInstance> getInstances() {
      return instances;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class LoadBalancerInstance extends Model {
    public LoadBalancerInstance() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Resource names must not start with the literal crn: prefix or be UUIDs (canonical, compact,
     * braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    /** In-flight transition, if any; null when settled. */
    @JsonProperty(value = "task_state", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> task_state = JsonField.missing();

    @JsonProperty("task_state")
    public JsonField<String> getTaskState() {
      return task_state;
    }

    /** Flavor identity. Every instance has a flavor; query the flavor resource for CPU and RAM. */
    @JsonProperty(value = "flavor", required = true)
    private ResourceRef flavor;

    @JsonProperty("flavor")
    public ResourceRef getFlavor() {
      return flavor;
    }

    /** Pinned source image identity, or null for a volume-only boot. */
    @JsonProperty(value = "image", required = true)
    private LoadBalancerInstanceImage image;

    @JsonProperty("image")
    public LoadBalancerInstanceImage getImage() {
      return image;
    }

    /** Base64-encoded cloud-init user-data supplied at launch. */
    @JsonProperty(value = "user_data", required = false)
    private String user_data;

    @JsonProperty("user_data")
    public String getUserData() {
      return user_data;
    }

    /**
     * Attached IAM role identity, or null when no role is attached. Deleted roles retain their
     * identity without name.
     */
    @JsonProperty(value = "iam_role", required = true)
    private LoadBalancerInstanceIamRole iam_role;

    @JsonProperty("iam_role")
    public LoadBalancerInstanceIamRole getIamRole() {
      return iam_role;
    }

    @JsonProperty(value = "metadata", required = false)
    private Map<String, String> metadata;

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
      return metadata;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    /**
     * Active faults ordered by last_at descending, then internal history id descending for a stable
     * tie-breaker. Healthy resources return [].
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }

    @JsonProperty(value = "launched_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> launched_at = JsonField.missing();

    @JsonProperty("launched_at")
    public JsonField<String> getLaunchedAt() {
      return launched_at;
    }

    @JsonProperty(value = "terminated_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> terminated_at = JsonField.missing();

    @JsonProperty("terminated_at")
    public JsonField<String> getTerminatedAt() {
      return terminated_at;
    }

    /**
     * What was asked for. Only three values, because there are only three things you can ask an
     * instance to be: Create/Start/Reboot ask for running, Stop for stopped, Delete for deleted.
     */
    @JsonProperty(value = "desired_state", required = true)
    private LoadBalancerInstanceDesiredState desired_state;

    @JsonProperty("desired_state")
    public LoadBalancerInstanceDesiredState getDesiredState() {
      return desired_state;
    }

    /**
     * Where the instance actually is. Read this one to answer "is it up" — the transitional states
     * live here, not on desired_state, because nobody asks for `stopping`. desired_state=running
     * with current_state=stopped is an instance that was asked to start and has not come up yet.
     */
    @JsonProperty(value = "current_state", required = true)
    private CurrentState current_state;

    @JsonProperty("current_state")
    public CurrentState getCurrentState() {
      return current_state;
    }

    @JsonProperty(value = "retirement", required = false)
    private Retirement retirement;

    @JsonProperty("retirement")
    public Retirement getRetirement() {
      return retirement;
    }

    /**
     * Proxy health: initializing before the first report, healthy when the last report says the
     * proxy is serving, unhealthy when it is down, and draining when the instance is retiring. See
     * last_seen for the age of the last observation.
     */
    @JsonProperty(value = "status", required = true)
    private LoadBalancerInstanceStatus status;

    @JsonProperty("status")
    public LoadBalancerInstanceStatus getStatus() {
      return status;
    }

    /** Whether the proxy reported ready at the last health report */
    @JsonProperty(value = "proxy_ok", required = true)
    private Boolean proxy_ok;

    @JsonProperty("proxy_ok")
    public Boolean getProxyOk() {
      return proxy_ok;
    }

    @JsonProperty(value = "agent_version", required = false)
    private String agent_version;

    @JsonProperty("agent_version")
    public String getAgentVersion() {
      return agent_version;
    }

    /** Omitted when this instance has not reported yet */
    @JsonProperty(value = "last_seen", required = false)
    private String last_seen;

    @JsonProperty("last_seen")
    public String getLastSeen() {
      return last_seen;
    }
  }

  public static final class LoadBalancerInstanceImage {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LoadBalancerInstanceImage(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "LoadBalancerInstanceImage{[REDACTED]}";
    }

    public static LoadBalancerInstanceImage ofVariant1(ResourceRef value) {
      Model.validate(value);
      return new LoadBalancerInstanceImage(Json.tree(value));
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

    public static LoadBalancerInstanceImage ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new LoadBalancerInstanceImage(Json.tree(value));
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

  public static final class LoadBalancerInstanceIamRole {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LoadBalancerInstanceIamRole(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "LoadBalancerInstanceIamRole{[REDACTED]}";
    }

    public static LoadBalancerInstanceIamRole ofVariant1(ResourceRef value) {
      Model.validate(value);
      return new LoadBalancerInstanceIamRole(Json.tree(value));
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

    public static LoadBalancerInstanceIamRole ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new LoadBalancerInstanceIamRole(Json.tree(value));
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

  public static final class LoadBalancerInstanceDesiredState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LoadBalancerInstanceDesiredState(String value) {
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
      return other instanceof LoadBalancerInstanceDesiredState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LoadBalancerInstanceDesiredState RUNNING =
        new LoadBalancerInstanceDesiredState("running");
    public static final LoadBalancerInstanceDesiredState STOPPED =
        new LoadBalancerInstanceDesiredState("stopped");
    public static final LoadBalancerInstanceDesiredState DELETED =
        new LoadBalancerInstanceDesiredState("deleted");
  }

  public static final class CurrentState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CurrentState(String value) {
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
      return other instanceof CurrentState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CurrentState PENDING = new CurrentState("pending");
    public static final CurrentState BUILDING = new CurrentState("building");
    public static final CurrentState RUNNING = new CurrentState("running");
    public static final CurrentState STOPPING = new CurrentState("stopping");
    public static final CurrentState STOPPED = new CurrentState("stopped");
    public static final CurrentState REBOOTING = new CurrentState("rebooting");
    public static final CurrentState MIGRATING = new CurrentState("migrating");
    public static final CurrentState DELETING = new CurrentState("deleting");
    public static final CurrentState DELETED = new CurrentState("deleted");
    public static final CurrentState ERROR = new CurrentState("error");
    public static final CurrentState CRASHED = new CurrentState("crashed");
    public static final CurrentState PAUSED = new CurrentState("paused");
    public static final CurrentState SUSPENDED = new CurrentState("suspended");
  }

  public static final class Retirement extends Model {
    public Retirement() {}

    @JsonProperty(value = "requested_at", required = true)
    private String requested_at;

    @JsonProperty("requested_at")
    public String getRequestedAt() {
      return requested_at;
    }

    @JsonProperty(value = "drain_seconds", required = true)
    private Long drain_seconds;

    @JsonProperty("drain_seconds")
    public Long getDrainSeconds() {
      return drain_seconds;
    }

    @JsonProperty(value = "agent_acknowledged_at", required = false)
    private String agent_acknowledged_at;

    @JsonProperty("agent_acknowledged_at")
    public String getAgentAcknowledgedAt() {
      return agent_acknowledged_at;
    }

    /** Earliest deletion time; absent while withdrawal is pending. */
    @JsonProperty(value = "drain_until", required = false)
    private String drain_until;

    @JsonProperty("drain_until")
    public String getDrainUntil() {
      return drain_until;
    }
  }

  public static final class LoadBalancerInstanceStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LoadBalancerInstanceStatus(String value) {
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
      return other instanceof LoadBalancerInstanceStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LoadBalancerInstanceStatus INITIALIZING =
        new LoadBalancerInstanceStatus("initializing");
    public static final LoadBalancerInstanceStatus HEALTHY =
        new LoadBalancerInstanceStatus("healthy");
    public static final LoadBalancerInstanceStatus UNHEALTHY =
        new LoadBalancerInstanceStatus("unhealthy");
    public static final LoadBalancerInstanceStatus DRAINING =
        new LoadBalancerInstanceStatus("draining");
  }

  public static final class ListLoadBalancersQuery extends Model {
    public ListLoadBalancersQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListLoadBalancersQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListLoadBalancersQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private ListLoadBalancersQueryStatus status;

    @JsonProperty("status")
    public ListLoadBalancersQueryStatus getStatus() {
      return status;
    }

    public ListLoadBalancersQuery withStatus(ListLoadBalancersQueryStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListLoadBalancersQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListLoadBalancersQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ListLoadBalancersQueryStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListLoadBalancersQueryStatus(String value) {
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
      return other instanceof ListLoadBalancersQueryStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListLoadBalancersQueryStatus PROVISIONING =
        new ListLoadBalancersQueryStatus("provisioning");
    public static final ListLoadBalancersQueryStatus ACTIVE =
        new ListLoadBalancersQueryStatus("active");
    public static final ListLoadBalancersQueryStatus ERROR =
        new ListLoadBalancersQueryStatus("error");
    public static final ListLoadBalancersQueryStatus DELETING =
        new ListLoadBalancersQueryStatus("deleting");
  }

  public static final class LoadBalancerListResponse extends Model {
    public LoadBalancerListResponse() {}

    @JsonProperty(value = "load_balancers", required = true)
    private List<LoadBalancer> load_balancers;

    @JsonProperty("load_balancers")
    public List<LoadBalancer> getLoadBalancers() {
      return load_balancers;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListRulesQuery extends Model {
    public ListRulesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRulesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRulesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class RuleListResponse extends Model {
    public RuleListResponse() {}

    @JsonProperty(value = "rules", required = true)
    private List<Rule> rules;

    @JsonProperty("rules")
    public List<Rule> getRules() {
      return rules;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListTargetGroupsQuery extends Model {
    public ListTargetGroupsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListTargetGroupsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListTargetGroupsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "protocol", required = false)
    private ListTargetGroupsQueryProtocol protocol;

    @JsonProperty("protocol")
    public ListTargetGroupsQueryProtocol getProtocol() {
      return protocol;
    }

    public ListTargetGroupsQuery withProtocol(ListTargetGroupsQueryProtocol value) {
      this.protocol = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListTargetGroupsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListTargetGroupsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ListTargetGroupsQueryProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListTargetGroupsQueryProtocol(String value) {
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
      return other instanceof ListTargetGroupsQueryProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListTargetGroupsQueryProtocol HTTP =
        new ListTargetGroupsQueryProtocol("http");
    public static final ListTargetGroupsQueryProtocol HTTPS =
        new ListTargetGroupsQueryProtocol("https");
    public static final ListTargetGroupsQueryProtocol TCP =
        new ListTargetGroupsQueryProtocol("tcp");
    public static final ListTargetGroupsQueryProtocol UDP =
        new ListTargetGroupsQueryProtocol("udp");
  }

  public static final class TargetGroupListResponse extends Model {
    public TargetGroupListResponse() {}

    @JsonProperty(value = "target_groups", required = true)
    private List<TargetGroup> target_groups;

    @JsonProperty("target_groups")
    public List<TargetGroup> getTargetGroups() {
      return target_groups;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListTargetsQuery extends Model {
    public ListTargetsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListTargetsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListTargetsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class TargetListResponse extends Model {
    public TargetListResponse() {}

    @JsonProperty(value = "targets", required = true)
    private List<Target> targets;

    @JsonProperty("targets")
    public List<Target> getTargets() {
      return targets;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class UpdateListenerRequestInput extends Model {
    public UpdateListenerRequestInput() {}

    /**
     * UUID, CRN or exact account-scoped target group name. Null clears the default; omission leaves
     * it unchanged.
     */
    @JsonProperty(value = "default_target_group", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> default_target_group = JsonField.missing();

    @JsonProperty("default_target_group")
    public JsonField<String> getDefaultTargetGroup() {
      return default_target_group;
    }

    public UpdateListenerRequestInput withDefaultTargetGroup(JsonField<String> value) {
      this.default_target_group = value;
      return this;
    }

    /** Mutate which addresses are bound. Omit to leave unchanged. */
    @JsonProperty(value = "exposure", required = false)
    private UpdateListenerRequestInputExposure exposure;

    @JsonProperty("exposure")
    public UpdateListenerRequestInputExposure getExposure() {
      return exposure;
    }

    public UpdateListenerRequestInput withExposure(UpdateListenerRequestInputExposure value) {
      this.exposure = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateListenerRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * UUID, CRN, or exact name of a certificate already attached to this listener. Makes it the
     * default and demotes the previous default atomically. Does not attach new certificates.
     */
    @JsonProperty(value = "default_certificate", required = false)
    private String default_certificate;

    @JsonProperty("default_certificate")
    public String getDefaultCertificate() {
      return default_certificate;
    }

    public UpdateListenerRequestInput withDefaultCertificate(String value) {
      this.default_certificate = value;
      return this;
    }
  }

  public static final class UpdateListenerRequestInputExposure {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UpdateListenerRequestInputExposure(String value) {
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
      return other instanceof UpdateListenerRequestInputExposure v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final UpdateListenerRequestInputExposure PUBLIC_ONLY =
        new UpdateListenerRequestInputExposure("public_only");
    public static final UpdateListenerRequestInputExposure PRIVATE_ONLY =
        new UpdateListenerRequestInputExposure("private_only");
    public static final UpdateListenerRequestInputExposure BOTH =
        new UpdateListenerRequestInputExposure("both");
  }

  public static final class UpdateLoadBalancerRequestInput extends Model {
    public UpdateLoadBalancerRequestInput() {}

    /** Steady target within min_count and max_count. */
    @JsonProperty(value = "desired_count", required = false)
    private Long desired_count;

    @JsonProperty("desired_count")
    public Long getDesiredCount() {
      return desired_count;
    }

    public UpdateLoadBalancerRequestInput withDesiredCount(Long value) {
      this.desired_count = value;
      return this;
    }

    /** Lower capacity bound. */
    @JsonProperty(value = "min_count", required = false)
    private Long min_count;

    @JsonProperty("min_count")
    public Long getMinCount() {
      return min_count;
    }

    public UpdateLoadBalancerRequestInput withMinCount(Long value) {
      this.min_count = value;
      return this;
    }

    /** Upper capacity bound including rollout surge. */
    @JsonProperty(value = "max_count", required = false)
    private Long max_count;

    @JsonProperty("max_count")
    public Long getMaxCount() {
      return max_count;
    }

    public UpdateLoadBalancerRequestInput withMaxCount(Long value) {
      this.max_count = value;
      return this;
    }

    @JsonProperty(value = "autoscaling", required = false)
    private AutoscalingPolicyInput autoscaling;

    @JsonProperty("autoscaling")
    public AutoscalingPolicyInput getAutoscaling() {
      return autoscaling;
    }

    public UpdateLoadBalancerRequestInput withAutoscaling(AutoscalingPolicyInput value) {
      this.autoscaling = value;
      return this;
    }

    /**
     * Deprecated alias of desired_count; send only one. Bounds are preserved. With desired_count
     * omitted, it is clamped into the resulting bounds. Scale-in withdraws and drains members
     * before deletion.
     */
    @JsonProperty(value = "replica_count", required = false)
    private Long replica_count;

    @JsonProperty("replica_count")
    public Long getReplicaCount() {
      return replica_count;
    }

    public UpdateLoadBalancerRequestInput withReplicaCount(Long value) {
      this.replica_count = value;
      return this;
    }

    /**
     * Resize each replica to a different compute flavor. Must be a loadbalancer-family flavor. A
     * running instance cannot change size in place, so the request records the new size and
     * returns; the replicas already up are then replaced one at a time in the background. The load
     * balancer temporarily runs one replica over desired_count, within max_count while it does: the
     * extra replica comes up on the new flavor and starts serving before any replica on the old one
     * is retired, so the number serving never drops below desired_count — a resize does not cost
     * you capacity, at any replica count. Expect it to take several minutes, and poll GET
     * /v1/load-balancers/{id}/instances to watch: a replica has been replaced when its id changes,
     * and the resize is done when every flavor.id there matches the requested flavor. A resize
     * requires max_count above desired_count for surge headroom. A rollout waits if headroom is
     * removed while it is in progress. Rejected up front if the account does not have the compute
     * quota for the replacement replica, so a resize cannot half-apply and leave the load balancer
     * short.
     */
    @JsonProperty(value = "flavor", required = false)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public UpdateLoadBalancerRequestInput withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateLoadBalancerRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UpdateRuleRequestInput extends Model {
    public UpdateRuleRequestInput() {}

    @JsonProperty(value = "priority", required = true)
    private Long priority;

    @JsonProperty("priority")
    public Long getPriority() {
      return priority;
    }

    public UpdateRuleRequestInput withPriority(Long value) {
      this.priority = value;
      return this;
    }

    @JsonProperty(value = "conditions", required = true)
    private List<RuleConditionInput> conditions;

    @JsonProperty("conditions")
    public List<RuleConditionInput> getConditions() {
      return conditions;
    }

    public UpdateRuleRequestInput withConditions(List<RuleConditionInput> value) {
      this.conditions = value;
      return this;
    }

    @JsonProperty(value = "target_group", required = true)
    private String target_group;

    @JsonProperty("target_group")
    public String getTargetGroup() {
      return target_group;
    }

    public UpdateRuleRequestInput withTargetGroup(String value) {
      this.target_group = value;
      return this;
    }
  }

  public static final class UpdateTargetGroupRequestInput extends Model {
    public UpdateTargetGroupRequestInput() {}

    @JsonProperty(value = "health_check", required = false)
    private HealthCheckPatchInput health_check;

    @JsonProperty("health_check")
    public HealthCheckPatchInput getHealthCheck() {
      return health_check;
    }

    public UpdateTargetGroupRequestInput withHealthCheck(HealthCheckPatchInput value) {
      this.health_check = value;
      return this;
    }

    /**
     * Toggle PROXY v2 framing on upstream connections. Omitting the field leaves the current
     * setting; setting true/false flips it explicitly.
     */
    @JsonProperty(value = "proxy_protocol", required = false)
    private Boolean proxy_protocol;

    @JsonProperty("proxy_protocol")
    public Boolean getProxyProtocol() {
      return proxy_protocol;
    }

    public UpdateTargetGroupRequestInput withProxyProtocol(Boolean value) {
      this.proxy_protocol = value;
      return this;
    }

    /**
     * Replaces the stickiness config. Omitting the field leaves it alone; turning it off is an
     * explicit `{"type": "none"}`.
     */
    @JsonProperty(value = "session_affinity", required = false)
    private SessionAffinityInput session_affinity;

    @JsonProperty("session_affinity")
    public SessionAffinityInput getSessionAffinity() {
      return session_affinity;
    }

    public UpdateTargetGroupRequestInput withSessionAffinity(SessionAffinityInput value) {
      this.session_affinity = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateTargetGroupRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class HealthCheckPatchInput extends Model {
    public HealthCheckPatchInput() {}

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public HealthCheckPatchInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    @JsonProperty(value = "protocol", required = false)
    private ProtocolInput protocol;

    @JsonProperty("protocol")
    public ProtocolInput getProtocol() {
      return protocol;
    }

    public HealthCheckPatchInput withProtocol(ProtocolInput value) {
      this.protocol = value;
      return this;
    }

    @JsonProperty(value = "path", required = false)
    private String path;

    @JsonProperty("path")
    public String getPath() {
      return path;
    }

    public HealthCheckPatchInput withPath(String value) {
      this.path = value;
      return this;
    }

    /** Zero removes the probe port override. */
    @JsonProperty(value = "port", required = false)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    public HealthCheckPatchInput withPort(Long value) {
      this.port = value;
      return this;
    }

    @JsonProperty(value = "interval_sec", required = false)
    private Long interval_sec;

    @JsonProperty("interval_sec")
    public Long getIntervalSec() {
      return interval_sec;
    }

    public HealthCheckPatchInput withIntervalSec(Long value) {
      this.interval_sec = value;
      return this;
    }

    @JsonProperty(value = "timeout_sec", required = false)
    private Long timeout_sec;

    @JsonProperty("timeout_sec")
    public Long getTimeoutSec() {
      return timeout_sec;
    }

    public HealthCheckPatchInput withTimeoutSec(Long value) {
      this.timeout_sec = value;
      return this;
    }

    @JsonProperty(value = "healthy_threshold", required = false)
    private Long healthy_threshold;

    @JsonProperty("healthy_threshold")
    public Long getHealthyThreshold() {
      return healthy_threshold;
    }

    public HealthCheckPatchInput withHealthyThreshold(Long value) {
      this.healthy_threshold = value;
      return this;
    }

    @JsonProperty(value = "unhealthy_threshold", required = false)
    private Long unhealthy_threshold;

    @JsonProperty("unhealthy_threshold")
    public Long getUnhealthyThreshold() {
      return unhealthy_threshold;
    }

    public HealthCheckPatchInput withUnhealthyThreshold(Long value) {
      this.unhealthy_threshold = value;
      return this;
    }

    @JsonProperty(value = "matcher", required = false)
    private String matcher;

    @JsonProperty("matcher")
    public String getMatcher() {
      return matcher;
    }

    public HealthCheckPatchInput withMatcher(String value) {
      this.matcher = value;
      return this;
    }
  }

  public static final class ProtocolInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ProtocolInput(String value) {
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
      return other instanceof ProtocolInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ProtocolInput HTTP = new ProtocolInput("http");
    public static final ProtocolInput HTTPS = new ProtocolInput("https");
    public static final ProtocolInput TCP = new ProtocolInput("tcp");
    public static final ProtocolInput UDP = new ProtocolInput("udp");
    public static final ProtocolInput VALUE = new ProtocolInput("");
  }
}
