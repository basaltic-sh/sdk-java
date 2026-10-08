package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Network.AddressRequestInput;
import sh.basaltic.sdk.models.Network.AttachFloatingIpBody;
import sh.basaltic.sdk.models.Network.AttachFloatingIpResponse;
import sh.basaltic.sdk.models.Network.CreateInterfaceAddressResponse;
import sh.basaltic.sdk.models.Network.CreateInterfacePrefixBody;
import sh.basaltic.sdk.models.Network.CreateInterfacePrefixResponse;
import sh.basaltic.sdk.models.Network.CreatePrefixPoolBody;
import sh.basaltic.sdk.models.Network.CreatePrefixPoolResponse;
import sh.basaltic.sdk.models.Network.DetachFloatingIpBody;
import sh.basaltic.sdk.models.Network.DetachFloatingIpResponse;
import sh.basaltic.sdk.models.Network.EgressOnlyGateway;
import sh.basaltic.sdk.models.Network.EgressOnlyGatewayCreateRequestInput;
import sh.basaltic.sdk.models.Network.EgressOnlyGatewayListResponse;
import sh.basaltic.sdk.models.Network.EgressOnlyGatewayResponse;
import sh.basaltic.sdk.models.Network.EgressOnlyGatewayUpdateRequestInput;
import sh.basaltic.sdk.models.Network.FloatingIp;
import sh.basaltic.sdk.models.Network.FloatingIpCreateRequestInput;
import sh.basaltic.sdk.models.Network.FloatingIpListResponse;
import sh.basaltic.sdk.models.Network.FloatingIpResponse;
import sh.basaltic.sdk.models.Network.FloatingIpUpdateRequestInput;
import sh.basaltic.sdk.models.Network.GatewayRoute;
import sh.basaltic.sdk.models.Network.GatewayRouteListResponse;
import sh.basaltic.sdk.models.Network.GetEgressOnlyGatewayScope;
import sh.basaltic.sdk.models.Network.GetFloatingIpScope;
import sh.basaltic.sdk.models.Network.GetInterfaceAddressResponse;
import sh.basaltic.sdk.models.Network.GetInterfaceScope;
import sh.basaltic.sdk.models.Network.GetInternetGatewayScope;
import sh.basaltic.sdk.models.Network.GetNATGatewayScope;
import sh.basaltic.sdk.models.Network.GetRouteScope;
import sh.basaltic.sdk.models.Network.GetRouteTableScope;
import sh.basaltic.sdk.models.Network.GetSecurityGroupRuleScope;
import sh.basaltic.sdk.models.Network.GetSecurityGroupScope;
import sh.basaltic.sdk.models.Network.GetSubnetScope;
import sh.basaltic.sdk.models.Network.GetVpcScope;
import sh.basaltic.sdk.models.Network.Interface;
import sh.basaltic.sdk.models.Network.InterfaceAddress;
import sh.basaltic.sdk.models.Network.InterfaceCreateRequestInput;
import sh.basaltic.sdk.models.Network.InterfaceListResponse;
import sh.basaltic.sdk.models.Network.InterfaceResponse;
import sh.basaltic.sdk.models.Network.InterfaceSecurityGroupsRequestInput;
import sh.basaltic.sdk.models.Network.InterfaceSecurityGroupsResponse;
import sh.basaltic.sdk.models.Network.InterfaceUpdateRequestInput;
import sh.basaltic.sdk.models.Network.InternetGateway;
import sh.basaltic.sdk.models.Network.InternetGatewayAttachRequestInput;
import sh.basaltic.sdk.models.Network.InternetGatewayCreateRequestInput;
import sh.basaltic.sdk.models.Network.InternetGatewayListResponse;
import sh.basaltic.sdk.models.Network.InternetGatewayResponse;
import sh.basaltic.sdk.models.Network.InternetGatewayUpdateRequestInput;
import sh.basaltic.sdk.models.Network.ListEgressOnlyGatewayRoutesQuery;
import sh.basaltic.sdk.models.Network.ListEgressOnlyGatewaysQuery;
import sh.basaltic.sdk.models.Network.ListFloatingIpsQuery;
import sh.basaltic.sdk.models.Network.ListInterfaceAddressesResponse;
import sh.basaltic.sdk.models.Network.ListInterfacePrefixesResponse;
import sh.basaltic.sdk.models.Network.ListInterfaceSecurityGroupsQuery;
import sh.basaltic.sdk.models.Network.ListInterfacesQuery;
import sh.basaltic.sdk.models.Network.ListInternetGatewayRoutesQuery;
import sh.basaltic.sdk.models.Network.ListInternetGatewaysQuery;
import sh.basaltic.sdk.models.Network.ListNATGatewayRoutesQuery;
import sh.basaltic.sdk.models.Network.ListNATGatewaysQuery;
import sh.basaltic.sdk.models.Network.ListPrefixPoolsResponse;
import sh.basaltic.sdk.models.Network.ListRouteTablesQuery;
import sh.basaltic.sdk.models.Network.ListRoutesQuery;
import sh.basaltic.sdk.models.Network.ListSecurityGroupRulesQuery;
import sh.basaltic.sdk.models.Network.ListSecurityGroupsQuery;
import sh.basaltic.sdk.models.Network.ListSubnetsQuery;
import sh.basaltic.sdk.models.Network.ListVpcsQuery;
import sh.basaltic.sdk.models.Network.NATGateway;
import sh.basaltic.sdk.models.Network.NATGatewayCreateRequestInput;
import sh.basaltic.sdk.models.Network.NATGatewayListResponse;
import sh.basaltic.sdk.models.Network.NATGatewayResponse;
import sh.basaltic.sdk.models.Network.NATGatewayUpdateRequestInput;
import sh.basaltic.sdk.models.Network.PrefixPool;
import sh.basaltic.sdk.models.Network.Route;
import sh.basaltic.sdk.models.Network.RouteCreateRequestInput;
import sh.basaltic.sdk.models.Network.RouteListResponse;
import sh.basaltic.sdk.models.Network.RouteResponse;
import sh.basaltic.sdk.models.Network.RouteTable;
import sh.basaltic.sdk.models.Network.RouteTableCreateRequestInput;
import sh.basaltic.sdk.models.Network.RouteTableListResponse;
import sh.basaltic.sdk.models.Network.RouteTableResponse;
import sh.basaltic.sdk.models.Network.RouteTableUpdateRequestInput;
import sh.basaltic.sdk.models.Network.RouteUpdateRequestInput;
import sh.basaltic.sdk.models.Network.RoutedPrefix;
import sh.basaltic.sdk.models.Network.SecurityGroup;
import sh.basaltic.sdk.models.Network.SecurityGroupCreateRequestInput;
import sh.basaltic.sdk.models.Network.SecurityGroupListResponse;
import sh.basaltic.sdk.models.Network.SecurityGroupResponse;
import sh.basaltic.sdk.models.Network.SecurityGroupRule;
import sh.basaltic.sdk.models.Network.SecurityGroupRuleCreateRequestInput;
import sh.basaltic.sdk.models.Network.SecurityGroupRuleListResponse;
import sh.basaltic.sdk.models.Network.SecurityGroupRuleResponse;
import sh.basaltic.sdk.models.Network.SecurityGroupUpdateRequestInput;
import sh.basaltic.sdk.models.Network.Subnet;
import sh.basaltic.sdk.models.Network.SubnetCreateRequestInput;
import sh.basaltic.sdk.models.Network.SubnetListResponse;
import sh.basaltic.sdk.models.Network.SubnetResponse;
import sh.basaltic.sdk.models.Network.SubnetUpdateRequestInput;
import sh.basaltic.sdk.models.Network.Vpc;
import sh.basaltic.sdk.models.Network.VpcCreateRequestInput;
import sh.basaltic.sdk.models.Network.VpcListResponse;
import sh.basaltic.sdk.models.Network.VpcResponse;
import sh.basaltic.sdk.models.Network.VpcUpdateRequestInput;

