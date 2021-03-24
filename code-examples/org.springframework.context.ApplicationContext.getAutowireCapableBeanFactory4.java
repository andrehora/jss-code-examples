public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	beanFactory = applicationContext.getAutowireCapableBeanFactory();
}