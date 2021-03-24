private void findAndRegisterAnnotatedDelegates(
        ApplicationContext applicationContext) {
    String[] beanNames = applicationContext.getBeanDefinitionNames();
    for (String beanName : beanNames) {
        Object bean = applicationContext.getBean(beanName);
        if (bean != null) {
            Class<?> type = bean.getClass();
            Method[] methods = type.getMethods();
            for (Method method : methods) {
                findAndRegisterAnnotatedDelegateMethods(bean, method);
            }
        }
    }
}