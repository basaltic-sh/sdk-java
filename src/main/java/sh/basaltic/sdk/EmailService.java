package sh.basaltic.sdk;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import sh.basaltic.sdk.models.Email.BatchSendRequestInput;
import sh.basaltic.sdk.models.Email.BatchSendResponse;
import sh.basaltic.sdk.models.Email.ConfigurationSet;
import sh.basaltic.sdk.models.Email.ConfigurationSetListResponse;
import sh.basaltic.sdk.models.Email.ConfigurationSetResponse;
import sh.basaltic.sdk.models.Email.CreateConfigurationSetRequestInput;
import sh.basaltic.sdk.models.Email.CreateIPPoolRequestInput;
import sh.basaltic.sdk.models.Email.CreateIdentityRequestInput;
import sh.basaltic.sdk.models.Email.CreateRecipientRuleRequestInput;
import sh.basaltic.sdk.models.Email.CreateSuppressionRequestInput;
import sh.basaltic.sdk.models.Email.CreateTemplateRequestInput;
import sh.basaltic.sdk.models.Email.DMARCReportListResponse;
import sh.basaltic.sdk.models.Email.DMARCReportRecord;
import sh.basaltic.sdk.models.Email.DedicatedIP;
import sh.basaltic.sdk.models.Email.DedicatedIPListResponse;
import sh.basaltic.sdk.models.Email.DedicatedIPResponse;
import sh.basaltic.sdk.models.Email.IPPool;
import sh.basaltic.sdk.models.Email.IPPoolListResponse;
import sh.basaltic.sdk.models.Email.IPPoolResponse;
import sh.basaltic.sdk.models.Email.Identity;
import sh.basaltic.sdk.models.Email.IdentityListResponse;
import sh.basaltic.sdk.models.Email.IdentityResponse;
import sh.basaltic.sdk.models.Email.ListConfigurationSetsQuery;
import sh.basaltic.sdk.models.Email.ListDMARCReportsQuery;
import sh.basaltic.sdk.models.Email.ListDedicatedIPsQuery;
import sh.basaltic.sdk.models.Email.ListIPPoolsQuery;
import sh.basaltic.sdk.models.Email.ListIdentitiesQuery;
import sh.basaltic.sdk.models.Email.ListReceivedMessagesQuery;
import sh.basaltic.sdk.models.Email.ListRecipientRulesQuery;
import sh.basaltic.sdk.models.Email.ListRejectionsQuery;
import sh.basaltic.sdk.models.Email.ListSentMessagesQuery;
import sh.basaltic.sdk.models.Email.ListSuppressionsQuery;
import sh.basaltic.sdk.models.Email.ListTemplatesQuery;
import sh.basaltic.sdk.models.Email.Message;
import sh.basaltic.sdk.models.Email.MessageContentResponse;
import sh.basaltic.sdk.models.Email.MessageEngagementResponse;
import sh.basaltic.sdk.models.Email.MessageListResponse;
import sh.basaltic.sdk.models.Email.MessageResponse;
import sh.basaltic.sdk.models.Email.ReceivedMessage;
import sh.basaltic.sdk.models.Email.ReceivedMessageListResponse;
import sh.basaltic.sdk.models.Email.ReceivedMessageResponse;
import sh.basaltic.sdk.models.Email.ReceivingConfigurationResponse;
import sh.basaltic.sdk.models.Email.RecipientRule;
import sh.basaltic.sdk.models.Email.RecipientRuleListResponse;
import sh.basaltic.sdk.models.Email.RecipientRuleResponse;
import sh.basaltic.sdk.models.Email.Rejection;
import sh.basaltic.sdk.models.Email.RejectionListResponse;
import sh.basaltic.sdk.models.Email.RequestDedicatedIPRequestInput;
import sh.basaltic.sdk.models.Email.SendMessageRequestInput;
import sh.basaltic.sdk.models.Email.SetBIMIRequestInput;
import sh.basaltic.sdk.models.Email.SetMailFromDomainRequestInput;
import sh.basaltic.sdk.models.Email.Suppression;
import sh.basaltic.sdk.models.Email.SuppressionListResponse;
import sh.basaltic.sdk.models.Email.SuppressionOverrideRequestInput;
import sh.basaltic.sdk.models.Email.SuppressionResponse;
import sh.basaltic.sdk.models.Email.Template;
import sh.basaltic.sdk.models.Email.TemplateListResponse;
import sh.basaltic.sdk.models.Email.TemplateResponse;
import sh.basaltic.sdk.models.Email.UpdateConfigurationSetRequestInput;
import sh.basaltic.sdk.models.Email.UpdateDedicatedIPRequestInput;
import sh.basaltic.sdk.models.Email.UpdateIPPoolRequestInput;
import sh.basaltic.sdk.models.Email.UpdateIdentityRequestInput;
import sh.basaltic.sdk.models.Email.UpdateReceivingConfigurationRequestInput;
import sh.basaltic.sdk.models.Email.UpdateRecipientRuleRequestInput;
import sh.basaltic.sdk.models.Email.UpdateSuppressionRequestInput;
import sh.basaltic.sdk.models.Email.UpdateTemplateRequestInput;

