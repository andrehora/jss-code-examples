public void testAspectJTypeFilter() {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"org/springframework/context/annotation/aspectjTypeFilterTests.xml");
	assertTrue(context.containsBean("fooServiceImpl"));
	assertTrue(context.containsBean("stubFooDao"));
	assertFalse(context.containsBean("scopedProxyTestBean"));
}