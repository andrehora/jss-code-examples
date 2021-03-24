public void givenUsingCommonsIO_whenConvertingAnInputStreamToAByteArray_thenCorrect() 
  throws IOException {
    ByteArrayInputStream initialStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });
     
    byte[] targetArray = IOUtils.toByteArray(initialStream);
}