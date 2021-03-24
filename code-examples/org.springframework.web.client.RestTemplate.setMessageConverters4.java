@Bean
public RestTemplate restTemplate()
{
    RestTemplate restTemplate = new RestTemplate();
 
    restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(clientHttpRequestFactory()));
    restTemplate.setMessageConverters(Collections.singletonList(mappingJacksonHttpMessageConverter()));
 
    restTemplate.setInterceptors( Collections.singletonList(new RequestResponseLoggingInterceptor()) );
 
    return restTemplate;
}