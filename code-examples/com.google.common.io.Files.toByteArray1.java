public void testToByteArray() throws IOException {
    File asciiFile = getTestFile("ascii.txt");
    File i18nFile = getTestFile("i18n.txt");
    assertTrue(Arrays.equals(ASCII.getBytes(Charsets.US_ASCII),
        Files.toByteArray(asciiFile)));
    assertTrue(Arrays.equals(I18N.getBytes(Charsets.UTF_8),
        Files.toByteArray(i18nFile)));
    assertTrue(Arrays.equals(I18N.getBytes(Charsets.UTF_8),
        Files.asByteSource(i18nFile).read()));
}