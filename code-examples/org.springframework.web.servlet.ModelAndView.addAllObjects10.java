public ModelAndView handleRequest(HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	ModelAndView result = new ModelAndView();
	result.setViewName(view);

	Map<String, Object> model = new HashMap<String, Object>();
	model.put("appConfig", config);
	model.put("server", server);
	model.put("memory", new MemoryInfo());
	result.addAllObjects(model);

	return result;
}