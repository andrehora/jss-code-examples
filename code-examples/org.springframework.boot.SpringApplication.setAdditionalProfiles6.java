public static void main(String[] args) {
    SpringApplication application = new SpringApplication(Application.class);
    application.setAdditionalProfiles("local");
    try {
        BootShim bs = new BootShim(args, application.run(args));
        bs.run();
    } catch (RuntimeException e) {
        throw e;
    } finally {
        HandlerUtils.flushAllHandlers(Logger.getLogger(""));
    }
}