private T connect(final PathBuilder config) throws RestClientException {
	final RestTemplate restTemplate = new RestTemplate(httpMessageConverters);
	final SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
	rf.setReadTimeout(2000);
	rf.setConnectTimeout(2000);
	config.addParam("t", RestfulContext.getToken());
	final ResponseEntity<T> re = restTemplate.getForEntity(config.buildEndpointURI(), dtoType);
	return re.getBody();
}