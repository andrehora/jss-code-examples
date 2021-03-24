public void testCreateFileByteSink() throws Exception {
	File dest = new File("src/test/resources/byteSink.pdf");
	dest.deleteOnExit();
	byteSink = Files.asByteSink(dest);
	File file = new File("src/main/resources/sample.pdf");
	byteSink.write(Files.toByteArray(file));
	assertThat(Files.toByteArray(dest),is(Files.toByteArray(file)));
}