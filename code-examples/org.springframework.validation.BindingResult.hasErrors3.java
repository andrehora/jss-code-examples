@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
public String addStudent(@ModelAttribute("student") @Validated Student student, 
		BindingResult bindingResult, Model model) {

	if (bindingResult.hasErrors()) {
		return "addStudent";
	}
	model.addAttribute("name", student.getName());
	model.addAttribute("age", student.getAge());
	model.addAttribute("id", student.getId());

	return "result";
}