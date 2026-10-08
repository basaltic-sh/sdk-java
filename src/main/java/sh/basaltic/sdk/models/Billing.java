package sh.basaltic.sdk.models;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;
import sh.basaltic.sdk.JsonField;
import sh.basaltic.sdk.internal.Json;
import sh.basaltic.sdk.internal.Model;

/** Typed billing wire models. Unknown string enum values are retained. */
public final class Billing {

  private Billing() {}

  public static final class BillingProfile extends Model {
    public BillingProfile() {}

    @JsonProperty(value = "customer_type", required = false)
    private BillingProfileCustomerType customer_type;

    @JsonProperty("customer_type")
    public BillingProfileCustomerType getCustomerType() {
      return customer_type;
    }

    /** Full legal name of the individual or company. */
    @JsonProperty(value = "company_name", required = false)
    private String company_name;

    @JsonProperty("company_name")
    public String getCompanyName() {
      return company_name;
    }

    /** ISO 3166-1 alpha-2 country code. */
    @JsonProperty(value = "country", required = false)
    private String country;

    @JsonProperty("country")
    public String getCountry() {
      return country;
    }

    /**
     * CPF for a Brazilian individual or CNPJ for a Brazilian company. Check digits are validated.
     */
    @JsonProperty(value = "tax_id", required = false)
    private String tax_id;

    @JsonProperty("tax_id")
    public String getTaxId() {
      return tax_id;
    }

    /** Foreign identifier; not validated as a Brazilian document. */
    @JsonProperty(value = "foreign_tax_id", required = false)
    private String foreign_tax_id;

    @JsonProperty("foreign_tax_id")
    public String getForeignTaxId() {
      return foreign_tax_id;
    }

    /** Required for a foreign recipient without a tax identifier. */
    @JsonProperty(value = "no_tax_id_reason", required = false)
    private String no_tax_id_reason;

    @JsonProperty("no_tax_id_reason")
    public String getNoTaxIdReason() {
      return no_tax_id_reason;
    }

    /**
     * Billing email for fiscal invoice delivery. The onboarding form prefills this from the
     * signed-in user's email.
     */
    @JsonProperty(value = "email", required = false)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    @JsonProperty(value = "phone", required = false)
    private String phone;

    @JsonProperty("phone")
    public String getPhone() {
      return phone;
    }

    @JsonProperty(value = "street_name", required = false)
    private String street_name;

    @JsonProperty("street_name")
    public String getStreetName() {
      return street_name;
    }

    @JsonProperty(value = "street_number", required = false)
    private String street_number;

    @JsonProperty("street_number")
    public String getStreetNumber() {
      return street_number;
    }

    @JsonProperty(value = "complement", required = false)
    private String complement;

    @JsonProperty("complement")
    public String getComplement() {
      return complement;
    }

    @JsonProperty(value = "neighborhood", required = false)
    private String neighborhood;

    @JsonProperty("neighborhood")
    public String getNeighborhood() {
      return neighborhood;
    }

    @JsonProperty(value = "city", required = false)
    private String city;

    @JsonProperty("city")
    public String getCity() {
      return city;
    }

    /** Seven-digit IBGE municipality code, required for a Brazilian recipient. */
    @JsonProperty(value = "municipality_code", required = false)
    private String municipality_code;

    @JsonProperty("municipality_code")
    public String getMunicipalityCode() {
      return municipality_code;
    }

    /** Two-letter UF for Brazil; free-form state/province abroad. */
    @JsonProperty(value = "state", required = false)
    private String state;

    @JsonProperty("state")
    public String getState() {
      return state;
    }

    /** Eight-digit CEP for Brazil; optional international postal code abroad. */
    @JsonProperty(value = "postal_code", required = false)
    private String postal_code;

    @JsonProperty("postal_code")
    public String getPostalCode() {
      return postal_code;
    }

    @JsonProperty(value = "ready", required = false)
    private Boolean ready;

    @JsonProperty("ready")
    public Boolean getReady() {
      return ready;
    }

    @JsonProperty(value = "missing_fields", required = false)
    private List<String> missing_fields;

    @JsonProperty("missing_fields")
    public List<String> getMissingFields() {
      return missing_fields;
    }
  }

