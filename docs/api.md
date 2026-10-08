# Java API reference

Constructing a request does no network IO. Execute using `.send()` or `.sendAsync()`. Paged requests also offer `.pages()`, `.items()` and a backpressure-aware `.pagesAsync()` publisher. WebSocket descriptors use `.prepare()` or `.prepareAsync()`. Models are nested under `sh.basaltic.sdk.models.<Service>`. Nullable fields use `JsonField.missing()`, `JsonField.nullValue()` or `JsonField.of(value)`.

## `audit.getAuditLog`

Get audit log entry

`GET /v1/audit-logs/{log_id}`

```java
public Request<AuditLogResponse> getAuditLog(String log_id)
```

## `audit.listAuditLogs`

List audit logs

`GET /v1/audit-logs`

```java
public PagedRequest<AuditLogListResponse,AuditLog> listAuditLogs(ListAuditLogsQuery query)
```

## `billing.getBillingProfile`

Read the organization billing profile

`GET /v1/profile`

```java
public Request<BillingProfile> getBillingProfile()
```

## `billing.getCurrentUsage`

Get month-to-date usage total

`GET /v1/usage`

```java
public Request<CurrentUsage> getCurrentUsage()
```

## `billing.getFiscalInvoiceXml`

Download issued NFS-e XML

`GET /v1/fiscal-invoices/{document_id}/xml`

```java
public BinaryRequest getFiscalInvoiceXml(String document_id)
```

## `billing.getInvoice`

Get an invoice with its line items

`GET /v1/invoices/{invoice_id}`

```java
public Request<Invoice> getInvoice(String invoice_id)
```

## `billing.getInvoicePdf`

Download an invoice as a PDF statement

`GET /v1/invoices/{invoice_id}/pdf`

```java
public BinaryRequest getInvoicePdf(String invoice_id)
```

## `billing.listCredits`

List credit grants

`GET /v1/credits`

```java
public PagedRequest<CreditListResponse,Credit> listCredits(ListCreditsQuery query)
```

## `billing.listFiscalInvoices`

List fiscal invoice issuance and delivery status

`GET /v1/fiscal-invoices`

```java
public PagedRequest<ListFiscalInvoicesResponse,FiscalInvoice> listFiscalInvoices(ListFiscalInvoicesQuery query)
```

## `billing.listInvoices`

List invoices

`GET /v1/invoices`

```java
public PagedRequest<InvoiceListResponse,Invoice> listInvoices(ListInvoicesQuery query)
```

## `billing.listPayments`

List invoice payments

`GET /v1/payments`

```java
public PagedRequest<PaymentListResponse,Payment> listPayments(ListPaymentsQuery query)
```

## `billing.listPrices`

List catalog prices

`GET /v1/prices`

```java
public PagedRequest<PriceListResponse,Price> listPrices(ListPricesQuery query)
```

## `billing.listTransactions`

List ledger transactions

`GET /v1/transactions`

```java
public PagedRequest<TransactionListResponse,Transaction> listTransactions(ListTransactionsQuery query)
```

## `billing.updateBillingProfile`

Save organization billing details

`PUT /v1/profile`

```java
public Request<BillingProfile> updateBillingProfile(BillingProfileInput body)
```

## `catalog.getRegion`

Get a region

`GET /v1/regions/{code}`

```java
public Request<Region> getRegion(String code)
```

## `catalog.listRegions`

List regions

`GET /v1/regions`

```java
public PagedRequest<ListRegionsResponse,Region> listRegions(ListRegionsQuery query)
```

## `certificate.createCertificate`

Create certificate

`POST /v1/certificates`

```java
public Request<CreateCertificateResponse> createCertificate(CertificateIssueRequestInput body)
```

## `certificate.deleteCertificate`

Delete certificate

`DELETE /v1/certificates/{certificate_id}`

```java
public EmptyRequest deleteCertificate(String certificate_id)
```

## `certificate.getCertificate`

Get certificate

`GET /v1/certificates/{certificate_id}`

```java
public Request<CertificateResponse> getCertificate(String certificate_id)
```

## `certificate.getCertificateMaterial`

Fetch certificate material (leaf, chain, private key)

`GET /v1/certificates/{certificate_id}/material`

```java
public Request<MaterialResponse> getCertificateMaterial(String certificate_id)
```

## `certificate.listCertificates`

List certificates

`GET /v1/certificates`

```java
public PagedRequest<CertificateListResponse,Certificate2> listCertificates(ListCertificatesQuery query)
```

## `certificate.revokeCertificate`

Revoke certificate

`POST /v1/certificates/{certificate_id}/revoke`

```java
public Request<CertificateResponse> revokeCertificate(String certificate_id)
```

## `compute.attachInstanceNIC`

Attach an existing NIC to an instance

`POST /v1/instances/{instance_id}/nics`

```java
public Request<AttachInstanceNICResponse> attachInstanceNIC(String instance_id,AttachInstanceNICBody body)
```

## `compute.attachInstancePoolFloatingIp`

Give the pool a shared public address

`POST /v1/instance-pools/{pool_id}/floating-ips`

```java
public Request<InstancePoolFloatingIpResponse> attachInstancePoolFloatingIp(String pool_id,InstancePoolFloatingIpAttachRequestInput body)
```

## `compute.attachInstanceVolume`

Attach a data volume to an instance

`POST /v1/instances/{instance_id}/volumes`

```java
public Request<AttachInstanceVolumeResponse> attachInstanceVolume(String instance_id,AttachInstanceVolumeBody body)
```

## `compute.createImage`

Import an image from an object URL

`POST /v1/images`

```java
public Request<ImageResponse> createImage(ImageCreateRequestInput body)
```

## `compute.createInstance`

Create instance

`POST /v1/instances`

```java
public Request<CreateInstanceResponse> createInstance(InstanceCreateRequestInput body)
```

## `compute.createInstancePool`

Create an instance pool

`POST /v1/instance-pools`

```java
public Request<InstancePoolResponse> createInstancePool(InstancePoolCreateRequestInput body)
```

## `compute.createSerialConsoleTicket`

Mint a ticket for the serial console

`POST /v1/instances/{instance_id}/console/ticket`

```java
public Request<SerialConsoleTicket> createSerialConsoleTicket(String instance_id)
```

## `compute.deleteImage`

Delete an unused image

`DELETE /v1/images/{image_id}`

```java
public Request<ImageResponse> deleteImage(String image_id)
```

## `compute.deleteInstance`

Delete instance

`DELETE /v1/instances/{instance_id}`

```java
public EmptyRequest deleteInstance(String instance_id)
```

## `compute.deleteInstancePool`

Delete an instance pool

`DELETE /v1/instance-pools/{pool_id}`

```java
public EmptyRequest deleteInstancePool(String pool_id)
```

## `compute.detachInstanceNIC`

Detach a NIC from a running instance

`DELETE /v1/instances/{instance_id}/nics/{interface_id}`

```java
public EmptyRequest detachInstanceNIC(String instance_id,String interface_id)
```

## `compute.detachInstancePoolFloatingIp`

Take a shared address off the pool

`DELETE /v1/instance-pools/{pool_id}/floating-ips/{floating_ip_id}`

```java
public EmptyRequest detachInstancePoolFloatingIp(String pool_id,String floating_ip_id)
```

## `compute.detachInstanceVolume`

Detach a data volume from an instance

`DELETE /v1/instances/{instance_id}/volumes/{volume_id}`

```java
public EmptyRequest detachInstanceVolume(String instance_id,String volume_id)
```

## `compute.getConsoleOutput`

Get the instance's serial console output

`GET /v1/instances/{instance_id}/console/output`

```java
public Request<GetConsoleOutputResponse> getConsoleOutput(String instance_id,GetConsoleOutputQuery query)
```

## `compute.getConsoleScreenshot`

Capture the instance's display

`GET /v1/instances/{instance_id}/console/screenshot`

```java
public BinaryRequest getConsoleScreenshot(String instance_id)
```

## `compute.getFlavor`

Get flavor

`GET /v1/flavors/{flavor_id}`

```java
public Request<GetFlavorResponse> getFlavor(String flavor_id)
```

## `compute.getImage`

Get an image

`GET /v1/images/{image_id}`

```java
public Request<ImageResponse> getImage(String image_id)
```

## `compute.getInstance`

Get instance

`GET /v1/instances/{instance_id}`

```java
public Request<GetInstanceResponse> getInstance(String instance_id)
```

## `compute.getInstancePool`

Get an instance pool

`GET /v1/instance-pools/{pool_id}`

```java
public Request<InstancePoolResponse> getInstancePool(String pool_id)
```

## `compute.listFlavors`

List flavors

`GET /v1/flavors`

```java
public PagedRequest<FlavorListResponse,Flavor> listFlavors(ListFlavorsQuery query)
```

## `compute.listImageCatalog`

List the launch image catalog

`GET /v1/image-catalog`

```java
public PagedRequest<ImageCatalogResponse,ImageCatalogCategory> listImageCatalog(ListImageCatalogQuery query)
```

## `compute.listImages`

List images

`GET /v1/images`

```java
public PagedRequest<ImageListResponse,Image> listImages(ListImagesQuery query)
```

## `compute.listInstanceNICs`

List the instance's network interfaces

`GET /v1/instances/{instance_id}/nics`

```java
public PagedRequest<ListInstanceNICsResponse,ListInstanceNICsItem> listInstanceNICs(String instance_id,ListInstanceNICsQuery query)
```

## `compute.listInstancePoolFloatingIps`

List the pool's shared public addresses

`GET /v1/instance-pools/{pool_id}/floating-ips`

```java
public PagedRequest<FloatingIpListResponse,FloatingIp> listInstancePoolFloatingIps(String pool_id,ListInstancePoolFloatingIpsQuery query)
```

## `compute.listInstancePools`

List instance pools

`GET /v1/instance-pools`

```java
public PagedRequest<InstancePoolListResponse,InstancePool> listInstancePools(ListInstancePoolsQuery query)
```

## `compute.listInstanceVolumes`

List the instance's attached volumes

`GET /v1/instances/{instance_id}/volumes`

```java
public PagedRequest<ListInstanceVolumesResponse,ListInstanceVolumesItem> listInstanceVolumes(String instance_id,ListInstanceVolumesQuery query)
```

## `compute.listInstances`

List instances

`GET /v1/instances`

```java
public PagedRequest<InstanceListResponse,Instance> listInstances(ListInstancesQuery query)
```

## `compute.listPoolInstances`

List a pool's instances

`GET /v1/instance-pools/{pool_id}/instances`

```java
public PagedRequest<InstanceListResponse,Instance> listPoolInstances(String pool_id,ListPoolInstancesQuery query)
```

## `compute.rebootInstance`

Reboot instance

`POST /v1/instances/{instance_id}/reboot`

```java
public EmptyRequest rebootInstance(String instance_id,InstanceRebootRequestInput body)
```

