public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	boolean isRedirectView = modelAndView!=null && modelAndView.getView() instanceof RedirectView;
	//boolean isViewObject = modelAndView.getView() == null;
	// if the view name is null then set a default value of true
	boolean viewNameStartsWithRedirect = (modelAndView!=null && modelAndView.getViewName() == null ? true
			: modelAndView!=null && modelAndView.getViewName().startsWith(UrlBasedViewResolver.REDIRECT_URL_PREFIX));
	if (modelAndView!=null && modelAndView.hasView() && !isRedirectView && !viewNameStartsWithRedirect) {
		addCommonModelData(modelAndView);
	}
}