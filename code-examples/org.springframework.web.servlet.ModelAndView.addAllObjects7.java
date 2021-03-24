@ExceptionHandler(BusinessException.class)
ModelAndView handleExceptionView(BusinessException exception, HttpServletResponse response) {
    response.setStatus(exception.getStatus());
    ModelAndView modelAndView = new ModelAndView("error/" + exception.getStatus());
    modelAndView.addAllObjects(ResponseMessage.error(exception.getMessage(), exception.getStatus()).toMap());
    modelAndView.addObject("exception", exception);
    modelAndView.addObject("absPath", WebUtil.getBasePath(WebUtil.getHttpServletRequest()));
    return modelAndView;
}