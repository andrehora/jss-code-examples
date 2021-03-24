@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		// do something
		int exitCode = SpringApplication.exit(context, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 0;
			}
		});

		System.exit(exitCode);
	}
}