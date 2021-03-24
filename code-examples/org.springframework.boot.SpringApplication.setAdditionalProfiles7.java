public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler());
    String profiles = System.getProperty("spring.profiles.active", "");
    log.info("requested profiles {}", profiles);
    SpringApplication application = new SpringApplication(SpringBootInitializer.class, DataSourceConfiguration.class, WebSecurityConfig.class, MvcConfiguration.class);
    application.setAdditionalProfiles(Initializer.PROFILE_SPRING_BOOT);
    ConfigurableApplicationContext applicationContext = application.run(args);
    ConfigurableEnvironment environment = applicationContext.getEnvironment();
    log.info("active profiles: {}", String.join(", ", environment.getActiveProfiles()));
    if (System.getProperty("startDBManager") != null) {
        Class<?> cls;
        try {
            cls = ClassUtils.getClass("org.hsqldb.util.DatabaseManagerSwing");
            MethodUtils.invokeStaticMethod(cls, "main", new Object[] { new String[] { "--url", "jdbc:hsqldb:mem:alfio", "--noexit" } });
        } catch (ReflectiveOperationException e) {
            log.warn("error starting db manager", e);
        }
    }
}