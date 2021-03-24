public static void registerSingleton(ApplicationContext applicationContext, String beanName, Object singletonObject) {

	AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
	if (!SingletonBeanRegistry.class.isAssignableFrom(beanFactory.getClass())) {
		throw new IllegalArgumentException(
				"ApplicationContext: " + applicationContext.getClass().toString()
				+ " doesn't implements SingletonBeanRegistry, cannot register JMS connection at runtime");
	}

	SingletonBeanRegistry beanDefinitionRegistry = (SingletonBeanRegistry) beanFactory;
	beanDefinitionRegistry.registerSingleton(beanName, singletonObject);

}