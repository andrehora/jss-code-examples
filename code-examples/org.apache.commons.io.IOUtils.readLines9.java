public void write() throws Exception {
    String secondString = "second_test_string";
    access.access(targetFileName).appendln(fileContent).close();
    access.access(targetFileName).append(secondString).close();
    assertTrue(targetFile.isFile());
    List<String> result = IOUtils.readLines(new FileInputStream(targetFile));
    assertEquals(fileContent, result.get(result.size() - 2));
    assertEquals(secondString, result.get(result.size() - 1));
}