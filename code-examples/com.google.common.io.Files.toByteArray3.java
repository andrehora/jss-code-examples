public void createByteSourceFromFileTest() throws Exception {
	File f1 = new File("src/main/resources/sample.pdf");
	byteSource = Files.asByteSource(f1);
	byte[] readBytes = byteSource.read();
	assertThat(readBytes,is(Files.toByteArray(f1)));
}