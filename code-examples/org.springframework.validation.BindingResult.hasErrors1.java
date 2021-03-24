@PostMapping("/")
public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

	if (bindingResult.hasErrors()) {
		return "form";
	}

	return "redirect:/results";
}