public void readSuccessful() throws IOException {
    String path = "file";
    File file = new File(sourceDir, path);
    InputStream inputStream = IOUtils.toInputStream(fileContent, "UTF-8");
    FileUtils.copyInputStreamToFile(inputStream, file);
    String result = access.read(path);

    assertNotNull(result);

    assertEquals(fileContent, result);
}