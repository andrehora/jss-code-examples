@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
public ModelAndView getUser(@PathVariable String username) {
  ModelAndView mav;
  try {
    MatrixUser mxUser = blackboard.getUserInfo(username);
    mav = new ModelAndView("json/user");
    mxUser.setMode("get");
    mxUser.setStatus("ok");
    mav.getModel().put("user", mxUser);
  }
  catch(BlackboardException be) {
    mav = new ModelAndView("json/error");
    mav.getModel().put("error", be.getMessage());
  }
  return mav;
}