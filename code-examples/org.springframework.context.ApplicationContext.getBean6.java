public void setUp() throws Exception
{
    ApplicationContext ctx = ApplicationContextHelper.getApplicationContext();
    serviceRegistry = (ServiceRegistry) ctx.getBean(ServiceRegistry.SERVICE_REGISTRY);
    mimetypeService = serviceRegistry.getMimetypeService();
    transformerDebug = (TransformerDebug) ctx.getBean("transformerDebug");
    transformerConfig = (TransformerConfig) ctx.getBean("transformerConfig");
    registry = (ContentTransformerRegistry) ctx.getBean("contentTransformerRegistry");
    transactionService = serviceRegistry.getTransactionService();
    repositoryHelper = (Repository) ctx.getBean("repositoryHelper");
    nodeService = serviceRegistry.getNodeService();
    contentService = serviceRegistry.getContentService();
    
    assertNotNull("MimetypeMap not present", this.mimetypeService);
    assertNotNull("ServiceRegistry not present", serviceRegistry);
    assertNotNull("TransformerDebug not present", transformerDebug);
    assertNotNull("TransformerConfig not present", transformerConfig);
    assertNotNull("transactionService not present", transactionService);
    assertNotNull("repositoryHelper not present", repositoryHelper);
    assertNotNull("nodeService not present", nodeService);
    assertNotNull("contentService not present", contentService);
}