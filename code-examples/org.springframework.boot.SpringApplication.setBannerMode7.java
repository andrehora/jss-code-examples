public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.setBannerMode(Banner.Mode.OFF);
    app.setLogStartupInfo(false);
    app.setRegisterShutdownHook(false);
    Map<String, Object> pro = Maps.newHashMap();
    pro.put("logging.level.root", "ERROR");

    app.setDefaultProperties(pro);
    app.run(args);
}