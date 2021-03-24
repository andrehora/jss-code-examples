@RequestMapping(value = "technician-add", method = RequestMethod.POST)
  public String add(@ModelAttribute("technicianAttribute") TechnicianUserWrapper technicianWrapper, BindingResult result, Model model) {

    if (technicianWrapper.getFirstName() == null || technicianWrapper.getSurname() == null
            || technicianWrapper.getUsername() == null || technicianWrapper.getPassword() == null) {
      result.reject("e", ERR_OMMITEDFIELD);
    } else if (!testUniqueName(technicianWrapper.getUsername())) {
      result.reject("e", ERR_USERNAMEEXISTS);
    }

    if (result.hasErrors()) {
      model.addAttribute("actionURL", "/technician-add");
      return "technician-add";
    }

    Technician technician = new Technician();
    technician.setFirstName(technicianWrapper.getFirstName());
    technician.setSurname(technicianWrapper.getSurname());
    technician.setDateHired(technicianWrapper.getDateHired());
    technician.setDateOfBirth(technicianWrapper.getDateOfBirth());
    technician.setDegree(technicianWrapper.getDegree());

    User user = new User();
    user.setActive(1);
    user.setUsername(technicianWrapper.getUsername());

    user.setPassword(encryptPassword(technicianWrapper.getPassword(), technicianWrapper.getUsername()));
    user.setKindOfUser("ROLE_TECHNIK");

    user.setTechnician(technician);

    userService.addUser(user);

    model.addAttribute("id", user.getTechnician().getId());
    return "redirect:/technician-detail";
  }