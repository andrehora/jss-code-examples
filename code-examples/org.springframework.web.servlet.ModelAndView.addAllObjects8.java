public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    ModelAndView errorMav;
    logger.debug("resolving Exception");
    if (ex instanceof ValidationException) {
        logger.debug("is a ValidationException");
        ValidationException ve = (ValidationException) ex;
        errorMav = new ModelAndView(ve.getViewName());
        errorMav.addObject(errorMessageKey, ve.getErrorMessageKey());
        errorMav.addAllObjects(ve.getModelElements());
        return errorMav;
    } else if (ex instanceof IllegalArgumentException) {
        errorMav = new ModelAndView("editStep2");
        errorMav.addObject("error", "ERROR: " + ex.getMessage());
        return errorMav;
    //return new ModelAndView("arraystoreView");
    } else
        return null;
}