public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView mav)
{
	HttpSession session = request.getSession();

	if (session != null) {
		Message message = (Message)session.getAttribute(Message.ATTRIBUTE_KEY);
		if (message != null && !mav.getModelMap().containsKey(Message.ATTRIBUTE_KEY)) {
			mav.addObject(Message.ATTRIBUTE_KEY, message);
		}

		boolean shouldRemove = true;
		if (mav.hasView() && mav.getView() instanceof RedirectView) {
			shouldRemove = false;
		}
		if (mav.getViewName() != null && mav.getViewName().startsWith("redirect:")) {
			shouldRemove = false;
		}

		if (shouldRemove) {
			session.removeAttribute(Message.ATTRIBUTE_KEY);
		}
	}
}