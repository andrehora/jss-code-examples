public static void main(String[] args) {
    final SpringApplication app = new SpringApplication(Application.class);
    // save the pid into a file...
    app.addListeners(new ApplicationPidFileWriter("smarti.pid"));

    final ConfigurableApplicationContext context = app.run(args);
    final ConfigurableEnvironment env = context.getEnvironment();

    try {
        //http://localhost:8080/admin/index.html
        final URI uri = new URI(
                (env.getProperty("server.ssl.enabled", Boolean.class, false) ? "https" : "http"),
                null,
                (env.getProperty("server.address", "localhost")),
                (env.getProperty("server.port", Integer.class, 8080)),
                (env.getProperty("server.context-path", "/")).replaceAll("//+", "/"),
                null, null);

        log.info("{} started: {}",
                env.getProperty("server.display-name", context.getDisplayName()),
                uri);
    } catch (URISyntaxException e) {
        log.warn("Could not build launch-url: {}", e.getMessage());
    }
}