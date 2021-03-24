@ExceptionHandler(ProductNotFoundException.class)
public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
    ModelAndView mav = new ModelAndView();
    mav.addObject("invalidProductId", exception.getProductId());
    mav.addObject("exception", exception);
    mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
    mav.setViewName("productNotFound");
    return mav;
}