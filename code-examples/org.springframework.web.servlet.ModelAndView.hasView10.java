public View resolveView(HttpServletRequest request, ModelAndView mv)
		throws ViewResolutionException {

	if (mv.hasView() && !mv.isReference()) {
		return mv.getView();
	}
	return resolveView(request, mv.getViewName());
}