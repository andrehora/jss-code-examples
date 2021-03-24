RestTemplate restTemplate = new RestTemplate();
List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
Jaxb2RootElementHttpMessageConverter jaxbMessageConverter = new Jaxb2RootElementHttpMessageConverter();
List<MediaType> mediaTypes = new ArrayList<MediaType>();
mediaTypes.add(MediaType.TEXT_HTML);
jaxbMessageConverter.setSupportedMediaTypes(mediaTypes);
messageConverters.add(jaxbMessageConverter);
restTemplate.setMessageConverters(messageConverters);