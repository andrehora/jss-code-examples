public RestTemplate createRestTemplate() {
  RestTemplate restTemplate = new RestTemplate();
  List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
  MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
  jsonMessageConverter.setObjectMapper(objectMapper);
  messageConverters.add(jsonMessageConverter);
  restTemplate.setMessageConverters(messageConverters);
  return restTemplate;
}