## `compute.refreshInstancePool`

Roll every member onto the pool's current launch template

`POST /v1/instance-pools/{pool_id}/refresh`

```java
public Request<InstancePoolResponse> refreshInstancePool(String pool_id)
```

## `compute.reinstallInstance`

Reinstall instance

`POST /v1/instances/{instance_id}/reinstall`

```java
public EmptyRequest reinstallInstance(String instance_id,ReinstallInstanceBody body)
```

## `compute.resizeInstance`

Resize instance

`POST /v1/instances/{instance_id}/resize`

```java
public EmptyRequest resizeInstance(String instance_id,ResizeInstanceBody body)
```

## `compute.startInstance`

Start instance

`POST /v1/instances/{instance_id}/start`

```java
public EmptyRequest startInstance(String instance_id)
```

## `compute.startSerialConsole`

Open an interactive serial console

`GET /v1/instances/{instance_id}/console/serial`

```java
public WebSocketRequest startSerialConsole(String instance_id,StartSerialConsoleQuery query)
```

## `compute.stopInstance`

Stop instance

`POST /v1/instances/{instance_id}/stop`

```java
public EmptyRequest stopInstance(String instance_id)
```

## `compute.updateImage`

Update an image's metadata

`PATCH /v1/images/{image_id}`

```java
public Request<ImageResponse> updateImage(String image_id,ImageUpdateRequestInput body)
```

## `compute.updateInstance`

Update instance

`PATCH /v1/instances/{instance_id}`

```java
public Request<UpdateInstanceResponse> updateInstance(String instance_id,InstanceUpdateRequestInput body)
```

## `compute.updateInstancePool`

Update an instance pool's description, size, tags or launch template

`PATCH /v1/instance-pools/{pool_id}`

```java
public Request<InstancePoolResponse> updateInstancePool(String pool_id,InstancePoolUpdateRequestInput body)
```

## `compute.updateInstanceVolumeAttachment`

Update a volume attachment's settings

`PATCH /v1/instances/{instance_id}/volumes/{volume_id}`

```java
public EmptyRequest updateInstanceVolumeAttachment(String instance_id,String volume_id,UpdateInstanceVolumeAttachmentBody body)
```

## `dns.associateZoneVPC`

Associate a VPC with a private zone

`POST /v1/zones/{zone_id}/vpc-associations`

```java
public Request<VPCAssociationAccepted> associateZoneVPC(String zone_id,VPCAssociationRequestInput body)
```

## `dns.createRecord`

Create record

`POST /v1/zones/{zone_id}/records`

```java
public Request<RecordResponse> createRecord(String zone_id,RecordCreateRequestInput body)
```

## `dns.createZone`

Create zone

`POST /v1/zones`

```java
public Request<ZoneResponse> createZone(ZoneCreateRequestInput body)
```

## `dns.deleteRecord`

Delete record

`DELETE /v1/zones/{zone_id}/records/{record_id}`

```java
public EmptyRequest deleteRecord(String zone_id,String record_id)
```

## `dns.deleteZone`

Delete zone

`DELETE /v1/zones/{zone_id}`

```java
public EmptyRequest deleteZone(String zone_id)
```

## `dns.deleteZoneRecordImport`

Discard the record-import outcome

`DELETE /v1/zones/{zone_id}/record-import`

```java
public EmptyRequest deleteZoneRecordImport(String zone_id)
```

## `dns.dissociateZoneVPC`

Dissociate a VPC from a private zone

`DELETE /v1/zones/{zone_id}/vpc-associations/{vpc_id}`

```java
public EmptyRequest dissociateZoneVPC(String zone_id,String vpc_id)
```

## `dns.exportZoneFile`

Export the zone as a zone file

`GET /v1/zones/{zone_id}/export`

```java
public BinaryRequest exportZoneFile(String zone_id)
```

## `dns.getRecord`

Get record

`GET /v1/zones/{zone_id}/records/{record_id}`

```java
public Request<RecordResponse> getRecord(String zone_id,String record_id)
```

## `dns.getZone`

Get zone

`GET /v1/zones/{zone_id}`

```java
public Request<ZoneResponse> getZone(String zone_id)
```

## `dns.getZoneRecordImport`

Get the record-import outcome

`GET /v1/zones/{zone_id}/record-import`

```java
public Request<ZoneRecordImportResponse> getZoneRecordImport(String zone_id)
```

## `dns.importZoneFile`

Import a zone file

`POST /v1/zones/{zone_id}/import`

```java
public Request<ZoneImportResponse> importZoneFile(String zone_id,ZoneImportRequestInput body)
```

## `dns.listRecords`

List records

`GET /v1/zones/{zone_id}/records`

```java
public PagedRequest<RecordListResponse,Record> listRecords(String zone_id,ListRecordsQuery query)
```

## `dns.listZoneVPCAssociations`

List VPC associations

`GET /v1/zones/{zone_id}/vpc-associations`

```java
public PagedRequest<VPCAssociationsResponse,String> listZoneVPCAssociations(String zone_id,ListZoneVPCAssociationsQuery query)
```

## `dns.listZones`

List zones

`GET /v1/zones`

```java
public PagedRequest<ZoneListResponse,Zone> listZones(ListZonesQuery query)
```

## `dns.updateRecord`

Update record

`PATCH /v1/zones/{zone_id}/records/{record_id}`

```java
public Request<RecordResponse> updateRecord(String zone_id,String record_id,RecordUpdateRequestInput body)
```

## `dns.updateZone`

Update zone

`PATCH /v1/zones/{zone_id}`

```java
public Request<ZoneResponse> updateZone(String zone_id,ZoneUpdateRequestInput body)
```

## `dns.verifyZoneOwnership`

Verify zone ownership

`POST /v1/zones/{zone_id}/verify-ownership`

```java
public Request<ZoneResponse> verifyZoneOwnership(String zone_id)
```

## `iam.assumeRole`

Assume role

`POST /v1/assume-role`

```java
public Request<AssumeRoleResponse> assumeRole(AssumeRoleRequestInput body)
```

## `iam.assumeRoleWithWebIdentity`

Assume role with web identity

`POST /v1/assume-role-with-web-identity`

```java
public Request<AssumeRoleResponse> assumeRoleWithWebIdentity(AssumeRoleWithWebIdentityRequestInput body)
```

## `iam.attachRolePolicy`

Attach policy to role

`POST /v1/roles/{role_id}/policies`

```java
public EmptyRequest attachRolePolicy(String role_id,RolePolicyAttachRequestInput body)
```

## `iam.attachServiceAccountPolicy`

Attach policy to service account

`POST /v1/service-accounts/{service_account_id}/policies`

```java
public EmptyRequest attachServiceAccountPolicy(String service_account_id,PolicyAttachRequestInput body)
```

## `iam.authorizeOAuthClient`

Approve a CLI login and issue an authorization code

`POST /v1/oauth/authorize`

```java
public Request<OAuthAuthorizeResponse> authorizeOAuthClient(OAuthAuthorizeRequestInput body)
```

## `iam.createPersonalSSHKey`

Add personal SSH key

`POST /v1/auth/ssh-keys`

```java
public Request<CreatePersonalSSHKeyResponse> createPersonalSSHKey(SSHKeyCreateRequestInput body)
```

## `iam.createPolicy`

Create policy

`POST /v1/policies`

```java
public Request<CreatePolicyResponse> createPolicy(PolicyCreateRequestInput body)
```

## `iam.createRole`

Create role

`POST /v1/roles`

```java
public Request<CreateRoleResponse> createRole(RoleCreateRequestInput body)
```

## `iam.createServiceAccount`

Create service account

`POST /v1/service-accounts`

```java
public Request<CreateServiceAccountResponse> createServiceAccount(ServiceAccountCreateRequestInput body)
```

## `iam.createServiceAccountCredential`

Create credential

`POST /v1/service-accounts/{service_account_id}/credentials`

```java
public Request<CredentialCreateResponse> createServiceAccountCredential(String service_account_id,CredentialCreateRequestInput body)
```

## `iam.createServiceAccountSSHKey`

Add service-account SSH key

`POST /v1/service-accounts/{service_account_id}/ssh-keys`

```java
public Request<CreateServiceAccountSSHKeyResponse> createServiceAccountSSHKey(String service_account_id,SSHKeyCreateRequestInput body)
```

## `iam.deletePersonalSSHKey`

Revoke personal SSH key

`DELETE /v1/auth/ssh-keys/{ssh_key_id}`

```java
public EmptyRequest deletePersonalSSHKey(String ssh_key_id)
```

## `iam.deletePolicy`

Delete policy

`DELETE /v1/policies/{policy_id}`

```java
public EmptyRequest deletePolicy(String policy_id)
```

## `iam.deleteRole`

Delete role

`DELETE /v1/roles/{role_id}`

```java
public EmptyRequest deleteRole(String role_id)
```

## `iam.deleteRoleInlinePolicy`

Delete a role's inline policy by name

`DELETE /v1/roles/{role_id}/inline-policies/{policy_name}`

```java
public EmptyRequest deleteRoleInlinePolicy(String role_id,String policy_name)
```

## `iam.deleteServiceAccount`

Delete service account

`DELETE /v1/service-accounts/{service_account_id}`

```java
public EmptyRequest deleteServiceAccount(String service_account_id)
```

## `iam.deleteServiceAccountCredential`

Delete credential

`DELETE /v1/service-accounts/{service_account_id}/credentials/{credential_id}`

```java
public EmptyRequest deleteServiceAccountCredential(String service_account_id,String credential_id)
```

## `iam.deleteServiceAccountInlinePolicy`

Delete a service account's inline policy by name

`DELETE /v1/service-accounts/{service_account_id}/inline-policies/{policy_name}`

```java
public EmptyRequest deleteServiceAccountInlinePolicy(String service_account_id,String policy_name)
```

## `iam.deleteServiceAccountSSHKey`

Revoke service-account SSH key

`DELETE /v1/service-accounts/{service_account_id}/ssh-keys/{ssh_key_id}`

```java
public EmptyRequest deleteServiceAccountSSHKey(String service_account_id,String ssh_key_id)
```

## `iam.detachRolePolicy`

Detach policy from role

`DELETE /v1/roles/{role_id}/policies/{policy_id}`

```java
public EmptyRequest detachRolePolicy(String role_id,String policy_id)
```

## `iam.detachServiceAccountPolicy`

Detach policy from service account

`DELETE /v1/service-accounts/{service_account_id}/policies/{policy_id}`

```java
public EmptyRequest detachServiceAccountPolicy(String service_account_id,String policy_id)
```

## `iam.getOAuthToken`

Exchange an access key for a bearer token

`POST /v1/oauth/token`

```java
public Request<OAuthTokenResponse> getOAuthToken(OAuthTokenRequestInput body)
```

## `iam.getPersonalLinuxIdentity`

Get personal Linux identity

`GET /v1/auth/linux-identity`

