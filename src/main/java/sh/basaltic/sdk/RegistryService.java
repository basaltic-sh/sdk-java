package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Registry.AuthorizationTokenResponse;
import sh.basaltic.sdk.models.Registry.BatchDeleteImageRequestInput;
import sh.basaltic.sdk.models.Registry.BatchDeleteResult;
import sh.basaltic.sdk.models.Registry.CreatePullThroughCacheRuleRequestInput;
import sh.basaltic.sdk.models.Registry.CreateRepositoryRequestInput;
import sh.basaltic.sdk.models.Registry.DeleteRepositoryQuery;
import sh.basaltic.sdk.models.Registry.DescribeImagesQuery;
import sh.basaltic.sdk.models.Registry.DescribePullThroughCacheRulesQuery;
import sh.basaltic.sdk.models.Registry.DescribeRepositoriesQuery;
import sh.basaltic.sdk.models.Registry.EncryptionConfigurationRequestInput;
import sh.basaltic.sdk.models.Registry.EncryptionConfigurationResponse;
import sh.basaltic.sdk.models.Registry.GetRetainedRegistryPresenceResponse;
import sh.basaltic.sdk.models.Registry.ImageListResponse;
import sh.basaltic.sdk.models.Registry.ImageResponse;
import sh.basaltic.sdk.models.Registry.LifecyclePolicyRequestInput;
import sh.basaltic.sdk.models.Registry.LifecyclePolicyResponse;
import sh.basaltic.sdk.models.Registry.LifecyclePreviewResponse;
import sh.basaltic.sdk.models.Registry.ListTagsQuery;
import sh.basaltic.sdk.models.Registry.PullThroughCacheRuleListResponse;
import sh.basaltic.sdk.models.Registry.PullThroughCacheRuleResponse;
import sh.basaltic.sdk.models.Registry.RepositoryListResponse;
import sh.basaltic.sdk.models.Registry.RepositoryPolicyRequestInput;
import sh.basaltic.sdk.models.Registry.RepositoryPolicyResponse;
import sh.basaltic.sdk.models.Registry.RepositoryResponse;
import sh.basaltic.sdk.models.Registry.Tag;
import sh.basaltic.sdk.models.Registry.TagListResponse;
import sh.basaltic.sdk.models.Registry.UpdatePullThroughCacheRuleRequestInput;
import sh.basaltic.sdk.models.Registry.UpdateRepositoryRequestInput;

/** Typed registry API methods. */
public final class RegistryService {
  private final Transport transport;

  RegistryService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "batchDeleteImage",
          "POST",
          "/v1/repositories/{repository_id}/images/batch-delete",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "createPullThroughCacheRule",
          "POST",
          "/v1/pull-through-cache-rules",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "createRepository",
          "POST",
          "/v1/repositories",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "deleteEncryptionConfiguration",
          "DELETE",
          "/v1/encryption-configuration",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "deleteLifecyclePolicy",
          "DELETE",
          "/v1/repositories/{repository_id}/lifecycle-policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "deletePullThroughCacheRule",
          "DELETE",
          "/v1/pull-through-cache-rules/{prefix}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "deleteRepository",
          "DELETE",
          "/v1/repositories/{repository_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(Map.entry("force", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "deleteRepositoryPolicy",
          "DELETE",
          "/v1/repositories/{repository_id}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "describeImage",
          "GET",
          "/v1/repositories/{repository_id}/images/{image_reference}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "describeImages",
          "GET",
          "/v1/repositories/{repository_id}/images",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("tag_status", new Operation.Encoding("form", true)),
              Map.entry("tag_prefix", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "describePullThroughCacheRule",
          "GET",
          "/v1/pull-through-cache-rules/{prefix}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "describePullThroughCacheRules",
          "GET",
          "/v1/pull-through-cache-rules",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "describeRepositories",
          "GET",
          "/v1/repositories",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "describeRepository",
          "GET",
          "/v1/repositories/{repository_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "getAuthorizationToken",
          "POST",
          "/v1/authorization-token",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "getEncryptionConfiguration",
          "GET",
          "/v1/encryption-configuration",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "getLifecyclePolicy",
          "GET",
          "/v1/repositories/{repository_id}/lifecycle-policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "getRepositoryPolicy",
          "GET",
          "/v1/repositories/{repository_id}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "getRetainedRegistryPresence",
          "GET",
          "/v1/encryption-configuration/retained-data",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "listTags",
          "GET",
          "/v1/repositories/{repository_id}/tags",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "putEncryptionConfiguration",
          "PUT",
          "/v1/encryption-configuration",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "putLifecyclePolicy",
          "PUT",
          "/v1/repositories/{repository_id}/lifecycle-policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "setRepositoryPolicy",
          "PUT",
          "/v1/repositories/{repository_id}/policy",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_23 =
      new Operation(
          "startLifecyclePolicyPreview",
          "POST",
          "/v1/repositories/{repository_id}/lifecycle-policy/preview",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_24 =
      new Operation(
          "updatePullThroughCacheRule",
          "PATCH",
          "/v1/pull-through-cache-rules/{prefix}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_25 =
      new Operation(
          "updateRepository",
          "PATCH",
          "/v1/repositories/{repository_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Delete images */
  public Request<BatchDeleteResult> batchDeleteImage(
      String repository_id, BatchDeleteImageRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            body,
            null),
        new TypeReference<BatchDeleteResult>() {});
  }

  /** Create a pull-through cache rule */
  public Request<PullThroughCacheRuleResponse> createPullThroughCacheRule(
      CreatePullThroughCacheRuleRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<PullThroughCacheRuleResponse>() {});
  }

  /** Create a repository */
  public Request<RepositoryResponse> createRepository(CreateRepositoryRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<RepositoryResponse>() {});
  }

