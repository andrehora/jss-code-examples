@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication=new SpringApplication(SpringBootConfig.class);
        String[] profiles= new String[]{"production","production-extra"}; // array of profiles, create array of one profile in case single profile
        springApplication.setAdditionalProfiles(profiles); // set active profile, We can write condition here based on requirements
        springApplication.run(args);  // run spring boot application
    }
}