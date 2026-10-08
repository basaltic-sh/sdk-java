package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Compute.AttachInstanceNICBody;
import sh.basaltic.sdk.models.Compute.AttachInstanceNICResponse;
import sh.basaltic.sdk.models.Compute.AttachInstanceVolumeBody;
import sh.basaltic.sdk.models.Compute.AttachInstanceVolumeResponse;
import sh.basaltic.sdk.models.Compute.CreateInstanceResponse;
import sh.basaltic.sdk.models.Compute.Flavor;
import sh.basaltic.sdk.models.Compute.FlavorListResponse;
import sh.basaltic.sdk.models.Compute.FloatingIp;
import sh.basaltic.sdk.models.Compute.FloatingIpListResponse;
import sh.basaltic.sdk.models.Compute.GetConsoleOutputQuery;
import sh.basaltic.sdk.models.Compute.GetConsoleOutputResponse;
import sh.basaltic.sdk.models.Compute.GetFlavorResponse;
import sh.basaltic.sdk.models.Compute.GetFlavorScope;
import sh.basaltic.sdk.models.Compute.GetImageScope;
import sh.basaltic.sdk.models.Compute.GetInstancePoolScope;
import sh.basaltic.sdk.models.Compute.GetInstanceResponse;
import sh.basaltic.sdk.models.Compute.GetInstanceScope;
import sh.basaltic.sdk.models.Compute.Image;
import sh.basaltic.sdk.models.Compute.ImageCatalogCategory;
import sh.basaltic.sdk.models.Compute.ImageCatalogResponse;
import sh.basaltic.sdk.models.Compute.ImageCreateRequestInput;
import sh.basaltic.sdk.models.Compute.ImageListResponse;
import sh.basaltic.sdk.models.Compute.ImageResponse;
import sh.basaltic.sdk.models.Compute.ImageUpdateRequestInput;
import sh.basaltic.sdk.models.Compute.Instance;
import sh.basaltic.sdk.models.Compute.InstanceCreateRequestInput;
import sh.basaltic.sdk.models.Compute.InstanceListResponse;
import sh.basaltic.sdk.models.Compute.InstancePool;
import sh.basaltic.sdk.models.Compute.InstancePoolCreateRequestInput;
import sh.basaltic.sdk.models.Compute.InstancePoolFloatingIpAttachRequestInput;
import sh.basaltic.sdk.models.Compute.InstancePoolFloatingIpResponse;
import sh.basaltic.sdk.models.Compute.InstancePoolListResponse;
import sh.basaltic.sdk.models.Compute.InstancePoolResponse;
import sh.basaltic.sdk.models.Compute.InstancePoolUpdateRequestInput;
import sh.basaltic.sdk.models.Compute.InstanceRebootRequestInput;
import sh.basaltic.sdk.models.Compute.InstanceUpdateRequestInput;
import sh.basaltic.sdk.models.Compute.ListFlavorsQuery;
import sh.basaltic.sdk.models.Compute.ListImageCatalogQuery;
import sh.basaltic.sdk.models.Compute.ListImagesQuery;
import sh.basaltic.sdk.models.Compute.ListInstanceNICsItem;
import sh.basaltic.sdk.models.Compute.ListInstanceNICsQuery;
import sh.basaltic.sdk.models.Compute.ListInstanceNICsResponse;
import sh.basaltic.sdk.models.Compute.ListInstancePoolFloatingIpsQuery;
import sh.basaltic.sdk.models.Compute.ListInstancePoolsQuery;
import sh.basaltic.sdk.models.Compute.ListInstanceVolumesItem;
import sh.basaltic.sdk.models.Compute.ListInstanceVolumesQuery;
import sh.basaltic.sdk.models.Compute.ListInstanceVolumesResponse;
import sh.basaltic.sdk.models.Compute.ListInstancesQuery;
import sh.basaltic.sdk.models.Compute.ListPoolInstancesQuery;
import sh.basaltic.sdk.models.Compute.ReinstallInstanceBody;
import sh.basaltic.sdk.models.Compute.ResizeInstanceBody;
import sh.basaltic.sdk.models.Compute.SerialConsoleTicket;
import sh.basaltic.sdk.models.Compute.StartSerialConsoleQuery;
import sh.basaltic.sdk.models.Compute.UpdateInstanceResponse;
import sh.basaltic.sdk.models.Compute.UpdateInstanceVolumeAttachmentBody;

