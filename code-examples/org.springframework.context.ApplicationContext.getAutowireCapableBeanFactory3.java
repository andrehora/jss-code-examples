// try to use the default configuration as much as possible
ObjectMapper om = Jackson2ObjectMapperBuilder.json().build();
// This instantiator will handle autowiring properties into the custom serializers
om.setHandlerInstantiator(
new SpringHandlerInstantiator(this.applicationContext.getAutowireCapableBeanFactory()));