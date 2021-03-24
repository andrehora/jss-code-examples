@SpringBootApplication(exclude = {JmxAutoConfiguration.class})
public class Main {
    public static void main (String[] args) {
        SpringApplication sa = new SpringApplication(Main.class);
        sa.setBannerMode(Banner.Mode.OFF);
        sa.setLogStartupInfo(false);

        ApplicationContext c = sa.run(args);
        MyObject bean = c.getBean(MyObject.class);
        bean.doSomething();

    }

    @Component
    private static class MyObject {

        public void doSomething () {
            System.out.println("-------------");
            System.out.println("working ...");
            System.out.println("-------------");
        }
    }
}