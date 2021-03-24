@ExceptionHandler(Throwable.class)
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public ModelAndView exception(final Throwable throwable, final Model model) {
    logger.error("Exception during execution of SpringSecurity application", throwable);
    StringBuffer sb = new StringBuffer();
    sb.append("Exception during execution of Spring Security application!   ");

    sb.append((throwable != null && throwable.getMessage() != null ? throwable.getMessage() : "Unknown error"));

    if (throwable != null && throwable.getCause() != null) {
        sb.append(" root cause: ").append(throwable.getCause());
    }
    model.addAttribute("error", sb.toString());

    ModelAndView mav = new ModelAndView();
    mav.addObject("error", sb.toString());
    mav.setViewName("error");

    return mav;
}