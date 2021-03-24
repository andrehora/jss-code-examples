public class WrapperAspect {
  public ModelAndView auth(ProceedingJoinPoint joinPoint) {
    HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();

    if (checkCredentials(request)) {
      try {
        return (ModelAndView)joinPoint.proceed();
      }
      catch(Throwable theEnd) {
        ModelAndView mav = new ModelAndView("json/error");
        mav.getModel().put("error", theEnd.getMessage());
        return mav;
      }
    }
    else {
      ModelAndView mav = new ModelAndView("json/error");
      mav.getModel().put("error", "unauthorised");
      return mav;
    }
  }
}