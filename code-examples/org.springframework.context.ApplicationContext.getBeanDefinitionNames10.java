private void initializeBindings(Binding bindings) {
	bindings.setVariable("context", applicationContext);
	for (String name : applicationContext.getBeanDefinitionNames()) {
		try {
			bindings.setVariable(name, applicationContext.getBean(name));
		} catch (BeanIsAbstractException e) {
		} catch (Throwable t) {
			LOGGER.warn("Can't get bean " + name + ", error: " + t, t);
		}
	}

	bindings.setProperty("out", io.getOutputResultMessageStream());
	bindings.setProperty("err", io.getOutputErrorMessageStream());
}