```java
public Request<GetPersonalLinuxIdentityResponse> getPersonalLinuxIdentity()
```

## `iam.getPolicy`

Get policy

`GET /v1/policies/{policy_id}`

```java
public Request<GetPolicyResponse> getPolicy(String policy_id)
```

## `iam.getRole`

Get role

`GET /v1/roles/{role_id}`

```java
public Request<GetRoleResponse> getRole(String role_id)
```

## `iam.getRoleInlinePolicy`

Get a role's inline policy by name

`GET /v1/roles/{role_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> getRoleInlinePolicy(String role_id,String policy_name)
```

## `iam.getRolePermissionBoundary`

Get a role's permission boundary

`GET /v1/roles/{role_id}/permission-boundary`

```java
public Request<PermissionBoundaryResponse> getRolePermissionBoundary(String role_id)
```

## `iam.getSTSSession`

Get STS session

`GET /v1/sts-sessions/{session_id}`

```java
public Request<STSSessionResponse> getSTSSession(String session_id)
```

## `iam.getServiceAccount`

Get service account

`GET /v1/service-accounts/{service_account_id}`

```java
public Request<GetServiceAccountResponse> getServiceAccount(String service_account_id)
```

## `iam.getServiceAccountInlinePolicy`

Get a service account's inline policy by name

`GET /v1/service-accounts/{service_account_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> getServiceAccountInlinePolicy(String service_account_id,String policy_name)
```

## `iam.getServiceAccountLinuxIdentity`

Get serviceaccount Linux identity

`GET /v1/service-accounts/{service_account_id}/linux-identity`

```java
public Request<GetServiceAccountLinuxIdentityResponse> getServiceAccountLinuxIdentity(String service_account_id)
```

## `iam.getServiceAccountPermissionBoundary`

Get a service account's permission boundary

`GET /v1/service-accounts/{service_account_id}/permission-boundary`

```java
public Request<PermissionBoundaryResponse> getServiceAccountPermissionBoundary(String service_account_id)
```

## `iam.listPersonalSSHKeys`

List personal SSH keys

`GET /v1/auth/ssh-keys`

```java
public PagedRequest<ListPersonalSSHKeysResponse,SSHKey> listPersonalSSHKeys()
```

## `iam.listPolicies`

List policies

`GET /v1/policies`

```java
public PagedRequest<PolicyListResponse,Policy> listPolicies(ListPoliciesQuery query)
```

## `iam.listPolicyRoles`

List roles with policy

`GET /v1/policies/{policy_id}/roles`

```java
public PagedRequest<PolicyRolesListResponse,Role> listPolicyRoles(String policy_id,ListPolicyRolesQuery query)
```

## `iam.listPolicyServiceAccounts`

List service accounts with policy

`GET /v1/policies/{policy_id}/service-accounts`

```java
public PagedRequest<PolicyServiceAccountsListResponse,ServiceAccount> listPolicyServiceAccounts(String policy_id,ListPolicyServiceAccountsQuery query)
```

## `iam.listRegions`

List regions (legacy IAM)

`GET /v1/regions`

```java
public PagedRequest<ListRegionsResponse,Region> listRegions(ListRegionsQuery query)
```

## `iam.listRoleInlinePolicies`

List a role's inline policies

`GET /v1/roles/{role_id}/inline-policies`

```java
public PagedRequest<InlinePolicyListResponse,InlinePolicy> listRoleInlinePolicies(String role_id,ListRoleInlinePoliciesQuery query)
```

## `iam.listRolePolicies`

List role policies

`GET /v1/roles/{role_id}/policies`

```java
public PagedRequest<RolePoliciesListResponse,Policy> listRolePolicies(String role_id,ListRolePoliciesQuery query)
```

## `iam.listRoles`

List roles

`GET /v1/roles`

```java
public PagedRequest<RoleListResponse,Role> listRoles(ListRolesQuery query)
```

## `iam.listSTSSessions`

List STS sessions

`GET /v1/sts-sessions`

```java
public PagedRequest<STSSessionListResponse,STSSession> listSTSSessions(ListSTSSessionsQuery query)
```

## `iam.listServiceAccountCredentials`

List credentials

`GET /v1/service-accounts/{service_account_id}/credentials`

```java
public PagedRequest<CredentialListResponse,Credential> listServiceAccountCredentials(String service_account_id,ListServiceAccountCredentialsQuery query)
```

## `iam.listServiceAccountInlinePolicies`

List a service account's inline policies

`GET /v1/service-accounts/{service_account_id}/inline-policies`

```java
public PagedRequest<InlinePolicyListResponse,InlinePolicy> listServiceAccountInlinePolicies(String service_account_id,ListServiceAccountInlinePoliciesQuery query)
```

## `iam.listServiceAccountPolicies`

List service account policies

`GET /v1/service-accounts/{service_account_id}/policies`

```java
public PagedRequest<PrincipalPoliciesListResponse,Policy> listServiceAccountPolicies(String service_account_id,ListServiceAccountPoliciesQuery query)
```

## `iam.listServiceAccountSSHKeys`

List service-account SSH keys

`GET /v1/service-accounts/{service_account_id}/ssh-keys`

```java
public PagedRequest<ListServiceAccountSSHKeysResponse,SSHKey> listServiceAccountSSHKeys(String service_account_id)
```

## `iam.listServiceAccounts`

List service accounts

`GET /v1/service-accounts`

```java
public PagedRequest<ServiceAccountListResponse,ServiceAccount> listServiceAccounts(ListServiceAccountsQuery query)
```

## `iam.putRoleInlinePolicy`

Create or replace a role's inline policy

`PUT /v1/roles/{role_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> putRoleInlinePolicy(String role_id,String policy_name,PutInlinePolicyRequestInput body)
```

## `iam.putServiceAccountInlinePolicy`

Create or replace a service account's inline policy

`PUT /v1/service-accounts/{service_account_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> putServiceAccountInlinePolicy(String service_account_id,String policy_name,PutInlinePolicyRequestInput body)
```

## `iam.removeRolePermissionBoundary`

Remove a role's permission boundary

`DELETE /v1/roles/{role_id}/permission-boundary`

```java
public EmptyRequest removeRolePermissionBoundary(String role_id)
```

## `iam.removeServiceAccountPermissionBoundary`

Remove a service account's permission boundary

`DELETE /v1/service-accounts/{service_account_id}/permission-boundary`

```java
public EmptyRequest removeServiceAccountPermissionBoundary(String service_account_id)
```

## `iam.revokeOAuthToken`

Revoke a bearer token

`POST /v1/oauth/revoke`

```java
public EmptyRequest revokeOAuthToken(OAuthRevokeRequestInput body)
```

## `iam.revokeSTSSession`

Revoke STS session

`DELETE /v1/sts-sessions/{session_id}`

```java
public Request<STSSessionResponse> revokeSTSSession(String session_id,RevokeSTSSessionBody body)
```

## `iam.setRolePermissionBoundary`

Set a role's permission boundary

`PUT /v1/roles/{role_id}/permission-boundary`

```java
public EmptyRequest setRolePermissionBoundary(String role_id,SetBoundaryRequestInput body)
```

## `iam.setServiceAccountPermissionBoundary`

Set a service account's permission boundary

`PUT /v1/service-accounts/{service_account_id}/permission-boundary`

```java
public EmptyRequest setServiceAccountPermissionBoundary(String service_account_id,SetBoundaryRequestInput body)
```

## `iam.updatePolicy`

Update policy

`PATCH /v1/policies/{policy_id}`

```java
public Request<UpdatePolicyResponse> updatePolicy(String policy_id,PolicyUpdateRequestInput body)
```

## `iam.updateRole`

Update role

`PATCH /v1/roles/{role_id}`

```java
public Request<UpdateRoleResponse> updateRole(String role_id,RoleUpdateRequestInput body)
```

## `iam.updateServiceAccount`

Update service account

`PATCH /v1/service-accounts/{service_account_id}`

```java
public Request<UpdateServiceAccountResponse> updateServiceAccount(String service_account_id,ServiceAccountUpdateRequestInput body)
```

## `kms.cancelKeyDeletion`

Cancel a scheduled deletion

`POST /v1/keys/{key_id}/cancel-deletion`

```java
public Request<KeyResponse> cancelKeyDeletion(String key_id)
```

## `kms.createKey`

Create a KMS key

`POST /v1/keys`

```java
public Request<KeyResponse> createKey(CreateKeyRequestInput body)
```

## `kms.decrypt`

Decrypt a ciphertext

`POST /v1/keys/{key_id}/decrypt`

```java
public Request<DecryptResponse> decrypt(String key_id,DecryptRequestInput body)
```

## `kms.disableKey`

Disable a key

`POST /v1/keys/{key_id}/disable`

```java
public Request<KeyResponse> disableKey(String key_id)
```

## `kms.enableKey`

Enable a disabled key

`POST /v1/keys/{key_id}/enable`

```java
public Request<KeyResponse> enableKey(String key_id)
```

## `kms.encrypt`

Encrypt a payload

`POST /v1/keys/{key_id}/encrypt`

```java
public Request<EncryptResponse> encrypt(String key_id,EncryptRequestInput body)
```

## `kms.generateDataKey`

Generate a fresh data key

`POST /v1/keys/{key_id}/generate-data-key`

```java
public Request<GenerateDataKeyResponse> generateDataKey(String key_id,GenerateDataKeyRequestInput body)
```

## `kms.getKey`

Get a KMS key

`GET /v1/keys/{key_id}`

```java
public Request<KeyResponse> getKey(String key_id)
```

## `kms.listKeys`

List KMS keys

`GET /v1/keys`

```java
public PagedRequest<KeyListResponse,Key> listKeys(ListKeysQuery query)
```

## `kms.scheduleKeyDeletion`

Schedule key for deletion

`POST /v1/keys/{key_id}/schedule-deletion`

```java
public Request<KeyResponse> scheduleKeyDeletion(String key_id,ScheduleKeyDeletionRequestInput body)
```

## `kms.sign`

Sign a message

`POST /v1/keys/{key_id}/sign`

```java
public Request<SignResponse> sign(String key_id,SignRequestInput body)
```

## `kms.updateKey`

Update key metadata

`PATCH /v1/keys/{key_id}`

```java
public Request<KeyResponse> updateKey(String key_id,UpdateKeyRequestInput body)
```

## `kms.verify`

Verify a signature

`POST /v1/keys/{key_id}/verify`

```java
public Request<VerifyResponse> verify(String key_id,VerifyRequestInput body)
```

## `loadbalancer.attachListenerCertificate`

Attach an additional certificate to an HTTPS listener

`POST /v1/load-balancers/{id}/listeners/{listener_id}/certificates`

```java
public Request<ListenerResponse> attachListenerCertificate(String id,String listener_id,AttachListenerCertificateRequestInput body)
```

## `loadbalancer.attachTarget`

Attach a target to this group

