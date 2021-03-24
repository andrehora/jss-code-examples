@SpringBootApplication
public class Application {
    public static void main(String[] args) 
    {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}