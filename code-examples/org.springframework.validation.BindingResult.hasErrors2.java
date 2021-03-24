@PostMapping("/")
public String checkForm(@Valid UserForm userForm, BindingResult bindingResult,
		RedirectAttributes atts) {

	if (bindingResult.hasErrors()) {
		return "form";
	}

	atts.addAttribute("name", userForm.getName());
	atts.addAttribute("email", userForm.getEmail());

	return "redirect:/showInfo";
}