`POST /v1/target-groups/{id}/targets`

```java
public Request<TargetResponse> attachTarget(String id,AttachTargetRequestInput body)
```

## `loadbalancer.createListener`

Create a listener on this load balancer

`POST /v1/load-balancers/{id}/listeners`

```java
public Request<ListenerResponse> createListener(String id,CreateListenerRequestInput body)
```

## `loadbalancer.createLoadBalancer`

Create a load balancer

`POST /v1/load-balancers`

```java
public Request<LoadBalancerResponse> createLoadBalancer(CreateLoadBalancerRequestInput body)
```

## `loadbalancer.createRule`

Create a routing rule on this listener (HTTP/HTTPS only)

`POST /v1/load-balancers/{id}/listeners/{listener_id}/rules`

```java
public Request<RuleResponse> createRule(String id,String listener_id,CreateRuleRequestInput body)
```

## `loadbalancer.createTargetGroup`

Create a target group

`POST /v1/target-groups`

```java
public Request<TargetGroupResponse> createTargetGroup(CreateTargetGroupRequestInput body)
```

## `loadbalancer.deleteListener`

Delete a listener

`DELETE /v1/load-balancers/{id}/listeners/{listener_id}`

```java
public EmptyRequest deleteListener(String id,String listener_id)
```

## `loadbalancer.deleteLoadBalancer`

Delete a load balancer

`DELETE /v1/load-balancers/{id}`

```java
public EmptyRequest deleteLoadBalancer(String id)
```

## `loadbalancer.deleteRuleInListener`

Delete a routing rule

`DELETE /v1/load-balancers/{id}/listeners/{listener_id}/rules/{rule_id}`

```java
public EmptyRequest deleteRuleInListener(String id,String listener_id,String rule_id)
```

## `loadbalancer.deleteTargetGroup`

Delete a target group

`DELETE /v1/target-groups/{id}`

```java
public EmptyRequest deleteTargetGroup(String id)
```

## `loadbalancer.detachListenerCertificate`

Detach a certificate from an HTTPS listener

`DELETE /v1/load-balancers/{id}/listeners/{listener_id}/certificates/{certificate_id}`

```java
public EmptyRequest detachListenerCertificate(String id,String listener_id,String certificate_id)
```

## `loadbalancer.detachTarget`

Detach a target

`DELETE /v1/target-groups/{id}/targets/{target_id}`

```java
public EmptyRequest detachTarget(String id,String target_id)
```

## `loadbalancer.getListener`

Get a listener

`GET /v1/load-balancers/{id}/listeners/{listener_id}`

```java
public Request<ListenerResponse> getListener(String id,String listener_id)
```

## `loadbalancer.getLoadBalancer`

Get a load balancer

`GET /v1/load-balancers/{id}`

```java
public Request<LoadBalancerResponse> getLoadBalancer(String id)
```

## `loadbalancer.getRule`

Get a routing rule

`GET /v1/load-balancers/{id}/listeners/{listener_id}/rules/{rule_id}`

```java
public Request<RuleResponse> getRule(String id,String listener_id,String rule_id)
```

## `loadbalancer.getTarget`

Get a target

`GET /v1/target-groups/{id}/targets/{target_id}`

```java
public Request<TargetResponse> getTarget(String id,String target_id)
```

## `loadbalancer.getTargetGroup`

Get a target group

`GET /v1/target-groups/{id}`

```java
public Request<TargetGroupResponse> getTargetGroup(String id)
```

## `loadbalancer.listListeners`

List this load balancer's listeners

`GET /v1/load-balancers/{id}/listeners`

```java
public PagedRequest<ListenerListResponse,Listener> listListeners(String id,ListListenersQuery query)
```

## `loadbalancer.listLoadBalancerReplicas`

List the LB's instance replicas with live health

`GET /v1/load-balancers/{id}/replicas`

```java
public PagedRequest<LoadBalancerReplicasResponse,LoadBalancerReplica> listLoadBalancerReplicas(String id,ListLoadBalancerReplicasQuery query)
```

## `loadbalancer.listLoadBalancers`

List load balancers

`GET /v1/load-balancers`

```java
public PagedRequest<LoadBalancerListResponse,LoadBalancer> listLoadBalancers(ListLoadBalancersQuery query)
```

## `loadbalancer.listRules`

List this listener's rules

`GET /v1/load-balancers/{id}/listeners/{listener_id}/rules`

```java
public PagedRequest<RuleListResponse,Rule> listRules(String id,String listener_id,ListRulesQuery query)
```

## `loadbalancer.listTargetGroups`

List target groups

`GET /v1/target-groups`

```java
public PagedRequest<TargetGroupListResponse,TargetGroup> listTargetGroups(ListTargetGroupsQuery query)
```

## `loadbalancer.listTargets`

List targets in this group

`GET /v1/target-groups/{id}/targets`

```java
public PagedRequest<TargetListResponse,Target> listTargets(String id,ListTargetsQuery query)
```

## `loadbalancer.updateListener`

Patch a listener (rotate cert, change default target group)

`PATCH /v1/load-balancers/{id}/listeners/{listener_id}`

```java
public Request<ListenerResponse> updateListener(String id,String listener_id,UpdateListenerRequestInput body)
```

## `loadbalancer.updateLoadBalancer`

Scale or resize a load balancer

`PATCH /v1/load-balancers/{id}`

```java
public Request<LoadBalancerResponse> updateLoadBalancer(String id,UpdateLoadBalancerRequestInput body)
```

## `loadbalancer.updateRule`

Update a routing rule (full replace)

`PATCH /v1/load-balancers/{id}/listeners/{listener_id}/rules/{rule_id}`

```java
public Request<RuleResponse> updateRule(String id,String listener_id,String rule_id,UpdateRuleRequestInput body)
```

## `loadbalancer.updateTargetGroup`

Update target group health checks, framing, or stickiness

`PATCH /v1/target-groups/{id}`

```java
public Request<TargetGroupResponse> updateTargetGroup(String id,UpdateTargetGroupRequestInput body)
```

## `network.attachFloatingIp`

Attach a floating IP to an interface

`POST /v1/floating-ips/{floating_ip_id}/attach`

```java
public Request<AttachFloatingIpResponse> attachFloatingIp(String floating_ip_id,AttachFloatingIpBody body)
```

## `network.attachInternetGateway`

Attach internet gateway to a VPC

`POST /v1/internet-gateways/{internet_gateway_id}/attach`

```java
public Request<InternetGatewayResponse> attachInternetGateway(String internet_gateway_id,InternetGatewayAttachRequestInput body)
```

## `network.createEgressOnlyGateway`

Create egress-only gateway

`POST /v1/egress-only-gateways`

```java
public Request<EgressOnlyGatewayResponse> createEgressOnlyGateway(EgressOnlyGatewayCreateRequestInput body)
```

## `network.createFloatingIp`

Allocate floating IP

`POST /v1/floating-ips`

```java
public Request<FloatingIpResponse> createFloatingIp(FloatingIpCreateRequestInput body)
```

## `network.createInterface`

Create interface

`POST /v1/interfaces`

```java
public Request<InterfaceResponse> createInterface(InterfaceCreateRequestInput body)
```

## `network.createInterfaceAddress`

Create interface address

`POST /v1/interfaces/{interface_id}/addresses`

```java
public Request<CreateInterfaceAddressResponse> createInterfaceAddress(String interface_id,AddressRequestInput body)
```

## `network.createInterfacePrefix`

Create interface prefix

`POST /v1/interfaces/{interface_id}/prefixes`

```java
public Request<CreateInterfacePrefixResponse> createInterfacePrefix(String interface_id,CreateInterfacePrefixBody body)
```

## `network.createInternetGateway`

Create internet gateway

`POST /v1/internet-gateways`

```java
public Request<InternetGatewayResponse> createInternetGateway(InternetGatewayCreateRequestInput body)
```

## `network.createNATGateway`

Create NAT gateway

`POST /v1/nat-gateways`

```java
public Request<NATGatewayResponse> createNATGateway(NATGatewayCreateRequestInput body)
```

## `network.createPrefixPool`

Create prefix pool

`POST /v1/vpcs/{vpc_id}/prefix-pools`

```java
public Request<CreatePrefixPoolResponse> createPrefixPool(String vpc_id,CreatePrefixPoolBody body)
```

## `network.createRoute`

Create route

`POST /v1/route-tables/{route_table_id}/routes`

```java
public Request<RouteResponse> createRoute(String route_table_id,RouteCreateRequestInput body)
```

## `network.createRouteTable`

Create route table

`POST /v1/route-tables`

```java
public Request<RouteTableResponse> createRouteTable(RouteTableCreateRequestInput body)
```

## `network.createSecurityGroup`

Create security group

`POST /v1/security-groups`

```java
public Request<SecurityGroupResponse> createSecurityGroup(SecurityGroupCreateRequestInput body)
```

## `network.createSecurityGroupRule`

Create security group rule

`POST /v1/security-groups/{security_group_id}/rules`

```java
public Request<SecurityGroupRuleResponse> createSecurityGroupRule(String security_group_id,SecurityGroupRuleCreateRequestInput body)
```

## `network.createSubnet`

Create subnet

`POST /v1/subnets`

```java
public Request<SubnetResponse> createSubnet(SubnetCreateRequestInput body)
```

## `network.createVpc`

Create VPC

`POST /v1/vpcs`

```java
public Request<VpcResponse> createVpc(VpcCreateRequestInput body)
```

## `network.deleteEgressOnlyGateway`

Delete egress-only gateway

`DELETE /v1/egress-only-gateways/{egress_only_gateway_id}`

```java
public EmptyRequest deleteEgressOnlyGateway(String egress_only_gateway_id)
```

## `network.deleteFloatingIp`

Release floating IP

`DELETE /v1/floating-ips/{floating_ip_id}`

```java
public EmptyRequest deleteFloatingIp(String floating_ip_id)
```

## `network.deleteInterface`

Delete interface

`DELETE /v1/interfaces/{interface_id}`

```java
public EmptyRequest deleteInterface(String interface_id)
```

## `network.deleteInterfaceAddress`

Delete interface address

`DELETE /v1/interfaces/{interface_id}/addresses/{address_id}`

```java
public EmptyRequest deleteInterfaceAddress(String interface_id,String address_id)
```

## `network.deleteInterfacePrefix`

Delete interface prefix

`DELETE /v1/interfaces/{interface_id}/prefixes/{prefix_id}`

```java
public EmptyRequest deleteInterfacePrefix(String interface_id,String prefix_id)
```

## `network.deleteInternetGateway`

Delete internet gateway

`DELETE /v1/internet-gateways/{internet_gateway_id}`

```java
public EmptyRequest deleteInternetGateway(String internet_gateway_id)
```

## `network.deleteNATGateway`

Delete NAT gateway

`DELETE /v1/nat-gateways/{nat_gateway_id}`

