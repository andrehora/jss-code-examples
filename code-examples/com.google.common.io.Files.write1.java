public void whenWriteUsingFiles_thenWritten() throws IOException {
    String expectedValue = "Hello world";
    File file = new File("test.txt");
    Files.write(expectedValue, file, Charsets.UTF_8);
    String result = Files.toString(file, Charsets.UTF_8);
    assertEquals(expectedValue, result);
}