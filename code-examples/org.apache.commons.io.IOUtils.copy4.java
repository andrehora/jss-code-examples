public void givenUsingCommonsIoWithCopy_whenConvertingAnInputStreamToAString_thenCorrect() 
  throws IOException {
    String originalString = randomAlphabetic(8);
    InputStream inputStream = new ByteArrayInputStream(originalString.getBytes());
 
    StringWriter writer = new StringWriter();
    String encoding = StandardCharsets.UTF_8.name();
    IOUtils.copy(inputStream, writer, encoding);
 
    assertThat(writer.toString(), equalTo(originalString));
}