@GetMapping(
		path = {"/oauth2.0/authorize"}
)
public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	J2EContext context = WebUtils.getPac4jJ2EContext(request, response);
	ProfileManager manager = WebUtils.getPac4jProfileManager(request, response);
	if(this.verifyAuthorizeRequest(request) && isRequestAuthenticated(manager, context)) {
		String clientId = context.getRequestParameter("client_id");
		OAuthRegisteredService registeredService = this.getRegisteredServiceByClientId(clientId);
		try {
			RegisteredServiceAccessStrategyUtils.ensureServiceAccessIsAllowed(clientId, registeredService);
		} catch (Exception var8) {
			LOGGER.error(var8.getMessage(), var8);
			return OAuth20Utils.produceUnauthorizedErrorView();
		}
		ModelAndView mv = this.consentApprovalViewResolver.resolve(context, registeredService);
		return !mv.isEmpty() && mv.hasView()?mv:this.redirectToCallbackRedirectUrl(manager, registeredService, context, clientId);
	} else {
		LOGGER.error("Authorize request verification failed");
		return OAuth20Utils.produceUnauthorizedErrorView();
	}
}