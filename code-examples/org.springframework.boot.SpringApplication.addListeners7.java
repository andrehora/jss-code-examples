public static void main(String[] args) {
    SpringApplication springApplication =new SpringApplication(DataAppConsumerApplication.class);
    springApplication.addListeners(new ApplicationStartup());
    springApplication.run(args);
    logger.info("============= SpringBoot Start Success =============");
}