/** Typed email API methods. */
public final class EmailService {
  private final Transport transport;

  EmailService(Transport transport) {
    this.transport = transport;
  }

  private static final Operation OP_0 =
      new Operation(
          "addSuppressionOverride",
          "POST",
          "/v1/configuration-sets/{configuration_set_id}/suppression-overrides",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_1 =
      new Operation(
          "beginDKIMRotation",
          "POST",
          "/v1/identities/{identity_id}/dkim/rotate",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_2 =
      new Operation(
          "cancelDKIMRotation",
          "DELETE",
          "/v1/identities/{identity_id}/dkim/rotate",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_3 =
      new Operation(
          "createConfigurationSet",
          "POST",
          "/v1/configuration-sets",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_4 =
      new Operation(
          "createIPPool",
          "POST",
          "/v1/ip-pools",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_5 =
      new Operation(
          "createIdentity",
          "POST",
          "/v1/identities",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_6 =
      new Operation(
          "createRecipientRule",
          "POST",
          "/v1/identities/{identity_id}/recipient-rules",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_7 =
      new Operation(
          "createSuppression",
          "POST",
          "/v1/suppressions",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_8 =
      new Operation(
          "createTemplate",
          "POST",
          "/v1/templates",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_9 =
      new Operation(
          "deleteConfigurationSet",
          "DELETE",
          "/v1/configuration-sets/{configuration_set_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_10 =
      new Operation(
          "deleteIPPool",
          "DELETE",
          "/v1/ip-pools/{ip_pool_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_11 =
      new Operation(
          "deleteIdentity",
          "DELETE",
          "/v1/identities/{identity_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_12 =
      new Operation(
          "deleteRecipientRule",
          "DELETE",
          "/v1/identities/{identity_id}/recipient-rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_13 =
      new Operation(
          "deleteSuppression",
          "DELETE",
          "/v1/suppressions/{suppression_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_14 =
      new Operation(
          "deleteTemplate",
          "DELETE",
          "/v1/templates/{template_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_15 =
      new Operation(
          "describeConfigurationSet",
          "GET",
          "/v1/configuration-sets/{configuration_set_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_16 =
      new Operation(
          "describeDedicatedIP",
          "GET",
          "/v1/dedicated-ips/{dedicated_ip_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_17 =
      new Operation(
          "describeIPPool",
          "GET",
          "/v1/ip-pools/{ip_pool_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_18 =
      new Operation(
          "describeIdentity",
          "GET",
          "/v1/identities/{identity_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_19 =
      new Operation(
          "describeReceivedMessage",
          "GET",
          "/v1/received-messages/{message_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_20 =
      new Operation(
          "describeRecipientRule",
          "GET",
          "/v1/identities/{identity_id}/recipient-rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_21 =
      new Operation(
          "describeSentMessage",
          "GET",
          "/v1/sent-messages/{message_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_22 =
      new Operation(
          "describeSuppression",
          "GET",
          "/v1/suppressions/{suppression_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_23 =
      new Operation(
          "describeTemplate",
          "GET",
          "/v1/templates/{template_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_24 =
      new Operation(
          "downloadReceivedAttachment",
          "GET",
          "/v1/received-messages/{message_id}/attachments/{attachment_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_25 =
      new Operation(
          "downloadReceivedMessage",
          "GET",
          "/v1/received-messages/{message_id}/raw",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_26 =
      new Operation(
          "downloadSentAttachment",
          "GET",
          "/v1/sent-messages/{message_id}/attachments/{attachment_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_27 =
      new Operation(
          "downloadSentMessage",
          "GET",
          "/v1/sent-messages/{message_id}/raw",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "*/*");
  private static final Operation OP_28 =
      new Operation(
          "finalizeDKIMRotation",
          "POST",
          "/v1/identities/{identity_id}/dkim/rotate/finalize",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_29 =
      new Operation(
          "getReceivedMessageContent",
          "GET",
          "/v1/received-messages/{message_id}/content",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_30 =
      new Operation(
          "getReceivingConfiguration",
          "GET",
          "/v1/identities/{identity_id}/receiving",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_31 =
      new Operation(
          "getSentMessageContent",
          "GET",
          "/v1/sent-messages/{message_id}/content",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_32 =
      new Operation(
          "getSentMessageEngagement",
          "GET",
          "/v1/sent-messages/{message_id}/engagement",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_33 =
      new Operation(
          "listConfigurationSets",
          "GET",
          "/v1/configuration-sets",
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
  private static final Operation OP_34 =
      new Operation(
          "listDMARCReports",
          "GET",
          "/v1/identities/{identity_id}/dmarc-reports",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("from", new Operation.Encoding("form", true)),
              Map.entry("to", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_35 =
      new Operation(
          "listDedicatedIPs",
          "GET",
          "/v1/dedicated-ips",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("ip_pool", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_36 =
      new Operation(
          "listIPPools",
          "GET",
          "/v1/ip-pools",
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
  private static final Operation OP_37 =
      new Operation(
          "listIdentities",
          "GET",
          "/v1/identities",
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
  private static final Operation OP_38 =
      new Operation(
          "listReceivedMessages",
          "GET",
          "/v1/received-messages",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("identity", new Operation.Encoding("form", true)),
              Map.entry("recipient", new Operation.Encoding("form", true)),
              Map.entry("review_reason", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_39 =
      new Operation(
          "listRecipientRules",
          "GET",
          "/v1/identities/{identity_id}/recipient-rules",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_40 =
      new Operation(
          "listRejections",
          "GET",
          "/v1/rejections",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("before", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("identity", new Operation.Encoding("form", true)),
              Map.entry("reason", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_41 =
      new Operation(
          "listSentMessages",
          "GET",
          "/v1/sent-messages",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true)),
              Map.entry("identity", new Operation.Encoding("form", true)),
              Map.entry("status", new Operation.Encoding("form", true)),
              Map.entry("recipient", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_42 =
      new Operation(
          "listSuppressions",
          "GET",
          "/v1/suppressions",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(
              Map.entry("crn", new Operation.Encoding("form", true)),
              Map.entry("reason", new Operation.Encoding("form", true)),
              Map.entry("marker", new Operation.Encoding("form", true)),
              Map.entry("limit", new Operation.Encoding("form", true))),
          false,
          "",
          "application/json");
  private static final Operation OP_43 =
      new Operation(
          "listTemplates",
          "GET",
          "/v1/templates",
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
  private static final Operation OP_44 =
      new Operation(
          "releaseDedicatedIP",
          "DELETE",
          "/v1/dedicated-ips/{dedicated_ip_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_45 =
      new Operation(
          "removeSuppressionOverride",
          "DELETE",
          "/v1/configuration-sets/{configuration_set_id}/suppression-overrides/{address}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_46 =
      new Operation(
          "requestDedicatedIP",
          "POST",
          "/v1/dedicated-ips",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "application/json",
          "application/json");
  private static final Operation OP_47 =
      new Operation(
          "sendMessage",
          "POST",
          "/v1/sent-messages",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_48 =
      new Operation(
          "sendMessageBatch",
          "POST",
          "/v1/sent-messages/batch",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_49 =
      new Operation(
          "setBIMI",
          "PATCH",
          "/v1/identities/{identity_id}/bimi",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_50 =
      new Operation(
          "setMailFromDomain",
          "PATCH",
          "/v1/identities/{identity_id}/mail-from-domain",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_51 =
      new Operation(
          "updateConfigurationSet",
          "PATCH",
          "/v1/configuration-sets/{configuration_set_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_52 =
      new Operation(
          "updateDedicatedIP",
          "PATCH",
          "/v1/dedicated-ips/{dedicated_ip_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_53 =
      new Operation(
          "updateIPPool",
          "PATCH",
          "/v1/ip-pools/{ip_pool_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_54 =
      new Operation(
          "updateIdentity",
          "PATCH",
          "/v1/identities/{identity_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_55 =
      new Operation(
          "updateReceivingConfiguration",
          "PATCH",
          "/v1/identities/{identity_id}/receiving",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_56 =
      new Operation(
          "updateRecipientRule",
          "PATCH",
          "/v1/identities/{identity_id}/recipient-rules/{rule_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_57 =
      new Operation(
          "updateSuppression",
          "PATCH",
          "/v1/suppressions/{suppression_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_58 =
      new Operation(
          "updateTemplate",
          "PATCH",
          "/v1/templates/{template_id}",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          true,
          "application/json",
          "application/json");
  private static final Operation OP_59 =
      new Operation(
          "verifyBIMI",
          "POST",
          "/v1/identities/{identity_id}/bimi/verify",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_60 =
      new Operation(
          "verifyIdentity",
          "POST",
          "/v1/identities/{identity_id}/verify",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");
  private static final Operation OP_61 =
      new Operation(
          "verifyMailFromDomain",
          "POST",
          "/v1/identities/{identity_id}/mail-from-domain/verify",
          true,
          List.of(),
          List.of(),
          Map.ofEntries(),
          false,
          "",
          "application/json");

  /** Add a suppression override address */
  public Request<ConfigurationSetResponse> addSuppressionOverride(
      String configuration_set_id, SuppressionOverrideRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_0,
            Map.ofEntries(Map.entry("configuration_set_id", configuration_set_id)),
            body,
            null),
        new TypeReference<ConfigurationSetResponse>() {});
  }

  /** Begin DKIM key rotation */
  public Request<IdentityResponse> beginDKIMRotation(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_1,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Cancel in-progress DKIM rotation */
  public Request<IdentityResponse> cancelDKIMRotation(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_2,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Create a configuration set */
  public Request<ConfigurationSetResponse> createConfigurationSet(
      CreateConfigurationSetRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_3,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<ConfigurationSetResponse>() {});
  }

  /** Create an IP pool */
  public Request<IPPoolResponse> createIPPool(CreateIPPoolRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_4,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<IPPoolResponse>() {});
  }

  /** Create a sender identity */
  public Request<IdentityResponse> createIdentity(CreateIdentityRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_5,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Create recipient rule */
  public Request<RecipientRuleResponse> createRecipientRule(
      String identity_id, CreateRecipientRuleRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_6,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            body,
            null),
        new TypeReference<RecipientRuleResponse>() {});
  }

  /** Add a suppression entry */
  public Request<SuppressionResponse> createSuppression(CreateSuppressionRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_7,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<SuppressionResponse>() {});
  }

  /** Create a template */
  public Request<TemplateResponse> createTemplate(CreateTemplateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_8,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<TemplateResponse>() {});
  }

  /** Delete a configuration set */
  public EmptyRequest deleteConfigurationSet(String configuration_set_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_9,
            Map.ofEntries(Map.entry("configuration_set_id", configuration_set_id)),
            null,
            null));
  }

  /** Delete an IP pool */
  public EmptyRequest deleteIPPool(String ip_pool_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_10,
            Map.ofEntries(Map.entry("ip_pool_id", ip_pool_id)),
            null,
            null));
  }

  /** Delete an identity */
  public EmptyRequest deleteIdentity(String identity_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_11,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null));
  }

  /** Delete recipient rule */
  public EmptyRequest deleteRecipientRule(String identity_id, String rule_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_12,
            Map.ofEntries(Map.entry("identity_id", identity_id), Map.entry("rule_id", rule_id)),
            null,
            null));
  }

  /** Delete suppression */
  public EmptyRequest deleteSuppression(String suppression_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_13,
            Map.ofEntries(Map.entry("suppression_id", suppression_id)),
            null,
            null));
  }

  /** Delete a template */
  public EmptyRequest deleteTemplate(String template_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_14,
            Map.ofEntries(Map.entry("template_id", template_id)),
            null,
            null));
  }

  /** Describe a configuration set */
  public Request<ConfigurationSetResponse> describeConfigurationSet(String configuration_set_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_15,
            Map.ofEntries(Map.entry("configuration_set_id", configuration_set_id)),
            null,
            null),
        new TypeReference<ConfigurationSetResponse>() {});
  }

  /** Describe a dedicated IP */
  public Request<DedicatedIPResponse> describeDedicatedIP(String dedicated_ip_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_16,
            Map.ofEntries(Map.entry("dedicated_ip_id", dedicated_ip_id)),
            null,
            null),
        new TypeReference<DedicatedIPResponse>() {});
  }

  /** Describe an IP pool */
  public Request<IPPoolResponse> describeIPPool(String ip_pool_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_17,
            Map.ofEntries(Map.entry("ip_pool_id", ip_pool_id)),
            null,
            null),
        new TypeReference<IPPoolResponse>() {});
  }

  /** Describe an identity */
  public Request<IdentityResponse> describeIdentity(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_18,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Get received message metadata */
  public Request<ReceivedMessageResponse> describeReceivedMessage(String message_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_19,
            Map.ofEntries(Map.entry("message_id", message_id)),
            null,
            null),
        new TypeReference<ReceivedMessageResponse>() {});
  }

  /** Get recipient rule */
  public Request<RecipientRuleResponse> describeRecipientRule(String identity_id, String rule_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_20,
            Map.ofEntries(Map.entry("identity_id", identity_id), Map.entry("rule_id", rule_id)),
            null,
            null),
        new TypeReference<RecipientRuleResponse>() {});
  }

  /** Describe a sent message */
  public Request<MessageResponse> describeSentMessage(String message_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_21,
            Map.ofEntries(Map.entry("message_id", message_id)),
            null,
            null),
        new TypeReference<MessageResponse>() {});
  }

  /** Get suppression */
  public Request<SuppressionResponse> describeSuppression(String suppression_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_22,
            Map.ofEntries(Map.entry("suppression_id", suppression_id)),
            null,
            null),
        new TypeReference<SuppressionResponse>() {});
  }

  /** Describe a template */
  public Request<TemplateResponse> describeTemplate(String template_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_23,
            Map.ofEntries(Map.entry("template_id", template_id)),
            null,
            null),
        new TypeReference<TemplateResponse>() {});
  }

  /** Download received attachment */
  public BinaryRequest downloadReceivedAttachment(String message_id, String attachment_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_24,
            Map.ofEntries(
                Map.entry("message_id", message_id), Map.entry("attachment_id", attachment_id)),
            null,
            null));
  }

  /** Download received message */
  public BinaryRequest downloadReceivedMessage(String message_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_25,
            Map.ofEntries(Map.entry("message_id", message_id)),
            null,
            null));
  }

  /** Download sent attachment */
  public BinaryRequest downloadSentAttachment(String message_id, String attachment_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_26,
            Map.ofEntries(
                Map.entry("message_id", message_id), Map.entry("attachment_id", attachment_id)),
            null,
            null));
  }

  /** Download sent message */
  public BinaryRequest downloadSentMessage(String message_id) {
    return new BinaryRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_27,
            Map.ofEntries(Map.entry("message_id", message_id)),
            null,
            null));
  }

  /** Finalize DKIM key rotation */
  public Request<IdentityResponse> finalizeDKIMRotation(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_28,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Get received message content */
  public Request<MessageContentResponse> getReceivedMessageContent(String message_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_29,
            Map.ofEntries(Map.entry("message_id", message_id)),
            null,
            null),
        new TypeReference<MessageContentResponse>() {});
  }

  /** Get receiving configuration */
  public Request<ReceivingConfigurationResponse> getReceivingConfiguration(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_30,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<ReceivingConfigurationResponse>() {});
  }

  /** Get sent message content */
  public Request<MessageContentResponse> getSentMessageContent(String message_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_31,
            Map.ofEntries(Map.entry("message_id", message_id)),
            null,
            null),
        new TypeReference<MessageContentResponse>() {});
  }

  /** Sent message engagement */
  public Request<MessageEngagementResponse> getSentMessageEngagement(String message_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_32,
            Map.ofEntries(Map.entry("message_id", message_id)),
            null,
            null),
        new TypeReference<MessageEngagementResponse>() {});
  }

  /** List configuration sets */
  public PagedRequest<ConfigurationSetListResponse, ConfigurationSet> listConfigurationSets(
      ListConfigurationSetsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_33,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ConfigurationSetListResponse>() {},
        new TypeReference<ConfigurationSet>() {},
        "configuration_sets");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ConfigurationSetListResponse, ConfigurationSet> listConfigurationSets() {
    return listConfigurationSets(null);
  }

  /** List DMARC report records */
  public PagedRequest<DMARCReportListResponse, DMARCReportRecord> listDMARCReports(
      String identity_id, ListDMARCReportsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_34,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            query),
        new TypeReference<DMARCReportListResponse>() {},
        new TypeReference<DMARCReportRecord>() {},
        "records");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<DMARCReportListResponse, DMARCReportRecord> listDMARCReports(
      String identity_id) {
    return listDMARCReports(identity_id, null);
  }

  /** List dedicated IPs */
  public PagedRequest<DedicatedIPListResponse, DedicatedIP> listDedicatedIPs(
      ListDedicatedIPsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_35,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<DedicatedIPListResponse>() {},
        new TypeReference<DedicatedIP>() {},
        "dedicated_ips");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<DedicatedIPListResponse, DedicatedIP> listDedicatedIPs() {
    return listDedicatedIPs(null);
  }

  /** List IP pools */
  public PagedRequest<IPPoolListResponse, IPPool> listIPPools(ListIPPoolsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_36,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<IPPoolListResponse>() {},
        new TypeReference<IPPool>() {},
        "ip_pools");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<IPPoolListResponse, IPPool> listIPPools() {
    return listIPPools(null);
  }

  /** List sender identities */
  public PagedRequest<IdentityListResponse, Identity> listIdentities(ListIdentitiesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_37,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<IdentityListResponse>() {},
        new TypeReference<Identity>() {},
        "identities");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<IdentityListResponse, Identity> listIdentities() {
    return listIdentities(null);
  }

  /** List received messages */
  public PagedRequest<ReceivedMessageListResponse, ReceivedMessage> listReceivedMessages(
      ListReceivedMessagesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_38,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<ReceivedMessageListResponse>() {},
        new TypeReference<ReceivedMessage>() {},
        "messages");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<ReceivedMessageListResponse, ReceivedMessage> listReceivedMessages() {
    return listReceivedMessages(null);
  }

  /** List recipient rules */
  public PagedRequest<RecipientRuleListResponse, RecipientRule> listRecipientRules(
      String identity_id, ListRecipientRulesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_39,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            query),
        new TypeReference<RecipientRuleListResponse>() {},
        new TypeReference<RecipientRule>() {},
        "rules");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RecipientRuleListResponse, RecipientRule> listRecipientRules(
      String identity_id) {
    return listRecipientRules(identity_id, null);
  }

  /** List API-side send rejections */
  public PagedRequest<RejectionListResponse, Rejection> listRejections(ListRejectionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_40,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<RejectionListResponse>() {},
        new TypeReference<Rejection>() {},
        "rejections");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<RejectionListResponse, Rejection> listRejections() {
    return listRejections(null);
  }

  /** List sent messages */
  public PagedRequest<MessageListResponse, Message> listSentMessages(ListSentMessagesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_41,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<MessageListResponse>() {},
        new TypeReference<Message>() {},
        "messages");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<MessageListResponse, Message> listSentMessages() {
    return listSentMessages(null);
  }

  /** List suppression entries */
  public PagedRequest<SuppressionListResponse, Suppression> listSuppressions(
      ListSuppressionsQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_42,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<SuppressionListResponse>() {},
        new TypeReference<Suppression>() {},
        "suppressions");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<SuppressionListResponse, Suppression> listSuppressions() {
    return listSuppressions(null);
  }

  /** List templates */
  public PagedRequest<TemplateListResponse, Template> listTemplates(ListTemplatesQuery query) {
    return new PagedRequest<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_43,
            Map.ofEntries(),
            null,
            query),
        new TypeReference<TemplateListResponse>() {},
        new TypeReference<Template>() {},
        "templates");
  }

  /** Execute with optional inputs omitted. */
  public PagedRequest<TemplateListResponse, Template> listTemplates() {
    return listTemplates(null);
  }

  /** Release a dedicated IP */
  public EmptyRequest releaseDedicatedIP(String dedicated_ip_id) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_44,
            Map.ofEntries(Map.entry("dedicated_ip_id", dedicated_ip_id)),
            null,
            null));
  }

  /** Remove a suppression override address */
  public Request<ConfigurationSetResponse> removeSuppressionOverride(
      String configuration_set_id, String address) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_45,
            Map.ofEntries(
                Map.entry("configuration_set_id", configuration_set_id),
                Map.entry("address", address)),
            null,
            null),
        new TypeReference<ConfigurationSetResponse>() {});
  }

  /** Request a dedicated IP */
  public Request<DedicatedIPResponse> requestDedicatedIP(RequestDedicatedIPRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_46,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<DedicatedIPResponse>() {});
  }

  /** Execute with optional inputs omitted. */
  public Request<DedicatedIPResponse> requestDedicatedIP() {
    return requestDedicatedIP(null);
  }

  /** Send a message */
  public Request<MessageResponse> sendMessage(SendMessageRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_47,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<MessageResponse>() {});
  }

  /** Send message batch */
  public Request<BatchSendResponse> sendMessageBatch(BatchSendRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_48,
            Map.ofEntries(),
            body,
            null),
        new TypeReference<BatchSendResponse>() {});
  }

  /** Set BIMI logo / VMC URLs */
  public Request<IdentityResponse> setBIMI(String identity_id, SetBIMIRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_49,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            body,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Set custom MAIL FROM domain */
  public Request<IdentityResponse> setMailFromDomain(
      String identity_id, SetMailFromDomainRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_50,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            body,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Update a configuration set */
  public Request<ConfigurationSetResponse> updateConfigurationSet(
      String configuration_set_id, UpdateConfigurationSetRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_51,
            Map.ofEntries(Map.entry("configuration_set_id", configuration_set_id)),
            body,
            null),
        new TypeReference<ConfigurationSetResponse>() {});
  }

  /** Update a dedicated IP */
  public Request<DedicatedIPResponse> updateDedicatedIP(
      String dedicated_ip_id, UpdateDedicatedIPRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_52,
            Map.ofEntries(Map.entry("dedicated_ip_id", dedicated_ip_id)),
            body,
            null),
        new TypeReference<DedicatedIPResponse>() {});
  }

  /** Update an IP pool */
  public Request<IPPoolResponse> updateIPPool(String ip_pool_id, UpdateIPPoolRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_53,
            Map.ofEntries(Map.entry("ip_pool_id", ip_pool_id)),
            body,
            null),
        new TypeReference<IPPoolResponse>() {});
  }

  /** Update identity */
  public Request<IdentityResponse> updateIdentity(
      String identity_id, UpdateIdentityRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_54,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            body,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Update receiving configuration */
  public EmptyRequest updateReceivingConfiguration(
      String identity_id, UpdateReceivingConfigurationRequestInput body) {
    return new EmptyRequest(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_55,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            body,
            null));
  }

  /** Update recipient rule */
  public Request<RecipientRuleResponse> updateRecipientRule(
      String identity_id, String rule_id, UpdateRecipientRuleRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_56,
            Map.ofEntries(Map.entry("identity_id", identity_id), Map.entry("rule_id", rule_id)),
            body,
            null),
        new TypeReference<RecipientRuleResponse>() {});
  }

  /** Update suppression */
  public Request<SuppressionResponse> updateSuppression(
      String suppression_id, UpdateSuppressionRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_57,
            Map.ofEntries(Map.entry("suppression_id", suppression_id)),
            body,
            null),
        new TypeReference<SuppressionResponse>() {});
  }

  /** Update a template */
  public Request<TemplateResponse> updateTemplate(
      String template_id, UpdateTemplateRequestInput body) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_58,
            Map.ofEntries(Map.entry("template_id", template_id)),
            body,
            null),
        new TypeReference<TemplateResponse>() {});
  }

  /** Verify BIMI logo (+ optional VMC) */
  public Request<IdentityResponse> verifyBIMI(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_59,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Trigger DNS verification */
  public Request<IdentityResponse> verifyIdentity(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_60,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<IdentityResponse>() {});
  }

  /** Verify custom MAIL FROM domain MX */
  public Request<IdentityResponse> verifyMailFromDomain(String identity_id) {
    return new Request<>(
        new Core(
            transport,
            "email",
            "https://email.{region}.basaltic.sh",
            OP_61,
            Map.ofEntries(Map.entry("identity_id", identity_id)),
            null,
            null),
        new TypeReference<IdentityResponse>() {});
  }
}
