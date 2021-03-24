public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws IOException {
    if (modelAndView != null) {
        if (modelAndView.getModel().containsKey("currentTabWrapped")) {
            final Object tabObject = modelAndView.getModelMap().get("currentTabWrapped");
            if (tabObject instanceof ProposalTabWrapper) {
                ProposalTabWrapper currentTabWrapped = (ProposalTabWrapper) tabObject;
                if (!currentTabWrapped.getCanAccess()) {
                    modelAndView.setViewName(ErrorText.ACCESS_DENIED.flashAndReturnView(request));
                }
            }
        }
    }
}