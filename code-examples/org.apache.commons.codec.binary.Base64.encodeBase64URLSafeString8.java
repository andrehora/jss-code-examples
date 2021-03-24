private ExtensionInterfaceBean getTestBean(String instanceId,
        String subscriptionId, String organizationId) throws Exception {
    instanceAccess = Mockito.mock(InstanceAccess.class);

    serverInfo = getServerInfoMock(3);

    String encodedInstId = Base64.encodeBase64URLSafeString(
            instanceId.getBytes(StandardCharsets.UTF_8));
    String encodedSubId = Base64.encodeBase64URLSafeString(
            subscriptionId.getBytes(StandardCharsets.UTF_8));
    String encodedOrgId = Base64.encodeBase64URLSafeString(
            organizationId.getBytes(StandardCharsets.UTF_8));

    Mockito.when(instanceAccess.getAccessInfo(instanceID, subscriptionID,
            organizationID)).thenReturn("Access info from IaaS");
    Mockito.<List<? extends ServerInformation>> when(instanceAccess
            .getServerDetails(instanceID, subscriptionID, organizationID))
            .thenReturn(serverInfo);

    ExtensionInterfaceBean bean = new ExtensionInterfaceBean();
    bean.setInstanceId(encodedInstId);
    bean.setSubscriptionId(encodedSubId);
    bean.setOrganizationId(encodedOrgId);
    bean.setInstanceAccess(instanceAccess);

    return bean;
}