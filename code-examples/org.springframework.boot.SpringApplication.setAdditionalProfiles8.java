public static void main(String[] args) {
    SpringApplication app = new SpringApplication(ApplicationStarter.class);
    app.setAdditionalProfiles();
    app.setBannerMode(Banner.Mode.LOG);
    app.run(args);
}