```java
public EmptyRequest deleteNATGateway(String nat_gateway_id)
```

## `network.deletePrefixPool`

Delete prefix pool

`DELETE /v1/vpcs/{vpc_id}/prefix-pools/{pool_id}`

```java
public EmptyRequest deletePrefixPool(String vpc_id,String pool_id)
```

## `network.deleteRoute`

Delete route

`DELETE /v1/route-tables/{route_table_id}/routes/{route_id}`

```java
public EmptyRequest deleteRoute(String route_table_id,String route_id)
```

## `network.deleteRouteTable`

Delete route table

`DELETE /v1/route-tables/{route_table_id}`

```java
public EmptyRequest deleteRouteTable(String route_table_id)
```

## `network.deleteSecurityGroup`

Delete security group

`DELETE /v1/security-groups/{security_group_id}`

```java
public EmptyRequest deleteSecurityGroup(String security_group_id)
```

## `network.deleteSecurityGroupRule`

Delete security group rule

`DELETE /v1/security-groups/{security_group_id}/rules/{rule_id}`

```java
public EmptyRequest deleteSecurityGroupRule(String security_group_id,String rule_id)
```

## `network.deleteSubnet`

Delete subnet

`DELETE /v1/subnets/{subnet_id}`

```java
public EmptyRequest deleteSubnet(String subnet_id)
```

## `network.deleteVpc`

Delete VPC

`DELETE /v1/vpcs/{vpc_id}`

```java
public EmptyRequest deleteVpc(String vpc_id)
```

## `network.detachFloatingIp`

Detach a floating IP

`POST /v1/floating-ips/{floating_ip_id}/detach`

```java
public Request<DetachFloatingIpResponse> detachFloatingIp(String floating_ip_id,DetachFloatingIpBody body)
```

## `network.detachInternetGateway`

Detach internet gateway from its VPC

`POST /v1/internet-gateways/{internet_gateway_id}/detach`

```java
public Request<InternetGatewayResponse> detachInternetGateway(String internet_gateway_id)
```

## `network.getEgressOnlyGateway`

Get egress-only gateway

`GET /v1/egress-only-gateways/{egress_only_gateway_id}`

```java
public Request<EgressOnlyGatewayResponse> getEgressOnlyGateway(String egress_only_gateway_id)
```

## `network.getFloatingIp`

Get floating IP

`GET /v1/floating-ips/{floating_ip_id}`

```java
public Request<FloatingIpResponse> getFloatingIp(String floating_ip_id)
```

## `network.getInterface`

Get interface

`GET /v1/interfaces/{interface_id}`

```java
public Request<InterfaceResponse> getInterface(String interface_id)
```

## `network.getInterfaceAddress`

Get interface address

`GET /v1/interfaces/{interface_id}/addresses/{address_id}`

```java
public Request<GetInterfaceAddressResponse> getInterfaceAddress(String interface_id,String address_id)
```

## `network.getInternetGateway`

Get internet gateway

`GET /v1/internet-gateways/{internet_gateway_id}`

```java
public Request<InternetGatewayResponse> getInternetGateway(String internet_gateway_id)
```

## `network.getNATGateway`

Get NAT gateway

`GET /v1/nat-gateways/{nat_gateway_id}`

```java
public Request<NATGatewayResponse> getNATGateway(String nat_gateway_id)
```

## `network.getRoute`

Get route

`GET /v1/route-tables/{route_table_id}/routes/{route_id}`

```java
public Request<RouteResponse> getRoute(String route_table_id,String route_id)
```

## `network.getRouteTable`

Get route table

`GET /v1/route-tables/{route_table_id}`

```java
public Request<RouteTableResponse> getRouteTable(String route_table_id)
```

## `network.getSecurityGroup`

Get security group

`GET /v1/security-groups/{security_group_id}`

```java
public Request<SecurityGroupResponse> getSecurityGroup(String security_group_id)
```

## `network.getSecurityGroupRule`

Get security group rule

`GET /v1/security-groups/{security_group_id}/rules/{rule_id}`

```java
public Request<SecurityGroupRuleResponse> getSecurityGroupRule(String security_group_id,String rule_id)
```

## `network.getSubnet`

Get subnet

`GET /v1/subnets/{subnet_id}`

```java
public Request<SubnetResponse> getSubnet(String subnet_id)
```

## `network.getVpc`

Get VPC

`GET /v1/vpcs/{vpc_id}`

```java
public Request<VpcResponse> getVpc(String vpc_id)
```

## `network.listEgressOnlyGatewayRoutes`

List egress-only gateway routes

`GET /v1/egress-only-gateways/{egress_only_gateway_id}/routes`

```java
public PagedRequest<GatewayRouteListResponse,GatewayRoute> listEgressOnlyGatewayRoutes(String egress_only_gateway_id,ListEgressOnlyGatewayRoutesQuery query)
```

## `network.listEgressOnlyGateways`

List egress-only gateways

`GET /v1/egress-only-gateways`

```java
public PagedRequest<EgressOnlyGatewayListResponse,EgressOnlyGateway> listEgressOnlyGateways(ListEgressOnlyGatewaysQuery query)
```

## `network.listFloatingIps`

List floating IPs

`GET /v1/floating-ips`

```java
public PagedRequest<FloatingIpListResponse,FloatingIp> listFloatingIps(ListFloatingIpsQuery query)
```

## `network.listInterfaceAddresses`

List interface addresses

`GET /v1/interfaces/{interface_id}/addresses`

```java
public PagedRequest<ListInterfaceAddressesResponse,InterfaceAddress> listInterfaceAddresses(String interface_id)
```

## `network.listInterfacePrefixes`

List interface prefixes

`GET /v1/interfaces/{interface_id}/prefixes`

```java
public PagedRequest<ListInterfacePrefixesResponse,RoutedPrefix> listInterfacePrefixes(String interface_id)
```

## `network.listInterfaceSecurityGroups`

List interface security-group membership

`GET /v1/interfaces/{interface_id}/security-groups`

```java
public PagedRequest<InterfaceSecurityGroupsResponse,String> listInterfaceSecurityGroups(String interface_id,ListInterfaceSecurityGroupsQuery query)
```

## `network.listInterfaces`

List interfaces

`GET /v1/interfaces`

```java
public PagedRequest<InterfaceListResponse,Interface> listInterfaces(ListInterfacesQuery query)
```

## `network.listInternetGatewayRoutes`

List internet gateway routes

`GET /v1/internet-gateways/{internet_gateway_id}/routes`

```java
public PagedRequest<GatewayRouteListResponse,GatewayRoute> listInternetGatewayRoutes(String internet_gateway_id,ListInternetGatewayRoutesQuery query)
```

## `network.listInternetGateways`

List internet gateways

`GET /v1/internet-gateways`

```java
public PagedRequest<InternetGatewayListResponse,InternetGateway> listInternetGateways(ListInternetGatewaysQuery query)
```

## `network.listNATGatewayRoutes`

List NAT gateway routes

`GET /v1/nat-gateways/{nat_gateway_id}/routes`

```java
public PagedRequest<GatewayRouteListResponse,GatewayRoute> listNATGatewayRoutes(String nat_gateway_id,ListNATGatewayRoutesQuery query)
```

## `network.listNATGateways`

List NAT gateways

`GET /v1/nat-gateways`

```java
public PagedRequest<NATGatewayListResponse,NATGateway> listNATGateways(ListNATGatewaysQuery query)
```

## `network.listPrefixPools`

List prefix pools

`GET /v1/vpcs/{vpc_id}/prefix-pools`

```java
public PagedRequest<ListPrefixPoolsResponse,PrefixPool> listPrefixPools(String vpc_id)
```

## `network.listRouteTables`

List route tables

`GET /v1/route-tables`

```java
public PagedRequest<RouteTableListResponse,RouteTable> listRouteTables(ListRouteTablesQuery query)
```

## `network.listRoutes`

List routes

`GET /v1/route-tables/{route_table_id}/routes`

```java
public PagedRequest<RouteListResponse,Route> listRoutes(String route_table_id,ListRoutesQuery query)
```

## `network.listSecurityGroupRules`

List security group rules

`GET /v1/security-groups/{security_group_id}/rules`

```java
public PagedRequest<SecurityGroupRuleListResponse,SecurityGroupRule> listSecurityGroupRules(String security_group_id,ListSecurityGroupRulesQuery query)
```

## `network.listSecurityGroups`

List security groups

`GET /v1/security-groups`

```java
public PagedRequest<SecurityGroupListResponse,SecurityGroup> listSecurityGroups(ListSecurityGroupsQuery query)
```

## `network.listSubnets`

List subnets

`GET /v1/subnets`

```java
public PagedRequest<SubnetListResponse,Subnet> listSubnets(ListSubnetsQuery query)
```

## `network.listVpcs`

List VPCs

`GET /v1/vpcs`

```java
public PagedRequest<VpcListResponse,Vpc> listVpcs(ListVpcsQuery query)
```

## `network.setInterfaceSecurityGroups`

Set interface security-group membership

`PUT /v1/interfaces/{interface_id}/security-groups`

```java
public Request<InterfaceSecurityGroupsResponse> setInterfaceSecurityGroups(String interface_id,InterfaceSecurityGroupsRequestInput body)
```

## `network.updateEgressOnlyGateway`

Update egress-only gateway

`PATCH /v1/egress-only-gateways/{egress_only_gateway_id}`

```java
public Request<EgressOnlyGatewayResponse> updateEgressOnlyGateway(String egress_only_gateway_id,EgressOnlyGatewayUpdateRequestInput body)
```

## `network.updateFloatingIp`

Update floating IP

`PATCH /v1/floating-ips/{floating_ip_id}`

```java
public Request<FloatingIpResponse> updateFloatingIp(String floating_ip_id,FloatingIpUpdateRequestInput body)
```

## `network.updateInterface`

Update interface

`PATCH /v1/interfaces/{interface_id}`

```java
public Request<InterfaceResponse> updateInterface(String interface_id,InterfaceUpdateRequestInput body)
```

## `network.updateInternetGateway`

Update internet gateway

`PATCH /v1/internet-gateways/{internet_gateway_id}`

```java
public Request<InternetGatewayResponse> updateInternetGateway(String internet_gateway_id,InternetGatewayUpdateRequestInput body)
```

## `network.updateNATGateway`

Update NAT gateway

`PATCH /v1/nat-gateways/{nat_gateway_id}`

```java
public Request<NATGatewayResponse> updateNATGateway(String nat_gateway_id,NATGatewayUpdateRequestInput body)
```

## `network.updateRoute`

Update route

`PATCH /v1/route-tables/{route_table_id}/routes/{route_id}`

```java
public Request<RouteResponse> updateRoute(String route_table_id,String route_id,RouteUpdateRequestInput body)
```

## `network.updateRouteTable`

Update route table

`PATCH /v1/route-tables/{route_table_id}`

