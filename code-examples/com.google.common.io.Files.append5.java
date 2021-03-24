public void testAppendString() throws IOException {
    File temp = createTempFile();
    Files.append(I18N, temp, Charsets.UTF_16LE);
    assertEquals(I18N, Files.toString(temp, Charsets.UTF_16LE));
    Files.append(I18N, temp, Charsets.UTF_16LE);
    assertEquals(I18N + I18N, Files.toString(temp, Charsets.UTF_16LE));
    Files.append(I18N, temp, Charsets.UTF_16LE);
    assertEquals(I18N + I18N + I18N, Files.toString(temp, Charsets.UTF_16LE));
}