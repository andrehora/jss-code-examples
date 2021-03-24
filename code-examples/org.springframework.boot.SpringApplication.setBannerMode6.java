public static void main(final String[] args) {

        System.setProperty("vertx.disableDnsResolver", "true");
        System.setProperty("vertx.logger-delegate-factory-class-name", "io.vertx.core.logging.SLF4JLogDelegateFactory");

        final File logbackFile = new File("logback.xml");
        if (logbackFile.exists()) {
            System.setProperty("logging.config", logbackFile.getAbsolutePath());
        }

        final SpringApplication application = new SpringApplication(GatewayMS.class);
        application.setBannerMode(Mode.OFF);
        application.setWebEnvironment(false);
        application.run(args);

    }