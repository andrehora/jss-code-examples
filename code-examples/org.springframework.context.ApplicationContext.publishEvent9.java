public void onDifferentPortWithPrimaryFailure() throws Exception {
    EnvironmentTestUtils.addEnvironment(this.applicationContext, "management.port=" + ports.get().management);
    this.applicationContext.register(RootConfig.class, EndpointConfig.class, DifferentPortConfig.class, BaseConfiguration.class, EndpointWebMvcAutoConfiguration.class, ErrorMvcAutoConfiguration.class);
    this.applicationContext.refresh();
    ApplicationContext managementContext = this.applicationContext.getBean(ManagementContextResolver.class).getApplicationContext();
    ApplicationFailedEvent event = mock(ApplicationFailedEvent.class);
    given(event.getApplicationContext()).willReturn(this.applicationContext);
    this.applicationContext.publishEvent(event);
    assertThat(((ConfigurableApplicationContext) managementContext).isActive()).isFalse();
}