@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
	SpringApplication application = new SpringApplication(MyApplication.class);
	application.setAdditionalProfiles("dev","animal_dev");
	application.run(args);
    }       
}