public void springContextIsValid() {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring/st-data-context.xml");

	for (String s : context.getBeanDefinitionNames()) {
		try {
			context.getBean(s);
		} catch (BeanIsAbstractException e) {
		}
	}
}