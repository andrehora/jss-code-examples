public ModelAndView handleRequest(HttpServletRequest req, HttpServletResponse res) throws Exception {
	String id = req.getParameter("id");
	Player player = service.getPlayer(id);

	Map<String, Object> model = new HashMap<String, Object>();
	model.put("player", player);

	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("/WEB-INF/views/player/test.jsp");
	modelAndView.addAllObjects(model);

	return modelAndView;
}