/** Typed compute API methods. */
public final class ComputeService {
  private final Transport transport;

  ComputeService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "attachInstanceNIC",
          "POST",
          "/v1/instances/{instance_id}/nics",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "attachInstancePoolFloatingIp",
          "POST",
          "/v1/instance-pools/{pool_id}/floating-ips",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "attachInstanceVolume",
          "POST",
          "/v1/instances/{instance_id}/volumes",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "createImage",
          "POST",
          "/v1/images",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "createInstance",
          "POST",
          "/v1/instances",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "createInstancePool",
          "POST",
          "/v1/instance-pools",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "createSerialConsoleTicket",
          "POST",
          "/v1/instances/{instance_id}/console/ticket",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "deleteImage",
          "DELETE",
          "/v1/images/{image_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "deleteInstance",
          "DELETE",
          "/v1/instances/{instance_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "deleteInstancePool",
          "DELETE",
          "/v1/instance-pools/{pool_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "detachInstanceNIC",
          "DELETE",
          "/v1/instances/{instance_id}/nics/{interface_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "detachInstancePoolFloatingIp",
          "DELETE",
          "/v1/instance-pools/{pool_id}/floating-ips/{floating_ip_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "detachInstanceVolume",
          "DELETE",
          "/v1/instances/{instance_id}/volumes/{volume_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "getConsoleOutput",
          "GET",
          "/v1/instances/{instance_id}/console/output",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(Map.entry("max_bytes", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "getConsoleScreenshot",
          "GET",
          "/v1/instances/{instance_id}/console/screenshot",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_15 =
      new Operation(
          "getFlavor",
          "GET",
          "/v1/flavors/{flavor_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "getImage",
          "GET",
          "/v1/images/{image_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "getInstance",
          "GET",
          "/v1/instances/{instance_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "getInstancePool",
          "GET",
          "/v1/instance-pools/{pool_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "listFlavors",
          "GET",
          "/v1/flavors",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("family", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "listImageCatalog",
          "GET",
          "/v1/image-catalog",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("os", new Operation.Encoding("form", true)),
              Map.entry("architecture", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "listImages",
          "GET",
          "/v1/images",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("os", new Operation.Encoding("form", true)),
              Map.entry("architecture", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("all_versions", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "listInstanceNICs",
          "GET",
          "/v1/instances/{instance_id}/nics",
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
          "listInstancePoolFloatingIps",
          "GET",
          "/v1/instance-pools/{pool_id}/floating-ips",
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
  private static final Operation OP_24 =
      new Operation(
          "listInstancePools",
          "GET",
          "/v1/instance-pools",
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
  private static final Operation OP_25 =
      new Operation(
          "listInstanceVolumes",
          "GET",
          "/v1/instances/{instance_id}/volumes",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_26 =
      new Operation(
          "listInstances",
          "GET",
          "/v1/instances",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("current_state", new Operation.Encoding("form", true)),
              Map.entry("flavor", new Operation.Encoding("form", true)),
              Map.entry("image", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_27 =
      new Operation(
          "listPoolInstances",
          "GET",
          "/v1/instance-pools/{pool_id}/instances",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("current_state", new Operation.Encoding("form", true)),
              Map.entry("flavor", new Operation.Encoding("form", true)),
              Map.entry("image", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_28 =
      new Operation(
          "rebootInstance",
          "POST",
          "/v1/instances/{instance_id}/reboot",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_29 =
      new Operation(
          "refreshInstancePool",
          "POST",
          "/v1/instance-pools/{pool_id}/refresh",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_30 =
      new Operation(
          "reinstallInstance",
          "POST",
          "/v1/instances/{instance_id}/reinstall",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_31 =
      new Operation(
          "resizeInstance",
          "POST",
          "/v1/instances/{instance_id}/resize",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_32 =
      new Operation(
          "startInstance",
          "POST",
          "/v1/instances/{instance_id}/start",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_33 =
      new Operation(
          "startSerialConsole",
          "GET",
          "/v1/instances/{instance_id}/console/serial",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(Map.entry("backlog_bytes", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_34 =
      new Operation(
          "stopInstance",
          "POST",
          "/v1/instances/{instance_id}/stop",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_35 =
      new Operation(
          "updateImage",
          "PATCH",
          "/v1/images/{image_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_36 =
      new Operation(
          "updateInstance",
          "PATCH",
          "/v1/instances/{instance_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_37 =
      new Operation(
          "updateInstancePool",
          "PATCH",
          "/v1/instance-pools/{pool_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_38 =
      new Operation(
          "updateInstanceVolumeAttachment",
          "PATCH",
          "/v1/instances/{instance_id}/volumes/{volume_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Attach an existing NIC to an instance */
  public Request<AttachInstanceNICResponse> attachInstanceNIC(
      String instance_id, AttachInstanceNICBody body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            body,
            null),
        new TypeReference<AttachInstanceNICResponse>() {});
  }

  /** Give the pool a shared public address */
  public Request<InstancePoolFloatingIpResponse> attachInstancePoolFloatingIp(
      String pool_id, InstancePoolFloatingIpAttachRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("pool_id", pool_id)),
            body,
            null),
        new TypeReference<InstancePoolFloatingIpResponse>() {});
  }

  /** Attach a data volume to an instance */
  public Request<AttachInstanceVolumeResponse> attachInstanceVolume(
      String instance_id, AttachInstanceVolumeBody body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            body,
            null),
        new TypeReference<AttachInstanceVolumeResponse>() {});
  }

  /** Import an image from an object URL */
  public Request<ImageResponse> createImage(ImageCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<ImageResponse>() {});
  }

  /** Create instance */
  public Request<CreateInstanceResponse> createInstance(InstanceCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<CreateInstanceResponse>() {});
  }

  /** Create an instance pool */
  public Request<InstancePoolResponse> createInstancePool(InstancePoolCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<InstancePoolResponse>() {});
  }

  /** Mint a ticket for the serial console */
  public Request<SerialConsoleTicket> createSerialConsoleTicket(String instance_id) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            null),
        new TypeReference<SerialConsoleTicket>() {});
  }

  /** Delete an unused image */
  public Request<ImageResponse> deleteImage(String image_id) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("image_id", image_id)),
            null,
            null),
        new TypeReference<ImageResponse>() {});
  }

  /** Delete instance */
  public EmptyRequest deleteInstance(String instance_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            null));
  }

  /** Delete an instance pool */
  public EmptyRequest deleteInstancePool(String pool_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("pool_id", pool_id)),
            null,
            null));
  }

  /** Detach a NIC from a running instance */
  public EmptyRequest detachInstanceNIC(String instance_id, String interface_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(
                Map.entry("instance_id", instance_id), Map.entry("interface_id", interface_id)),
            null,
            null));
  }

  /** Take a shared address off the pool */
  public EmptyRequest detachInstancePoolFloatingIp(String pool_id, String floating_ip_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(
                Map.entry("pool_id", pool_id), Map.entry("floating_ip_id", floating_ip_id)),
            null,
            null));
  }

