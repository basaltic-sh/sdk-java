package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Workspace.Account;
import sh.basaltic.sdk.models.Workspace.AccountListResponse;
import sh.basaltic.sdk.models.Workspace.AccountPrincipalReference;
import sh.basaltic.sdk.models.Workspace.AccountResponse;
import sh.basaltic.sdk.models.Workspace.AccountRole;
import sh.basaltic.sdk.models.Workspace.AccountRoleAssignment;
import sh.basaltic.sdk.models.Workspace.AccountRoleAssignmentCreateRequestInput;
import sh.basaltic.sdk.models.Workspace.AccountRoleAssignmentListResponse;
import sh.basaltic.sdk.models.Workspace.AccountRoleAssignmentResponse;
import sh.basaltic.sdk.models.Workspace.AccountRoleListResponse;
import sh.basaltic.sdk.models.Workspace.CreateAccountRequestInput;
import sh.basaltic.sdk.models.Workspace.CreateGroupResponse;
import sh.basaltic.sdk.models.Workspace.CreatePolicyResponse;
import sh.basaltic.sdk.models.Workspace.GetAccountResourcesResponse;
import sh.basaltic.sdk.models.Workspace.GetAccountScope;
import sh.basaltic.sdk.models.Workspace.GetGroupInlinePolicyScope;
import sh.basaltic.sdk.models.Workspace.GetGroupResponse;
import sh.basaltic.sdk.models.Workspace.GetGroupScope;
import sh.basaltic.sdk.models.Workspace.GetInvitationResponse;
import sh.basaltic.sdk.models.Workspace.GetInvitationScope;
import sh.basaltic.sdk.models.Workspace.GetOrganizationScope;
import sh.basaltic.sdk.models.Workspace.GetPolicyResponse;
import sh.basaltic.sdk.models.Workspace.GetPolicyScope;
import sh.basaltic.sdk.models.Workspace.GetUserInlinePolicyScope;
import sh.basaltic.sdk.models.Workspace.GetUserResponse;
import sh.basaltic.sdk.models.Workspace.GetUserScope;
import sh.basaltic.sdk.models.Workspace.Group;
import sh.basaltic.sdk.models.Workspace.GroupCreateRequestInput;
import sh.basaltic.sdk.models.Workspace.GroupListResponse;
import sh.basaltic.sdk.models.Workspace.GroupUpdateRequestInput;
import sh.basaltic.sdk.models.Workspace.GroupUser;
import sh.basaltic.sdk.models.Workspace.GroupUsersListResponse;
import sh.basaltic.sdk.models.Workspace.InlinePolicy;
import sh.basaltic.sdk.models.Workspace.InlinePolicyListResponse;
import sh.basaltic.sdk.models.Workspace.InlinePolicyResponse;
import sh.basaltic.sdk.models.Workspace.Invitation;
import sh.basaltic.sdk.models.Workspace.InvitationListResponse;
import sh.basaltic.sdk.models.Workspace.ListAccountsQuery;
import sh.basaltic.sdk.models.Workspace.ListGroupInlinePoliciesQuery;
import sh.basaltic.sdk.models.Workspace.ListGroupPoliciesQuery;
import sh.basaltic.sdk.models.Workspace.ListGroupUsersQuery;
import sh.basaltic.sdk.models.Workspace.ListGroupsQuery;
import sh.basaltic.sdk.models.Workspace.ListInvitationsQuery;
import sh.basaltic.sdk.models.Workspace.ListOrganizationsQuery;
import sh.basaltic.sdk.models.Workspace.ListPoliciesQuery;
import sh.basaltic.sdk.models.Workspace.ListPolicyGroupsQuery;
import sh.basaltic.sdk.models.Workspace.ListPolicyRolesQuery;
import sh.basaltic.sdk.models.Workspace.ListPolicyServiceAccountsQuery;
import sh.basaltic.sdk.models.Workspace.ListPolicyUsersQuery;
import sh.basaltic.sdk.models.Workspace.ListRolePoliciesQuery;
import sh.basaltic.sdk.models.Workspace.ListServiceAccountPoliciesQuery;
import sh.basaltic.sdk.models.Workspace.ListUserGroupsQuery;
import sh.basaltic.sdk.models.Workspace.ListUserInlinePoliciesQuery;
import sh.basaltic.sdk.models.Workspace.ListUserPoliciesQuery;
import sh.basaltic.sdk.models.Workspace.ListUsersQuery;
import sh.basaltic.sdk.models.Workspace.Organization;
import sh.basaltic.sdk.models.Workspace.OrganizationListResponse;
import sh.basaltic.sdk.models.Workspace.OrganizationPolicyAttachRequestInput;
import sh.basaltic.sdk.models.Workspace.OrganizationResponse;
import sh.basaltic.sdk.models.Workspace.OrganizationUpdateRequestInput;
import sh.basaltic.sdk.models.Workspace.OrganizationWithMembership;
import sh.basaltic.sdk.models.Workspace.PermissionBoundaryResponse;
import sh.basaltic.sdk.models.Workspace.Policy;
import sh.basaltic.sdk.models.Workspace.PolicyAttachRequestInput;
import sh.basaltic.sdk.models.Workspace.PolicyCreateRequestInput;
import sh.basaltic.sdk.models.Workspace.PolicyGroupsListResponse;
import sh.basaltic.sdk.models.Workspace.PolicyListResponse;
import sh.basaltic.sdk.models.Workspace.PolicyRolesListResponse;
import sh.basaltic.sdk.models.Workspace.PolicyServiceAccountsListResponse;
import sh.basaltic.sdk.models.Workspace.PolicyUpdateRequestInput;
import sh.basaltic.sdk.models.Workspace.PolicyUsersListResponse;
import sh.basaltic.sdk.models.Workspace.PrincipalPoliciesListResponse;
import sh.basaltic.sdk.models.Workspace.PutInlinePolicyRequestInput;
import sh.basaltic.sdk.models.Workspace.RolePoliciesListResponse;
import sh.basaltic.sdk.models.Workspace.SetBoundaryRequestInput;
import sh.basaltic.sdk.models.Workspace.UpdateAccountRequestInput;
import sh.basaltic.sdk.models.Workspace.UpdateGroupResponse;
import sh.basaltic.sdk.models.Workspace.UpdatePolicyResponse;
import sh.basaltic.sdk.models.Workspace.User;
import sh.basaltic.sdk.models.Workspace.UserAddRequestInput;
import sh.basaltic.sdk.models.Workspace.UserAddResponse;
import sh.basaltic.sdk.models.Workspace.UserGroupAddRequestInput;
import sh.basaltic.sdk.models.Workspace.UserListResponse;

