package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Iam.AssumeRoleRequestInput;
import sh.basaltic.sdk.models.Iam.AssumeRoleResponse;
import sh.basaltic.sdk.models.Iam.AssumeRoleWithWebIdentityRequestInput;
import sh.basaltic.sdk.models.Iam.CreatePersonalSSHKeyResponse;
import sh.basaltic.sdk.models.Iam.CreatePolicyResponse;
import sh.basaltic.sdk.models.Iam.CreateRoleResponse;
import sh.basaltic.sdk.models.Iam.CreateServiceAccountResponse;
import sh.basaltic.sdk.models.Iam.CreateServiceAccountSSHKeyResponse;
import sh.basaltic.sdk.models.Iam.Credential;
import sh.basaltic.sdk.models.Iam.CredentialCreateRequestInput;
import sh.basaltic.sdk.models.Iam.CredentialCreateResponse;
import sh.basaltic.sdk.models.Iam.CredentialListResponse;
import sh.basaltic.sdk.models.Iam.GetPersonalLinuxIdentityResponse;
import sh.basaltic.sdk.models.Iam.GetPolicyResponse;
import sh.basaltic.sdk.models.Iam.GetPolicyScope;
import sh.basaltic.sdk.models.Iam.GetRoleInlinePolicyScope;
import sh.basaltic.sdk.models.Iam.GetRoleResponse;
import sh.basaltic.sdk.models.Iam.GetRoleScope;
import sh.basaltic.sdk.models.Iam.GetSTSSessionScope;
import sh.basaltic.sdk.models.Iam.GetServiceAccountInlinePolicyScope;
import sh.basaltic.sdk.models.Iam.GetServiceAccountLinuxIdentityResponse;
import sh.basaltic.sdk.models.Iam.GetServiceAccountResponse;
import sh.basaltic.sdk.models.Iam.GetServiceAccountScope;
import sh.basaltic.sdk.models.Iam.InlinePolicy;
import sh.basaltic.sdk.models.Iam.InlinePolicyListResponse;
import sh.basaltic.sdk.models.Iam.InlinePolicyResponse;
import sh.basaltic.sdk.models.Iam.ListPersonalSSHKeysResponse;
import sh.basaltic.sdk.models.Iam.ListPoliciesQuery;
import sh.basaltic.sdk.models.Iam.ListPolicyRolesQuery;
import sh.basaltic.sdk.models.Iam.ListPolicyServiceAccountsQuery;
import sh.basaltic.sdk.models.Iam.ListRegionsQuery;
import sh.basaltic.sdk.models.Iam.ListRegionsResponse;
import sh.basaltic.sdk.models.Iam.ListRoleInlinePoliciesQuery;
import sh.basaltic.sdk.models.Iam.ListRolePoliciesQuery;
import sh.basaltic.sdk.models.Iam.ListRolesQuery;
import sh.basaltic.sdk.models.Iam.ListSTSSessionsQuery;
import sh.basaltic.sdk.models.Iam.ListServiceAccountCredentialsQuery;
import sh.basaltic.sdk.models.Iam.ListServiceAccountInlinePoliciesQuery;
import sh.basaltic.sdk.models.Iam.ListServiceAccountPoliciesQuery;
import sh.basaltic.sdk.models.Iam.ListServiceAccountSSHKeysResponse;
import sh.basaltic.sdk.models.Iam.ListServiceAccountsQuery;
import sh.basaltic.sdk.models.Iam.OAuthAuthorizeRequestInput;
import sh.basaltic.sdk.models.Iam.OAuthAuthorizeResponse;
import sh.basaltic.sdk.models.Iam.OAuthRevokeRequestInput;
import sh.basaltic.sdk.models.Iam.OAuthTokenRequestInput;
import sh.basaltic.sdk.models.Iam.OAuthTokenResponse;
import sh.basaltic.sdk.models.Iam.PermissionBoundaryResponse;
import sh.basaltic.sdk.models.Iam.Policy;
import sh.basaltic.sdk.models.Iam.PolicyAttachRequestInput;
import sh.basaltic.sdk.models.Iam.PolicyCreateRequestInput;
import sh.basaltic.sdk.models.Iam.PolicyListResponse;
import sh.basaltic.sdk.models.Iam.PolicyRolesListResponse;
import sh.basaltic.sdk.models.Iam.PolicyServiceAccountsListResponse;
import sh.basaltic.sdk.models.Iam.PolicyUpdateRequestInput;
import sh.basaltic.sdk.models.Iam.PrincipalPoliciesListResponse;
import sh.basaltic.sdk.models.Iam.PutInlinePolicyRequestInput;
import sh.basaltic.sdk.models.Iam.Region;
import sh.basaltic.sdk.models.Iam.RevokeSTSSessionBody;
import sh.basaltic.sdk.models.Iam.Role;
import sh.basaltic.sdk.models.Iam.RoleCreateRequestInput;
import sh.basaltic.sdk.models.Iam.RoleListResponse;
import sh.basaltic.sdk.models.Iam.RolePoliciesListResponse;
import sh.basaltic.sdk.models.Iam.RolePolicyAttachRequestInput;
import sh.basaltic.sdk.models.Iam.RoleUpdateRequestInput;
import sh.basaltic.sdk.models.Iam.SSHKey;
import sh.basaltic.sdk.models.Iam.SSHKeyCreateRequestInput;
import sh.basaltic.sdk.models.Iam.STSSession;
import sh.basaltic.sdk.models.Iam.STSSessionListResponse;
import sh.basaltic.sdk.models.Iam.STSSessionResponse;
import sh.basaltic.sdk.models.Iam.ServiceAccount;
import sh.basaltic.sdk.models.Iam.ServiceAccountCreateRequestInput;
import sh.basaltic.sdk.models.Iam.ServiceAccountListResponse;
import sh.basaltic.sdk.models.Iam.ServiceAccountUpdateRequestInput;
import sh.basaltic.sdk.models.Iam.SetBoundaryRequestInput;
import sh.basaltic.sdk.models.Iam.UpdatePolicyResponse;
import sh.basaltic.sdk.models.Iam.UpdateRoleResponse;
import sh.basaltic.sdk.models.Iam.UpdateServiceAccountResponse;

