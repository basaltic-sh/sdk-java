package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed network wire models. Unknown string enum values are retained. */
public final class Network {

  private Network() {}

  public static final class AttachFloatingIpBody extends Model {
    public AttachFloatingIpBody() {}

    /** Interface UUID or nested CRN. Bare names have no subnet scope and are rejected. */
    @JsonProperty(value = "interface", required = true)
    private String interfaceValue;

    @JsonProperty("interface")
    public String getInterfaceValue() {
      return interfaceValue;
    }

    public AttachFloatingIpBody withInterfaceValue(String value) {
      this.interfaceValue = value;
      return this;
    }

    @JsonProperty(value = "address_id", required = true)
    private String address_id;

    @JsonProperty("address_id")
    public String getAddressId() {
      return address_id;
    }

    public AttachFloatingIpBody withAddressId(String value) {
      this.address_id = value;
      return this;
    }
  }

  public static final class AttachFloatingIpResponse extends Model {
    public AttachFloatingIpResponse() {}

    @JsonProperty(value = "floating_ip", required = false)
    private FloatingIp floating_ip;

    @JsonProperty("floating_ip")
    public FloatingIp getFloatingIp() {
      return floating_ip;
    }
  }

  public static final class FloatingIp extends Model {
    public FloatingIp() {}

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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "family", required = true)
    private IpFamily family;

    @JsonProperty("family")
    public IpFamily getFamily() {
      return family;
    }

