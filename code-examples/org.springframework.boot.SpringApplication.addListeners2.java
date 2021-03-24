@SpringBootApplication
public class Application {
  
  public static void main(String[] args) {
    SpringApplication springApplication = 
        new SpringApplication(Application.class);
    springApplication.addListeners(
        new ApplicationPidListener("app.pid"));
    springApplication.run(args);
  }
}