public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	if (!modelAndView.hasView()) {
		return;
	}
	String originalViewName = modelAndView.getViewName();
	if (isRedirectOrForward(originalViewName)) {
		return;
	}
	String layoutName = getLayoutName(handler);
	modelAndView.setViewName(layoutName);
	modelAndView.addObject(this.viewAttributeName, originalViewName);
}