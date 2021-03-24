public void testByteToStringVariations() throws DecoderException {
	Base64 base64 = new Base64(0);
	byte[] b1 = StringUtils.getBytesUtf8("Hello World");
	byte[] b2 = new byte[0];
	byte[] b3 = null;
	byte[] b4 = Hex.decodeHex("2bf7cc2701fe4397b49ebeed5acc7090".toCharArray());  // for url-safe tests

	assertEquals("byteToString Hello World", "SGVsbG8gV29ybGQ=", base64.encodeToString(b1));
	assertEquals("byteToString static Hello World", "SGVsbG8gV29ybGQ=\r\n", Base64.encodeBase64String(b1));
	assertEquals("byteToString \"\"", "", base64.encodeToString(b2));
	assertEquals("byteToString static \"\"", "", Base64.encodeBase64String(b2));
	assertEquals("byteToString null", null, base64.encodeToString(b3));
	assertEquals("byteToString static null", null, Base64.encodeBase64String(b3));
	assertEquals("byteToString UUID", "K/fMJwH+Q5e0nr7tWsxwkA==", base64.encodeToString(b4));
	assertEquals("byteToString static UUID", "K/fMJwH+Q5e0nr7tWsxwkA==\r\n", Base64.encodeBase64String(b4));
	assertEquals("byteToString static-url-safe UUID", "K_fMJwH-Q5e0nr7tWsxwkA", Base64.encodeBase64URLSafeString(b4));
}