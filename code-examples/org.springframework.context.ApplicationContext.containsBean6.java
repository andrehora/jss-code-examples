public void setApplicationContext(ApplicationContext applicationContext)
		throws BeansException {
	if (StringUtils.isEmpty(userCacheBean)) {
		if (applicationContext.containsBean(userServiceBean)) {
			userDetailsService = (UserDetailsService) applicationContext
					.getBean(userServiceBean);
		} else {
			throw new RuntimeException("Can not found spring bean["
					+ userServiceBean + "] implements "
					+ UserDetailsService.class.getName() + " interface!");
		}
	} else {
		if (applicationContext.containsBean(userCacheBean)) {
			userCache = (UserCache) applicationContext
					.getBean(userServiceBean);
		} else {
			throw new RuntimeException("Can not found spring bean["
					+ userCacheBean + "] implements "
					+ UserCache.class.getName() + " interface!");
		}

	}
}