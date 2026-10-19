package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Model;

/** Typed registry wire models. Unknown string enum values are retained. */
public final class Registry {

  private Registry() {}

  public static final class BatchDeleteImageRequestInput extends Model {
    public BatchDeleteImageRequestInput() {}

    /** Removes the manifest AND every tag pointing at it. */
    @JsonProperty(value = "digests", required = false)
    private List<String> digests;

    @JsonProperty("digests")
    public List<String> getDigests() {
      return digests;
    }

    public BatchDeleteImageRequestInput withDigests(List<String> value) {
      this.digests = value;
      return this;
    }

    /** Removes only the tag. The manifest survives, untagged. */
    @JsonProperty(value = "tags", required = false)
    private List<String> tags;

    @JsonProperty("tags")
    public List<String> getTags() {
      return tags;
    }

    public BatchDeleteImageRequestInput withTags(List<String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class BatchDeleteResult extends Model {
    public BatchDeleteResult() {}

    @JsonProperty(value = "deleted", required = true)
    private List<BatchDeleteResultDeletedItem> deleted;

    @JsonProperty("deleted")
    public List<BatchDeleteResultDeletedItem> getDeleted() {
      return deleted;
    }

    @JsonProperty(value = "failed", required = true)
    private List<BatchDeleteResultFailedItem> failed;

    @JsonProperty("failed")
    public List<BatchDeleteResultFailedItem> getFailed() {
      return failed;
    }
  }

  public static final class BatchDeleteResultDeletedItem extends Model {
    public BatchDeleteResultDeletedItem() {}

    @JsonProperty(value = "digest", required = true)
    private String digest;

    @JsonProperty("digest")
    public String getDigest() {
      return digest;
    }

    /**
     * The tags the delete took with it. Surfaced because deleting by digest silently removes every
     * tag pointing at it, and a caller who meant to remove one needs to see the rest go.
     */
    @JsonProperty(value = "tags", required = false)
    private List<String> tags;

    @JsonProperty("tags")
    public List<String> getTags() {
      return tags;
    }
  }

  public static final class BatchDeleteResultFailedItem extends Model {
    public BatchDeleteResultFailedItem() {}

    @JsonProperty(value = "digest", required = false)
    private String digest;

    @JsonProperty("digest")
    public String getDigest() {
      return digest;
    }

    @JsonProperty(value = "tag", required = false)
    private String tag;

    @JsonProperty("tag")
    public String getTag() {
      return tag;
    }

    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty("code")
    public String getCode() {
      return code;
    }

    @JsonProperty(value = "reason", required = true)
    private String reason;

    @JsonProperty("reason")
    public String getReason() {
      return reason;
    }
  }

  public static final class CreatePullThroughCacheRuleRequestInput extends Model {
    public CreatePullThroughCacheRuleRequestInput() {}

    /**
     * One or two lowercase repository-name components. It becomes the leading path of every
     * repository the rule creates, so it has to be a name a client can pull.
     */
    @JsonProperty(value = "prefix", required = true)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }

    public CreatePullThroughCacheRuleRequestInput withPrefix(String value) {
      this.prefix = value;
      return this;
    }

    /**
     * A hostname with an optional port. `https://` is accepted and stripped; anything else is
     * refused, because the connection can carry a credential.
     */
    @JsonProperty(value = "upstream_registry", required = true)
    private String upstream_registry;

    @JsonProperty("upstream_registry")
    public String getUpstreamRegistry() {
      return upstream_registry;
    }

    public CreatePullThroughCacheRuleRequestInput withUpstreamRegistry(String value) {
      this.upstream_registry = value;
      return this;
    }

    /** Optional path prepended upstream. */
    @JsonProperty(value = "upstream_prefix", required = false)
    private String upstream_prefix;

    @JsonProperty("upstream_prefix")
    public String getUpstreamPrefix() {
      return upstream_prefix;
    }

    public CreatePullThroughCacheRuleRequestInput withUpstreamPrefix(String value) {
      this.upstream_prefix = value;
      return this;
    }

    /**
     * Optional. Worth setting even against a public registry: an authenticated Docker Hub pull
     * draws on a far larger rate-limit budget than an anonymous one.
     */
    @JsonProperty(value = "upstream_username", required = false)
    private String upstream_username;

    @JsonProperty("upstream_username")
    public String getUpstreamUsername() {
      return upstream_username;
    }

    public CreatePullThroughCacheRuleRequestInput withUpstreamUsername(String value) {
      this.upstream_username = value;
      return this;
    }

    /**
     * The password or token. Write-only — sealed at rest and never returned. Required with
     * `upstream_username`, and refused without it: a half-specified credential produces an
     * anonymous pull that silently draws on the small budget.
     */
    @JsonProperty(value = "upstream_secret", required = false)
    private String upstream_secret;

    @JsonProperty("upstream_secret")
    public String getUpstreamSecret() {
      return upstream_secret;
    }

    public CreatePullThroughCacheRuleRequestInput withUpstreamSecret(String value) {
      this.upstream_secret = value;
      return this;
    }
  }

  public static final class PullThroughCacheRuleResponse extends Model {
    public PullThroughCacheRuleResponse() {}

    @JsonProperty(value = "pull_through_cache_rule", required = true)
    private PullThroughCacheRule pull_through_cache_rule;

    @JsonProperty("pull_through_cache_rule")
    public PullThroughCacheRule getPullThroughCacheRule() {
      return pull_through_cache_rule;
    }
  }

  public static final class PullThroughCacheRule extends Model {
    public PullThroughCacheRule() {}

    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /** The leading path component(s) of the repository names this rule claims. */
    @JsonProperty(value = "prefix", required = true)
    private String prefix;

    @JsonProperty("prefix")
    public String getPrefix() {
      return prefix;
    }

    /**
     * The pullable reference prefix the rule creates. Returned rather than assembled by the client,
     * for the same reason a repository's `uri` is: the account handle's position in the path is the
     * only thing separating two tenants' namespaces.
     */
    @JsonProperty(value = "uri_prefix", required = true)
    private String uri_prefix;

    @JsonProperty("uri_prefix")
    public String getUriPrefix() {
      return uri_prefix;
    }

    /**
     * The upstream host. `docker.io` is stored as `registry-1.docker.io`, which is the host that
     * actually speaks `/v2` — the docker daemon makes the same rewrite internally.
     */
    @JsonProperty(value = "upstream_registry", required = true)
    private String upstream_registry;

    @JsonProperty("upstream_registry")
    public String getUpstreamRegistry() {
      return upstream_registry;
    }

