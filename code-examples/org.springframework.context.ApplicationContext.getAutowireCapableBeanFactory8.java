protected void doInitialize() throws Exception {
    provider.getProviders().forEach(p -> {
        final FlowDefinitionRegistry duoFlowRegistry = buildDuoFlowRegistry(p);
        applicationContext.getAutowireCapableBeanFactory().initializeBean(duoFlowRegistry, p.getId());
        final ConfigurableListableBeanFactory cfg = (ConfigurableListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        cfg.registerSingleton(p.getId(), duoFlowRegistry);
        registerMultifactorProviderAuthenticationWebflow(getLoginFlow(), p.getId(), duoFlowRegistry);
    });
    casProperties.getAuthn().getMfa().getDuo().stream().filter(MultifactorAuthenticationProperties.Duo::isTrustedDeviceEnabled).forEach(duo -> {
        final String id = duo.getId();
        try {
            LOGGER.debug("Activating multifactor trusted authentication for webflow [{}]", id);
            final FlowDefinitionRegistry registry = applicationContext.getBean(id, FlowDefinitionRegistry.class);
            registerMultifactorTrustedAuthentication(registry);
        } catch (final Exception e) {
            LOGGER.error("Failed to register multifactor trusted authentication for " + id, e);
        }
    });
}