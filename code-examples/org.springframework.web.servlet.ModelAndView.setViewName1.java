@RequestMapping(value = "exeJsTest-modelAndView-returned")
public ModelAndView testExeJsModelAndView(Model model) {
	setTestVariables(model);
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("booking");
	return modelAndView;
}