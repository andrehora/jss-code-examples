SpringBootApplication
public class Application{
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);
        // add configuration properties logger
        app.addListeners(new ConfigurationLogger());
        app.run(args);
    }
}