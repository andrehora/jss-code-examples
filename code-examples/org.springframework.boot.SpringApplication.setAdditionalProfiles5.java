@SpringBootApplication
public class ExampleMain2 {

  public static void main(String[] args) {
      ConfigurableEnvironment environment = new StandardEnvironment();
      environment.setActiveProfiles("dev");

      SpringApplication sa = new SpringApplication(ExampleMain2.class);
      sa.setEnvironment(environment);
      sa.setAdditionalProfiles("remote","live");
      sa.run(args);
  }
}