```java
public Request<RouteTableResponse> updateRouteTable(String route_table_id,RouteTableUpdateRequestInput body)
```

## `network.updateSecurityGroup`

Update security group

`PATCH /v1/security-groups/{security_group_id}`

```java
public Request<SecurityGroupResponse> updateSecurityGroup(String security_group_id,SecurityGroupUpdateRequestInput body)
```

## `network.updateSubnet`

Update subnet

`PATCH /v1/subnets/{subnet_id}`

```java
public Request<SubnetResponse> updateSubnet(String subnet_id,SubnetUpdateRequestInput body)
```

## `network.updateVpc`

Update VPC

`PATCH /v1/vpcs/{vpc_id}`

```java
public Request<VpcResponse> updateVpc(String vpc_id,VpcUpdateRequestInput body)
```

## `quota.listQuotas`

List quotas

`GET /v1/quotas`

```java
public PagedRequest<QuotaListResponse,QuotaItem> listQuotas(ListQuotasQuery query)
```

## `secrets.createSecret`

Create a new secret with an initial value

`POST /v1/secrets`

```java
public Request<SecretResponse> createSecret(CreateSecretRequestInput body)
```

## `secrets.deleteSecret`

Schedule deletion (soft delete with recovery window)

`DELETE /v1/secrets/{secret_id}`

```java
public Request<SecretResponse> deleteSecret(String secret_id,DeleteSecretRequestInput body)
```

## `secrets.describeSecret`

Describe a secret (no value)

`GET /v1/secrets/{secret_id}`

```java
public Request<SecretResponse> describeSecret(String secret_id)
```

## `secrets.getSecretValue`

Read the current value (or a specific version)

`GET /v1/secrets/{secret_id}/value`

```java
public Request<SecretValueResponse> getSecretValue(String secret_id,GetSecretValueQuery query)
```

## `secrets.listSecrets`

List secrets

`GET /v1/secrets`

```java
public PagedRequest<SecretListResponse,Secret> listSecrets(ListSecretsQuery query)
```

## `secrets.listVersions`

List versions

`GET /v1/secrets/{secret_id}/versions`

```java
public PagedRequest<VersionListResponse,SecretVersion> listVersions(String secret_id,ListVersionsQuery query)
```

## `secrets.putSecretValue`

Store a new version (becomes current)

`POST /v1/secrets/{secret_id}/value`

```java
public Request<VersionResponse> putSecretValue(String secret_id,PutSecretValueRequestInput body)
```

## `secrets.restoreSecret`

Restore a secret from the recovery window

`POST /v1/secrets/{secret_id}/restore`

```java
public Request<SecretResponse> restoreSecret(String secret_id)
```

## `secrets.updateSecret`

Update mutable metadata

`PATCH /v1/secrets/{secret_id}`

```java
public Request<SecretResponse> updateSecret(String secret_id,UpdateSecretRequestInput body)
```

## `storage.abortMultipartUpload`

Abort a multipart upload

`DELETE /v1/buckets/{bucket}/multipart-uploads/{upload_id}`

```java
public EmptyRequest abortMultipartUpload(String bucket,String upload_id)
```

## `storage.completeMultipartUpload`

Complete a multipart upload

`POST /v1/buckets/{bucket}/multipart-uploads/{upload_id}/complete`

```java
public Request<CompleteMultipartUploadResponse> completeMultipartUpload(String bucket,String upload_id,CompleteMultipartUploadRequestInput body)
```

## `storage.createBucket`

Create bucket

`POST /v1/buckets`

```java
public Request<BucketResponse> createBucket(CreateBucketRequestInput body)
```

## `storage.createSnapshot`

Create snapshot

`POST /v1/snapshots`

```java
public Request<SnapshotResponse> createSnapshot(SnapshotCreateRequestInput body)
```

## `storage.createSnapshotPolicy`

Create snapshot policy

`POST /v1/snapshot-policies`

```java
public Request<SnapshotPolicyResponse> createSnapshotPolicy(SnapshotPolicyCreateRequestInput body)
```

## `storage.createVolume`

Create volume

`POST /v1/volumes`

```java
public Request<VolumeResponse> createVolume(VolumeCreateRequestInput body)
```

## `storage.deleteBucket`

Delete bucket

`DELETE /v1/buckets/{bucket}`

```java
public Request<DeleteBucketResponse> deleteBucket(String bucket)
```

## `storage.deleteBucketCORS`

Delete bucket CORS configuration

`DELETE /v1/buckets/{bucket}/cors`

```java
public EmptyRequest deleteBucketCORS(String bucket)
```

## `storage.deleteBucketEncryption`

Delete bucket encryption configuration

`DELETE /v1/buckets/{bucket}/encryption`

```java
public EmptyRequest deleteBucketEncryption(String bucket)
```

## `storage.deleteBucketLifecycle`

Delete bucket lifecycle configuration

`DELETE /v1/buckets/{bucket}/lifecycle`

```java
public EmptyRequest deleteBucketLifecycle(String bucket)
```

## `storage.deleteBucketObjectLock`

Delete bucket object-lock configuration

`DELETE /v1/buckets/{bucket}/object-lock`

```java
public EmptyRequest deleteBucketObjectLock(String bucket)
```

## `storage.deleteBucketPolicy`

Delete bucket policy

`DELETE /v1/buckets/{bucket}/policy`

```java
public EmptyRequest deleteBucketPolicy(String bucket)
```

## `storage.deleteBucketTagging`

Delete bucket tag set

`DELETE /v1/buckets/{bucket}/tagging`

```java
public EmptyRequest deleteBucketTagging(String bucket)
```

## `storage.deleteObject`

Delete object

`DELETE /v1/buckets/{bucket}/objects/{key}`

```java
public EmptyRequest deleteObject(String bucket,String key)
```

## `storage.deleteSnapshot`

Delete snapshot

`DELETE /v1/snapshots/{snapshot_id}`

```java
public EmptyRequest deleteSnapshot(String snapshot_id)
```

## `storage.deleteSnapshotPolicy`

Delete snapshot policy

`DELETE /v1/snapshot-policies/{policy_id}`

```java
public EmptyRequest deleteSnapshotPolicy(String policy_id)
```

## `storage.deleteVolume`

Delete volume

`DELETE /v1/volumes/{volume_id}`

```java
public EmptyRequest deleteVolume(String volume_id)
```

## `storage.extendVolume`

Extend volume

`POST /v1/volumes/{volume_id}/extend`

```java
public Request<VolumeResponse> extendVolume(String volume_id,VolumeExtendRequestInput body)
```

## `storage.getBucketCORS`

Get bucket CORS configuration

`GET /v1/buckets/{bucket}/cors`

```java
public Request<BucketCORSResponse> getBucketCORS(String bucket)
```

## `storage.getBucketEncryption`

Get bucket encryption configuration

`GET /v1/buckets/{bucket}/encryption`

```java
public Request<BucketEncryptionResponse> getBucketEncryption(String bucket)
```

## `storage.getBucketLifecycle`

Get bucket lifecycle configuration

`GET /v1/buckets/{bucket}/lifecycle`

```java
public Request<BucketLifecycleResponse> getBucketLifecycle(String bucket)
```

## `storage.getBucketObjectLock`

Get bucket object-lock configuration

`GET /v1/buckets/{bucket}/object-lock`

```java
public Request<BucketObjectLockResponse> getBucketObjectLock(String bucket)
```

## `storage.getBucketPolicy`

Get bucket policy

`GET /v1/buckets/{bucket}/policy`

```java
public Request<BucketPolicyResponse> getBucketPolicy(String bucket)
```

## `storage.getBucketTagging`

Get bucket tag set

`GET /v1/buckets/{bucket}/tagging`

```java
public Request<BucketTaggingResponse> getBucketTagging(String bucket)
```

## `storage.getBucketVersioning`

Get bucket versioning state

`GET /v1/buckets/{bucket}/versioning`

```java
public Request<BucketVersioningResponse> getBucketVersioning(String bucket)
```

## `storage.getObject`

Download object

`GET /v1/buckets/{bucket}/objects/{key}`

```java
public BinaryRequest getObject(String bucket,String key)
```

## `storage.getSnapshot`

Get snapshot

`GET /v1/snapshots/{snapshot_id}`

```java
public Request<SnapshotResponse> getSnapshot(String snapshot_id)
```

## `storage.getSnapshotPolicy`

Get snapshot policy

`GET /v1/snapshot-policies/{policy_id}`

```java
public Request<SnapshotPolicyResponse> getSnapshotPolicy(String policy_id)
```

## `storage.getVolume`

Get volume

`GET /v1/volumes/{volume_id}`

```java
public Request<VolumeResponse> getVolume(String volume_id)
```

## `storage.headBucket`

Head bucket

`HEAD /v1/buckets/{bucket}`

```java
public BinaryRequest headBucket(String bucket)
```

## `storage.headObject`

Head object

`HEAD /v1/buckets/{bucket}/objects/{key}`

```java
public BinaryRequest headObject(String bucket,String key)
```

## `storage.initiateMultipartUpload`

Initiate a multipart upload

`POST /v1/buckets/{bucket}/multipart-uploads`

```java
public Request<MultipartUploadResponse> initiateMultipartUpload(String bucket,InitiateMultipartUploadRequestInput body)
```

## `storage.listBuckets`

List buckets

`GET /v1/buckets`

```java
public PagedRequest<BucketListResponse,Bucket> listBuckets(ListBucketsQuery query)
```

## `storage.listMultipartUploads`

List in-flight multipart uploads

`GET /v1/buckets/{bucket}/multipart-uploads`

```java
public PagedRequest<ListMultipartUploadsResponse,MultipartUpload> listMultipartUploads(String bucket,ListMultipartUploadsQuery query)
```

## `storage.listObjectVersions`

List object versions

`GET /v1/buckets/{bucket}/object-versions`

```java
public PagedRequest<ListObjectVersionsResponse,ObjectVersion> listObjectVersions(String bucket,ListObjectVersionsQuery query)
```

## `storage.listObjects`

List objects

`GET /v1/buckets/{bucket}/objects`

```java
public Request<ObjectListResponse> listObjects(String bucket,ListObjectsQuery query)
```

## `storage.listParts`

List uploaded parts

`GET /v1/buckets/{bucket}/multipart-uploads/{upload_id}/parts`

```java
public PagedRequest<ListPartsResponse,MultipartPart> listParts(String bucket,String upload_id)
```

## `storage.listSnapshotPolicies`

List snapshot policies

`GET /v1/snapshot-policies`

```java
public PagedRequest<SnapshotPolicyListResponse,SnapshotPolicy> listSnapshotPolicies(ListSnapshotPoliciesQuery query)
```

## `storage.listSnapshots`

List snapshots

`GET /v1/snapshots`

```java
public PagedRequest<SnapshotListResponse,Snapshot> listSnapshots(ListSnapshotsQuery query)
```

## `storage.listVolumeTypes`

List volume types

