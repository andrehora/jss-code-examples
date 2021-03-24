@RequestMapping(method = RequestMethod.POST)
  public String handlePostRequest (@Valid @ModelAttribute("user") User user,
                                   BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
          return "user-registration";
      }

      userService.saveUser(user);
      return "registration-done";
  }