    /**
     * Prepended to the rest of the repository name upstream. `library` is what makes `hub/nginx`
     * resolve to Docker Hub's `library/nginx`.
     */
    @JsonProperty(value = "upstream_prefix", required = false)
    private String upstream_prefix;

    @JsonProperty("upstream_prefix")
    public String getUpstreamPrefix() {
      return upstream_prefix;
    }

    @JsonProperty(value = "upstream_username", required = false)
    private String upstream_username;

    @JsonProperty("upstream_username")
    public String getUpstreamUsername() {
      return upstream_username;
    }

    /**
     * Whether a secret is stored. The secret itself is never returned; rotation is a write of the
     * new value.
     */
    @JsonProperty(value = "has_credential", required = true)
    private Boolean has_credential;

    @JsonProperty("has_credential")
    public Boolean getHasCredential() {
      return has_credential;
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

  public static final class CreateRepositoryRequestInput extends Model {
    public CreateRepositoryRequestInput() {}

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

    public CreateRepositoryRequestInput withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "tag_mutability", required = false)
    private CreateRepositoryRequestInputTagMutability tag_mutability;

    @JsonProperty("tag_mutability")
    public CreateRepositoryRequestInputTagMutability getTagMutability() {
      return tag_mutability;
    }

    public CreateRepositoryRequestInput withTagMutability(
        CreateRepositoryRequestInputTagMutability value) {
      this.tag_mutability = value;
      return this;
    }

    @JsonProperty(value = "deletion_protection", required = false)
    private Boolean deletion_protection;

    @JsonProperty("deletion_protection")
    public Boolean getDeletionProtection() {
      return deletion_protection;
    }

    public CreateRepositoryRequestInput withDeletionProtection(Boolean value) {
      this.deletion_protection = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public CreateRepositoryRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class CreateRepositoryRequestInputTagMutability {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreateRepositoryRequestInputTagMutability(String value) {
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
      return other instanceof CreateRepositoryRequestInputTagMutability v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreateRepositoryRequestInputTagMutability MUTABLE =
        new CreateRepositoryRequestInputTagMutability("mutable");
    public static final CreateRepositoryRequestInputTagMutability IMMUTABLE =
        new CreateRepositoryRequestInputTagMutability("immutable");
  }

  public static final class RepositoryResponse extends Model {
    public RepositoryResponse() {}

    @JsonProperty(value = "repository", required = true)
    private Repository repository;

    @JsonProperty("repository")
    public Repository getRepository() {
      return repository;
    }

    /**
     * The login/build/push sequence for this repository. Rendered server-side because the login
     * username, the endpoint, and the account handle's position in the reference all come from
     * service configuration.
     */
    @JsonProperty(value = "push_commands", required = false)
    private List<String> push_commands;

    @JsonProperty("push_commands")
    public List<String> getPushCommands() {
      return push_commands;
    }
  }

  public static final class Repository extends Model {
    public Repository() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /**
     * The IAM resource name. Built from the repository NAME, not its id, so a policy naming a
     * repository keeps applying after a delete and re-create under the same name — which matters
     * here more than elsewhere, because the name is what every deployment manifest pulls.
     */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    /**
     * Lowercase alphanumeric path components separated by a single period, one or two underscores,
     * or hyphens, joined by slashes. This is the OCI grammar — anything else is not pushable, so a
     * laxer rule would only produce repositories nobody can use. Resource names must not start with
     * the literal crn: prefix or be UUIDs (canonical, compact, braced, or urn:uuid: forms, in
     * either case).
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    /**
     * The pullable reference prefix. Returned rather than left for clients to assemble: the account
     * handle's position in the path is the only thing separating two tenants' repositories of the
     * same name.
     */
    @JsonProperty(value = "uri", required = true)
    private String uri;

    @JsonProperty("uri")
    public String getUri() {
      return uri;
    }

    /**
     * `immutable` refuses to move a tag that already resolves, so a deployed digest cannot be
     * swapped under a running fleet. Pushing a tag that does not exist yet still works — the
     * guarantee is that a tag never changes meaning, not that the tag set is frozen. A repeat push
     * of the identical manifest is always allowed.
     */
    @JsonProperty(value = "tag_mutability", required = true)
    private RepositoryTagMutability tag_mutability;

    @JsonProperty("tag_mutability")
    public RepositoryTagMutability getTagMutability() {
      return tag_mutability;
    }

    /** Refuses `DeleteRepository` while set, even for an empty repository and even with `force`. */
    @JsonProperty(value = "deletion_protection", required = true)
    private Boolean deletion_protection;

    @JsonProperty("deletion_protection")
    public Boolean getDeletionProtection() {
      return deletion_protection;
    }

    /** AWS-style resource tags. Feed the `basalt:ResourceTag/*` policy conditions. */
    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    @JsonProperty(value = "stats", required = false)
    private RepositoryStats stats;

    @JsonProperty("stats")
    public RepositoryStats getStats() {
      return stats;
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

  public static final class RepositoryTagMutability {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RepositoryTagMutability(String value) {
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
      return other instanceof RepositoryTagMutability v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RepositoryTagMutability MUTABLE = new RepositoryTagMutability("mutable");
    public static final RepositoryTagMutability IMMUTABLE =
        new RepositoryTagMutability("immutable");
  }

  public static final class RepositoryStats extends Model {
    public RepositoryStats() {}

    @JsonProperty(value = "image_count", required = false)
    private Long image_count;

    @JsonProperty("image_count")
    public Long getImageCount() {
      return image_count;
    }

    @JsonProperty(value = "tag_count", required = false)
    private Long tag_count;

    @JsonProperty("tag_count")
    public Long getTagCount() {
      return tag_count;
    }

    /**
     * The sum of the DISTINCT blobs this repository's manifests reference. Not the sum of its
     * images' sizes: ten tags of one image share their layers, and adding the per-image figures
     * would report ten times the space occupied.
     */
    @JsonProperty(value = "size_bytes", required = false)
    private Long size_bytes;

    @JsonProperty("size_bytes")
    public Long getSizeBytes() {
      return size_bytes;
    }

    /** Null for a repository that has never received an image. */
    @JsonProperty(value = "last_pushed_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_pushed_at = JsonField.missing();

    @JsonProperty("last_pushed_at")
    public JsonField<String> getLastPushedAt() {
      return last_pushed_at;
    }
  }

  public static final class DeleteRepositoryQuery extends Model {
    public DeleteRepositoryQuery() {}

    @JsonProperty(value = "force", required = false)
    private Boolean force;

    @JsonProperty("force")
    public Boolean getForce() {
      return force;
    }

    public DeleteRepositoryQuery withForce(Boolean value) {
      this.force = value;
      return this;
    }
  }

  public static final class ImageResponse extends Model {
    public ImageResponse() {}

    @JsonProperty(value = "image", required = true)
    private Image image;

    @JsonProperty("image")
    public Image getImage() {
      return image;
    }

    /**
     * The manifest document, parsed. NOT suitable for verifying the digest — that covers the exact
     * bytes pushed, and a round-trip through a JSON encoder reorders keys. Fetch from `/v2` to
     * re-hash.
     */
    @JsonProperty(value = "manifest", required = false)
    private Map<String, JsonNode> manifest;

    @JsonProperty("manifest")
    public Map<String, JsonNode> getManifest() {
      return manifest;
    }
  }

  public static final class Image extends Model {
    public Image() {}

    /** The image's row id — the pagination cursor for the list endpoint. */
    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** The sha256 of the manifest document's exact bytes. */
    @JsonProperty(value = "digest", required = true)
    private String digest;

    @JsonProperty("digest")
    public String getDigest() {
      return digest;
    }

    /**
     * The OCI or Docker v2 media type. Both vocabularies are stored as pushed: containerd emits
     * OCI, older `docker push` emits Docker v2, and they are the same documents with different
     * labels.
     */
    @JsonProperty(value = "media_type", required = true)
    private String media_type;

    @JsonProperty("media_type")
    public String getMediaType() {
      return media_type;
    }

    /** Every tag pointing at this manifest. Empty for an untagged image. */
    @JsonProperty(value = "tags", required = true)
    private List<String> tags;

    @JsonProperty("tags")
    public List<String> getTags() {
      return tags;
    }

    /**
     * What kind of thing this is. Distinguishes a container image from a Helm chart, an SBOM, or a
     * signature — all of which are stored as manifests and would otherwise be indistinguishable.
     */
    @JsonProperty(value = "artifact_type", required = false)
    private String artifact_type;

    @JsonProperty("artifact_type")
    public String getArtifactType() {
      return artifact_type;
    }

    /** Absent on a multi-platform index, which has no config of its own. */
    @JsonProperty(value = "config_digest", required = false)
    private String config_digest;

    @JsonProperty("config_digest")
    public String getConfigDigest() {
      return config_digest;
    }

    /**
     * The digest this manifest is *about*, set on a signature, SBOM, or attestation. What the OCI
     * referrers API resolves.
     */
    @JsonProperty(value = "subject", required = false)
    private String subject;

    @JsonProperty("subject")
    public String getSubject() {
      return subject;
    }

    /** The manifest document itself. */
    @JsonProperty(value = "manifest_size_bytes", required = false)
    private Long manifest_size_bytes;

    @JsonProperty("manifest_size_bytes")
    public Long getManifestSizeBytes() {
      return manifest_size_bytes;
    }

    /**
     * The sum of the distinct blobs this manifest references — what a customer means by "how big is
     * this image".
     */
    @JsonProperty(value = "size_bytes", required = true)
    private Long size_bytes;

    @JsonProperty("size_bytes")
    public Long getSizeBytes() {
      return size_bytes;
    }

    /** True for a multi-platform image index or Docker manifest list. */
    @JsonProperty(value = "is_index", required = true)
    private Boolean is_index;

    @JsonProperty("is_index")
    public Boolean getIsIndex() {
      return is_index;
    }

    @JsonProperty(value = "pushed_at", required = true)
    private String pushed_at;

    @JsonProperty("pushed_at")
    public String getPushedAt() {
      return pushed_at;
    }

    /**
     * Coarsened to a minute. A fleet of 500 nodes pulling one image in a few seconds would
     * otherwise be 500 row updates contending on one page, and the lifecycle rule reading this
     * measures in days.
     */
    @JsonProperty(value = "last_pulled_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_pulled_at = JsonField.missing();

    @JsonProperty("last_pulled_at")
    public JsonField<String> getLastPulledAt() {
      return last_pulled_at;
    }
  }

  public static final class DescribeImagesQuery extends Model {
    public DescribeImagesQuery() {}

    @JsonProperty(value = "tag_status", required = false)
    private DescribeImagesQueryTagStatus tag_status;

    @JsonProperty("tag_status")
    public DescribeImagesQueryTagStatus getTagStatus() {
      return tag_status;
    }

    public DescribeImagesQuery withTagStatus(DescribeImagesQueryTagStatus value) {
      this.tag_status = value;
      return this;
    }

    @JsonProperty(value = "tag_prefix", required = false)
    private String tag_prefix;

    @JsonProperty("tag_prefix")
    public String getTagPrefix() {
      return tag_prefix;
    }

    public DescribeImagesQuery withTagPrefix(String value) {
      this.tag_prefix = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public DescribeImagesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public DescribeImagesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class DescribeImagesQueryTagStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public DescribeImagesQueryTagStatus(String value) {
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
      return other instanceof DescribeImagesQueryTagStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final DescribeImagesQueryTagStatus TAGGED =
        new DescribeImagesQueryTagStatus("tagged");
    public static final DescribeImagesQueryTagStatus UNTAGGED =
        new DescribeImagesQueryTagStatus("untagged");
    public static final DescribeImagesQueryTagStatus ANY = new DescribeImagesQueryTagStatus("any");
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

  public static final class DescribePullThroughCacheRulesQuery extends Model {
    public DescribePullThroughCacheRulesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public DescribePullThroughCacheRulesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public DescribePullThroughCacheRulesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }
  }

  public static final class PullThroughCacheRuleListResponse extends Model {
    public PullThroughCacheRuleListResponse() {}

    @JsonProperty(value = "pull_through_cache_rules", required = true)
    private List<PullThroughCacheRule> pull_through_cache_rules;

    @JsonProperty("pull_through_cache_rules")
    public List<PullThroughCacheRule> getPullThroughCacheRules() {
      return pull_through_cache_rules;
    }
  }

  public static final class DescribeRepositoriesQuery extends Model {
    public DescribeRepositoriesQuery() {}

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    public DescribeRepositoriesQuery withName(String value) {
      this.name = value;
      return this;
    }

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public DescribeRepositoriesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public DescribeRepositoriesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public DescribeRepositoriesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class RepositoryListResponse extends Model {
    public RepositoryListResponse() {}

    @JsonProperty(value = "repositories", required = true)
    private List<Repository> repositories;

    @JsonProperty("repositories")
    public List<Repository> getRepositories() {
      return repositories;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class AuthorizationTokenResponse extends Model {
    public AuthorizationTokenResponse() {}

    @JsonProperty(value = "authorization_data", required = true)
    private AuthorizationTokenResponseAuthorizationData authorization_data;

    @JsonProperty("authorization_data")
    public AuthorizationTokenResponseAuthorizationData getAuthorizationData() {
      return authorization_data;
    }
  }

  public static final class AuthorizationTokenResponseAuthorizationData extends Model {
    public AuthorizationTokenResponseAuthorizationData() {}

    /**
     * `base64("&lt;username&gt;:&lt;password&gt;")` — the single opaque blob ECR-shaped tooling
     * expects.
     */
    @JsonProperty(value = "authorization_token", required = true)
    private String authorization_token;

    @JsonProperty("authorization_token")
    public String getAuthorizationToken() {
      return authorization_token;
    }

    /**
     * Fixed, and ignored on the way in: the token identifies the principal. Present so `docker
     * login -u` has something to pass.
     */
    @JsonProperty(value = "username", required = true)
    private String username;

    @JsonProperty("username")
    public String getUsername() {
      return username;
    }

    /** The credential itself, for `docker login --password-stdin`. */
    @JsonProperty(value = "password", required = true)
    private String password;

    @JsonProperty("password")
    public String getPassword() {
      return password;
    }

    @JsonProperty(value = "endpoint", required = true)
    private String endpoint;

    @JsonProperty("endpoint")
    public String getEndpoint() {
      return endpoint;
    }

    @JsonProperty(value = "expires_at", required = true)
    private String expires_at;

    @JsonProperty("expires_at")
    public String getExpiresAt() {
      return expires_at;
    }
  }

  public static final class EncryptionConfigurationResponse extends Model {
    public EncryptionConfigurationResponse() {}

    @JsonProperty(value = "encryption_configuration", required = true)
    private EncryptionConfiguration encryption_configuration;

    @JsonProperty("encryption_configuration")
    public EncryptionConfiguration getEncryptionConfiguration() {
      return encryption_configuration;
    }
  }

  public static final class EncryptionConfiguration extends Model {
    public EncryptionConfiguration() {}

    /**
     * `platform_managed` wraps each blob's data key under a platform key the customer does not
     * manage. `kms` wraps it under a key in the account's own KMS, so disabling that key stops the
     * account's layers from being readable. Reported as a named type rather than a boolean so a
     * future third posture has somewhere to go.
     */
    @JsonProperty(value = "encryption_type", required = true)
    private EncryptionConfigurationEncryptionType encryption_type;

    @JsonProperty("encryption_type")
    public EncryptionConfigurationEncryptionType getEncryptionType() {
      return encryption_type;
    }

    /**
     * Customer-managed key reference. Omitted under platform encryption. A deleted key retains its
     * ID and CRN without a name; existing layers still require that key.
     */
    @JsonProperty(value = "kms_key", required = false)
    private ResourceRef kms_key;

    @JsonProperty("kms_key")
    public ResourceRef getKmsKey() {
      return kms_key;
    }

    /**
     * When the setting last changed. Absent on an account that has never configured encryption —
     * there is no record, and reporting the current time would read as a change that never
     * happened.
     */
    @JsonProperty(value = "updated_at", required = false)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class EncryptionConfigurationEncryptionType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public EncryptionConfigurationEncryptionType(String value) {
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
      return other instanceof EncryptionConfigurationEncryptionType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final EncryptionConfigurationEncryptionType PLATFORM_MANAGED =
        new EncryptionConfigurationEncryptionType("platform_managed");
    public static final EncryptionConfigurationEncryptionType KMS =
        new EncryptionConfigurationEncryptionType("kms");
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

  public static final class LifecyclePolicyResponse extends Model {
    public LifecyclePolicyResponse() {}

    @JsonProperty(value = "policy", required = true)
    private LifecyclePolicyResponsePolicy policy;

    @JsonProperty("policy")
    public LifecyclePolicyResponsePolicy getPolicy() {
      return policy;
    }
  }

  public static final class LifecyclePolicyResponsePolicy extends Model {
    public LifecyclePolicyResponsePolicy() {}

    @JsonProperty(value = "rules", required = true)
    private List<LifecycleRule> rules;

    @JsonProperty("rules")
    public List<LifecycleRule> getRules() {
      return rules;
    }

    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }

    /**
     * Null for a policy the worker has not reached yet. Surfaced so a customer whose images are not
     * expiring can tell "never ran" from "ran and matched nothing".
     */
    @JsonProperty(value = "last_evaluated_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_evaluated_at = JsonField.missing();

    @JsonProperty("last_evaluated_at")
    public JsonField<String> getLastEvaluatedAt() {
      return last_evaluated_at;
    }
  }

  public static final class LifecycleRule extends Model {
    public LifecycleRule() {}

    /**
     * Evaluation order, ascending, unique within the policy. An image is claimed by the first
     * matching rule.
     */
    @JsonProperty(value = "priority", required = true)
    private Long priority;

    @JsonProperty("priority")
    public Long getPriority() {
      return priority;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "selection", required = true)
    private LifecycleSelection selection;

    @JsonProperty("selection")
    public LifecycleSelection getSelection() {
      return selection;
    }

    /**
     * The only action there is. A field rather than an implication so the document has room for a
     * future one without a policy written today meaning something different tomorrow.
     */
    @JsonProperty(value = "action", required = true)
    private LifecycleRuleAction action;

    @JsonProperty("action")
    public LifecycleRuleAction getAction() {
      return action;
    }
  }

  public static final class LifecycleSelection extends Model {
    public LifecycleSelection() {}

    /**
     * `tagged` requires a prefix or pattern. `any` may appear on at most one rule and must carry
     * the highest priority number.
     */
    @JsonProperty(value = "tag_status", required = true)
    private LifecycleSelectionTagStatus tag_status;

    @JsonProperty("tag_status")
    public LifecycleSelectionTagStatus getTagStatus() {
      return tag_status;
    }

    @JsonProperty(value = "tag_prefixes", required = false)
    private List<String> tag_prefixes;

    @JsonProperty("tag_prefixes")
    public List<String> getTagPrefixes() {
      return tag_prefixes;
    }

    /** A glob whose only wildcard is `*`. A bare `*` is refused. */
    @JsonProperty(value = "tag_patterns", required = false)
    private List<String> tag_patterns;

    @JsonProperty("tag_patterns")
    public List<String> getTagPatterns() {
      return tag_patterns;
    }

    /**
     * `image_count_more_than` keeps the N newest matching images. `since_image_pushed` expires
     * those older than N days. `since_image_pulled` expires those not pulled in N days, measuring a
     * never-pulled image from its push time — otherwise a never-pulled image would be immortal,
     * which is the opposite of what the rule is for.
     */
    @JsonProperty(value = "count_type", required = true)
    private LifecycleSelectionCountType count_type;

    @JsonProperty("count_type")
    public LifecycleSelectionCountType getCountType() {
      return count_type;
    }

    /** Required by the two `since_*` types, forbidden by the other. */
    @JsonProperty(value = "count_unit", required = false)
    private LifecycleSelectionCountUnit count_unit;

    @JsonProperty("count_unit")
    public LifecycleSelectionCountUnit getCountUnit() {
      return count_unit;
    }

    @JsonProperty(value = "count_number", required = true)
    private Long count_number;

    @JsonProperty("count_number")
    public Long getCountNumber() {
      return count_number;
    }
  }

  public static final class LifecycleSelectionTagStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleSelectionTagStatus(String value) {
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
      return other instanceof LifecycleSelectionTagStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleSelectionTagStatus TAGGED =
        new LifecycleSelectionTagStatus("tagged");
    public static final LifecycleSelectionTagStatus UNTAGGED =
        new LifecycleSelectionTagStatus("untagged");
    public static final LifecycleSelectionTagStatus ANY = new LifecycleSelectionTagStatus("any");
  }

  public static final class LifecycleSelectionCountType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleSelectionCountType(String value) {
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
      return other instanceof LifecycleSelectionCountType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleSelectionCountType IMAGE_COUNT_MORE_THAN =
        new LifecycleSelectionCountType("image_count_more_than");
    public static final LifecycleSelectionCountType SINCE_IMAGE_PUSHED =
        new LifecycleSelectionCountType("since_image_pushed");
    public static final LifecycleSelectionCountType SINCE_IMAGE_PULLED =
        new LifecycleSelectionCountType("since_image_pulled");
  }

  public static final class LifecycleSelectionCountUnit {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleSelectionCountUnit(String value) {
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
      return other instanceof LifecycleSelectionCountUnit v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleSelectionCountUnit DAYS = new LifecycleSelectionCountUnit("days");
  }

  public static final class LifecycleRuleAction {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleRuleAction(String value) {
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
      return other instanceof LifecycleRuleAction v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleRuleAction EXPIRE = new LifecycleRuleAction("expire");
  }

  public static final class RepositoryPolicyResponse extends Model {
    public RepositoryPolicyResponse() {}

    @JsonProperty(value = "policy", required = true)
    private RepositoryPolicyResponsePolicy policy;

    @JsonProperty("policy")
    public RepositoryPolicyResponsePolicy getPolicy() {
      return policy;
    }
  }

  public static final class RepositoryPolicyResponsePolicy extends Model {
    public RepositoryPolicyResponsePolicy() {}

    @JsonProperty(value = "document", required = true)
    private RepositoryPolicyDocument document;

    @JsonProperty("document")
    public RepositoryPolicyDocument getDocument() {
      return document;
    }

    @JsonProperty(value = "updated_at", required = false)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class RepositoryPolicyDocument extends Model {
    public RepositoryPolicyDocument() {}

    @JsonProperty(value = "version", required = true)
    private String version;

    @JsonProperty("version")
    public String getVersion() {
      return version;
    }

    @JsonProperty(value = "statements", required = true)
    private List<RepositoryPolicyDocumentStatementsItem> statements;

    @JsonProperty("statements")
    public List<RepositoryPolicyDocumentStatementsItem> getStatements() {
      return statements;
    }
  }

  public static final class RepositoryPolicyDocumentStatementsItem extends Model {
    public RepositoryPolicyDocumentStatementsItem() {}

    @JsonProperty(value = "sid", required = false)
    private String sid;

    @JsonProperty("sid")
    public String getSid() {
      return sid;
    }

    @JsonProperty(value = "effect", required = true)
    private RepositoryPolicyDocumentStatementsItemEffect effect;

    @JsonProperty("effect")
    public RepositoryPolicyDocumentStatementsItemEffect getEffect() {
      return effect;
    }

    /** Account CRNs, an org CRN (`crn:iam:::org/&lt;org-id&gt;`), or `*` for the public. */
    @JsonProperty(value = "principals", required = true)
    private List<String> principals;

    @JsonProperty("principals")
    public List<String> getPrincipals() {
      return principals;
    }

    /**
     * Must all be `registry:` actions. A repository's owner cannot grant `storage:GetObject` by
     * writing it here, and ignoring such a statement would leave a document that reads as a grant
     * and is not one.
     */
    @JsonProperty(value = "actions", required = true)
    private List<String> actions;

    @JsonProperty("actions")
    public List<String> getActions() {
      return actions;
    }

    /**
     * Must be this repository's own CRN, or the bare `*` — the same thing here, since the document
     * is only ever evaluated against this repository.
     */
    @JsonProperty(value = "resources", required = true)
    private List<String> resources;

    @JsonProperty("resources")
    public List<String> getResources() {
      return resources;
    }

    @JsonProperty(value = "conditions", required = false)
    private List<PolicyCondition> conditions;

    @JsonProperty("conditions")
    public List<PolicyCondition> getConditions() {
      return conditions;
    }
  }

  public static final class RepositoryPolicyDocumentStatementsItemEffect {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RepositoryPolicyDocumentStatementsItemEffect(String value) {
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
      return other instanceof RepositoryPolicyDocumentStatementsItemEffect v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RepositoryPolicyDocumentStatementsItemEffect ALLOW =
        new RepositoryPolicyDocumentStatementsItemEffect("allow");
    public static final RepositoryPolicyDocumentStatementsItemEffect DENY =
        new RepositoryPolicyDocumentStatementsItemEffect("deny");
  }

  public static final class PolicyCondition extends Model {
    public PolicyCondition() {}

    @JsonProperty(value = "operator", required = true)
    private String operator;

    @JsonProperty("operator")
    public String getOperator() {
      return operator;
    }

    @JsonProperty(value = "key", required = true)
    private String key;

    @JsonProperty("key")
    public String getKey() {
      return key;
    }

    @JsonProperty(value = "values", required = true)
    private List<String> values;

    @JsonProperty("values")
    public List<String> getValues() {
      return values;
    }

    @JsonProperty(value = "set_operator", required = false)
    private PolicyConditionSetOperator set_operator;

    @JsonProperty("set_operator")
    public PolicyConditionSetOperator getSetOperator() {
      return set_operator;
    }
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

  public static final class GetRetainedRegistryPresenceResponse extends Model {
    public GetRetainedRegistryPresenceResponse() {}

    @JsonProperty(value = "has_resources", required = true)
    private Boolean has_resources;

    @JsonProperty("has_resources")
    public Boolean getHasResources() {
      return has_resources;
    }
  }

  public static final class ListTagsQuery extends Model {
    public ListTagsQuery() {}

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListTagsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListTagsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class TagListResponse extends Model {
    public TagListResponse() {}

    @JsonProperty(value = "tags", required = true)
    private List<Tag> tags;

    @JsonProperty("tags")
    public List<Tag> getTags() {
      return tags;
    }

    @JsonProperty(value = "meta", required = false)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Tag extends Model {
    public Tag() {}

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "digest", required = true)
    private String digest;

    @JsonProperty("digest")
    public String getDigest() {
      return digest;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    /** When the tag last moved. Equal to created_at for a tag that never has. */
    @JsonProperty(value = "updated_at", required = true)
    private String updated_at;

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
      return updated_at;
    }
  }

  public static final class EncryptionConfigurationRequestInput extends Model {
    public EncryptionConfigurationRequestInput() {}

    /**
     * Required. Inferring it from whether `kms_key` is present would make "move me back to the
     * platform key" indistinguishable from a client that forgot the field.
     */
    @JsonProperty(value = "encryption_type", required = true)
    private EncryptionConfigurationRequestInputEncryptionType encryption_type;

    @JsonProperty("encryption_type")
    public EncryptionConfigurationRequestInputEncryptionType getEncryptionType() {
      return encryption_type;
    }

    public EncryptionConfigurationRequestInput withEncryptionType(
        EncryptionConfigurationRequestInputEncryptionType value) {
      this.encryption_type = value;
      return this;
    }

    /**
     * KMS key UUID, CRN or account-scoped name. Required with `kms`, and refused with
     * `platform_managed` rather than ignored — the two together are contradictory, and guessing
     * which was meant could leave content under a key the caller did not intend.
     */
    @JsonProperty(value = "kms_key", required = false)
    private String kms_key;

    @JsonProperty("kms_key")
    public String getKmsKey() {
      return kms_key;
    }

    public EncryptionConfigurationRequestInput withKmsKey(String value) {
      this.kms_key = value;
      return this;
    }
  }

  public static final class EncryptionConfigurationRequestInputEncryptionType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public EncryptionConfigurationRequestInputEncryptionType(String value) {
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
      return other instanceof EncryptionConfigurationRequestInputEncryptionType v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final EncryptionConfigurationRequestInputEncryptionType PLATFORM_MANAGED =
        new EncryptionConfigurationRequestInputEncryptionType("platform_managed");
    public static final EncryptionConfigurationRequestInputEncryptionType KMS =
        new EncryptionConfigurationRequestInputEncryptionType("kms");
  }

  public static final class LifecyclePolicyRequestInput extends Model {
    public LifecyclePolicyRequestInput() {}

    @JsonProperty(value = "rules", required = true)
    private List<LifecycleRuleInput> rules;

    @JsonProperty("rules")
    public List<LifecycleRuleInput> getRules() {
      return rules;
    }

    public LifecyclePolicyRequestInput withRules(List<LifecycleRuleInput> value) {
      this.rules = value;
      return this;
    }
  }

  public static final class LifecycleRuleInput extends Model {
    public LifecycleRuleInput() {}

    /**
     * Evaluation order, ascending, unique within the policy. An image is claimed by the first
     * matching rule.
     */
    @JsonProperty(value = "priority", required = true)
    private Long priority;

    @JsonProperty("priority")
    public Long getPriority() {
      return priority;
    }

    public LifecycleRuleInput withPriority(Long value) {
      this.priority = value;
      return this;
    }

    @JsonProperty(value = "description", required = false)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    public LifecycleRuleInput withDescription(String value) {
      this.description = value;
      return this;
    }

    @JsonProperty(value = "selection", required = true)
    private LifecycleSelectionInput selection;

    @JsonProperty("selection")
    public LifecycleSelectionInput getSelection() {
      return selection;
    }

    public LifecycleRuleInput withSelection(LifecycleSelectionInput value) {
      this.selection = value;
      return this;
    }

    /**
     * The only action there is. A field rather than an implication so the document has room for a
     * future one without a policy written today meaning something different tomorrow.
     */
    @JsonProperty(value = "action", required = true)
    private LifecycleRuleInputAction action;

    @JsonProperty("action")
    public LifecycleRuleInputAction getAction() {
      return action;
    }

    public LifecycleRuleInput withAction(LifecycleRuleInputAction value) {
      this.action = value;
      return this;
    }
  }

  public static final class LifecycleSelectionInput extends Model {
    public LifecycleSelectionInput() {}

    /**
     * `tagged` requires a prefix or pattern. `any` may appear on at most one rule and must carry
     * the highest priority number.
     */
    @JsonProperty(value = "tag_status", required = true)
    private LifecycleSelectionInputTagStatus tag_status;

    @JsonProperty("tag_status")
    public LifecycleSelectionInputTagStatus getTagStatus() {
      return tag_status;
    }

    public LifecycleSelectionInput withTagStatus(LifecycleSelectionInputTagStatus value) {
      this.tag_status = value;
      return this;
    }

    @JsonProperty(value = "tag_prefixes", required = false)
    private List<String> tag_prefixes;

    @JsonProperty("tag_prefixes")
    public List<String> getTagPrefixes() {
      return tag_prefixes;
    }

    public LifecycleSelectionInput withTagPrefixes(List<String> value) {
      this.tag_prefixes = value;
      return this;
    }

    /** A glob whose only wildcard is `*`. A bare `*` is refused. */
    @JsonProperty(value = "tag_patterns", required = false)
    private List<String> tag_patterns;

    @JsonProperty("tag_patterns")
    public List<String> getTagPatterns() {
      return tag_patterns;
    }

    public LifecycleSelectionInput withTagPatterns(List<String> value) {
      this.tag_patterns = value;
      return this;
    }

    /**
     * `image_count_more_than` keeps the N newest matching images. `since_image_pushed` expires
     * those older than N days. `since_image_pulled` expires those not pulled in N days, measuring a
     * never-pulled image from its push time — otherwise a never-pulled image would be immortal,
     * which is the opposite of what the rule is for.
     */
    @JsonProperty(value = "count_type", required = true)
    private LifecycleSelectionInputCountType count_type;

    @JsonProperty("count_type")
    public LifecycleSelectionInputCountType getCountType() {
      return count_type;
    }

    public LifecycleSelectionInput withCountType(LifecycleSelectionInputCountType value) {
      this.count_type = value;
      return this;
    }

    /** Required by the two `since_*` types, forbidden by the other. */
    @JsonProperty(value = "count_unit", required = false)
    private LifecycleSelectionInputCountUnit count_unit;

    @JsonProperty("count_unit")
    public LifecycleSelectionInputCountUnit getCountUnit() {
      return count_unit;
    }

    public LifecycleSelectionInput withCountUnit(LifecycleSelectionInputCountUnit value) {
      this.count_unit = value;
      return this;
    }

    @JsonProperty(value = "count_number", required = true)
    private Long count_number;

    @JsonProperty("count_number")
    public Long getCountNumber() {
      return count_number;
    }

    public LifecycleSelectionInput withCountNumber(Long value) {
      this.count_number = value;
      return this;
    }
  }

  public static final class LifecycleSelectionInputTagStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleSelectionInputTagStatus(String value) {
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
      return other instanceof LifecycleSelectionInputTagStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleSelectionInputTagStatus TAGGED =
        new LifecycleSelectionInputTagStatus("tagged");
    public static final LifecycleSelectionInputTagStatus UNTAGGED =
        new LifecycleSelectionInputTagStatus("untagged");
    public static final LifecycleSelectionInputTagStatus ANY =
        new LifecycleSelectionInputTagStatus("any");
  }

  public static final class LifecycleSelectionInputCountType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleSelectionInputCountType(String value) {
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
      return other instanceof LifecycleSelectionInputCountType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleSelectionInputCountType IMAGE_COUNT_MORE_THAN =
        new LifecycleSelectionInputCountType("image_count_more_than");
    public static final LifecycleSelectionInputCountType SINCE_IMAGE_PUSHED =
        new LifecycleSelectionInputCountType("since_image_pushed");
    public static final LifecycleSelectionInputCountType SINCE_IMAGE_PULLED =
        new LifecycleSelectionInputCountType("since_image_pulled");
  }

  public static final class LifecycleSelectionInputCountUnit {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleSelectionInputCountUnit(String value) {
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
      return other instanceof LifecycleSelectionInputCountUnit v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleSelectionInputCountUnit DAYS =
        new LifecycleSelectionInputCountUnit("days");
  }

  public static final class LifecycleRuleInputAction {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public LifecycleRuleInputAction(String value) {
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
      return other instanceof LifecycleRuleInputAction v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final LifecycleRuleInputAction EXPIRE = new LifecycleRuleInputAction("expire");
  }

  public static final class RepositoryPolicyRequestInput extends Model {
    public RepositoryPolicyRequestInput() {}

    @JsonProperty(value = "document", required = true)
    private RepositoryPolicyDocumentInput document;

    @JsonProperty("document")
    public RepositoryPolicyDocumentInput getDocument() {
      return document;
    }

    public RepositoryPolicyRequestInput withDocument(RepositoryPolicyDocumentInput value) {
      this.document = value;
      return this;
    }
  }

  public static final class RepositoryPolicyDocumentInput extends Model {
    public RepositoryPolicyDocumentInput() {}

    @JsonProperty(value = "version", required = true)
    private String version;

    @JsonProperty("version")
    public String getVersion() {
      return version;
    }

    public RepositoryPolicyDocumentInput withVersion(String value) {
      this.version = value;
      return this;
    }

    @JsonProperty(value = "statements", required = true)
    private List<RepositoryPolicyDocumentInputStatementsItem> statements;

    @JsonProperty("statements")
    public List<RepositoryPolicyDocumentInputStatementsItem> getStatements() {
      return statements;
    }

    public RepositoryPolicyDocumentInput withStatements(
        List<RepositoryPolicyDocumentInputStatementsItem> value) {
      this.statements = value;
      return this;
    }
  }

  public static final class RepositoryPolicyDocumentInputStatementsItem extends Model {
    public RepositoryPolicyDocumentInputStatementsItem() {}

    @JsonProperty(value = "sid", required = false)
    private String sid;

    @JsonProperty("sid")
    public String getSid() {
      return sid;
    }

    public RepositoryPolicyDocumentInputStatementsItem withSid(String value) {
      this.sid = value;
      return this;
    }

    @JsonProperty(value = "effect", required = true)
    private RepositoryPolicyDocumentInputStatementsItemEffect effect;

    @JsonProperty("effect")
    public RepositoryPolicyDocumentInputStatementsItemEffect getEffect() {
      return effect;
    }

    public RepositoryPolicyDocumentInputStatementsItem withEffect(
        RepositoryPolicyDocumentInputStatementsItemEffect value) {
      this.effect = value;
      return this;
    }

    /** Account CRNs, an org CRN (`crn:iam:::org/&lt;org-id&gt;`), or `*` for the public. */
    @JsonProperty(value = "principals", required = true)
    private List<String> principals;

    @JsonProperty("principals")
    public List<String> getPrincipals() {
      return principals;
    }

    public RepositoryPolicyDocumentInputStatementsItem withPrincipals(List<String> value) {
      this.principals = value;
      return this;
    }

    /**
     * Must all be `registry:` actions. A repository's owner cannot grant `storage:GetObject` by
     * writing it here, and ignoring such a statement would leave a document that reads as a grant
     * and is not one.
     */
    @JsonProperty(value = "actions", required = true)
    private List<String> actions;

    @JsonProperty("actions")
    public List<String> getActions() {
      return actions;
    }

    public RepositoryPolicyDocumentInputStatementsItem withActions(List<String> value) {
      this.actions = value;
      return this;
    }

    /**
     * Must be this repository's own CRN, or the bare `*` — the same thing here, since the document
     * is only ever evaluated against this repository.
     */
    @JsonProperty(value = "resources", required = true)
    private List<String> resources;

    @JsonProperty("resources")
    public List<String> getResources() {
      return resources;
    }

    public RepositoryPolicyDocumentInputStatementsItem withResources(List<String> value) {
      this.resources = value;
      return this;
    }

    @JsonProperty(value = "conditions", required = false)
    private List<PolicyConditionInput> conditions;

    @JsonProperty("conditions")
    public List<PolicyConditionInput> getConditions() {
      return conditions;
    }

    public RepositoryPolicyDocumentInputStatementsItem withConditions(
        List<PolicyConditionInput> value) {
      this.conditions = value;
      return this;
    }
  }

  public static final class RepositoryPolicyDocumentInputStatementsItemEffect {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public RepositoryPolicyDocumentInputStatementsItemEffect(String value) {
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
      return other instanceof RepositoryPolicyDocumentInputStatementsItemEffect v
          && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final RepositoryPolicyDocumentInputStatementsItemEffect ALLOW =
        new RepositoryPolicyDocumentInputStatementsItemEffect("allow");
    public static final RepositoryPolicyDocumentInputStatementsItemEffect DENY =
        new RepositoryPolicyDocumentInputStatementsItemEffect("deny");
  }

  public static final class PolicyConditionInput extends Model {
    public PolicyConditionInput() {}

    @JsonProperty(value = "operator", required = true)
    private String operator;

    @JsonProperty("operator")
    public String getOperator() {
      return operator;
    }

    public PolicyConditionInput withOperator(String value) {
      this.operator = value;
      return this;
    }

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

  public static final class LifecyclePreviewResponse extends Model {
    public LifecyclePreviewResponse() {}

    @JsonProperty(value = "preview", required = true)
    private LifecyclePreviewResponsePreview preview;

    @JsonProperty("preview")
    public LifecyclePreviewResponsePreview getPreview() {
      return preview;
    }
  }

  public static final class LifecyclePreviewResponsePreview extends Model {
    public LifecyclePreviewResponsePreview() {}

    @JsonProperty(value = "matches", required = true)
    private List<LifecyclePreviewResponsePreviewMatchesItem> matches;

    @JsonProperty("matches")
    public List<LifecyclePreviewResponsePreviewMatchesItem> getMatches() {
      return matches;
    }

    /**
     * How many images the repository holds, so 400 matches can be read against the 402 that exist.
     */
    @JsonProperty(value = "total_images", required = true)
    private Long total_images;

    @JsonProperty("total_images")
    public Long getTotalImages() {
      return total_images;
    }

    /**
     * What the expiry would reclaim: only layers no surviving image still references, each counted
     * once.
     */
    @JsonProperty(value = "size_bytes", required = true)
    private Long size_bytes;

    @JsonProperty("size_bytes")
    public Long getSizeBytes() {
      return size_bytes;
    }
  }

  public static final class LifecyclePreviewResponsePreviewMatchesItem extends Model {
    public LifecyclePreviewResponsePreviewMatchesItem() {}

    @JsonProperty(value = "digest", required = true)
    private String digest;

    @JsonProperty("digest")
    public String getDigest() {
      return digest;
    }

    @JsonProperty(value = "tags", required = false)
    private List<String> tags;

    @JsonProperty("tags")
    public List<String> getTags() {
      return tags;
    }

    @JsonProperty(value = "pushed_at", required = true)
    private String pushed_at;

    @JsonProperty("pushed_at")
    public String getPushedAt() {
      return pushed_at;
    }

    @JsonProperty(value = "last_pulled_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> last_pulled_at = JsonField.missing();

    @JsonProperty("last_pulled_at")
    public JsonField<String> getLastPulledAt() {
      return last_pulled_at;
    }

    /** Which rule claimed this image. */
    @JsonProperty(value = "rule_priority", required = true)
    private Long rule_priority;

    @JsonProperty("rule_priority")
    public Long getRulePriority() {
      return rule_priority;
    }
  }

  public static final class UpdatePullThroughCacheRuleRequestInput extends Model {
    public UpdatePullThroughCacheRuleRequestInput() {}

    @JsonProperty(value = "upstream_registry", required = false)
    private String upstream_registry;

    @JsonProperty("upstream_registry")
    public String getUpstreamRegistry() {
      return upstream_registry;
    }

    public UpdatePullThroughCacheRuleRequestInput withUpstreamRegistry(String value) {
      this.upstream_registry = value;
      return this;
    }

    @JsonProperty(value = "upstream_prefix", required = false)
    private String upstream_prefix;

    @JsonProperty("upstream_prefix")
    public String getUpstreamPrefix() {
      return upstream_prefix;
    }

    public UpdatePullThroughCacheRuleRequestInput withUpstreamPrefix(String value) {
      this.upstream_prefix = value;
      return this;
    }

    @JsonProperty(value = "upstream_username", required = false)
    private String upstream_username;

    @JsonProperty("upstream_username")
    public String getUpstreamUsername() {
      return upstream_username;
    }

    public UpdatePullThroughCacheRuleRequestInput withUpstreamUsername(String value) {
      this.upstream_username = value;
      return this;
    }

    @JsonProperty(value = "upstream_secret", required = false)
    private String upstream_secret;

    @JsonProperty("upstream_secret")
    public String getUpstreamSecret() {
      return upstream_secret;
    }

    public UpdatePullThroughCacheRuleRequestInput withUpstreamSecret(String value) {
      this.upstream_secret = value;
      return this;
    }
  }

  public static final class UpdateRepositoryRequestInput extends Model {
    public UpdateRepositoryRequestInput() {}

    @JsonProperty(value = "tag_mutability", required = false)
    private UpdateRepositoryRequestInputTagMutability tag_mutability;

    @JsonProperty("tag_mutability")
    public UpdateRepositoryRequestInputTagMutability getTagMutability() {
      return tag_mutability;
    }

    public UpdateRepositoryRequestInput withTagMutability(
        UpdateRepositoryRequestInputTagMutability value) {
      this.tag_mutability = value;
      return this;
    }

    @JsonProperty(value = "deletion_protection", required = false)
    private Boolean deletion_protection;

    @JsonProperty("deletion_protection")
    public Boolean getDeletionProtection() {
      return deletion_protection;
    }

    public UpdateRepositoryRequestInput withDeletionProtection(Boolean value) {
      this.deletion_protection = value;
      return this;
    }

    @JsonProperty(value = "tags", required = false)
    private Map<String, String> tags;

    @JsonProperty("tags")
    public Map<String, String> getTags() {
      return tags;
    }

    public UpdateRepositoryRequestInput withTags(Map<String, String> value) {
      this.tags = value;
      return this;
    }
  }

  public static final class UpdateRepositoryRequestInputTagMutability {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UpdateRepositoryRequestInputTagMutability(String value) {
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
      return other instanceof UpdateRepositoryRequestInputTagMutability v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final UpdateRepositoryRequestInputTagMutability MUTABLE =
        new UpdateRepositoryRequestInputTagMutability("mutable");
    public static final UpdateRepositoryRequestInputTagMutability IMMUTABLE =
        new UpdateRepositoryRequestInputTagMutability("immutable");
  }
}
