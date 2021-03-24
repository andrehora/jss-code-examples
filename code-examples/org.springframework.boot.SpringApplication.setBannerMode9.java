public static void main(String... args) {
    final SpringApplication app = new SpringApplication(MongoMigration.class);
    app.setBannerMode(Banner.Mode.OFF);

    boolean hasError = false;
    try (ConfigurableApplicationContext context = app.run(args)) {
        context.getBean(MongoDbMigrationService.class).runDatabaseMigration();
    } catch (IOException e) {
        hasError = true;
        log.error("Error while running database-migration: {}", e.getMessage(), e);
    }

    if (hasError) System.exit(1);
}