public List<StreamFeatured> getFeatured(Optional<Long> limit, Optional<Long> offset) {
	// Endpoint
	String requestUrl = String.format("%s/streams/featured", Endpoints.API.getURL());
	RestTemplate restTemplate = getTwitchClient().getRestClient().getRestTemplate();

	// Parameters
	restTemplate.getInterceptors().add(new QueryRequestInterceptor("limit", limit.orElse(25l).toString()));
	restTemplate.getInterceptors().add(new QueryRequestInterceptor("offset", offset.orElse(0l).toString()));

	// REST Request
	try {
		StreamFeaturedList responseObject = restTemplate.getForObject(requestUrl, StreamFeaturedList.class);

		return responseObject.getFeatured();
	} catch (Exception ex) {
		Logger.error(this, "Request failed: " + ex.getMessage());
		Logger.trace(this, ExceptionUtils.getStackTrace(ex));
	}

	return new ArrayList<StreamFeatured>();
}