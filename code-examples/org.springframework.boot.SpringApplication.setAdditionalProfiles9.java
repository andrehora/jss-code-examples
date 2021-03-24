protected static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
    if ((System.getProperty("spring.profiles.active") == null)
            && !source.containsProperty("spring.profiles.active")
            && !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
        app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
    }
}