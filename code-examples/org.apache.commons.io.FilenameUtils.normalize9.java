public void testNormalize_with_nullbytes() throws Exception {
  try {
    assertEquals("a" + SEP + "b" + SEP + "c.txt", FilenameUtils.normalize("a\\b/c\u0000.txt"));
  } catch (final IllegalArgumentException ignore) {
  }
  try {
    assertEquals("a" + SEP + "b" + SEP + "c.txt", FilenameUtils.normalize("\u0000a\\b/c.txt"));
  } catch (final IllegalArgumentException ignore) {
  }
}