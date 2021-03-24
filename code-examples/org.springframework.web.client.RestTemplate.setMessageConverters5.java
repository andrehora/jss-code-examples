public RestTemplate getRestTemplateWithHalMessageConverter() {
 RestTemplate restTemplate = new RestTemplate();
 List<HttpMessageConverter<?>> existingConverters = restTemplate.getMessageConverters();
 List<HttpMessageConverter<?>> newConverters = new ArrayList<>();
 newConverters.add(getHalMessageConverter());
 newConverters.addAll(existingConverters);
 restTemplate.setMessageConverters(newConverters);
 return restTemplate;
}