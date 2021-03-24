public ModelAndView
defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
  // If the exception is annotated with @ResponseStatus rethrow it and let
  // the framework handle it - like the OrderNotFoundException example
  // at the start of this post.
  // AnnotationUtils is a Spring Framework utility class.
  logger.error("exception: {}", e);
  if (AnnotationUtils.findAnnotation
      (e.getClass(), ResponseStatus.class) != null) {
    throw e;
  }

  // Otherwise setup and send the user to a default error-view.
  ModelAndView mav = new ModelAndView();
  mav.addObject("exception", e);
  mav.addObject("url", req.getRequestURL());
  mav.setViewName(DEFAULT_ERROR_VIEW);
  return mav;
}