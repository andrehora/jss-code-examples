public void run(ApplicationArguments args) throws Exception {

    SpringApplication app = new SpringApplication(Lyre.class);
    String[] arguments = RunnerUtils.buildArguments(app.getMainApplicationClass().getAnnotation(EnableLyre.class));
    app.setMainApplicationClass(Lyre.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.run(arguments);
}