public void init() {
  restTemplate = new RestTemplate();

  SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();
  rf.setReadTimeout(portalConfig.readTimeout());
  rf.setConnectTimeout(portalConfig.connectTimeout());

  MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
  converter.setSupportedMediaTypes(
      Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));

  restTemplate.setMessageConverters(Arrays.asList(converter, new FormHttpMessageConverter()));

}