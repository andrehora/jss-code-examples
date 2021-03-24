public void testHandlerReturnsMap() throws Exception {
	Map model = new HashMap();
	model.put("message", "Hello World!");

	MultiActionController mac = new ModelOnlyMultiActionController(model);

	MockHttpServletRequest request = new MockHttpServletRequest("GET", "/welcome.html");
	MockHttpServletResponse response = new MockHttpServletResponse();
	ModelAndView mav = mac.handleRequest(request, response);

	assertNotNull("ModelAndView cannot be null", mav);
	assertFalse("ModelAndView should not have a view", mav.hasView());
	assertEquals(model, mav.getModel());
}