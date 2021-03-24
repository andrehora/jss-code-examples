public void testInputStreamToByteArray() throws IOException {

    byte[] expecteds = LOREM_IPSUM.getBytes("UTF-8");
    byte[] actuals = org.apache.commons.io.IOUtils.toByteArray(new StringReader(LOREM_IPSUM), "UTF-8");

    assertArrayEquals(expecteds, actuals);
}