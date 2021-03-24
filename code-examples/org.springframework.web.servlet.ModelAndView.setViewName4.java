@RequestMapping(value = "/welcome", method = RequestMethod.GET)
public ModelAndView welcome() {
	ModelAndView model = new ModelAndView();
	model.setViewName("welcome");
	return model;
}