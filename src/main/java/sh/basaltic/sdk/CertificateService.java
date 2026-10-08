package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Certificate.Certificate2;
import sh.basaltic.sdk.models.Certificate.CertificateIssueRequestInput;
import sh.basaltic.sdk.models.Certificate.CertificateListResponse;
import sh.basaltic.sdk.models.Certificate.CertificateResponse;
import sh.basaltic.sdk.models.Certificate.CreateCertificateResponse;
import sh.basaltic.sdk.models.Certificate.GetCertificateScope;
import sh.basaltic.sdk.models.Certificate.ListCertificatesQuery;
import sh.basaltic.sdk.models.Certificate.MaterialResponse;

/** Typed certificate API methods. */
public final class CertificateService {
  private final Transport transport;

  CertificateService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "createCertificate",
          "POST",
          "/v1/certificates",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "deleteCertificate",
          "DELETE",
          "/v1/certificates/{certificate_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "getCertificate",
          "GET",
          "/v1/certificates/{certificate_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "getCertificateMaterial",
          "GET",
          "/v1/certificates/{certificate_id}/material",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "listCertificates",
          "GET",
          "/v1/certificates",
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
  private static final Operation OP_5 =
      new Operation(
          "revokeCertificate",
          "POST",
          "/v1/certificates/{certificate_id}/revoke",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");

  /** Create certificate */
  public Request<CreateCertificateResponse> createCertificate(CertificateIssueRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<CreateCertificateResponse>() {});
  }

  /** Delete certificate */
  public EmptyRequest deleteCertificate(String certificate_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("certificate_id", certificate_id)),
            null,
            null));
  }

  /** Get certificate */
  public Request<CertificateResponse> getCertificate(String certificate_id) {
    return new Request<>(
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("certificate_id", certificate_id)),
            null,
            null),
        new TypeReference<CertificateResponse>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Certificate2> getCertificateByReference(
      String reference, GetCertificateScope scope) {
    return Request.reference(
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("certificate_id", reference)),
            null,
            null),
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            null,
            scope),
        reference,
        true,
        "certificate",
        "certificates",
        new TypeReference<Certificate2>() {});
  }

  public Request<Certificate2> getCertificateByReference(String reference) {
    return getCertificateByReference(reference, null);
  }

  /** Fetch certificate material (leaf, chain, private key) */
  public Request<MaterialResponse> getCertificateMaterial(String certificate_id) {
    return new Request<>(
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("certificate_id", certificate_id)),
            null,
            null),
        new TypeReference<MaterialResponse>() {});
  }

  /** List certificates */
  public PagedRequest<CertificateListResponse, Certificate2> listCertificates(
      ListCertificatesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<CertificateListResponse>() {},
        new TypeReference<Certificate2>() {},
        "certificates");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<CertificateListResponse, Certificate2> listCertificates() {
    return listCertificates(null);
  }

  /** Revoke certificate */
  public Request<CertificateResponse> revokeCertificate(String certificate_id) {
    return new Request<>(
        new Core(
            transport,
            "certificate",
            "https://certificate.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(Map.entry("certificate_id", certificate_id)),
            null,
            null),
        new TypeReference<CertificateResponse>() {});
  }
}
