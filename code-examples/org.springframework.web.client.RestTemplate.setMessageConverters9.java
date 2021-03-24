public static RestTemplate createRestTemplateWithJsonSupport(final String proxyHost, final int proxyPort) {
    RestTemplate rt = createRestTemplate(proxyHost, proxyPort);
    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
    messageConverters.add(new MappingJackson2HttpMessageConverter());
    rt.setMessageConverters(messageConverters);
    return rt;
}