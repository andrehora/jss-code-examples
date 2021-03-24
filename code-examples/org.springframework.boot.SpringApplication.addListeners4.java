@SpringBootApplication
public class SpringBootPidApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringBootPidApplication.class);
		springApplication.addListeners(new ApplicationPidFileWriter());
		springApplication.run(args);

	}
}