package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.math.BigDecimal;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

/** Typed compute wire models. Unknown string enum values are retained. */
public final class Compute {

  private Compute() {}

  public static final class AttachInstanceNICBody extends Model {
    public AttachInstanceNICBody() {}

    /**
     * Existing standalone interface UUID or complete VPC/subnet/interface CRN. Bare names lack the
     * subnet parent and are rejected. It keeps its address, MAC, and security groups; detach
     * returns it to standalone instead of destroying it.
     */
    @JsonProperty(value = "interface", required = true)
    private String interfaceValue;

    @JsonProperty("interface")
    public String getInterfaceValue() {
      return interfaceValue;
    }

    public AttachInstanceNICBody withInterfaceValue(String value) {
      this.interfaceValue = value;
      return this;
    }
  }

  public static final class AttachInstanceNICResponse extends Model {
    public AttachInstanceNICResponse() {}

    @JsonProperty(value = "attachment", required = false)
    private AttachInstanceNICResponseAttachment attachment;

    @JsonProperty("attachment")
    public AttachInstanceNICResponseAttachment getAttachment() {
      return attachment;
    }
  }

  public static final class AttachInstanceNICResponseAttachment extends Model {
    public AttachInstanceNICResponseAttachment() {}

    @JsonProperty(value = "interface_id", required = false)
    private String interface_id;

    @JsonProperty("interface_id")
    public String getInterfaceId() {
      return interface_id;
    }

    @JsonProperty(value = "mac", required = false)
    private String mac;

    @JsonProperty("mac")
    public String getMac() {
      return mac;
    }

    @JsonProperty(value = "boot_index", required = false)
    private Long boot_index;

    @JsonProperty("boot_index")
    public Long getBootIndex() {
      return boot_index;
    }

    /**
     * The attached interface existed before this call (interface was given). Detach unbinds it and
     * leaves it standalone rather than destroying it.
     */
    @JsonProperty(value = "external", required = false)
    private Boolean external;

    @JsonProperty("external")
    public Boolean getExternal() {
      return external;
    }

    /**
     * The guest does not carry the interface yet and a hard reboot is what delivers it — an
     * interface past the first is a network on the instance's launcher, and a launcher's networks
     * are fixed for its lifetime. Set when the instance was running in a region that cannot attach
     * to a running guest. Absent for a stopped instance, which comes up with the device, and absent
     * where the region attaches live, where the running guest is given the device without a
     * restart.
     */
    @JsonProperty(value = "restart_required", required = false)
    private Boolean restart_required;

    @JsonProperty("restart_required")
    public Boolean getRestartRequired() {
      return restart_required;
    }

    @JsonProperty(value = "addresses", required = false)
    private List<InterfaceAddress> addresses;

