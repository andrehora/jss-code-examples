public void testWriteBytes() throws IOException {
    File temp = createTempFile();
    byte[] data = newPreFilledByteArray(2000);
    Files.write(data, temp);
    assertTrue(Arrays.equals(data, Files.toByteArray(temp)));

    try {
      Files.write(null, temp);
      fail("expected exception");
    } catch (NullPointerException expected) {
    }
  }