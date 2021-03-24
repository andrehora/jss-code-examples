public void whenConvertingInProgressToFile_thenCorrect() 
  throws IOException {
  
    InputStream initialStream = new FileInputStream(
      new File("src/main/resources/sample.txt"));
    File targetFile = new File("src/main/resources/targetFile.tmp");
    OutputStream outStream = new FileOutputStream(targetFile);
 
    byte[] buffer = new byte[8 * 1024];
    int bytesRead;
    while ((bytesRead = initialStream.read(buffer)) != -1) {
        outStream.write(buffer, 0, bytesRead);
    }
    IOUtils.closeQuietly(initialStream);
    IOUtils.closeQuietly(outStream);
}