/** Typed iam API methods. */
public final class IamService {
  private final Transport transport;

  IamService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "assumeRole",
          "POST",
          "/v1/assume-role",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "assumeRoleWithWebIdentity",
          "POST",
          "/v1/assume-role-with-web-identity",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
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
  private static final Operation OP_3 =
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
  private static final Operation OP_4 =
      new Operation(
          "authorizeOAuthClient",
          "POST",
          "/v1/oauth/authorize",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "createPersonalSSHKey",
          "POST",
          "/v1/auth/ssh-keys",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
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
  private static final Operation OP_7 =
      new Operation(
          "createRole",
          "POST",
          "/v1/roles",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "createServiceAccount",
          "POST",
          "/v1/service-accounts",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "createServiceAccountCredential",
          "POST",
          "/v1/service-accounts/{service_account_id}/credentials",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "createServiceAccountSSHKey",
          "POST",
          "/v1/service-accounts/{service_account_id}/ssh-keys",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "deletePersonalSSHKey",
          "DELETE",
          "/v1/auth/ssh-keys/{ssh_key_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
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
  private static final Operation OP_13 =
      new Operation(
          "deleteRole",
          "DELETE",
          "/v1/roles/{role_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "deleteRoleInlinePolicy",
          "DELETE",
          "/v1/roles/{role_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "deleteServiceAccount",
          "DELETE",
          "/v1/service-accounts/{service_account_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "deleteServiceAccountCredential",
          "DELETE",
          "/v1/service-accounts/{service_account_id}/credentials/{credential_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "deleteServiceAccountInlinePolicy",
          "DELETE",
          "/v1/service-accounts/{service_account_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "deleteServiceAccountSSHKey",
          "DELETE",
          "/v1/service-accounts/{service_account_id}/ssh-keys/{ssh_key_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
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
  private static final Operation OP_20 =
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
  private static final Operation OP_21 =
      new Operation(
          "getOAuthToken",
          "POST",
          "/v1/oauth/token",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "getPersonalLinuxIdentity",
          "GET",
          "/v1/auth/linux-identity",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_23 =
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
  private static final Operation OP_24 =
      new Operation(
          "getRole",
          "GET",
          "/v1/roles/{role_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_25 =
      new Operation(
          "getRoleInlinePolicy",
          "GET",
          "/v1/roles/{role_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_26 =
      new Operation(
          "getRolePermissionBoundary",
          "GET",
          "/v1/roles/{role_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_27 =
      new Operation(
          "getSTSSession",
          "GET",
          "/v1/sts-sessions/{session_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_28 =
      new Operation(
          "getServiceAccount",
          "GET",
          "/v1/service-accounts/{service_account_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_29 =
      new Operation(
          "getServiceAccountInlinePolicy",
          "GET",
          "/v1/service-accounts/{service_account_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_30 =
      new Operation(
          "getServiceAccountLinuxIdentity",
          "GET",
          "/v1/service-accounts/{service_account_id}/linux-identity",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_31 =
      new Operation(
          "getServiceAccountPermissionBoundary",
          "GET",
          "/v1/service-accounts/{service_account_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_32 =
      new Operation(
          "listPersonalSSHKeys",
          "GET",
          "/v1/auth/ssh-keys",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_33 =
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
  private static final Operation OP_34 =
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
  private static final Operation OP_35 =
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
  private static final Operation OP_36 =
      new Operation(
          "listRegions",
          "GET",
          "/v1/regions",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_37 =
      new Operation(
          "listRoleInlinePolicies",
          "GET",
          "/v1/roles/{role_id}/inline-policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_38 =
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
  private static final Operation OP_39 =
      new Operation(
          "listRoles",
          "GET",
          "/v1/roles",
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
          "listSTSSessions",
          "GET",
          "/v1/sts-sessions",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("role", new Operation.Encoding("form", true)),
              Map.entry("principal", new Operation.Encoding("form", true)),
              Map.entry("principal_type", new Operation.Encoding("form", true)),
              Map.entry("active_only", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_41 =
      new Operation(
          "listServiceAccountCredentials",
          "GET",
          "/v1/service-accounts/{service_account_id}/credentials",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_42 =
      new Operation(
          "listServiceAccountInlinePolicies",
          "GET",
          "/v1/service-accounts/{service_account_id}/inline-policies",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_43 =
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
  private static final Operation OP_44 =
      new Operation(
          "listServiceAccountSSHKeys",
          "GET",
          "/v1/service-accounts/{service_account_id}/ssh-keys",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_45 =
      new Operation(
          "listServiceAccounts",
          "GET",
          "/v1/service-accounts",
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
          "putRoleInlinePolicy",
          "PUT",
          "/v1/roles/{role_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_47 =
      new Operation(
          "putServiceAccountInlinePolicy",
          "PUT",
          "/v1/service-accounts/{service_account_id}/inline-policies/{policy_name}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_48 =
      new Operation(
          "removeRolePermissionBoundary",
          "DELETE",
          "/v1/roles/{role_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_49 =
      new Operation(
          "removeServiceAccountPermissionBoundary",
          "DELETE",
          "/v1/service-accounts/{service_account_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_50 =
      new Operation(
          "revokeOAuthToken",
          "POST",
          "/v1/oauth/revoke",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_51 =
      new Operation(
          "revokeSTSSession",
          "DELETE",
          "/v1/sts-sessions/{session_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_52 =
      new Operation(
          "setRolePermissionBoundary",
          "PUT",
          "/v1/roles/{role_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_53 =
      new Operation(
          "setServiceAccountPermissionBoundary",
          "PUT",
          "/v1/service-accounts/{service_account_id}/permission-boundary",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_54 =
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
  private static final Operation OP_55 =
      new Operation(
          "updateRole",
          "PATCH",
          "/v1/roles/{role_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_56 =
      new Operation(
          "updateServiceAccount",
          "PATCH",
          "/v1/service-accounts/{service_account_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Assume role */
  public Request<AssumeRoleResponse> assumeRole(AssumeRoleRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_0, Map.ofEntries(), body, null),
        new TypeReference<AssumeRoleResponse>() {});
  }

  /** Assume role with web identity */
  public Request<AssumeRoleResponse> assumeRoleWithWebIdentity(
      AssumeRoleWithWebIdentityRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_1, Map.ofEntries(), body, null),
        new TypeReference<AssumeRoleResponse>() {});
  }

  /** Attach policy to role */
  public EmptyRequest attachRolePolicy(String role_id, RolePolicyAttachRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("role_id", role_id)),
            body,
            null));
  }

  /** Attach policy to service account */
  public EmptyRequest attachServiceAccountPolicy(
      String service_account_id, PolicyAttachRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            body,
            null));
  }

  /** Approve a CLI login and issue an authorization code */
  public Request<OAuthAuthorizeResponse> authorizeOAuthClient(OAuthAuthorizeRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_4, Map.ofEntries(), body, null),
        new TypeReference<OAuthAuthorizeResponse>() {});
  }

  /** Add personal SSH key */
  public Request<CreatePersonalSSHKeyResponse> createPersonalSSHKey(SSHKeyCreateRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_5, Map.ofEntries(), body, null),
        new TypeReference<CreatePersonalSSHKeyResponse>() {});
  }

  /** Create policy */
  public Request<CreatePolicyResponse> createPolicy(PolicyCreateRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_6, Map.ofEntries(), body, null),
        new TypeReference<CreatePolicyResponse>() {});
  }

  /** Create role */
  public Request<CreateRoleResponse> createRole(RoleCreateRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_7, Map.ofEntries(), body, null),
        new TypeReference<CreateRoleResponse>() {});
  }

  /** Create service account */
  public Request<CreateServiceAccountResponse> createServiceAccount(
      ServiceAccountCreateRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_8, Map.ofEntries(), body, null),
        new TypeReference<CreateServiceAccountResponse>() {});
  }

  /** Create credential */
  public Request<CredentialCreateResponse> createServiceAccountCredential(
      String service_account_id, CredentialCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            body,
            null),
        new TypeReference<CredentialCreateResponse>() {});
  }

  /** Add service-account SSH key */
  public Request<CreateServiceAccountSSHKeyResponse> createServiceAccountSSHKey(
      String service_account_id, SSHKeyCreateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            body,
            null),
        new TypeReference<CreateServiceAccountSSHKeyResponse>() {});
  }

  /** Revoke personal SSH key */
  public EmptyRequest deletePersonalSSHKey(String ssh_key_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("ssh_key_id", ssh_key_id)),
            null,
            null));
  }

  /** Delete policy */
  public EmptyRequest deletePolicy(String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Delete role */
  public EmptyRequest deleteRole(String role_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("role_id", role_id)),
            null,
            null));
  }

  /** Delete a role's inline policy by name */
  public EmptyRequest deleteRoleInlinePolicy(String role_id, String policy_name) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_14,
            Map.ofEntries(Map.entry("role_id", role_id), Map.entry("policy_name", policy_name)),
            null,
            null));
  }

  /** Delete service account */
  public EmptyRequest deleteServiceAccount(String service_account_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            null));
  }

  /** Delete credential */
  public EmptyRequest deleteServiceAccountCredential(
      String service_account_id, String credential_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_16,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("credential_id", credential_id)),
            null,
            null));
  }

  /** Delete a service account's inline policy by name */
  public EmptyRequest deleteServiceAccountInlinePolicy(
      String service_account_id, String policy_name) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_17,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("policy_name", policy_name)),
            null,
            null));
  }

  /** Revoke service-account SSH key */
  public EmptyRequest deleteServiceAccountSSHKey(String service_account_id, String ssh_key_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_18,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("ssh_key_id", ssh_key_id)),
            null,
            null));
  }

  /** Detach policy from role */
  public EmptyRequest detachRolePolicy(String role_id, String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_19,
            Map.ofEntries(Map.entry("role_id", role_id), Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Detach policy from service account */
  public EmptyRequest detachServiceAccountPolicy(String service_account_id, String policy_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_20,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("policy_id", policy_id)),
            null,
            null));
  }

  /** Exchange an access key for a bearer token */
  public Request<OAuthTokenResponse> getOAuthToken(OAuthTokenRequestInput body) {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_21, Map.ofEntries(), body, null),
        new TypeReference<OAuthTokenResponse>() {});
  }

  /** Get personal Linux identity */
  public Request<GetPersonalLinuxIdentityResponse> getPersonalLinuxIdentity() {
    return new Request<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_22, Map.ofEntries(), null, null),
        new TypeReference<GetPersonalLinuxIdentityResponse>() {});
  }

  /** Get policy */
  public Request<GetPolicyResponse> getPolicy(String policy_id) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_23,
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
            "iam",
            "https://iam.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("policy_id", reference)),
            null,
            null),
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_33, Map.ofEntries(), null, scope),
        reference,
        true,
        "policy",
        "policies",
        new TypeReference<Policy>() {});
  }

  public Request<Policy> getPolicyByReference(String reference) {
    return getPolicyByReference(reference, null);
  }

  /** Get role */
  public Request<GetRoleResponse> getRole(String role_id) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_24,
            Map.ofEntries(Map.entry("role_id", role_id)),
            null,
            null),
        new TypeReference<GetRoleResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Role> getRoleByReference(String reference, GetRoleScope scope) {
    return Request.reference(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_24,
            Map.ofEntries(Map.entry("role_id", reference)),
            null,
            null),
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_39, Map.ofEntries(), null, scope),
        reference,
        true,
        "role",
        "roles",
        new TypeReference<Role>() {});
  }

  public Request<Role> getRoleByReference(String reference) {
    return getRoleByReference(reference, null);
  }

  /** Get a role's inline policy by name */
  public Request<InlinePolicyResponse> getRoleInlinePolicy(String role_id, String policy_name) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("role_id", role_id), Map.entry("policy_name", policy_name)),
            null,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<InlinePolicy> getRoleInlinePolicyByReference(
      String role_id, String reference, GetRoleInlinePolicyScope scope) {
    return Request.reference(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("role_id", role_id), Map.entry("policy_name", reference)),
            null,
            null),
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_37,
            Map.ofEntries(Map.entry("role_id", role_id)),
            null,
            scope),
        reference,
        true,
        "inline_policy",
        "inline_policies",
        new TypeReference<InlinePolicy>() {});
  }

  public Request<InlinePolicy> getRoleInlinePolicyByReference(String role_id, String reference) {
    return getRoleInlinePolicyByReference(role_id, reference, null);
  }

  /** Get a role's permission boundary */
  public Request<PermissionBoundaryResponse> getRolePermissionBoundary(String role_id) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_26,
            Map.ofEntries(Map.entry("role_id", role_id)),
            null,
            null),
        new TypeReference<PermissionBoundaryResponse>() {});
  }

  /** Get STS session */
  public Request<STSSessionResponse> getSTSSession(String session_id) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("session_id", session_id)),
            null,
            null),
        new TypeReference<STSSessionResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<STSSession> getSTSSessionByReference(String reference, GetSTSSessionScope scope) {
    return Request.reference(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("session_id", reference)),
            null,
            null),
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_40, Map.ofEntries(), null, scope),
        reference,
        true,
        "sts_session",
        "sts_sessions",
        new TypeReference<STSSession>() {});
  }

  public Request<STSSession> getSTSSessionByReference(String reference) {
    return getSTSSessionByReference(reference, null);
  }

  /** Get service account */
  public Request<GetServiceAccountResponse> getServiceAccount(String service_account_id) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            null),
        new TypeReference<GetServiceAccountResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<ServiceAccount> getServiceAccountByReference(
      String reference, GetServiceAccountScope scope) {
    return Request.reference(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("service_account_id", reference)),
            null,
            null),
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_45, Map.ofEntries(), null, scope),
        reference,
        true,
        "service_account",
        "service_accounts",
        new TypeReference<ServiceAccount>() {});
  }

  public Request<ServiceAccount> getServiceAccountByReference(String reference) {
    return getServiceAccountByReference(reference, null);
  }

  /** Get a service account's inline policy by name */
  public Request<InlinePolicyResponse> getServiceAccountInlinePolicy(
      String service_account_id, String policy_name) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_29,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("policy_name", policy_name)),
            null,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<InlinePolicy> getServiceAccountInlinePolicyByReference(
      String service_account_id, String reference, GetServiceAccountInlinePolicyScope scope) {
    return Request.reference(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_29,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("policy_name", reference)),
            null,
            null),
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_42,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            scope),
        reference,
        true,
        "inline_policy",
        "inline_policies",
        new TypeReference<InlinePolicy>() {});
  }

  public Request<InlinePolicy> getServiceAccountInlinePolicyByReference(
      String service_account_id, String reference) {
    return getServiceAccountInlinePolicyByReference(service_account_id, reference, null);
  }

  /** Get serviceaccount Linux identity */
  public Request<GetServiceAccountLinuxIdentityResponse> getServiceAccountLinuxIdentity(
      String service_account_id) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_30,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            null),
        new TypeReference<GetServiceAccountLinuxIdentityResponse>() {});
  }

  /** Get a service account's permission boundary */
  public Request<PermissionBoundaryResponse> getServiceAccountPermissionBoundary(
      String service_account_id) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_31,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            null),
        new TypeReference<PermissionBoundaryResponse>() {});
  }

  /** List personal SSH keys */
  public PagedRequest<ListPersonalSSHKeysResponse, SSHKey> listPersonalSSHKeys() {
    return new PagedRequest<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_32, Map.ofEntries(), null, null),
        new TypeReference<ListPersonalSSHKeysResponse>() {},
        new TypeReference<SSHKey>() {},
        "ssh_keys");
  }

  /** List policies */
  public PagedRequest<PolicyListResponse, Policy> listPolicies(ListPoliciesQuery query) {
    return new PagedRequest<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_33, Map.ofEntries(), null, query),
        new TypeReference<PolicyListResponse>() {},
        new TypeReference<Policy>() {},
        "policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyListResponse, Policy> listPolicies() {
    return listPolicies(null);
  }

  /** List roles with policy */
  public PagedRequest<PolicyRolesListResponse, Role> listPolicyRoles(
      String policy_id, ListPolicyRolesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            query),
        new TypeReference<PolicyRolesListResponse>() {},
        new TypeReference<Role>() {},
        "roles");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyRolesListResponse, Role> listPolicyRoles(String policy_id) {
    return listPolicyRoles(policy_id, null);
  }

  /** List service accounts with policy */
  public PagedRequest<PolicyServiceAccountsListResponse, ServiceAccount> listPolicyServiceAccounts(
      String policy_id, ListPolicyServiceAccountsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_35,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            null,
            query),
        new TypeReference<PolicyServiceAccountsListResponse>() {},
        new TypeReference<ServiceAccount>() {},
        "service_accounts");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PolicyServiceAccountsListResponse, ServiceAccount> listPolicyServiceAccounts(
      String policy_id) {
    return listPolicyServiceAccounts(policy_id, null);
  }

  /** List regions (legacy IAM) */
  public PagedRequest<ListRegionsResponse, Region> listRegions(ListRegionsQuery query) {
    return new PagedRequest<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_36, Map.ofEntries(), null, query),
        new TypeReference<ListRegionsResponse>() {},
        new TypeReference<Region>() {},
        "regions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListRegionsResponse, Region> listRegions() {
    return listRegions(null);
  }

  /** List a role's inline policies */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listRoleInlinePolicies(
      String role_id, ListRoleInlinePoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_37,
            Map.ofEntries(Map.entry("role_id", role_id)),
            null,
            query),
        new TypeReference<InlinePolicyListResponse>() {},
        new TypeReference<InlinePolicy>() {},
        "inline_policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listRoleInlinePolicies(
      String role_id) {
    return listRoleInlinePolicies(role_id, null);
  }

  /** List role policies */
  public PagedRequest<RolePoliciesListResponse, Policy> listRolePolicies(
      String role_id, ListRolePoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_38,
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

  /** List roles */
  public PagedRequest<RoleListResponse, Role> listRoles(ListRolesQuery query) {
    return new PagedRequest<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_39, Map.ofEntries(), null, query),
        new TypeReference<RoleListResponse>() {},
        new TypeReference<Role>() {},
        "roles");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RoleListResponse, Role> listRoles() {
    return listRoles(null);
  }

  /** List STS sessions */
  public PagedRequest<STSSessionListResponse, STSSession> listSTSSessions(
      ListSTSSessionsQuery query) {
    return new PagedRequest<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_40, Map.ofEntries(), null, query),
        new TypeReference<STSSessionListResponse>() {},
        new TypeReference<STSSession>() {},
        "sts_sessions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<STSSessionListResponse, STSSession> listSTSSessions() {
    return listSTSSessions(null);
  }

  /** List credentials */
  public PagedRequest<CredentialListResponse, Credential> listServiceAccountCredentials(
      String service_account_id, ListServiceAccountCredentialsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_41,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            query),
        new TypeReference<CredentialListResponse>() {},
        new TypeReference<Credential>() {},
        "credentials");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<CredentialListResponse, Credential> listServiceAccountCredentials(
      String service_account_id) {
    return listServiceAccountCredentials(service_account_id, null);
  }

  /** List a service account's inline policies */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listServiceAccountInlinePolicies(
      String service_account_id, ListServiceAccountInlinePoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_42,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            query),
        new TypeReference<InlinePolicyListResponse>() {},
        new TypeReference<InlinePolicy>() {},
        "inline_policies");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InlinePolicyListResponse, InlinePolicy> listServiceAccountInlinePolicies(
      String service_account_id) {
    return listServiceAccountInlinePolicies(service_account_id, null);
  }

  /** List service account policies */
  public PagedRequest<PrincipalPoliciesListResponse, Policy> listServiceAccountPolicies(
      String service_account_id, ListServiceAccountPoliciesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_43,
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

  /** List service-account SSH keys */
  public PagedRequest<ListServiceAccountSSHKeysResponse, SSHKey> listServiceAccountSSHKeys(
      String service_account_id) {
    return new PagedRequest<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_44,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            null),
        new TypeReference<ListServiceAccountSSHKeysResponse>() {},
        new TypeReference<SSHKey>() {},
        "ssh_keys");
  }

  /** List service accounts */
  public PagedRequest<ServiceAccountListResponse, ServiceAccount> listServiceAccounts(
      ListServiceAccountsQuery query) {
    return new PagedRequest<>(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_45, Map.ofEntries(), null, query),
        new TypeReference<ServiceAccountListResponse>() {},
        new TypeReference<ServiceAccount>() {},
        "service_accounts");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ServiceAccountListResponse, ServiceAccount> listServiceAccounts() {
    return listServiceAccounts(null);
  }

  /** Create or replace a role's inline policy */
  public Request<InlinePolicyResponse> putRoleInlinePolicy(
      String role_id, String policy_name, PutInlinePolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_46,
            Map.ofEntries(Map.entry("role_id", role_id), Map.entry("policy_name", policy_name)),
            body,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Create or replace a service account's inline policy */
  public Request<InlinePolicyResponse> putServiceAccountInlinePolicy(
      String service_account_id, String policy_name, PutInlinePolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_47,
            Map.ofEntries(
                Map.entry("service_account_id", service_account_id),
                Map.entry("policy_name", policy_name)),
            body,
            null),
        new TypeReference<InlinePolicyResponse>() {});
  }

  /** Remove a role's permission boundary */
  public EmptyRequest removeRolePermissionBoundary(String role_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_48,
            Map.ofEntries(Map.entry("role_id", role_id)),
            null,
            null));
  }

  /** Remove a service account's permission boundary */
  public EmptyRequest removeServiceAccountPermissionBoundary(String service_account_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_49,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            null,
            null));
  }

  /** Revoke a bearer token */
  public EmptyRequest revokeOAuthToken(OAuthRevokeRequestInput body) {
    return new EmptyRequest(
        new Core(transport, "iam", "https://iam.basaltic.sh", OP_50, Map.ofEntries(), body, null));
  }

  /** Revoke STS session */
  public Request<STSSessionResponse> revokeSTSSession(
      String session_id, RevokeSTSSessionBody body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_51,
            Map.ofEntries(Map.entry("session_id", session_id)),
            body,
            null),
        new TypeReference<STSSessionResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<STSSessionResponse> revokeSTSSession(String session_id) {
    return revokeSTSSession(session_id, null);
  }

  /** Set a role's permission boundary */
  public EmptyRequest setRolePermissionBoundary(String role_id, SetBoundaryRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_52,
            Map.ofEntries(Map.entry("role_id", role_id)),
            body,
            null));
  }

  /** Set a service account's permission boundary */
  public EmptyRequest setServiceAccountPermissionBoundary(
      String service_account_id, SetBoundaryRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_53,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            body,
            null));
  }

  /** Update policy */
  public Request<UpdatePolicyResponse> updatePolicy(
      String policy_id, PolicyUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_54,
            Map.ofEntries(Map.entry("policy_id", policy_id)),
            body,
            null),
        new TypeReference<UpdatePolicyResponse>() {});
  }

  /** Update role */
  public Request<UpdateRoleResponse> updateRole(String role_id, RoleUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_55,
            Map.ofEntries(Map.entry("role_id", role_id)),
            body,
            null),
        new TypeReference<UpdateRoleResponse>() {});
  }

  /** Update service account */
  public Request<UpdateServiceAccountResponse> updateServiceAccount(
      String service_account_id, ServiceAccountUpdateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "iam",
            "https://iam.basaltic.sh",
            OP_56,
            Map.ofEntries(Map.entry("service_account_id", service_account_id)),
            body,
            null),
        new TypeReference<UpdateServiceAccountResponse>() {});
  }
}
