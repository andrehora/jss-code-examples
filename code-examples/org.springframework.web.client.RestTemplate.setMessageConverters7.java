public RestTemplate createRestTemplate(HttpProxyConfiguration httpProxyConfiguration, boolean
        trustSelfSignedCerts) {
    RestTemplate restTemplate = new LoggingRestTemplate();
    restTemplate.setRequestFactory(createRequestFactory(httpProxyConfiguration, trustSelfSignedCerts));
    restTemplate.setErrorHandler(new CloudControllerResponseErrorHandler());
    restTemplate.setMessageConverters(getHttpMessageConverters());

    return restTemplate;
}