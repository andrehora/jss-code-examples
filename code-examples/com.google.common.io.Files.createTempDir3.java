public void testCreateTempDir() {
	File temp = Files.createTempDir();
	assertTrue(temp.exists());
	assertTrue(temp.isDirectory());
	assertThat(temp.listFiles()).isEmpty();
	assertTrue(temp.delete());
}