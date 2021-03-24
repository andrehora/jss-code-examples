public void sessionDestroyed(HttpSessionEvent se) {
    ApplicationContext ctx = WebApplicationContextUtils
            .getWebApplicationContext(se.getSession().getServletContext());

    if (ctx == null) {
        logger.warn("cannot find applicationContext");

        return;
    }

    HttpSession session = se.getSession();
    UserAuthDTO userAuthDto = this.internalUserAuthConnector
            .findFromSession(session);

    String tenantId = null;

    if (userAuthDto != null) {
        tenantId = userAuthDto.getTenantId();
    }

    LogoutEvent logoutEvent = new LogoutEvent(session, null,
            session.getId(), tenantId);
    ctx.publishEvent(logoutEvent);
}