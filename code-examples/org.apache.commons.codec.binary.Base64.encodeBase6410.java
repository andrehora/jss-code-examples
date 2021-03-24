public static String AESEncrypt(String keyStr, String plainText) throws Exception {
    byte[] encrypt = null;
    try {
        Key key = generateKey(keyStr);
        Cipher cipher = Cipher.getInstance(AES_TYPE);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        encrypt = cipher.doFinal(plainText.getBytes());
        return new String(Base64.encodeBase64(encrypt));
    } catch (Exception e) {
        LOGGER.error("aes encrypt failure : {}", e);
        throw e;
    }
}