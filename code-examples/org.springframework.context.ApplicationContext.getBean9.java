private void getCtxAndSetBeans()
{
    ApplicationContext ctx = ApplicationContextHelper.getApplicationContext();
    this.customModelService = ctx.getBean("customModelService", CustomModelService.class);
    this.transactionHelper = ctx.getBean("retryingTransactionHelper", RetryingTransactionHelper.class);
    AuthenticationUtil.setAdminUserAsFullyAuthenticatedUser();
}