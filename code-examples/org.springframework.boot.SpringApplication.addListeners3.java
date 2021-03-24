@SpringBootApplication
@ComponentScan // Using a root package also allows the @ComponentScan annotation to be used without needing to specify a basePackage attribute
public class SpringBootConfig {
    public static void main(String[] args) throws Exception {
        SpringApplication springApplication = new SpringApplication(SpringBootConfig.class);
        springApplication.addListeners(new ApplicationPidFileWriter());     // register PID write to spring boot. It will write PID to file
        springApplication.run(args);
    }
}