@RequestMapping(value="/confirm", method = RequestMethod.POST)
public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {

	modelAndView.setViewName("confirm");

	Zxcvbn passwordCheck = new Zxcvbn();

	Strength strength = passwordCheck.measure(requestParams.get("password"));

	if (strength.getScore() < 3) {
		bindingResult.reject("password");

		redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

		modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
		System.out.println(requestParams.get("token"));
		return modelAndView;
	}

	// Find the user associated with the reset token
	User user = userService.findByConfirmationToken(requestParams.get("token"));

	// Set new password
	user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

	// Set user to enabled
	user.setEnabled(true);

	// Save user
	userService.saveUser(user);

	modelAndView.addObject("successMessage", "Your password has been set!");
	return modelAndView;		
}