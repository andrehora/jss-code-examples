RestTemplate restTemplate = new RestTemplate();
HttpEntity<Foo> request = new HttpEntity<>(new Foo("bar"));
ResponseEntity<Foo> response = restTemplate
  .exchange(fooResourceUrl, HttpMethod.POST, request, Foo.class);
  
assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
  
Foo foo = response.getBody();
  
assertThat(foo, notNullValue());
assertThat(foo.getName(), is("bar"));