/** Typed workspace API methods. */
public final class WorkspaceService {
  private final Transport transport;

  WorkspaceService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "addUser",
          "POST",
          "/v1/users",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "addUserToGroup",
          "POST",
          "/v1/users/{user_id}/groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "assignAccountRole",
          "POST",
          "/v1/accounts/{account_id}/role-assignments",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "attachGroupPolicy",
          "POST",
          "/v1/groups/{group_id}/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "attachRolePolicy",
          "POST",
          "/v1/roles/{role_id}/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "attachServiceAccountPolicy",
          "POST",
          "/v1/service-accounts/{service_account_id}/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "attachUserPolicy",
          "POST",
          "/v1/users/{user_id}/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "cancelInvitation",
          "DELETE",
          "/v1/invitations/{invitation_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "createAccount",
          "POST",
          "/v1/accounts",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "createGroup",
          "POST",
          "/v1/groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "createPolicy",
          "POST",
          "/v1/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "deleteAccount",
          "DELETE",
          "/v1/accounts/{account_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "deleteGroup",
          "DELETE",
          "/v1/groups/{group_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "deleteGroupInlinePolicy",
          "DELETE",
          "/v1/groups/{group_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "deleteOrganization",
          "DELETE",
          "/v1/organizations/{organization_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "deletePolicy",
          "DELETE",
          "/v1/policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "deleteUserInlinePolicy",
          "DELETE",
          "/v1/users/{user_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "detachGroupPolicy",
          "DELETE",
          "/v1/groups/{group_id}/policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "detachRolePolicy",
          "DELETE",
          "/v1/roles/{role_id}/policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "detachServiceAccountPolicy",
          "DELETE",
          "/v1/service-accounts/{service_account_id}/policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "detachUserPolicy",
          "DELETE",
          "/v1/users/{user_id}/policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "getAccount",
          "GET",
          "/v1/accounts/{account_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "getAccountResources",
          "GET",
          "/v1/accounts/{account_id}/resources",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_23 =
      new Operation(
          "getGroup",
          "GET",
          "/v1/groups/{group_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_24 =
      new Operation(
          "getGroupInlinePolicy",
          "GET",
          "/v1/groups/{group_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_25 =
      new Operation(
          "getInvitation",
          "GET",
          "/v1/invitations/{invitation_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_26 =
      new Operation(
          "getOrganization",
          "GET",
          "/v1/organizations/{organization_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_27 =
      new Operation(
          "getPolicy",
          "GET",
          "/v1/policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_28 =
      new Operation(
          "getUser",
          "GET",
          "/v1/users/{user_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_29 =
      new Operation(
          "getUserInlinePolicy",
          "GET",
          "/v1/users/{user_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_30 =
      new Operation(
          "getUserPermissionBoundary",
          "GET",
          "/v1/users/{user_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_31 =
      new Operation(
          "listAccountRoleAssignments",
          "GET",
          "/v1/accounts/{account_id}/role-assignments",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_32 =
      new Operation(
          "listAccountRoles",
          "GET",
          "/v1/account-roles",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_33 =
      new Operation(
          "listAccounts",
          "GET",
          "/v1/accounts",
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
  private static final Operation OP_34 =
      new Operation(
          "listGroupInlinePolicies",
          "GET",
          "/v1/groups/{group_id}/inline-policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_35 =
      new Operation(
          "listGroupPolicies",
          "GET",
          "/v1/groups/{group_id}/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_36 =
      new Operation(
          "listGroupUsers",
          "GET",
          "/v1/groups/{group_id}/users",
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
  private static final Operation OP_37 =
      new Operation(
          "listGroups",
          "GET",
          "/v1/groups",
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
  private static final Operation OP_38 =
      new Operation(
          "listInvitations",
          "GET",
          "/v1/invitations",
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
  private static final Operation OP_39 =
      new Operation(
          "listOrganizations",
          "GET",
          "/v1/organizations",
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
  private static final Operation OP_40 =
      new Operation(
          "listPolicies",
          "GET",
          "/v1/policies",
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
  private static final Operation OP_41 =
      new Operation(
          "listPolicyGroups",
          "GET",
          "/v1/policies/{policy_id}/groups",
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
  private static final Operation OP_42 =
      new Operation(
          "listPolicyRoles",
          "GET",
          "/v1/policies/{policy_id}/roles",
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
  private static final Operation OP_43 =
      new Operation(
          "listPolicyServiceAccounts",
          "GET",
          "/v1/policies/{policy_id}/service-accounts",
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
  private static final Operation OP_44 =
      new Operation(
          "listPolicyUsers",
          "GET",
          "/v1/policies/{policy_id}/users",
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
          "listRolePolicies",
          "GET",
          "/v1/roles/{role_id}/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_46 =
      new Operation(
          "listServiceAccountPolicies",
          "GET",
          "/v1/service-accounts/{service_account_id}/policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_47 =
      new Operation(
          "listUserGroups",
          "GET",
          "/v1/users/{user_id}/groups",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_48 =
      new Operation(
          "listUserInlinePolicies",
          "GET",
          "/v1/users/{user_id}/inline-policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_49 =
      new Operation(
          "listUserPolicies",
          "GET",
          "/v1/users/{user_id}/policies",
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
          "listUsers",
          "GET",
          "/v1/users",
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
  private static final Operation OP_51 =
      new Operation(
          "putGroupInlinePolicy",
          "PUT",
          "/v1/groups/{group_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_52 =
      new Operation(
          "putUserInlinePolicy",
          "PUT",
          "/v1/users/{user_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_53 =
      new Operation(
          "removeAccountRoleAssignment",
          "DELETE",
          "/v1/accounts/{account_id}/role-assignments/{assignment_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_54 =
      new Operation(
          "removeUser",
          "DELETE",
          "/v1/users/{user_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_55 =
      new Operation(
          "removeUserFromGroup",
          "DELETE",
          "/v1/users/{user_id}/groups/{group_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_56 =
      new Operation(
          "removeUserPermissionBoundary",
          "DELETE",
          "/v1/users/{user_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_57 =
      new Operation(
          "setUserPermissionBoundary",
          "PUT",
          "/v1/users/{user_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_58 =
      new Operation(
          "updateAccount",
          "PATCH",
          "/v1/accounts/{account_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_59 =
      new Operation(
          "updateGroup",
          "PATCH",
          "/v1/groups/{group_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_60 =
      new Operation(
          "updateOrganization",
          "PATCH",
          "/v1/organizations/{organization_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_61 =
      new Operation(
          "updatePolicy",
          "PATCH",
          "/v1/policies/{policy_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Add user to organization */
  public Request<UserAddResponse> addUser(UserAddRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_0,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<UserAddResponse>() {});
  }

  /** Add user to group */
  public EmptyRequest addUserToGroup(String user_id, UserGroupAddRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("user_id", user_id)),
            body,
            null));
  }

  /** Assign account role */
  public Request<AccountRoleAssignmentResponse> assignAccountRole(
      String account_id, AccountRoleAssignmentCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("account_id", account_id)),
            body,
            null),
        new TypeReference<AccountRoleAssignmentResponse>() {});
  }

  /** Attach policy to group */
  public EmptyRequest attachGroupPolicy(String group_id, PolicyAttachRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("group_id", group_id)),
            body,
            null));
  }

  /** Attach policy to role */
  public EmptyRequest attachRolePolicy(String role_id, OrganizationPolicyAttachRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("role_id", role_id)),
            body,
            null));
  }

  /** Attach policy to service account */
  public EmptyRequest attachServiceAccountPolicy(
      String service_account_id, OrganizationPolicyAttachRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            body,
            null));
  }

  /** Attach policy to user */
  public EmptyRequest attachUserPolicy(String user_id, PolicyAttachRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("user_id", user_id)),
            body,
            null));
  }

  /** Cancel invitation */
  public EmptyRequest cancelInvitation(String invitation_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("invitation_id", invitation_id)),
            null,
            null));
  }

  /** Create account */
  public Request<AccountResponse> createAccount(CreateAccountRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_8,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<AccountResponse>() {});
  }

  /** Create group */
  public Request<CreateGroupResponse> createGroup(GroupCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_9,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<CreateGroupResponse>() {});
  }

  /** Create policy */
  public Request<CreatePolicyResponse> createPolicy(PolicyCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_10,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<CreatePolicyResponse>() {});
  }

  /** Delete account */
  public EmptyRequest deleteAccount(String account_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("account_id", account_id)),
            null,
            null));
  }

  /** Delete group */
  public EmptyRequest deleteGroup(String group_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("group_id", group_id)),
            null,
            null));
  }

  /** Delete a group's inline policy by name */
  public EmptyRequest deleteGroupInlinePolicy(String group_id, String policy_name) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("group_id", group_id), Map.entry("policy_name", policy_name)),
            null,
            null));
  }

  /** Delete organization */
  public EmptyRequest deleteOrganization(String organization_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_14,
            Map.ofEntries(Map.entry("organization_id", organization_id)),
            null,
            null));
  }

  /** Delete policy */
  public EmptyRequest deletePolicy(String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Delete a user's inline policy by name */
  public EmptyRequest deleteUserInlinePolicy(String user_id, String policy_name) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("user_id", user_id), Map.entry("policy_name", policy_name)),
            null,
            null));
  }

  /** Detach policy from group */
  public EmptyRequest detachGroupPolicy(String group_id, String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("group_id", group_id), Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Detach policy from role */
  public EmptyRequest detachRolePolicy(String role_id, String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("role_id", role_id), Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Detach policy from service account */
  public EmptyRequest detachServiceAccountPolicy(String service_account_id, String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_19,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Detach policy from user */
  public EmptyRequest detachUserPolicy(String user_id, String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_20,
            Map.ofEntries(Map.entry("user_id", user_id), Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Get account */
  public Request<AccountResponse> getAccount(String account_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_21,
            Map.ofEntries(Map.entry("account_id", account_id)),
            null,
            null),
        new TypeReference<AccountResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Account> getAccountByReference(String reference, GetAccountScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_21,
            Map.ofEntries(Map.entry("account_id", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_33,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "account",
        "accounts",
        new TypeReference<Account>() {});
  }

  public Request<Account> getAccountByReference(String reference) {
    return getAccountByReference(reference, null);
  }

  /** Check account resource presence */
  public Request<GetAccountResourcesResponse> getAccountResources(String account_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("account_id", account_id)),
            null,
            null),
        new TypeReference<GetAccountResourcesResponse>() {});
  }

  /** Get group */
  public Request<GetGroupResponse> getGroup(String group_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("group_id", group_id)),
            null,
            null),
        new TypeReference<GetGroupResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Group> getGroupByReference(String reference, GetGroupScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("group_id", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_37,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "group",
        "groups",
        new TypeReference<Group>() {});
  }

  public Request<Group> getGroupByReference(String reference) {
    return getGroupByReference(reference, null);
  }

  /** Get a group's inline policy by name */
  public Request<InlinePolicyResponse> getGroupInlinePolicy(String group_id, String policy_name) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_24,
            Map.ofEntries(Map.entry("group_id", group_id), Map.entry("policy_name", policy_name)),
            null,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<InlinePolicy> getGroupInlinePolicyByReference(
      String group_id, String reference, GetGroupInlinePolicyScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_24,
            Map.ofEntries(Map.entry("group_id", group_id), Map.entry("policy_name", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("group_id", group_id)),
            null,
            scope),
        reference,
        true,
        "inline_policy",
        "inline_policies",
        new TypeReference<InlinePolicy>() {});
  }

  public Request<InlinePolicy> getGroupInlinePolicyByReference(String group_id, String reference) {
    return getGroupInlinePolicyByReference(group_id, reference, null);
  }

  /** Get invitation */
  public Request<GetInvitationResponse> getInvitation(String invitation_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("invitation_id", invitation_id)),
            null,
            null),
        new TypeReference<GetInvitationResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Invitation> getInvitationByReference(String reference, GetInvitationScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("invitation_id", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_38,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "invitation",
        "invitations",
        new TypeReference<Invitation>() {});
  }

  public Request<Invitation> getInvitationByReference(String reference) {
    return getInvitationByReference(reference, null);
  }

  /** Get organization */
  public Request<OrganizationResponse> getOrganization(String organization_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_26,
            Map.ofEntries(Map.entry("organization_id", organization_id)),
            null,
            null),
        new TypeReference<OrganizationResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Organization> getOrganizationByReference(
      String reference, GetOrganizationScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_26,
            Map.ofEntries(Map.entry("organization_id", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_39,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "organization",
        "organizations",
        new TypeReference<Organization>() {});
  }

  public Request<Organization> getOrganizationByReference(String reference) {
    return getOrganizationByReference(reference, null);
  }

  /** Get policy */
  public Request<GetPolicyResponse> getPolicy(String policy_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            null),
        new TypeReference<GetPolicyResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Policy> getPolicyByReference(String reference, GetPolicyScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("policy_id", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_40,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "policy",
        "policies",
        new TypeReference<Policy>() {});
  }

  public Request<Policy> getPolicyByReference(String reference) {
    return getPolicyByReference(reference, null);
  }

  /** Get user */
  public Request<GetUserResponse> getUser(String user_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            null),
        new TypeReference<GetUserResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<User> getUserByReference(String reference, GetUserScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("user_id", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_50,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "user",
        "users",
        new TypeReference<User>() {});
  }

  public Request<User> getUserByReference(String reference) {
    return getUserByReference(reference, null);
  }

  /** Get a user's inline policy by name */
  public Request<InlinePolicyResponse> getUserInlinePolicy(String user_id, String policy_name) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_29,
            Map.ofEntries(Map.entry("user_id", user_id), Map.entry("policy_name", policy_name)),
            null,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<InlinePolicy> getUserInlinePolicyByReference(
      String user_id, String reference, GetUserInlinePolicyScope scope) {
    return Request.reference(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_29,
            Map.ofEntries(Map.entry("user_id", user_id), Map.entry("policy_name", reference)),
            null,
            null),
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_48,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            scope),
        reference,
        true,
        "inline_policy",
        "inline_policies",
        new TypeReference<InlinePolicy>() {});
  }

  public Request<InlinePolicy> getUserInlinePolicyByReference(String user_id, String reference) {
    return getUserInlinePolicyByReference(user_id, reference, null);
  }

  /** Get a user's permission boundary */
  public Request<PermissionBoundaryResponse> getUserPermissionBoundary(String user_id) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_30,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            null),
        new TypeReference<PermissionBoundaryResponse>() {});
  }

  /** List account role assignments */
  public PagedRequest<AccountRoleAssignmentListResponse, AccountRoleAssignment>
      listAccountRoleAssignments(String account_id) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_31,
            Map.ofEntries(Map.entry("account_id", account_id)),
            null,
            null),
        new TypeReference<AccountRoleAssignmentListResponse>() {},
        new TypeReference<AccountRoleAssignment>() {},
        "role_assignments");
  }

  /** List assigned account roles */
  public PagedRequest<AccountRoleListResponse, AccountRole> listAccountRoles() {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_32,
            Map.ofEntries(),
            null,
            null),
        new TypeReference<AccountRoleListResponse>() {},
        new TypeReference<AccountRole>() {},
        "account_roles");
  }

  /** List accounts */
  public PagedRequest<AccountListResponse, Account> listAccounts(ListAccountsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_33,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<AccountListResponse>() {},
        new TypeReference<Account>() {},
        "accounts");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<AccountListResponse, Account> listAccounts() {
    return listAccounts(null);
  }

  /** List a group's inline policies */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listGroupInlinePolicies(
      String group_id, ListGroupInlinePoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("group_id", group_id)),
            null,
            query),
        new TypeReference<InlinePolicyListResponse>() {},
        new TypeReference<InlinePolicy>() {},
        "inline_policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listGroupInlinePolicies(
      String group_id) {
    return listGroupInlinePolicies(group_id, null);
  }

  /** List group policies */
  public PagedRequest<PrincipalPoliciesListResponse, Policy> listGroupPolicies(
      String group_id, ListGroupPoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_35,
            Map.ofEntries(Map.entry("group_id", group_id)),
            null,
            query),
        new TypeReference<PrincipalPoliciesListResponse>() {},
        new TypeReference<Policy>() {},
        "policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PrincipalPoliciesListResponse, Policy> listGroupPolicies(String group_id) {
    return listGroupPolicies(group_id, null);
  }

  /** List group users */
  public PagedRequest<GroupUsersListResponse, GroupUser> listGroupUsers(
      String group_id, ListGroupUsersQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_36,
            Map.ofEntries(Map.entry("group_id", group_id)),
            null,
            query),
        new TypeReference<GroupUsersListResponse>() {},
        new TypeReference<GroupUser>() {},
        "users");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<GroupUsersListResponse, GroupUser> listGroupUsers(String group_id) {
    return listGroupUsers(group_id, null);
  }

  /** List groups */
  public PagedRequest<GroupListResponse, Group> listGroups(ListGroupsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_37,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<GroupListResponse>() {},
        new TypeReference<Group>() {},
        "groups");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<GroupListResponse, Group> listGroups() {
    return listGroups(null);
  }

  /** List invitations */
  public PagedRequest<InvitationListResponse, Invitation> listInvitations(
      ListInvitationsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_38,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<InvitationListResponse>() {},
        new TypeReference<Invitation>() {},
        "invitations");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InvitationListResponse, Invitation> listInvitations() {
    return listInvitations(null);
  }

  /** List organizations */
  public PagedRequest<OrganizationListResponse, OrganizationWithMembership> listOrganizations(
      ListOrganizationsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_39,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<OrganizationListResponse>() {},
        new TypeReference<OrganizationWithMembership>() {},
        "organizations");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<OrganizationListResponse, OrganizationWithMembership> listOrganizations() {
    return listOrganizations(null);
  }

  /** List policies */
  public PagedRequest<PolicyListResponse, Policy> listPolicies(ListPoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_40,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<PolicyListResponse>() {},
        new TypeReference<Policy>() {},
        "policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyListResponse, Policy> listPolicies() {
    return listPolicies(null);
  }

  /** List groups with policy */
  public PagedRequest<PolicyGroupsListResponse, Group> listPolicyGroups(
      String policy_id, ListPolicyGroupsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_41,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            query),
        new TypeReference<PolicyGroupsListResponse>() {},
        new TypeReference<Group>() {},
        "groups");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyGroupsListResponse, Group> listPolicyGroups(String policy_id) {
    return listPolicyGroups(policy_id, null);
  }

  /** List roles with policy */
  public PagedRequest<PolicyRolesListResponse, AccountPrincipalReference> listPolicyRoles(
      String policy_id, ListPolicyRolesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_42,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            query),
        new TypeReference<PolicyRolesListResponse>() {},
        new TypeReference<AccountPrincipalReference>() {},
        "roles");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyRolesListResponse, AccountPrincipalReference> listPolicyRoles(
      String policy_id) {
    return listPolicyRoles(policy_id, null);
  }

  /** List service accounts with policy */
  public PagedRequest<PolicyServiceAccountsListResponse, AccountPrincipalReference>
      listPolicyServiceAccounts(String policy_id, ListPolicyServiceAccountsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_43,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            query),
        new TypeReference<PolicyServiceAccountsListResponse>() {},
        new TypeReference<AccountPrincipalReference>() {},
        "service_accounts");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyServiceAccountsListResponse, AccountPrincipalReference>
      listPolicyServiceAccounts(String policy_id) {
    return listPolicyServiceAccounts(policy_id, null);
  }

  /** List users with policy */
  public PagedRequest<PolicyUsersListResponse, User> listPolicyUsers(
      String policy_id, ListPolicyUsersQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_44,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            query),
        new TypeReference<PolicyUsersListResponse>() {},
        new TypeReference<User>() {},
        "users");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyUsersListResponse, User> listPolicyUsers(String policy_id) {
    return listPolicyUsers(policy_id, null);
  }

  /** List role policies */
  public PagedRequest<RolePoliciesListResponse, Policy> listRolePolicies(
      String role_id, ListRolePoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_45,
            Map.ofEntries(Map.entry("role_id", role_id)),
            null,
            query),
        new TypeReference<RolePoliciesListResponse>() {},
        new TypeReference<Policy>() {},
        "policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RolePoliciesListResponse, Policy> listRolePolicies(String role_id) {
    return listRolePolicies(role_id, null);
  }

  /** List service account policies */
  public PagedRequest<PrincipalPoliciesListResponse, Policy> listServiceAccountPolicies(
      String service_account_id, ListServiceAccountPoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_46,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            query),
        new TypeReference<PrincipalPoliciesListResponse>() {},
        new TypeReference<Policy>() {},
        "policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PrincipalPoliciesListResponse, Policy> listServiceAccountPolicies(
      String service_account_id) {
    return listServiceAccountPolicies(service_account_id, null);
  }

  /** List user groups */
  public PagedRequest<GroupListResponse, Group> listUserGroups(
      String user_id, ListUserGroupsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_47,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            query),
        new TypeReference<GroupListResponse>() {},
        new TypeReference<Group>() {},
        "groups");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<GroupListResponse, Group> listUserGroups(String user_id) {
    return listUserGroups(user_id, null);
  }

  /** List a user's inline policies */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listUserInlinePolicies(
      String user_id, ListUserInlinePoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_48,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            query),
        new TypeReference<InlinePolicyListResponse>() {},
        new TypeReference<InlinePolicy>() {},
        "inline_policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listUserInlinePolicies(
      String user_id) {
    return listUserInlinePolicies(user_id, null);
  }

  /** List user policies */
  public PagedRequest<PrincipalPoliciesListResponse, Policy> listUserPolicies(
      String user_id, ListUserPoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_49,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            query),
        new TypeReference<PrincipalPoliciesListResponse>() {},
        new TypeReference<Policy>() {},
        "policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PrincipalPoliciesListResponse, Policy> listUserPolicies(String user_id) {
    return listUserPolicies(user_id, null);
  }

  /** List users */
  public PagedRequest<UserListResponse, User> listUsers(ListUsersQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_50,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<UserListResponse>() {},
        new TypeReference<User>() {},
        "users");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<UserListResponse, User> listUsers() {
    return listUsers(null);
  }

  /** Create or replace a group's inline policy */
  public Request<InlinePolicyResponse> putGroupInlinePolicy(
      String group_id, String policy_name, PutInlinePolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_51,
            Map.ofEntries(Map.entry("group_id", group_id), Map.entry("policy_name", policy_name)),
            body,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Create or replace a user's inline policy */
  public Request<InlinePolicyResponse> putUserInlinePolicy(
      String user_id, String policy_name, PutInlinePolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_52,
            Map.ofEntries(Map.entry("user_id", user_id), Map.entry("policy_name", policy_name)),
            body,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Remove account role assignment */
  public EmptyRequest removeAccountRoleAssignment(String account_id, String assignment_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_53,
            Map.ofEntries(
                Map.entry("account_id", account_id), Map.entry("assignment_id", assignment_id)),
            null,
            null));
  }

  /** Remove user from organization */
  public EmptyRequest removeUser(String user_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_54,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            null));
  }

  /** Remove user from group */
  public EmptyRequest removeUserFromGroup(String user_id, String group_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_55,
            Map.ofEntries(Map.entry("user_id", user_id), Map.entry("group_id", group_id)),
            null,
            null));
  }

  /** Remove a user's permission boundary */
  public EmptyRequest removeUserPermissionBoundary(String user_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_56,
            Map.ofEntries(Map.entry("user_id", user_id)),
            null,
            null));
  }

  /** Set a user's permission boundary */
  public EmptyRequest setUserPermissionBoundary(String user_id, SetBoundaryRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_57,
            Map.ofEntries(Map.entry("user_id", user_id)),
            body,
            null));
  }

  /** Update account */
  public Request<AccountResponse> updateAccount(String account_id, UpdateAccountRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_58,
            Map.ofEntries(Map.entry("account_id", account_id)),
            body,
            null),
        new TypeReference<AccountResponse>() {});
  }

  /** Update group */
  public Request<UpdateGroupResponse> updateGroup(String group_id, GroupUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_59,
            Map.ofEntries(Map.entry("group_id", group_id)),
            body,
            null),
        new TypeReference<UpdateGroupResponse>() {});
  }

  /** Update organization */
  public Request<OrganizationResponse> updateOrganization(
      String organization_id, OrganizationUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_60,
            Map.ofEntries(Map.entry("organization_id", organization_id)),
            body,
            null),
        new TypeReference<OrganizationResponse>() {});
  }

  /** Update policy */
  public Request<UpdatePolicyResponse> updatePolicy(
      String policy_id, PolicyUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "workspace",
            "https://workspace.basaltic.sh",
            OP_61,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            body,
            null),
        new TypeReference<UpdatePolicyResponse>() {});
  }
}
