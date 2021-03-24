@SpringBootApplication
public class DemoApplication implements ExitCodeGenerator {
 
    public static void main(String[] args) {
        System.exit(SpringApplication
          .exit(SpringApplication.run(DemoApplication.class, args)));
    }
  
    @Override
    public int getExitCode() {
        return 42;
    }
}