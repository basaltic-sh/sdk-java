package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.internal.Model;

/** Typed workspace wire models. Unknown string enum values are retained. */
public final class Workspace {

  private Workspace() {}

  public static final class UserAddRequestInput extends Model {
    public UserAddRequestInput() {}

    /** Email of the user to add */
    @JsonProperty(value = "email", required = true)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    public UserAddRequestInput withEmail(String value) {
      this.email = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UserAddRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    /**
     * Groups to assign when the invitation is accepted. Each reference is validated in the caller
     * organization before the invitation is created.
     */
    @JsonProperty(value = "groups", required = false)
    private List<String> groups;

    @JsonProperty("groups")
    public List<String> getGroups() {
      return groups;
    }

    public UserAddRequestInput withGroups(List<String> value) {
      this.groups = value;
      return this;
    }
  }

  public static final class UserAddResponse extends Model {
    public UserAddResponse() {}

    @JsonProperty(value = "invitation", required = true)
    private Invitation invitation;

    @JsonProperty("invitation")
    public Invitation getInvitation() {
      return invitation;
    }

    /**
     * Always `invited` — adding a user always goes through an invitation the invitee has to accept,
     * whether or not they already have a platform account.
     */
    @JsonProperty(value = "status", required = true)
    private UserAddResponseStatus status;

    @JsonProperty("status")
    public UserAddResponseStatus getStatus() {
      return status;
    }
  }

  public static final class Invitation extends Model {
    public Invitation() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Email address of the invited user */
    @JsonProperty(value = "email", required = false)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    /** Groups the user will be added to upon accepting */
    @JsonProperty(value = "groups", required = false)
    private List<GroupSummary> groups;

    @JsonProperty("groups")
    public List<GroupSummary> getGroups() {
      return groups;
    }

    @JsonProperty(value = "invited_by", required = false)
    private InvitationInvitedBy invited_by;

    @JsonProperty("invited_by")
    public InvitationInvitedBy getInvitedBy() {
      return invited_by;
    }

    @JsonProperty(value = "status", required = false)
    private InvitationStatus status;

