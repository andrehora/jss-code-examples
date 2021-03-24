@SpringBootApplication
public class ExampleMain {

  public static void main(String[] args) throws InterruptedException {
      SpringApplication sa = new SpringApplication();
      sa.addListeners(new MyApplicationListener());
      sa.setSources(new HashSet<>(Arrays.asList(ExampleMain.class)));
      ConfigurableApplicationContext context = sa.run(args);
      MyBean bean = context.getBean(MyBean.class);
      bean.doSomething();
  }
}