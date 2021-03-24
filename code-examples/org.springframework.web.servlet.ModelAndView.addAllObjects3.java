@RequestMapping("/test")
public ModelAndView test(){
	Map<String, String> model = new HashMap<String, String>();
	ModelAndView modelAndView = new ModelAndView("TestPage");
	model.put('var1', "test1");
	model.put('var2', "test2");
	modelAndView.addAllObjects(model);
	return modelAndView;
}