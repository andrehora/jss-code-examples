public void testEncodeDecodeSmall() {
	for (int i = 0; i < 12; i++) {
		byte[] data = new byte[i];
		this.getRandom().nextBytes(data);
		byte[] enc = Base64.encodeBase64(data);
		assertTrue("\"" + (new String(enc)) + "\" is Base64 data.", Base64.isArrayByteBase64(enc));
		byte[] data2 = Base64.decodeBase64(enc);
		assertTrue(toString(data) + " equals " + toString(data2), Arrays.equals(data, data2));
	}
}