`GET /v1/volume-types`

```java
public PagedRequest<VolumeTypeListResponse,VolumeType> listVolumeTypes(ListVolumeTypesQuery query)
```

## `storage.listVolumes`

List volumes

`GET /v1/volumes`

```java
public PagedRequest<VolumeListResponse,Volume> listVolumes(ListVolumesQuery query)
```

## `storage.putBucketCORS`

Put bucket CORS configuration

`PUT /v1/buckets/{bucket}/cors`

```java
public EmptyRequest putBucketCORS(String bucket,PutBucketCORSRequestInput body)
```

## `storage.putBucketDeletionProtection`

Set bucket deletion protection

`PUT /v1/buckets/{bucket}/deletion-protection`

```java
public EmptyRequest putBucketDeletionProtection(String bucket,PutBucketDeletionProtectionRequestInput body)
```

## `storage.putBucketEncryption`

Put bucket encryption configuration

`PUT /v1/buckets/{bucket}/encryption`

```java
public EmptyRequest putBucketEncryption(String bucket,PutBucketEncryptionRequestInput body)
```

## `storage.putBucketLifecycle`

Put bucket lifecycle configuration

`PUT /v1/buckets/{bucket}/lifecycle`

```java
public EmptyRequest putBucketLifecycle(String bucket,PutBucketLifecycleRequestInput body)
```

## `storage.putBucketObjectLock`

Put bucket object-lock configuration

`PUT /v1/buckets/{bucket}/object-lock`

```java
public EmptyRequest putBucketObjectLock(String bucket,PutBucketObjectLockRequestInput body)
```

## `storage.putBucketPolicy`

Put bucket policy

`PUT /v1/buckets/{bucket}/policy`

```java
public EmptyRequest putBucketPolicy(String bucket,PutBucketPolicyRequestInput body)
```

## `storage.putBucketTagging`

Put bucket tag set

`PUT /v1/buckets/{bucket}/tagging`

```java
public EmptyRequest putBucketTagging(String bucket,PutBucketTaggingRequestInput body)
```

## `storage.putBucketVersioning`

Set bucket versioning state

`PUT /v1/buckets/{bucket}/versioning`

```java
public EmptyRequest putBucketVersioning(String bucket,PutBucketVersioningRequestInput body)
```

## `storage.putObject`

Upload object

`PUT /v1/buckets/{bucket}/objects/{key}`

```java
public Request<PutObjectResponse2> putObject(String bucket,String key,BinaryBody body)
```

## `storage.restoreBucket`

Restore a bucket pending deletion

`POST /v1/buckets/{bucket}/restore`

```java
public EmptyRequest restoreBucket(String bucket)
```

## `storage.updateSnapshot`

Update snapshot metadata

`PATCH /v1/snapshots/{snapshot_id}`

```java
public Request<SnapshotResponse> updateSnapshot(String snapshot_id,SnapshotUpdateRequestInput body)
```

## `storage.updateSnapshotPolicy`

Update snapshot policy

`PATCH /v1/snapshot-policies/{policy_id}`

```java
public Request<SnapshotPolicyResponse> updateSnapshotPolicy(String policy_id,SnapshotPolicyUpdateRequestInput body)
```

## `storage.updateVolume`

Update volume metadata

`PATCH /v1/volumes/{volume_id}`

```java
public Request<VolumeResponse> updateVolume(String volume_id,VolumeUpdateRequestInput body)
```

## `storage.updateVolumePerformance`

Update provisioned performance

`POST /v1/volumes/{volume_id}/performance`

```java
public Request<VolumeResponse> updateVolumePerformance(String volume_id,VolumePerformanceRequestInput body)
```

## `storage.uploadPart`

Upload a part

`PUT /v1/buckets/{bucket}/multipart-uploads/{upload_id}/parts/{part_number}`

```java
public Request<UploadPartResponse> uploadPart(String bucket,String upload_id,String part_number,BinaryBody body)
```

## `telemetry.createLogGroup`

Create a log group

`POST /v1/log-groups`

```java
public Request<LogGroupResponse> createLogGroup(CreateLogGroupRequestInput body)
```

## `telemetry.deleteLogGroup`

Delete a log group

`DELETE /v1/log-groups/{id}`

```java
public EmptyRequest deleteLogGroup(String id)
```

## `telemetry.deleteTraceSettings`

Delete trace settings

`DELETE /v1/trace-settings`

```java
public EmptyRequest deleteTraceSettings()
```

## `telemetry.getLog`

Get a single log record by id

`GET /v1/logs/{log_id}`

```java
public Request<LogResponse> getLog(String log_id)
```

## `telemetry.getLogGroup`

Get a log group by id

`GET /v1/log-groups/{id}`

```java
public Request<LogGroupResponse> getLogGroup(String id)
```

## `telemetry.getRetainedTelemetryPresence`

Check retained telemetry presence

`GET /v1/trace-settings/retained-data`

```java
public Request<GetRetainedTelemetryPresenceResponse> getRetainedTelemetryPresence()
```

## `telemetry.getTrace`

Get all spans for a trace

`GET /v1/traces/{trace_id}`

```java
public Request<TraceResponse> getTrace(String trace_id)
```

## `telemetry.getTraceSettings`

Get the caller account's trace settings

`GET /v1/trace-settings`

```java
public Request<TraceSettingsResponse> getTraceSettings()
```

## `telemetry.ingestLogs`

Ingest a batch of log records

`POST /v1/logs`

```java
public Request<IngestResult> ingestLogs(IngestRequestInput body)
```

## `telemetry.ingestSpans`

Ingest a batch of trace spans

`POST /v1/spans`

```java
public Request<IngestResult> ingestSpans(IngestSpansRequestInput body)
```

## `telemetry.listLogGroups`

List log groups (or look up one by name)

`GET /v1/log-groups`

```java
public PagedRequest<LogGroupListResponse,LogGroup> listLogGroups(ListLogGroupsQuery query)
```

## `telemetry.listMetricNames`

List the distinct metric names emitted in a time window

`GET /v1/metrics/names`

```java
public PagedRequest<ListMetricNamesResponse,String> listMetricNames(ListMetricNamesQuery query)
```

## `telemetry.listMetricNamesPost`

List the distinct metric names emitted in a time window (form body)

`POST /v1/metrics/names`

```java
public Request<ListMetricNamesPostResponse> listMetricNamesPost(ListMetricNamesPostBody body)
```

## `telemetry.listMetricSeries`

List distinct label sets for a metric

`GET /v1/metrics/series`

```java
public Request<Map<String, JsonNode>> listMetricSeries(ListMetricSeriesQuery query)
```

## `telemetry.listMetricSeriesPost`

List distinct label sets for a metric (form body)

`POST /v1/metrics/series`

```java
public Request<Map<String, JsonNode>> listMetricSeriesPost(ListMetricSeriesPostBody body)
```

## `telemetry.putTraceSettings`

Update the caller account's trace settings

`PUT /v1/trace-settings`

```java
public Request<TraceSettingsResponse> putTraceSettings(UpdateTraceSettingsRequestInput body)
```

## `telemetry.queryMetricsInstant`

Instant structured metric query

`GET /v1/metrics/query`

```java
public Request<Map<String, JsonNode>> queryMetricsInstant(QueryMetricsInstantQuery query)
```

## `telemetry.queryMetricsInstantPost`

Instant structured metric query (form body)

`POST /v1/metrics/query`

```java
public Request<Map<String, JsonNode>> queryMetricsInstantPost(QueryMetricsInstantPostBody body)
```

## `telemetry.queryMetricsRange`

Range structured metric query

`GET /v1/metrics/query_range`

```java
public Request<Map<String, JsonNode>> queryMetricsRange(QueryMetricsRangeQuery query)
```

## `telemetry.queryMetricsRangePost`

Range structured metric query (form body)

`POST /v1/metrics/query_range`

```java
public Request<Map<String, JsonNode>> queryMetricsRangePost(QueryMetricsRangePostBody body)
```

## `telemetry.searchLogs`

Search log records

`GET /v1/logs`

```java
public Request<LogListResponse> searchLogs(SearchLogsQuery query)
```

## `telemetry.searchTraces`

List traces

`GET /v1/traces`

```java
public Request<TraceListResponse> searchTraces(SearchTracesQuery query)
```

## `telemetry.updateLogGroup`

Update a log group

`PATCH /v1/log-groups/{id}`

```java
public Request<LogGroupResponse> updateLogGroup(String id,UpdateLogGroupRequestInput body)
```

## `telemetry.writeMetrics`

Prometheus remote_write ingest

`POST /v1/metrics/write`

```java
public EmptyRequest writeMetrics(BinaryBody body)
```

## `workspace.addUser`

Add user to organization

`POST /v1/users`

```java
public Request<UserAddResponse> addUser(UserAddRequestInput body)
```

## `workspace.addUserToGroup`

Add user to group

`POST /v1/users/{user_id}/groups`

```java
public EmptyRequest addUserToGroup(String user_id,UserGroupAddRequestInput body)
```

## `workspace.assignAccountRole`

Assign account role

`POST /v1/accounts/{account_id}/role-assignments`

```java
public Request<AccountRoleAssignmentResponse> assignAccountRole(String account_id,AccountRoleAssignmentCreateRequestInput body)
```

## `workspace.attachGroupPolicy`

Attach policy to group

`POST /v1/groups/{group_id}/policies`

```java
public EmptyRequest attachGroupPolicy(String group_id,PolicyAttachRequestInput body)
```

## `workspace.attachRolePolicy`

Attach policy to role

`POST /v1/roles/{role_id}/policies`

```java
public EmptyRequest attachRolePolicy(String role_id,OrganizationPolicyAttachRequestInput body)
```

## `workspace.attachServiceAccountPolicy`

Attach policy to service account

`POST /v1/service-accounts/{service_account_id}/policies`

```java
public EmptyRequest attachServiceAccountPolicy(String service_account_id,OrganizationPolicyAttachRequestInput body)
```

## `workspace.attachUserPolicy`

Attach policy to user

`POST /v1/users/{user_id}/policies`

```java
public EmptyRequest attachUserPolicy(String user_id,PolicyAttachRequestInput body)
```

## `workspace.cancelInvitation`

Cancel invitation

`DELETE /v1/invitations/{invitation_id}`

```java
public EmptyRequest cancelInvitation(String invitation_id)
```

## `workspace.createAccount`

Create account

`POST /v1/accounts`

```java
public Request<AccountResponse> createAccount(CreateAccountRequestInput body)
```

## `workspace.createGroup`

Create group

`POST /v1/groups`

```java
public Request<CreateGroupResponse> createGroup(GroupCreateRequestInput body)
```

## `workspace.createPolicy`

Create policy

`POST /v1/policies`

```java
public Request<CreatePolicyResponse> createPolicy(PolicyCreateRequestInput body)
```

## `workspace.deleteAccount`

Delete account