/** Typed network API methods. */
public final class NetworkService {
  private final Transport transport;

  NetworkService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "attachFloatingIp",
          "POST",
          "/v1/floating-ips/{floating_ip_id}/attach",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "attachInternetGateway",
          "POST",
          "/v1/internet-gateways/{internet_gateway_id}/attach",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "createEgressOnlyGateway",
          "POST",
          "/v1/egress-only-gateways",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "createFloatingIp",
          "POST",
          "/v1/floating-ips",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "createInterface",
          "POST",
          "/v1/interfaces",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "createInterfaceAddress",
          "POST",
          "/v1/interfaces/{interface_id}/addresses",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "createInterfacePrefix",
          "POST",
          "/v1/interfaces/{interface_id}/prefixes",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "createInternetGateway",
          "POST",
          "/v1/internet-gateways",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "createNATGateway",
          "POST",
          "/v1/nat-gateways",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "createPrefixPool",
          "POST",
          "/v1/vpcs/{vpc_id}/prefix-pools",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "createRoute",
          "POST",
          "/v1/route-tables/{route_table_id}/routes",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "createRouteTable",
          "POST",
          "/v1/route-tables",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "createSecurityGroup",
          "POST",
          "/v1/security-groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "createSecurityGroupRule",
          "POST",
          "/v1/security-groups/{security_group_id}/rules",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "createSubnet",
          "POST",
          "/v1/subnets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "createVpc",
          "POST",
          "/v1/vpcs",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "deleteEgressOnlyGateway",
          "DELETE",
          "/v1/egress-only-gateways/{egress_only_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "deleteFloatingIp",
          "DELETE",
          "/v1/floating-ips/{floating_ip_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "deleteInterface",
          "DELETE",
          "/v1/interfaces/{interface_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "deleteInterfaceAddress",
          "DELETE",
          "/v1/interfaces/{interface_id}/addresses/{address_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "deleteInterfacePrefix",
          "DELETE",
          "/v1/interfaces/{interface_id}/prefixes/{prefix_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "deleteInternetGateway",
          "DELETE",
          "/v1/internet-gateways/{internet_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "deleteNATGateway",
          "DELETE",
          "/v1/nat-gateways/{nat_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_23 =
      new Operation(
          "deletePrefixPool",
          "DELETE",
          "/v1/vpcs/{vpc_id}/prefix-pools/{pool_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_24 =
      new Operation(
          "deleteRoute",
          "DELETE",
          "/v1/route-tables/{route_table_id}/routes/{route_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_25 =
      new Operation(
          "deleteRouteTable",
          "DELETE",
          "/v1/route-tables/{route_table_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_26 =
      new Operation(
          "deleteSecurityGroup",
          "DELETE",
          "/v1/security-groups/{security_group_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_27 =
      new Operation(
          "deleteSecurityGroupRule",
          "DELETE",
          "/v1/security-groups/{security_group_id}/rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_28 =
      new Operation(
          "deleteSubnet",
          "DELETE",
          "/v1/subnets/{subnet_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_29 =
      new Operation(
          "deleteVpc",
          "DELETE",
          "/v1/vpcs/{vpc_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_30 =
      new Operation(
          "detachFloatingIp",
          "POST",
          "/v1/floating-ips/{floating_ip_id}/detach",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_31 =
      new Operation(
          "detachInternetGateway",
          "POST",
          "/v1/internet-gateways/{internet_gateway_id}/detach",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_32 =
      new Operation(
          "getEgressOnlyGateway",
          "GET",
          "/v1/egress-only-gateways/{egress_only_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_33 =
      new Operation(
          "getFloatingIp",
          "GET",
          "/v1/floating-ips/{floating_ip_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_34 =
      new Operation(
          "getInterface",
          "GET",
          "/v1/interfaces/{interface_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_35 =
      new Operation(
          "getInterfaceAddress",
          "GET",
          "/v1/interfaces/{interface_id}/addresses/{address_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_36 =
      new Operation(
          "getInternetGateway",
          "GET",
          "/v1/internet-gateways/{internet_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_37 =
      new Operation(
          "getNATGateway",
          "GET",
          "/v1/nat-gateways/{nat_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_38 =
      new Operation(
          "getRoute",
          "GET",
          "/v1/route-tables/{route_table_id}/routes/{route_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_39 =
      new Operation(
          "getRouteTable",
          "GET",
          "/v1/route-tables/{route_table_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_40 =
      new Operation(
          "getSecurityGroup",
          "GET",
          "/v1/security-groups/{security_group_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_41 =
      new Operation(
          "getSecurityGroupRule",
          "GET",
          "/v1/security-groups/{security_group_id}/rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_42 =
      new Operation(
          "getSubnet",
          "GET",
          "/v1/subnets/{subnet_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_43 =
      new Operation(
          "getVpc",
          "GET",
          "/v1/vpcs/{vpc_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_44 =
      new Operation(
          "listEgressOnlyGatewayRoutes",
          "GET",
          "/v1/egress-only-gateways/{egress_only_gateway_id}/routes",
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
  private static final Operation OP_45 =
      new Operation(
          "listEgressOnlyGateways",
          "GET",
          "/v1/egress-only-gateways",
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
  private static final Operation OP_46 =
      new Operation(
          "listFloatingIps",
          "GET",
          "/v1/floating-ips",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("attached_to", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_47 =
      new Operation(
          "listInterfaceAddresses",
          "GET",
          "/v1/interfaces/{interface_id}/addresses",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_48 =
      new Operation(
          "listInterfacePrefixes",
          "GET",
          "/v1/interfaces/{interface_id}/prefixes",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_49 =
      new Operation(
          "listInterfaceSecurityGroups",
          "GET",
          "/v1/interfaces/{interface_id}/security-groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_50 =
      new Operation(
          "listInterfaces",
          "GET",
          "/v1/interfaces",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("subnet", new Operation.Encoding("form", true)),
              Map.entry("vpc", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_51 =
      new Operation(
          "listInternetGatewayRoutes",
          "GET",
          "/v1/internet-gateways/{internet_gateway_id}/routes",
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
  private static final Operation OP_52 =
      new Operation(
          "listInternetGateways",
          "GET",
          "/v1/internet-gateways",
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
  private static final Operation OP_53 =
      new Operation(
          "listNATGatewayRoutes",
          "GET",
          "/v1/nat-gateways/{nat_gateway_id}/routes",
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
  private static final Operation OP_54 =
      new Operation(
          "listNATGateways",
          "GET",
          "/v1/nat-gateways",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("subnet", new Operation.Encoding("form", true)),
              Map.entry("vpc", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_55 =
      new Operation(
          "listPrefixPools",
          "GET",
          "/v1/vpcs/{vpc_id}/prefix-pools",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_56 =
      new Operation(
          "listRouteTables",
          "GET",
          "/v1/route-tables",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("vpc", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_57 =
      new Operation(
          "listRoutes",
          "GET",
          "/v1/route-tables/{route_table_id}/routes",
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
  private static final Operation OP_58 =
      new Operation(
          "listSecurityGroupRules",
          "GET",
          "/v1/security-groups/{security_group_id}/rules",
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
  private static final Operation OP_59 =
      new Operation(
          "listSecurityGroups",
          "GET",
          "/v1/security-groups",
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
  private static final Operation OP_60 =
      new Operation(
          "listSubnets",
          "GET",
          "/v1/subnets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("vpc", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_61 =
      new Operation(
          "listVpcs",
          "GET",
          "/v1/vpcs",
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
  private static final Operation OP_62 =
      new Operation(
          "setInterfaceSecurityGroups",
          "PUT",
          "/v1/interfaces/{interface_id}/security-groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_63 =
      new Operation(
          "updateEgressOnlyGateway",
          "PATCH",
          "/v1/egress-only-gateways/{egress_only_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_64 =
      new Operation(
          "updateFloatingIp",
          "PATCH",
          "/v1/floating-ips/{floating_ip_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_65 =
      new Operation(
          "updateInterface",
          "PATCH",
          "/v1/interfaces/{interface_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_66 =
      new Operation(
          "updateInternetGateway",
          "PATCH",
          "/v1/internet-gateways/{internet_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_67 =
      new Operation(
          "updateNATGateway",
          "PATCH",
          "/v1/nat-gateways/{nat_gateway_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_68 =
      new Operation(
          "updateRoute",
          "PATCH",
          "/v1/route-tables/{route_table_id}/routes/{route_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_69 =
      new Operation(
          "updateRouteTable",
          "PATCH",
          "/v1/route-tables/{route_table_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_70 =
      new Operation(
          "updateSecurityGroup",
          "PATCH",
          "/v1/security-groups/{security_group_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_71 =
      new Operation(
          "updateSubnet",
          "PATCH",
          "/v1/subnets/{subnet_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_72 =
      new Operation(
          "updateVpc",
          "PATCH",
          "/v1/vpcs/{vpc_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Attach a floating IP to an interface */
  public Request<AttachFloatingIpResponse> attachFloatingIp(
      String floating_ip_id, AttachFloatingIpBody body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("floating_ip_id", floating_ip_id)),
            body,
            null),
        new TypeReference<AttachFloatingIpResponse>() {});
  }

  /** Attach internet gateway to a VPC */
  public Request<InternetGatewayResponse> attachInternetGateway(
      String internet_gateway_id, InternetGatewayAttachRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("internet_gateway_id", internet_gateway_id)),
            body,
            null),
        new TypeReference<InternetGatewayResponse>() {});
  }

  /** Create egress-only gateway */
  public Request<EgressOnlyGatewayResponse> createEgressOnlyGateway(
      EgressOnlyGatewayCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<EgressOnlyGatewayResponse>() {});
  }

  /** Allocate floating IP */
  public Request<FloatingIpResponse> createFloatingIp(FloatingIpCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<FloatingIpResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<FloatingIpResponse> createFloatingIp() {
    return createFloatingIp(null);
  }

  /** Create interface */
  public Request<InterfaceResponse> createInterface(InterfaceCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<InterfaceResponse>() {});
  }

  /** Create interface address */
  public Request<CreateInterfaceAddressResponse> createInterfaceAddress(
      String interface_id, AddressRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            body,
            null),
        new TypeReference<CreateInterfaceAddressResponse>() {});
  }

  /** Create interface prefix */
  public Request<CreateInterfacePrefixResponse> createInterfacePrefix(
      String interface_id, CreateInterfacePrefixBody body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            body,
            null),
        new TypeReference<CreateInterfacePrefixResponse>() {});
  }

  /** Create internet gateway */
  public Request<InternetGatewayResponse> createInternetGateway(
      InternetGatewayCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<InternetGatewayResponse>() {});
  }

  /** Create NAT gateway */
  public Request<NATGatewayResponse> createNATGateway(NATGatewayCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<NATGatewayResponse>() {});
  }

  /** Create prefix pool */
  public Request<CreatePrefixPoolResponse> createPrefixPool(
      String vpc_id, CreatePrefixPoolBody body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("vpc_id", vpc_id)),
            body,
            null),
        new TypeReference<CreatePrefixPoolResponse>() {});
  }

  /** Create route */
  public Request<RouteResponse> createRoute(String route_table_id, RouteCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("route_table_id", route_table_id)),
            body,
            null),
        new TypeReference<RouteResponse>() {});
  }

  /** Create route table */
  public Request<RouteTableResponse> createRouteTable(RouteTableCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<RouteTableResponse>() {});
  }

  /** Create security group */
  public Request<SecurityGroupResponse> createSecurityGroup(SecurityGroupCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<SecurityGroupResponse>() {});
  }

  /** Create security group rule */
  public Request<SecurityGroupRuleResponse> createSecurityGroupRule(
      String security_group_id, SecurityGroupRuleCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("security_group_id", security_group_id)),
            body,
            null),
        new TypeReference<SecurityGroupRuleResponse>() {});
  }

  /** Create subnet */
  public Request<SubnetResponse> createSubnet(SubnetCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<SubnetResponse>() {});
  }

  /** Create VPC */
  public Request<VpcResponse> createVpc(VpcCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<VpcResponse>() {});
  }

  /** Delete egress-only gateway */
  public EmptyRequest deleteEgressOnlyGateway(String egress_only_gateway_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("egress_only_gateway_id", egress_only_gateway_id)),
            null,
            null));
  }

  /** Release floating IP */
  public EmptyRequest deleteFloatingIp(String floating_ip_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("floating_ip_id", floating_ip_id)),
            null,
            null));
  }

  /** Delete interface */
  public EmptyRequest deleteInterface(String interface_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            null,
            null));
  }

  /** Delete interface address */
  public EmptyRequest deleteInterfaceAddress(String interface_id, String address_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(
                Map.entry("interface_id", interface_id), Map.entry("address_id", address_id)),
            null,
            null));
  }

  /** Delete interface prefix */
  public EmptyRequest deleteInterfacePrefix(String interface_id, String prefix_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(
                Map.entry("interface_id", interface_id), Map.entry("prefix_id", prefix_id)),
            null,
            null));
  }

  /** Delete internet gateway */
  public EmptyRequest deleteInternetGateway(String internet_gateway_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(Map.entry("internet_gateway_id", internet_gateway_id)),
            null,
            null));
  }

  /** Delete NAT gateway */
  public EmptyRequest deleteNATGateway(String nat_gateway_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("nat_gateway_id", nat_gateway_id)),
            null,
            null));
  }

  /** Delete prefix pool */
  public EmptyRequest deletePrefixPool(String vpc_id, String pool_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("vpc_id", vpc_id), Map.entry("pool_id", pool_id)),
            null,
            null));
  }

  /** Delete route */
  public EmptyRequest deleteRoute(String route_table_id, String route_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_24,
            Map.ofEntries(
                Map.entry("route_table_id", route_table_id), Map.entry("route_id", route_id)),
            null,
            null));
  }

  /** Delete route table */
  public EmptyRequest deleteRouteTable(String route_table_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("route_table_id", route_table_id)),
            null,
            null));
  }

  /** Delete security group */
  public EmptyRequest deleteSecurityGroup(String security_group_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_26,
            Map.ofEntries(Map.entry("security_group_id", security_group_id)),
            null,
            null));
  }

  /** Delete security group rule */
  public EmptyRequest deleteSecurityGroupRule(String security_group_id, String rule_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_27,
            Map.ofEntries(
                Map.entry("security_group_id", security_group_id), Map.entry("rule_id", rule_id)),
            null,
            null));
  }

  /** Delete subnet */
  public EmptyRequest deleteSubnet(String subnet_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("subnet_id", subnet_id)),
            null,
            null));
  }

  /** Delete VPC */
  public EmptyRequest deleteVpc(String vpc_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_29,
            Map.ofEntries(Map.entry("vpc_id", vpc_id)),
            null,
            null));
  }

  /** Detach a floating IP */
  public Request<DetachFloatingIpResponse> detachFloatingIp(
      String floating_ip_id, DetachFloatingIpBody body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_30,
            Map.ofEntries(Map.entry("floating_ip_id", floating_ip_id)),
            body,
            null),
        new TypeReference<DetachFloatingIpResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<DetachFloatingIpResponse> detachFloatingIp(String floating_ip_id) {
    return detachFloatingIp(floating_ip_id, null);
  }

  /** Detach internet gateway from its VPC */
  public Request<InternetGatewayResponse> detachInternetGateway(String internet_gateway_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_31,
            Map.ofEntries(Map.entry("internet_gateway_id", internet_gateway_id)),
            null,
            null),
        new TypeReference<InternetGatewayResponse>() {});
  }

  /** Get egress-only gateway */
  public Request<EgressOnlyGatewayResponse> getEgressOnlyGateway(String egress_only_gateway_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_32,
            Map.ofEntries(Map.entry("egress_only_gateway_id", egress_only_gateway_id)),
            null,
            null),
        new TypeReference<EgressOnlyGatewayResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<EgressOnlyGateway> getEgressOnlyGatewayByReference(
      String reference, GetEgressOnlyGatewayScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_32,
            Map.ofEntries(Map.entry("egress_only_gateway_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_45,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "egress_only_gateway",
        "egress_only_gateways",
        new TypeReference<EgressOnlyGateway>() {});
  }

  public Request<EgressOnlyGateway> getEgressOnlyGatewayByReference(String reference) {
    return getEgressOnlyGatewayByReference(reference, null);
  }

  /** Get floating IP */
  public Request<FloatingIpResponse> getFloatingIp(String floating_ip_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_33,
            Map.ofEntries(Map.entry("floating_ip_id", floating_ip_id)),
            null,
            null),
        new TypeReference<FloatingIpResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<FloatingIp> getFloatingIpByReference(String reference, GetFloatingIpScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_33,
            Map.ofEntries(Map.entry("floating_ip_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_46,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "floating_ip",
        "floating_ips",
        new TypeReference<FloatingIp>() {});
  }

  public Request<FloatingIp> getFloatingIpByReference(String reference) {
    return getFloatingIpByReference(reference, null);
  }

  /** Get interface */
  public Request<InterfaceResponse> getInterface(String interface_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            null,
            null),
        new TypeReference<InterfaceResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Interface> getInterfaceByReference(String reference, GetInterfaceScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("interface_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_50,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "interface",
        "interfaces",
        new TypeReference<Interface>() {});
  }

  public Request<Interface> getInterfaceByReference(String reference) {
    return getInterfaceByReference(reference, null);
  }

  /** Get interface address */
  public Request<GetInterfaceAddressResponse> getInterfaceAddress(
      String interface_id, String address_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_35,
            Map.ofEntries(
                Map.entry("interface_id", interface_id), Map.entry("address_id", address_id)),
            null,
            null),
        new TypeReference<GetInterfaceAddressResponse>() {});
  }

  /** Get internet gateway */
  public Request<InternetGatewayResponse> getInternetGateway(String internet_gateway_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_36,
            Map.ofEntries(Map.entry("internet_gateway_id", internet_gateway_id)),
            null,
            null),
        new TypeReference<InternetGatewayResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<InternetGateway> getInternetGatewayByReference(
      String reference, GetInternetGatewayScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_36,
            Map.ofEntries(Map.entry("internet_gateway_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_52,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "internet_gateway",
        "internet_gateways",
        new TypeReference<InternetGateway>() {});
  }

  public Request<InternetGateway> getInternetGatewayByReference(String reference) {
    return getInternetGatewayByReference(reference, null);
  }

  /** Get NAT gateway */
  public Request<NATGatewayResponse> getNATGateway(String nat_gateway_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_37,
            Map.ofEntries(Map.entry("nat_gateway_id", nat_gateway_id)),
            null,
            null),
        new TypeReference<NATGatewayResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<NATGateway> getNATGatewayByReference(String reference, GetNATGatewayScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_37,
            Map.ofEntries(Map.entry("nat_gateway_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_54,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "nat_gateway",
        "nat_gateways",
        new TypeReference<NATGateway>() {});
  }

  public Request<NATGateway> getNATGatewayByReference(String reference) {
    return getNATGatewayByReference(reference, null);
  }

  /** Get route */
  public Request<RouteResponse> getRoute(String route_table_id, String route_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_38,
            Map.ofEntries(
                Map.entry("route_table_id", route_table_id), Map.entry("route_id", route_id)),
            null,
            null),
        new TypeReference<RouteResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Route> getRouteByReference(
      String route_table_id, String reference, GetRouteScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_38,
            Map.ofEntries(
                Map.entry("route_table_id", route_table_id), Map.entry("route_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_57,
            Map.ofEntries(Map.entry("route_table_id", route_table_id)),
            null,
            scope),
        reference,
        true,
        "route",
        "routes",
        new TypeReference<Route>() {});
  }

  public Request<Route> getRouteByReference(String route_table_id, String reference) {
    return getRouteByReference(route_table_id, reference, null);
  }

  /** Get route table */
  public Request<RouteTableResponse> getRouteTable(String route_table_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_39,
            Map.ofEntries(Map.entry("route_table_id", route_table_id)),
            null,
            null),
        new TypeReference<RouteTableResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<RouteTable> getRouteTableByReference(String reference, GetRouteTableScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_39,
            Map.ofEntries(Map.entry("route_table_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_56,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "route_table",
        "route_tables",
        new TypeReference<RouteTable>() {});
  }

  public Request<RouteTable> getRouteTableByReference(String reference) {
    return getRouteTableByReference(reference, null);
  }

  /** Get security group */
  public Request<SecurityGroupResponse> getSecurityGroup(String security_group_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_40,
            Map.ofEntries(Map.entry("security_group_id", security_group_id)),
            null,
            null),
        new TypeReference<SecurityGroupResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<SecurityGroup> getSecurityGroupByReference(
      String reference, GetSecurityGroupScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_40,
            Map.ofEntries(Map.entry("security_group_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_59,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "security_group",
        "security_groups",
        new TypeReference<SecurityGroup>() {});
  }

  public Request<SecurityGroup> getSecurityGroupByReference(String reference) {
    return getSecurityGroupByReference(reference, null);
  }

  /** Get security group rule */
  public Request<SecurityGroupRuleResponse> getSecurityGroupRule(
      String security_group_id, String rule_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_41,
            Map.ofEntries(
                Map.entry("security_group_id", security_group_id), Map.entry("rule_id", rule_id)),
            null,
            null),
        new TypeReference<SecurityGroupRuleResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<SecurityGroupRule> getSecurityGroupRuleByReference(
      String security_group_id, String reference, GetSecurityGroupRuleScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_41,
            Map.ofEntries(
                Map.entry("security_group_id", security_group_id), Map.entry("rule_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_58,
            Map.ofEntries(Map.entry("security_group_id", security_group_id)),
            null,
            scope),
        reference,
        true,
        "rule",
        "rules",
        new TypeReference<SecurityGroupRule>() {});
  }

  public Request<SecurityGroupRule> getSecurityGroupRuleByReference(
      String security_group_id, String reference) {
    return getSecurityGroupRuleByReference(security_group_id, reference, null);
  }

  /** Get subnet */
  public Request<SubnetResponse> getSubnet(String subnet_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_42,
            Map.ofEntries(Map.entry("subnet_id", subnet_id)),
            null,
            null),
        new TypeReference<SubnetResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Subnet> getSubnetByReference(String reference, GetSubnetScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_42,
            Map.ofEntries(Map.entry("subnet_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_60,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "subnet",
        "subnets",
        new TypeReference<Subnet>() {});
  }

  public Request<Subnet> getSubnetByReference(String reference) {
    return getSubnetByReference(reference, null);
  }

  /** Get VPC */
  public Request<VpcResponse> getVpc(String vpc_id) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_43,
            Map.ofEntries(Map.entry("vpc_id", vpc_id)),
            null,
            null),
        new TypeReference<VpcResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Vpc> getVpcByReference(String reference, GetVpcScope scope) {
    return Request.reference(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_43,
            Map.ofEntries(Map.entry("vpc_id", reference)),
            null,
            null),
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_61,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "vpc",
        "vpcs",
        new TypeReference<Vpc>() {});
  }

  public Request<Vpc> getVpcByReference(String reference) {
    return getVpcByReference(reference, null);
  }

  /** List egress-only gateway routes */
  public PagedRequest<GatewayRouteListResponse, GatewayRoute> listEgressOnlyGatewayRoutes(
      String egress_only_gateway_id, ListEgressOnlyGatewayRoutesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_44,
            Map.ofEntries(Map.entry("egress_only_gateway_id", egress_only_gateway_id)),
            null,
            query),
        new TypeReference<GatewayRouteListResponse>() {},
        new TypeReference<GatewayRoute>() {},
        "routes");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<GatewayRouteListResponse, GatewayRoute> listEgressOnlyGatewayRoutes(
      String egress_only_gateway_id) {
    return listEgressOnlyGatewayRoutes(egress_only_gateway_id, null);
  }

  /** List egress-only gateways */
  public PagedRequest<EgressOnlyGatewayListResponse, EgressOnlyGateway> listEgressOnlyGateways(
      ListEgressOnlyGatewaysQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_45,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<EgressOnlyGatewayListResponse>() {},
        new TypeReference<EgressOnlyGateway>() {},
        "egress_only_gateways");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<EgressOnlyGatewayListResponse, EgressOnlyGateway> listEgressOnlyGateways() {
    return listEgressOnlyGateways(null);
  }

  /** List floating IPs */
  public PagedRequest<FloatingIpListResponse, FloatingIp> listFloatingIps(
      ListFloatingIpsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_46,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<FloatingIpListResponse>() {},
        new TypeReference<FloatingIp>() {},
        "floating_ips");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<FloatingIpListResponse, FloatingIp> listFloatingIps() {
    return listFloatingIps(null);
  }

  /** List interface addresses */
  public PagedRequest<ListInterfaceAddressesResponse, InterfaceAddress> listInterfaceAddresses(
      String interface_id) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_47,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            null,
            null),
        new TypeReference<ListInterfaceAddressesResponse>() {},
        new TypeReference<InterfaceAddress>() {},
        "addresses");
  }

  /** List interface prefixes */
  public PagedRequest<ListInterfacePrefixesResponse, RoutedPrefix> listInterfacePrefixes(
      String interface_id) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_48,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            null,
            null),
        new TypeReference<ListInterfacePrefixesResponse>() {},
        new TypeReference<RoutedPrefix>() {},
        "routed_prefixes");
  }

  /** List interface security-group membership */
  public PagedRequest<InterfaceSecurityGroupsResponse, String> listInterfaceSecurityGroups(
      String interface_id, ListInterfaceSecurityGroupsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_49,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            null,
            query),
        new TypeReference<InterfaceSecurityGroupsResponse>() {},
        new TypeReference<String>() {},
        "security_group_ids");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InterfaceSecurityGroupsResponse, String> listInterfaceSecurityGroups(
      String interface_id) {
    return listInterfaceSecurityGroups(interface_id, null);
  }

  /** List interfaces */
  public PagedRequest<InterfaceListResponse, Interface> listInterfaces(ListInterfacesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_50,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<InterfaceListResponse>() {},
        new TypeReference<Interface>() {},
        "interfaces");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InterfaceListResponse, Interface> listInterfaces() {
    return listInterfaces(null);
  }

  /** List internet gateway routes */
  public PagedRequest<GatewayRouteListResponse, GatewayRoute> listInternetGatewayRoutes(
      String internet_gateway_id, ListInternetGatewayRoutesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_51,
            Map.ofEntries(Map.entry("internet_gateway_id", internet_gateway_id)),
            null,
            query),
        new TypeReference<GatewayRouteListResponse>() {},
        new TypeReference<GatewayRoute>() {},
        "routes");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<GatewayRouteListResponse, GatewayRoute> listInternetGatewayRoutes(
      String internet_gateway_id) {
    return listInternetGatewayRoutes(internet_gateway_id, null);
  }

  /** List internet gateways */
  public PagedRequest<InternetGatewayListResponse, InternetGateway> listInternetGateways(
      ListInternetGatewaysQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_52,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<InternetGatewayListResponse>() {},
        new TypeReference<InternetGateway>() {},
        "internet_gateways");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InternetGatewayListResponse, InternetGateway> listInternetGateways() {
    return listInternetGateways(null);
  }

  /** List NAT gateway routes */
  public PagedRequest<GatewayRouteListResponse, GatewayRoute> listNATGatewayRoutes(
      String nat_gateway_id, ListNATGatewayRoutesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_53,
            Map.ofEntries(Map.entry("nat_gateway_id", nat_gateway_id)),
            null,
            query),
        new TypeReference<GatewayRouteListResponse>() {},
        new TypeReference<GatewayRoute>() {},
        "routes");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<GatewayRouteListResponse, GatewayRoute> listNATGatewayRoutes(
      String nat_gateway_id) {
    return listNATGatewayRoutes(nat_gateway_id, null);
  }

  /** List NAT gateways */
  public PagedRequest<NATGatewayListResponse, NATGateway> listNATGateways(
      ListNATGatewaysQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_54,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<NATGatewayListResponse>() {},
        new TypeReference<NATGateway>() {},
        "nat_gateways");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<NATGatewayListResponse, NATGateway> listNATGateways() {
    return listNATGateways(null);
  }

  /** List prefix pools */
  public PagedRequest<ListPrefixPoolsResponse, PrefixPool> listPrefixPools(String vpc_id) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_55,
            Map.ofEntries(Map.entry("vpc_id", vpc_id)),
            null,
            null),
        new TypeReference<ListPrefixPoolsResponse>() {},
        new TypeReference<PrefixPool>() {},
        "prefix_pools");
  }

  /** List route tables */
  public PagedRequest<RouteTableListResponse, RouteTable> listRouteTables(
      ListRouteTablesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_56,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<RouteTableListResponse>() {},
        new TypeReference<RouteTable>() {},
        "route_tables");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RouteTableListResponse, RouteTable> listRouteTables() {
    return listRouteTables(null);
  }

  /** List routes */
  public PagedRequest<RouteListResponse, Route> listRoutes(
      String route_table_id, ListRoutesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_57,
            Map.ofEntries(Map.entry("route_table_id", route_table_id)),
            null,
            query),
        new TypeReference<RouteListResponse>() {},
        new TypeReference<Route>() {},
        "routes");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RouteListResponse, Route> listRoutes(String route_table_id) {
    return listRoutes(route_table_id, null);
  }

  /** List security group rules */
  public PagedRequest<SecurityGroupRuleListResponse, SecurityGroupRule> listSecurityGroupRules(
      String security_group_id, ListSecurityGroupRulesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_58,
            Map.ofEntries(Map.entry("security_group_id", security_group_id)),
            null,
            query),
        new TypeReference<SecurityGroupRuleListResponse>() {},
        new TypeReference<SecurityGroupRule>() {},
        "rules");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SecurityGroupRuleListResponse, SecurityGroupRule> listSecurityGroupRules(
      String security_group_id) {
    return listSecurityGroupRules(security_group_id, null);
  }

  /** List security groups */
  public PagedRequest<SecurityGroupListResponse, SecurityGroup> listSecurityGroups(
      ListSecurityGroupsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_59,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<SecurityGroupListResponse>() {},
        new TypeReference<SecurityGroup>() {},
        "security_groups");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SecurityGroupListResponse, SecurityGroup> listSecurityGroups() {
    return listSecurityGroups(null);
  }

  /** List subnets */
  public PagedRequest<SubnetListResponse, Subnet> listSubnets(ListSubnetsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_60,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<SubnetListResponse>() {},
        new TypeReference<Subnet>() {},
        "subnets");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SubnetListResponse, Subnet> listSubnets() {
    return listSubnets(null);
  }

  /** List VPCs */
  public PagedRequest<VpcListResponse, Vpc> listVpcs(ListVpcsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_61,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<VpcListResponse>() {},
        new TypeReference<Vpc>() {},
        "vpcs");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<VpcListResponse, Vpc> listVpcs() {
    return listVpcs(null);
  }

  /** Set interface security-group membership */
  public Request<InterfaceSecurityGroupsResponse> setInterfaceSecurityGroups(
      String interface_id, InterfaceSecurityGroupsRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_62,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            body,
            null),
        new TypeReference<InterfaceSecurityGroupsResponse>() {});
  }

  /** Update egress-only gateway */
  public Request<EgressOnlyGatewayResponse> updateEgressOnlyGateway(
      String egress_only_gateway_id, EgressOnlyGatewayUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_63,
            Map.ofEntries(Map.entry("egress_only_gateway_id", egress_only_gateway_id)),
            body,
            null),
        new TypeReference<EgressOnlyGatewayResponse>() {});
  }

  /** Update floating IP */
  public Request<FloatingIpResponse> updateFloatingIp(
      String floating_ip_id, FloatingIpUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_64,
            Map.ofEntries(Map.entry("floating_ip_id", floating_ip_id)),
            body,
            null),
        new TypeReference<FloatingIpResponse>() {});
  }

  /** Update interface */
  public Request<InterfaceResponse> updateInterface(
      String interface_id, InterfaceUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_65,
            Map.ofEntries(Map.entry("interface_id", interface_id)),
            body,
            null),
        new TypeReference<InterfaceResponse>() {});
  }

  /** Update internet gateway */
  public Request<InternetGatewayResponse> updateInternetGateway(
      String internet_gateway_id, InternetGatewayUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_66,
            Map.ofEntries(Map.entry("internet_gateway_id", internet_gateway_id)),
            body,
            null),
        new TypeReference<InternetGatewayResponse>() {});
  }

  /** Update NAT gateway */
  public Request<NATGatewayResponse> updateNATGateway(
      String nat_gateway_id, NATGatewayUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_67,
            Map.ofEntries(Map.entry("nat_gateway_id", nat_gateway_id)),
            body,
            null),
        new TypeReference<NATGatewayResponse>() {});
  }

  /** Update route */
  public Request<RouteResponse> updateRoute(
      String route_table_id, String route_id, RouteUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_68,
            Map.ofEntries(
                Map.entry("route_table_id", route_table_id), Map.entry("route_id", route_id)),
            body,
            null),
        new TypeReference<RouteResponse>() {});
  }

  /** Update route table */
  public Request<RouteTableResponse> updateRouteTable(
      String route_table_id, RouteTableUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_69,
            Map.ofEntries(Map.entry("route_table_id", route_table_id)),
            body,
            null),
        new TypeReference<RouteTableResponse>() {});
  }

  /** Update security group */
  public Request<SecurityGroupResponse> updateSecurityGroup(
      String security_group_id, SecurityGroupUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_70,
            Map.ofEntries(Map.entry("security_group_id", security_group_id)),
            body,
            null),
        new TypeReference<SecurityGroupResponse>() {});
  }

  /** Update subnet */
  public Request<SubnetResponse> updateSubnet(String subnet_id, SubnetUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_71,
            Map.ofEntries(Map.entry("subnet_id", subnet_id)),
            body,
            null),
        new TypeReference<SubnetResponse>() {});
  }

  /** Update VPC */
  public Request<VpcResponse> updateVpc(String vpc_id, VpcUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "network",
            "https://network.{region}.basaltic.sh",
            OP_72,
            Map.ofEntries(Map.entry("vpc_id", vpc_id)),
            body,
            null),
        new TypeReference<VpcResponse>() {});
  }
}
