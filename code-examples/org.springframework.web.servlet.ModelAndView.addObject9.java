@GetMapping(value = "/login")
public ModelAndView login(
        @RequestParam(value = "error", required = false) String error,
        @RequestParam(value = "logout", required = false) String logout) {

    logger.info("******login(error): {} ***************************************", error);
    logger.info("******login(logout): {} ***************************************", logout);

    ModelAndView model = new ModelAndView();
    if (error != null) {
        model.addObject("error", "Invalid username and password!");
    }

    if (logout != null) {
        model.addObject("message", "You've been logged out successfully.");
    }
    model.setViewName("login");

    return model;
}