public ModelAndView list(HttpServletRequest req,
		HttpServletResponse resp) throws Exception {

	String name = req.getParameter("name");

	List agendaEntries = agendaEntryDAO.find(name);            
	Map model = new HashMap();        
	ModelAndView modelAndView = new ModelAndView();
	model.put("jsonResponse", agendaEntries);   
	modelAndView.addAllObjects(model);
	View jsonView = new JSONView();
	modelAndView.setView(jsonView);
	return modelAndView;        
}