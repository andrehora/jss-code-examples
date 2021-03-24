public void givenUsingCommonsIO_whenConvertingStringToInputStream_thenCorrect() 
  throws IOException {
    String initialString = "text";
    InputStream targetStream = IOUtils.toInputStream(initialString);
}