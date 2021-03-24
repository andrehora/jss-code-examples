private ModelAndView generateSuccessView(final Assertion assertion, final String proxyIou,
                                         final WebApplicationService service,
                                         final TicketGrantingTicket proxyGrantingTicket) {

    final ModelAndView modelAndView = getModelAndView(true, service);

    modelAndView.addObject(CasViewConstants.MODEL_ATTRIBUTE_NAME_ASSERTION, assertion);
    modelAndView.addObject(CasViewConstants.MODEL_ATTRIBUTE_NAME_SERVICE, service);
    modelAndView.addObject(CasViewConstants.MODEL_ATTRIBUTE_NAME_PROXY_GRANTING_TICKET_IOU, proxyIou);
    if (proxyGrantingTicket != null) {
        modelAndView.addObject(CasViewConstants.MODEL_ATTRIBUTE_NAME_PROXY_GRANTING_TICKET, proxyGrantingTicket.getId());
    }
    final Map<String, ?> augmentedModelObjects = augmentSuccessViewModelObjects(assertion);
    if (augmentedModelObjects != null) {
        modelAndView.addAllObjects(augmentedModelObjects);
    }
    return modelAndView;
}