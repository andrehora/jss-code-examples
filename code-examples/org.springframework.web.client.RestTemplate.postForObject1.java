ClientHttpRequestFactory requestFactory = getClientHttpRequestFactory();
RestTemplate restTemplate = new RestTemplate(requestFactory);
 
HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
Foo foo = restTemplate.postForObject(fooResourceUrl, request, Foo.class);
assertThat(foo, notNullValue());
assertThat(foo.getName(), is("bar"));