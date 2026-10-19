package sh.basaltic.sdk;

/** Generated service accessors. Use Client to construct a client. */
public abstract class GeneratedClient {
  GeneratedClient() {}

  abstract Transport transport();

  /** Access the audit API. */
  public final AuditService audit() {
    return new AuditService(transport());
  }

  /** Access the billing API. */
  public final BillingService billing() {
    return new BillingService(transport());
  }

  /** Access the catalog API. */
  public final CatalogService catalog() {
    return new CatalogService(transport());
  }

  /** Access the certificate API. */
  public final CertificateService certificate() {
    return new CertificateService(transport());
  }

  /** Access the compute API. */
  public final ComputeService compute() {
    return new ComputeService(transport());
  }

  /** Access the dns API. */
  public final DnsService dns() {
    return new DnsService(transport());
  }

  /** Access the email API. */
  public final EmailService email() {
    return new EmailService(transport());
  }

  /** Access the iam API. */
  public final IamService iam() {
    return new IamService(transport());
  }

  /** Access the kms API. */
  public final KmsService kms() {
    return new KmsService(transport());
  }

  /** Access the loadbalancer API. */
  public final LoadbalancerService loadbalancer() {
    return new LoadbalancerService(transport());
  }

  /** Access the network API. */
  public final NetworkService network() {
    return new NetworkService(transport());
  }

  /** Access the notifications API. */
  public final NotificationsService notifications() {
    return new NotificationsService(transport());
  }

  /** Access the queue API. */
  public final QueueService queue() {
    return new QueueService(transport());
  }

  /** Access the quota API. */
  public final QuotaService quota() {
    return new QuotaService(transport());
  }

  /** Access the registry API. */
  public final RegistryService registry() {
    return new RegistryService(transport());
  }

  /** Access the secrets API. */
  public final SecretsService secrets() {
    return new SecretsService(transport());
  }

  /** Access the storage API. */
  public final StorageService storage() {
    return new StorageService(transport());
  }

  /** Access the telemetry API. */
  public final TelemetryService telemetry() {
    return new TelemetryService(transport());
  }

  /** Access the workspace API. */
  public final WorkspaceService workspace() {
    return new WorkspaceService(transport());
  }
}
