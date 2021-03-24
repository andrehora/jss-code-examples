public void encrypt() throws Exception {
 AesCipher cipher = new AesCipher(pathToSecretKey());
 String encryptedText = cipher.encrypt("this is a secret");
 assertThat(StringUtils.isNotBlank(encryptedText)).isTrue();
 assertThat(Base64.isArrayByteBase64(encryptedText.getBytes())).isTrue();
}