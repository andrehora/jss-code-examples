@RequestMapping(value = "/users/password", method = RequestMethod.POST)
public String setPasswordPage(@Valid UserPasswordDTO userPasswordDTO, BindingResult result, Model model,
                              RedirectAttributes attributes) {

    long userId = userPasswordDTO.getUserId();
    if (result.hasErrors()) {
        model.addAttribute("userDescription", getUserDescription(userId));
        return ADMIN_USERPASSWORD_VIEW;
    } else {
        if (!userPasswordDTO.getPassword().equals(userPasswordDTO.getRepeatedPassword())) {
            result.reject(GLOBAL_ERROR_PASSWORDS_DONOT_MATCH_KEY);
            model.addAttribute("userDescription", getUserDescription(userId));
            return ADMIN_USERPASSWORD_VIEW;
        } else {
            userService.updatePassword(userPasswordDTO);
            Optional<User> user = userService.getUserById(userPasswordDTO.getUserId());
            if (user.isPresent()) {
                webUI.addFeedbackMessage(attributes, FEEDBACK_USER_PASSWORD_UPDATED_KEY, user.get().getFirstName(),
                        user.get().getLastName());
            }
        }
    }
    return "redirect:/admin/users";
}