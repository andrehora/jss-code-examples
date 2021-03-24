AnnotationConfigApplicationContext context = 
	new AnnotationConfigApplicationContext(EventListenerExample2.class);
context.publishEvent(new MyEvent(1, "test message 1"));
context.publishEvent(new MyEvent(5, "test message 5"));