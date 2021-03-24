public static byte[] decrypt(byte[] encrypted)
        throws GeneralSecurityException {

    SecretKeySpec skeySpec = new SecretKeySpec(
            Base64.decodeBase64(ENCRYPTION_KEY), "AES");

    byte[] decoded = Base64.decodeBase64(encrypted);
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    return cipher.doFinal(decoded);
}