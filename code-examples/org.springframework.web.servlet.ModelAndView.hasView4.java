public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    if (modelAndView == null || !modelAndView.hasView()) {
        return;
    }

    String originalViewName = modelAndView.getViewName();
    if (originalViewName.startsWith("redirect:") || originalViewName.startsWith("forward:")) {
        return;
    }
    modelAndView.setViewName(LayoutFile);
    modelAndView.addObject(ReturnedHtmlFile,originalViewName);
}