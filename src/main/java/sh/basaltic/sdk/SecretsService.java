package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Secrets.CreateSecretRequestInput;
import sh.basaltic.sdk.models.Secrets.DeleteSecretRequestInput;
import sh.basaltic.sdk.models.Secrets.GetSecretValueQuery;
import sh.basaltic.sdk.models.Secrets.ListSecretsQuery;
import sh.basaltic.sdk.models.Secrets.ListVersionsQuery;
import sh.basaltic.sdk.models.Secrets.PutSecretValueRequestInput;
import sh.basaltic.sdk.models.Secrets.Secret;
import sh.basaltic.sdk.models.Secrets.SecretListResponse;
import sh.basaltic.sdk.models.Secrets.SecretResponse;
import sh.basaltic.sdk.models.Secrets.SecretValueResponse;
import sh.basaltic.sdk.models.Secrets.SecretVersion;
import sh.basaltic.sdk.models.Secrets.UpdateSecretRequestInput;
import sh.basaltic.sdk.models.Secrets.VersionListResponse;
import sh.basaltic.sdk.models.Secrets.VersionResponse;

/** Typed secrets API methods. */
public final class SecretsService {
  private final Transport transport;

  SecretsService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "createSecret",
          "POST",
          "/v1/secrets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "deleteSecret",
          "DELETE",
          "/v1/secrets/{secret_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "describeSecret",
          "GET",
          "/v1/secrets/{secret_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "getSecretValue",
          "GET",
          "/v1/secrets/{secret_id}/value",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(Map.entry("version", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "listSecrets",
          "GET",
          "/v1/secrets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("name", new Operation.Encoding("form", true)),
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("include_deleted", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "listVersions",
          "GET",
          "/v1/secrets/{secret_id}/versions",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "putSecretValue",
          "POST",
          "/v1/secrets/{secret_id}/value",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "restoreSecret",
          "POST",
          "/v1/secrets/{secret_id}/restore",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "updateSecret",
          "PATCH",
          "/v1/secrets/{secret_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Create a new secret with an initial value */
  public Request<SecretResponse> createSecret(CreateSecretRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<SecretResponse>() {});
  }

  /** Schedule deletion (soft delete with recovery window) */
  public Request<SecretResponse> deleteSecret(String secret_id, DeleteSecretRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("secret_id", secret_id)),
            body,
            null),
        new TypeReference<SecretResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<SecretResponse> deleteSecret(String secret_id) {
    return deleteSecret(secret_id, null);
  }

  /** Describe a secret (no value) */
  public Request<SecretResponse> describeSecret(String secret_id) {
    return new Request<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("secret_id", secret_id)),
            null,
            null),
        new TypeReference<SecretResponse>() {});
  }

  /** Read the current value (or a specific version) */
  public Request<SecretValueResponse> getSecretValue(String secret_id, GetSecretValueQuery query) {
    return new Request<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("secret_id", secret_id)),
            null,
            query),
        new TypeReference<SecretValueResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<SecretValueResponse> getSecretValue(String secret_id) {
    return getSecretValue(secret_id, null);
  }

  /** List secrets */
  public PagedRequest<SecretListResponse, Secret> listSecrets(ListSecretsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<SecretListResponse>() {},
        new TypeReference<Secret>() {},
        "secrets");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SecretListResponse, Secret> listSecrets() {
    return listSecrets(null);
  }

  /** List versions */
  public PagedRequest<VersionListResponse, SecretVersion> listVersions(
      String secret_id, ListVersionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("secret_id", secret_id)),
            null,
            query),
        new TypeReference<VersionListResponse>() {},
        new TypeReference<SecretVersion>() {},
        "versions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<VersionListResponse, SecretVersion> listVersions(String secret_id) {
    return listVersions(secret_id, null);
  }

  /** Store a new version (becomes current) */
  public Request<VersionResponse> putSecretValue(
      String secret_id, PutSecretValueRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("secret_id", secret_id)),
            body,
            null),
        new TypeReference<VersionResponse>() {});
  }

  /** Restore a secret from the recovery window */
  public Request<SecretResponse> restoreSecret(String secret_id) {
    return new Request<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(Map.entry("secret_id", secret_id)),
            null,
            null),
        new TypeReference<SecretResponse>() {});
  }

  /** Update mutable metadata */
  public Request<SecretResponse> updateSecret(String secret_id, UpdateSecretRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "secrets",
            "https://secrets.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(Map.entry("secret_id", secret_id)),
            body,
            null),
        new TypeReference<SecretResponse>() {});
  }
}
