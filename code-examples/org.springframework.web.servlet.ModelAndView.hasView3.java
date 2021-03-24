public void postHandle(HttpServletRequest request,
		HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {

	boolean isRedirectView = modelAndView.getView() instanceof RedirectView;
	boolean isViewObject = modelAndView.getView() == null;
	// if the view name is null then set a default value of true
	boolean viewNameStartsWithRedirect = (modelAndView.getViewName() == null ? true : 	modelAndView.getViewName().startsWith(UrlBasedViewResolver.REDIRECT_URL_PREFIX));

	if(modelAndView.hasView() && (
			( isViewObject && !isRedirectView) ||
			(!isViewObject && !viewNameStartsWithRedirect))){
		addCommonModelData(modelAndView);
	}
}