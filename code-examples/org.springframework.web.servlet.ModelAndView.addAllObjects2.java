public ModelAndView handleRequest(final HttpServletRequest request,
		final HttpServletResponse response) throws Exception {
	ModelAndView modelAndView = null;
	User user = new User();
	user.setAge(10);
	user.setName("Dummy user");

	User autoUser = new User();
	autoUser.setAge(11);
	autoUser.setName("Auto");

	String conTime = "CON TIME";
	//the view, attribute name and value
	modelAndView = new ModelAndView("data", "model", user);
	modelAndView.addObject(autoUser);//just the attribute - name auto-generated

	modelAndView.addObject("tpVariable", conTime);//atribute and name

	User testUser = new User();
	testUser.setAge(61);
	testUser.setName("Test user");

	Map<String, Object> modelMap = new LinkedHashMap<String, Object>();
	modelMap.put("testValue", "testValue");
	modelMap.put("int", 10);
	modelMap.put("tUser", testUser);

	modelAndView.addAllObjects(modelMap);// a map of attributes
	return modelAndView;
}