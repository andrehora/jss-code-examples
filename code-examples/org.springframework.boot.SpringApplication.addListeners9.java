public static void main(String[] args) {
    SpringApplication springApplication = new SpringApplication(ConsoleApplicationStart.class);
    springApplication.addListeners(new ApplicationPidFileWriter("console.pid"));
    springApplication.run(args);
}