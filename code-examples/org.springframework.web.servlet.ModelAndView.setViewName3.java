public ModelAndView handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("hello");
	mv.addObject("message", "Spring 4 MVC Hello World<br>Class Name Handler Mapping Example");
	return mv;
}