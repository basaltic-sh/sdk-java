package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed iam wire models. Unknown string enum values are retained. */
public final class Iam {

  private Iam() {}

  public static final class AssumeRoleRequestInput extends Model {
    public AssumeRoleRequestInput() {}

    @JsonProperty(value = "role", required = true)
    private String role;

    @JsonProperty("role")
    public String getRole() {
      return role;
    }

    public AssumeRoleRequestInput withRole(String value) {
      this.role = value;
      return this;
    }

    /** Credential validity duration (15 min to 12 hours) */
    @JsonProperty(value = "duration_seconds", required = false)
    private Long duration_seconds;

    @JsonProperty("duration_seconds")
    public Long getDurationSeconds() {
      return duration_seconds;
    }

    public AssumeRoleRequestInput withDurationSeconds(Long value) {
      this.duration_seconds = value;
      return this;
    }

    @JsonProperty(value = "policy", required = false)
    private SessionPolicyDocumentInput policy;

    @JsonProperty("policy")
    public SessionPolicyDocumentInput getPolicy() {
      return policy;
    }

    public AssumeRoleRequestInput withPolicy(SessionPolicyDocumentInput value) {
      this.policy = value;
      return this;
    }
  }

  public static final class SessionPolicyDocumentInput extends Model {
    public SessionPolicyDocumentInput() {}

    @JsonProperty(value = "version", required = true)
    private SessionPolicyDocumentInputVersion version;

    @JsonProperty("version")
    public SessionPolicyDocumentInputVersion getVersion() {
      return version;
    }

    public SessionPolicyDocumentInput withVersion(SessionPolicyDocumentInputVersion value) {
      this.version = value;
      return this;
    }

    @JsonProperty(value = "statements", required = true)
    private List<SessionPolicyStatementInput> statements;

    @JsonProperty("statements")
    public List<SessionPolicyStatementInput> getStatements() {
      return statements;
    }

    public SessionPolicyDocumentInput withStatements(List<SessionPolicyStatementInput> value) {
      this.statements = value;
      return this;
    }
  }

  public static final class SessionPolicyDocumentInputVersion {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SessionPolicyDocumentInputVersion(String value) {
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
      return other instanceof SessionPolicyDocumentInputVersion v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SessionPolicyDocumentInputVersion VALUE20240101 =
        new SessionPolicyDocumentInputVersion("2024-01-01");
  }

  public static final class SessionPolicyStatementInput extends Model {
    public SessionPolicyStatementInput() {}

    /** Statement identifier */
    @JsonProperty(value = "sid", required = false)
    private String sid;

    @JsonProperty("sid")
    public String getSid() {
      return sid;
    }

    public SessionPolicyStatementInput withSid(String value) {
      this.sid = value;
      return this;
    }

    @JsonProperty(value = "effect", required = true)
    private SessionPolicyStatementInputEffect effect;

    @JsonProperty("effect")
    public SessionPolicyStatementInputEffect getEffect() {
      return effect;
    }

