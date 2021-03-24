public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	if (!modelAndView.hasView()) {
		return;
	}
	String originalViewName = modelAndView.getViewName();
	modelAndView.setViewName(DEFAULT_LAYOUT);
	modelAndView.addObject(DEFAULT_VIEW_ATTRIBUTE_NAME, originalViewName);
}