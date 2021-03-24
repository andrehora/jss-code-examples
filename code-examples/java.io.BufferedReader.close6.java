public void testOpenBufferedStream() throws IOException {
  BufferedReader reader = source.openBufferedStream();
  assertTrue(source.wasStreamOpened());
  assertFalse(source.wasStreamClosed());

  StringWriter writer = new StringWriter();
  char[] buf = new char[64];
  int read;
  while ((read = reader.read(buf)) != -1) {
    writer.write(buf, 0, read);
  }
  reader.close();
  writer.close();

  assertTrue(source.wasStreamClosed());
  assertEquals(STRING, writer.toString());
}