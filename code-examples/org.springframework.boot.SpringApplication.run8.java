@SpringBootApplication
@EnableSwagger2   //<1>
@ComponentScan(basePackageClasses = {PetController.class})    //<2>
public class Swagger2SpringBoot {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(Swagger2SpringBoot.class, args);
  }

  @Bean
  public Docket petApi() {
    return new Docket(DocumentationType.SWAGGER_2)    //<3>
            .select()   //<4>
            .build();   //<5>
  }
}