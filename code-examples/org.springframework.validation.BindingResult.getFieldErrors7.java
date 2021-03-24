@RequestMapping(value = "/addTopic", method = RequestMethod.POST)
public String addTopic(@Valid @ModelAttribute ForumModel newForumModel, BindingResult bindingResult,
		Model model) {
	if (bindingResult.hasErrors()) {
		String errorMessage = "";
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			errorMessage += fieldError.getField() + " is invalid<br>";
		}
		model.addAttribute("errorMessage", errorMessage);
		return "/forum";
	}

	
	forumRepository.save(newForumModel);
	return "/forum";
}