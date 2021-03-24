public void should_read_files_in_directory() throws IOException {
    // Given a temp directory that contains
    File tempDir = Files.createTempDir();
    tempDir.deleteOnExit();
    // json file
    File file1 = File.createTempFile("file1", ".json", tempDir);
    String content1 = "content1";
    Files.write(content1.getBytes(), file1);
    // n1ql file
    File file2 = File.createTempFile("file2", ".N1QL", tempDir);
    String content2 = "content2";
    Files.write(content2.getBytes(), file2);
    // txt file
    Files.write(getRandomString().getBytes(), File.createTempFile(getRandomString(), ".txt", tempDir));

    // When we read files in this directory with extension filter
    Map<String, String> result = FileUtils.readFilesInDirectory(tempDir.toPath(), "json", "n1ql");

    // Then we should have file content matching this extension
    Assert.assertEquals(2, result.size());
    Assert.assertEquals(content1, result.get(file1.getName()));
    Assert.assertEquals(content2, result.get(file2.getName()));
}