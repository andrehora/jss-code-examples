public static void main(String[] args) {
	((ch.qos.logback.classic.Logger) logger).setLevel(ch.qos.logback.classic.Level.TRACE);
	SpringApplication app = new SpringApplication(new Object[]{ScooldServer.class});
	initConfig();
	app.setAdditionalProfiles(Config.ENVIRONMENT);
	app.setWebEnvironment(true);
	app.run(args);
}