  public static final class BillingProfileCustomerType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public BillingProfileCustomerType(String value) {
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
      return other instanceof BillingProfileCustomerType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final BillingProfileCustomerType VALUE = new BillingProfileCustomerType("");
    public static final BillingProfileCustomerType INDIVIDUAL =
        new BillingProfileCustomerType("individual");
    public static final BillingProfileCustomerType COMPANY =
        new BillingProfileCustomerType("company");
  }

  public static final class CurrentUsage extends Model {
    public CurrentUsage() {}

    /** Unbilled usage accrued this UTC month, 2-decimal string. */
    @JsonProperty(value = "amount", required = true)
    private String amount;

    @JsonProperty("amount")
    public String getAmount() {
      return amount;
    }

    @JsonProperty(value = "period_start", required = true)
    private String period_start;

    @JsonProperty("period_start")
    public String getPeriodStart() {
      return period_start;
    }

    /** Per-SKU breakdown, ordered by cost. */
    @JsonProperty(value = "items", required = true)
    private List<UsageLine> items;

    @JsonProperty("items")
    public List<UsageLine> getItems() {
      return items;
    }
  }

  public static final class UsageLine extends Model {
    public UsageLine() {}

    @JsonProperty(value = "sku", required = true)
    private String sku;

    @JsonProperty("sku")
    public String getSku() {
      return sku;
    }

    @JsonProperty(value = "description", required = true)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "quantity", required = true)
    private String quantity;

    @JsonProperty("quantity")
    public String getQuantity() {
      return quantity;
    }

    @JsonProperty(value = "unit", required = true)
    private String unit;

    @JsonProperty("unit")
    public String getUnit() {
      return unit;
    }

    /** Accrued cost at 4-decimal precision (sub-centavo lines stay visible mid-month). */
    @JsonProperty(value = "amount", required = true)
    private String amount;

