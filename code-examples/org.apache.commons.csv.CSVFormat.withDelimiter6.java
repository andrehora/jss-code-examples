public void testApacheCommonCsvDelimiter() throws Exception {
    StringReader stringReader = new StringReader("foo;bar;15;true");
    CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(';').withHeader("firstName", "lastName", "age", "married");
    ApacheCommonCsvRecord record = getApacheCommonCsvRecord(stringReader, csvFormat);
    GenericRecord<Foo> actual = mapper.processRecord(record);
    Foo foo = actual.getPayload();
    assertThat(foo).isNotNull();
    assertThat(foo.getFirstName()).isEqualTo("foo");
    assertThat(foo.getLastName()).isEqualTo("bar");
    assertThat(foo.getAge()).isEqualTo(15);
    assertThat(foo.isMarried()).isTrue();
}