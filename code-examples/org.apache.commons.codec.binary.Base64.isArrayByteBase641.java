public void testEncodeDecodeRandom() {
	for (int i = 1; i < 5; i++) {
		byte[] data = new byte[this.getRandom().nextInt(10000) + 1];
		this.getRandom().nextBytes(data);
		byte[] enc = Base64.encodeBase64(data);
		assertTrue(Base64.isArrayByteBase64(enc));
		byte[] data2 = Base64.decodeBase64(enc);
		assertTrue(Arrays.equals(data, data2));
	}
}