public void verifyOK() throws Exception {
    final MockHttpServletRequest mockRequest = new MockHttpServletRequest(
            "GET",
            CONTEXT
            + OAuthConstants.CALLBACK_AUTHORIZE_URL);
    mockRequest.addParameter(OAuthConstants.TICKET, SERVICE_TICKET);
    final MockHttpSession mockSession = new MockHttpSession();
    mockSession.putValue(OAuthConstants.OAUTH20_CALLBACKURL, REDIRECT_URI);
    mockSession.putValue(OAuthConstants.OAUTH20_SERVICE_NAME, SERVICE_NAME);
    mockRequest.setSession(mockSession);
    final MockHttpServletResponse mockResponse = new MockHttpServletResponse();

    final ModelAndView modelAndView = oauth20WrapperController.handleRequest(mockRequest, mockResponse);
    assertEquals(OAuthConstants.CONFIRM_VIEW, modelAndView.getViewName());
    final Map<String, Object> map = modelAndView.getModel();
    assertEquals(SERVICE_NAME, map.get("serviceName"));
    assertEquals(REDIRECT_URI + '?' + OAuthConstants.CODE + '=' + SERVICE_TICKET, map.get("callbackUrl"));
}