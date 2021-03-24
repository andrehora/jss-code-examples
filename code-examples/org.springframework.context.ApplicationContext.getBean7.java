private static void findServices()
{
    ApplicationContext ctx = testContext.getApplicationContext();
    
    copyService = ctx.getBean("CopyService", CopyService.class);
    nodeService = ctx.getBean("NodeService", NodeService.class);
    directQuickShareService = ctx.getBean("quickShareService", QuickShareService.class);
    quickShareService = ctx.getBean("QuickShareService", QuickShareService.class);
    repository = ctx.getBean("repositoryHelper", Repository.class);
    attributeService = ctx.getBean("AttributeService", AttributeService.class);
    permissionService = ctx.getBean("PermissionService", PermissionService.class);
    nodeArchiveService = ctx.getBean("nodeArchiveService", NodeArchiveService.class);
    scheduledPersistedActionService = ctx.getBean("scheduledPersistedActionService", ScheduledPersistedActionService.class);
    quickShareLinkExpiryActionPersister = ctx.getBean("quickShareLinkExpiryActionPersister", QuickShareLinkExpiryActionPersister.class);
    transactionHelper = ctx.getBean("retryingTransactionHelper", RetryingTransactionHelper.class);
    globalProperties = ctx.getBean("global-properties", Properties.class);
    siteService = (SiteService) ctx.getBean("SiteService");
}