protected void render(ModelAndView mv, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
 // Determine locale for request and apply it to the response.
 Locale locale = this.localeResolver.resolveLocale(request);
 response.setLocale(locale);
 View view = null;
 // Do we need view name translation?
 if (!mv.hasView()) {
	 mv.setViewName(getDefaultViewName(request));
 }
 if (mv.isReference()) {
 // We need to resolve the view name.
 view = resolveViewName(mv.getViewName(), mv.getModelInternal(),
 locale, request);
 if (view == null) {
	 throw new ServletException("Could not resolve view... ");
 }
 }
 else {
	 // No need to lookup: the ModelAndView object contains the
	 // actual View object.
	 view = mv.getView();
	 if (view == null) {
		 throw new ServletException("ModelAndView ... neither contains a view name nor a View object in Servlet... ");
	 }
 }
 //debug msgs
 view.render(mv.getModelInternal(), request, response);
}