    /**
     * Canonical CRN of the bound interface, instance pool, or load balancer; null when unattached.
     * A pool-owned address names its pool even when the pool has zero members. Only pool-owned
     * addresses may have multiple NIC members. Manage their bindings through the instance pool
     * floating IP endpoints; direct attach and detach are refused.
     */
    @JsonProperty(value = "attached_to", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> attached_to = JsonField.missing();

    @JsonProperty("attached_to")
    public JsonField<String> getAttachedTo() {
      return attached_to;
    }

    /**
     * The floating IP's bindings. A floating IP fronts 0 members (allocated, unattached), 1 member
     * (the everyday case), or N members for an instance pool — an anycast floating IP, where one
     * public IP is delivered to N VM NICs across hosts (each advertised as a /32 from the host
     * holding it). Members may share a hypervisor. Two of them on one host used to mean one served
     * and the other was silently dark; a member's forwarding rule now names the member, and the
     * host splits connections across the members it holds, so where the members sit is a capacity
     * decision rather than a correctness one. An instance pool's address takes its members from the
     * pool's live replicas — every one of them — so a scale-out joins and a scale-in leaves without
     * a per-replica attach. With more than one member ONE member serves each connection, chosen by
     * hashing the flow's addresses and ports, and every packet of that connection goes to the same
     * one. The members are separate instances that share nothing, so this spreads connections and
     * survives the loss of a host — it is not a load balancer: nothing checks whether the service
     * inside the instance is up, and connections in progress to a member that goes away are not
     * moved, they end. A POOL's address is the exception, and only for booting. A replica joins the
     * address as soon as it is placed, but does not receive traffic until it has reached the
     * instance metadata service — evidence that the guest booted, rather than that its virtual
     * machine was started. Until then it is a member with `health` `unhealthy`. A replica whose
     * image never contacts the metadata service is admitted anyway after a few minutes, so an
     * unusual image delays traffic rather than never getting it.
     */
    @JsonProperty(value = "members", required = true)
    private List<FloatingIpMember> members;

    @JsonProperty("members")
    public List<FloatingIpMember> getMembers() {
      return members;
    }

    @JsonProperty(value = "tags", required = true)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    /**
     * The readiness check applied to this address's members. Absent when none is configured. See
     * `FloatingIpHealthCheck`.
     */
    @JsonProperty(value = "health_check", required = false)
    private FloatingIpHealthCheck health_check;

    @JsonProperty("health_check")
    public FloatingIpHealthCheck getHealthCheck() {
      return health_check;
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

    /** Allocated public or private address. */
    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    @JsonProperty(value = "visibility", required = true)
    private FloatingIpVisibility visibility;

    @JsonProperty("visibility")
    public FloatingIpVisibility getVisibility() {
      return visibility;
    }

    /** Allocation subnet for private floating IPs. */
    @JsonProperty(value = "subnet_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> subnet_id = JsonField.missing();

    @JsonProperty("subnet_id")
    public JsonField<String> getSubnetId() {
      return subnet_id;
    }

    /** Allocation VPC for private floating IPs. */
    @JsonProperty(value = "vpc_id", required = false)
    private String vpc_id;

    @JsonProperty("vpc_id")
    public String getVpcId() {
      return vpc_id;
    }
  }

  public static final class IpFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public IpFamily(String value) {
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
      return other instanceof IpFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final IpFamily IPV4 = new IpFamily("ipv4");
    public static final IpFamily IPV6 = new IpFamily("ipv6");
  }

  public static final class FloatingIpMember extends Model {
    public FloatingIpMember() {}

    /** Bound NIC summary; null for a load balancer binding named by attached_to. */
    @JsonProperty(value = "interface", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<FloatingIpMemberInterface> interfaceValue = JsonField.missing();

    @JsonProperty("interface")
    public JsonField<FloatingIpMemberInterface> getInterfaceValue() {
      return interfaceValue;
    }

    /**
     * What the platform knows about this member. `unknown` — nobody is checking. A member you
     * attached yourself with no health check on the address reads this: you chose the moment of
     * attach, and the platform has no signal about what runs inside the instance. It is advertised.
     * `healthy` — the platform has evidence this member is up (and, if a health check is configured
     * on the address, that the check is passing). `unhealthy` — the platform is waiting for that
     * evidence and has not seen it, or a configured check is failing. The member keeps its place on
     * the address and receives no traffic until it recovers. Without a health check this is
     * liveness only — `healthy` means the guest came up, not that your service is listening.
     * Configure `health_check` on the floating IP to add readiness on top of that.
     */
    @JsonProperty(value = "health", required = true)
    private FloatingIpMemberHealth health;

    @JsonProperty("health")
    public FloatingIpMemberHealth getHealth() {
      return health;
    }

    /**
     * Why the member reads the `health` it does — so you can tell "your service is not answering"
     * from "the guest has not booted yet". `unprobed` — nobody is checking (no health check,
     * hand-attached). `booting` — the platform has not yet seen the guest come up. `probe_failed` —
     * the configured health check is failing. `passing` — the guest is up and, if a check is
     * configured, it passes.
     */
    @JsonProperty(value = "reason", required = true)
    private FloatingIpMemberReason reason;

    @JsonProperty("reason")
    public FloatingIpMemberReason getReason() {
      return reason;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    /** Target child address on the member interface. */
    @JsonProperty(value = "address_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> address_id = JsonField.missing();

    @JsonProperty("address_id")
    public JsonField<String> getAddressId() {
      return address_id;
    }
  }

  public static final class FloatingIpMemberInterface extends Model {
    public FloatingIpMemberInterface() {}

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

    /** Owning instance; null when the interface has no owning instance. */
    @JsonProperty(value = "instance", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<FloatingIpMemberInterfaceInstance> instance = JsonField.missing();

    @JsonProperty("instance")
    public JsonField<FloatingIpMemberInterfaceInstance> getInstance() {
      return instance;
    }
  }

  public static final class FloatingIpMemberInterfaceInstance extends Model {
    public FloatingIpMemberInterfaceInstance() {}

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
  }

  public static final class FloatingIpMemberHealth {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FloatingIpMemberHealth(String value) {
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
      return other instanceof FloatingIpMemberHealth v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FloatingIpMemberHealth UNKNOWN = new FloatingIpMemberHealth("unknown");
    public static final FloatingIpMemberHealth HEALTHY = new FloatingIpMemberHealth("healthy");
    public static final FloatingIpMemberHealth UNHEALTHY = new FloatingIpMemberHealth("unhealthy");
  }

  public static final class FloatingIpMemberReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FloatingIpMemberReason(String value) {
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
      return other instanceof FloatingIpMemberReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FloatingIpMemberReason UNPROBED = new FloatingIpMemberReason("unprobed");
    public static final FloatingIpMemberReason BOOTING = new FloatingIpMemberReason("booting");
    public static final FloatingIpMemberReason PROBE_FAILED =
        new FloatingIpMemberReason("probe_failed");
    public static final FloatingIpMemberReason PASSING = new FloatingIpMemberReason("passing");
  }

  public static final class FloatingIpHealthCheck extends Model {
    public FloatingIpHealthCheck() {}

    /**
     * `tcp` opens a connection; `http`/`https` issue a GET and match the status against `matcher`.
     * There is no `udp`: a readiness probe needs an answer — check a udp service on a tcp health
     * port instead.
     */
    @JsonProperty(value = "protocol", required = true)
    private FloatingIpHealthCheckProtocol protocol;

    @JsonProperty("protocol")
    public FloatingIpHealthCheckProtocol getProtocol() {
      return protocol;
    }

    /** HTTP path probed; ignored for tcp. */
    @JsonProperty(value = "path", required = false)
    private String path;

    @JsonProperty("path")
    public String getPath() {
      return path;
    }

    /** Port probed on the member. */
    @JsonProperty(value = "port", required = true)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    @JsonProperty(value = "interval_sec", required = true)
    private Long interval_sec;

    @JsonProperty("interval_sec")
    public Long getIntervalSec() {
      return interval_sec;
    }

    /** Per-probe timeout; must be less than interval_sec. */
    @JsonProperty(value = "timeout_sec", required = true)
    private Long timeout_sec;

    @JsonProperty("timeout_sec")
    public Long getTimeoutSec() {
      return timeout_sec;
    }

    /** Consecutive passes before a member flips healthy. */
    @JsonProperty(value = "healthy_threshold", required = true)
    private Long healthy_threshold;

    @JsonProperty("healthy_threshold")
    public Long getHealthyThreshold() {
      return healthy_threshold;
    }

    /** Consecutive failures before a member flips unhealthy. */
    @JsonProperty(value = "unhealthy_threshold", required = true)
    private Long unhealthy_threshold;

    @JsonProperty("unhealthy_threshold")
    public Long getUnhealthyThreshold() {
      return unhealthy_threshold;
    }

    /** HTTP status or range that counts as passing; ignored for tcp. */
    @JsonProperty(value = "matcher", required = false)
    private String matcher;

    @JsonProperty("matcher")
    public String getMatcher() {
      return matcher;
    }
  }

  public static final class FloatingIpHealthCheckProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FloatingIpHealthCheckProtocol(String value) {
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
      return other instanceof FloatingIpHealthCheckProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FloatingIpHealthCheckProtocol TCP =
        new FloatingIpHealthCheckProtocol("tcp");
    public static final FloatingIpHealthCheckProtocol HTTP =
        new FloatingIpHealthCheckProtocol("http");
    public static final FloatingIpHealthCheckProtocol HTTPS =
        new FloatingIpHealthCheckProtocol("https");
  }

  public static final class FloatingIpVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FloatingIpVisibility(String value) {
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
      return other instanceof FloatingIpVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FloatingIpVisibility PUBLIC = new FloatingIpVisibility("public");
    public static final FloatingIpVisibility PRIVATE = new FloatingIpVisibility("private");
  }

  public static final class InternetGatewayAttachRequestInput extends Model {
    public InternetGatewayAttachRequestInput() {}

    /** VPC UUID, CRN or exact name in the caller account. */
    @JsonProperty(value = "vpc", required = true)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public InternetGatewayAttachRequestInput withVpc(String value) {
      this.vpc = value;
      return this;
    }
  }

  public static final class InternetGatewayResponse extends Model {
    public InternetGatewayResponse() {}

    @JsonProperty(value = "internet_gateway", required = false)
    private InternetGateway internet_gateway;

    @JsonProperty("internet_gateway")
    public InternetGateway getInternetGateway() {
      return internet_gateway;
    }
  }

  public static final class InternetGateway extends Model {
    public InternetGateway() {}

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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    /** VPC the IGW is currently attached to (null when detached). */
    @JsonProperty(value = "attached_vpc_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> attached_vpc_id = JsonField.missing();

    @JsonProperty("attached_vpc_id")
    public JsonField<String> getAttachedVpcId() {
      return attached_vpc_id;
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

  public static final class EgressOnlyGatewayCreateRequestInput extends Model {
    public EgressOnlyGatewayCreateRequestInput() {}

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

    public EgressOnlyGatewayCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public EgressOnlyGatewayCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /** VPC UUID, CRN or exact name in the caller account. */
    @JsonProperty(value = "vpc", required = true)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public EgressOnlyGatewayCreateRequestInput withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public EgressOnlyGatewayCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class EgressOnlyGatewayResponse extends Model {
    public EgressOnlyGatewayResponse() {}

    @JsonProperty(value = "egress_only_gateway", required = false)
    private EgressOnlyGateway egress_only_gateway;

    @JsonProperty("egress_only_gateway")
    public EgressOnlyGateway getEgressOnlyGateway() {
      return egress_only_gateway;
    }
  }

  public static final class EgressOnlyGateway extends Model {
    public EgressOnlyGateway() {}

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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "vpc", required = true)
    private Vpc vpc;

    @JsonProperty("vpc")
    public Vpc getVpc() {
      return vpc;
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

  public static final class Vpc extends Model {
    public Vpc() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name (name-based, region+account-scoped). */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * 1-63 chars, lowercase alphanumeric + hyphen Resource names must not start with the literal
     * crn: prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
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

    /**
     * IPv4 CIDR block carved up by subnets. Must be private (RFC 1918): within 10.0.0.0/8,
     * 172.16.0.0/12 or 192.168.0.0/16. Immutable after create.
     */
    @JsonProperty(value = "cidr_ipv4", required = true)
    private String cidr_ipv4;

    @JsonProperty("cidr_ipv4")
    public String getCidrIpv4() {
      return cidr_ipv4;
    }

    /** Associated regional GUA or private ULA prefix. */
    @JsonProperty(value = "cidr_ipv6", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cidr_ipv6 = JsonField.missing();

    @JsonProperty("cidr_ipv6")
    public JsonField<String> getCidrIpv6() {
      return cidr_ipv6;
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

  public static final class FloatingIpCreateRequestInput extends Model {
    public FloatingIpCreateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public FloatingIpCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * Which family to allocate in. Fixed for the life of the address — it decides the pool the
     * address comes from, the quota it counts against (`floating_ips_v4` or `floating_ips_v6`) and
     * the SKU it bills as. Omitted means `ipv4`.
     */
    @JsonProperty(value = "family", required = false)
    private IpFamilyInput family;

    @JsonProperty("family")
    public IpFamilyInput getFamily() {
      return family;
    }

    public FloatingIpCreateRequestInput withFamily(IpFamilyInput value) {
      this.family = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public FloatingIpCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * An optional readiness check for the address's members. Omitted means none — the address
     * behaves exactly as an ordinary floating IP.
     */
    @JsonProperty(value = "health_check", required = false)
    private FloatingIpHealthCheckInput health_check;

    @JsonProperty("health_check")
    public FloatingIpHealthCheckInput getHealthCheck() {
      return health_check;
    }

    public FloatingIpCreateRequestInput withHealthCheck(FloatingIpHealthCheckInput value) {
      this.health_check = value;
      return this;
    }

    @JsonProperty(value = "visibility", required = false)
    private FloatingIpCreateRequestInputVisibility visibility;

    @JsonProperty("visibility")
    public FloatingIpCreateRequestInputVisibility getVisibility() {
      return visibility;
    }

    public FloatingIpCreateRequestInput withVisibility(
        FloatingIpCreateRequestInputVisibility value) {
      this.visibility = value;
      return this;
    }

    /**
     * Required for private floating IPs; subnet UUID or CRN in this account. Targets may be in
     * other subnets of the same VPC.
     */
    @JsonProperty(value = "subnet", required = false)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public FloatingIpCreateRequestInput withSubnet(String value) {
      this.subnet = value;
      return this;
    }
  }

  public static final class IpFamilyInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public IpFamilyInput(String value) {
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
      return other instanceof IpFamilyInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final IpFamilyInput IPV4 = new IpFamilyInput("ipv4");
    public static final IpFamilyInput IPV6 = new IpFamilyInput("ipv6");
  }

  public static final class FloatingIpHealthCheckInput extends Model {
    public FloatingIpHealthCheckInput() {}

    /**
     * `tcp` opens a connection; `http`/`https` issue a GET and match the status against `matcher`.
     * There is no `udp`: a readiness probe needs an answer — check a udp service on a tcp health
     * port instead.
     */
    @JsonProperty(value = "protocol", required = true)
    private FloatingIpHealthCheckInputProtocol protocol;

    @JsonProperty("protocol")
    public FloatingIpHealthCheckInputProtocol getProtocol() {
      return protocol;
    }

    public FloatingIpHealthCheckInput withProtocol(FloatingIpHealthCheckInputProtocol value) {
      this.protocol = value;
      return this;
    }

    /** HTTP path probed; ignored for tcp. */
    @JsonProperty(value = "path", required = false)
    private String path;

    @JsonProperty("path")
    public String getPath() {
      return path;
    }

    public FloatingIpHealthCheckInput withPath(String value) {
      this.path = value;
      return this;
    }

    /** Port probed on the member. */
    @JsonProperty(value = "port", required = true)
    private Long port;

    @JsonProperty("port")
    public Long getPort() {
      return port;
    }

    public FloatingIpHealthCheckInput withPort(Long value) {
      this.port = value;
      return this;
    }

    @JsonProperty(value = "interval_sec", required = true)
    private Long interval_sec;

    @JsonProperty("interval_sec")
    public Long getIntervalSec() {
      return interval_sec;
    }

    public FloatingIpHealthCheckInput withIntervalSec(Long value) {
      this.interval_sec = value;
      return this;
    }

    /** Per-probe timeout; must be less than interval_sec. */
    @JsonProperty(value = "timeout_sec", required = true)
    private Long timeout_sec;

    @JsonProperty("timeout_sec")
    public Long getTimeoutSec() {
      return timeout_sec;
    }

    public FloatingIpHealthCheckInput withTimeoutSec(Long value) {
      this.timeout_sec = value;
      return this;
    }

    /** Consecutive passes before a member flips healthy. */
    @JsonProperty(value = "healthy_threshold", required = true)
    private Long healthy_threshold;

    @JsonProperty("healthy_threshold")
    public Long getHealthyThreshold() {
      return healthy_threshold;
    }

    public FloatingIpHealthCheckInput withHealthyThreshold(Long value) {
      this.healthy_threshold = value;
      return this;
    }

    /** Consecutive failures before a member flips unhealthy. */
    @JsonProperty(value = "unhealthy_threshold", required = true)
    private Long unhealthy_threshold;

    @JsonProperty("unhealthy_threshold")
    public Long getUnhealthyThreshold() {
      return unhealthy_threshold;
    }

    public FloatingIpHealthCheckInput withUnhealthyThreshold(Long value) {
      this.unhealthy_threshold = value;
      return this;
    }

    /** HTTP status or range that counts as passing; ignored for tcp. */
    @JsonProperty(value = "matcher", required = false)
    private String matcher;

    @JsonProperty("matcher")
    public String getMatcher() {
      return matcher;
    }

    public FloatingIpHealthCheckInput withMatcher(String value) {
      this.matcher = value;
      return this;
    }
  }

  public static final class FloatingIpHealthCheckInputProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FloatingIpHealthCheckInputProtocol(String value) {
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
      return other instanceof FloatingIpHealthCheckInputProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FloatingIpHealthCheckInputProtocol TCP =
        new FloatingIpHealthCheckInputProtocol("tcp");
    public static final FloatingIpHealthCheckInputProtocol HTTP =
        new FloatingIpHealthCheckInputProtocol("http");
    public static final FloatingIpHealthCheckInputProtocol HTTPS =
        new FloatingIpHealthCheckInputProtocol("https");
  }

  public static final class FloatingIpCreateRequestInputVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FloatingIpCreateRequestInputVisibility(String value) {
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
      return other instanceof FloatingIpCreateRequestInputVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FloatingIpCreateRequestInputVisibility PUBLIC =
        new FloatingIpCreateRequestInputVisibility("public");
    public static final FloatingIpCreateRequestInputVisibility PRIVATE =
        new FloatingIpCreateRequestInputVisibility("private");
  }

  public static final class FloatingIpResponse extends Model {
    public FloatingIpResponse() {}

    @JsonProperty(value = "floating_ip", required = false)
    private FloatingIp floating_ip;

    @JsonProperty("floating_ip")
    public FloatingIp getFloatingIp() {
      return floating_ip;
    }
  }

  public static final class InterfaceCreateRequestInput extends Model {
    public InterfaceCreateRequestInput() {}

    /**
     * Subnet UUID or nested CRN (vpc/&lt;vpc&gt;/subnet/&lt;subnet&gt;). A bare name requires an
     * explicit VPC filter; create requests without a VPC do not accept bare names.
     */
    @JsonProperty(value = "subnet", required = true)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public InterfaceCreateRequestInput withSubnet(String value) {
      this.subnet = value;
      return this;
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

    public InterfaceCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public InterfaceCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /** Defaults to a fresh locally-administered EUI-48 */
    @JsonProperty(value = "mac", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> mac = JsonField.missing();

    @JsonProperty("mac")
    public JsonField<String> getMac() {
      return mac;
    }

    public InterfaceCreateRequestInput withMac(JsonField<String> value) {
      this.mac = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InterfaceCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * Every enabled subnet family is allocated automatically. Entries may request a fixed IPv4
     * address; omitting a family never disables it. At most one entry per family.
     */
    @JsonProperty(value = "addresses", required = false)
    private List<AddressRequestInput> addresses;

    @JsonProperty("addresses")
    public List<AddressRequestInput> getAddresses() {
      return addresses;
    }

    public InterfaceCreateRequestInput withAddresses(List<AddressRequestInput> value) {
      this.addresses = value;
      return this;
    }
  }

  public static final class AddressRequestInput extends Model {
    public AddressRequestInput() {}

    @JsonProperty(value = "family", required = true)
    private AddressRequestInputFamily family;

    @JsonProperty("family")
    public AddressRequestInputFamily getFamily() {
      return family;
    }

    public AddressRequestInput withFamily(AddressRequestInputFamily value) {
      this.family = value;
      return this;
    }

    /**
     * Optional fixed address when creating an interface or instance NIC. For IPv6, use the first
     * address of an aligned /96 inside the subnet /64 (last 32 bits zero); the first and last /96
     * ranges are reserved. Omit for automatic allocation. Managed database nodes and the
     * add-address operation require automatic allocation.
     */
    @JsonProperty(value = "address", required = false)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    public AddressRequestInput withAddress(String value) {
      this.address = value;
      return this;
    }
  }

  public static final class AddressRequestInputFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AddressRequestInputFamily(String value) {
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
      return other instanceof AddressRequestInputFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AddressRequestInputFamily IPV4 = new AddressRequestInputFamily("ipv4");
    public static final AddressRequestInputFamily IPV6 = new AddressRequestInputFamily("ipv6");
  }

  public static final class InterfaceResponse extends Model {
    public InterfaceResponse() {}

    @JsonProperty(value = "interface", required = false)
    private Interface interfaceValue;

    @JsonProperty("interface")
    public Interface getInterfaceValue() {
      return interfaceValue;
    }
  }

  public static final class Interface extends Model {
    public Interface() {}

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

    @JsonProperty(value = "subnet", required = true)
    private Subnet subnet;

    @JsonProperty("subnet")
    public Subnet getSubnet() {
      return subnet;
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

    @JsonProperty(value = "mac", required = true)
    private String mac;

    @JsonProperty("mac")
    public String getMac() {
      return mac;
    }

    /**
     * UUID of the instance holding this interface, including stopped instances. Null when no
     * instance NIC binding exists. Deletion is refused while bound; floating IP attachment is
     * tracked separately.
     */
    @JsonProperty(value = "attached_to", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> attached_to = JsonField.missing();

    @JsonProperty("attached_to")
    public JsonField<String> getAttachedTo() {
      return attached_to;
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

    @JsonProperty(value = "addresses", required = true)
    private List<InterfaceAddress> addresses;

    @JsonProperty("addresses")
    public List<InterfaceAddress> getAddresses() {
      return addresses;
    }

    @JsonProperty(value = "routed_prefixes", required = true)
    private List<RoutedPrefix> routed_prefixes;

    @JsonProperty("routed_prefixes")
    public List<RoutedPrefix> getRoutedPrefixes() {
      return routed_prefixes;
    }
  }

  public static final class Subnet extends Model {
    public Subnet() {}

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

    @JsonProperty(value = "vpc", required = true)
    private Vpc vpc;

    @JsonProperty("vpc")
    public Vpc getVpc() {
      return vpc;
    }

    @JsonProperty(value = "route_table", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<RouteTableSummary> route_table = JsonField.missing();

    @JsonProperty("route_table")
    public JsonField<RouteTableSummary> getRouteTable() {
      return route_table;
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

    @JsonProperty(value = "cidr_ipv4", required = true)
    private String cidr_ipv4;

    @JsonProperty("cidr_ipv4")
    public String getCidrIpv4() {
      return cidr_ipv4;
    }

    @JsonProperty(value = "gateway_ipv4", required = true)
    private String gateway_ipv4;

    @JsonProperty("gateway_ipv4")
    public String getGatewayIpv4() {
      return gateway_ipv4;
    }

    /**
     * The dual-stack IPv6 /64, if the subnet is v6-enabled. Its presence (vs the v4 cidr_ipv4) is
     * how a client tells the subnet's families apart.
     */
    @JsonProperty(value = "cidr_ipv6", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cidr_ipv6 = JsonField.missing();

    @JsonProperty("cidr_ipv6")
    public JsonField<String> getCidrIpv6() {
      return cidr_ipv6;
    }

    @JsonProperty(value = "gateway_ipv6", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> gateway_ipv6 = JsonField.missing();

    @JsonProperty("gateway_ipv6")
    public JsonField<String> getGatewayIpv6() {
      return gateway_ipv6;
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

  public static final class RouteTableSummary extends Model {
    public RouteTableSummary() {}

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
  }

  public static final class InterfaceAddress extends Model {
    public InterfaceAddress() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "family", required = true)
    private InterfaceAddressFamily family;

    @JsonProperty("family")
    public InterfaceAddressFamily getFamily() {
      return family;
    }

    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }

    /**
     * Owned allocation, not the guest netmask: IPv4 /32 or IPv6 /96. DHCPv6 configures the first
     * /128.
     */
    @JsonProperty(value = "prefix", required = true)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }

    @JsonProperty(value = "primary", required = true)
    private Boolean primary;

    @JsonProperty("primary")
    public Boolean getPrimary() {
      return primary;
    }

    @JsonProperty(value = "floating_ips", required = true)
    private List<AddressFloatingIp> floating_ips;

    @JsonProperty("floating_ips")
    public List<AddressFloatingIp> getFloatingIps() {
      return floating_ips;
    }
  }

  public static final class InterfaceAddressFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InterfaceAddressFamily(String value) {
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
      return other instanceof InterfaceAddressFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InterfaceAddressFamily IPV4 = new InterfaceAddressFamily("ipv4");
    public static final InterfaceAddressFamily IPV6 = new InterfaceAddressFamily("ipv6");
  }

  public static final class AddressFloatingIp extends Model {
    public AddressFloatingIp() {}

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
    private AddressFloatingIpVisibility visibility;

    @JsonProperty("visibility")
    public AddressFloatingIpVisibility getVisibility() {
      return visibility;
    }

    @JsonProperty(value = "address", required = true)
    private String address;

    @JsonProperty("address")
    public String getAddress() {
      return address;
    }
  }

  public static final class AddressFloatingIpVisibility {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AddressFloatingIpVisibility(String value) {
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
      return other instanceof AddressFloatingIpVisibility v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AddressFloatingIpVisibility PUBLIC =
        new AddressFloatingIpVisibility("public");
    public static final AddressFloatingIpVisibility PRIVATE =
        new AddressFloatingIpVisibility("private");
  }

  public static final class RoutedPrefix extends Model {
    public RoutedPrefix() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "pool_id", required = true)
    private String pool_id;

    @JsonProperty("pool_id")
    public String getPoolId() {
      return pool_id;
    }

    @JsonProperty(value = "family", required = true)
    private RoutedPrefixFamily family;

    @JsonProperty("family")
    public RoutedPrefixFamily getFamily() {
      return family;
    }

    /** A routed /28 from a VPC prefix pool. */
    @JsonProperty(value = "prefix", required = true)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }
  }

  public static final class RoutedPrefixFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RoutedPrefixFamily(String value) {
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
      return other instanceof RoutedPrefixFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RoutedPrefixFamily IPV4 = new RoutedPrefixFamily("ipv4");
  }

  public static final class CreateInterfaceAddressResponse extends Model {
    public CreateInterfaceAddressResponse() {}

    @JsonProperty(value = "address", required = false)
    private InterfaceAddress address;

    @JsonProperty("address")
    public InterfaceAddress getAddress() {
      return address;
    }
  }

  public static final class CreateInterfacePrefixBody extends Model {
    public CreateInterfacePrefixBody() {}

    @JsonProperty(value = "pool_id", required = true)
    private String pool_id;

    @JsonProperty("pool_id")
    public String getPoolId() {
      return pool_id;
    }

    public CreateInterfacePrefixBody withPoolId(String value) {
      this.pool_id = value;
      return this;
    }
  }

  public static final class CreateInterfacePrefixResponse extends Model {
    public CreateInterfacePrefixResponse() {}

    @JsonProperty(value = "routed_prefixes", required = false)
    private List<RoutedPrefix> routed_prefixes;

    @JsonProperty("routed_prefixes")
    public List<RoutedPrefix> getRoutedPrefixes() {
      return routed_prefixes;
    }
  }

  public static final class InternetGatewayCreateRequestInput extends Model {
    public InternetGatewayCreateRequestInput() {}

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

    public InternetGatewayCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public InternetGatewayCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InternetGatewayCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class NATGatewayCreateRequestInput extends Model {
    public NATGatewayCreateRequestInput() {}

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

    public NATGatewayCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public NATGatewayCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * Subnet UUID or nested CRN (vpc/&lt;vpc&gt;/subnet/&lt;subnet&gt;). A bare name requires an
     * explicit VPC filter; create requests without a VPC do not accept bare names.
     */
    @JsonProperty(value = "subnet", required = true)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public NATGatewayCreateRequestInput withSubnet(String value) {
      this.subnet = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public NATGatewayCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class NATGatewayResponse extends Model {
    public NATGatewayResponse() {}

    @JsonProperty(value = "nat_gateway", required = false)
    private NATGateway nat_gateway;

    @JsonProperty("nat_gateway")
    public NATGateway getNatGateway() {
      return nat_gateway;
    }
  }

  public static final class NATGateway extends Model {
    public NATGateway() {}

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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "subnet", required = true)
    private Subnet subnet;

    @JsonProperty("subnet")
    public Subnet getSubnet() {
      return subnet;
    }

    /** Public IPv4 allocated from the regional pool at creation. Stable until gateway deletion. */
    @JsonProperty(value = "public_ipv4", required = true)
    private String public_ipv4;

    @JsonProperty("public_ipv4")
    public String getPublicIpv4() {
      return public_ipv4;
    }

    /**
     * Public IPv6 allocated from the regional pool when the gateway's hosting subnet has IPv6.
     * Assigned at gateway creation or when IPv6 is enabled on that subnet, independently of routes.
     * Stable until gateway deletion. Shared source NAT supports both global and ULA subnet
     * addresses.
     */
    @JsonProperty(value = "public_ipv6", required = false)
    private String public_ipv6;

    @JsonProperty("public_ipv6")
    public String getPublicIpv6() {
      return public_ipv6;
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

  public static final class CreatePrefixPoolBody extends Model {
    public CreatePrefixPoolBody() {}

    @JsonProperty(value = "cidr_ipv4", required = true)
    private String cidr_ipv4;

    @JsonProperty("cidr_ipv4")
    public String getCidrIpv4() {
      return cidr_ipv4;
    }

    public CreatePrefixPoolBody withCidrIpv4(String value) {
      this.cidr_ipv4 = value;
      return this;
    }
  }

  public static final class CreatePrefixPoolResponse extends Model {
    public CreatePrefixPoolResponse() {}

    @JsonProperty(value = "prefix_pools", required = false)
    private List<PrefixPool> prefix_pools;

    @JsonProperty("prefix_pools")
    public List<PrefixPool> getPrefixPools() {
      return prefix_pools;
    }
  }

  public static final class PrefixPool extends Model {
    public PrefixPool() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** VPC IPv4 range disjoint from all subnets and other prefix pools. */
    @JsonProperty(value = "cidr_ipv4", required = true)
    private String cidr_ipv4;

    @JsonProperty("cidr_ipv4")
    public String getCidrIpv4() {
      return cidr_ipv4;
    }
  }

  public static final class RouteCreateRequestInput extends Model {
    public RouteCreateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public RouteCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "destination_cidr", required = true)
    private String destination_cidr;

    @JsonProperty("destination_cidr")
    public String getDestinationCidr() {
      return destination_cidr;
    }

    public RouteCreateRequestInput withDestinationCidr(String value) {
      this.destination_cidr = value;
      return this;
    }

    /**
     * Unicast next hop inside this VPC's CIDR (same IP family as destination_cidr). Not for
     * internet egress — use a gateway target id instead.
     */
    @JsonProperty(value = "next_hop_ip", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> next_hop_ip = JsonField.missing();

    @JsonProperty("next_hop_ip")
    public JsonField<String> getNextHopIp() {
      return next_hop_ip;
    }

    public RouteCreateRequestInput withNextHopIp(JsonField<String> value) {
      this.next_hop_ip = value;
      return this;
    }

    /**
     * Gateway UUID, CRN or exact account-scoped name. Must belong to the route table VPC and match
     * the destination_cidr address family. Exactly one route target is required.
     */
    @JsonProperty(value = "target_internet_gateway", required = false)
    private String target_internet_gateway;

    @JsonProperty("target_internet_gateway")
    public String getTargetInternetGateway() {
      return target_internet_gateway;
    }

    public RouteCreateRequestInput withTargetInternetGateway(String value) {
      this.target_internet_gateway = value;
      return this;
    }

    /**
     * Gateway UUID, CRN or exact account-scoped name. Must belong to the route table VPC and match
     * the destination_cidr address family. Exactly one route target is required.
     */
    @JsonProperty(value = "target_nat_gateway", required = false)
    private String target_nat_gateway;

    @JsonProperty("target_nat_gateway")
    public String getTargetNatGateway() {
      return target_nat_gateway;
    }

    public RouteCreateRequestInput withTargetNatGateway(String value) {
      this.target_nat_gateway = value;
      return this;
    }

    /**
     * Gateway UUID, CRN or exact account-scoped name. Must belong to the route table VPC and match
     * the destination_cidr address family. Exactly one route target is required.
     */
    @JsonProperty(value = "target_egress_only_gateway", required = false)
    private String target_egress_only_gateway;

    @JsonProperty("target_egress_only_gateway")
    public String getTargetEgressOnlyGateway() {
      return target_egress_only_gateway;
    }

    public RouteCreateRequestInput withTargetEgressOnlyGateway(String value) {
      this.target_egress_only_gateway = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public RouteCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class RouteResponse extends Model {
    public RouteResponse() {}

    @JsonProperty(value = "route", required = false)
    private Route route;

    @JsonProperty("route")
    public Route getRoute() {
      return route;
    }
  }

  public static final class Route extends Model {
    public Route() {}

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

    @JsonProperty(value = "route_table_id", required = true)
    private String route_table_id;

    @JsonProperty("route_table_id")
    public String getRouteTableId() {
      return route_table_id;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "destination_cidr", required = true)
    private String destination_cidr;

    @JsonProperty("destination_cidr")
    public String getDestinationCidr() {
      return destination_cidr;
    }

    @JsonProperty(value = "target_type", required = true)
    private RouteTargetType target_type;

    @JsonProperty("target_type")
    public RouteTargetType getTargetType() {
      return target_type;
    }

    /**
     * Set when target_type=ip. Mutex with the target_*_id fields. Must be a unicast address inside
     * this VPC's CIDR (same IP family as destination_cidr); internet egress uses
     * target_internet_gateway_id / target_nat_gateway_id.
     */
    @JsonProperty(value = "next_hop_ip", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> next_hop_ip = JsonField.missing();

    @JsonProperty("next_hop_ip")
    public JsonField<String> getNextHopIp() {
      return next_hop_ip;
    }

    /** Set when target_type=internet_gateway. */
    @JsonProperty(value = "target_internet_gateway_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> target_internet_gateway_id = JsonField.missing();

    @JsonProperty("target_internet_gateway_id")
    public JsonField<String> getTargetInternetGatewayId() {
      return target_internet_gateway_id;
    }

    /**
     * Set when target_type=nat_gateway. Supports IPv4 and IPv6; IPv6 requires an IPv6-enabled
     * hosting subnet.
     */
    @JsonProperty(value = "target_nat_gateway_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> target_nat_gateway_id = JsonField.missing();

    @JsonProperty("target_nat_gateway_id")
    public JsonField<String> getTargetNatGatewayId() {
      return target_nat_gateway_id;
    }

    /**
     * Set when target_type=egress_only_gateway (IPv6 only). Gives the subnet outbound v6 with the
     * internet unable to initiate inbound.
     */
    @JsonProperty(value = "target_egress_only_gateway_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> target_egress_only_gateway_id = JsonField.missing();

    @JsonProperty("target_egress_only_gateway_id")
    public JsonField<String> getTargetEgressOnlyGatewayId() {
      return target_egress_only_gateway_id;
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

  public static final class RouteTargetType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RouteTargetType(String value) {
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
      return other instanceof RouteTargetType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RouteTargetType IP = new RouteTargetType("ip");
    public static final RouteTargetType INTERNET_GATEWAY = new RouteTargetType("internet_gateway");
    public static final RouteTargetType NAT_GATEWAY = new RouteTargetType("nat_gateway");
    public static final RouteTargetType EGRESS_ONLY_GATEWAY =
        new RouteTargetType("egress_only_gateway");
  }

  public static final class RouteTableCreateRequestInput extends Model {
    public RouteTableCreateRequestInput() {}

    /** VPC UUID, CRN or exact name in the caller account. */
    @JsonProperty(value = "vpc", required = true)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public RouteTableCreateRequestInput withVpc(String value) {
      this.vpc = value;
      return this;
    }

    /**
     * 1-63 chars, lowercase alphanumeric + hyphen. `main` is reserved. Resource names must not
     * start with the literal crn: prefix or be UUIDs (canonical, compact, braced, or urn:uuid:
     * forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public RouteTableCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public RouteTableCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public RouteTableCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class RouteTableResponse extends Model {
    public RouteTableResponse() {}

    @JsonProperty(value = "route_table", required = false)
    private RouteTable route_table;

    @JsonProperty("route_table")
    public RouteTable getRouteTable() {
      return route_table;
    }
  }

  public static final class RouteTable extends Model {
    public RouteTable() {}

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

    @JsonProperty(value = "vpc", required = true)
    private Vpc vpc;

    @JsonProperty("vpc")
    public Vpc getVpc() {
      return vpc;
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

    /**
     * True for the per-VPC default table, named &lt;vpc-name&gt;-private-rt. It is created
     * automatically and can't be deleted. Subnets that don't specify a route_table at create time
     * land here.
     */
    @JsonProperty(value = "is_main", required = true)
    private Boolean is_main;

    @JsonProperty("is_main")
    public Boolean getIsMain() {
      return is_main;
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

  public static final class SecurityGroupCreateRequestInput extends Model {
    public SecurityGroupCreateRequestInput() {}

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

    public SecurityGroupCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SecurityGroupCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SecurityGroupCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SecurityGroupResponse extends Model {
    public SecurityGroupResponse() {}

    @JsonProperty(value = "security_group", required = false)
    private SecurityGroup security_group;

    @JsonProperty("security_group")
    public SecurityGroup getSecurityGroup() {
      return security_group;
    }
  }

  public static final class SecurityGroup extends Model {
    public SecurityGroup() {}

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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
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

  public static final class SecurityGroupRuleCreateRequestInput extends Model {
    public SecurityGroupRuleCreateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SecurityGroupRuleCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "direction", required = true)
    private SecurityGroupRuleDirectionInput direction;

    @JsonProperty("direction")
    public SecurityGroupRuleDirectionInput getDirection() {
      return direction;
    }

    public SecurityGroupRuleCreateRequestInput withDirection(
        SecurityGroupRuleDirectionInput value) {
      this.direction = value;
      return this;
    }

    @JsonProperty(value = "ethertype", required = false)
    private SecurityGroupRuleEthertypeInput ethertype;

    @JsonProperty("ethertype")
    public SecurityGroupRuleEthertypeInput getEthertype() {
      return ethertype;
    }

    public SecurityGroupRuleCreateRequestInput withEthertype(
        SecurityGroupRuleEthertypeInput value) {
      this.ethertype = value;
      return this;
    }

    @JsonProperty(value = "protocol", required = true)
    private SecurityGroupRuleProtocolInput protocol;

    @JsonProperty("protocol")
    public SecurityGroupRuleProtocolInput getProtocol() {
      return protocol;
    }

    public SecurityGroupRuleCreateRequestInput withProtocol(SecurityGroupRuleProtocolInput value) {
      this.protocol = value;
      return this;
    }

    @JsonProperty(value = "port_min", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> port_min = JsonField.missing();

    @JsonProperty("port_min")
    public JsonField<Long> getPortMin() {
      return port_min;
    }

    public SecurityGroupRuleCreateRequestInput withPortMin(JsonField<Long> value) {
      this.port_min = value;
      return this;
    }

    @JsonProperty(value = "port_max", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> port_max = JsonField.missing();

    @JsonProperty("port_max")
    public JsonField<Long> getPortMax() {
      return port_max;
    }

    public SecurityGroupRuleCreateRequestInput withPortMax(JsonField<Long> value) {
      this.port_max = value;
      return this;
    }

    @JsonProperty(value = "remote_cidr", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> remote_cidr = JsonField.missing();

    @JsonProperty("remote_cidr")
    public JsonField<String> getRemoteCidr() {
      return remote_cidr;
    }

    public SecurityGroupRuleCreateRequestInput withRemoteCidr(JsonField<String> value) {
      this.remote_cidr = value;
      return this;
    }

    /**
     * Security-group UUID, CRN or exact account-scoped name. Mutually exclusive with remote_cidr.
     */
    @JsonProperty(value = "source_security_group", required = false)
    private String source_security_group;

    @JsonProperty("source_security_group")
    public String getSourceSecurityGroup() {
      return source_security_group;
    }

    public SecurityGroupRuleCreateRequestInput withSourceSecurityGroup(String value) {
      this.source_security_group = value;
      return this;
    }
  }

  public static final class SecurityGroupRuleDirectionInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SecurityGroupRuleDirectionInput(String value) {
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
      return other instanceof SecurityGroupRuleDirectionInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SecurityGroupRuleDirectionInput INGRESS =
        new SecurityGroupRuleDirectionInput("ingress");
    public static final SecurityGroupRuleDirectionInput EGRESS =
        new SecurityGroupRuleDirectionInput("egress");
  }

  public static final class SecurityGroupRuleEthertypeInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SecurityGroupRuleEthertypeInput(String value) {
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
      return other instanceof SecurityGroupRuleEthertypeInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SecurityGroupRuleEthertypeInput IPV4 =
        new SecurityGroupRuleEthertypeInput("ipv4");
    public static final SecurityGroupRuleEthertypeInput IPV6 =
        new SecurityGroupRuleEthertypeInput("ipv6");
  }

  public static final class SecurityGroupRuleProtocolInput {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SecurityGroupRuleProtocolInput(String value) {
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
      return other instanceof SecurityGroupRuleProtocolInput v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SecurityGroupRuleProtocolInput TCP =
        new SecurityGroupRuleProtocolInput("tcp");
    public static final SecurityGroupRuleProtocolInput UDP =
        new SecurityGroupRuleProtocolInput("udp");
    public static final SecurityGroupRuleProtocolInput ICMP =
        new SecurityGroupRuleProtocolInput("icmp");
    public static final SecurityGroupRuleProtocolInput ALL =
        new SecurityGroupRuleProtocolInput("all");
  }

  public static final class SecurityGroupRuleResponse extends Model {
    public SecurityGroupRuleResponse() {}

    @JsonProperty(value = "rule", required = false)
    private SecurityGroupRule rule;

    @JsonProperty("rule")
    public SecurityGroupRule getRule() {
      return rule;
    }
  }

  public static final class SecurityGroupRule extends Model {
    public SecurityGroupRule() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "security_group_id", required = true)
    private String security_group_id;

    @JsonProperty("security_group_id")
    public String getSecurityGroupId() {
      return security_group_id;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "direction", required = true)
    private SecurityGroupRuleDirection direction;

    @JsonProperty("direction")
    public SecurityGroupRuleDirection getDirection() {
      return direction;
    }

    @JsonProperty(value = "ethertype", required = true)
    private SecurityGroupRuleEthertype ethertype;

    @JsonProperty("ethertype")
    public SecurityGroupRuleEthertype getEthertype() {
      return ethertype;
    }

    @JsonProperty(value = "protocol", required = true)
    private SecurityGroupRuleProtocol protocol;

    @JsonProperty("protocol")
    public SecurityGroupRuleProtocol getProtocol() {
      return protocol;
    }

    /** Required when protocol is tcp/udp; ignored otherwise. */
    @JsonProperty(value = "port_min", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> port_min = JsonField.missing();

    @JsonProperty("port_min")
    public JsonField<Long> getPortMin() {
      return port_min;
    }

    @JsonProperty(value = "port_max", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<Long> port_max = JsonField.missing();

    @JsonProperty("port_max")
    public JsonField<Long> getPortMax() {
      return port_max;
    }

    /**
     * Source (ingress) or destination_cidr (egress) CIDR. Must match the rule's ethertype. Mutually
     * exclusive with source_security_group_id.
     */
    @JsonProperty(value = "remote_cidr", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> remote_cidr = JsonField.missing();

    @JsonProperty("remote_cidr")
    public JsonField<String> getRemoteCidr() {
      return remote_cidr;
    }

    /**
     * Source (ingress) or destination_cidr (egress) is "any workload in this SG". Traffic is
     * matched by membership in the named security group. Mutually exclusive with remote_cidr.
     */
    @JsonProperty(value = "source_security_group_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> source_security_group_id = JsonField.missing();

    @JsonProperty("source_security_group_id")
    public JsonField<String> getSourceSecurityGroupId() {
      return source_security_group_id;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class SecurityGroupRuleDirection {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SecurityGroupRuleDirection(String value) {
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
      return other instanceof SecurityGroupRuleDirection v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SecurityGroupRuleDirection INGRESS =
        new SecurityGroupRuleDirection("ingress");
    public static final SecurityGroupRuleDirection EGRESS =
        new SecurityGroupRuleDirection("egress");
  }

  public static final class SecurityGroupRuleEthertype {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SecurityGroupRuleEthertype(String value) {
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
      return other instanceof SecurityGroupRuleEthertype v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SecurityGroupRuleEthertype IPV4 = new SecurityGroupRuleEthertype("ipv4");
    public static final SecurityGroupRuleEthertype IPV6 = new SecurityGroupRuleEthertype("ipv6");
  }

  public static final class SecurityGroupRuleProtocol {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SecurityGroupRuleProtocol(String value) {
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
      return other instanceof SecurityGroupRuleProtocol v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SecurityGroupRuleProtocol TCP = new SecurityGroupRuleProtocol("tcp");
    public static final SecurityGroupRuleProtocol UDP = new SecurityGroupRuleProtocol("udp");
    public static final SecurityGroupRuleProtocol ICMP = new SecurityGroupRuleProtocol("icmp");
    public static final SecurityGroupRuleProtocol ALL = new SecurityGroupRuleProtocol("all");
  }

  public static final class SubnetCreateRequestInput extends Model {
    public SubnetCreateRequestInput() {}

    /** VPC UUID, CRN or exact name in the caller account. */
    @JsonProperty(value = "vpc", required = true)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public SubnetCreateRequestInput withVpc(String value) {
      this.vpc = value;
      return this;
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

    public SubnetCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SubnetCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "cidr_ipv4", required = true)
    private String cidr_ipv4;

    @JsonProperty("cidr_ipv4")
    public String getCidrIpv4() {
      return cidr_ipv4;
    }

    public SubnetCreateRequestInput withCidrIpv4(String value) {
      this.cidr_ipv4 = value;
      return this;
    }

    /** Defaults to the first usable host in the CIDR */
    @JsonProperty(value = "gateway_ipv4", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> gateway_ipv4 = JsonField.missing();

    @JsonProperty("gateway_ipv4")
    public JsonField<String> getGatewayIpv4() {
      return gateway_ipv4;
    }

    public SubnetCreateRequestInput withGatewayIpv4(JsonField<String> value) {
      this.gateway_ipv4 = value;
      return this;
    }

    /**
     * Route-table UUID, nested CRN or exact name within the subnet VPC. On PATCH the owned path
     * subnet supplies the VPC. Omission on create selects the default table; an empty reference is
     * invalid.
     */
    @JsonProperty(value = "route_table", required = false)
    private String route_table;

    @JsonProperty("route_table")
    public String getRouteTable() {
      return route_table;
    }

    public SubnetCreateRequestInput withRouteTable(String value) {
      this.route_table = value;
      return this;
    }

    /**
     * Allocate a free /64 from the VPC IPv6 range. Can be enabled after creation. Every existing
     * and new interface receives an IPv6 /96 and its first /128 automatically. NAT gateways hosted
     * here also receive a public IPv6 address from the regional pool. Updating hosted gateways
     * requires UpdateNATGateway permission and public IPv6 quota.
     */
    @JsonProperty(value = "allocate_cidr_ipv6", required = false)
    private Boolean allocate_cidr_ipv6;

    @JsonProperty("allocate_cidr_ipv6")
    public Boolean getAllocateCidrIpv6() {
      return allocate_cidr_ipv6;
    }

    public SubnetCreateRequestInput withAllocateCidrIpv6(Boolean value) {
      this.allocate_cidr_ipv6 = value;
      return this;
    }

    /**
     * An aligned /64 inside the VPC IPv6 range. Can be added later; cannot replace an existing
     * range. Mutually exclusive with allocate_cidr_ipv6.
     */
    @JsonProperty(value = "cidr_ipv6", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cidr_ipv6 = JsonField.missing();

    @JsonProperty("cidr_ipv6")
    public JsonField<String> getCidrIpv6() {
      return cidr_ipv6;
    }

    public SubnetCreateRequestInput withCidrIpv6(JsonField<String> value) {
      this.cidr_ipv6 = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SubnetCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SubnetResponse extends Model {
    public SubnetResponse() {}

    @JsonProperty(value = "subnet", required = false)
    private Subnet subnet;

    @JsonProperty("subnet")
    public Subnet getSubnet() {
      return subnet;
    }
  }

  public static final class VpcCreateRequestInput extends Model {
    public VpcCreateRequestInput() {}

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

    public VpcCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public VpcCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /** Must be private (RFC 1918): within 10.0.0.0/8, 172.16.0.0/12 or 192.168.0.0/16. */
    @JsonProperty(value = "cidr_ipv4", required = true)
    private String cidr_ipv4;

    @JsonProperty("cidr_ipv4")
    public String getCidrIpv4() {
      return cidr_ipv4;
    }

    public VpcCreateRequestInput withCidrIpv4(String value) {
      this.cidr_ipv4 = value;
      return this;
    }

    /**
     * Allocate a regional GUA /60. Mutually exclusive with cidr_ipv6. Existing IPv6 ranges cannot
     * be replaced.
     */
    @JsonProperty(value = "allocate_cidr_ipv6", required = false)
    private Boolean allocate_cidr_ipv6;

    @JsonProperty("allocate_cidr_ipv6")
    public Boolean getAllocateCidrIpv6() {
      return allocate_cidr_ipv6;
    }

    public VpcCreateRequestInput withAllocateCidrIpv6(Boolean value) {
      this.allocate_cidr_ipv6 = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public VpcCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * Optional aligned locally assigned ULA (fd00::/8), /48 through /60. May be added after VPC
     * creation.
     */
    @JsonProperty(value = "cidr_ipv6", required = false)
    private String cidr_ipv6;

    @JsonProperty("cidr_ipv6")
    public String getCidrIpv6() {
      return cidr_ipv6;
    }

    public VpcCreateRequestInput withCidrIpv6(String value) {
      this.cidr_ipv6 = value;
      return this;
    }
  }

  public static final class VpcResponse extends Model {
    public VpcResponse() {}

    @JsonProperty(value = "vpc", required = false)
    private Vpc vpc;

    @JsonProperty("vpc")
    public Vpc getVpc() {
      return vpc;
    }
  }

  public static final class DetachFloatingIpBody extends Model {
    public DetachFloatingIpBody() {}

    /**
     * Interface UUID or nested CRN; bare names, null and empty references are rejected. Omitting
     * the field clears the binding. Naming a NIC that is not a member is a no-op.
     */
    @JsonProperty(value = "interface", required = false)
    private String interfaceValue;

    @JsonProperty("interface")
    public String getInterfaceValue() {
      return interfaceValue;
    }

    public DetachFloatingIpBody withInterfaceValue(String value) {
      this.interfaceValue = value;
      return this;
    }
  }

  public static final class DetachFloatingIpResponse extends Model {
    public DetachFloatingIpResponse() {}

    @JsonProperty(value = "floating_ip", required = false)
    private FloatingIp floating_ip;

    @JsonProperty("floating_ip")
    public FloatingIp getFloatingIp() {
      return floating_ip;
    }
  }

  public static final class GetEgressOnlyGatewayScope extends Model {
    public GetEgressOnlyGatewayScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetEgressOnlyGatewayScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetFloatingIpScope extends Model {
    public GetFloatingIpScope() {}

    @JsonProperty(value = "attached_to", required = false)
    private String attached_to;

    @JsonProperty("attached_to")
    public String getAttachedTo() {
      return attached_to;
    }

    public GetFloatingIpScope withAttachedTo(String value) {
      this.attached_to = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetFloatingIpScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetInterfaceScope extends Model {
    public GetInterfaceScope() {}

    @JsonProperty(value = "subnet", required = false)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public GetInterfaceScope withSubnet(String value) {
      this.subnet = value;
      return this;
    }

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public GetInterfaceScope withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetInterfaceScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetInterfaceAddressResponse extends Model {
    public GetInterfaceAddressResponse() {}

    @JsonProperty(value = "address", required = false)
    private InterfaceAddress address;

    @JsonProperty("address")
    public InterfaceAddress getAddress() {
      return address;
    }
  }

  public static final class GetInternetGatewayScope extends Model {
    public GetInternetGatewayScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetInternetGatewayScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetNATGatewayScope extends Model {
    public GetNATGatewayScope() {}

    @JsonProperty(value = "subnet", required = false)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public GetNATGatewayScope withSubnet(String value) {
      this.subnet = value;
      return this;
    }

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public GetNATGatewayScope withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetNATGatewayScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetRouteScope extends Model {
    public GetRouteScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetRouteScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetRouteTableScope extends Model {
    public GetRouteTableScope() {}

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public GetRouteTableScope withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetRouteTableScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetSecurityGroupScope extends Model {
    public GetSecurityGroupScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetSecurityGroupScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetSecurityGroupRuleScope extends Model {
    public GetSecurityGroupRuleScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetSecurityGroupRuleScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetSubnetScope extends Model {
    public GetSubnetScope() {}

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public GetSubnetScope withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetSubnetScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetVpcScope extends Model {
    public GetVpcScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetVpcScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListEgressOnlyGatewayRoutesQuery extends Model {
    public ListEgressOnlyGatewayRoutesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListEgressOnlyGatewayRoutesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListEgressOnlyGatewayRoutesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListEgressOnlyGatewayRoutesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListEgressOnlyGatewayRoutesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class GatewayRouteListResponse extends Model {
    public GatewayRouteListResponse() {}

    @JsonProperty(value = "routes", required = true)
    private List<GatewayRoute> routes;

    @JsonProperty("routes")
    public List<GatewayRoute> getRoutes() {
      return routes;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class GatewayRoute extends Model {
    public GatewayRoute() {}

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

    @JsonProperty(value = "route_table_id", required = true)
    private String route_table_id;

    @JsonProperty("route_table_id")
    public String getRouteTableId() {
      return route_table_id;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "destination_cidr", required = true)
    private String destination_cidr;

    @JsonProperty("destination_cidr")
    public String getDestinationCidr() {
      return destination_cidr;
    }

    @JsonProperty(value = "target_type", required = true)
    private RouteTargetType target_type;

    @JsonProperty("target_type")
    public RouteTargetType getTargetType() {
      return target_type;
    }

    /**
     * Set when target_type=ip. Mutex with the target_*_id fields. Must be a unicast address inside
     * this VPC's CIDR (same IP family as destination_cidr); internet egress uses
     * target_internet_gateway_id / target_nat_gateway_id.
     */
    @JsonProperty(value = "next_hop_ip", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> next_hop_ip = JsonField.missing();

    @JsonProperty("next_hop_ip")
    public JsonField<String> getNextHopIp() {
      return next_hop_ip;
    }

    /** Set when target_type=internet_gateway. */
    @JsonProperty(value = "target_internet_gateway_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> target_internet_gateway_id = JsonField.missing();

    @JsonProperty("target_internet_gateway_id")
    public JsonField<String> getTargetInternetGatewayId() {
      return target_internet_gateway_id;
    }

    /**
     * Set when target_type=nat_gateway. Supports IPv4 and IPv6; IPv6 requires an IPv6-enabled
     * hosting subnet.
     */
    @JsonProperty(value = "target_nat_gateway_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> target_nat_gateway_id = JsonField.missing();

    @JsonProperty("target_nat_gateway_id")
    public JsonField<String> getTargetNatGatewayId() {
      return target_nat_gateway_id;
    }

    /**
     * Set when target_type=egress_only_gateway (IPv6 only). Gives the subnet outbound v6 with the
     * internet unable to initiate inbound.
     */
    @JsonProperty(value = "target_egress_only_gateway_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> target_egress_only_gateway_id = JsonField.missing();

    @JsonProperty("target_egress_only_gateway_id")
    public JsonField<String> getTargetEgressOnlyGatewayId() {
      return target_egress_only_gateway_id;
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

    @JsonProperty(value = "route_table", required = true)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<RouteTableSummary> route_table = JsonField.missing();

    @JsonProperty("route_table")
    public JsonField<RouteTableSummary> getRouteTable() {
      return route_table;
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

  public static final class ListEgressOnlyGatewaysQuery extends Model {
    public ListEgressOnlyGatewaysQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListEgressOnlyGatewaysQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListEgressOnlyGatewaysQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListEgressOnlyGatewaysQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListEgressOnlyGatewaysQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class EgressOnlyGatewayListResponse extends Model {
    public EgressOnlyGatewayListResponse() {}

    @JsonProperty(value = "egress_only_gateways", required = true)
    private List<EgressOnlyGateway> egress_only_gateways;

    @JsonProperty("egress_only_gateways")
    public List<EgressOnlyGateway> getEgressOnlyGateways() {
      return egress_only_gateways;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListFloatingIpsQuery extends Model {
    public ListFloatingIpsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListFloatingIpsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListFloatingIpsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "attached_to", required = false)
    private String attached_to;

    @JsonProperty("attached_to")
    public String getAttachedTo() {
      return attached_to;
    }

    public ListFloatingIpsQuery withAttachedTo(String value) {
      this.attached_to = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListFloatingIpsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListFloatingIpsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class FloatingIpListResponse extends Model {
    public FloatingIpListResponse() {}

    @JsonProperty(value = "floating_ips", required = true)
    private List<FloatingIp> floating_ips;

    @JsonProperty("floating_ips")
    public List<FloatingIp> getFloatingIps() {
      return floating_ips;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListInterfaceAddressesResponse extends Model {
    public ListInterfaceAddressesResponse() {}

    @JsonProperty(value = "addresses", required = false)
    private List<InterfaceAddress> addresses;

    @JsonProperty("addresses")
    public List<InterfaceAddress> getAddresses() {
      return addresses;
    }
  }

  public static final class ListInterfacePrefixesResponse extends Model {
    public ListInterfacePrefixesResponse() {}

    @JsonProperty(value = "routed_prefixes", required = false)
    private List<RoutedPrefix> routed_prefixes;

    @JsonProperty("routed_prefixes")
    public List<RoutedPrefix> getRoutedPrefixes() {
      return routed_prefixes;
    }
  }

  public static final class ListInterfaceSecurityGroupsQuery extends Model {
    public ListInterfaceSecurityGroupsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInterfaceSecurityGroupsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInterfaceSecurityGroupsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class InterfaceSecurityGroupsResponse extends Model {
    public InterfaceSecurityGroupsResponse() {}

    @JsonProperty(value = "security_group_ids", required = true)
    private List<String> security_group_ids;

    @JsonProperty("security_group_ids")
    public List<String> getSecurityGroupIds() {
      return security_group_ids;
    }
  }

  public static final class ListInterfacesQuery extends Model {
    public ListInterfacesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInterfacesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInterfacesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "subnet", required = false)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public ListInterfacesQuery withSubnet(String value) {
      this.subnet = value;
      return this;
    }

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public ListInterfacesQuery withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInterfacesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInterfacesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class InterfaceListResponse extends Model {
    public InterfaceListResponse() {}

    @JsonProperty(value = "interfaces", required = true)
    private List<Interface> interfaces;

    @JsonProperty("interfaces")
    public List<Interface> getInterfaces() {
      return interfaces;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListInternetGatewayRoutesQuery extends Model {
    public ListInternetGatewayRoutesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInternetGatewayRoutesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInternetGatewayRoutesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInternetGatewayRoutesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInternetGatewayRoutesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ListInternetGatewaysQuery extends Model {
    public ListInternetGatewaysQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInternetGatewaysQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInternetGatewaysQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInternetGatewaysQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInternetGatewaysQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class InternetGatewayListResponse extends Model {
    public InternetGatewayListResponse() {}

    @JsonProperty(value = "internet_gateways", required = true)
    private List<InternetGateway> internet_gateways;

    @JsonProperty("internet_gateways")
    public List<InternetGateway> getInternetGateways() {
      return internet_gateways;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListNATGatewayRoutesQuery extends Model {
    public ListNATGatewayRoutesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListNATGatewayRoutesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListNATGatewayRoutesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListNATGatewayRoutesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListNATGatewayRoutesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ListNATGatewaysQuery extends Model {
    public ListNATGatewaysQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListNATGatewaysQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListNATGatewaysQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "subnet", required = false)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public ListNATGatewaysQuery withSubnet(String value) {
      this.subnet = value;
      return this;
    }

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public ListNATGatewaysQuery withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListNATGatewaysQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListNATGatewaysQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class NATGatewayListResponse extends Model {
    public NATGatewayListResponse() {}

    @JsonProperty(value = "nat_gateways", required = true)
    private List<NATGateway> nat_gateways;

    @JsonProperty("nat_gateways")
    public List<NATGateway> getNatGateways() {
      return nat_gateways;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListPrefixPoolsResponse extends Model {
    public ListPrefixPoolsResponse() {}

    @JsonProperty(value = "prefix_pools", required = false)
    private List<PrefixPool> prefix_pools;

    @JsonProperty("prefix_pools")
    public List<PrefixPool> getPrefixPools() {
      return prefix_pools;
    }
  }

  public static final class ListRouteTablesQuery extends Model {
    public ListRouteTablesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRouteTablesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRouteTablesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public ListRouteTablesQuery withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListRouteTablesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListRouteTablesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class RouteTableListResponse extends Model {
    public RouteTableListResponse() {}

    @JsonProperty(value = "route_tables", required = true)
    private List<RouteTable> route_tables;

    @JsonProperty("route_tables")
    public List<RouteTable> getRouteTables() {
      return route_tables;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListRoutesQuery extends Model {
    public ListRoutesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRoutesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRoutesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListRoutesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListRoutesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class RouteListResponse extends Model {
    public RouteListResponse() {}

    @JsonProperty(value = "routes", required = true)
    private List<Route> routes;

    @JsonProperty("routes")
    public List<Route> getRoutes() {
      return routes;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListSecurityGroupRulesQuery extends Model {
    public ListSecurityGroupRulesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListSecurityGroupRulesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSecurityGroupRulesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSecurityGroupRulesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSecurityGroupRulesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class SecurityGroupRuleListResponse extends Model {
    public SecurityGroupRuleListResponse() {}

    @JsonProperty(value = "rules", required = true)
    private List<SecurityGroupRule> rules;

    @JsonProperty("rules")
    public List<SecurityGroupRule> getRules() {
      return rules;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListSecurityGroupsQuery extends Model {
    public ListSecurityGroupsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListSecurityGroupsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSecurityGroupsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSecurityGroupsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSecurityGroupsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class SecurityGroupListResponse extends Model {
    public SecurityGroupListResponse() {}

    @JsonProperty(value = "security_groups", required = true)
    private List<SecurityGroup> security_groups;

    @JsonProperty("security_groups")
    public List<SecurityGroup> getSecurityGroups() {
      return security_groups;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListSubnetsQuery extends Model {
    public ListSubnetsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListSubnetsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSubnetsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "vpc", required = false)
    private String vpc;

    @JsonProperty("vpc")
    public String getVpc() {
      return vpc;
    }

    public ListSubnetsQuery withVpc(String value) {
      this.vpc = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSubnetsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSubnetsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class SubnetListResponse extends Model {
    public SubnetListResponse() {}

    @JsonProperty(value = "subnets", required = true)
    private List<Subnet> subnets;

    @JsonProperty("subnets")
    public List<Subnet> getSubnets() {
      return subnets;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListVpcsQuery extends Model {
    public ListVpcsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListVpcsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListVpcsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListVpcsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListVpcsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class VpcListResponse extends Model {
    public VpcListResponse() {}

    @JsonProperty(value = "vpcs", required = true)
    private List<Vpc> vpcs;

    @JsonProperty("vpcs")
    public List<Vpc> getVpcs() {
      return vpcs;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class InterfaceSecurityGroupsRequestInput extends Model {
    public InterfaceSecurityGroupsRequestInput() {}

    /**
     * Security-group UUIDs, CRNs or account-scoped names. All entries resolve before replacement;
     * duplicate canonical IDs collapse to one membership. An empty array removes all groups.
     */
    @JsonProperty(value = "security_groups", required = true)
    private List<String> security_groups;

    @JsonProperty("security_groups")
    public List<String> getSecurityGroups() {
      return security_groups;
    }

    public InterfaceSecurityGroupsRequestInput withSecurityGroups(List<String> value) {
      this.security_groups = value;
      return this;
    }
  }

  public static final class EgressOnlyGatewayUpdateRequestInput extends Model {
    public EgressOnlyGatewayUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public EgressOnlyGatewayUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public EgressOnlyGatewayUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class FloatingIpUpdateRequestInput extends Model {
    public FloatingIpUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public FloatingIpUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public FloatingIpUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * Set (an object) or clear (null) the address's readiness check. Omit the field to leave it
     * unchanged.
     */
    @JsonProperty(value = "health_check", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<FloatingIpHealthCheckInput> health_check = JsonField.missing();

    @JsonProperty("health_check")
    public JsonField<FloatingIpHealthCheckInput> getHealthCheck() {
      return health_check;
    }

    public FloatingIpUpdateRequestInput withHealthCheck(
        JsonField<FloatingIpHealthCheckInput> value) {
      this.health_check = value;
      return this;
    }
  }

  public static final class InterfaceUpdateRequestInput extends Model {
    public InterfaceUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public InterfaceUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InterfaceUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class InternetGatewayUpdateRequestInput extends Model {
    public InternetGatewayUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public InternetGatewayUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InternetGatewayUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class NATGatewayUpdateRequestInput extends Model {
    public NATGatewayUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public NATGatewayUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public NATGatewayUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class RouteUpdateRequestInput extends Model {
    public RouteUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public RouteUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public RouteUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class RouteTableUpdateRequestInput extends Model {
    public RouteTableUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public RouteTableUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public RouteTableUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SecurityGroupUpdateRequestInput extends Model {
    public SecurityGroupUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public SecurityGroupUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SecurityGroupUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class SubnetUpdateRequestInput extends Model {
    public SubnetUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public SubnetUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    /**
     * Route-table UUID, nested CRN or exact name within the subnet VPC. On PATCH the owned path
     * subnet supplies the VPC. Omission on create selects the default table; an empty reference is
     * invalid.
     */
    @JsonProperty(value = "route_table", required = false)
    private String route_table;

    @JsonProperty("route_table")
    public String getRouteTable() {
      return route_table;
    }

    public SubnetUpdateRequestInput withRouteTable(String value) {
      this.route_table = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SubnetUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * Allocate a free /64 from the VPC IPv6 range. Can be enabled after creation. Every existing
     * and new interface receives an IPv6 /96 and its first /128 automatically. NAT gateways hosted
     * here also receive a public IPv6 address from the regional pool. Updating hosted gateways
     * requires UpdateNATGateway permission and public IPv6 quota.
     */
    @JsonProperty(value = "allocate_cidr_ipv6", required = false)
    private Boolean allocate_cidr_ipv6;

    @JsonProperty("allocate_cidr_ipv6")
    public Boolean getAllocateCidrIpv6() {
      return allocate_cidr_ipv6;
    }

    public SubnetUpdateRequestInput withAllocateCidrIpv6(Boolean value) {
      this.allocate_cidr_ipv6 = value;
      return this;
    }

    /**
     * An aligned /64 inside the VPC IPv6 range. Can be added later; cannot replace an existing
     * range. Mutually exclusive with allocate_cidr_ipv6.
     */
    @JsonProperty(value = "cidr_ipv6", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> cidr_ipv6 = JsonField.missing();

    @JsonProperty("cidr_ipv6")
    public JsonField<String> getCidrIpv6() {
      return cidr_ipv6;
    }

    public SubnetUpdateRequestInput withCidrIpv6(JsonField<String> value) {
      this.cidr_ipv6 = value;
      return this;
    }

    /**
     * When enabling IPv6, copy equivalent rules in security groups used by this subnet's
     * interfaces. Copies 0.0.0.0/0 to ::/0 and security-group references, preserving protocol,
     * ports and direction. Restricted IPv4 CIDRs are not widened. Existing IPv6 equivalents are not
     * duplicated. Changes affect every interface sharing these groups. Requires
     * CreateSecurityGroupRule permission and available rule quota. Only accepted with
     * allocate_cidr_ipv6 or cidr_ipv6.
     */
    @JsonProperty(value = "copy_ipv4_security_rules", required = false)
    private Boolean copy_ipv4_security_rules;

    @JsonProperty("copy_ipv4_security_rules")
    public Boolean getCopyIpv4SecurityRules() {
      return copy_ipv4_security_rules;
    }

    public SubnetUpdateRequestInput withCopyIpv4SecurityRules(Boolean value) {
      this.copy_ipv4_security_rules = value;
      return this;
    }

    /**
     * When enabling IPv6, optionally add ::/0 to the subnet's route table. match_ipv4 follows an
     * IPv4 internet-gateway or NAT-gateway default route, using the same target. A NAT gateway must
     * already have IPv6 enabled on its hosting subnet, or be hosted in the subnet being enabled. No
     * IPv4 default route leaves IPv6 routing unchanged. Existing IPv6 default routes are always
     * preserved. Egress-only gateways cannot provide ULA internet access; use a NAT gateway, or a
     * public IPv6 floating IP with an internet-gateway route. Changes affect every subnet sharing
     * the route table and require CreateRoute permission; creating an egress-only gateway also
     * requires CreateEgressOnlyGateway permission. Only accepted with allocate_cidr_ipv6 or
     * cidr_ipv6.
     */
    @JsonProperty(value = "ipv6_routing", required = false)
    private SubnetUpdateRequestInputIpv6Routing ipv6_routing;

    @JsonProperty("ipv6_routing")
    public SubnetUpdateRequestInputIpv6Routing getIpv6Routing() {
      return ipv6_routing;
    }

    public SubnetUpdateRequestInput withIpv6Routing(SubnetUpdateRequestInputIpv6Routing value) {
      this.ipv6_routing = value;
      return this;
    }
  }

  public static final class SubnetUpdateRequestInputIpv6Routing {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SubnetUpdateRequestInputIpv6Routing(String value) {
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
      return other instanceof SubnetUpdateRequestInputIpv6Routing v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SubnetUpdateRequestInputIpv6Routing MATCH_IPV4 =
        new SubnetUpdateRequestInputIpv6Routing("match_ipv4");
    public static final SubnetUpdateRequestInputIpv6Routing UNCHANGED =
        new SubnetUpdateRequestInputIpv6Routing("unchanged");
    public static final SubnetUpdateRequestInputIpv6Routing INTERNET_GATEWAY =
        new SubnetUpdateRequestInputIpv6Routing("internet_gateway");
    public static final SubnetUpdateRequestInputIpv6Routing NAT_GATEWAY =
        new SubnetUpdateRequestInputIpv6Routing("nat_gateway");
    public static final SubnetUpdateRequestInputIpv6Routing EGRESS_ONLY_GATEWAY =
        new SubnetUpdateRequestInputIpv6Routing("egress_only_gateway");
  }

  public static final class VpcUpdateRequestInput extends Model {
    public VpcUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    public VpcUpdateRequestInput withDescription(JsonField<String> value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public VpcUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * Allocate a regional GUA /60. Mutually exclusive with cidr_ipv6. Existing IPv6 ranges cannot
     * be replaced.
     */
    @JsonProperty(value = "allocate_cidr_ipv6", required = false)
    private Boolean allocate_cidr_ipv6;

    @JsonProperty("allocate_cidr_ipv6")
    public Boolean getAllocateCidrIpv6() {
      return allocate_cidr_ipv6;
    }

    public VpcUpdateRequestInput withAllocateCidrIpv6(Boolean value) {
      this.allocate_cidr_ipv6 = value;
      return this;
    }

    /**
     * Optional aligned locally assigned ULA (fd00::/8), /48 through /60. May be added after VPC
     * creation.
     */
    @JsonProperty(value = "cidr_ipv6", required = false)
    private String cidr_ipv6;

    @JsonProperty("cidr_ipv6")
    public String getCidrIpv6() {
      return cidr_ipv6;
    }

    public VpcUpdateRequestInput withCidrIpv6(String value) {
      this.cidr_ipv6 = value;
      return this;
    }
  }
}
