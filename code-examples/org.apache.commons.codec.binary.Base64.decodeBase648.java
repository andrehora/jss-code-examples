private String decrypt(String text) throws GeneralSecurityException {
    SecretKeySpec skeySpec = new SecretKeySpec(
            Base64.decodeBase64(ENCRYPTION_KEY), "AES");

    byte[] result;
    try {
        byte[] decoded = Base64.decodeBase64(text.getBytes());
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        result = cipher.doFinal(decoded);
    } catch (InvalidKeyException | NoSuchAlgorithmException
            | NoSuchPaddingException | IllegalBlockSizeException
            | BadPaddingException e) {
        throw new GeneralSecurityException(
                "unable to decrypt old encryption");
    }

    return new String(result);
}