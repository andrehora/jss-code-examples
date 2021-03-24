@RequestMapping(value = "/", method = RequestMethod.GET)
public ModelAndView getdata() {

	List<String> list = getList();

	//return back to index.jsp
	ModelAndView model = new ModelAndView("index");
	model.addObject("lists", list);

	return model;

}