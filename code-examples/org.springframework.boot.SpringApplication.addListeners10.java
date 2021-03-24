public static void main(String[] args) throws Exception {
    //SpringApplication.run(Application.class, args);
    SpringApplication springApplication = new SpringApplication(Application.class);
    springApplication.addListeners(new ApplicationPidFileWriter());
    springApplication.run(args);
}