public static void main(String[] args) {
	//SpringApplication.run(ItweetBootApplication.class, args);
	SpringApplication springApplication =new SpringApplication(ItweetBootApplication.class);
	springApplication.addListeners(new ApplicationStartup());
	springApplication.run(args);
}