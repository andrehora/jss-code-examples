@SpringBootApplication
public class SpringBootShutdownApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootShutdownApplication.class, args);
		exitApplication(ctx);
		//ctx.close();
	}

	public static void exitApplication(ConfigurableApplicationContext ctx) {
		int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				// no errors
				return 0;
			}
		});
		System.exit(exitCode);
	}
}