    @JsonProperty("amount")
    public String getAmount() {
      return amount;
    }
  }

  public static final class Invoice extends Model {
    public Invoice() {}

    /** Global organization-scoped invoice identity. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "invoice_number", required = true)
    private String invoice_number;

    @JsonProperty("invoice_number")
    public String getInvoiceNumber() {
      return invoice_number;
    }

    /** First day of the billed UTC month. */
    @JsonProperty(value = "period_start", required = true)
    private String period_start;

    @JsonProperty("period_start")
    public String getPeriodStart() {
      return period_start;
    }

    /** Exclusive end (first day of the following month). */
    @JsonProperty(value = "period_end", required = true)
    private String period_end;

    @JsonProperty("period_end")
    public String getPeriodEnd() {
      return period_end;
    }

    @JsonProperty(value = "subtotal", required = true)
    private String subtotal;

    @JsonProperty("subtotal")
    public String getSubtotal() {
      return subtotal;
    }

    @JsonProperty(value = "credits_applied", required = true)
    private String credits_applied;

    @JsonProperty("credits_applied")
    public String getCreditsApplied() {
      return credits_applied;
    }

    @JsonProperty(value = "total", required = true)
    private String total;

    @JsonProperty("total")
    public String getTotal() {
      return total;
    }

    @JsonProperty(value = "currency", required = true)
    private String currency;

    @JsonProperty("currency")
    public String getCurrency() {
      return currency;
    }

    /** Confirmed refunds less failed-refund reversals, in BRL. */
    @JsonProperty(value = "refunded_amount", required = true)
    private String refunded_amount;

    @JsonProperty("refunded_amount")
    public String getRefundedAmount() {
      return refunded_amount;
    }

    /** Dispute principal withdrawn less funds reinstated; excludes provider fees. */
    @JsonProperty(value = "disputed_amount", required = true)
    private String disputed_amount;

    @JsonProperty("disputed_amount")
    public String getDisputedAmount() {
      return disputed_amount;
    }

    @JsonProperty(value = "status", required = true)
    private InvoiceStatus status;

    @JsonProperty("status")
    public InvoiceStatus getStatus() {
      return status;
    }

    @JsonProperty(value = "issued_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> issued_at = JsonField.missing();

    @JsonProperty("issued_at")
    public JsonField<String> getIssuedAt() {
      return issued_at;
    }

    @JsonProperty(value = "due_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> due_at = JsonField.missing();

    @JsonProperty("due_at")
    public JsonField<String> getDueAt() {
      return due_at;
    }

    @JsonProperty(value = "paid_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> paid_at = JsonField.missing();

    @JsonProperty("paid_at")
    public JsonField<String> getPaidAt() {
      return paid_at;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }

    /**
     * Path of the PDF statement, rendered on demand by GET /v1/invoices/{invoice_id}/pdf under the
     * same authorization as this document.
     */
    @JsonProperty(value = "pdf_url", required = false)
    private String pdf_url;

    @JsonProperty("pdf_url")
    public String getPdfUrl() {
      return pdf_url;
    }

    /** Line items; present only on the detail endpoint. */
    @JsonProperty(value = "items", required = false)
    private List<InvoiceItem> items;

    @JsonProperty("items")
    public List<InvoiceItem> getItems() {
      return items;
    }
  }

  public static final class InvoiceStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InvoiceStatus(String value) {
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
      return other instanceof InvoiceStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InvoiceStatus OPEN = new InvoiceStatus("open");
    public static final InvoiceStatus PAID = new InvoiceStatus("paid");
    public static final InvoiceStatus PAST_DUE = new InvoiceStatus("past_due");
    public static final InvoiceStatus UNCOLLECTIBLE = new InvoiceStatus("uncollectible");
    public static final InvoiceStatus VOID = new InvoiceStatus("void");
  }

  public static final class InvoiceItem extends Model {
    public InvoiceItem() {}

    @JsonProperty(value = "kind", required = true)
    private InvoiceItemKind kind;

    @JsonProperty("kind")
    public InvoiceItemKind getKind() {
      return kind;
    }

    @JsonProperty(value = "sku", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> sku = JsonField.missing();

    @JsonProperty("sku")
    public JsonField<String> getSku() {
      return sku;
    }

    @JsonProperty(value = "description", required = true)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "quantity", required = true)
    private String quantity;

    @JsonProperty("quantity")
    public String getQuantity() {
      return quantity;
    }

    @JsonProperty(value = "unit", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> unit = JsonField.missing();

    @JsonProperty("unit")
    public JsonField<String> getUnit() {
      return unit;
    }

    @JsonProperty(value = "unit_price", required = true)
    private String unit_price;

    @JsonProperty("unit_price")
    public String getUnitPrice() {
      return unit_price;
    }

    /** Rounded line total; negative for credit lines. */
    @JsonProperty(value = "amount", required = true)
    private String amount;

    @JsonProperty("amount")
    public String getAmount() {
      return amount;
    }
  }

  public static final class InvoiceItemKind {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public InvoiceItemKind(String value) {
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
      return other instanceof InvoiceItemKind v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final InvoiceItemKind USAGE = new InvoiceItemKind("usage");
    public static final InvoiceItemKind CREDIT = new InvoiceItemKind("credit");
  }

  public static final class GetInvoiceScope extends Model {
    public GetInvoiceScope() {}

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public GetInvoiceScope withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class ListCreditsQuery extends Model {
    public ListCreditsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListCreditsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListCreditsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListCreditsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class CreditListResponse extends Model {
    public CreditListResponse() {}

    @JsonProperty(value = "credits", required = true)
    private List<Credit> credits;

    @JsonProperty("credits")
    public List<Credit> getCredits() {
      return credits;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Credit extends Model {
    public Credit() {}

    /** Global organization-scoped credit identity. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "source", required = true)
    private CreditSource source;

    @JsonProperty("source")
    public CreditSource getSource() {
      return source;
    }

    @JsonProperty(value = "description", required = true)
    private String description;

    @JsonProperty("description")
    public String getDescription() {
      return description;
    }

    @JsonProperty(value = "amount", required = true)
    private String amount;

    @JsonProperty("amount")
    public String getAmount() {
      return amount;
    }

    @JsonProperty(value = "remaining", required = true)
    private String remaining;

    @JsonProperty("remaining")
    public String getRemaining() {
      return remaining;
    }

    @JsonProperty(value = "expires_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> expires_at = JsonField.missing();

    @JsonProperty("expires_at")
    public JsonField<String> getExpiresAt() {
      return expires_at;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class CreditSource {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public CreditSource(String value) {
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
      return other instanceof CreditSource v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final CreditSource PROMO = new CreditSource("promo");
    public static final CreditSource COUPON = new CreditSource("coupon");
    public static final CreditSource ADJUSTMENT = new CreditSource("adjustment");
    public static final CreditSource MIGRATION = new CreditSource("migration");
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

  public static final class ListFiscalInvoicesQuery extends Model {
    public ListFiscalInvoicesQuery() {}

    @JsonProperty(value = "invoice", required = false)
    private String invoice;

    @JsonProperty("invoice")
    public String getInvoice() {
      return invoice;
    }

    public ListFiscalInvoicesQuery withInvoice(String value) {
      this.invoice = value;
      return this;
    }
  }

  public static final class ListFiscalInvoicesResponse extends Model {
    public ListFiscalInvoicesResponse() {}

    @JsonProperty(value = "fiscal_documents", required = true)
    private List<FiscalInvoice> fiscal_documents;

    @JsonProperty("fiscal_documents")
    public List<FiscalInvoice> getFiscalDocuments() {
      return fiscal_documents;
    }
  }

  public static final class FiscalInvoice extends Model {
    public FiscalInvoice() {}

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    @JsonProperty(value = "organization_id", required = true)
    private String organization_id;

    @JsonProperty("organization_id")
    public String getOrganizationId() {
      return organization_id;
    }

    @JsonProperty(value = "payment_id", required = true)
    private String payment_id;

    @JsonProperty("payment_id")
    public String getPaymentId() {
      return payment_id;
    }

    @JsonProperty(value = "invoice_id", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> invoice_id = JsonField.missing();

    @JsonProperty("invoice_id")
    public JsonField<String> getInvoiceId() {
      return invoice_id;
    }

    /** Actual amount received in BRL, not the billing invoice total. */
    @JsonProperty(value = "amount", required = true)
    private String amount;

    @JsonProperty("amount")
    public String getAmount() {
      return amount;
    }

    @JsonProperty(value = "status", required = true)
    private FiscalInvoiceStatus status;

    @JsonProperty("status")
    public FiscalInvoiceStatus getStatus() {
      return status;
    }

    /**
     * Separate delivery state. Queued means durably accepted by the internal email service; it does
     * not assert recipient delivery.
     */
    @JsonProperty(value = "email_status", required = true)
    private FiscalInvoiceEmailStatus email_status;

    @JsonProperty("email_status")
    public FiscalInvoiceEmailStatus getEmailStatus() {
      return email_status;
    }

    /** Sanitized operational error or municipal rejection codes. */
    @JsonProperty(value = "last_error", required = false)
    private String last_error;

    @JsonProperty("last_error")
    public String getLastError() {
      return last_error;
    }

    @JsonProperty(value = "attempts", required = true)
    private Long attempts;

    @JsonProperty("attempts")
    public Long getAttempts() {
      return attempts;
    }

    @JsonProperty(value = "number", required = false)
    private String number;

    @JsonProperty("number")
    public String getNumber() {
      return number;
    }

    @JsonProperty(value = "verification_code", required = false)
    private String verification_code;

    @JsonProperty("verification_code")
    public String getVerificationCode() {
      return verification_code;
    }

    /** Municipal view/print link available after issuance. */
    @JsonProperty(value = "url", required = false)
    private String url;

    @JsonProperty("url")
    public String getUrl() {
      return url;
    }

    @JsonProperty(value = "issued_at", required = false)
    private String issued_at;

    @JsonProperty("issued_at")
    public String getIssuedAt() {
      return issued_at;
    }

    /**
     * Refunds preserve the fiscal document and require operator review; cancellation is never
     * inferred automatically.
     */
    @JsonProperty(value = "requires_review", required = true)
    private Boolean requires_review;

    @JsonProperty("requires_review")
    public Boolean getRequiresReview() {
      return requires_review;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class FiscalInvoiceStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FiscalInvoiceStatus(String value) {
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
      return other instanceof FiscalInvoiceStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FiscalInvoiceStatus QUEUED = new FiscalInvoiceStatus("queued");
    public static final FiscalInvoiceStatus WAITING_DETAILS =
        new FiscalInvoiceStatus("waiting_details");
    public static final FiscalInvoiceStatus RETRYING = new FiscalInvoiceStatus("retrying");
    public static final FiscalInvoiceStatus REJECTED = new FiscalInvoiceStatus("rejected");
    public static final FiscalInvoiceStatus ISSUED = new FiscalInvoiceStatus("issued");
    public static final FiscalInvoiceStatus REVIEW_REQUIRED =
        new FiscalInvoiceStatus("review_required");
  }

  public static final class FiscalInvoiceEmailStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public FiscalInvoiceEmailStatus(String value) {
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
      return other instanceof FiscalInvoiceEmailStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final FiscalInvoiceEmailStatus PENDING = new FiscalInvoiceEmailStatus("pending");
    public static final FiscalInvoiceEmailStatus QUEUED = new FiscalInvoiceEmailStatus("queued");
  }

  public static final class ListInvoicesQuery extends Model {
    public ListInvoicesQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListInvoicesQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListInvoicesQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListInvoicesQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class InvoiceListResponse extends Model {
    public InvoiceListResponse() {}

    @JsonProperty(value = "invoices", required = true)
    private List<Invoice> invoices;

    @JsonProperty("invoices")
    public List<Invoice> getInvoices() {
      return invoices;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class ListPaymentsQuery extends Model {
    public ListPaymentsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListPaymentsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListPaymentsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListPaymentsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class PaymentListResponse extends Model {
    public PaymentListResponse() {}

    @JsonProperty(value = "payments", required = true)
    private List<Payment> payments;

    @JsonProperty("payments")
    public List<Payment> getPayments() {
      return payments;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Payment extends Model {
    public Payment() {}

    /** Global organization-scoped payment identity. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Current invoice list shape, without items; null when the invoice has been deleted. */
    @JsonProperty(value = "invoice", required = true)
    private PaymentInvoice invoice;

    @JsonProperty("invoice")
    public PaymentInvoice getInvoice() {
      return invoice;
    }

    @JsonProperty(value = "amount", required = true)
    private String amount;

    @JsonProperty("amount")
    public String getAmount() {
      return amount;
    }

    /** Confirmed refunds less failed-refund reversals, in BRL. */
    @JsonProperty(value = "refunded_amount", required = true)
    private String refunded_amount;

    @JsonProperty("refunded_amount")
    public String getRefundedAmount() {
      return refunded_amount;
    }

    /** Dispute principal withdrawn less funds reinstated; excludes provider fees. */
    @JsonProperty(value = "disputed_amount", required = true)
    private String disputed_amount;

    @JsonProperty("disputed_amount")
    public String getDisputedAmount() {
      return disputed_amount;
    }

    /**
     * Settled receipt less refunds and disputed funds. Zero for an unsettled attempt; may be
     * negative if the provider has withdrawn overlapping reversals. Does not change invoice
     * collection status.
     */
    @JsonProperty(value = "retained_amount", required = true)
    private String retained_amount;

    @JsonProperty("retained_amount")
    public String getRetainedAmount() {
      return retained_amount;
    }

    @JsonProperty(value = "status", required = true)
    private PaymentStatus status;

    @JsonProperty("status")
    public PaymentStatus getStatus() {
      return status;
    }

    /** 1-based dunning attempt this payment row belongs to. */
    @JsonProperty(value = "attempt", required = true)
    private Long attempt;

    @JsonProperty("attempt")
    public Long getAttempt() {
      return attempt;
    }

    @JsonProperty(value = "completed_at", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> completed_at = JsonField.missing();

    @JsonProperty("completed_at")
    public JsonField<String> getCompletedAt() {
      return completed_at;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class PaymentInvoice {
    private final JsonNode value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PaymentInvoice(JsonNode value) {
      this.value = Objects.requireNonNull(value).deepCopy();
    }

    @JsonValue
    public JsonNode json() {
      return value.deepCopy();
    }

    @Override
    public String toString() {
      return "PaymentInvoice{[REDACTED]}";
    }

    public static PaymentInvoice ofVariant1(Invoice value) {
      Model.validate(value);
      return new PaymentInvoice(Json.tree(value));
    }

    public Optional<Invoice> asVariant1() {
      try {
        Invoice result = Json.convert(value, new TypeReference<Invoice>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }

    public static PaymentInvoice ofVariant2(Map<String, JsonNode> value) {
      Model.validate(value);
      return new PaymentInvoice(Json.tree(value));
    }

    public Optional<Map<String, JsonNode>> asVariant2() {
      try {
        Map<String, JsonNode> result =
            Json.convert(value, new TypeReference<Map<String, JsonNode>>() {});
        Model.validate(result);
        return Optional.ofNullable(result);
      } catch (sh.basaltic.sdk.SdkException e) {
        return Optional.empty();
      }
    }
  }

  public static final class PaymentStatus {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public PaymentStatus(String value) {
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
      return other instanceof PaymentStatus v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final PaymentStatus PENDING = new PaymentStatus("pending");
    public static final PaymentStatus PROCESSING = new PaymentStatus("processing");
    public static final PaymentStatus SUCCEEDED = new PaymentStatus("succeeded");
    public static final PaymentStatus FAILED = new PaymentStatus("failed");
    public static final PaymentStatus REFUNDED = new PaymentStatus("refunded");
  }

  public static final class ListPricesQuery extends Model {
    public ListPricesQuery() {}

    @JsonProperty(value = "service", required = false)
    private String service;

    @JsonProperty("service")
    public String getService() {
      return service;
    }

    public ListPricesQuery withService(String value) {
      this.service = value;
      return this;
    }

    @JsonProperty(value = "resource_type", required = false)
    private String resource_type;

    @JsonProperty("resource_type")
    public String getResourceType() {
      return resource_type;
    }

    public ListPricesQuery withResourceType(String value) {
      this.resource_type = value;
      return this;
    }

    @JsonProperty(value = "sku", required = false)
    private String sku;

    @JsonProperty("sku")
    public String getSku() {
      return sku;
    }

    public ListPricesQuery withSku(String value) {
      this.sku = value;
      return this;
    }

    @JsonProperty(value = "family", required = false)
    private String family;

    @JsonProperty("family")
    public String getFamily() {
      return family;
    }

    public ListPricesQuery withFamily(String value) {
      this.family = value;
      return this;
    }

    @JsonProperty(value = "at", required = false)
    private String at;

    @JsonProperty("at")
    public String getAt() {
      return at;
    }

    public ListPricesQuery withAt(String value) {
      this.at = value;
      return this;
    }
  }

  public static final class PriceListResponse extends Model {
    public PriceListResponse() {}

    @JsonProperty(value = "prices", required = true)
    private List<Price> prices;

    @JsonProperty("prices")
    public List<Price> getPrices() {
      return prices;
    }

    /**
     * The instant the catalog was read as of — the `at` that was asked for, or the server's clock
     * when none was.
     */
    @JsonProperty(value = "as_of", required = true)
    private String as_of;

    @JsonProperty("as_of")
    public String getAsOf() {
      return as_of;
    }
  }

  public static final class Price extends Model {
    public Price() {}

    /**
     * Stable catalog key, `{service}.{resource_type}.{variant}`. This is the public identity of a
     * price — the row id is not published.
     */
    @JsonProperty(value = "sku", required = true)
    private String sku;

    @JsonProperty("sku")
    public String getSku() {
      return sku;
    }

    /** Which service bills this SKU. */
    @JsonProperty(value = "service", required = true)
    private String service;

    @JsonProperty("service")
    public String getService() {
      return service;
    }

    @JsonProperty(value = "resource_type", required = true)
    private String resource_type;

    @JsonProperty("resource_type")
    public String getResourceType() {
      return resource_type;
    }

    /** Display name. For compute SKUs this is the flavor name. */
    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty("name")
    public String getName() {
      return name;
    }

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    /** What one unit of `unit_price` buys. */
    @JsonProperty(value = "unit", required = true)
    private String unit;

    @JsonProperty("unit")
    public String getUnit() {
      return unit;
    }

    /** Price for one `unit`, as an exact decimal string. */
    @JsonProperty(value = "unit_price", required = true)
    private String unit_price;

    @JsonProperty("unit_price")
    public String getUnitPrice() {
      return unit_price;
    }

    @JsonProperty(value = "currency", required = true)
    private String currency;

    @JsonProperty("currency")
    public String getCurrency() {
      return currency;
    }

    /**
     * Extra facts about the SKU — `class`, `family`, `vcpus`, `memory_gb`, `storage_type`, …
     * `family` separates the managed products (load balancer replicas, database cluster nodes) from
     * the general compute flavors they share a `resource_type` with.
     */
    @JsonProperty(value = "metadata", required = true)
    private Map<String, JsonNode> metadata;

    @JsonProperty("metadata")
    public Map<String, JsonNode> getMetadata() {
      return metadata;
    }
  }

  public static final class ListTransactionsQuery extends Model {
    public ListTransactionsQuery() {}

    @JsonProperty(value = "crn", required = false)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    public ListTransactionsQuery withCrn(String value) {
      this.crn = value;
      return this;
    }

    @JsonProperty(value = "marker", required = false)
    private String marker;

    @JsonProperty("marker")
    public String getMarker() {
      return marker;
    }

    public ListTransactionsQuery withMarker(String value) {
      this.marker = value;
      return this;
    }

    @JsonProperty(value = "limit", required = false)
    private Long limit;

    @JsonProperty("limit")
    public Long getLimit() {
      return limit;
    }

    public ListTransactionsQuery withLimit(Long value) {
      this.limit = value;
      return this;
    }
  }

  public static final class TransactionListResponse extends Model {
    public TransactionListResponse() {}

    @JsonProperty(value = "transactions", required = true)
    private List<Transaction> transactions;

    @JsonProperty("transactions")
    public List<Transaction> getTransactions() {
      return transactions;
    }

    @JsonProperty(value = "meta", required = true)
    private PaginationMeta meta;

    @JsonProperty("meta")
    public PaginationMeta getMeta() {
      return meta;
    }
  }

  public static final class Transaction extends Model {
    public Transaction() {}

    /** Global organization-scoped transaction identity. */
    @JsonProperty(value = "crn", required = true)
    private String crn;

    @JsonProperty("crn")
    public String getCrn() {
      return crn;
    }

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty("id")
    public String getId() {
      return id;
    }

    /** Ledger entry type. */
    @JsonProperty(value = "type", required = true)
    private TransactionType type;

    @JsonProperty("type")
    public TransactionType getType() {
      return type;
    }

    /** Always positive; the direction lives in the type. */
    @JsonProperty(value = "amount", required = true)
    private String amount;

    @JsonProperty("amount")
    public String getAmount() {
      return amount;
    }

    @JsonProperty(value = "description", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> description = JsonField.missing();

    @JsonProperty("description")
    public JsonField<String> getDescription() {
      return description;
    }

    /**
     * Organization-scoped reference to the ledger entry's target: crn:billing:::invoice/&lt;id&gt;,
     * crn:billing:::payment/&lt;id&gt;, or crn:billing:::credit/&lt;id&gt; for a credit grant. Pass
     * this CRN to the corresponding collection's crn filter within the authenticated organization.
     * Null for manual entries, unsupported reference types, or missing references.
     */
    @JsonProperty(value = "reference", required = false)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private JsonField<String> reference = JsonField.missing();

    @JsonProperty("reference")
    public JsonField<String> getReference() {
      return reference;
    }

    @JsonProperty(value = "created_at", required = true)
    private String created_at;

    @JsonProperty("created_at")
    public String getCreatedAt() {
      return created_at;
    }
  }

  public static final class TransactionType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TransactionType(String value) {
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
      return other instanceof TransactionType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final TransactionType PAYMENT = new TransactionType("payment");
    public static final TransactionType REFUND = new TransactionType("refund");
    public static final TransactionType REFUND_REVERSAL = new TransactionType("refund_reversal");
    public static final TransactionType DISPUTE = new TransactionType("dispute");
    public static final TransactionType DISPUTE_REVERSAL = new TransactionType("dispute_reversal");
    public static final TransactionType ADJUSTMENT = new TransactionType("adjustment");
    public static final TransactionType CREDIT_GRANT = new TransactionType("credit_grant");
    public static final TransactionType CREDIT_APPLIED = new TransactionType("credit_applied");
  }

  public static final class BillingProfileInput extends Model {
    public BillingProfileInput() {}

    @JsonProperty(value = "customer_type", required = false)
    private BillingProfileInputCustomerType customer_type;

    @JsonProperty("customer_type")
    public BillingProfileInputCustomerType getCustomerType() {
      return customer_type;
    }

    public BillingProfileInput withCustomerType(BillingProfileInputCustomerType value) {
      this.customer_type = value;
      return this;
    }

    /** Full legal name of the individual or company. */
    @JsonProperty(value = "company_name", required = false)
    private String company_name;

    @JsonProperty("company_name")
    public String getCompanyName() {
      return company_name;
    }

    public BillingProfileInput withCompanyName(String value) {
      this.company_name = value;
      return this;
    }

    /** ISO 3166-1 alpha-2 country code. */
    @JsonProperty(value = "country", required = false)
    private String country;

    @JsonProperty("country")
    public String getCountry() {
      return country;
    }

    public BillingProfileInput withCountry(String value) {
      this.country = value;
      return this;
    }

    /**
     * CPF for a Brazilian individual or CNPJ for a Brazilian company. Check digits are validated.
     */
    @JsonProperty(value = "tax_id", required = false)
    private String tax_id;

    @JsonProperty("tax_id")
    public String getTaxId() {
      return tax_id;
    }

    public BillingProfileInput withTaxId(String value) {
      this.tax_id = value;
      return this;
    }

    /** Foreign identifier; not validated as a Brazilian document. */
    @JsonProperty(value = "foreign_tax_id", required = false)
    private String foreign_tax_id;

    @JsonProperty("foreign_tax_id")
    public String getForeignTaxId() {
      return foreign_tax_id;
    }

    public BillingProfileInput withForeignTaxId(String value) {
      this.foreign_tax_id = value;
      return this;
    }

    /** Required for a foreign recipient without a tax identifier. */
    @JsonProperty(value = "no_tax_id_reason", required = false)
    private String no_tax_id_reason;

    @JsonProperty("no_tax_id_reason")
    public String getNoTaxIdReason() {
      return no_tax_id_reason;
    }

    public BillingProfileInput withNoTaxIdReason(String value) {
      this.no_tax_id_reason = value;
      return this;
    }

    /**
     * Billing email for fiscal invoice delivery. The onboarding form prefills this from the
     * signed-in user's email.
     */
    @JsonProperty(value = "email", required = false)
    private String email;

    @JsonProperty("email")
    public String getEmail() {
      return email;
    }

    public BillingProfileInput withEmail(String value) {
      this.email = value;
      return this;
    }

    @JsonProperty(value = "phone", required = false)
    private String phone;

    @JsonProperty("phone")
    public String getPhone() {
      return phone;
    }

    public BillingProfileInput withPhone(String value) {
      this.phone = value;
      return this;
    }

    @JsonProperty(value = "street_name", required = false)
    private String street_name;

    @JsonProperty("street_name")
    public String getStreetName() {
      return street_name;
    }

    public BillingProfileInput withStreetName(String value) {
      this.street_name = value;
      return this;
    }

    @JsonProperty(value = "street_number", required = false)
    private String street_number;

    @JsonProperty("street_number")
    public String getStreetNumber() {
      return street_number;
    }

    public BillingProfileInput withStreetNumber(String value) {
      this.street_number = value;
      return this;
    }

    @JsonProperty(value = "complement", required = false)
    private String complement;

    @JsonProperty("complement")
    public String getComplement() {
      return complement;
    }

    public BillingProfileInput withComplement(String value) {
      this.complement = value;
      return this;
    }

    @JsonProperty(value = "neighborhood", required = false)
    private String neighborhood;

    @JsonProperty("neighborhood")
    public String getNeighborhood() {
      return neighborhood;
    }

    public BillingProfileInput withNeighborhood(String value) {
      this.neighborhood = value;
      return this;
    }

    @JsonProperty(value = "city", required = false)
    private String city;

    @JsonProperty("city")
    public String getCity() {
      return city;
    }

    public BillingProfileInput withCity(String value) {
      this.city = value;
      return this;
    }

    /** Seven-digit IBGE municipality code, required for a Brazilian recipient. */
    @JsonProperty(value = "municipality_code", required = false)
    private String municipality_code;

    @JsonProperty("municipality_code")
    public String getMunicipalityCode() {
      return municipality_code;
    }

    public BillingProfileInput withMunicipalityCode(String value) {
      this.municipality_code = value;
      return this;
    }

    /** Two-letter UF for Brazil; free-form state/province abroad. */
    @JsonProperty(value = "state", required = false)
    private String state;

    @JsonProperty("state")
    public String getState() {
      return state;
    }

    public BillingProfileInput withState(String value) {
      this.state = value;
      return this;
    }

    /** Eight-digit CEP for Brazil; optional international postal code abroad. */
    @JsonProperty(value = "postal_code", required = false)
    private String postal_code;

    @JsonProperty("postal_code")
    public String getPostalCode() {
      return postal_code;
    }

    public BillingProfileInput withPostalCode(String value) {
      this.postal_code = value;
      return this;
    }
  }

  public static final class BillingProfileInputCustomerType {
    private final String value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public BillingProfileInputCustomerType(String value) {
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
      return other instanceof BillingProfileInputCustomerType v && value.equals(v.value);
    }

    @Override
    public int hashCode() {
      return value.hashCode();
    }

    public static final BillingProfileInputCustomerType VALUE =
        new BillingProfileInputCustomerType("");
    public static final BillingProfileInputCustomerType INDIVIDUAL =
        new BillingProfileInputCustomerType("individual");
    public static final BillingProfileInputCustomerType COMPANY =
        new BillingProfileInputCustomerType("company");
  }
}