  /** Delete encryption configuration */
  public EmptyRequest deleteEncryptionConfiguration() {
    return new EmptyRequest(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(),
            null,
            null));
  }

  /** Delete the lifecycle policy */
  public EmptyRequest deleteLifecyclePolicy(String repository_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            null));
  }

  /** Delete a pull-through cache rule */
  public EmptyRequest deletePullThroughCacheRule(String prefix) {
    return new EmptyRequest(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("prefix", prefix)),
            null,
            null));
  }

  /** Delete a repository */
  public EmptyRequest deleteRepository(String repository_id, DeleteRepositoryQuery query) {
    return new EmptyRequest(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            query));
  }

  /** Execute with optional inputs omitted. */
  public EmptyRequest deleteRepository(String repository_id) {
    return deleteRepository(repository_id, null);
  }

  /** Delete the repository policy */
  public EmptyRequest deleteRepositoryPolicy(String repository_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            null));
  }

  /** Describe an image */
  public Request<ImageResponse> describeImage(String repository_id, String image_reference) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(
                Map.entry("repository_id", repository_id),
                Map.entry("image_reference", image_reference)),
            null,
            null),
        new TypeReference<ImageResponse>() {});
  }

  /** List images */
  public Request<ImageListResponse> describeImages(
      String repository_id, DescribeImagesQuery query) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            query),
        new TypeReference<ImageListResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<ImageListResponse> describeImages(String repository_id) {
    return describeImages(repository_id, null);
  }

  /** Get a pull-through cache rule */
  public Request<PullThroughCacheRuleResponse> describePullThroughCacheRule(String prefix) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("prefix", prefix)),
            null,
            null),
        new TypeReference<PullThroughCacheRuleResponse>() {});
  }

  /** List pull-through cache rules */
  public Request<PullThroughCacheRuleListResponse> describePullThroughCacheRules(
      DescribePullThroughCacheRulesQuery query) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<PullThroughCacheRuleListResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<PullThroughCacheRuleListResponse> describePullThroughCacheRules() {
    return describePullThroughCacheRules(null);
  }

  /** List repositories */
  public Request<RepositoryListResponse> describeRepositories(DescribeRepositoriesQuery query) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<RepositoryListResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<RepositoryListResponse> describeRepositories() {
    return describeRepositories(null);
  }

  /** Describe a repository */
  public Request<RepositoryResponse> describeRepository(String repository_id) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            null),
        new TypeReference<RepositoryResponse>() {});
  }

  /** Get a docker login credential */
  public Request<AuthorizationTokenResponse> getAuthorizationToken() {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(),
            null,
            null),
        new TypeReference<AuthorizationTokenResponse>() {});
  }

  /** Get the encryption configuration */
  public Request<EncryptionConfigurationResponse> getEncryptionConfiguration() {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(),
            null,
            null),
        new TypeReference<EncryptionConfigurationResponse>() {});
  }

  /** Get the lifecycle policy */
  public Request<LifecyclePolicyResponse> getLifecyclePolicy(String repository_id) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            null),
        new TypeReference<LifecyclePolicyResponse>() {});
  }

  /** Get the repository policy */
  public Request<RepositoryPolicyResponse> getRepositoryPolicy(String repository_id) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            null),
        new TypeReference<RepositoryPolicyResponse>() {});
  }

  /** Check retained registry data presence */
  public Request<GetRetainedRegistryPresenceResponse> getRetainedRegistryPresence() {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(),
            null,
            null),
        new TypeReference<GetRetainedRegistryPresenceResponse>() {});
  }

  /** List tags */
  public PagedRequest<TagListResponse, Tag> listTags(String repository_id, ListTagsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            null,
            query),
        new TypeReference<TagListResponse>() {},
        new TypeReference<Tag>() {},
        "tags");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<TagListResponse, Tag> listTags(String repository_id) {
    return listTags(repository_id, null);
  }

  /** Set the encryption configuration */
  public Request<EncryptionConfigurationResponse> putEncryptionConfiguration(
      EncryptionConfigurationRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<EncryptionConfigurationResponse>() {});
  }

  /** Set the lifecycle policy */
  public Request<LifecyclePolicyResponse> putLifecyclePolicy(
      String repository_id, LifecyclePolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            body,
            null),
        new TypeReference<LifecyclePolicyResponse>() {});
  }

  /** Set the repository policy */
  public Request<RepositoryPolicyResponse> setRepositoryPolicy(
      String repository_id, RepositoryPolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            body,
            null),
        new TypeReference<RepositoryPolicyResponse>() {});
  }

  /** Preview a lifecycle policy */
  public Request<LifecyclePreviewResponse> startLifecyclePolicyPreview(
      String repository_id, LifecyclePolicyRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            body,
            null),
        new TypeReference<LifecyclePreviewResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<LifecyclePreviewResponse> startLifecyclePolicyPreview(String repository_id) {
    return startLifecyclePolicyPreview(repository_id, null);
  }

  /** Update a pull-through cache rule */
  public Request<PullThroughCacheRuleResponse> updatePullThroughCacheRule(
      String prefix, UpdatePullThroughCacheRuleRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_24,
            Map.ofEntries(Map.entry("prefix", prefix)),
            body,
            null),
        new TypeReference<PullThroughCacheRuleResponse>() {});
  }

  /** Update repository settings */
  public Request<RepositoryResponse> updateRepository(
      String repository_id, UpdateRepositoryRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "registry",
            "https://registry.{region}.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("repository_id", repository_id)),
            body,
            null),
        new TypeReference<RepositoryResponse>() {});
  }
}
