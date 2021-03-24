private String[] printBeans() {
    AutowireCapableBeanFactory autowireCapableBeanFactory = applicationContext.getAutowireCapableBeanFactory();
    if (autowireCapableBeanFactory instanceof SingletonBeanRegistry) {
        String[] singletonNames = ((SingletonBeanRegistry) autowireCapableBeanFactory).getSingletonNames();
        for (String singleton : singletonNames) {
            System.out.println(singleton);
        }
        return singletonNames;
    }
    return null;
}