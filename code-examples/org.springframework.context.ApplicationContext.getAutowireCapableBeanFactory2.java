B bean = new B();
AutowireCapableBeanFactory factory = applicationContext.getAutowireCapableBeanFactory();
factory.autowireBean( bean );
factory.initializeBean( bean, "bean" );