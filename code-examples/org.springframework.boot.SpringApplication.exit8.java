public static void main(String[] args) {
    SpringApplication app = new SpringApplication(MessageServerApplication.class); 
    ApplicationContext applicationContext = app.run(args);
    
    try {
        applicationContext.getBean(MessageServerStarter.class).start(args);
    } catch (Exception e) {
        logger.error("Shutdown with errors ", e);
        SpringApplication.exit(applicationContext);
    } finally {
        logger.info("done");
    }
}