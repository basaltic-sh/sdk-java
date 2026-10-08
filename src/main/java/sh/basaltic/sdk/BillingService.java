package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Billing.BillingProfile;
import sh.basaltic.sdk.models.Billing.BillingProfileInput;
import sh.basaltic.sdk.models.Billing.Credit;
import sh.basaltic.sdk.models.Billing.CreditListResponse;
import sh.basaltic.sdk.models.Billing.CurrentUsage;
import sh.basaltic.sdk.models.Billing.FiscalInvoice;
import sh.basaltic.sdk.models.Billing.GetInvoiceScope;
import sh.basaltic.sdk.models.Billing.Invoice;
import sh.basaltic.sdk.models.Billing.InvoiceListResponse;
import sh.basaltic.sdk.models.Billing.ListCreditsQuery;
import sh.basaltic.sdk.models.Billing.ListFiscalInvoicesQuery;
import sh.basaltic.sdk.models.Billing.ListFiscalInvoicesResponse;
import sh.basaltic.sdk.models.Billing.ListInvoicesQuery;
import sh.basaltic.sdk.models.Billing.ListPaymentsQuery;
import sh.basaltic.sdk.models.Billing.ListPricesQuery;
import sh.basaltic.sdk.models.Billing.ListTransactionsQuery;
import sh.basaltic.sdk.models.Billing.Payment;
import sh.basaltic.sdk.models.Billing.PaymentListResponse;
import sh.basaltic.sdk.models.Billing.Price;
import sh.basaltic.sdk.models.Billing.PriceListResponse;
import sh.basaltic.sdk.models.Billing.Transaction;
import sh.basaltic.sdk.models.Billing.TransactionListResponse;

/** Typed billing API methods. */
public final class BillingService {
  private final Transport transport;

  BillingService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "getBillingProfile",
          "GET",
          "/v1/profile",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "getCurrentUsage",
          "GET",
          "/v1/usage",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "getFiscalInvoiceXml",
          "GET",
          "/v1/fiscal-invoices/{document_id}/xml",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_3 =
      new Operation(
          "getInvoice",
          "GET",
          "/v1/invoices/{invoice_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "getInvoicePdf",
          "GET",
          "/v1/invoices/{invoice_id}/pdf",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_5 =
      new Operation(
          "listCredits",
          "GET",
          "/v1/credits",
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
          "listFiscalInvoices",
          "GET",
          "/v1/fiscal-invoices",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(Map.entry("invoice", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "listInvoices",
          "GET",
          "/v1/invoices",
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
  private static final Operation OP_8 =
      new Operation(
          "listPayments",
          "GET",
          "/v1/payments",
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
  private static final Operation OP_9 =
      new Operation(
          "listPrices",
          "GET",
          "/v1/prices",
          false,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("service", new Operation.Encoding("form", true)),
              Map.entry("resource_type", new Operation.Encoding("form", true)),
              Map.entry("sku", new Operation.Encoding("form", true)),
              Map.entry("family", new Operation.Encoding("form", true)),
              Map.entry("at", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "listTransactions",
          "GET",
          "/v1/transactions",
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
  private static final Operation OP_11 =
      new Operation(
          "updateBillingProfile",
          "PUT",
          "/v1/profile",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");

  /** Read the organization billing profile */
  public Request<BillingProfile> getBillingProfile() {
    return new Request<>(
        new Core(
            transport, "billing", "https://billing.basaltic.sh", OP_0, Map.ofEntries(), null, null),
        new TypeReference<BillingProfile>() {});
  }

  /** Get month-to-date usage total */
  public Request<CurrentUsage> getCurrentUsage() {
    return new Request<>(
        new Core(
            transport, "billing", "https://billing.basaltic.sh", OP_1, Map.ofEntries(), null, null),
        new TypeReference<CurrentUsage>() {});
  }

  /** Download issued NFS-e XML */
  public BinaryRequest getFiscalInvoiceXml(String document_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("document_id", document_id)),
            null,
            null));
  }

  /** Get an invoice with its line items */
  public Request<Invoice> getInvoice(String invoice_id) {
    return new Request<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("invoice_id", invoice_id)),
            null,
            null),
        new TypeReference<Invoice>() {});
  }

  /** Resolve by UUID, CRN, or an unambiguous name. */
  public Request<Invoice> getInvoiceByReference(String reference, GetInvoiceScope scope) {
    return Request.reference(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_3,
            Map.ofEntries(Map.entry("invoice_id", reference)),
            null,
            null),
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_7,
            Map.ofEntries(),
            null,
            scope),
        reference,
        false,
        null,
        "invoices",
        new TypeReference<Invoice>() {});
  }

  public Request<Invoice> getInvoiceByReference(String reference) {
    return getInvoiceByReference(reference, null);
  }

  /** Download an invoice as a PDF statement */
  public BinaryRequest getInvoicePdf(String invoice_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_4,
            Map.ofEntries(Map.entry("invoice_id", invoice_id)),
            null,
            null));
  }

  /** List credit grants */
  public PagedRequest<CreditListResponse, Credit> listCredits(ListCreditsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_5,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<CreditListResponse>() {},
        new TypeReference<Credit>() {},
        "credits");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<CreditListResponse, Credit> listCredits() {
    return listCredits(null);
  }

  /** List fiscal invoice issuance and delivery status */
  public PagedRequest<ListFiscalInvoicesResponse, FiscalInvoice> listFiscalInvoices(
      ListFiscalInvoicesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_6,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ListFiscalInvoicesResponse>() {},
        new TypeReference<FiscalInvoice>() {},
        "fiscal_documents");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ListFiscalInvoicesResponse, FiscalInvoice> listFiscalInvoices() {
    return listFiscalInvoices(null);
  }

  /** List invoices */
  public PagedRequest<InvoiceListResponse, Invoice> listInvoices(ListInvoicesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_7,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<InvoiceListResponse>() {},
        new TypeReference<Invoice>() {},
        "invoices");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<InvoiceListResponse, Invoice> listInvoices() {
    return listInvoices(null);
  }

  /** List invoice payments */
  public PagedRequest<PaymentListResponse, Payment> listPayments(ListPaymentsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_8,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<PaymentListResponse>() {},
        new TypeReference<Payment>() {},
        "payments");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PaymentListResponse, Payment> listPayments() {
    return listPayments(null);
  }

  /** List catalog prices */
  public PagedRequest<PriceListResponse, Price> listPrices(ListPricesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_9,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<PriceListResponse>() {},
        new TypeReference<Price>() {},
        "prices");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<PriceListResponse, Price> listPrices() {
    return listPrices(null);
  }

  /** List ledger transactions */
  public PagedRequest<TransactionListResponse, Transaction> listTransactions(
      ListTransactionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_10,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<TransactionListResponse>() {},
        new TypeReference<Transaction>() {},
        "transactions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<TransactionListResponse, Transaction> listTransactions() {
    return listTransactions(null);
  }

  /** Save organization billing details */
  public Request<BillingProfile> updateBillingProfile(BillingProfileInput body) {
    return new Request<>(
        new Core(
            transport,
            "billing",
            "https://billing.basaltic.sh",
            OP_11,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<BillingProfile>() {});
  }
}
