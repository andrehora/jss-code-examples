public static void main(String[] args) throws UnknownHostException {
    SpringApplication app = new SpringApplication(App.class);
    SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
    if (!source.containsProperty("spring.profiles.active") &&
            !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {

        app.setAdditionalProfiles("production");
    }
    ...
}