    public SessionPolicyStatementInput withEffect(SessionPolicyStatementInputEffect value) {
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

    public SessionPolicyStatementInput withActions(List<String> value) {
      this.actions = value;
      return this;
    }

    /** The statement covers every action except these */
    @JsonProperty(value = "not_actions", required = false)
    private List<String> not_actions;

    @JsonProperty("not_actions")
    public List<String> getNotActions() {
      return not_actions;
    }

    public SessionPolicyStatementInput withNotActions(List<String> value) {
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

    public SessionPolicyStatementInput withResources(List<String> value) {
      this.resources = value;
      return this;
    }

    /** The statement covers every resource except these */
    @JsonProperty(value = "not_resources", required = false)
    private List<String> not_resources;

    @JsonProperty("not_resources")
    public List<String> getNotResources() {
      return not_resources;
    }

    public SessionPolicyStatementInput withNotResources(List<String> value) {
      this.not_resources = value;
      return this;
    }
  }

  public static final class SessionPolicyStatementInputEffect {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public SessionPolicyStatementInputEffect(String value) {
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
      return other instanceof SessionPolicyStatementInputEffect v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final SessionPolicyStatementInputEffect ALLOW =
        new SessionPolicyStatementInputEffect("allow");
    public static final SessionPolicyStatementInputEffect DENY =
        new SessionPolicyStatementInputEffect("deny");
  }

  public static final class AssumeRoleResponse extends Model {
    public AssumeRoleResponse() {}

    /** Bearer token for the Basaltic API. Present on every role session. */
    @JsonProperty(value = "access_token", required = false)
    private String access_token;

    @JsonProperty("access_token")
    public String getAccessToken() {
      return access_token;
    }

    /** Always `Bearer` when `access_token` is present. */
    @JsonProperty(value = "token_type", required = false)
    private String token_type;

    @JsonProperty("token_type")
    public String getTokenType() {
      return token_type;
    }

    /** Seconds until `access_token` expires. */
    @JsonProperty(value = "expires_in", required = false)
    private Long expires_in;

    @JsonProperty("expires_in")
    public Long getExpiresIn() {
      return expires_in;
    }

    /** SigV4 access key id, for the S3 endpoint. */
    @JsonProperty(value = "access_key_id", required = false)
    private String access_key_id;

    @JsonProperty("access_key_id")
    public String getAccessKeyId() {
      return access_key_id;
    }

    /** SigV4 secret, for the S3 endpoint. */
    @JsonProperty(value = "secret_access_key", required = false)
    private String secret_access_key;

    @JsonProperty("secret_access_key")
    public String getSecretAccessKey() {
      return secret_access_key;
    }

    /**
     * SigV4 session token, for the S3 endpoint. Send as `X-Amz-Security-Token` and include it in
     * `SignedHeaders`.
     */
    @JsonProperty(value = "session_token", required = false)
    private String session_token;

    @JsonProperty("session_token")
    public String getSessionToken() {
      return session_token;
    }

    /** When the session — and therefore both credential forms — expires. */
    @JsonProperty(value = "expiration", required = false)
    private String expiration;

    @JsonProperty("expiration")
    public String getExpiration() {
      return expiration;
    }

    /** Owning account UUID of the target role. */
    @JsonProperty(value = "account_id", required = false)
    private String account_id;

    @JsonProperty("account_id")
    public String getAccountId() {
      return account_id;
    }

    /** Owning account handle of the target role. */
    @JsonProperty(value = "account_handle", required = false)
    private String account_handle;

    @JsonProperty("account_handle")
    public String getAccountHandle() {
      return account_handle;
    }

    /** Immutable UUID of the assumed role. */
    @JsonProperty(value = "role_id", required = false)
    private String role_id;

    @JsonProperty("role_id")
    public String getRoleId() {
      return role_id;
    }
  }

  public static final class AssumeRoleWithWebIdentityRequestInput extends Model {
    public AssumeRoleWithWebIdentityRequestInput() {}

    /**
     * Signed OIDC JWT. The issuer must be registered in the role account; signature, expiry and an
     * allowed audience are verified before evaluating role trust.
     */
    @JsonProperty(value = "web_identity_token", required = true)
    private String web_identity_token;

    @JsonProperty("web_identity_token")
    public String getWebIdentityToken() {
      return web_identity_token;
    }

    public AssumeRoleWithWebIdentityRequestInput withWebIdentityToken(String value) {
      this.web_identity_token = value;
      return this;
    }

    /** Full account-scoped role CRN. Bare UUIDs and names are not accepted. */
    @JsonProperty(value = "role", required = true)
    private String role;

    @JsonProperty("role")
    public String getRole() {
      return role;
    }

    public AssumeRoleWithWebIdentityRequestInput withRole(String value) {
      this.role = value;
      return this;
    }

    /**
     * A label recorded on the session and in the audit trail. Defaults to the token's `sub` claim,
     * so an unnamed session still records which identity it came from.
     */
    @JsonProperty(value = "session_name", required = false)
    private String session_name;

    @JsonProperty("session_name")
    public String getSessionName() {
      return session_name;
    }

    public AssumeRoleWithWebIdentityRequestInput withSessionName(String value) {
      this.session_name = value;
      return this;
    }

    /**
     * Credential validity duration (15 min to 12 hours). A value above the role's own
     * `max_session_duration` is rejected rather than clamped.
     */
    @JsonProperty(value = "duration_seconds", required = false)
    private Long duration_seconds;

    @JsonProperty("duration_seconds")
    public Long getDurationSeconds() {
      return duration_seconds;
    }

    public AssumeRoleWithWebIdentityRequestInput withDurationSeconds(Long value) {
      this.duration_seconds = value;
      return this;
    }
  }

  public static final class RolePolicyAttachRequestInput extends Model {
    public RolePolicyAttachRequestInput() {}

    @JsonProperty(value = "policy", required = true)
    private String policy;

    @JsonProperty("policy")
    public String getPolicy() {
      return policy;
    }

    public RolePolicyAttachRequestInput withPolicy(String value) {
      this.policy = value;
      return this;
    }
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

  public static final class OIDCProviderCreateRequestInput extends Model {
    public OIDCProviderCreateRequestInput() {}

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public OIDCProviderCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public OIDCProviderCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    /**
     * Immutable HTTPS issuer URL. Public discovery and JWKS endpoints are required for customer
     * providers.
     */
    @JsonProperty(value = "issuer", required = true)
    private String issuer;

    @JsonProperty("issuer")
    public String getIssuer() {
      return issuer;
    }

    public OIDCProviderCreateRequestInput withIssuer(String value) {
      this.issuer = value;
      return this;
    }

    @JsonProperty(value = "audiences", required = true)
    private List<String> audiences;

    @JsonProperty("audiences")
    public List<String> getAudiences() {
      return audiences;
    }

    public OIDCProviderCreateRequestInput withAudiences(List<String> value) {
      this.audiences = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public OIDCProviderCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class OIDCProviderResponse extends Model {
    public OIDCProviderResponse() {}

    @JsonProperty(value = "oidc_provider", required = true)
    private OIDCProvider oidc_provider;

    @JsonProperty("oidc_provider")
    public OIDCProvider getOidcProvider() {
      return oidc_provider;
    }
  }

  public static final class OIDCProvider extends Model {
    public OIDCProvider() {}

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

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    /**
     * Immutable HTTPS issuer URL. Public discovery and JWKS endpoints are required for customer
     * providers.
     */
    @JsonProperty(value = "issuer", required = true)
    private String issuer;

    @JsonProperty("issuer")
    public String getIssuer() {
      return issuer;
    }

    @JsonProperty(value = "audiences", required = true)
    private List<String> audiences;

    @JsonProperty("audiences")
    public List<String> getAudiences() {
      return audiences;
    }

    /** Platform-managed providers cannot be edited or deleted. */
    @JsonProperty(value = "is_system", required = true)
    private Boolean is_system;

    @JsonProperty("is_system")
    public Boolean getIsSystem() {
      return is_system;
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

  public static final class SSHKeyCreateRequestInput extends Model {
    public SSHKeyCreateRequestInput() {}

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public SSHKeyCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    /**
     * One OpenSSH public key. Ed25519, ECDSA, security-key variants, and RSA of at least 2048 bits
     * are supported. Private keys, certificates, multiple keys and authorized_keys options are
     * rejected.
     */
    @JsonProperty(value = "public_key", required = true)
    private String public_key;

    @JsonProperty("public_key")
    public String getPublicKey() {
      return public_key;
    }

    public SSHKeyCreateRequestInput withPublicKey(String value) {
      this.public_key = value;
      return this;
    }

    /**
     * Optional expiry at least one minute in the future. Expired keys stop authorizing new logins
     * and stop consuming quota immediately; records are automatically deleted after seven days by
     * an hourly cleanup. Rotation requires a new credential and revocation of the old one.
     */
    @JsonProperty(value = "expires_at", required = false)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    public SSHKeyCreateRequestInput withExpiresAt(String value) {
      this.expires_at = value;
      return this;
    }
  }

  public static final class CreatePersonalSSHKeyResponse extends Model {
    public CreatePersonalSSHKeyResponse() {}

    @JsonProperty(value = "ssh_key", required = true)
    private SSHKey ssh_key;

    @JsonProperty("ssh_key")
    public SSHKey getSshKey() {
      return ssh_key;
    }
  }

  public static final class SSHKey extends Model {
    public SSHKey() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Identity-owned SSH credential CRN. */
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

    /** Canonical OpenSSH public key without a comment or authorized_keys options. */
    @JsonProperty(value = "public_key", required = true)
    private String public_key;

    @JsonProperty("public_key")
    public String getPublicKey() {
      return public_key;
    }

    /** SHA-256 fingerprint in OpenSSH format. */
    @JsonProperty(value = "fingerprint", required = true)
    private String fingerprint;

    @JsonProperty("fingerprint")
    public String getFingerprint() {
      return fingerprint;
    }

    @JsonProperty(value = "algorithm", required = true)
    private String algorithm;

    @JsonProperty("algorithm")
    public String getAlgorithm() {
      return algorithm;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    /**
     * Optional expiry. Expired keys do not count toward the SSH key quota. They remain listed for
     * seven days after expiry, then are automatically deleted by an hourly cleanup.
     */
    @JsonProperty(value = "expires_at", required = false)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
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

  public static final class RoleCreateRequestInput extends Model {
    public RoleCreateRequestInput() {}

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

    public RoleCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public RoleCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public RoleCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "trust_policy", required = false)
    private TrustPolicyInput trust_policy;

    @JsonProperty("trust_policy")
    public TrustPolicyInput getTrustPolicy() {
      return trust_policy;
    }

    public RoleCreateRequestInput withTrustPolicy(TrustPolicyInput value) {
      this.trust_policy = value;
      return this;
    }
  }

  public static final class TrustPolicyInput extends Model {
    public TrustPolicyInput() {}

    /**
     * Qualified CRN patterns identifying who may assume this account role. Same-organization
     * membership alone does not establish trust. The caller also needs iam:AssumeRole permission
     * for the target role. Account roles and service accounts use
     * crn:iam::&lt;account-handle&gt;:role/&lt;name&gt; and
     * crn:iam::&lt;account-handle&gt;:service-account/&lt;name&gt;. Human users use
     * crn:workspace:::user/&lt;username&gt; or crn:workspace:::user/* in the selected organization.
     * An instance presents its compute CRN through IMDS. A federated caller names the trusted
     * provider as crn:iam::&lt;account&gt;:oidc-provider/&lt;provider&gt; and uses conditions to
     * restrict token claims.
     */
    @JsonProperty(value = "principals", required = false)
    private List<String> principals;

    @JsonProperty("principals")
    public List<String> getPrincipals() {
      return principals;
    }

    public TrustPolicyInput withPrincipals(List<String> value) {
      this.principals = value;
      return this;
    }

    /** Optional conditions for role assumption */
    @JsonProperty(value = "conditions", required = false)
    private List<PolicyConditionInput> conditions;

    @JsonProperty("conditions")
    public List<PolicyConditionInput> getConditions() {
      return conditions;
    }

    public TrustPolicyInput withConditions(List<PolicyConditionInput> value) {
      this.conditions = value;
      return this;
    }
  }

  public static final class CreateRoleResponse extends Model {
    public CreateRoleResponse() {}

    @JsonProperty(value = "role", required = false)
    private Role role;

    @JsonProperty("role")
    public Role getRole() {
      return role;
    }
  }

  public static final class Role extends Model {
    public Role() {}

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

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "trust_policy", required = false)
    private TrustPolicy trust_policy;

    @JsonProperty("trust_policy")
    public TrustPolicy getTrustPolicy() {
      return trust_policy;
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

    /** System roles cannot be changed or deleted. */
    @JsonProperty(value = "is_system", required = false)
    private Boolean is_system;

    @JsonProperty("is_system")
    public Boolean getIsSystem() {
      return is_system;
    }
  }

  public static final class TrustPolicy extends Model {
    public TrustPolicy() {}

    /**
     * Qualified CRN patterns identifying who may assume this account role. Same-organization
     * membership alone does not establish trust. The caller also needs iam:AssumeRole permission
     * for the target role. Account roles and service accounts use
     * crn:iam::&lt;account-handle&gt;:role/&lt;name&gt; and
     * crn:iam::&lt;account-handle&gt;:service-account/&lt;name&gt;. Human users use
     * crn:workspace:::user/&lt;username&gt; or crn:workspace:::user/* in the selected organization.
     * An instance presents its compute CRN through IMDS. A federated caller names the trusted
     * provider as crn:iam::&lt;account&gt;:oidc-provider/&lt;provider&gt; and uses conditions to
     * restrict token claims.
     */
    @JsonProperty(value = "principals", required = false)
    private List<String> principals;

    @JsonProperty("principals")
    public List<String> getPrincipals() {
      return principals;
    }

    /** Optional conditions for role assumption */
    @JsonProperty(value = "conditions", required = false)
    private List<PolicyCondition> conditions;

    @JsonProperty("conditions")
    public List<PolicyCondition> getConditions() {
      return conditions;
    }
  }

  public static final class ServiceAccountCreateRequestInput extends Model {
    public ServiceAccountCreateRequestInput() {}

    /**
     * Immutable account-scoped name. The Linux login is sa_&lt;name&gt;. Resource names must not
     * start with the literal crn: prefix or be UUIDs.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ServiceAccountCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public ServiceAccountCreateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public ServiceAccountCreateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class CreateServiceAccountResponse extends Model {
    public CreateServiceAccountResponse() {}

    @JsonProperty(value = "service_account", required = false)
    private ServiceAccount service_account;

    @JsonProperty("service_account")
    public ServiceAccount getServiceAccount() {
      return service_account;
    }
  }

  public static final class ServiceAccount extends Model {
    public ServiceAccount() {}

    @JsonProperty(value = "linux_identity", required = false)
    private LinuxIdentity linux_identity;

    @JsonProperty("linux_identity")
    public LinuxIdentity getLinuxIdentity() {
      return linux_identity;
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

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
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

  public static final class LinuxIdentity extends Model {
    public LinuxIdentity() {}

    /**
     * Home allocated to this identity. New human identities use /home/bsu_&lt;uid&gt; and service
     * accounts use /home/bsa_&lt;uid&gt;. Existing identities retain their home. Read this value
     * instead of deriving it from the username.
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

  public static final class CredentialCreateRequestInput extends Model {
    public CredentialCreateRequestInput() {}

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public CredentialCreateRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    /** Optional expiration date */
    @JsonProperty(value = "expires_at", required = false)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    public CredentialCreateRequestInput withExpiresAt(String value) {
      this.expires_at = value;
      return this;
    }
  }

  public static final class CredentialCreateResponse extends Model {
    public CredentialCreateResponse() {}

    @JsonProperty(value = "credential", required = false)
    private Credential credential;

    @JsonProperty("credential")
    public Credential getCredential() {
      return credential;
    }

    /** Only returned once at creation time */
    @JsonProperty(value = "secret_access_key", required = false)
    private String secret_access_key;

    @JsonProperty("secret_access_key")
    public String getSecretAccessKey() {
      return secret_access_key;
    }
  }

  public static final class Credential extends Model {
    public Credential() {}

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

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "access_key_id", required = false)
    private String access_key_id;

    @JsonProperty("access_key_id")
    public String getAccessKeyId() {
      return access_key_id;
    }

    @JsonProperty(value = "last_used_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_used_at = JsonField.missing();

    @JsonProperty("last_used_at")
    public JsonField<String> getLastUsedAt() {
      return last_used_at;
    }

    @JsonProperty(value = "expires_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> expires_at = JsonField.missing();

    @JsonProperty("expires_at")
    public JsonField<String> getExpiresAt() {
      return expires_at;
    }

    @JsonProperty(value = "created_at", required = false)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class CreateServiceAccountSSHKeyResponse extends Model {
    public CreateServiceAccountSSHKeyResponse() {}

    @JsonProperty(value = "ssh_key", required = true)
    private SSHKey ssh_key;

    @JsonProperty("ssh_key")
    public SSHKey getSshKey() {
      return ssh_key;
    }
  }

  public static final class OAuthTokenRequestInput extends Model {
    public OAuthTokenRequestInput() {}

    /**
     * `client_credentials` is the one to use for a service account: it exchanges an access key pair
     * for a token, and needs nothing else. `authorization_code` and `refresh_token` belong to the
     * interactive login a person runs (`basaltic login`), where the token names a USER rather than
     * a service account. They are driven by the CLI, not written by hand. Check the
     * authorization-server metadata document before branching on them — they are advertised only
     * where an authorization endpoint is configured.
     */
    @JsonProperty(value = "grant_type", required = true)
    private OAuthTokenRequestInputGrantType grant_type;

    @JsonProperty("grant_type")
    public OAuthTokenRequestInputGrantType getGrantType() {
      return grant_type;
    }

    public OAuthTokenRequestInput withGrantType(OAuthTokenRequestInputGrantType value) {
      this.grant_type = value;
      return this;
    }

    /** The access key id. Omit when using HTTP Basic. */
    @JsonProperty(value = "client_id", required = false)
    private String client_id;

    @JsonProperty("client_id")
    public String getClientId() {
      return client_id;
    }

    public OAuthTokenRequestInput withClientId(String value) {
      this.client_id = value;
      return this;
    }

    /** The secret access key. Omit when using HTTP Basic. */
    @JsonProperty(value = "client_secret", required = false)
    private String client_secret;

    @JsonProperty("client_secret")
    public String getClientSecret() {
      return client_secret;
    }

    public OAuthTokenRequestInput withClientSecret(String value) {
      this.client_secret = value;
      return this;
    }

    /**
     * Requested token lifetime. A Basaltic extension, not an OAuth parameter — omit it and you get
     * the default. Values outside the range are clamped into it rather than refused, so asking for
     * a day yields the longest token allowed.
     */
    @JsonProperty(value = "duration_seconds", required = false)
    private Long duration_seconds;

    @JsonProperty("duration_seconds")
    public Long getDurationSeconds() {
      return duration_seconds;
    }

    public OAuthTokenRequestInput withDurationSeconds(Long value) {
      this.duration_seconds = value;
      return this;
    }

    /**
     * The authorization code from the consent redirect. Single use, and valid for five minutes.
     * `authorization_code` grant only.
     */
    @JsonProperty(value = "code", required = false)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    public OAuthTokenRequestInput withCode(String value) {
      this.code = value;
      return this;
    }

    /**
     * The PKCE verifier whose SHA-256 was sent as `code_challenge` when the flow started (RFC
     * 7636). Required with `authorization_code`: it is what proves this is the client that began
     * the flow, since a CLI holds no client secret.
     */
    @JsonProperty(value = "code_verifier", required = false)
    private String code_verifier;

    @JsonProperty("code_verifier")
    public String getCodeVerifier() {
      return code_verifier;
    }

    public OAuthTokenRequestInput withCodeVerifier(String value) {
      this.code_verifier = value;
      return this;
    }

    /**
     * The same `redirect_uri` the code was issued for — for the CLI, `urn:ietf:wg:oauth:2.0:oob`.
     * Re-checked here, so a code cannot be redeemed under a different one (RFC 6749 4.1.3).
     */
    @JsonProperty(value = "redirect_uri", required = false)
    private String redirect_uri;

    @JsonProperty("redirect_uri")
    public String getRedirectUri() {
      return redirect_uri;
    }

    public OAuthTokenRequestInput withRedirectUri(String value) {
      this.redirect_uri = value;
      return this;
    }

    /**
     * `refresh_token` grant only. Renews a user session without another trip through the browser.
     * Rotated on every use — store the new one.
     */
    @JsonProperty(value = "refresh_token", required = false)
    private String refresh_token;

    @JsonProperty("refresh_token")
    public String getRefreshToken() {
      return refresh_token;
    }

    public OAuthTokenRequestInput withRefreshToken(String value) {
      this.refresh_token = value;
      return this;
    }
  }

  public static final class OAuthTokenRequestInputGrantType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OAuthTokenRequestInputGrantType(String value) {
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
      return other instanceof OAuthTokenRequestInputGrantType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OAuthTokenRequestInputGrantType CLIENT_CREDENTIALS =
        new OAuthTokenRequestInputGrantType("client_credentials");
    public static final OAuthTokenRequestInputGrantType AUTHORIZATION_CODE =
        new OAuthTokenRequestInputGrantType("authorization_code");
    public static final OAuthTokenRequestInputGrantType REFRESH_TOKEN =
        new OAuthTokenRequestInputGrantType("refresh_token");
  }

  public static final class OAuthTokenResponse extends Model {
    public OAuthTokenResponse() {}

    /**
     * Send as `Authorization: Bearer &lt;token&gt;`. Opaque to clients: do not parse it, and do not
     * key anything on the token string.
     */
    @JsonProperty(value = "access_token", required = true)
    private String access_token;

    @JsonProperty("access_token")
    public String getAccessToken() {
      return access_token;
    }

    @JsonProperty(value = "token_type", required = true)
    private OAuthTokenResponseTokenType token_type;

    @JsonProperty("token_type")
    public OAuthTokenResponseTokenType getTokenType() {
      return token_type;
    }

    /** Seconds until the token expires. */
    @JsonProperty(value = "expires_in", required = true)
    private Long expires_in;

    @JsonProperty("expires_in")
    public Long getExpiresIn() {
      return expires_in;
    }

    /**
     * Returned only by the user grants (`authorization_code` and `refresh_token`). Present it to
     * the `refresh_token` grant to renew without another browser round trip; it is ROTATED on each
     * use, so replace the stored copy every time. A service account gets none. It already holds a
     * long-lived access key and can simply run `client_credentials` again, so a refresh token would
     * be a second credential to store for no gain.
     */
    @JsonProperty(value = "refresh_token", required = false)
    private String refresh_token;

    @JsonProperty("refresh_token")
    public String getRefreshToken() {
      return refresh_token;
    }
  }

  public static final class OAuthTokenResponseTokenType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public OAuthTokenResponseTokenType(String value) {
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
      return other instanceof OAuthTokenResponseTokenType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final OAuthTokenResponseTokenType BEARER =
        new OAuthTokenResponseTokenType("Bearer");
  }

  public static final class GetOIDCProviderScope extends Model {
    public GetOIDCProviderScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetOIDCProviderScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetPersonalLinuxIdentityResponse extends Model {
    public GetPersonalLinuxIdentityResponse() {}

    @JsonProperty(value = "linux_identity", required = true)
    private LinuxIdentity linux_identity;

    @JsonProperty("linux_identity")
    public LinuxIdentity getLinuxIdentity() {
      return linux_identity;
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

  public static final class GetRoleResponse extends Model {
    public GetRoleResponse() {}

    @JsonProperty(value = "role", required = false)
    private Role role;

    @JsonProperty("role")
    public Role getRole() {
      return role;
    }
  }

  public static final class GetRoleScope extends Model {
    public GetRoleScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetRoleScope withLimit(Long value) {
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

    /** Canonical inline policy identity under the owning account principal. */
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

  public static final class GetRoleInlinePolicyScope extends Model {
    public GetRoleInlinePolicyScope() {}
  }

  public static final class PermissionBoundaryResponse extends Model {
    public PermissionBoundaryResponse() {}

    @JsonProperty(value = "policy", required = true)
    private Policy policy;

    @JsonProperty("policy")
    public Policy getPolicy() {
      return policy;
    }
  }

  public static final class STSSessionResponse extends Model {
    public STSSessionResponse() {}

    @JsonProperty(value = "sts_session", required = true)
    private STSSession sts_session;

    @JsonProperty("sts_session")
    public STSSession getStsSession() {
      return sts_session;
    }
  }

  public static final class STSSession extends Model {
    public STSSession() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Optional session identifier */
    @JsonProperty(value = "session_name", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> session_name = JsonField.missing();

    @JsonProperty("session_name")
    public JsonField<String> getSessionName() {
      return session_name;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    @JsonProperty(value = "expires_at", required = true)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }

    @JsonProperty(value = "last_used_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_used_at = JsonField.missing();

    @JsonProperty("last_used_at")
    public JsonField<String> getLastUsedAt() {
      return last_used_at;
    }

    /** Whether the session has been revoked */
    @JsonProperty(value = "revoked", required = true)
    private Boolean revoked;

    @JsonProperty("revoked")
    public Boolean getRevoked() {
      return revoked;
    }

    @JsonProperty(value = "revoked_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> revoked_at = JsonField.missing();

    @JsonProperty("revoked_at")
    public JsonField<String> getRevokedAt() {
      return revoked_at;
    }

    @JsonProperty(value = "revoked_reason", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> revoked_reason = JsonField.missing();

    @JsonProperty("revoked_reason")
    public JsonField<String> getRevokedReason() {
      return revoked_reason;
    }

    /** IP address where the session was created */
    @JsonProperty(value = "source_ip", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> source_ip = JsonField.missing();

    @JsonProperty("source_ip")
    public JsonField<String> getSourceIp() {
      return source_ip;
    }

    /** User-Agent of the caller that created the session */
    @JsonProperty(value = "user_agent", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> user_agent = JsonField.missing();

    @JsonProperty("user_agent")
    public JsonField<String> getUserAgent() {
      return user_agent;
    }

    @JsonProperty(value = "grant_type", required = false)
    private String grant_type;

    @JsonProperty("grant_type")
    public String getGrantType() {
      return grant_type;
    }

    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** Assumed role. Absent for service-account OAuth sessions that do not assume a role. */
    @JsonProperty(value = "role", required = false)
    private ResourceRef role;

    @JsonProperty("role")
    public ResourceRef getRole() {
      return role;
    }

    /**
     * Source user, service account, role or instance. Absent for web identity; use
     * identity_provider and subject instead.
     */
    @JsonProperty(value = "source_principal", required = false)
    private ResourceRef source_principal;

    @JsonProperty("source_principal")
    public ResourceRef getSourcePrincipal() {
      return source_principal;
    }

    /** Account of the source resource, when applicable. */
    @JsonProperty(value = "source_account", required = false)
    private ResourceRef source_account;

    @JsonProperty("source_account")
    public ResourceRef getSourceAccount() {
      return source_account;
    }

    /** Session used to assume this role, when the session is chained. */
    @JsonProperty(value = "parent_session", required = false)
    private ResourceRef parent_session;

    @JsonProperty("parent_session")
    public ResourceRef getParentSession() {
      return parent_session;
    }

    /** Account-owned OIDC provider that verified the web-identity token. */
    @JsonProperty(value = "identity_provider", required = false)
    private ResourceRef identity_provider;

    @JsonProperty("identity_provider")
    public ResourceRef getIdentityProvider() {
      return identity_provider;
    }

    /** Verified subject (sub) from the web-identity token, independent of the session name. */
    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
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

  public static final class GetSTSSessionScope extends Model {
    public GetSTSSessionScope() {}

    @JsonProperty(value = "role", required = false)
    private String role;

    @JsonProperty("role")
    public String getRole() {
      return role;
    }

    public GetSTSSessionScope withRole(String value) {
      this.role = value;
      return this;
    }

    @JsonProperty(value = "principal", required = false)
    private String principal;

    @JsonProperty("principal")
    public String getPrincipal() {
      return principal;
    }

    public GetSTSSessionScope withPrincipal(String value) {
      this.principal = value;
      return this;
    }

    @JsonProperty(value = "principal_type", required = false)
    private GetSTSSessionScopePrincipalType principal_type;

    @JsonProperty("principal_type")
    public GetSTSSessionScopePrincipalType getPrincipalType() {
      return principal_type;
    }

    public GetSTSSessionScope withPrincipalType(GetSTSSessionScopePrincipalType value) {
      this.principal_type = value;
      return this;
    }

    @JsonProperty(value = "active_only", required = false)
    private Boolean active_only;

    @JsonProperty("active_only")
    public Boolean getActiveOnly() {
      return active_only;
    }

    public GetSTSSessionScope withActiveOnly(Boolean value) {
      this.active_only = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetSTSSessionScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetSTSSessionScopePrincipalType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public GetSTSSessionScopePrincipalType(String value) {
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
      return other instanceof GetSTSSessionScopePrincipalType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final GetSTSSessionScopePrincipalType USER =
        new GetSTSSessionScopePrincipalType("user");
    public static final GetSTSSessionScopePrincipalType SERVICE_ACCOUNT =
        new GetSTSSessionScopePrincipalType("service_account");
    public static final GetSTSSessionScopePrincipalType ROLE =
        new GetSTSSessionScopePrincipalType("role");
    public static final GetSTSSessionScopePrincipalType ASSUMED_ROLE =
        new GetSTSSessionScopePrincipalType("assumed_role");
  }

  public static final class GetServiceAccountResponse extends Model {
    public GetServiceAccountResponse() {}

    @JsonProperty(value = "service_account", required = false)
    private ServiceAccount service_account;

    @JsonProperty("service_account")
    public ServiceAccount getServiceAccount() {
      return service_account;
    }
  }

  public static final class GetServiceAccountScope extends Model {
    public GetServiceAccountScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetServiceAccountScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class GetServiceAccountInlinePolicyScope extends Model {
    public GetServiceAccountInlinePolicyScope() {}
  }

  public static final class GetServiceAccountLinuxIdentityResponse extends Model {
    public GetServiceAccountLinuxIdentityResponse() {}

    @JsonProperty(value = "linux_identity", required = true)
    private LinuxIdentity linux_identity;

    @JsonProperty("linux_identity")
    public LinuxIdentity getLinuxIdentity() {
      return linux_identity;
    }
  }

  public static final class ListOIDCProvidersQuery extends Model {
    public ListOIDCProvidersQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListOIDCProvidersQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListOIDCProvidersQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListOIDCProvidersQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListOIDCProvidersQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class OIDCProviderListResponse extends Model {
    public OIDCProviderListResponse() {}

    @JsonProperty(value = "oidc_providers", required = true)
    private List<OIDCProvider> oidc_providers;

    @JsonProperty("oidc_providers")
    public List<OIDCProvider> getOidcProviders() {
      return oidc_providers;
    }

    @JsonProperty(value = "meta", required = true)
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

  public static final class ListPersonalSSHKeysResponse extends Model {
    public ListPersonalSSHKeysResponse() {}

    @JsonProperty(value = "ssh_keys", required = true)
    private List<SSHKey> ssh_keys;

    @JsonProperty("ssh_keys")
    public List<SSHKey> getSshKeys() {
      return ssh_keys;
    }
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

    @JsonProperty(value = "roles", required = true)
    private List<Role> roles;

    @JsonProperty("roles")
    public List<Role> getRoles() {
      return roles;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
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

    @JsonProperty(value = "service_accounts", required = true)
    private List<ServiceAccount> service_accounts;

    @JsonProperty("service_accounts")
    public List<ServiceAccount> getServiceAccounts() {
      return service_accounts;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListRoleInlinePoliciesQuery extends Model {
    public ListRoleInlinePoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRoleInlinePoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRoleInlinePoliciesQuery withCrn(String value) {
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

  public static final class ListRolesQuery extends Model {
    public ListRolesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListRolesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListRolesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListRolesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListRolesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class RoleListResponse extends Model {
    public RoleListResponse() {}

    @JsonProperty(value = "roles", required = false)
    private List<Role> roles;

    @JsonProperty("roles")
    public List<Role> getRoles() {
      return roles;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListSTSSessionsQuery extends Model {
    public ListSTSSessionsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListSTSSessionsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListSTSSessionsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "role", required = false)
    private String role;

    @JsonProperty("role")
    public String getRole() {
      return role;
    }

    public ListSTSSessionsQuery withRole(String value) {
      this.role = value;
      return this;
    }

    @JsonProperty(value = "principal", required = false)
    private String principal;

    @JsonProperty("principal")
    public String getPrincipal() {
      return principal;
    }

    public ListSTSSessionsQuery withPrincipal(String value) {
      this.principal = value;
      return this;
    }

    @JsonProperty(value = "principal_type", required = false)
    private ListSTSSessionsQueryPrincipalType principal_type;

    @JsonProperty("principal_type")
    public ListSTSSessionsQueryPrincipalType getPrincipalType() {
      return principal_type;
    }

    public ListSTSSessionsQuery withPrincipalType(ListSTSSessionsQueryPrincipalType value) {
      this.principal_type = value;
      return this;
    }

    @JsonProperty(value = "active_only", required = false)
    private Boolean active_only;

    @JsonProperty("active_only")
    public Boolean getActiveOnly() {
      return active_only;
    }

    public ListSTSSessionsQuery withActiveOnly(Boolean value) {
      this.active_only = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListSTSSessionsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListSTSSessionsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ListSTSSessionsQueryPrincipalType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ListSTSSessionsQueryPrincipalType(String value) {
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
      return other instanceof ListSTSSessionsQueryPrincipalType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final ListSTSSessionsQueryPrincipalType USER =
        new ListSTSSessionsQueryPrincipalType("user");
    public static final ListSTSSessionsQueryPrincipalType SERVICE_ACCOUNT =
        new ListSTSSessionsQueryPrincipalType("service_account");
    public static final ListSTSSessionsQueryPrincipalType ROLE =
        new ListSTSSessionsQueryPrincipalType("role");
    public static final ListSTSSessionsQueryPrincipalType ASSUMED_ROLE =
        new ListSTSSessionsQueryPrincipalType("assumed_role");
  }

  public static final class STSSessionListResponse extends Model {
    public STSSessionListResponse() {}

    @JsonProperty(value = "sts_sessions", required = true)
    private List<STSSession> sts_sessions;

    @JsonProperty("sts_sessions")
    public List<STSSession> getStsSessions() {
      return sts_sessions;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListServiceAccountCredentialsQuery extends Model {
    public ListServiceAccountCredentialsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListServiceAccountCredentialsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListServiceAccountCredentialsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class CredentialListResponse extends Model {
    public CredentialListResponse() {}

    @JsonProperty(value = "credentials", required = false)
    private List<Credential> credentials;

    @JsonProperty("credentials")
    public List<Credential> getCredentials() {
      return credentials;
    }
  }

  public static final class ListServiceAccountInlinePoliciesQuery extends Model {
    public ListServiceAccountInlinePoliciesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListServiceAccountInlinePoliciesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListServiceAccountInlinePoliciesQuery withCrn(String value) {
      this.crn = value;
      return this;
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

  public static final class PrincipalPoliciesListResponse extends Model {
    public PrincipalPoliciesListResponse() {}

    @JsonProperty(value = "policies", required = false)
    private List<Policy> policies;

    @JsonProperty("policies")
    public List<Policy> getPolicies() {
      return policies;
    }
  }

  public static final class ListServiceAccountSSHKeysResponse extends Model {
    public ListServiceAccountSSHKeysResponse() {}

    @JsonProperty(value = "ssh_keys", required = true)
    private List<SSHKey> ssh_keys;

    @JsonProperty("ssh_keys")
    public List<SSHKey> getSshKeys() {
      return ssh_keys;
    }
  }

  public static final class ListServiceAccountsQuery extends Model {
    public ListServiceAccountsQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public ListServiceAccountsQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListServiceAccountsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListServiceAccountsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListServiceAccountsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }
  }

  public static final class ServiceAccountListResponse extends Model {
    public ServiceAccountListResponse() {}

    @JsonProperty(value = "service_accounts", required = false)
    private List<ServiceAccount> service_accounts;

    @JsonProperty("service_accounts")
    public List<ServiceAccount> getServiceAccounts() {
      return service_accounts;
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

  public static final class OAuthRevokeRequestInput extends Model {
    public OAuthRevokeRequestInput() {}

    /** The access token to revoke. */
    @JsonProperty(value = "token", required = true)
    private String token;

    @JsonProperty("token")
    public String getToken() {
      return token;
    }

    public OAuthRevokeRequestInput withToken(String value) {
      this.token = value;
      return this;
    }

    /**
     * Accepted and ignored — the token identifies itself. Present because RFC 7009 clients send it.
     */
    @JsonProperty(value = "token_type_hint", required = false)
    private String token_type_hint;

    @JsonProperty("token_type_hint")
    public String getTokenTypeHint() {
      return token_type_hint;
    }

    public OAuthRevokeRequestInput withTokenTypeHint(String value) {
      this.token_type_hint = value;
      return this;
    }
  }

  public static final class RevokeSTSSessionBody extends Model {
    public RevokeSTSSessionBody() {}

    /** Reason for revoking the session */
    @JsonProperty(value = "reason", required = false)
    private String reason;

    @JsonProperty("reason")
    public String getReason() {
      return reason;
    }

    public RevokeSTSSessionBody withReason(String value) {
      this.reason = value;
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

  public static final class OIDCProviderUpdateRequestInput extends Model {
    public OIDCProviderUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public OIDCProviderUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "audiences", required = false)
    private List<String> audiences;

    @JsonProperty("audiences")
    public List<String> getAudiences() {
      return audiences;
    }

    public OIDCProviderUpdateRequestInput withAudiences(List<String> value) {
      this.audiences = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public OIDCProviderUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
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

  public static final class RoleUpdateRequestInput extends Model {
    public RoleUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public RoleUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public RoleUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "trust_policy", required = false)
    private TrustPolicyInput trust_policy;

    @JsonProperty("trust_policy")
    public TrustPolicyInput getTrustPolicy() {
      return trust_policy;
    }

    public RoleUpdateRequestInput withTrustPolicy(TrustPolicyInput value) {
      this.trust_policy = value;
      return this;
    }
  }

  public static final class UpdateRoleResponse extends Model {
    public UpdateRoleResponse() {}

    @JsonProperty(value = "role", required = false)
    private Role role;

    @JsonProperty("role")
    public Role getRole() {
      return role;
    }
  }

  public static final class ServiceAccountUpdateRequestInput extends Model {
    public ServiceAccountUpdateRequestInput() {}

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public ServiceAccountUpdateRequestInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public ServiceAccountUpdateRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }

    @JsonProperty(value = "enabled", required = false)
    private Boolean enabled;

    @JsonProperty("enabled")
    public Boolean getEnabled() {
      return enabled;
    }

    public ServiceAccountUpdateRequestInput withEnabled(Boolean value) {
      this.enabled = value;
      return this;
    }
  }

  public static final class UpdateServiceAccountResponse extends Model {
    public UpdateServiceAccountResponse() {}

    @JsonProperty(value = "service_account", required = false)
    private ServiceAccount service_account;

    @JsonProperty("service_account")
    public ServiceAccount getServiceAccount() {
      return service_account;
    }
  }
}
