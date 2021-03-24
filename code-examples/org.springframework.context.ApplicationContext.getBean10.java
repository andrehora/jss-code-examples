public static void main(String[] args) {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext*.xml");
    final IndustryProcessor industryProcessor = applicationContext.getBean(IndustryProcessor.class);
    industryProcessor.crawl();
}