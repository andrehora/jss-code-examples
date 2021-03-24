@RequestMapping(value = "/article/show")
public ModelAndView show(@RequestParam final Integer id) {
	final ModelMap modelMap = new ModelMap();

	final Collection<Category> categories = this.categoryDao.find();
	modelMap.addAttribute("categories", categories);
	modelMap.addAttribute("article", this.articleDao.getById(id));

	return new ModelAndView("showArticle" /* JSP généré */)
			.addAllObjects(modelMap);
}