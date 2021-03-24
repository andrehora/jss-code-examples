public String signup(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    if(result.hasErrors()) {
        return "signup/form";
    }

    String email = signupForm.getEmail();
    if(calendarService.findUserByEmail(email) != null) {
        result.rejectValue("email", "errors.signup.email", "Email address is already in use.");
        return "signup/form";
    }

    CalendarUser user = new CalendarUser();
    user.setEmail(email);
    user.setFirstName(signupForm.getFirstName());
    user.setLastName(signupForm.getLastName());
    user.setPassword(signupForm.getPassword());

    logger.info("CalendarUser: {}", user);

    int id = calendarService.createUser(user);
    user.setId(id);
    userContext.setCurrentUser(user);

    redirectAttributes.addFlashAttribute("message", "You have successfully signed up and logged in.");
    return "redirect:/";
}