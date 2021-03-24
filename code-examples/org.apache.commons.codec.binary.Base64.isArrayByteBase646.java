public void generateRandomSecretKey() {
	AesCipher cipher = new AesCipher(null);
	String key = cipher.generateRandomSecretKey();
	assertThat(StringUtils.isNotBlank(key)).isTrue();
	assertThat(Base64.isArrayByteBase64(key.getBytes())).isTrue();
}