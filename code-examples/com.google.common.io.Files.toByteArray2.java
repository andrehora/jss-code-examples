public void file_to_byte_array_guava () throws IOException, URISyntaxException {

    File file = new File(fileLocation);

    byte[] fileInBytes = Files.toByteArray(file);

    assertEquals(18, fileInBytes.length);
}