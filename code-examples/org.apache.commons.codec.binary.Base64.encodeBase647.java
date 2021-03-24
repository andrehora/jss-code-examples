protected String encrypt(final String message, final String secretKey) throws Exception { // NOSONAR
	// SSO digest algorithm used for password. This
	final MessageDigest md = MessageDigest.getInstance(getDigest());
	final byte[] digestOfPassword = md.digest(secretKey.getBytes(StandardCharsets.UTF_8));
	final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

	// Cipher implementation.
	final String algo = get("sso.crypt", DEFAULT_IMPL);

	final SecretKey key = new SecretKeySpec(keyBytes, algo);
	final Cipher cipher = Cipher.getInstance(algo);
	cipher.init(Cipher.ENCRYPT_MODE, key);
	final byte[] plainTextBytes = message.getBytes(StandardCharsets.UTF_8);
	final byte[] buf = cipher.doFinal(plainTextBytes);
	final byte[] base64Bytes = Base64.encodeBase64(buf);
	return new String(base64Bytes, StandardCharsets.UTF_8);
}