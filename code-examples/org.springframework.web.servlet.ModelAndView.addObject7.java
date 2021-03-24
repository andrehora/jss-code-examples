@RequestMapping(value = "/registration", method = RequestMethod.POST)
public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	ModelAndView modelAndView = new ModelAndView();
	User userExists = userService.findUserByEmail(user.getEmail());
	if (userExists != null) {
		bindingResult.rejectValue("email", "error.user",
				"There is already a user registered with the email provided");
	}
	if (bindingResult.hasErrors()) {
		modelAndView.setViewName("registration");
	} else {
		userService.saveUser(user);
		modelAndView.addObject("successMessage", "User has been registered successfully");
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("registration");

	}
	return modelAndView;
}