public static void main(String[] args) throws Exception {
  // below is output *before* logging is configured so will appear on console
  logVersionInfo();

  try {
    SpringApplication.exit(new SpringApplicationBuilder(VacuumTool.class)
        .properties("spring.config.location:${config:null}")
        .properties("spring.profiles.active:" + Modules.REPLICATION)
        .properties("instance.home:${user.home}")
        .properties("instance.name:${source-catalog.name}_${replica-catalog.name}")
        .bannerMode(Mode.OFF)
        .registerShutdownHook(true)
        .build()
        .run(args));
  } catch (BeanCreationException e) {
    if (e.getMostSpecificCause() instanceof BindException) {
      printVacuumToolHelp(((BindException) e.getMostSpecificCause()).getAllErrors());
    }
    throw e;
  }
}