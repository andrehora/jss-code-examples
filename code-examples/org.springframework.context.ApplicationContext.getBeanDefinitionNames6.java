public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    //Map<String, Object> serviceMap = applicationContext.getBeansWithAnnotation(XxlWebHandlerMapping.class);

    String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
    if (beanDefinitionNames!=null && beanDefinitionNames.length>0) {
        for (String beanDefinitionName : beanDefinitionNames) {

            boolean isApiHandler = applicationContext.isTypeMatch(beanDefinitionName, XxlWebHandler.class);
            if (isApiHandler) { // if (beanDefinition instanceof XxlWebHandler) {
                Object beanDefinition = applicationContext.getBean(beanDefinitionName);
                // valid annotation
                XxlWebHandlerMapping annotation = beanDefinition.getClass().getAnnotation(XxlWebHandlerMapping.class);
                if (annotation!=null && annotation.value()!=null && annotation.value().trim().length()>0 ) {
                    handlerRepository.put(annotation.value(), (XxlWebHandler) beanDefinition);
                    logger.warn(">>>>>>>>>>> xxl-hex, bind hex handler success : {}", annotation.value());
                }
            }

        }
    }

}