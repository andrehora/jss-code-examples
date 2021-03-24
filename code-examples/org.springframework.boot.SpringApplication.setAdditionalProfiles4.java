@SpringBootApplication
public class ExampleMain {


  public static void main(String[] args) {
      System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "prod");
      SpringApplication sa = new SpringApplication(ExampleMain.class);
      sa.setAdditionalProfiles("remote","live");
      sa.run(args);
  }
}