  /** Detach a data volume from an instance */
  public EmptyRequest detachInstanceVolume(String instance_id, String volume_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("instance_id", instance_id), Map.entry("volume_id", volume_id)),
            null,
            null));
  }

  /** Get the instance's serial console output */
  public Request<GetConsoleOutputResponse> getConsoleOutput(
      String instance_id, GetConsoleOutputQuery query) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            query),
        new TypeReference<GetConsoleOutputResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<GetConsoleOutputResponse> getConsoleOutput(String instance_id) {
    return getConsoleOutput(instance_id, null);
  }

  /** Capture the instance's display */
  public BinaryRequest getConsoleScreenshot(String instance_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            null));
  }

  /** Get flavor */
  public Request<GetFlavorResponse> getFlavor(String flavor_id) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("flavor_id", flavor_id)),
            null,
            null),
        new TypeReference<GetFlavorResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Flavor> getFlavorByReference(String reference, GetFlavorScope scope) {
    return Request.reference(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("flavor_id", reference)),
            null,
            null),
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "flavor",
        "flavors",
        new TypeReference<Flavor>() {});
  }

  public Request<Flavor> getFlavorByReference(String reference) {
    return getFlavorByReference(reference, null);
  }

  /** Get an image */
  public Request<ImageResponse> getImage(String image_id) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("image_id", image_id)),
            null,
            null),
        new TypeReference<ImageResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Image> getImageByReference(String reference, GetImageScope scope) {
    return Request.reference(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("image_id", reference)),
            null,
            null),
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "image",
        "images",
        new TypeReference<Image>() {});
  }

  public Request<Image> getImageByReference(String reference) {
    return getImageByReference(reference, null);
  }

  /** Get instance */
  public Request<GetInstanceResponse> getInstance(String instance_id) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            null),
        new TypeReference<GetInstanceResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Instance> getInstanceByReference(String reference, GetInstanceScope scope) {
    return Request.reference(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("instance_id", reference)),
            null,
            null),
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_26,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "instance",
        "instances",
        new TypeReference<Instance>() {});
  }

  public Request<Instance> getInstanceByReference(String reference) {
    return getInstanceByReference(reference, null);
  }

  /** Get an instance pool */
  public Request<InstancePoolResponse> getInstancePool(String pool_id) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("pool_id", pool_id)),
            null,
            null),
        new TypeReference<InstancePoolResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<InstancePool> getInstancePoolByReference(
      String reference, GetInstancePoolScope scope) {
    return Request.reference(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("pool_id", reference)),
            null,
            null),
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_24,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "instance_pool",
        "instance_pools",
        new TypeReference<InstancePool>() {});
  }

  public Request<InstancePool> getInstancePoolByReference(String reference) {
    return getInstancePoolByReference(reference, null);
  }

  /** List flavors */
  public PagedRequest<FlavorListResponse, Flavor> listFlavors(ListFlavorsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<FlavorListResponse>() {},
        new TypeReference<Flavor>() {},
        "flavors");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<FlavorListResponse, Flavor> listFlavors() {
    return listFlavors(null);
  }

  /** List the launch image catalog */
  public PagedRequest<ImageCatalogResponse, ImageCatalogCategory> listImageCatalog(
      ListImageCatalogQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ImageCatalogResponse>() {},
        new TypeReference<ImageCatalogCategory>() {},
        "categories");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ImageCatalogResponse, ImageCatalogCategory> listImageCatalog() {
    return listImageCatalog(null);
  }

  /** List images */
  public PagedRequest<ImageListResponse, Image> listImages(ListImagesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ImageListResponse>() {},
        new TypeReference<Image>() {},
        "images");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ImageListResponse, Image> listImages() {
    return listImages(null);
  }

  /** List the instance's network interfaces */
  public PagedRequest<ListInstanceNICsResponse, ListInstanceNICsItem> listInstanceNICs(
      String instance_id, ListInstanceNICsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            query),
        new TypeReference<ListInstanceNICsResponse>() {},
        new TypeReference<ListInstanceNICsItem>() {},
        "nics");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListInstanceNICsResponse, ListInstanceNICsItem> listInstanceNICs(
      String instance_id) {
    return listInstanceNICs(instance_id, null);
  }

  /** List the pool's shared public addresses */
  public PagedRequest<FloatingIpListResponse, FloatingIp> listInstancePoolFloatingIps(
      String pool_id, ListInstancePoolFloatingIpsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("pool_id", pool_id)),
            null,
            query),
        new TypeReference<FloatingIpListResponse>() {},
        new TypeReference<FloatingIp>() {},
        "floating_ips");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<FloatingIpListResponse, FloatingIp> listInstancePoolFloatingIps(
      String pool_id) {
    return listInstancePoolFloatingIps(pool_id, null);
  }

  /** List instance pools */
  public PagedRequest<InstancePoolListResponse, InstancePool> listInstancePools(
      ListInstancePoolsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_24,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<InstancePoolListResponse>() {},
        new TypeReference<InstancePool>() {},
        "instance_pools");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InstancePoolListResponse, InstancePool> listInstancePools() {
    return listInstancePools(null);
  }

  /** List the instance's attached volumes */
  public PagedRequest<ListInstanceVolumesResponse, ListInstanceVolumesItem> listInstanceVolumes(
      String instance_id, ListInstanceVolumesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            query),
        new TypeReference<ListInstanceVolumesResponse>() {},
        new TypeReference<ListInstanceVolumesItem>() {},
        "attachments");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListInstanceVolumesResponse, ListInstanceVolumesItem> listInstanceVolumes(
      String instance_id) {
    return listInstanceVolumes(instance_id, null);
  }

  /** List instances */
  public PagedRequest<InstanceListResponse, Instance> listInstances(ListInstancesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_26,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<InstanceListResponse>() {},
        new TypeReference<Instance>() {},
        "instances");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InstanceListResponse, Instance> listInstances() {
    return listInstances(null);
  }

  /** List a pool's instances */
  public PagedRequest<InstanceListResponse, Instance> listPoolInstances(
      String pool_id, ListPoolInstancesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("pool_id", pool_id)),
            null,
            query),
        new TypeReference<InstanceListResponse>() {},
        new TypeReference<Instance>() {},
        "instances");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InstanceListResponse, Instance> listPoolInstances(String pool_id) {
    return listPoolInstances(pool_id, null);
  }

  /** Reboot instance */
  public EmptyRequest rebootInstance(String instance_id, InstanceRebootRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            body,
            null));
  }

  /** Execute with optional inputs omitted. */
  public EmptyRequest rebootInstance(String instance_id) {
    return rebootInstance(instance_id, null);
  }

  /** Roll every member onto the pool's current launch template */
  public Request<InstancePoolResponse> refreshInstancePool(String pool_id) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_29,
            Map.ofEntries(Map.entry("pool_id", pool_id)),
            null,
            null),
        new TypeReference<InstancePoolResponse>() {});
  }

  /** Reinstall instance */
  public EmptyRequest reinstallInstance(String instance_id, ReinstallInstanceBody body) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_30,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            body,
            null));
  }

  /** Execute with optional inputs omitted. */
  public EmptyRequest reinstallInstance(String instance_id) {
    return reinstallInstance(instance_id, null);
  }

  /** Resize instance */
  public EmptyRequest resizeInstance(String instance_id, ResizeInstanceBody body) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_31,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            body,
            null));
  }

  /** Start instance */
  public EmptyRequest startInstance(String instance_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_32,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            null));
  }

  /** Open an interactive serial console */
  public WebSocketRequest startSerialConsole(String instance_id, StartSerialConsoleQuery query) {
    return new WebSocketRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_33,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            query));
  }

  /** Execute with optional inputs omitted. */
  public WebSocketRequest startSerialConsole(String instance_id) {
    return startSerialConsole(instance_id, null);
  }

  /** Stop instance */
  public EmptyRequest stopInstance(String instance_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            null,
            null));
  }

  /** Update an image's metadata */
  public Request<ImageResponse> updateImage(String image_id, ImageUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_35,
            Map.ofEntries(Map.entry("image_id", image_id)),
            body,
            null),
        new TypeReference<ImageResponse>() {});
  }

  /** Update instance */
  public Request<UpdateInstanceResponse> updateInstance(
      String instance_id, InstanceUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_36,
            Map.ofEntries(Map.entry("instance_id", instance_id)),
            body,
            null),
        new TypeReference<UpdateInstanceResponse>() {});
  }

  /** Update an instance pool's description, size, tags or launch template */
  public Request<InstancePoolResponse> updateInstancePool(
      String pool_id, InstancePoolUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_37,
            Map.ofEntries(Map.entry("pool_id", pool_id)),
            body,
            null),
        new TypeReference<InstancePoolResponse>() {});
  }

  /** Update a volume attachment's settings */
  public EmptyRequest updateInstanceVolumeAttachment(
      String instance_id, String volume_id, UpdateInstanceVolumeAttachmentBody body) {
    return new EmptyRequest(
        new Core(
            transport,
            "compute",
            "https://compute.{region}.basaltic.sh",
            OP_38,
            Map.ofEntries(Map.entry("instance_id", instance_id), Map.entry("volume_id", volume_id)),
            body,
            null));
  }
}
