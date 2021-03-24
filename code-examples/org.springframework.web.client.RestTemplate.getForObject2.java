Foo foo = restTemplate
  .getForObject(fooResourceUrl + "/1", Foo.class);
assertThat(foo.getName(), notNullValue());
assertThat(foo.getId(), is(1L));