    @JsonProperty("addresses")
    public List<InterfaceAddress> getAddresses() {
      return addresses;
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

  public static final class InstancePoolFloatingIpAttachRequestInput extends Model {
    public InstancePoolFloatingIpAttachRequestInput() {}

    /**
     * An account-scoped floating IP UUID or CRN (bare names are not accepted), currently attached
     * to nothing. This binds it to the pool; it does not allocate one.
     */
    @JsonProperty(value = "floating_ip", required = true)
    private String floating_ip;

    @JsonProperty("floating_ip")
    public String getFloatingIp() {
      return floating_ip;
    }

    public InstancePoolFloatingIpAttachRequestInput withFloatingIp(String value) {
      this.floating_ip = value;
      return this;
    }
  }

  public static final class InstancePoolFloatingIpResponse extends Model {
    public InstancePoolFloatingIpResponse() {}

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

  public static final class AttachInstanceVolumeBody extends Model {
    public AttachInstanceVolumeBody() {}

    /** Account-scoped volume reference (UUID, CRN or exact name). */
    @JsonProperty(value = "volume", required = true)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public AttachInstanceVolumeBody withVolume(String value) {
      this.volume = value;
      return this;
    }

    /** Optional device-name override; auto-picks the next free slot (vdb/vdc/…) when omitted. */
    @JsonProperty(value = "device", required = false)
    private String device;

    @JsonProperty("device")
    public String getDevice() {
      return device;
    }

    public AttachInstanceVolumeBody withDevice(String value) {
      this.device = value;
      return this;
    }

    /**
     * When set, the in-guest agent formats the disk (only if blank) and mounts it at this path.
     * Empty attaches the block device only.
     */
    @JsonProperty(value = "mount_path", required = false)
    private String mount_path;

    @JsonProperty("mount_path")
    public String getMountPath() {
      return mount_path;
    }

    public AttachInstanceVolumeBody withMountPath(String value) {
      this.mount_path = value;
      return this;
    }

    /**
     * Filesystem the in-guest agent formats the disk with, and only when `mount_path` is set and
     * the disk is blank. Rejected with 400 if it is neither value.
     */
    @JsonProperty(value = "fstype", required = false)
    private AttachInstanceVolumeBodyFstype fstype;

    @JsonProperty("fstype")
    public AttachInstanceVolumeBodyFstype getFstype() {
      return fstype;
    }

    public AttachInstanceVolumeBody withFstype(AttachInstanceVolumeBodyFstype value) {
      this.fstype = value;
      return this;
    }
  }

  public static final class AttachInstanceVolumeBodyFstype {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AttachInstanceVolumeBodyFstype(String value) {
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
      return other instanceof AttachInstanceVolumeBodyFstype v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AttachInstanceVolumeBodyFstype EXT4 =
        new AttachInstanceVolumeBodyFstype("ext4");
    public static final AttachInstanceVolumeBodyFstype XFS =
        new AttachInstanceVolumeBodyFstype("xfs");
  }

  public static final class AttachInstanceVolumeResponse extends Model {
    public AttachInstanceVolumeResponse() {}

    @JsonProperty(value = "attachment", required = false)
    private AttachInstanceVolumeResponseAttachment attachment;

    @JsonProperty("attachment")
    public AttachInstanceVolumeResponseAttachment getAttachment() {
      return attachment;
    }
  }

  public static final class AttachInstanceVolumeResponseAttachment extends Model {
    public AttachInstanceVolumeResponseAttachment() {}

    @JsonProperty(value = "instance_id", required = false)
    private String instance_id;

    @JsonProperty("instance_id")
    public String getInstanceId() {
      return instance_id;
    }

    @JsonProperty(value = "volume_id", required = false)
    private String volume_id;

    @JsonProperty("volume_id")
    public String getVolumeId() {
      return volume_id;
    }

    @JsonProperty(value = "device", required = false)
    private String device;

    @JsonProperty("device")
    public String getDevice() {
      return device;
    }
  }

  public static final class ImageCreateRequestInput extends Model {
    public ImageCreateRequestInput() {}

    /**
     * Immutable image name (e.g. debian-13) whose current-version pointer can move; the new image
     * becomes its current version. Names are shared across a tag's builds — one build is identified
     * by owner, name, architecture and version. Resource names must not start with the literal crn:
     * prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ImageCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    /**
     * Presigned https GET URL to the disk in an object store you control. Fetched once by the
     * import worker (which rejects private/link-local targets). The worker detects qcow2, raw,
     * vmdk, vhd, vhdx or vdi and converts it to raw storage. Unreadable or unsupported sources and
     * images declaring backing files fail asynchronously with status error and an active conversion
     * fault. Not retained after import.
     */
    @JsonProperty(value = "source_url", required = true)
    private String source_url;

    @JsonProperty("source_url")
    public String getSourceUrl() {
      return source_url;
    }

    public ImageCreateRequestInput withSourceUrl(String value) {
      this.source_url = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public ImageCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * Operating system distribution. Use linux for another or generic Linux distribution;
     * os_version specifies the release separately.
     */
    @JsonProperty(value = "os", required = false)
    private ImageCreateRequestInputOs os;

    @JsonProperty("os")
    public ImageCreateRequestInputOs getOs() {
      return os;
    }

    public ImageCreateRequestInput withOs(ImageCreateRequestInputOs value) {
      this.os = value;
      return this;
    }

    @JsonProperty(value = "os_version", required = false)
    private String os_version;

    @JsonProperty("os_version")
    public String getOsVersion() {
      return os_version;
    }

    public ImageCreateRequestInput withOsVersion(String value) {
      this.os_version = value;
      return this;
    }

    /** CPU architecture of the source image. Only amd64 (x86-64) is supported. */
    @JsonProperty(value = "architecture", required = false)
    private ImageCreateRequestInputArchitecture architecture;

    @JsonProperty("architecture")
    public ImageCreateRequestInputArchitecture getArchitecture() {
      return architecture;
    }

    public ImageCreateRequestInput withArchitecture(ImageCreateRequestInputArchitecture value) {
      this.architecture = value;
      return this;
    }

    /**
     * Identifies this build within `name`, and must be unique there — re-publishing a version that
     * a tag already carries is a 409. Omit it and the server stamps a UTC timestamp, so every build
     * is addressable as `name:version` whether or not you labelled it.
     */
    @JsonProperty(value = "version", required = false)
    private String version;

    @JsonProperty("version")
    public String getVersion() {
      return version;
    }

    public ImageCreateRequestInput withVersion(String value) {
      this.version = value;
      return this;
    }

    /** Make this the current version for its (name, architecture) once active. */
    @JsonProperty(value = "current", required = false)
    private Boolean current;

    @JsonProperty("current")
    public Boolean getCurrent() {
      return current;
    }

    public ImageCreateRequestInput withCurrent(Boolean value) {
      this.current = value;
      return this;
    }

    /**
     * The day this release stops receiving free security updates. Omit it and the image inherits
     * the date the name's current version carries, so re-publishing a tag can't quietly stop
     * tracking its release.
     */
    @JsonProperty(value = "eol_date", required = false)
    private String eol_date;

    @JsonProperty("eol_date")
    public String getEolDate() {
      return eol_date;
    }

    public ImageCreateRequestInput withEolDate(String value) {
      this.eol_date = value;
      return this;
    }

    @JsonProperty(value = "min_disk_gb", required = false)
    private Long min_disk_gb;

    @JsonProperty("min_disk_gb")
    public Long getMinDiskGb() {
      return min_disk_gb;
    }

    public ImageCreateRequestInput withMinDiskGb(Long value) {
      this.min_disk_gb = value;
      return this;
    }

    @JsonProperty(value = "min_ram_mb", required = false)
    private Long min_ram_mb;

    @JsonProperty("min_ram_mb")
    public Long getMinRamMb() {
      return min_ram_mb;
    }

    public ImageCreateRequestInput withMinRamMb(Long value) {
      this.min_ram_mb = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public ImageCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }

    public ImageCreateRequestInput withAttributes(Map<String, String> value) {
      this.attributes = value;
      return this;
    }
  }

  public static final class ImageCreateRequestInputOs {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ImageCreateRequestInputOs(String value) {
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
      return other instanceof ImageCreateRequestInputOs v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ImageCreateRequestInputOs ALMALINUX =
        new ImageCreateRequestInputOs("almalinux");
    public static final ImageCreateRequestInputOs ALPINE = new ImageCreateRequestInputOs("alpine");
    public static final ImageCreateRequestInputOs ARCH = new ImageCreateRequestInputOs("arch");
    public static final ImageCreateRequestInputOs CENTOS = new ImageCreateRequestInputOs("centos");
    public static final ImageCreateRequestInputOs DEBIAN = new ImageCreateRequestInputOs("debian");
    public static final ImageCreateRequestInputOs FEDORA = new ImageCreateRequestInputOs("fedora");
    public static final ImageCreateRequestInputOs OPENSUSE =
        new ImageCreateRequestInputOs("opensuse");
    public static final ImageCreateRequestInputOs RHEL = new ImageCreateRequestInputOs("rhel");
    public static final ImageCreateRequestInputOs ROCKY = new ImageCreateRequestInputOs("rocky");
    public static final ImageCreateRequestInputOs UBUNTU = new ImageCreateRequestInputOs("ubuntu");
    public static final ImageCreateRequestInputOs LINUX = new ImageCreateRequestInputOs("linux");
  }

  public static final class ImageCreateRequestInputArchitecture {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ImageCreateRequestInputArchitecture(String value) {
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
      return other instanceof ImageCreateRequestInputArchitecture v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ImageCreateRequestInputArchitecture AMD64 =
        new ImageCreateRequestInputArchitecture("amd64");
  }

  public static final class ImageResponse extends Model {
    public ImageResponse() {}

    @JsonProperty(value = "image", required = true)
    private Image image;

    @JsonProperty("image")
    public Image getImage() {
      return image;
    }
  }

  public static final class Image extends Model {
    public Image() {}

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

    @JsonProperty(value = "os", required = false)
    private String os;

    @JsonProperty("os")
    public String getOs() {
      return os;
    }

    @JsonProperty(value = "os_version", required = false)
    private String os_version;

    @JsonProperty("os_version")
    public String getOsVersion() {
      return os_version;
    }

    @JsonProperty(value = "architecture", required = true)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    /**
     * The build's identity within its name. Unique there: a name is a movable tag, so it can't also
     * be what tells two builds apart. Stamped as a UTC timestamp when the uploader didn't choose
     * one.
     */
    @JsonProperty(value = "version", required = true)
    private String version;

    @JsonProperty("version")
    public String getVersion() {
      return version;
    }

    /**
     * Whether this is the version resolve-by-name returns for its (name, architecture) — i.e. the
     * name's current tag target.
     */
    @JsonProperty(value = "is_current", required = false)
    private Boolean is_current;

    @JsonProperty("is_current")
    public Boolean getIsCurrent() {
      return is_current;
    }

    /**
     * The day this image's OS release stops receiving free security updates for a default install.
     * Absent when nobody has recorded one — which means unknown, not "supported indefinitely".
     * Platform images are withdrawn from the catalog a grace period after this date. They stay
     * bootable by id until then, and the date is published well ahead of it so you can plan the
     * move.
     */
    @JsonProperty(value = "eol_date", required = false)
    private String eol_date;

    @JsonProperty("eol_date")
    public String getEolDate() {
      return eol_date;
    }

    @JsonProperty(value = "size_bytes", required = false)
    private Long size_bytes;

    @JsonProperty("size_bytes")
    public Long getSizeBytes() {
      return size_bytes;
    }

    @JsonProperty(value = "min_disk_gb", required = false)
    private Long min_disk_gb;

    @JsonProperty("min_disk_gb")
    public Long getMinDiskGb() {
      return min_disk_gb;
    }

    @JsonProperty(value = "min_ram_mb", required = false)
    private Long min_ram_mb;

    @JsonProperty("min_ram_mb")
    public Long getMinRamMb() {
      return min_ram_mb;
    }

    /**
     * Error exactly while an active error fault exists; import and deletion progress remain
     * independently retryable.
     */
    @JsonProperty(value = "status", required = true)
    private ImageStatus status;

    @JsonProperty("status")
    public ImageStatus getStatus() {
      return status;
    }

    /**
     * Why this image was withdrawn. Present for withdrawn images, including those with an
     * independent error fault: end_of_life for platform release withdrawal (see eol_date), or
     * legacy for a migrated withdrawal whose original reason is unknown. Withdrawn images retain
     * their data but cannot be launched.
     */
    @JsonProperty(value = "withdrawal_reason", required = false)
    private String withdrawal_reason;

    @JsonProperty("withdrawal_reason")
    public String getWithdrawalReason() {
      return withdrawal_reason;
    }

    /**
     * Present in owner list/detail responses while image deletion is waiting for existing instance,
     * source-reservation, or instance-pool references. Counts include all referencing accounts
     * without disclosing their identities. The backing data remains intact; cleanup resumes when
     * references are gone. Independent faults may still set status to error.
     */
    @JsonProperty(value = "deletion_retention", required = false)
    private ImageDeletionRetention deletion_retention;

    @JsonProperty("deletion_retention")
    public ImageDeletionRetention getDeletionRetention() {
      return deletion_retention;
    }

    /**
     * Active faults, newest first. Empty for a healthy image. Error faults set status to error
     * without disabling an eligible import or cleanup retry.
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

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
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

  public static final class ImageStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ImageStatus(String value) {
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
      return other instanceof ImageStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ImageStatus PENDING = new ImageStatus("pending");
    public static final ImageStatus IMPORTING = new ImageStatus("importing");
    public static final ImageStatus ACTIVE = new ImageStatus("active");
    public static final ImageStatus ERROR = new ImageStatus("error");
    public static final ImageStatus DELETING = new ImageStatus("deleting");
    public static final ImageStatus WITHDRAWN = new ImageStatus("withdrawn");
  }

  public static final class ImageDeletionRetention extends Model {
    public ImageDeletionRetention() {}

    @JsonProperty(value = "reason", required = true)
    private ImageDeletionRetentionReason reason;

    @JsonProperty("reason")
    public ImageDeletionRetentionReason getReason() {
      return reason;
    }

    @JsonProperty(value = "instances", required = true)
    private Long instances;

    @JsonProperty("instances")
    public Long getInstances() {
      return instances;
    }

    @JsonProperty(value = "instance_pools", required = true)
    private Long instance_pools;

    @JsonProperty("instance_pools")
    public Long getInstancePools() {
      return instance_pools;
    }
  }

  public static final class ImageDeletionRetentionReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ImageDeletionRetentionReason(String value) {
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
      return other instanceof ImageDeletionRetentionReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ImageDeletionRetentionReason IN_USE =
        new ImageDeletionRetentionReason("in_use");
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

  public static final class InstanceCreateRequestInput extends Model {
    public InstanceCreateRequestInput() {}

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

    public InstanceCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public InstanceCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /** Regional flavor reference (UUID, CRN or exact name) */
    @JsonProperty(value = "flavor", required = true)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public InstanceCreateRequestInput withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    /**
     * Architecture for image names and name:version tags (default amd64); a CRN pins its own
     * architecture and version.
     */
    @JsonProperty(value = "architecture", required = false)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    public InstanceCreateRequestInput withArchitecture(String value) {
      this.architecture = value;
      return this;
    }

    /**
     * Image to clone the boot disk from. Required unless volumes contains an existing boot volume;
     * cannot be combined with an existing boot volume. Four forms are accepted: a complete
     * image/name/architecture/arch/version/version CRN; an image id; `name:version`, which pins one
     * build and is how you opt out of the tag moving under you; or a bare `name`, which follows the
     * tag to whichever build is current when the instance is created. Names prefer a usable
     * caller-owned build over a tagged platform catalog build for the requested architecture
     * (default amd64). A CRN pins owner, name, architecture and version. Resolution never retries
     * another reference kind; responses and stored templates retain the resolved image UUID.
     */
    @JsonProperty(value = "image", required = false)
    private String image;

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    public InstanceCreateRequestInput withImage(String value) {
      this.image = value;
      return this;
    }

    /**
     * Interfaces to attach, at least one. index 0 is the primary NIC. Required because an instance
     * with no interface boots with no network at all, and nothing inside it can add one afterwards.
     */
    @JsonProperty(value = "networks", required = true)
    private List<NetworkConfigInput> networks;

    @JsonProperty("networks")
    public List<NetworkConfigInput> getNetworks() {
      return networks;
    }

    public InstanceCreateRequestInput withNetworks(List<NetworkConfigInput> value) {
      this.networks = value;
      return this;
    }

    /**
     * New or existing disks bound with the instance, the boot disk included — mark it with `boot:
     * true`. At most one entry may. Omit the boot entry to take the image's minimum size and the
     * region's default tier.
     */
    @JsonProperty(value = "volumes", required = false)
    private List<InstanceLaunchVolumeInput> volumes;

    @JsonProperty("volumes")
    public List<InstanceLaunchVolumeInput> getVolumes() {
      return volumes;
    }

    public InstanceCreateRequestInput withVolumes(List<InstanceLaunchVolumeInput> value) {
      this.volumes = value;
      return this;
    }

    @JsonProperty(value = "metadata", required = false)
    private Map<String, String> metadata;

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
      return metadata;
    }

    public InstanceCreateRequestInput withMetadata(Map<String, String> value) {
      this.metadata = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InstanceCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /** Base64-encoded user data (cloud-init) */
    @JsonProperty(value = "user_data", required = false)
    private String user_data;

    @JsonProperty("user_data")
    public String getUserData() {
      return user_data;
    }

    public InstanceCreateRequestInput withUserData(String value) {
      this.user_data = value;
      return this;
    }

    /**
     * Attach an IAM role from the same account by UUID, CRN or exact name. The role's trust policy
     * must permit `crn:compute:*:*:instance/*` (or the specific instance CRN). The instance's IMDS
     * endpoint (169.254.169.254) mints short-lived STS credentials for this role from inside the
     * VM.
     */
    @JsonProperty(value = "iam_role", required = false)
    private String iam_role;

    @JsonProperty("iam_role")
    public String getIamRole() {
      return iam_role;
    }

    public InstanceCreateRequestInput withIamRole(String value) {
      this.iam_role = value;
      return this;
    }
  }

  public static final class NetworkConfigInput extends Model {
    public NetworkConfigInput() {}

    /**
     * Subnet UUID or complete VPC/subnet CRN. Bare names require a VPC parent and are rejected
     * here.
     */
    @JsonProperty(value = "subnet", required = true)
    private String subnet;

    @JsonProperty("subnet")
    public String getSubnet() {
      return subnet;
    }

    public NetworkConfigInput withSubnet(String value) {
      this.subnet = value;
      return this;
    }

    /**
     * Optional MAC address. Must be locally-administered (`X2:`, `X6:`, `XA:`, `XE:` in the first
     * octet). Generated when omitted.
     */
    @JsonProperty(value = "mac", required = false)
    private String mac;

    @JsonProperty("mac")
    public String getMac() {
      return mac;
    }

    public NetworkConfigInput withMac(String value) {
      this.mac = value;
      return this;
    }

    /**
     * Account-scoped security group references (UUID, CRN or name) to attach to this NIC. Each must
     * be owned by the same account. Empty list = no per-NIC ACLs (the platform's default-allow
     * stays in force).
     */
    @JsonProperty(value = "security_groups", required = false)
    private List<String> security_groups;

    @JsonProperty("security_groups")
    public List<String> getSecurityGroups() {
      return security_groups;
    }

    public NetworkConfigInput withSecurityGroups(List<String> value) {
      this.security_groups = value;
      return this;
    }

    /**
     * Allocate public floating IPs for this NIC at launch. Explicit families require matching guest
     * addresses and internet routes. Detach leaves the FIP reserved. No ordinary public IPv4
     * mapping exists.
     */
    @JsonProperty(value = "floating_ip_assignment", required = false)
    private NetworkConfigInputFloatingIpAssignment floating_ip_assignment;

    @JsonProperty("floating_ip_assignment")
    public NetworkConfigInputFloatingIpAssignment getFloatingIpAssignment() {
      return floating_ip_assignment;
    }

    public NetworkConfigInput withFloatingIpAssignment(
        NetworkConfigInputFloatingIpAssignment value) {
      this.floating_ip_assignment = value;
      return this;
    }

    @JsonProperty(value = "addresses", required = false)
    private List<AddressRequestInput> addresses;

    @JsonProperty("addresses")
    public List<AddressRequestInput> getAddresses() {
      return addresses;
    }

    public NetworkConfigInput withAddresses(List<AddressRequestInput> value) {
      this.addresses = value;
      return this;
    }
  }

  public static final class NetworkConfigInputFloatingIpAssignment {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public NetworkConfigInputFloatingIpAssignment(String value) {
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
      return other instanceof NetworkConfigInputFloatingIpAssignment v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final NetworkConfigInputFloatingIpAssignment NONE =
        new NetworkConfigInputFloatingIpAssignment("none");
    public static final NetworkConfigInputFloatingIpAssignment IPV4 =
        new NetworkConfigInputFloatingIpAssignment("ipv4");
    public static final NetworkConfigInputFloatingIpAssignment IPV6 =
        new NetworkConfigInputFloatingIpAssignment("ipv6");
    public static final NetworkConfigInputFloatingIpAssignment DUAL_STACK =
        new NetworkConfigInputFloatingIpAssignment("dual_stack");
    public static final NetworkConfigInputFloatingIpAssignment AUTO =
        new NetworkConfigInputFloatingIpAssignment("auto");
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

  public static final class InstanceLaunchVolumeInput {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InstanceLaunchVolumeInput(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "InstanceLaunchVolumeInput{[REDACTED]}";
    }

    public static InstanceLaunchVolumeInput ofVariant1(InstanceLaunchVolumeInputVariant1 value) {
      Model.validate(value);
      return new InstanceLaunchVolumeInput(Json.tree(value));
    }

    public Optional<InstanceLaunchVolumeInputVariant1> asVariant1() {
      try {
        InstanceLaunchVolumeInputVariant1 result =
            Json.convert(value, new TypeReference<InstanceLaunchVolumeInputVariant1>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static InstanceLaunchVolumeInput ofVariant2(InstanceLaunchVolumeInputVariant2 value) {
      Model.validate(value);
      return new InstanceLaunchVolumeInput(Json.tree(value));
    }

    public Optional<InstanceLaunchVolumeInputVariant2> asVariant2() {
      try {
        InstanceLaunchVolumeInputVariant2 result =
            Json.convert(value, new TypeReference<InstanceLaunchVolumeInputVariant2>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }
  }

  public static final class InstanceLaunchVolumeInputVariant1 extends Model {
    public InstanceLaunchVolumeInputVariant1() {}

    /** Select the one boot disk. Boot disks cannot specify mount_path or fstype. */
    @JsonProperty(value = "boot", required = false)
    private Boolean boot;

    @JsonProperty("boot")
    public Boolean getBoot() {
      return boot;
    }

    public InstanceLaunchVolumeInputVariant1 withBoot(Boolean value) {
      this.boot = value;
      return this;
    }

    /** Existing available volume UUID, name, or CRN. Mutually exclusive with new-disk settings. */
    @JsonProperty(value = "volume", required = true)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public InstanceLaunchVolumeInputVariant1 withVolume(String value) {
      this.volume = value;
      return this;
    }

    /** New disk capacity. Required for new data disks; boot disks default to the image minimum. */
    @JsonProperty(value = "size_gb", required = false)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    public InstanceLaunchVolumeInputVariant1 withSizeGb(Long value) {
      this.size_gb = value;
      return this;
    }

    /** New disk tier; omitted uses the region default. */
    @JsonProperty(value = "volume_type", required = false)
    private InstanceLaunchVolumeInputVariant1VolumeType volume_type;

    @JsonProperty("volume_type")
    public InstanceLaunchVolumeInputVariant1VolumeType getVolumeType() {
      return volume_type;
    }

    public InstanceLaunchVolumeInputVariant1 withVolumeType(
        InstanceLaunchVolumeInputVariant1VolumeType value) {
      this.volume_type = value;
      return this;
    }

    @JsonProperty(value = "performance", required = false)
    private VolumePerformanceRequestInput performance;

    @JsonProperty("performance")
    public VolumePerformanceRequestInput getPerformance() {
      return performance;
    }

    public InstanceLaunchVolumeInputVariant1 withPerformance(VolumePerformanceRequestInput value) {
      this.performance = value;
      return this;
    }

    /** Optional data disk mount path. The guest agent formats only blank disks. */
    @JsonProperty(value = "mount_path", required = false)
    private String mount_path;

    @JsonProperty("mount_path")
    public String getMountPath() {
      return mount_path;
    }

    public InstanceLaunchVolumeInputVariant1 withMountPath(String value) {
      this.mount_path = value;
      return this;
    }

    /** Optional filesystem for blank data disks; defaults to ext4. */
    @JsonProperty(value = "fstype", required = false)
    private String fstype;

    @JsonProperty("fstype")
    public String getFstype() {
      return fstype;
    }

    public InstanceLaunchVolumeInputVariant1 withFstype(String value) {
      this.fstype = value;
      return this;
    }

    @JsonProperty(value = "delete_on_termination", required = false)
    private JsonNode delete_on_termination;

    @JsonProperty("delete_on_termination")
    public JsonNode getDeleteOnTermination() {
      return delete_on_termination;
    }

    public InstanceLaunchVolumeInputVariant1 withDeleteOnTermination(JsonNode value) {
      this.delete_on_termination = value;
      return this;
    }

    /**
     * Independent schedules for a new disk. Names must be unique across the account and this
     * launch. Requires storage:CreateSnapshotPolicy. Existing disks keep their schedules and cannot
     * specify this field.
     */
    @JsonProperty(value = "snapshot_schedules", required = false)
    private List<SnapshotScheduleSettingsInput> snapshot_schedules;

    @JsonProperty("snapshot_schedules")
    public List<SnapshotScheduleSettingsInput> getSnapshotSchedules() {
      return snapshot_schedules;
    }

    public InstanceLaunchVolumeInputVariant1 withSnapshotSchedules(
        List<SnapshotScheduleSettingsInput> value) {
      this.snapshot_schedules = value;
      return this;
    }
  }

  public static final class InstanceLaunchVolumeInputVariant1VolumeType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InstanceLaunchVolumeInputVariant1VolumeType(String value) {
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
      return other instanceof InstanceLaunchVolumeInputVariant1VolumeType v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InstanceLaunchVolumeInputVariant1VolumeType SSD =
        new InstanceLaunchVolumeInputVariant1VolumeType("ssd");
    public static final InstanceLaunchVolumeInputVariant1VolumeType NVME =
        new InstanceLaunchVolumeInputVariant1VolumeType("nvme");
  }

  public static final class VolumePerformanceRequestInput extends Model {
    public VolumePerformanceRequestInput() {}

    @JsonProperty(value = "iops", required = false)
    private Long iops;

    @JsonProperty("iops")
    public Long getIops() {
      return iops;
    }

    public VolumePerformanceRequestInput withIops(Long value) {
      this.iops = value;
      return this;
    }

    @JsonProperty(value = "throughput_mib_s", required = false)
    private BigDecimal throughput_mib_s;

    @JsonProperty("throughput_mib_s")
    public BigDecimal getThroughputMibS() {
      return throughput_mib_s;
    }

    public VolumePerformanceRequestInput withThroughputMibS(BigDecimal value) {
      this.throughput_mib_s = value;
      return this;
    }
  }

  public static final class SnapshotScheduleSettingsInput extends Model {
    public SnapshotScheduleSettingsInput() {}

    /** Account-unique snapshot policy name, subject to resource-name validation. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public SnapshotScheduleSettingsInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public SnapshotScheduleSettingsInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "interval_minutes", required = true)
    private Long interval_minutes;

    @JsonProperty("interval_minutes")
    public Long getIntervalMinutes() {
      return interval_minutes;
    }

    public SnapshotScheduleSettingsInput withIntervalMinutes(Long value) {
      this.interval_minutes = value;
      return this;
    }

    @JsonProperty(value = "retention_count", required = true)
    private Long retention_count;

    @JsonProperty("retention_count")
    public Long getRetentionCount() {
      return retention_count;
    }

    public SnapshotScheduleSettingsInput withRetentionCount(Long value) {
      this.retention_count = value;
      return this;
    }

    @JsonProperty(value = "retention_days", required = false)
    private Long retention_days;

    @JsonProperty("retention_days")
    public Long getRetentionDays() {
      return retention_days;
    }

    public SnapshotScheduleSettingsInput withRetentionDays(Long value) {
      this.retention_days = value;
      return this;
    }

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public SnapshotScheduleSettingsInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public SnapshotScheduleSettingsInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class InstanceLaunchVolumeInputVariant2 extends Model {
    public InstanceLaunchVolumeInputVariant2() {}

    /** Select the one boot disk. Boot disks cannot specify mount_path or fstype. */
    @JsonProperty(value = "boot", required = false)
    private Boolean boot;

    @JsonProperty("boot")
    public Boolean getBoot() {
      return boot;
    }

    public InstanceLaunchVolumeInputVariant2 withBoot(Boolean value) {
      this.boot = value;
      return this;
    }

    /** Existing available volume UUID, name, or CRN. Mutually exclusive with new-disk settings. */
    @JsonProperty(value = "volume", required = false)
    private String volume;

    @JsonProperty("volume")
    public String getVolume() {
      return volume;
    }

    public InstanceLaunchVolumeInputVariant2 withVolume(String value) {
      this.volume = value;
      return this;
    }

    /** New disk capacity. Required for new data disks; boot disks default to the image minimum. */
    @JsonProperty(value = "size_gb", required = false)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    public InstanceLaunchVolumeInputVariant2 withSizeGb(Long value) {
      this.size_gb = value;
      return this;
    }

    /** New disk tier; omitted uses the region default. */
    @JsonProperty(value = "volume_type", required = false)
    private InstanceLaunchVolumeInputVariant2VolumeType volume_type;

    @JsonProperty("volume_type")
    public InstanceLaunchVolumeInputVariant2VolumeType getVolumeType() {
      return volume_type;
    }

    public InstanceLaunchVolumeInputVariant2 withVolumeType(
        InstanceLaunchVolumeInputVariant2VolumeType value) {
      this.volume_type = value;
      return this;
    }

    @JsonProperty(value = "performance", required = false)
    private VolumePerformanceRequestInput performance;

    @JsonProperty("performance")
    public VolumePerformanceRequestInput getPerformance() {
      return performance;
    }

    public InstanceLaunchVolumeInputVariant2 withPerformance(VolumePerformanceRequestInput value) {
      this.performance = value;
      return this;
    }

    /** Optional data disk mount path. The guest agent formats only blank disks. */
    @JsonProperty(value = "mount_path", required = false)
    private String mount_path;

    @JsonProperty("mount_path")
    public String getMountPath() {
      return mount_path;
    }

    public InstanceLaunchVolumeInputVariant2 withMountPath(String value) {
      this.mount_path = value;
      return this;
    }

    /** Optional filesystem for blank data disks; defaults to ext4. */
    @JsonProperty(value = "fstype", required = false)
    private String fstype;

    @JsonProperty("fstype")
    public String getFstype() {
      return fstype;
    }

    public InstanceLaunchVolumeInputVariant2 withFstype(String value) {
      this.fstype = value;
      return this;
    }

    /** Defaults true for new disks. Existing disks require false or omission and are retained. */
    @JsonProperty(value = "delete_on_termination", required = false)
    private Boolean delete_on_termination;

    @JsonProperty("delete_on_termination")
    public Boolean getDeleteOnTermination() {
      return delete_on_termination;
    }

    public InstanceLaunchVolumeInputVariant2 withDeleteOnTermination(Boolean value) {
      this.delete_on_termination = value;
      return this;
    }

    /**
     * Independent schedules for a new disk. Names must be unique across the account and this
     * launch. Requires storage:CreateSnapshotPolicy. Existing disks keep their schedules and cannot
     * specify this field.
     */
    @JsonProperty(value = "snapshot_schedules", required = false)
    private List<SnapshotScheduleSettingsInput> snapshot_schedules;

    @JsonProperty("snapshot_schedules")
    public List<SnapshotScheduleSettingsInput> getSnapshotSchedules() {
      return snapshot_schedules;
    }

    public InstanceLaunchVolumeInputVariant2 withSnapshotSchedules(
        List<SnapshotScheduleSettingsInput> value) {
      this.snapshot_schedules = value;
      return this;
    }
  }

  public static final class InstanceLaunchVolumeInputVariant2VolumeType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InstanceLaunchVolumeInputVariant2VolumeType(String value) {
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
      return other instanceof InstanceLaunchVolumeInputVariant2VolumeType v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InstanceLaunchVolumeInputVariant2VolumeType SSD =
        new InstanceLaunchVolumeInputVariant2VolumeType("ssd");
    public static final InstanceLaunchVolumeInputVariant2VolumeType NVME =
        new InstanceLaunchVolumeInputVariant2VolumeType("nvme");
  }

  public static final class CreateInstanceResponse extends Model {
    public CreateInstanceResponse() {}

    @JsonProperty(value = "instance", required = false)
    private Instance instance;

    @JsonProperty("instance")
    public Instance getInstance() {
      return instance;
    }
  }

  public static final class Instance extends Model {
    public Instance() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name */
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

    /**
     * Resolved flavor (compute size) the instance runs on. Omitted if the referenced flavor row has
     * been retired.
     */
    @JsonProperty(value = "flavor", required = false)
    private Flavor flavor;

    @JsonProperty("flavor")
    public Flavor getFlavor() {
      return flavor;
    }

    /**
     * Resolved source image the instance booted from. Omitted for a volume-only boot or if the
     * referenced image row is gone.
     */
    @JsonProperty(value = "image", required = false)
    private Image image;

    @JsonProperty("image")
    public Image getImage() {
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
     * Summary of the attached IAM role, visible with instance read access without iam:GetRole.
     * Omitted when no role is attached, the role was deleted, or it belongs to another account.
     * Sensitive role fields remain available only through the IAM API.
     */
    @JsonProperty(value = "iam_role", required = false)
    private InstanceRole iam_role;

    @JsonProperty("iam_role")
    public InstanceRole getIamRole() {
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

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = false)
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
    @JsonProperty(value = "desired_state", required = false)
    private InstanceDesiredState desired_state;

    @JsonProperty("desired_state")
    public InstanceDesiredState getDesiredState() {
      return desired_state;
    }

    /**
     * Where the instance actually is. Read this one to answer "is it up" — the transitional states
     * live here, not on desired_state, because nobody asks for `stopping`. desired_state=running
     * with current_state=stopped is an instance that was asked to start and has not come up yet.
     */
    @JsonProperty(value = "current_state", required = false)
    private CurrentState current_state;

    @JsonProperty("current_state")
    public CurrentState getCurrentState() {
      return current_state;
    }
  }

  public static final class Flavor extends Model {
    public Flavor() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Cloud Resource Name */
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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    /** Number of virtual CPUs */
    @JsonProperty(value = "vcpus", required = false)
    private Long vcpus;

    @JsonProperty("vcpus")
    public Long getVcpus() {
      return vcpus;
    }

    /** RAM in MB */
    @JsonProperty(value = "ram_mb", required = false)
    private Long ram_mb;

    @JsonProperty("ram_mb")
    public Long getRamMb() {
      return ram_mb;
    }

    /**
     * Host-pool routing. "shared" oversubscribes CPU for higher density; "dedicated" pins each vCPU
     * 1:1 to a physical core.
     */
    @JsonProperty(value = "class", required = false)
    private FlavorClass classValue;

    @JsonProperty("class")
    public FlavorClass getClassValue() {
      return classValue;
    }

    /**
     * Which product can book the flavor. "general" flavors are for regular instances and instance
     * pools; "loadbalancer" and "database" flavors are reserved for the managed products (their
     * nodes are platform- operated and priced accordingly) and cannot be used for regular
     * instances.
     */
    @JsonProperty(value = "family", required = false)
    private FlavorFamily family;

    @JsonProperty("family")
    public FlavorFamily getFamily() {
      return family;
    }

    /**
     * Aggregate instance network throughput limit in megabits per second. Omitted when uncapped.
     */
    @JsonProperty(value = "net_mbps", required = false)
    private Long net_mbps;

    @JsonProperty("net_mbps")
    public Long getNetMbps() {
      return net_mbps;
    }

    /** Guaranteed CPU floor as a percentage of each vCPU. Omitted when no floor is guaranteed. */
    @JsonProperty(value = "cpu_baseline_pct", required = false)
    private Long cpu_baseline_pct;

    @JsonProperty("cpu_baseline_pct")
    public Long getCpuBaselinePct() {
      return cpu_baseline_pct;
    }

    /**
     * CPU ceiling as a percentage of each vCPU. A value of 100 or an omitted field allows the full
     * vCPU count.
     */
    @JsonProperty(value = "cpu_burst_pct", required = false)
    private Long cpu_burst_pct;

    @JsonProperty("cpu_burst_pct")
    public Long getCpuBurstPct() {
      return cpu_burst_pct;
    }

    @JsonProperty(value = "status", required = false)
    private FlavorStatus status;

    @JsonProperty("status")
    public FlavorStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "updated_at", required = false)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class FlavorClass {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FlavorClass(String value) {
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
      return other instanceof FlavorClass v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FlavorClass SHARED = new FlavorClass("shared");
    public static final FlavorClass DEDICATED = new FlavorClass("dedicated");
  }

  public static final class FlavorFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FlavorFamily(String value) {
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
      return other instanceof FlavorFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FlavorFamily GENERAL = new FlavorFamily("general");
    public static final FlavorFamily LOADBALANCER = new FlavorFamily("loadbalancer");
    public static final FlavorFamily DATABASE = new FlavorFamily("database");
  }

  public static final class FlavorStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FlavorStatus(String value) {
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
      return other instanceof FlavorStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FlavorStatus ACTIVE = new FlavorStatus("active");
    public static final FlavorStatus DISABLED = new FlavorStatus("disabled");
  }

  public static final class InstanceRole extends Model {
    public InstanceRole() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Account-scoped role identity, as used in policy documents. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** Immutable role name. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }
  }

  public static final class InstanceDesiredState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InstanceDesiredState(String value) {
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
      return other instanceof InstanceDesiredState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InstanceDesiredState RUNNING = new InstanceDesiredState("running");
    public static final InstanceDesiredState STOPPED = new InstanceDesiredState("stopped");
    public static final InstanceDesiredState DELETED = new InstanceDesiredState("deleted");
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

  public static final class InstancePoolCreateRequestInput extends Model {
    public InstancePoolCreateRequestInput() {}

    @JsonProperty(value = "autoscaling", required = false)
    private AutoscalingPolicyInput autoscaling;

    @JsonProperty("autoscaling")
    public AutoscalingPolicyInput getAutoscaling() {
      return autoscaling;
    }

    public InstancePoolCreateRequestInput withAutoscaling(AutoscalingPolicyInput value) {
      this.autoscaling = value;
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

    public InstancePoolCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public InstancePoolCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * Labels on the pool resource, for IAM conditions (`basalt:RequestTag/&lt;key&gt;` here,
     * `basalt:ResourceTag/&lt;key&gt;` on later operations) and cost attribution. They are not
     * propagated to the instances the pool launches; `template.tags` is that set. A pool field,
     * sent beside `template`. Replica tags are only reachable through `template.tags`.
     */
    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InstancePoolCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "template", required = true)
    private InstancePoolTemplateRequestInput template;

    @JsonProperty("template")
    public InstancePoolTemplateRequestInput getTemplate() {
      return template;
    }

    public InstancePoolCreateRequestInput withTemplate(InstancePoolTemplateRequestInput value) {
      this.template = value;
      return this;
    }

    @JsonProperty(value = "desired_count", required = false)
    private Long desired_count;

    @JsonProperty("desired_count")
    public Long getDesiredCount() {
      return desired_count;
    }

    public InstancePoolCreateRequestInput withDesiredCount(Long value) {
      this.desired_count = value;
      return this;
    }

    @JsonProperty(value = "min_count", required = false)
    private Long min_count;

    @JsonProperty("min_count")
    public Long getMinCount() {
      return min_count;
    }

    public InstancePoolCreateRequestInput withMinCount(Long value) {
      this.min_count = value;
      return this;
    }

    /** A value of 0 means the pool holds no members until max_count is raised. */
    @JsonProperty(value = "max_count", required = false)
    private Long max_count;

    @JsonProperty("max_count")
    public Long getMaxCount() {
      return max_count;
    }

    public InstancePoolCreateRequestInput withMaxCount(Long value) {
      this.max_count = value;
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

  public static final class InstancePoolTemplateRequestInput extends Model {
    public InstancePoolTemplateRequestInput() {}

    /** Regional flavor reference (UUID, CRN or exact name). */
    @JsonProperty(value = "flavor", required = true)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public InstancePoolTemplateRequestInput withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    @JsonProperty(value = "architecture", required = false)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    public InstancePoolTemplateRequestInput withArchitecture(String value) {
      this.architecture = value;
      return this;
    }

    /**
     * Image to clone each replica's boot disk from. Accepts the same four forms instance create
     * does: an architecture-qualified CRN, an image id, `name:version`, or a bare `name`. Unlike
     * instance create, the reference is resolved ONCE, when the pool is created, and the resulting
     * image id is what every replica boots — including replacements spawned months later. A tag
     * re-resolved per replica would let a heal boot a newer build than its siblings, and a pool
     * whose members are quietly not identical is the premise of the primitive breaking silently. To
     * move a pool to a new build, change the template.
     */
    @JsonProperty(value = "image", required = false)
    private String image;

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    public InstancePoolTemplateRequestInput withImage(String value) {
      this.image = value;
      return this;
    }

    /** Per-replica interfaces. Index 0 is the primary NIC and is required; the rest are extras. */
    @JsonProperty(value = "networks", required = true)
    private List<NetworkConfigInput> networks;

    @JsonProperty("networks")
    public List<NetworkConfigInput> getNetworks() {
      return networks;
    }

    public InstancePoolTemplateRequestInput withNetworks(List<NetworkConfigInput> value) {
      this.networks = value;
      return this;
    }

    /** Base64-encoded user data (cloud-init), stamped on every replica. */
    @JsonProperty(value = "user_data", required = false)
    private String user_data;

    @JsonProperty("user_data")
    public String getUserData() {
      return user_data;
    }

    public InstancePoolTemplateRequestInput withUserData(String value) {
      this.user_data = value;
      return this;
    }

    @JsonProperty(value = "metadata", required = false)
    private Map<String, String> metadata;

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
      return metadata;
    }

    public InstancePoolTemplateRequestInput withMetadata(Map<String, String> value) {
      this.metadata = value;
      return this;
    }

    /**
     * Tags stamped on every instance this template launches. These are the replicas' tags, not the
     * pool's — the pool's own labels are the top-level `tags`, and the two are independent.
     * Changing them affects FUTURE launches only. The instances already running keep the tags they
     * were launched with, so between the change and a refresh the pool holds members carrying two
     * different tag sets; `stale_instance_count` is how many are still on the old one. POST
     * /v1/instance-pools/{pool_id}/refresh rolls them onto the current template.
     */
    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InstancePoolTemplateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * IAM role reference from the same account (UUID, CRN or exact name). PassRole and instance
     * trust authorization apply.
     */
    @JsonProperty(value = "iam_role", required = false)
    private String iam_role;

    @JsonProperty("iam_role")
    public String getIamRole() {
      return iam_role;
    }

    public InstancePoolTemplateRequestInput withIamRole(String value) {
      this.iam_role = value;
      return this;
    }

    /**
     * Per-replica disks, the boot disk included — mark it with `boot: true`. Each new replica
     * receives the configured provisioned performance. Omitted performance uses the included
     * allowance. Existing volumes and snapshot schedules are not supported in pool templates.
     */
    @JsonProperty(value = "volumes", required = false)
    private List<InstanceVolumeInput> volumes;

    @JsonProperty("volumes")
    public List<InstanceVolumeInput> getVolumes() {
      return volumes;
    }

    public InstancePoolTemplateRequestInput withVolumes(List<InstanceVolumeInput> value) {
      this.volumes = value;
      return this;
    }
  }

  public static final class InstanceVolumeInput extends Model {
    public InstanceVolumeInput() {}

    /**
     * Marks the boot disk. It takes no mount_path or fstype — both come from the image — and
     * sending either is refused rather than ignored.
     */
    @JsonProperty(value = "boot", required = false)
    private Boolean boot;

    @JsonProperty("boot")
    public Boolean getBoot() {
      return boot;
    }

    public InstanceVolumeInput withBoot(Boolean value) {
      this.boot = value;
      return this;
    }

    @JsonProperty(value = "size_gb", required = true)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    public InstanceVolumeInput withSizeGb(Long value) {
      this.size_gb = value;
      return this;
    }

    /** Tier; omitted = the region default. */
    @JsonProperty(value = "volume_type", required = false)
    private String volume_type;

    @JsonProperty("volume_type")
    public String getVolumeType() {
      return volume_type;
    }

    public InstanceVolumeInput withVolumeType(String value) {
      this.volume_type = value;
      return this;
    }

    @JsonProperty(value = "performance", required = false)
    private VolumePerformanceRequestInput performance;

    @JsonProperty("performance")
    public VolumePerformanceRequestInput getPerformance() {
      return performance;
    }

    public InstanceVolumeInput withPerformance(VolumePerformanceRequestInput value) {
      this.performance = value;
      return this;
    }

    @JsonProperty(value = "mount_path", required = false)
    private String mount_path;

    @JsonProperty("mount_path")
    public String getMountPath() {
      return mount_path;
    }

    public InstanceVolumeInput withMountPath(String value) {
      this.mount_path = value;
      return this;
    }

    /** Filesystem the in-guest agent formats the volume with. */
    @JsonProperty(value = "fstype", required = false)
    private String fstype;

    @JsonProperty("fstype")
    public String getFstype() {
      return fstype;
    }

    public InstanceVolumeInput withFstype(String value) {
      this.fstype = value;
      return this;
    }

    /** Destroyed with the instance unless set false. */
    @JsonProperty(value = "delete_on_termination", required = false)
    private Boolean delete_on_termination;

    @JsonProperty("delete_on_termination")
    public Boolean getDeleteOnTermination() {
      return delete_on_termination;
    }

    public InstanceVolumeInput withDeleteOnTermination(Boolean value) {
      this.delete_on_termination = value;
      return this;
    }
  }

  public static final class InstancePoolResponse extends Model {
    public InstancePoolResponse() {}

    @JsonProperty(value = "instance_pool", required = false)
    private InstancePool instance_pool;

    @JsonProperty("instance_pool")
    public InstancePool getInstancePool() {
      return instance_pool;
    }
  }

  public static final class InstancePool extends Model {
    public InstancePool() {}

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

    /** Temporary rollout capacity; desired_count remains the steady target. */
    @JsonProperty(value = "rollout_surge", required = false)
    private Boolean rollout_surge;

    @JsonProperty("rollout_surge")
    public Boolean getRolloutSurge() {
      return rollout_surge;
    }

    @JsonProperty(value = "retiring_instances", required = false)
    private List<RetiringPoolMember> retiring_instances;

    @JsonProperty("retiring_instances")
    public List<RetiringPoolMember> getRetiringInstances() {
      return retiring_instances;
    }

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * Cloud Resource Name. This is the value an IAM policy statement must name to scope a
     * permission to this pool alone; a policy written against anything else will not match.
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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "desired_count", required = false)
    private Long desired_count;

    @JsonProperty("desired_count")
    public Long getDesiredCount() {
      return desired_count;
    }

    @JsonProperty(value = "min_count", required = false)
    private Long min_count;

    @JsonProperty("min_count")
    public Long getMinCount() {
      return min_count;
    }

    /** A value of 0 means the pool holds no members until max_count is raised. */
    @JsonProperty(value = "max_count", required = false)
    private Long max_count;

    @JsonProperty("max_count")
    public Long getMaxCount() {
      return max_count;
    }

    /** How many members are UP — bound instances whose current_state is `running`. */
    @JsonProperty(value = "live_count", required = false)
    private Long live_count;

    @JsonProperty("live_count")
    public Long getLiveCount() {
      return live_count;
    }

    /**
     * How many instances the pool holds, running or not. This is what the reconciler converges
     * toward desired_count and what `status` reflects, so member_count == desired_count with
     * live_count below it means the pool has the members it was asked for and some of them are not
     * up.
     */
    @JsonProperty(value = "member_count", required = false)
    private Long member_count;

    @JsonProperty("member_count")
    public Long getMemberCount() {
      return member_count;
    }

    /**
     * True while a rolling replacement requested through POST /v1/instance-pools/{pool_id}/refresh
     * is still running. It clears itself once every member is on the current template. The pool
     * reads `scaling` for the duration, since it runs one instance over its target while a
     * replacement comes up.
     */
    @JsonProperty(value = "refresh_in_progress", required = false)
    private Boolean refresh_in_progress;

    @JsonProperty("refresh_in_progress")
    public Boolean getRefreshInProgress() {
      return refresh_in_progress;
    }

    /**
     * How many members were launched from a template other than the pool's current one — that is,
     * how many a refresh would replace. Non-zero after editing `template` and before refreshing,
     * which is the signal that a template change has not been rolled out yet.
     */
    @JsonProperty(value = "stale_instance_count", required = false)
    private Long stale_instance_count;

    @JsonProperty("stale_instance_count")
    public Long getStaleInstanceCount() {
      return stale_instance_count;
    }

    /**
     * Where the pool is against its target. `active` means member_count == desired_count — the pool
     * holds the members it was asked for. It is not a claim that all of them are up; read
     * live_count for that. `scaling` means it does not, and the reconciler is converging it: after
     * a create, after a desired_count change, and for the length of an instance refresh, which runs
     * the pool one instance over its target while a replacement comes up. `error` means an active
     * error fault exists. Capacity failures remain eligible for reconciliation; failed deletion
     * retains its teardown intent and never recreates members. `deleting` is teardown without an
     * active error.
     */
    @JsonProperty(value = "status", required = false)
    private InstancePoolStatus status;

    @JsonProperty("status")
    public InstancePoolStatus getStatus() {
      return status;
    }

    /**
     * Active faults, newest first. Empty for a healthy pool. Recovery resolves only the successful
     * operation's codes.
     */
    @JsonProperty(value = "faults", required = true)
    private List<Fault> faults;

    @JsonProperty("faults")
    public List<Fault> getFaults() {
      return faults;
    }

    @JsonProperty(value = "managed_by", required = false)
    private String managed_by;

    @JsonProperty("managed_by")
    public String getManagedBy() {
      return managed_by;
    }

    /**
     * Labels on the POOL itself, for IAM conditions (`basalt:ResourceTag/&lt;key&gt;`) and cost
     * attribution. They are attached to nothing else: no instance the pool launches carries them.
     * The tags a replica is launched with are `template.tags`. Unlike the other top-level fields
     * beside this one, `tags` is not a projection of the launch template — it is the pool's own
     * set, and PATCHable on its own.
     */
    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    /**
     * The pool's launch config, in the shape instance create takes. The only place it appears: a
     * flat copy of it beside this was two spellings of one thing, and two spellings drift.
     */
    @JsonProperty(value = "template", required = false)
    private InstancePoolTemplate template;

    @JsonProperty("template")
    public InstancePoolTemplate getTemplate() {
      return template;
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

  public static final class RetiringPoolMember extends Model {
    public RetiringPoolMember() {}

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

    @JsonProperty(value = "instance_id", required = true)
    private String instance_id;

    @JsonProperty("instance_id")
    public String getInstanceId() {
      return instance_id;
    }
  }

  public static final class InstancePoolStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InstancePoolStatus(String value) {
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
      return other instanceof InstancePoolStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InstancePoolStatus ACTIVE = new InstancePoolStatus("active");
    public static final InstancePoolStatus SCALING = new InstancePoolStatus("scaling");
    public static final InstancePoolStatus ERROR = new InstancePoolStatus("error");
    public static final InstancePoolStatus DELETING = new InstancePoolStatus("deleting");
  }

  public static final class InstancePoolTemplate extends Model {
    public InstancePoolTemplate() {}

    @JsonProperty(value = "flavor_id", required = false)
    private String flavor_id;

    @JsonProperty("flavor_id")
    public String getFlavorId() {
      return flavor_id;
    }

    /** Resolved image UUID pinned for every replica until template replacement. */
    @JsonProperty(value = "image_id", required = false)
    private String image_id;

    @JsonProperty("image_id")
    public String getImageId() {
      return image_id;
    }

    /** Per-replica interfaces. Index 0 is the primary NIC and is required; the rest are extras. */
    @JsonProperty(value = "networks", required = false)
    private List<NetworkConfigResponse> networks;

    @JsonProperty("networks")
    public List<NetworkConfigResponse> getNetworks() {
      return networks;
    }

    /** Base64-encoded user data (cloud-init), stamped on every replica. */
    @JsonProperty(value = "user_data", required = false)
    private String user_data;

    @JsonProperty("user_data")
    public String getUserData() {
      return user_data;
    }

    @JsonProperty(value = "metadata", required = false)
    private Map<String, String> metadata;

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
      return metadata;
    }

    /**
     * Tags stamped on every instance this template launches. These are the replicas' tags, not the
     * pool's — the pool's own labels are the top-level `tags`, and the two are independent.
     * Changing them affects FUTURE launches only. The instances already running keep the tags they
     * were launched with, so between the change and a refresh the pool holds members carrying two
     * different tag sets; `stale_instance_count` is how many are still on the old one. POST
     * /v1/instance-pools/{pool_id}/refresh rolls them onto the current template.
     */
    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    /**
     * Summary of the IAM role attached to every replica, visible with pool read access without
     * iam:GetRole. Omitted when no role is attached, the role was deleted, or it belongs to another
     * account. Sensitive role fields remain available only through the IAM API.
     */
    @JsonProperty(value = "iam_role", required = false)
    private InstanceRole iam_role;

    @JsonProperty("iam_role")
    public InstanceRole getIamRole() {
      return iam_role;
    }

    /**
     * Per-replica disks, the boot disk included — mark it with `boot: true`. Each new replica
     * receives the configured provisioned performance. Omitted performance uses the included
     * allowance. Existing volumes and snapshot schedules are not supported in pool templates.
     */
    @JsonProperty(value = "volumes", required = false)
    private List<InstanceVolume> volumes;

    @JsonProperty("volumes")
    public List<InstanceVolume> getVolumes() {
      return volumes;
    }
  }

  public static final class NetworkConfigResponse extends Model {
    public NetworkConfigResponse() {}

    /** Subnet placement; null when the referenced subnet no longer exists. */
    @JsonProperty(value = "subnet", required = true)
    private NetworkConfigResponseSubnet subnet;

    @JsonProperty("subnet")
    public NetworkConfigResponseSubnet getSubnet() {
      return subnet;
    }

    /**
     * Optional MAC address. Must be locally-administered (`X2:`, `X6:`, `XA:`, `XE:` in the first
     * octet). Generated when omitted.
     */
    @JsonProperty(value = "mac", required = false)
    private String mac;

    @JsonProperty("mac")
    public String getMac() {
      return mac;
    }

    /**
     * Account-scoped security group references (UUID, CRN or name) to attach to this NIC. Each must
     * be owned by the same account. Empty list = no per-NIC ACLs (the platform's default-allow
     * stays in force).
     */
    @JsonProperty(value = "security_group_ids", required = false)
    private List<String> security_group_ids;

    @JsonProperty("security_group_ids")
    public List<String> getSecurityGroupIds() {
      return security_group_ids;
    }

    /**
     * Allocate public floating IPs for this NIC at launch. Explicit families require matching guest
     * addresses and internet routes. Detach leaves the FIP reserved. No ordinary public IPv4
     * mapping exists.
     */
    @JsonProperty(value = "floating_ip_assignment", required = false)
    private NetworkConfigResponseFloatingIpAssignment floating_ip_assignment;

    @JsonProperty("floating_ip_assignment")
    public NetworkConfigResponseFloatingIpAssignment getFloatingIpAssignment() {
      return floating_ip_assignment;
    }

    @JsonProperty(value = "addresses", required = false)
    private List<AddressRequest> addresses;

    @JsonProperty("addresses")
    public List<AddressRequest> getAddresses() {
      return addresses;
    }
  }

  public static final class NetworkConfigResponseSubnet {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public NetworkConfigResponseSubnet(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "NetworkConfigResponseSubnet{[REDACTED]}";
    }

    public static NetworkConfigResponseSubnet ofVariant1(Subnet value) {
      Model.validate(value);
      return new NetworkConfigResponseSubnet(Json.tree(value));
    }

    public Optional<Subnet> asVariant1() {
      try {
        Subnet result = Json.convert(value, new TypeReference<Subnet>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static NetworkConfigResponseSubnet ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new NetworkConfigResponseSubnet(Json.tree(value));
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

  public static final class NetworkConfigResponseFloatingIpAssignment {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public NetworkConfigResponseFloatingIpAssignment(String value) {
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
      return other instanceof NetworkConfigResponseFloatingIpAssignment v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final NetworkConfigResponseFloatingIpAssignment NONE =
        new NetworkConfigResponseFloatingIpAssignment("none");
    public static final NetworkConfigResponseFloatingIpAssignment IPV4 =
        new NetworkConfigResponseFloatingIpAssignment("ipv4");
    public static final NetworkConfigResponseFloatingIpAssignment IPV6 =
        new NetworkConfigResponseFloatingIpAssignment("ipv6");
    public static final NetworkConfigResponseFloatingIpAssignment DUAL_STACK =
        new NetworkConfigResponseFloatingIpAssignment("dual_stack");
    public static final NetworkConfigResponseFloatingIpAssignment AUTO =
        new NetworkConfigResponseFloatingIpAssignment("auto");
  }

  public static final class AddressRequest extends Model {
    public AddressRequest() {}

    @JsonProperty(value = "family", required = true)
    private AddressRequestFamily family;

    @JsonProperty("family")
    public AddressRequestFamily getFamily() {
      return family;
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
  }

  public static final class AddressRequestFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AddressRequestFamily(String value) {
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
      return other instanceof AddressRequestFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AddressRequestFamily IPV4 = new AddressRequestFamily("ipv4");
    public static final AddressRequestFamily IPV6 = new AddressRequestFamily("ipv6");
  }

  public static final class InstanceVolume extends Model {
    public InstanceVolume() {}

    /**
     * Marks the boot disk. It takes no mount_path or fstype — both come from the image — and
     * sending either is refused rather than ignored.
     */
    @JsonProperty(value = "boot", required = false)
    private Boolean boot;

    @JsonProperty("boot")
    public Boolean getBoot() {
      return boot;
    }

    @JsonProperty(value = "size_gb", required = true)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    /** Tier; omitted = the region default. */
    @JsonProperty(value = "volume_type", required = false)
    private String volume_type;

    @JsonProperty("volume_type")
    public String getVolumeType() {
      return volume_type;
    }

    @JsonProperty(value = "performance", required = false)
    private VolumePerformanceRequest performance;

    @JsonProperty("performance")
    public VolumePerformanceRequest getPerformance() {
      return performance;
    }

    @JsonProperty(value = "mount_path", required = false)
    private String mount_path;

    @JsonProperty("mount_path")
    public String getMountPath() {
      return mount_path;
    }

    /** Filesystem the in-guest agent formats the volume with. */
    @JsonProperty(value = "fstype", required = false)
    private String fstype;

    @JsonProperty("fstype")
    public String getFstype() {
      return fstype;
    }

    /** Destroyed with the instance unless set false. */
    @JsonProperty(value = "delete_on_termination", required = false)
    private Boolean delete_on_termination;

    @JsonProperty("delete_on_termination")
    public Boolean getDeleteOnTermination() {
      return delete_on_termination;
    }
  }

  public static final class VolumePerformanceRequest extends Model {
    public VolumePerformanceRequest() {}

    @JsonProperty(value = "iops", required = false)
    private Long iops;

    @JsonProperty("iops")
    public Long getIops() {
      return iops;
    }

    @JsonProperty(value = "throughput_mib_s", required = false)
    private BigDecimal throughput_mib_s;

    @JsonProperty("throughput_mib_s")
    public BigDecimal getThroughputMibS() {
      return throughput_mib_s;
    }
  }

  public static final class SerialConsoleTicket extends Model {
    public SerialConsoleTicket() {}

    /**
     * The credential. Opaque — do not parse it. Good for one instance and one minute; mint a new
     * one per connection rather than storing it.
     */
    @JsonProperty(value = "ticket", required = true)
    private String ticket;

    @JsonProperty("ticket")
    public String getTicket() {
      return ticket;
    }

    @JsonProperty(value = "expires_at", required = true)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    /** Seconds until it expires. */
    @JsonProperty(value = "expires_in", required = true)
    private Long expires_in;

    @JsonProperty("expires_in")
    public Long getExpiresIn() {
      return expires_in;
    }
  }

  public static final class GetConsoleOutputQuery extends Model {
    public GetConsoleOutputQuery() {}

    @JsonProperty(value = "max_bytes", required = false)
    private Long max_bytes;

    @JsonProperty("max_bytes")
    public Long getMaxBytes() {
      return max_bytes;
    }

    public GetConsoleOutputQuery withMaxBytes(Long value) {
      this.max_bytes = value;
      return this;
    }
  }

  public static final class GetConsoleOutputResponse extends Model {
    public GetConsoleOutputResponse() {}

    /**
     * The transcript as plain text, newlines included. Empty when the instance has not booted yet.
     */
    @JsonProperty(value = "output", required = true)
    private String output;

    @JsonProperty("output")
    public String getOutput() {
      return output;
    }

    /**
     * True when the transcript was longer than the requested size and its BEGINNING was dropped to
     * fit. The end is always kept.
     */
    @JsonProperty(value = "truncated", required = true)
    private Boolean truncated;

    @JsonProperty("truncated")
    public Boolean getTruncated() {
      return truncated;
    }
  }

  public static final class GetFlavorResponse extends Model {
    public GetFlavorResponse() {}

    @JsonProperty(value = "flavor", required = false)
    private Flavor flavor;

    @JsonProperty("flavor")
    public Flavor getFlavor() {
      return flavor;
    }
  }

  public static final class GetFlavorScope extends Model {
    public GetFlavorScope() {}

    @JsonProperty(value = "family", required = false)
    private GetFlavorScopeFamily family;

    @JsonProperty("family")
    public GetFlavorScopeFamily getFamily() {
      return family;
    }

    public GetFlavorScope withFamily(GetFlavorScopeFamily value) {
      this.family = value;
      return this;
    }
  }

  public static final class GetFlavorScopeFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GetFlavorScopeFamily(String value) {
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
      return other instanceof GetFlavorScopeFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final GetFlavorScopeFamily GENERAL = new GetFlavorScopeFamily("general");
    public static final GetFlavorScopeFamily LOADBALANCER =
        new GetFlavorScopeFamily("loadbalancer");
    public static final GetFlavorScopeFamily DATABASE = new GetFlavorScopeFamily("database");
  }

  public static final class GetImageScope extends Model {
    public GetImageScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetImageScope withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "os", required = false)
    private String os;

    @JsonProperty("os")
    public String getOs() {
      return os;
    }

    public GetImageScope withOs(String value) {
      this.os = value;
      return this;
    }

    @JsonProperty(value = "architecture", required = false)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    public GetImageScope withArchitecture(String value) {
      this.architecture = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private GetImageScopeStatus status;

    @JsonProperty("status")
    public GetImageScopeStatus getStatus() {
      return status;
    }

    public GetImageScope withStatus(GetImageScopeStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "all_versions", required = false)
    private Boolean all_versions;

    @JsonProperty("all_versions")
    public Boolean getAllVersions() {
      return all_versions;
    }

    public GetImageScope withAllVersions(Boolean value) {
      this.all_versions = value;
      return this;
    }
  }

  public static final class GetImageScopeStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GetImageScopeStatus(String value) {
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
      return other instanceof GetImageScopeStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final GetImageScopeStatus PENDING = new GetImageScopeStatus("pending");
    public static final GetImageScopeStatus IMPORTING = new GetImageScopeStatus("importing");
    public static final GetImageScopeStatus ACTIVE = new GetImageScopeStatus("active");
    public static final GetImageScopeStatus ERROR = new GetImageScopeStatus("error");
    public static final GetImageScopeStatus DELETING = new GetImageScopeStatus("deleting");
    public static final GetImageScopeStatus WITHDRAWN = new GetImageScopeStatus("withdrawn");
  }

  public static final class GetInstanceResponse extends Model {
    public GetInstanceResponse() {}

    @JsonProperty(value = "instance", required = false)
    private Instance instance;

    @JsonProperty("instance")
    public Instance getInstance() {
      return instance;
    }
  }

  public static final class GetInstanceScope extends Model {
    public GetInstanceScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetInstanceScope withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "current_state", required = false)
    private CurrentStateInput current_state;

    @JsonProperty("current_state")
    public CurrentStateInput getCurrentState() {
      return current_state;
    }

    public GetInstanceScope withCurrentState(CurrentStateInput value) {
      this.current_state = value;
      return this;
    }

    @JsonProperty(value = "flavor", required = false)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public GetInstanceScope withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    @JsonProperty(value = "image", required = false)
    private String image;

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    public GetInstanceScope withImage(String value) {
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

  public static final class GetInstancePoolScope extends Model {
    public GetInstancePoolScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetInstancePoolScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListFlavorsQuery extends Model {
    public ListFlavorsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListFlavorsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListFlavorsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "family", required = false)
    private ListFlavorsQueryFamily family;

    @JsonProperty("family")
    public ListFlavorsQueryFamily getFamily() {
      return family;
    }

    public ListFlavorsQuery withFamily(ListFlavorsQueryFamily value) {
      this.family = value;
      return this;
    }
  }

  public static final class ListFlavorsQueryFamily {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListFlavorsQueryFamily(String value) {
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
      return other instanceof ListFlavorsQueryFamily v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListFlavorsQueryFamily GENERAL = new ListFlavorsQueryFamily("general");
    public static final ListFlavorsQueryFamily LOADBALANCER =
        new ListFlavorsQueryFamily("loadbalancer");
    public static final ListFlavorsQueryFamily DATABASE = new ListFlavorsQueryFamily("database");
  }

  public static final class FlavorListResponse extends Model {
    public FlavorListResponse() {}

    @JsonProperty(value = "flavors", required = false)
    private List<Flavor> flavors;

    @JsonProperty("flavors")
    public List<Flavor> getFlavors() {
      return flavors;
    }
  }

  public static final class ListImageCatalogQuery extends Model {
    public ListImageCatalogQuery() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListImageCatalogQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListImageCatalogQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListImageCatalogQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "os", required = false)
    private String os;

    @JsonProperty("os")
    public String getOs() {
      return os;
    }

    public ListImageCatalogQuery withOs(String value) {
      this.os = value;
      return this;
    }

    @JsonProperty(value = "architecture", required = false)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    public ListImageCatalogQuery withArchitecture(String value) {
      this.architecture = value;
      return this;
    }
  }

  public static final class ImageCatalogResponse extends Model {
    public ImageCatalogResponse() {}

    @JsonProperty(value = "categories", required = true)
    private List<ImageCatalogCategory> categories;

    @JsonProperty("categories")
    public List<ImageCatalogCategory> getCategories() {
      return categories;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ImageCatalogCategory extends Model {
    public ImageCatalogCategory() {}

    /** Catalog category. Currently platform or account; future categories may include apps. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "images", required = true)
    private List<CatalogImage> images;

    @JsonProperty("images")
    public List<CatalogImage> getImages() {
      return images;
    }
  }

  public static final class CatalogImage extends Model {
    public CatalogImage() {}

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

    @JsonProperty(value = "os", required = false)
    private String os;

    @JsonProperty("os")
    public String getOs() {
      return os;
    }

    @JsonProperty(value = "os_version", required = false)
    private String os_version;

    @JsonProperty("os_version")
    public String getOsVersion() {
      return os_version;
    }

    @JsonProperty(value = "architecture", required = true)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    @JsonProperty(value = "min_disk_gb", required = true)
    private Long min_disk_gb;

    @JsonProperty("min_disk_gb")
    public Long getMinDiskGb() {
      return min_disk_gb;
    }

    @JsonProperty(value = "min_ram_mb", required = true)
    private Long min_ram_mb;

    @JsonProperty("min_ram_mb")
    public Long getMinRamMb() {
      return min_ram_mb;
    }

    @JsonProperty(value = "eol_date", required = false)
    private String eol_date;

    @JsonProperty("eol_date")
    public String getEolDate() {
      return eol_date;
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

  public static final class ListImagesQuery extends Model {
    public ListImagesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListImagesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListImagesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListImagesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "os", required = false)
    private String os;

    @JsonProperty("os")
    public String getOs() {
      return os;
    }

    public ListImagesQuery withOs(String value) {
      this.os = value;
      return this;
    }

    @JsonProperty(value = "architecture", required = false)
    private String architecture;

    @JsonProperty("architecture")
    public String getArchitecture() {
      return architecture;
    }

    public ListImagesQuery withArchitecture(String value) {
      this.architecture = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListImagesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "status", required = false)
    private ListImagesQueryStatus status;

    @JsonProperty("status")
    public ListImagesQueryStatus getStatus() {
      return status;
    }

    public ListImagesQuery withStatus(ListImagesQueryStatus value) {
      this.status = value;
      return this;
    }

    @JsonProperty(value = "all_versions", required = false)
    private Boolean all_versions;

    @JsonProperty("all_versions")
    public Boolean getAllVersions() {
      return all_versions;
    }

    public ListImagesQuery withAllVersions(Boolean value) {
      this.all_versions = value;
      return this;
    }
  }

  public static final class ListImagesQueryStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListImagesQueryStatus(String value) {
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
      return other instanceof ListImagesQueryStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListImagesQueryStatus PENDING = new ListImagesQueryStatus("pending");
    public static final ListImagesQueryStatus IMPORTING = new ListImagesQueryStatus("importing");
    public static final ListImagesQueryStatus ACTIVE = new ListImagesQueryStatus("active");
    public static final ListImagesQueryStatus ERROR = new ListImagesQueryStatus("error");
    public static final ListImagesQueryStatus DELETING = new ListImagesQueryStatus("deleting");
    public static final ListImagesQueryStatus WITHDRAWN = new ListImagesQueryStatus("withdrawn");
  }

  public static final class ImageListResponse extends Model {
    public ImageListResponse() {}

    @JsonProperty(value = "images", required = true)
    private List<Image> images;

    @JsonProperty("images")
    public List<Image> getImages() {
      return images;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListInstanceNICsQuery extends Model {
    public ListInstanceNICsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInstanceNICsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInstanceNICsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListInstanceNICsResponse extends Model {
    public ListInstanceNICsResponse() {}

    @JsonProperty(value = "nics", required = false)
    private List<ListInstanceNICsResponseNicsItem> nics;

    @JsonProperty("nics")
    public List<ListInstanceNICsResponseNicsItem> getNics() {
      return nics;
    }
  }

  public static final class ListInstanceNICsResponseNicsItem extends Model {
    public ListInstanceNICsResponseNicsItem() {}

    @JsonProperty(value = "interface_id", required = true)
    private String interface_id;

    @JsonProperty("interface_id")
    public String getInterfaceId() {
      return interface_id;
    }

    @JsonProperty(value = "boot_index", required = true)
    private Long boot_index;

    @JsonProperty("boot_index")
    public Long getBootIndex() {
      return boot_index;
    }

    /** The lowest-boot-index NIC — the one carrying the guest's default and metadata routes. */
    @JsonProperty(value = "primary", required = true)
    private Boolean primary;

    @JsonProperty("primary")
    public Boolean getPrimary() {
      return primary;
    }

    /** A customer-attached standalone interface — detach unbinds it instead of destroying it. */
    @JsonProperty(value = "external", required = true)
    private Boolean external;

    @JsonProperty("external")
    public Boolean getExternal() {
      return external;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "mac", required = false)
    private String mac;

    @JsonProperty("mac")
    public String getMac() {
      return mac;
    }

    /** Subnet placement; null when the referenced subnet no longer exists. */
    @JsonProperty(value = "subnet", required = true)
    private ListInstanceNICsResponseNicsItemSubnet subnet;

    @JsonProperty("subnet")
    public ListInstanceNICsResponseNicsItemSubnet getSubnet() {
      return subnet;
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

  public static final class ListInstanceNICsResponseNicsItemSubnet {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListInstanceNICsResponseNicsItemSubnet(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "ListInstanceNICsResponseNicsItemSubnet{[REDACTED]}";
    }

    public static ListInstanceNICsResponseNicsItemSubnet ofVariant1(Subnet value) {
      Model.validate(value);
      return new ListInstanceNICsResponseNicsItemSubnet(Json.tree(value));
    }

    public Optional<Subnet> asVariant1() {
      try {
        Subnet result = Json.convert(value, new TypeReference<Subnet>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static ListInstanceNICsResponseNicsItemSubnet ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new ListInstanceNICsResponseNicsItemSubnet(Json.tree(value));
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

  public static final class ListInstanceNICsItem extends Model {
    public ListInstanceNICsItem() {}

    @JsonProperty(value = "interface_id", required = true)
    private String interface_id;

    @JsonProperty("interface_id")
    public String getInterfaceId() {
      return interface_id;
    }

    @JsonProperty(value = "boot_index", required = true)
    private Long boot_index;

    @JsonProperty("boot_index")
    public Long getBootIndex() {
      return boot_index;
    }

    /** The lowest-boot-index NIC — the one carrying the guest's default and metadata routes. */
    @JsonProperty(value = "primary", required = true)
    private Boolean primary;

    @JsonProperty("primary")
    public Boolean getPrimary() {
      return primary;
    }

    /** A customer-attached standalone interface — detach unbinds it instead of destroying it. */
    @JsonProperty(value = "external", required = true)
    private Boolean external;

    @JsonProperty("external")
    public Boolean getExternal() {
      return external;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "mac", required = false)
    private String mac;

    @JsonProperty("mac")
    public String getMac() {
      return mac;
    }

    /** Subnet placement; null when the referenced subnet no longer exists. */
    @JsonProperty(value = "subnet", required = true)
    private ListInstanceNICsItemSubnet subnet;

    @JsonProperty("subnet")
    public ListInstanceNICsItemSubnet getSubnet() {
      return subnet;
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

  public static final class ListInstanceNICsItemSubnet {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListInstanceNICsItemSubnet(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "ListInstanceNICsItemSubnet{[REDACTED]}";
    }

    public static ListInstanceNICsItemSubnet ofVariant1(Subnet value) {
      Model.validate(value);
      return new ListInstanceNICsItemSubnet(Json.tree(value));
    }

    public Optional<Subnet> asVariant1() {
      try {
        Subnet result = Json.convert(value, new TypeReference<Subnet>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static ListInstanceNICsItemSubnet ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new ListInstanceNICsItemSubnet(Json.tree(value));
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

  public static final class ListInstancePoolFloatingIpsQuery extends Model {
    public ListInstancePoolFloatingIpsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInstancePoolFloatingIpsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInstancePoolFloatingIpsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInstancePoolFloatingIpsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInstancePoolFloatingIpsQuery withMarker(String value) {
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

  public static final class ListInstancePoolsQuery extends Model {
    public ListInstancePoolsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInstancePoolsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInstancePoolsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInstancePoolsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInstancePoolsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class InstancePoolListResponse extends Model {
    public InstancePoolListResponse() {}

    @JsonProperty(value = "instance_pools", required = false)
    private List<InstancePool> instance_pools;

    @JsonProperty("instance_pools")
    public List<InstancePool> getInstancePools() {
      return instance_pools;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListInstanceVolumesQuery extends Model {
    public ListInstanceVolumesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInstanceVolumesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInstanceVolumesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListInstanceVolumesResponse extends Model {
    public ListInstanceVolumesResponse() {}

    @JsonProperty(value = "attachments", required = false)
    private List<ListInstanceVolumesResponseAttachmentsItem> attachments;

    @JsonProperty("attachments")
    public List<ListInstanceVolumesResponseAttachmentsItem> getAttachments() {
      return attachments;
    }
  }

  public static final class ListInstanceVolumesResponseAttachmentsItem extends Model {
    public ListInstanceVolumesResponseAttachmentsItem() {}

    @JsonProperty(value = "volume_id", required = false)
    private String volume_id;

    @JsonProperty("volume_id")
    public String getVolumeId() {
      return volume_id;
    }

    @JsonProperty(value = "device", required = false)
    private String device;

    @JsonProperty("device")
    public String getDevice() {
      return device;
    }

    @JsonProperty(value = "boot_index", required = false)
    private Long boot_index;

    @JsonProperty("boot_index")
    public Long getBootIndex() {
      return boot_index;
    }

    @JsonProperty(value = "delete_on_termination", required = false)
    private Boolean delete_on_termination;

    @JsonProperty("delete_on_termination")
    public Boolean getDeleteOnTermination() {
      return delete_on_termination;
    }

    @JsonProperty(value = "mount_path", required = false)
    private String mount_path;

    @JsonProperty("mount_path")
    public String getMountPath() {
      return mount_path;
    }

    /**
     * Filesystem the in-guest agent formatted the volume with, or absent when the attachment did
     * not name one and the agent used the ext4 default. Every write path — instance create, pool
     * template and attach — refuses anything else, so this is the whole set the field can hold.
     */
    @JsonProperty(value = "fstype", required = false)
    private ListInstanceVolumesResponseAttachmentsItemFstype fstype;

    @JsonProperty("fstype")
    public ListInstanceVolumesResponseAttachmentsItemFstype getFstype() {
      return fstype;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "volume_type", required = false)
    private String volume_type;

    @JsonProperty("volume_type")
    public String getVolumeType() {
      return volume_type;
    }

    @JsonProperty(value = "size_gb", required = false)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    @JsonProperty(value = "status", required = false)
    private String status;

    @JsonProperty("status")
    public String getStatus() {
      return status;
    }

    @JsonProperty(value = "bootable", required = false)
    private Boolean bootable;

    @JsonProperty("bootable")
    public Boolean getBootable() {
      return bootable;
    }

    @JsonProperty(value = "mount", required = false)
    private VolumeMount mount;

    @JsonProperty("mount")
    public VolumeMount getMount() {
      return mount;
    }
  }

  public static final class ListInstanceVolumesResponseAttachmentsItemFstype {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListInstanceVolumesResponseAttachmentsItemFstype(String value) {
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
      return other instanceof ListInstanceVolumesResponseAttachmentsItemFstype v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListInstanceVolumesResponseAttachmentsItemFstype EXT4 =
        new ListInstanceVolumesResponseAttachmentsItemFstype("ext4");
    public static final ListInstanceVolumesResponseAttachmentsItemFstype XFS =
        new ListInstanceVolumesResponseAttachmentsItemFstype("xfs");
  }

  public static final class VolumeMount extends Model {
    public VolumeMount() {}

    /**
     * - `unknown` — no guest agent has ever reported on this volume. The agent may predate this
     * feature, may have been removed (which is supported), or the guest may never have booted. -
     * `pending` — the agent cannot mount it yet and expects that to change. The ordinary state for
     * the first seconds after an attach, while the hot-plugged disk appears in the guest. -
     * `mounted` — mounted at `mount_path`. May still carry a `code`. - `failed` — it will not mount
     * until something changes. Either the agent reported a refusal that waiting cannot fix, or it
     * has been unable to make progress for long enough that waiting is no longer the explanation.
     * `code` says which.
     */
    @JsonProperty(value = "state", required = true)
    private VolumeMountState state;

    @JsonProperty("state")
    public VolumeMountState getState() {
      return state;
    }

    /**
     * Why the volume is in this state. Absent when there is nothing to say. Independent of `state`
     * rather than something only a failure carries: `fstab_write_failed` accompanies a **mounted**
     * volume whose fstab entry could not be written, which works now and will be gone after the
     * next reboot. The commonest one to act on is `signatures_no_filesystem` — the disk carries a
     * partition table or other signatures but no mountable filesystem, so the agent will not format
     * it, because formatting would destroy what is there. A volume cloned from a boot disk and
     * attached with a `mount_path` lands here. Partition and format it inside the guest, or attach
     * it without a `mount_path` and mount it yourself. `unknown_error` is a code this platform does
     * not recognise, reported by a guest agent newer than the region.
     */
    @JsonProperty(value = "code", required = false)
    private VolumeMountCode code;

    @JsonProperty("code")
    public VolumeMountCode getCode() {
      return code;
    }

    /**
     * Human-readable detail from inside the guest — the failing command's output, the partition
     * table type it found. Free text originating in the customer's own VM: sanitised and capped,
     * but display it as text, never as markup.
     */
    @JsonProperty(value = "message", required = false)
    private String message;

    @JsonProperty("message")
    public String getMessage() {
      return message;
    }

    /** When the volume entered this condition. Absent when `state` is `unknown`. */
    @JsonProperty(value = "since", required = false)
    private String since;

    @JsonProperty("since")
    public String getSince() {
      return since;
    }

    /**
     * When the guest agent last reported, whether or not anything had changed. A `reported_at` far
     * in the past means the agent has stopped talking to us, and the state beside it is what it
     * last said rather than what is true now. Absent when `state` is `unknown`.
     */
    @JsonProperty(value = "reported_at", required = false)
    private String reported_at;

    @JsonProperty("reported_at")
    public String getReportedAt() {
      return reported_at;
    }
  }

  public static final class VolumeMountState {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public VolumeMountState(String value) {
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
      return other instanceof VolumeMountState v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final VolumeMountState UNKNOWN = new VolumeMountState("unknown");
    public static final VolumeMountState PENDING = new VolumeMountState("pending");
    public static final VolumeMountState MOUNTED = new VolumeMountState("mounted");
    public static final VolumeMountState FAILED = new VolumeMountState("failed");
  }

  public static final class VolumeMountCode {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public VolumeMountCode(String value) {
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
      return other instanceof VolumeMountCode v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final VolumeMountCode UNSAFE_SERIAL = new VolumeMountCode("unsafe_serial");
    public static final VolumeMountCode DEVICE_ABSENT = new VolumeMountCode("device_absent");
    public static final VolumeMountCode PROBE_FAILED = new VolumeMountCode("probe_failed");
    public static final VolumeMountCode SIGNATURES_NO_FILESYSTEM =
        new VolumeMountCode("signatures_no_filesystem");
    public static final VolumeMountCode UNSUPPORTED_FSTYPE =
        new VolumeMountCode("unsupported_fstype");
    public static final VolumeMountCode MKFS_FAILED = new VolumeMountCode("mkfs_failed");
    public static final VolumeMountCode UNSAFE_MOUNT_PATH =
        new VolumeMountCode("unsafe_mount_path");
    public static final VolumeMountCode MKDIR_FAILED = new VolumeMountCode("mkdir_failed");
    public static final VolumeMountCode MOUNT_FAILED = new VolumeMountCode("mount_failed");
    public static final VolumeMountCode FSTAB_WRITE_FAILED =
        new VolumeMountCode("fstab_write_failed");
    public static final VolumeMountCode UNKNOWN_ERROR = new VolumeMountCode("unknown_error");
  }

  public static final class ListInstanceVolumesItem extends Model {
    public ListInstanceVolumesItem() {}

    @JsonProperty(value = "volume_id", required = false)
    private String volume_id;

    @JsonProperty("volume_id")
    public String getVolumeId() {
      return volume_id;
    }

    @JsonProperty(value = "device", required = false)
    private String device;

    @JsonProperty("device")
    public String getDevice() {
      return device;
    }

    @JsonProperty(value = "boot_index", required = false)
    private Long boot_index;

    @JsonProperty("boot_index")
    public Long getBootIndex() {
      return boot_index;
    }

    @JsonProperty(value = "delete_on_termination", required = false)
    private Boolean delete_on_termination;

    @JsonProperty("delete_on_termination")
    public Boolean getDeleteOnTermination() {
      return delete_on_termination;
    }

    @JsonProperty(value = "mount_path", required = false)
    private String mount_path;

    @JsonProperty("mount_path")
    public String getMountPath() {
      return mount_path;
    }

    /**
     * Filesystem the in-guest agent formatted the volume with, or absent when the attachment did
     * not name one and the agent used the ext4 default. Every write path — instance create, pool
     * template and attach — refuses anything else, so this is the whole set the field can hold.
     */
    @JsonProperty(value = "fstype", required = false)
    private ListInstanceVolumesItemFstype fstype;

    @JsonProperty("fstype")
    public ListInstanceVolumesItemFstype getFstype() {
      return fstype;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "volume_type", required = false)
    private String volume_type;

    @JsonProperty("volume_type")
    public String getVolumeType() {
      return volume_type;
    }

    @JsonProperty(value = "size_gb", required = false)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    @JsonProperty(value = "status", required = false)
    private String status;

    @JsonProperty("status")
    public String getStatus() {
      return status;
    }

    @JsonProperty(value = "bootable", required = false)
    private Boolean bootable;

    @JsonProperty("bootable")
    public Boolean getBootable() {
      return bootable;
    }

    @JsonProperty(value = "mount", required = false)
    private VolumeMount mount;

    @JsonProperty("mount")
    public VolumeMount getMount() {
      return mount;
    }
  }

  public static final class ListInstanceVolumesItemFstype {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListInstanceVolumesItemFstype(String value) {
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
      return other instanceof ListInstanceVolumesItemFstype v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListInstanceVolumesItemFstype EXT4 =
        new ListInstanceVolumesItemFstype("ext4");
    public static final ListInstanceVolumesItemFstype XFS =
        new ListInstanceVolumesItemFstype("xfs");
  }

  public static final class ListInstancesQuery extends Model {
    public ListInstancesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInstancesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInstancesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInstancesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInstancesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "current_state", required = false)
    private CurrentStateInput current_state;

    @JsonProperty("current_state")
    public CurrentStateInput getCurrentState() {
      return current_state;
    }

    public ListInstancesQuery withCurrentState(CurrentStateInput value) {
      this.current_state = value;
      return this;
    }

    @JsonProperty(value = "flavor", required = false)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public ListInstancesQuery withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    @JsonProperty(value = "image", required = false)
    private String image;

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    public ListInstancesQuery withImage(String value) {
      this.image = value;
      return this;
    }
  }

  public static final class InstanceListResponse extends Model {
    public InstanceListResponse() {}

    @JsonProperty(value = "instances", required = false)
    private List<Instance> instances;

    @JsonProperty("instances")
    public List<Instance> getInstances() {
      return instances;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListPoolInstancesQuery extends Model {
    public ListPoolInstancesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListPoolInstancesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListPoolInstancesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListPoolInstancesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListPoolInstancesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "current_state", required = false)
    private CurrentStateInput current_state;

    @JsonProperty("current_state")
    public CurrentStateInput getCurrentState() {
      return current_state;
    }

    public ListPoolInstancesQuery withCurrentState(CurrentStateInput value) {
      this.current_state = value;
      return this;
    }

    @JsonProperty(value = "flavor", required = false)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public ListPoolInstancesQuery withFlavor(String value) {
      this.flavor = value;
      return this;
    }

    @JsonProperty(value = "image", required = false)
    private String image;

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    public ListPoolInstancesQuery withImage(String value) {
      this.image = value;
      return this;
    }
  }

  public static final class InstanceRebootRequestInput extends Model {
    public InstanceRebootRequestInput() {}

    /**
     * Force a power cycle (destroy + start, equivalent to a reset button) instead of the default
     * ACPI graceful reboot the guest can act on.
     */
    @JsonProperty(value = "hard", required = false)
    private Boolean hard;

    @JsonProperty("hard")
    public Boolean getHard() {
      return hard;
    }

    public InstanceRebootRequestInput withHard(Boolean value) {
      this.hard = value;
      return this;
    }
  }

  public static final class ReinstallInstanceBody extends Model {
    public ReinstallInstanceBody() {}

    /**
     * Replacement image reference (UUID, architecture-qualified CRN, name or name:version). Omit to
     * reinstall from the instance's current image.
     */
    @JsonProperty(value = "image", required = false)
    private String image;

    @JsonProperty("image")
    public String getImage() {
      return image;
    }

    public ReinstallInstanceBody withImage(String value) {
      this.image = value;
      return this;
    }

    /**
     * Replacement boot disk size; omitted = the image's min_disk_gb. Must be within the volume size
     * range (1..16384) and at least the image's min_disk_gb.
     */
    @JsonProperty(value = "size_gb", required = false)
    private Long size_gb;

    @JsonProperty("size_gb")
    public Long getSizeGb() {
      return size_gb;
    }

    public ReinstallInstanceBody withSizeGb(Long value) {
      this.size_gb = value;
      return this;
    }

    /** Replacement boot disk tier; omitted = the region default. */
    @JsonProperty(value = "volume_type", required = false)
    private ReinstallInstanceBodyVolumeType volume_type;

    @JsonProperty("volume_type")
    public ReinstallInstanceBodyVolumeType getVolumeType() {
      return volume_type;
    }

    public ReinstallInstanceBody withVolumeType(ReinstallInstanceBodyVolumeType value) {
      this.volume_type = value;
      return this;
    }
  }

  public static final class ReinstallInstanceBodyVolumeType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ReinstallInstanceBodyVolumeType(String value) {
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
      return other instanceof ReinstallInstanceBodyVolumeType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ReinstallInstanceBodyVolumeType SSD =
        new ReinstallInstanceBodyVolumeType("ssd");
    public static final ReinstallInstanceBodyVolumeType NVME =
        new ReinstallInstanceBodyVolumeType("nvme");
  }

  public static final class ResizeInstanceBody extends Model {
    public ResizeInstanceBody() {}

    /** Regional flavor reference (UUID, CRN or exact name) to resize to. */
    @JsonProperty(value = "flavor", required = true)
    private String flavor;

    @JsonProperty("flavor")
    public String getFlavor() {
      return flavor;
    }

    public ResizeInstanceBody withFlavor(String value) {
      this.flavor = value;
      return this;
    }
  }

  public static final class StartSerialConsoleQuery extends Model {
    public StartSerialConsoleQuery() {}

    @JsonProperty(value = "backlog_bytes", required = false)
    private Long backlog_bytes;

    @JsonProperty("backlog_bytes")
    public Long getBacklogBytes() {
      return backlog_bytes;
    }

    public StartSerialConsoleQuery withBacklogBytes(Long value) {
      this.backlog_bytes = value;
      return this;
    }
  }

  public static final class ImageUpdateRequestInput extends Model {
    public ImageUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public ImageUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * Switch the resolve-by-name pointer for this image's name. true promotes this version to
     * current (the switch / rollback action) and demotes whatever else was current for the same
     * (name, architecture); false clears the pointer. Only active images can be made current.
     */
    @JsonProperty(value = "current", required = false)
    private Boolean current;

    @JsonProperty("current")
    public Boolean getCurrent() {
      return current;
    }

    public ImageUpdateRequestInput withCurrent(Boolean value) {
      this.current = value;
      return this;
    }

    /**
     * Set the release's end-of-life date. An explicit null clears it; omitting the field leaves it
     * unchanged. Clearing matters because the catalog withdraws platform images on this date — one
     * recorded by mistake has to be removable.
     */
    @JsonProperty(value = "eol_date", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> eol_date = JsonField.missing();

    @JsonProperty("eol_date")
    public JsonField<String> getEolDate() {
      return eol_date;
    }

    public ImageUpdateRequestInput withEolDate(JsonField<String> value) {
      this.eol_date = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public ImageUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "attributes", required = false)
    private Map<String, String> attributes;

    @JsonProperty("attributes")
    public Map<String, String> getAttributes() {
      return attributes;
    }

    public ImageUpdateRequestInput withAttributes(Map<String, String> value) {
      this.attributes = value;
      return this;
    }
  }

  public static final class InstanceUpdateRequestInput extends Model {
    public InstanceUpdateRequestInput() {}

    /**
     * Attach or replace the instance workload role using its ID, name, or CRN. Omit this field to
     * keep the current role; send an empty string to detach it. Null is not accepted. Requires
     * compute:UpdateInstance; attach/replace also require iam:PassRole and a role trust policy
     * allowing this instance. Only running or stopped customer-managed instances with no operation
     * in progress support role edits. Pool members use the pool launch template. New IMDS requests
     * observe the committed association immediately. Previously issued credentials are not revoked
     * and remain valid until expiry (up to one hour); in-flight requests may complete with their
     * prior association.
     */
    @JsonProperty(value = "iam_role", required = false)
    private String iam_role;

    @JsonProperty("iam_role")
    public String getIamRole() {
      return iam_role;
    }

    public InstanceUpdateRequestInput withIamRole(String value) {
      this.iam_role = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public InstanceUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "metadata", required = false)
    private Map<String, String> metadata;

    @JsonProperty("metadata")
    public Map<String, String> getMetadata() {
      return metadata;
    }

    public InstanceUpdateRequestInput withMetadata(Map<String, String> value) {
      this.metadata = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InstanceUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UpdateInstanceResponse extends Model {
    public UpdateInstanceResponse() {}

    @JsonProperty(value = "instance", required = false)
    private Instance instance;

    @JsonProperty("instance")
    public Instance getInstance() {
      return instance;
    }
  }

  public static final class InstancePoolUpdateRequestInput extends Model {
    public InstancePoolUpdateRequestInput() {}

    @JsonProperty(value = "autoscaling", required = false)
    private AutoscalingPolicyInput autoscaling;

    @JsonProperty("autoscaling")
    public AutoscalingPolicyInput getAutoscaling() {
      return autoscaling;
    }

    public InstancePoolUpdateRequestInput withAutoscaling(AutoscalingPolicyInput value) {
      this.autoscaling = value;
      return this;
    }

    /**
     * Customer note on the pool. Omit to preserve it; send an empty string to clear it. Changes no
     * instances, sizing or launch configuration.
     */
    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public InstancePoolUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * REPLACES the pool's labels: the map you send becomes the whole set, an empty object clears
     * them, and omitting the field leaves them alone. Replacement rather than a merge because a
     * merge leaves no way to say a key should be removed. These label the pool, not its instances.
     * To change what future replicas are tagged with, send `template.tags`.
     */
    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public InstancePoolUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * New target size, bounded by the resulting min_count/max_count and the hard platform cap of
     * 100.
     */
    @JsonProperty(value = "desired_count", required = false)
    private Long desired_count;

    @JsonProperty("desired_count")
    public Long getDesiredCount() {
      return desired_count;
    }

    public InstancePoolUpdateRequestInput withDesiredCount(Long value) {
      this.desired_count = value;
      return this;
    }

    /** New lower bound; omitted desired_count rises to this bound if needed. */
    @JsonProperty(value = "min_count", required = false)
    private Long min_count;

    @JsonProperty("min_count")
    public Long getMinCount() {
      return min_count;
    }

    public InstancePoolUpdateRequestInput withMinCount(Long value) {
      this.min_count = value;
      return this;
    }

    /**
     * New upper bound; omitted desired_count falls to this bound if needed. A value of 0 means the
     * pool holds no members until max_count is raised.
     */
    @JsonProperty(value = "max_count", required = false)
    private Long max_count;

    @JsonProperty("max_count")
    public Long getMaxCount() {
      return max_count;
    }

    public InstancePoolUpdateRequestInput withMaxCount(Long value) {
      this.max_count = value;
      return this;
    }

    /**
     * Replaces the launch config WHOLESALE — the object you send is what the pool launches next,
     * and anything you leave out is cleared rather than kept. Replacement rather than a deep merge
     * so a shorter `networks` or `volumes` cannot be read as a truncation and silently drop an
     * interface or a disk.
     */
    @JsonProperty(value = "template", required = false)
    private InstancePoolTemplateRequestInput template;

    @JsonProperty("template")
    public InstancePoolTemplateRequestInput getTemplate() {
      return template;
    }

    public InstancePoolUpdateRequestInput withTemplate(InstancePoolTemplateRequestInput value) {
      this.template = value;
      return this;
    }
  }

  public static final class UpdateInstanceVolumeAttachmentBody extends Model {
    public UpdateInstanceVolumeAttachmentBody() {}

    @JsonProperty(value = "delete_on_termination", required = true)
    private Boolean delete_on_termination;

    @JsonProperty("delete_on_termination")
    public Boolean getDeleteOnTermination() {
      return delete_on_termination;
    }

    public UpdateInstanceVolumeAttachmentBody withDeleteOnTermination(Boolean value) {
      this.delete_on_termination = value;
      return this;
    }
  }
}
