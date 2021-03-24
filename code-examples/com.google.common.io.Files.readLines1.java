public void whenReadMultipleLinesUsingFiles_thenRead() throws IOException {
    File file = new File("test.txt");
    List<String> result = Files.readLines(file, Charsets.UTF_8);
 
    assertThat(result, contains("John", "Jane", "Adam", "Tom"));
}