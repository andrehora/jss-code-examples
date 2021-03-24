public void testHandleRequestView() throws Exception{		
	HelloController controller = new HelloController();
	ModelAndView modelAndView = controller.handleRequest(null, null);		
	assertEquals("WEB-INF/views/hello.jsp", modelAndView.getViewName());
	assertNotNull(modelAndView.getModel());
	String nowValue = (String) modelAndView.getModel().get("now");
	assertNotNull(nowValue);

}