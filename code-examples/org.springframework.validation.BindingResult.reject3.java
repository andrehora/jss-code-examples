@RequestMapping(value = "/register", method = RequestMethod.POST)
public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {

	// Lookup user in database by e-mail
	User userExists = userService.findByEmail(user.getEmail());

	System.out.println(userExists);

	if (userExists != null) {
		modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
		modelAndView.setViewName("register");
		bindingResult.reject("email");
	}

	if (bindingResult.hasErrors()) { 
		modelAndView.setViewName("register");		
	} else { // new user so we create user and send confirmation e-mail

		// Disable user until they click on confirmation link in email
		user.setEnabled(false);

		// Generate random 36-character string token for confirmation link
		user.setConfirmationToken(UUID.randomUUID().toString());

		userService.saveUser(user);

		String appUrl = request.getScheme() + "://" + request.getServerName();

		SimpleMailMessage registrationEmail = new SimpleMailMessage();
		registrationEmail.setTo(user.getEmail());
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
				+ appUrl + "/confirm?token=" + user.getConfirmationToken());
		registrationEmail.setFrom("noreply@domain.com");

		emailService.sendEmail(registrationEmail);

		modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
		modelAndView.setViewName("register");
	}

	return modelAndView;
}