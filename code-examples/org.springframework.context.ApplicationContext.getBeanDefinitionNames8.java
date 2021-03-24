public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(BusPassApp.class, args);
    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    StringBuilder sb = new StringBuilder("Application beans:\n");
    for (String beanName : beanNames) {
        sb.append(beanName + "\n");
    }
    log.info(sb.toString());
}