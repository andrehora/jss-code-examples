public void onApplicationEvent(ApplicationEvent event) {
	// Once the context has been refreshed, we tell other interested beans
	// about the existence of this content store
	// (e.g. for monitoring purposes)
	if (event instanceof ContextRefreshedEvent && event.getSource() == this.applicationContext) {
		ApplicationContext context = ((ContextRefreshedEvent) event).getApplicationContext();
		context.publishEvent(new ContentStoreCreatedEvent(this, Collections.<String, Serializable>emptyMap()));
	}
}