`DELETE /v1/accounts/{account_id}`

```java
public EmptyRequest deleteAccount(String account_id)
```

## `workspace.deleteGroup`

Delete group

`DELETE /v1/groups/{group_id}`

```java
public EmptyRequest deleteGroup(String group_id)
```

## `workspace.deleteGroupInlinePolicy`

Delete a group's inline policy by name

`DELETE /v1/groups/{group_id}/inline-policies/{policy_name}`

```java
public EmptyRequest deleteGroupInlinePolicy(String group_id,String policy_name)
```

## `workspace.deleteOrganization`

Delete organization

`DELETE /v1/organizations/{organization_id}`

```java
public EmptyRequest deleteOrganization(String organization_id)
```

## `workspace.deletePolicy`

Delete policy

`DELETE /v1/policies/{policy_id}`

```java
public EmptyRequest deletePolicy(String policy_id)
```

## `workspace.deleteUserInlinePolicy`

Delete a user's inline policy by name

`DELETE /v1/users/{user_id}/inline-policies/{policy_name}`

```java
public EmptyRequest deleteUserInlinePolicy(String user_id,String policy_name)
```

## `workspace.detachGroupPolicy`

Detach policy from group

`DELETE /v1/groups/{group_id}/policies/{policy_id}`

```java
public EmptyRequest detachGroupPolicy(String group_id,String policy_id)
```

## `workspace.detachRolePolicy`

Detach policy from role

`DELETE /v1/roles/{role_id}/policies/{policy_id}`

```java
public EmptyRequest detachRolePolicy(String role_id,String policy_id)
```

## `workspace.detachServiceAccountPolicy`

Detach policy from service account

`DELETE /v1/service-accounts/{service_account_id}/policies/{policy_id}`

```java
public EmptyRequest detachServiceAccountPolicy(String service_account_id,String policy_id)
```

## `workspace.detachUserPolicy`

Detach policy from user

`DELETE /v1/users/{user_id}/policies/{policy_id}`

```java
public EmptyRequest detachUserPolicy(String user_id,String policy_id)
```

## `workspace.getAccount`

Get account

`GET /v1/accounts/{account_id}`

```java
public Request<AccountResponse> getAccount(String account_id)
```

## `workspace.getAccountResources`

Check account resource presence

`GET /v1/accounts/{account_id}/resources`

```java
public Request<GetAccountResourcesResponse> getAccountResources(String account_id)
```

## `workspace.getGroup`

Get group

`GET /v1/groups/{group_id}`

```java
public Request<GetGroupResponse> getGroup(String group_id)
```

## `workspace.getGroupInlinePolicy`

Get a group's inline policy by name

`GET /v1/groups/{group_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> getGroupInlinePolicy(String group_id,String policy_name)
```

## `workspace.getInvitation`

Get invitation

`GET /v1/invitations/{invitation_id}`

```java
public Request<GetInvitationResponse> getInvitation(String invitation_id)
```

## `workspace.getOrganization`

Get organization

`GET /v1/organizations/{organization_id}`

```java
public Request<OrganizationResponse> getOrganization(String organization_id)
```

## `workspace.getPolicy`

Get policy

`GET /v1/policies/{policy_id}`

```java
public Request<GetPolicyResponse> getPolicy(String policy_id)
```

## `workspace.getUser`

Get user

`GET /v1/users/{user_id}`

```java
public Request<GetUserResponse> getUser(String user_id)
```

## `workspace.getUserInlinePolicy`

Get a user's inline policy by name

`GET /v1/users/{user_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> getUserInlinePolicy(String user_id,String policy_name)
```

## `workspace.getUserPermissionBoundary`

Get a user's permission boundary

`GET /v1/users/{user_id}/permission-boundary`

```java
public Request<PermissionBoundaryResponse> getUserPermissionBoundary(String user_id)
```

## `workspace.listAccountRoleAssignments`

List account role assignments

`GET /v1/accounts/{account_id}/role-assignments`

```java
public PagedRequest<AccountRoleAssignmentListResponse,AccountRoleAssignment> listAccountRoleAssignments(String account_id)
```

## `workspace.listAccountRoles`

List assigned account roles

`GET /v1/account-roles`

```java
public PagedRequest<AccountRoleListResponse,AccountRole> listAccountRoles()
```

## `workspace.listAccounts`

List accounts

`GET /v1/accounts`

```java
public PagedRequest<AccountListResponse,Account> listAccounts(ListAccountsQuery query)
```

## `workspace.listGroupInlinePolicies`

List a group's inline policies

`GET /v1/groups/{group_id}/inline-policies`

```java
public PagedRequest<InlinePolicyListResponse,InlinePolicy> listGroupInlinePolicies(String group_id,ListGroupInlinePoliciesQuery query)
```

## `workspace.listGroupPolicies`

List group policies

`GET /v1/groups/{group_id}/policies`

```java
public PagedRequest<PrincipalPoliciesListResponse,Policy> listGroupPolicies(String group_id,ListGroupPoliciesQuery query)
```

## `workspace.listGroupUsers`

List group users

`GET /v1/groups/{group_id}/users`

```java
public PagedRequest<GroupUsersListResponse,GroupUser> listGroupUsers(String group_id,ListGroupUsersQuery query)
```

## `workspace.listGroups`

List groups

`GET /v1/groups`

```java
public PagedRequest<GroupListResponse,Group> listGroups(ListGroupsQuery query)
```

## `workspace.listInvitations`

List invitations

`GET /v1/invitations`

```java
public PagedRequest<InvitationListResponse,Invitation> listInvitations(ListInvitationsQuery query)
```

## `workspace.listOrganizations`

List organizations

`GET /v1/organizations`

```java
public PagedRequest<OrganizationListResponse,OrganizationWithMembership> listOrganizations(ListOrganizationsQuery query)
```

## `workspace.listPolicies`

List policies

`GET /v1/policies`

```java
public PagedRequest<PolicyListResponse,Policy> listPolicies(ListPoliciesQuery query)
```

## `workspace.listPolicyGroups`

List groups with policy

`GET /v1/policies/{policy_id}/groups`

```java
public PagedRequest<PolicyGroupsListResponse,Group> listPolicyGroups(String policy_id,ListPolicyGroupsQuery query)
```

## `workspace.listPolicyRoles`

List roles with policy

`GET /v1/policies/{policy_id}/roles`

```java
public PagedRequest<PolicyRolesListResponse,AccountPrincipalReference> listPolicyRoles(String policy_id,ListPolicyRolesQuery query)
```

## `workspace.listPolicyServiceAccounts`

List service accounts with policy

`GET /v1/policies/{policy_id}/service-accounts`

```java
public PagedRequest<PolicyServiceAccountsListResponse,AccountPrincipalReference> listPolicyServiceAccounts(String policy_id,ListPolicyServiceAccountsQuery query)
```

## `workspace.listPolicyUsers`

List users with policy

`GET /v1/policies/{policy_id}/users`

```java
public PagedRequest<PolicyUsersListResponse,User> listPolicyUsers(String policy_id,ListPolicyUsersQuery query)
```

## `workspace.listRolePolicies`

List role policies

`GET /v1/roles/{role_id}/policies`

```java
public PagedRequest<RolePoliciesListResponse,Policy> listRolePolicies(String role_id,ListRolePoliciesQuery query)
```

## `workspace.listServiceAccountPolicies`

List service account policies

`GET /v1/service-accounts/{service_account_id}/policies`

```java
public PagedRequest<PrincipalPoliciesListResponse,Policy> listServiceAccountPolicies(String service_account_id,ListServiceAccountPoliciesQuery query)
```

## `workspace.listUserGroups`

List user groups

`GET /v1/users/{user_id}/groups`

```java
public PagedRequest<GroupListResponse,Group> listUserGroups(String user_id,ListUserGroupsQuery query)
```

## `workspace.listUserInlinePolicies`

List a user's inline policies

`GET /v1/users/{user_id}/inline-policies`

```java
public PagedRequest<InlinePolicyListResponse,InlinePolicy> listUserInlinePolicies(String user_id,ListUserInlinePoliciesQuery query)
```

## `workspace.listUserPolicies`

List user policies

`GET /v1/users/{user_id}/policies`

```java
public PagedRequest<PrincipalPoliciesListResponse,Policy> listUserPolicies(String user_id,ListUserPoliciesQuery query)
```

## `workspace.listUsers`

List users

`GET /v1/users`

```java
public PagedRequest<UserListResponse,User> listUsers(ListUsersQuery query)
```

## `workspace.putGroupInlinePolicy`

Create or replace a group's inline policy

`PUT /v1/groups/{group_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> putGroupInlinePolicy(String group_id,String policy_name,PutInlinePolicyRequestInput body)
```

## `workspace.putUserInlinePolicy`

Create or replace a user's inline policy

`PUT /v1/users/{user_id}/inline-policies/{policy_name}`

```java
public Request<InlinePolicyResponse> putUserInlinePolicy(String user_id,String policy_name,PutInlinePolicyRequestInput body)
```

## `workspace.removeAccountRoleAssignment`

Remove account role assignment

`DELETE /v1/accounts/{account_id}/role-assignments/{assignment_id}`

```java
public EmptyRequest removeAccountRoleAssignment(String account_id,String assignment_id)
```

## `workspace.removeUser`

Remove user from organization

`DELETE /v1/users/{user_id}`

```java
public EmptyRequest removeUser(String user_id)
```

## `workspace.removeUserFromGroup`

Remove user from group

`DELETE /v1/users/{user_id}/groups/{group_id}`

```java
public EmptyRequest removeUserFromGroup(String user_id,String group_id)
```

## `workspace.removeUserPermissionBoundary`

Remove a user's permission boundary

`DELETE /v1/users/{user_id}/permission-boundary`

```java
public EmptyRequest removeUserPermissionBoundary(String user_id)
```

## `workspace.setUserPermissionBoundary`

Set a user's permission boundary

`PUT /v1/users/{user_id}/permission-boundary`

```java
public EmptyRequest setUserPermissionBoundary(String user_id,SetBoundaryRequestInput body)
```

## `workspace.updateAccount`

Update account

`PATCH /v1/accounts/{account_id}`

```java
public Request<AccountResponse> updateAccount(String account_id,UpdateAccountRequestInput body)
```

## `workspace.updateGroup`

Update group

`PATCH /v1/groups/{group_id}`

```java
public Request<UpdateGroupResponse> updateGroup(String group_id,GroupUpdateRequestInput body)
```

## `workspace.updateOrganization`

Update organization

`PATCH /v1/organizations/{organization_id}`

```java
public Request<OrganizationResponse> updateOrganization(String organization_id,OrganizationUpdateRequestInput body)
```

## `workspace.updatePolicy`

Update policy

`PATCH /v1/policies/{policy_id}`

```java
public Request<UpdatePolicyResponse> updatePolicy(String policy_id,PolicyUpdateRequestInput body)
```
