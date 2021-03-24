@RequestMapping("/projects/create")
public String create(@Validated ProjectCreateForm projectCreateForm, BindingResult bindingResult) {
	if (bindingResult.hasErrors()) {
		bindingResult.reject("message.error.param", new Object[]{"foo"}, null);
		return "projects/list";
	}
	try {
		projectService.create(projectCreateForm.getName());
	} catch (Exception e) {
		logHandler.handle(e);
	}
	return "projects/list";
}