    @JsonProperty("status")
    public InvitationStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "expires_at", required = false)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }
  }

  public static final class GroupSummary extends Model {
    public GroupSummary() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
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
  }

  public static final class InvitationInvitedBy extends Model {
    public InvitationInvitedBy() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /** Human inviter email; omitted for machine identities. */
    @JsonProperty(value = "email", required = false)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    /** Actual actor type. Assumed-role invitations record the session UUID in id. */
    @JsonProperty(value = "type", required = false)
    private InvitationInvitedByType type;

    @JsonProperty("type")
    public InvitationInvitedByType getType() {
      return type;
    }

    /**
     * Canonical Workspace user CRN or account IAM service-account/session CRN captured when
     * invited.
     */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Owning account for a service-account or assumed-role inviter; omitted for a human inviter.
     */
    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }
  }

  public static final class InvitationInvitedByType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InvitationInvitedByType(String value) {
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
      return other instanceof InvitationInvitedByType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InvitationInvitedByType USER = new InvitationInvitedByType("user");
    public static final InvitationInvitedByType SERVICE_ACCOUNT =
        new InvitationInvitedByType("service_account");
    public static final InvitationInvitedByType ASSUMED_ROLE =
        new InvitationInvitedByType("assumed_role");
  }

  public static final class InvitationStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InvitationStatus(String value) {
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
      return other instanceof InvitationStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InvitationStatus PENDING = new InvitationStatus("pending");
    public static final InvitationStatus ACCEPTED = new InvitationStatus("accepted");
    public static final InvitationStatus EXPIRED = new InvitationStatus("expired");
    public static final InvitationStatus CANCELLED = new InvitationStatus("cancelled");
  }

  public static final class UserAddResponseStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UserAddResponseStatus(String value) {
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
      return other instanceof UserAddResponseStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final UserAddResponseStatus INVITED = new UserAddResponseStatus("invited");
  }

  public static final class UserGroupAddRequestInput extends Model {
    public UserGroupAddRequestInput() {}

    @JsonProperty(value = "group", required = true)
    private String group;

    @JsonProperty("group")
    public String getGroup() {
      return group;
    }

    public UserGroupAddRequestInput withGroup(String value) {
      this.group = value;
      return this;
    }
  }

  public static final class AccountRoleAssignmentCreateRequestInput extends Model {
    public AccountRoleAssignmentCreateRequestInput() {}

    @JsonProperty(value = "principal_type", required = true)
    private AccountRoleAssignmentCreateRequestInputPrincipalType principal_type;

    @JsonProperty("principal_type")
    public AccountRoleAssignmentCreateRequestInputPrincipalType getPrincipalType() {
      return principal_type;
    }

    public AccountRoleAssignmentCreateRequestInput withPrincipalType(
        AccountRoleAssignmentCreateRequestInputPrincipalType value) {
      this.principal_type = value;
      return this;
    }

    /** Immutable UUID of a user or users-only group in this organization. */
    @JsonProperty(value = "principal_id", required = true)
    private String principal_id;

    @JsonProperty("principal_id")
    public String getPrincipalId() {
      return principal_id;
    }

    public AccountRoleAssignmentCreateRequestInput withPrincipalId(String value) {
      this.principal_id = value;
      return this;
    }

    /** Immutable UUID of a role owned by the target account. */
    @JsonProperty(value = "role_id", required = true)
    private String role_id;

    @JsonProperty("role_id")
    public String getRoleId() {
      return role_id;
    }

    public AccountRoleAssignmentCreateRequestInput withRoleId(String value) {
      this.role_id = value;
      return this;
    }
  }

  public static final class AccountRoleAssignmentCreateRequestInputPrincipalType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AccountRoleAssignmentCreateRequestInputPrincipalType(String value) {
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
      return other instanceof AccountRoleAssignmentCreateRequestInputPrincipalType v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AccountRoleAssignmentCreateRequestInputPrincipalType USER =
        new AccountRoleAssignmentCreateRequestInputPrincipalType("user");
    public static final AccountRoleAssignmentCreateRequestInputPrincipalType GROUP =
        new AccountRoleAssignmentCreateRequestInputPrincipalType("group");
  }

  public static final class AccountRoleAssignmentResponse extends Model {
    public AccountRoleAssignmentResponse() {}

    @JsonProperty(value = "role_assignment", required = false)
    private AccountRoleAssignment role_assignment;

    @JsonProperty("role_assignment")
    public AccountRoleAssignment getRoleAssignment() {
      return role_assignment;
    }
  }

  public static final class AccountRoleAssignment extends Model {
    public AccountRoleAssignment() {}

    /** Organization-qualified identity of this assignment in its target account. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }

    @JsonProperty(value = "role_id", required = false)
    private String role_id;

    @JsonProperty("role_id")
    public String getRoleId() {
      return role_id;
    }

    @JsonProperty(value = "role_name", required = false)
    private String role_name;

    @JsonProperty("role_name")
    public String getRoleName() {
      return role_name;
    }

    @JsonProperty(value = "principal_type", required = false)
    private AccountRoleAssignmentPrincipalType principal_type;

    @JsonProperty("principal_type")
    public AccountRoleAssignmentPrincipalType getPrincipalType() {
      return principal_type;
    }

    @JsonProperty(value = "principal_id", required = false)
    private String principal_id;

    @JsonProperty("principal_id")
    public String getPrincipalId() {
      return principal_id;
    }

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class AccountRoleAssignmentPrincipalType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AccountRoleAssignmentPrincipalType(String value) {
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
      return other instanceof AccountRoleAssignmentPrincipalType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AccountRoleAssignmentPrincipalType USER =
        new AccountRoleAssignmentPrincipalType("user");
    public static final AccountRoleAssignmentPrincipalType GROUP =
        new AccountRoleAssignmentPrincipalType("group");
  }

  public static final class PolicyAttachRequestInput extends Model {
    public PolicyAttachRequestInput() {}

    @JsonProperty(value = "policy", required = true)
    private String policy;

    @JsonProperty("policy")
    public String getPolicy() {
      return policy;
    }

    public PolicyAttachRequestInput withPolicy(String value) {
      this.policy = value;
      return this;
    }
  }

  public static final class OrganizationPolicyAttachRequestInput extends Model {
    public OrganizationPolicyAttachRequestInput() {}

    /** Immutable UUID of the organization policy to attach. */
    @JsonProperty(value = "policy_id", required = true)
    private String policy_id;

    @JsonProperty("policy_id")
    public String getPolicyId() {
      return policy_id;
    }

    public OrganizationPolicyAttachRequestInput withPolicyId(String value) {
      this.policy_id = value;
      return this;
    }
  }

  public static final class CreateAccountRequestInput extends Model {
    public CreateAccountRequestInput() {}

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CreateAccountRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "handle", required = true)
    private String handle;

    @JsonProperty("handle")
    public String getHandle() {
      return handle;
    }

    public CreateAccountRequestInput withHandle(String value) {
      this.handle = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public CreateAccountRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }
  }

  public static final class AccountResponse extends Model {
    public AccountResponse() {}

    @JsonProperty(value = "account", required = false)
    private Account account;

    @JsonProperty("account")
    public Account getAccount() {
      return account;
    }
  }

  public static final class Account extends Model {
    public Account() {}

    /** Internal UUID. Used for joins; the handle is the public identifier. */
    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "organization_id", required = false)
    private String organization_id;

    @JsonProperty("organization_id")
    public String getOrganizationId() {
      return organization_id;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /**
     * Globally-unique, immutable handle (URL-safe identifier). Sent as X-Account-Id on every
     * request that needs account context and embedded in CRNs.
     */
    @JsonProperty(value = "handle", required = false)
    private String handle;

    @JsonProperty("handle")
    public String getHandle() {
      return handle;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "status", required = false)
    private AccountStatus status;

    @JsonProperty("status")
    public AccountStatus getStatus() {
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

    /** Canonical Workspace resource identity. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Returned on creation. Immutable ID of the AccountAdministrator role trusted only to the
     * account creator.
     */
    @JsonProperty(value = "bootstrap_role_id", required = false)
    private String bootstrap_role_id;

    @JsonProperty("bootstrap_role_id")
    public String getBootstrapRoleId() {
      return bootstrap_role_id;
    }

    /**
     * Returned on creation. Assume this role to administer the new account; source AssumeRole
     * permission is still required.
     */
    @JsonProperty(value = "bootstrap_role_crn", required = false)
    private String bootstrap_role_crn;

    @JsonProperty("bootstrap_role_crn")
    public String getBootstrapRoleCrn() {
      return bootstrap_role_crn;
    }
  }

  public static final class AccountStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AccountStatus(String value) {
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
      return other instanceof AccountStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final AccountStatus ACTIVE = new AccountStatus("active");
    public static final AccountStatus SUSPENDED = new AccountStatus("suspended");
    public static final AccountStatus DELETED = new AccountStatus("deleted");
  }

  public static final class GroupCreateRequestInput extends Model {
    public GroupCreateRequestInput() {}

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

    public GroupCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public GroupCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }
  }

  public static final class CreateGroupResponse extends Model {
    public CreateGroupResponse() {}

    @JsonProperty(value = "group", required = false)
    private Group group;

    @JsonProperty("group")
    public Group getGroup() {
      return group;
    }
  }

  public static final class Group extends Model {
    public Group() {}

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

  public static final class PolicyCreateRequestInput extends Model {
    public PolicyCreateRequestInput() {}

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

    public PolicyCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public PolicyCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public PolicyCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "document", required = true)
    private PolicyDocumentInput document;

    @JsonProperty("document")
    public PolicyDocumentInput getDocument() {
      return document;
    }

    public PolicyCreateRequestInput withDocument(PolicyDocumentInput value) {
      this.document = value;
      return this;
    }
  }

  public static final class PolicyDocumentInput extends Model {
    public PolicyDocumentInput() {}

    @JsonProperty(value = "version", required = true)
    private PolicyDocumentInputVersion version;

    @JsonProperty("version")
    public PolicyDocumentInputVersion getVersion() {
      return version;
    }

    public PolicyDocumentInput withVersion(PolicyDocumentInputVersion value) {
      this.version = value;
      return this;
    }

    @JsonProperty(value = "statements", required = true)
    private List<PolicyStatementInput> statements;

    @JsonProperty("statements")
    public List<PolicyStatementInput> getStatements() {
      return statements;
    }

    public PolicyDocumentInput withStatements(List<PolicyStatementInput> value) {
      this.statements = value;
      return this;
    }
  }

  public static final class PolicyDocumentInputVersion {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyDocumentInputVersion(String value) {
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
      return other instanceof PolicyDocumentInputVersion v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyDocumentInputVersion VALUE20240101 =
        new PolicyDocumentInputVersion("2024-01-01");
  }

  public static final class PolicyStatementInput extends Model {
    public PolicyStatementInput() {}

    /** Statement identifier */
    @JsonProperty(value = "sid", required = false)
    private String sid;

    @JsonProperty("sid")
    public String getSid() {
      return sid;
    }

    public PolicyStatementInput withSid(String value) {
      this.sid = value;
      return this;
    }

    @JsonProperty(value = "effect", required = true)
    private PolicyStatementInputEffect effect;

    @JsonProperty("effect")
    public PolicyStatementInputEffect getEffect() {
      return effect;
    }

    public PolicyStatementInput withEffect(PolicyStatementInputEffect value) {
      this.effect = value;
      return this;
    }

    /** Actions in service:action format */
    @JsonProperty(value = "actions", required = false)
    private List<String> actions;

    @JsonProperty("actions")
    public List<String> getActions() {
      return actions;
    }

    public PolicyStatementInput withActions(List<String> value) {
      this.actions = value;
      return this;
    }

    /**
     * The statement covers every action *except* these. Pairs naturally with `effect: deny` to
     * carve a hole out of a broad allow; with `effect: allow` it grants everything the listed
     * patterns don't name, including actions added by future services.
     */
    @JsonProperty(value = "not_actions", required = false)
    private List<String> not_actions;

    @JsonProperty("not_actions")
    public List<String> getNotActions() {
      return not_actions;
    }

    public PolicyStatementInput withNotActions(List<String> value) {
      this.not_actions = value;
      return this;
    }

    /** Resource identifiers or patterns */
    @JsonProperty(value = "resources", required = false)
    private List<String> resources;

    @JsonProperty("resources")
    public List<String> getResources() {
      return resources;
    }

    public PolicyStatementInput withResources(List<String> value) {
      this.resources = value;
      return this;
    }

    /**
     * The statement covers every resource *except* these. Same trade-off as `not_actions`: with
     * `effect: allow` it reaches resources that do not exist yet.
     */
    @JsonProperty(value = "not_resources", required = false)
    private List<String> not_resources;

    @JsonProperty("not_resources")
    public List<String> getNotResources() {
      return not_resources;
    }

    public PolicyStatementInput withNotResources(List<String> value) {
      this.not_resources = value;
      return this;
    }

    /** Optional conditions for the statement */
    @JsonProperty(value = "conditions", required = false)
    private List<PolicyConditionInput> conditions;

    @JsonProperty("conditions")
    public List<PolicyConditionInput> getConditions() {
      return conditions;
    }

    public PolicyStatementInput withConditions(List<PolicyConditionInput> value) {
      this.conditions = value;
      return this;
    }
  }

  public static final class PolicyStatementInputEffect {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyStatementInputEffect(String value) {
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
      return other instanceof PolicyStatementInputEffect v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyStatementInputEffect ALLOW = new PolicyStatementInputEffect("allow");
    public static final PolicyStatementInputEffect DENY = new PolicyStatementInputEffect("deny");
  }

  public static final class PolicyConditionInput extends Model {
    public PolicyConditionInput() {}

    /** The comparison operator */
    @JsonProperty(value = "operator", required = true)
    private PolicyConditionInputOperator operator;

    @JsonProperty("operator")
    public PolicyConditionInputOperator getOperator() {
      return operator;
    }

    public PolicyConditionInput withOperator(PolicyConditionInputOperator value) {
      this.operator = value;
      return this;
    }

    /** The condition key to evaluate */
    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    public PolicyConditionInput withKey(String value) {
      this.key = value;
      return this;
    }

    /** Values to compare against */
    @JsonProperty(value = "values", required = true)
    private List<String> values;

    @JsonProperty("values")
    public List<String> getValues() {
      return values;
    }

    public PolicyConditionInput withValues(List<String> value) {
      this.values = value;
      return this;
    }

    /**
     * Evaluates `operator` against a multi-valued context key (a set, such as `basalt:TagKeys` —
     * the tag keys a request carries) rather than a single value. Omit for an ordinary
     * single-valued condition. - `for_all_values` — holds when every member of the request set
     * satisfies `operator`. An absent or empty set holds vacuously, so a request carrying no tags
     * is not fenced by a tag-key restriction. - `for_any_value` — holds when at least one member
     * does. An absent or empty set does not hold.
     */
    @JsonProperty(value = "set_operator", required = false)
    private PolicyConditionInputSetOperator set_operator;

    @JsonProperty("set_operator")
    public PolicyConditionInputSetOperator getSetOperator() {
      return set_operator;
    }

    public PolicyConditionInput withSetOperator(PolicyConditionInputSetOperator value) {
      this.set_operator = value;
      return this;
    }
  }

  public static final class PolicyConditionInputOperator {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyConditionInputOperator(String value) {
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
      return other instanceof PolicyConditionInputOperator v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyConditionInputOperator EQUALS =
        new PolicyConditionInputOperator("equals");
    public static final PolicyConditionInputOperator NOT_EQUALS =
        new PolicyConditionInputOperator("not_equals");
    public static final PolicyConditionInputOperator STARTS_WITH =
        new PolicyConditionInputOperator("starts_with");
    public static final PolicyConditionInputOperator ENDS_WITH =
        new PolicyConditionInputOperator("ends_with");
    public static final PolicyConditionInputOperator CONTAINS =
        new PolicyConditionInputOperator("contains");
    public static final PolicyConditionInputOperator IN = new PolicyConditionInputOperator("in");
    public static final PolicyConditionInputOperator NOT_IN =
        new PolicyConditionInputOperator("not_in");
    public static final PolicyConditionInputOperator GREATER_THAN =
        new PolicyConditionInputOperator("greater_than");
    public static final PolicyConditionInputOperator LESS_THAN =
        new PolicyConditionInputOperator("less_than");
    public static final PolicyConditionInputOperator GREATER_THAN_OR_EQUALS =
        new PolicyConditionInputOperator("greater_than_or_equals");
    public static final PolicyConditionInputOperator LESS_THAN_OR_EQUALS =
        new PolicyConditionInputOperator("less_than_or_equals");
    public static final PolicyConditionInputOperator EXISTS =
        new PolicyConditionInputOperator("exists");
    public static final PolicyConditionInputOperator NOT_EXISTS =
        new PolicyConditionInputOperator("not_exists");
    public static final PolicyConditionInputOperator IP_ADDRESS =
        new PolicyConditionInputOperator("ip_address");
    public static final PolicyConditionInputOperator NOT_IP_ADDRESS =
        new PolicyConditionInputOperator("not_ip_address");
  }

  public static final class PolicyConditionInputSetOperator {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyConditionInputSetOperator(String value) {
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
      return other instanceof PolicyConditionInputSetOperator v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyConditionInputSetOperator FOR_ALL_VALUES =
        new PolicyConditionInputSetOperator("for_all_values");
    public static final PolicyConditionInputSetOperator FOR_ANY_VALUE =
        new PolicyConditionInputSetOperator("for_any_value");
  }

  public static final class CreatePolicyResponse extends Model {
    public CreatePolicyResponse() {}

    @JsonProperty(value = "policy", required = false)
    private Policy policy;

    @JsonProperty("policy")
    public Policy getPolicy() {
      return policy;
    }
  }

  public static final class Policy extends Model {
    public Policy() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Managed policy CRN; absent on inline policy projections in effective-policy lists. */
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

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    /** Whether this is a system-managed policy (cannot be modified or deleted) */
    @JsonProperty(value = "is_system", required = false)
    private Boolean is_system;

    @JsonProperty("is_system")
    public Boolean getIsSystem() {
      return is_system;
    }

    @JsonProperty(value = "document", required = false)
    private PolicyDocument document;

    @JsonProperty("document")
    public PolicyDocument getDocument() {
      return document;
    }

    /** Creation timestamp (not present for system policies) */
    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    /** Last update timestamp (not present for system policies) */
    @JsonProperty(value = "updated_at", required = false)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class PolicyDocument extends Model {
    public PolicyDocument() {}

    @JsonProperty(value = "version", required = true)
    private PolicyDocumentVersion version;

    @JsonProperty("version")
    public PolicyDocumentVersion getVersion() {
      return version;
    }

    @JsonProperty(value = "statements", required = true)
    private List<PolicyStatement> statements;

    @JsonProperty("statements")
    public List<PolicyStatement> getStatements() {
      return statements;
    }
  }

  public static final class PolicyDocumentVersion {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyDocumentVersion(String value) {
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
      return other instanceof PolicyDocumentVersion v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyDocumentVersion VALUE20240101 =
        new PolicyDocumentVersion("2024-01-01");
  }

  public static final class PolicyStatement extends Model {
    public PolicyStatement() {}

    /** Statement identifier */
    @JsonProperty(value = "sid", required = false)
    private String sid;

    @JsonProperty("sid")
    public String getSid() {
      return sid;
    }

    @JsonProperty(value = "effect", required = true)
    private PolicyStatementEffect effect;

    @JsonProperty("effect")
    public PolicyStatementEffect getEffect() {
      return effect;
    }

    /** Actions in service:action format */
    @JsonProperty(value = "actions", required = false)
    private List<String> actions;

    @JsonProperty("actions")
    public List<String> getActions() {
      return actions;
    }

    /**
     * The statement covers every action *except* these. Pairs naturally with `effect: deny` to
     * carve a hole out of a broad allow; with `effect: allow` it grants everything the listed
     * patterns don't name, including actions added by future services.
     */
    @JsonProperty(value = "not_actions", required = false)
    private List<String> not_actions;

    @JsonProperty("not_actions")
    public List<String> getNotActions() {
      return not_actions;
    }

    /** Resource identifiers or patterns */
    @JsonProperty(value = "resources", required = false)
    private List<String> resources;

    @JsonProperty("resources")
    public List<String> getResources() {
      return resources;
    }

    /**
     * The statement covers every resource *except* these. Same trade-off as `not_actions`: with
     * `effect: allow` it reaches resources that do not exist yet.
     */
    @JsonProperty(value = "not_resources", required = false)
    private List<String> not_resources;

    @JsonProperty("not_resources")
    public List<String> getNotResources() {
      return not_resources;
    }

    /** Optional conditions for the statement */
    @JsonProperty(value = "conditions", required = false)
    private List<PolicyCondition> conditions;

    @JsonProperty("conditions")
    public List<PolicyCondition> getConditions() {
      return conditions;
    }
  }

  public static final class PolicyStatementEffect {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyStatementEffect(String value) {
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
      return other instanceof PolicyStatementEffect v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyStatementEffect ALLOW = new PolicyStatementEffect("allow");
    public static final PolicyStatementEffect DENY = new PolicyStatementEffect("deny");
  }

  public static final class PolicyCondition extends Model {
    public PolicyCondition() {}

    /** The comparison operator */
    @JsonProperty(value = "operator", required = true)
    private PolicyConditionOperator operator;

    @JsonProperty("operator")
    public PolicyConditionOperator getOperator() {
      return operator;
    }

    /** The condition key to evaluate */
    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    /** Values to compare against */
    @JsonProperty(value = "values", required = true)
    private List<String> values;

    @JsonProperty("values")
    public List<String> getValues() {
      return values;
    }

    /**
     * Evaluates `operator` against a multi-valued context key (a set, such as `basalt:TagKeys` —
     * the tag keys a request carries) rather than a single value. Omit for an ordinary
     * single-valued condition. - `for_all_values` — holds when every member of the request set
     * satisfies `operator`. An absent or empty set holds vacuously, so a request carrying no tags
     * is not fenced by a tag-key restriction. - `for_any_value` — holds when at least one member
     * does. An absent or empty set does not hold.
     */
    @JsonProperty(value = "set_operator", required = false)
    private PolicyConditionSetOperator set_operator;

    @JsonProperty("set_operator")
    public PolicyConditionSetOperator getSetOperator() {
      return set_operator;
    }
  }

  public static final class PolicyConditionOperator {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyConditionOperator(String value) {
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
      return other instanceof PolicyConditionOperator v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyConditionOperator EQUALS = new PolicyConditionOperator("equals");
    public static final PolicyConditionOperator NOT_EQUALS =
        new PolicyConditionOperator("not_equals");
    public static final PolicyConditionOperator STARTS_WITH =
        new PolicyConditionOperator("starts_with");
    public static final PolicyConditionOperator ENDS_WITH =
        new PolicyConditionOperator("ends_with");
    public static final PolicyConditionOperator CONTAINS = new PolicyConditionOperator("contains");
    public static final PolicyConditionOperator IN = new PolicyConditionOperator("in");
    public static final PolicyConditionOperator NOT_IN = new PolicyConditionOperator("not_in");
    public static final PolicyConditionOperator GREATER_THAN =
        new PolicyConditionOperator("greater_than");
    public static final PolicyConditionOperator LESS_THAN =
        new PolicyConditionOperator("less_than");
    public static final PolicyConditionOperator GREATER_THAN_OR_EQUALS =
        new PolicyConditionOperator("greater_than_or_equals");
    public static final PolicyConditionOperator LESS_THAN_OR_EQUALS =
        new PolicyConditionOperator("less_than_or_equals");
    public static final PolicyConditionOperator EXISTS = new PolicyConditionOperator("exists");
    public static final PolicyConditionOperator NOT_EXISTS =
        new PolicyConditionOperator("not_exists");
    public static final PolicyConditionOperator IP_ADDRESS =
        new PolicyConditionOperator("ip_address");
    public static final PolicyConditionOperator NOT_IP_ADDRESS =
        new PolicyConditionOperator("not_ip_address");
  }

  public static final class PolicyConditionSetOperator {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PolicyConditionSetOperator(String value) {
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
      return other instanceof PolicyConditionSetOperator v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PolicyConditionSetOperator FOR_ALL_VALUES =
        new PolicyConditionSetOperator("for_all_values");
    public static final PolicyConditionSetOperator FOR_ANY_VALUE =
        new PolicyConditionSetOperator("for_any_value");
  }

  public static final class GetAccountScope extends Model {
    public GetAccountScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetAccountScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetAccountResourcesResponse extends Model {
    public GetAccountResourcesResponse() {}

    @JsonProperty(value = "has_resources", required = true)
    private Boolean has_resources;

    @JsonProperty("has_resources")
    public Boolean getHasResources() {
      return has_resources;
    }
  }

  public static final class GetGroupResponse extends Model {
    public GetGroupResponse() {}

    @JsonProperty(value = "group", required = false)
    private Group group;

    @JsonProperty("group")
    public Group getGroup() {
      return group;
    }
  }

  public static final class GetGroupScope extends Model {
    public GetGroupScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetGroupScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class InlinePolicyResponse extends Model {
    public InlinePolicyResponse() {}

    @JsonProperty(value = "inline_policy", required = false)
    private InlinePolicy inline_policy;

    @JsonProperty("inline_policy")
    public InlinePolicy getInlinePolicy() {
      return inline_policy;
    }
  }

  public static final class InlinePolicy extends Model {
    public InlinePolicy() {}

    /**
     * Canonical principal-scoped inline policy identity; named principals use their immutable name,
     * users use UUID.
     */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "principal_id", required = false)
    private String principal_id;

    @JsonProperty("principal_id")
    public String getPrincipalId() {
      return principal_id;
    }

    @JsonProperty(value = "principal_type", required = false)
    private InlinePolicyPrincipalType principal_type;

    @JsonProperty("principal_type")
    public InlinePolicyPrincipalType getPrincipalType() {
      return principal_type;
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

    @JsonProperty(value = "document", required = false)
    private PolicyDocument document;

    @JsonProperty("document")
    public PolicyDocument getDocument() {
      return document;
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

  public static final class InlinePolicyPrincipalType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InlinePolicyPrincipalType(String value) {
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
      return other instanceof InlinePolicyPrincipalType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InlinePolicyPrincipalType USER = new InlinePolicyPrincipalType("user");
    public static final InlinePolicyPrincipalType GROUP = new InlinePolicyPrincipalType("group");
  }

  public static final class GetGroupInlinePolicyScope extends Model {
    public GetGroupInlinePolicyScope() {}
  }

  public static final class GetInvitationResponse extends Model {
    public GetInvitationResponse() {}

    @JsonProperty(value = "invitation", required = false)
    private Invitation invitation;

    @JsonProperty("invitation")
    public Invitation getInvitation() {
      return invitation;
    }
  }

  public static final class GetInvitationScope extends Model {
    public GetInvitationScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetInvitationScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class OrganizationResponse extends Model {
    public OrganizationResponse() {}

    @JsonProperty(value = "organization", required = false)
    private Organization organization;

    @JsonProperty("organization")
    public Organization getOrganization() {
      return organization;
    }
  }

  public static final class Organization extends Model {
    public Organization() {}

    /**
     * Language for organization billing and operational emails, independent of each user's console
     * preference.
     */
    @JsonProperty(value = "language", required = false)
    private OrganizationLanguage language;

    @JsonProperty("language")
    public OrganizationLanguage getLanguage() {
      return language;
    }

    /**
     * IANA timezone for formatting organization emails. Does not change billing periods or resource
     * schedules.
     */
    @JsonProperty(value = "time_zone", required = false)
    private String time_zone;

    @JsonProperty("time_zone")
    public String getTimeZone() {
      return time_zone;
    }

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

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

    /** ID of the organization owner */
    @JsonProperty(value = "owner_id", required = false)
    private String owner_id;

    @JsonProperty("owner_id")
    public String getOwnerId() {
      return owner_id;
    }

    /**
     * Lifecycle state. A newly created organization is `pending` until its owner has verified a
     * phone number and attached a payment method; until then every resource API refuses it with
     * `ORGANIZATION_ONBOARDING_REQUIRED`. `suspended` is a billing or administrative hold, and
     * `terminated` is irreversible.
     */
    @JsonProperty(value = "status", required = false)
    private OrganizationStatus status;

    @JsonProperty("status")
    public OrganizationStatus getStatus() {
      return status;
    }

    /**
     * Why the organization is suspended; absent unless it is. The two are the same `status` but not
     * the same situation — a `billing` hold is one the customer can clear by settling their
     * account, and the platform still grants organization context for it so they can reach billing
     * to do so. A `manual` hold is an operator decision and grants nothing.
     */
    @JsonProperty(value = "suspension_reason", required = false)
    private OrganizationSuspensionReason suspension_reason;

    @JsonProperty("suspension_reason")
    public OrganizationSuspensionReason getSuspensionReason() {
      return suspension_reason;
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

    /** Canonical Workspace resource identity. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }
  }

  public static final class OrganizationLanguage {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OrganizationLanguage(String value) {
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
      return other instanceof OrganizationLanguage v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OrganizationLanguage EN = new OrganizationLanguage("en");
    public static final OrganizationLanguage PT_BR = new OrganizationLanguage("pt-BR");
    public static final OrganizationLanguage ES = new OrganizationLanguage("es");
  }

  public static final class OrganizationStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OrganizationStatus(String value) {
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
      return other instanceof OrganizationStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OrganizationStatus PENDING = new OrganizationStatus("pending");
    public static final OrganizationStatus ACTIVE = new OrganizationStatus("active");
    public static final OrganizationStatus SUSPENDED = new OrganizationStatus("suspended");
    public static final OrganizationStatus TERMINATED = new OrganizationStatus("terminated");
  }

  public static final class OrganizationSuspensionReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OrganizationSuspensionReason(String value) {
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
      return other instanceof OrganizationSuspensionReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OrganizationSuspensionReason BILLING =
        new OrganizationSuspensionReason("billing");
    public static final OrganizationSuspensionReason MANUAL =
        new OrganizationSuspensionReason("manual");
  }

  public static final class GetOrganizationScope extends Model {
    public GetOrganizationScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetOrganizationScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetPolicyResponse extends Model {
    public GetPolicyResponse() {}

    @JsonProperty(value = "policy", required = false)
    private Policy policy;

    @JsonProperty("policy")
    public Policy getPolicy() {
      return policy;
    }
  }

  public static final class GetPolicyScope extends Model {
    public GetPolicyScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetPolicyScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetUserResponse extends Model {
    public GetUserResponse() {}

    @JsonProperty(value = "user", required = false)
    private User user;

    @JsonProperty("user")
    public User getUser() {
      return user;
    }
  }

  public static final class User extends Model {
    public User() {}

    /**
     * Globally unique permanent login handle; empty until the user completes username selection.
     */
    @JsonProperty(value = "username", required = false)
    private String username;

    @JsonProperty("username")
    public String getUsername() {
      return username;
    }

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

    @JsonProperty(value = "email", required = false)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "linux_identity", required = false)
    private LinuxIdentity linux_identity;

    @JsonProperty("linux_identity")
    public LinuxIdentity getLinuxIdentity() {
      return linux_identity;
    }

    @JsonProperty(value = "added_at", required = false)
    private String added_at;

    @JsonProperty("added_at")
    public String getAddedAt() {
      return added_at;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }
  }

  public static final class LinuxIdentity extends Model {
    public LinuxIdentity() {}

    /**
     * Home directory derived from the permanent username, as /home/&lt;username&gt;. Numeric file
     * ownership is defined by UID and GID.
     */
    @JsonProperty(value = "home_directory", required = true)
    private String home_directory;

    @JsonProperty("home_directory")
    public String getHomeDirectory() {
      return home_directory;
    }

    @JsonProperty(value = "username", required = true)
    private String username;

    @JsonProperty("username")
    public String getUsername() {
      return username;
    }

    @JsonProperty(value = "uid", required = true)
    private Long uid;

    @JsonProperty("uid")
    public Long getUid() {
      return uid;
    }

    @JsonProperty(value = "gid", required = true)
    private Long gid;

    @JsonProperty("gid")
    public Long getGid() {
      return gid;
    }
  }

  public static final class GetUserScope extends Model {
    public GetUserScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetUserScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetUserInlinePolicyScope extends Model {
    public GetUserInlinePolicyScope() {}
  }

  public static final class PermissionBoundaryResponse extends Model {
    public PermissionBoundaryResponse() {}

    @JsonProperty(value = "permission_boundary", required = false)
    private PermissionBoundary permission_boundary;

    @JsonProperty("permission_boundary")
    public PermissionBoundary getPermissionBoundary() {
      return permission_boundary;
    }
  }

  public static final class PermissionBoundary extends Model {
    public PermissionBoundary() {}

    @JsonProperty(value = "principal_id", required = false)
    private String principal_id;

    @JsonProperty("principal_id")
    public String getPrincipalId() {
      return principal_id;
    }

    @JsonProperty(value = "principal_type", required = false)
    private PermissionBoundaryPrincipalType principal_type;

    @JsonProperty("principal_type")
    public PermissionBoundaryPrincipalType getPrincipalType() {
      return principal_type;
    }

    @JsonProperty(value = "policy_id", required = false)
    private String policy_id;

    @JsonProperty("policy_id")
    public String getPolicyId() {
      return policy_id;
    }

    @JsonProperty(value = "policy_name", required = false)
    private String policy_name;

    @JsonProperty("policy_name")
    public String getPolicyName() {
      return policy_name;
    }

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class PermissionBoundaryPrincipalType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PermissionBoundaryPrincipalType(String value) {
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
      return other instanceof PermissionBoundaryPrincipalType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PermissionBoundaryPrincipalType USER =
        new PermissionBoundaryPrincipalType("user");
  }

  public static final class AccountRoleAssignmentListResponse extends Model {
    public AccountRoleAssignmentListResponse() {}

    @JsonProperty(value = "role_assignments", required = false)
    private List<AccountRoleAssignment> role_assignments;

    @JsonProperty("role_assignments")
    public List<AccountRoleAssignment> getRoleAssignments() {
      return role_assignments;
    }
  }

  public static final class AccountRoleListResponse extends Model {
    public AccountRoleListResponse() {}

    @JsonProperty(value = "account_roles", required = false)
    private List<AccountRole> account_roles;

    @JsonProperty("account_roles")
    public List<AccountRole> getAccountRoles() {
      return account_roles;
    }
  }

  public static final class AccountRole extends Model {
    public AccountRole() {}

    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }

    @JsonProperty(value = "account_handle", required = false)
    private String account_handle;

    @JsonProperty("account_handle")
    public String getAccountHandle() {
      return account_handle;
    }

    @JsonProperty(value = "account_name", required = false)
    private String account_name;

    @JsonProperty("account_name")
    public String getAccountName() {
      return account_name;
    }

    @JsonProperty(value = "role_id", required = false)
    private String role_id;

    @JsonProperty("role_id")
    public String getRoleId() {
      return role_id;
    }

    @JsonProperty(value = "role_name", required = false)
    private String role_name;

    @JsonProperty("role_name")
    public String getRoleName() {
      return role_name;
    }

    @JsonProperty(value = "role_crn", required = false)
    private String role_crn;

    @JsonProperty("role_crn")
    public String getRoleCrn() {
      return role_crn;
    }
  }

  public static final class ListAccountsQuery extends Model {
    public ListAccountsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListAccountsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListAccountsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListAccountsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListAccountsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class AccountListResponse extends Model {
    public AccountListResponse() {}

    @JsonProperty(value = "accounts", required = false)
    private List<Account> accounts;

    @JsonProperty("accounts")
    public List<Account> getAccounts() {
      return accounts;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
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

  public static final class ListGroupInlinePoliciesQuery extends Model {
    public ListGroupInlinePoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListGroupInlinePoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListGroupInlinePoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class InlinePolicyListResponse extends Model {
    public InlinePolicyListResponse() {}

    @JsonProperty(value = "inline_policies", required = false)
    private List<InlinePolicy> inline_policies;

    @JsonProperty("inline_policies")
    public List<InlinePolicy> getInlinePolicies() {
      return inline_policies;
    }
  }

  public static final class ListGroupPoliciesQuery extends Model {
    public ListGroupPoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListGroupPoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListGroupPoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class PrincipalPoliciesListResponse extends Model {
    public PrincipalPoliciesListResponse() {}

    @JsonProperty(value = "policies", required = false)
    private List<Policy> policies;

    @JsonProperty("policies")
    public List<Policy> getPolicies() {
      return policies;
    }
  }

  public static final class ListGroupUsersQuery extends Model {
    public ListGroupUsersQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListGroupUsersQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListGroupUsersQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListGroupUsersQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListGroupUsersQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class GroupUsersListResponse extends Model {
    public GroupUsersListResponse() {}

    @JsonProperty(value = "users", required = false)
    private List<GroupUser> users;

    @JsonProperty("users")
    public List<GroupUser> getUsers() {
      return users;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class GroupUser extends Model {
    public GroupUser() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** CRN of the user */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "email", required = false)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    /** Display name of the user */
    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "added_at", required = false)
    private String added_at;

    @JsonProperty("added_at")
    public String getAddedAt() {
      return added_at;
    }
  }

  public static final class ListGroupsQuery extends Model {
    public ListGroupsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListGroupsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListGroupsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListGroupsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListGroupsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class GroupListResponse extends Model {
    public GroupListResponse() {}

    @JsonProperty(value = "groups", required = false)
    private List<Group> groups;

    @JsonProperty("groups")
    public List<Group> getGroups() {
      return groups;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListInvitationsQuery extends Model {
    public ListInvitationsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListInvitationsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInvitationsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInvitationsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInvitationsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class InvitationListResponse extends Model {
    public InvitationListResponse() {}

    @JsonProperty(value = "invitations", required = false)
    private List<Invitation> invitations;

    @JsonProperty("invitations")
    public List<Invitation> getInvitations() {
      return invitations;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListOrganizationsQuery extends Model {
    public ListOrganizationsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListOrganizationsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListOrganizationsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListOrganizationsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListOrganizationsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class OrganizationListResponse extends Model {
    public OrganizationListResponse() {}

    @JsonProperty(value = "organizations", required = false)
    private List<OrganizationWithMembership> organizations;

    @JsonProperty("organizations")
    public List<OrganizationWithMembership> getOrganizations() {
      return organizations;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class OrganizationWithMembership extends Model {
    public OrganizationWithMembership() {}

    /**
     * Language for organization billing and operational emails, independent of each user's console
     * preference.
     */
    @JsonProperty(value = "language", required = false)
    private OrganizationWithMembershipLanguage language;

    @JsonProperty("language")
    public OrganizationWithMembershipLanguage getLanguage() {
      return language;
    }

    /**
     * IANA timezone for formatting organization emails. Does not change billing periods or resource
     * schedules.
     */
    @JsonProperty(value = "time_zone", required = false)
    private String time_zone;

    @JsonProperty("time_zone")
    public String getTimeZone() {
      return time_zone;
    }

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

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

    /** ID of the organization owner */
    @JsonProperty(value = "owner_id", required = false)
    private String owner_id;

    @JsonProperty("owner_id")
    public String getOwnerId() {
      return owner_id;
    }

    /**
     * Lifecycle state. A newly created organization is `pending` until its owner has verified a
     * phone number and attached a payment method; until then every resource API refuses it with
     * `ORGANIZATION_ONBOARDING_REQUIRED`. `suspended` is a billing or administrative hold, and
     * `terminated` is irreversible.
     */
    @JsonProperty(value = "status", required = false)
    private OrganizationWithMembershipStatus status;

    @JsonProperty("status")
    public OrganizationWithMembershipStatus getStatus() {
      return status;
    }

    /**
     * Why the organization is suspended; absent unless it is. The two are the same `status` but not
     * the same situation — a `billing` hold is one the customer can clear by settling their
     * account, and the platform still grants organization context for it so they can reach billing
     * to do so. A `manual` hold is an operator decision and grants nothing.
     */
    @JsonProperty(value = "suspension_reason", required = false)
    private OrganizationWithMembershipSuspensionReason suspension_reason;

    @JsonProperty("suspension_reason")
    public OrganizationWithMembershipSuspensionReason getSuspensionReason() {
      return suspension_reason;
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

    /** Canonical Workspace resource identity. */
    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }
  }

  public static final class OrganizationWithMembershipLanguage {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OrganizationWithMembershipLanguage(String value) {
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
      return other instanceof OrganizationWithMembershipLanguage v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OrganizationWithMembershipLanguage EN =
        new OrganizationWithMembershipLanguage("en");
    public static final OrganizationWithMembershipLanguage PT_BR =
        new OrganizationWithMembershipLanguage("pt-BR");
    public static final OrganizationWithMembershipLanguage ES =
        new OrganizationWithMembershipLanguage("es");
  }

  public static final class OrganizationWithMembershipStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OrganizationWithMembershipStatus(String value) {
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
      return other instanceof OrganizationWithMembershipStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OrganizationWithMembershipStatus PENDING =
        new OrganizationWithMembershipStatus("pending");
    public static final OrganizationWithMembershipStatus ACTIVE =
        new OrganizationWithMembershipStatus("active");
    public static final OrganizationWithMembershipStatus SUSPENDED =
        new OrganizationWithMembershipStatus("suspended");
    public static final OrganizationWithMembershipStatus TERMINATED =
        new OrganizationWithMembershipStatus("terminated");
  }

  public static final class OrganizationWithMembershipSuspensionReason {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OrganizationWithMembershipSuspensionReason(String value) {
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
      return other instanceof OrganizationWithMembershipSuspensionReason v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OrganizationWithMembershipSuspensionReason BILLING =
        new OrganizationWithMembershipSuspensionReason("billing");
    public static final OrganizationWithMembershipSuspensionReason MANUAL =
        new OrganizationWithMembershipSuspensionReason("manual");
  }

  public static final class ListPoliciesQuery extends Model {
    public ListPoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListPoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListPoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListPoliciesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListPoliciesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class PolicyListResponse extends Model {
    public PolicyListResponse() {}

    @JsonProperty(value = "policies", required = false)
    private List<Policy> policies;

    @JsonProperty("policies")
    public List<Policy> getPolicies() {
      return policies;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListPolicyGroupsQuery extends Model {
    public ListPolicyGroupsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListPolicyGroupsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListPolicyGroupsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListPolicyGroupsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListPolicyGroupsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class PolicyGroupsListResponse extends Model {
    public PolicyGroupsListResponse() {}

    @JsonProperty(value = "groups", required = false)
    private List<Group> groups;

    @JsonProperty("groups")
    public List<Group> getGroups() {
      return groups;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListPolicyRolesQuery extends Model {
    public ListPolicyRolesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListPolicyRolesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListPolicyRolesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListPolicyRolesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListPolicyRolesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class PolicyRolesListResponse extends Model {
    public PolicyRolesListResponse() {}

    @JsonProperty(value = "roles", required = false)
    private List<AccountPrincipalReference> roles;

    @JsonProperty("roles")
    public List<AccountPrincipalReference> getRoles() {
      return roles;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class AccountPrincipalReference extends Model {
    public AccountPrincipalReference() {}

    @JsonProperty(value = "id", required = false)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }

    @JsonProperty(value = "account_handle", required = false)
    private String account_handle;

    @JsonProperty("account_handle")
    public String getAccountHandle() {
      return account_handle;
    }
  }

  public static final class ListPolicyServiceAccountsQuery extends Model {
    public ListPolicyServiceAccountsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListPolicyServiceAccountsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListPolicyServiceAccountsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListPolicyServiceAccountsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListPolicyServiceAccountsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class PolicyServiceAccountsListResponse extends Model {
    public PolicyServiceAccountsListResponse() {}

    @JsonProperty(value = "service_accounts", required = false)
    private List<AccountPrincipalReference> service_accounts;

    @JsonProperty("service_accounts")
    public List<AccountPrincipalReference> getServiceAccounts() {
      return service_accounts;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListPolicyUsersQuery extends Model {
    public ListPolicyUsersQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListPolicyUsersQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListPolicyUsersQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListPolicyUsersQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListPolicyUsersQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class PolicyUsersListResponse extends Model {
    public PolicyUsersListResponse() {}

    @JsonProperty(value = "users", required = false)
    private List<User> users;

    @JsonProperty("users")
    public List<User> getUsers() {
      return users;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListRolePoliciesQuery extends Model {
    public ListRolePoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRolePoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRolePoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class RolePoliciesListResponse extends Model {
    public RolePoliciesListResponse() {}

    @JsonProperty(value = "policies", required = false)
    private List<Policy> policies;

    @JsonProperty("policies")
    public List<Policy> getPolicies() {
      return policies;
    }
  }

  public static final class ListServiceAccountPoliciesQuery extends Model {
    public ListServiceAccountPoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListServiceAccountPoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListServiceAccountPoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListUserGroupsQuery extends Model {
    public ListUserGroupsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListUserGroupsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListUserGroupsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListUserInlinePoliciesQuery extends Model {
    public ListUserInlinePoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListUserInlinePoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListUserInlinePoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListUserPoliciesQuery extends Model {
    public ListUserPoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListUserPoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListUserPoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class ListUsersQuery extends Model {
    public ListUsersQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListUsersQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListUsersQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListUsersQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListUsersQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class UserListResponse extends Model {
    public UserListResponse() {}

    @JsonProperty(value = "users", required = false)
    private List<User> users;

    @JsonProperty("users")
    public List<User> getUsers() {
      return users;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class PutInlinePolicyRequestInput extends Model {
    public PutInlinePolicyRequestInput() {}

    @JsonProperty(value = "document", required = true)
    private PolicyDocumentInput document;

    @JsonProperty("document")
    public PolicyDocumentInput getDocument() {
      return document;
    }

    public PutInlinePolicyRequestInput withDocument(PolicyDocumentInput value) {
      this.document = value;
      return this;
    }
  }

  public static final class SetBoundaryRequestInput extends Model {
    public SetBoundaryRequestInput() {}

    @JsonProperty(value = "policy", required = true)
    private String policy;

    @JsonProperty("policy")
    public String getPolicy() {
      return policy;
    }

    public SetBoundaryRequestInput withPolicy(String value) {
      this.policy = value;
      return this;
    }
  }

  public static final class UpdateAccountRequestInput extends Model {
    public UpdateAccountRequestInput() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public UpdateAccountRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public UpdateAccountRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }
  }

  public static final class GroupUpdateRequestInput extends Model {
    public GroupUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public GroupUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }
  }

  public static final class UpdateGroupResponse extends Model {
    public UpdateGroupResponse() {}

    @JsonProperty(value = "group", required = false)
    private Group group;

    @JsonProperty("group")
    public Group getGroup() {
      return group;
    }
  }

  public static final class OrganizationUpdateRequestInput extends Model {
    public OrganizationUpdateRequestInput() {}

    /**
     * Language for organization billing and operational emails, independent of each user's console
     * preference.
     */
    @JsonProperty(value = "language", required = false)
    private OrganizationUpdateRequestInputLanguage language;

    @JsonProperty("language")
    public OrganizationUpdateRequestInputLanguage getLanguage() {
      return language;
    }

    public OrganizationUpdateRequestInput withLanguage(
        OrganizationUpdateRequestInputLanguage value) {
      this.language = value;
      return this;
    }

    /**
     * IANA timezone for formatting organization emails. Does not change billing periods or resource
     * schedules.
     */
    @JsonProperty(value = "time_zone", required = false)
    private String time_zone;

    @JsonProperty("time_zone")
    public String getTimeZone() {
      return time_zone;
    }

    public OrganizationUpdateRequestInput withTimeZone(String value) {
      this.time_zone = value;
      return this;
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public OrganizationUpdateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public OrganizationUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /** Google reCAPTCHA token for bot protection */
    @JsonProperty(value = "captcha_token", required = true)
    private String captcha_token;

    @JsonProperty("captcha_token")
    public String getCaptchaToken() {
      return captcha_token;
    }

    public OrganizationUpdateRequestInput withCaptchaToken(String value) {
      this.captcha_token = value;
      return this;
    }
  }

  public static final class OrganizationUpdateRequestInputLanguage {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OrganizationUpdateRequestInputLanguage(String value) {
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
      return other instanceof OrganizationUpdateRequestInputLanguage v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OrganizationUpdateRequestInputLanguage EN =
        new OrganizationUpdateRequestInputLanguage("en");
    public static final OrganizationUpdateRequestInputLanguage PT_BR =
        new OrganizationUpdateRequestInputLanguage("pt-BR");
    public static final OrganizationUpdateRequestInputLanguage ES =
        new OrganizationUpdateRequestInputLanguage("es");
  }

  public static final class PolicyUpdateRequestInput extends Model {
    public PolicyUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public PolicyUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public PolicyUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "document", required = false)
    private PolicyDocumentInput document;

    @JsonProperty("document")
    public PolicyDocumentInput getDocument() {
      return document;
    }

    public PolicyUpdateRequestInput withDocument(PolicyDocumentInput value) {
      this.document = value;
      return this;
    }
  }

  public static final class UpdatePolicyResponse extends Model {
    public UpdatePolicyResponse() {}

    @JsonProperty(value = "policy", required = false)
    private Policy policy;

    @JsonProperty("policy")
    public Policy getPolicy() {
      return policy;
    }
  }
}
