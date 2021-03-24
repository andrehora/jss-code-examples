public Map<String, Object> sendPostForUpload(String url, Map<String, Object> parameters) {
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
    requestFactory.setBufferRequestBody(false);
    
    RestTemplate restTemplate = new RestTemplate(requestFactory);
    List<HttpMessageConverter<?>> mc = restTemplate.getMessageConverters();
    mc.add(new MappingJackson2HttpMessageConverter());
    restTemplate.setMessageConverters(mc);
    
    MultiValueMap<String, Object> postParams = new LinkedMultiValueMap<String, Object>();
    postParams.setAll(parameters);
    Map<String, Object> response = new HashMap<String, Object>();
    HttpHeaders headers = new HttpHeaders();
    headers.set("Content-Type", "multipart/form-data");
    headers.set("Accept", "application/json");
    headers.add("Cookie", "JSESSIONID=" + localContext.getCookieStore().getCookies().get(0).getValue());
    HttpEntity<Object> request = new HttpEntity<Object>(postParams, headers);
    ResponseEntity<?> result = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
    String body = result.getBody().toString();
    MediaType contentType = result.getHeaders().getContentType();
    HttpStatus statusCode = result.getStatusCode();
    response.put(CONTENT_TYPE, contentType);
    response.put(STATUS_CODE, statusCode);
    response.put(BODY, body);

    return response;

}