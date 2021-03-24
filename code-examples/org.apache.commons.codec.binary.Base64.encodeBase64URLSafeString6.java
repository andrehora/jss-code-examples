public void shouldSignAndVerifyWithECDSA384() throws Exception {
    ECDSAAlgorithm algorithm384 = (ECDSAAlgorithm) Algorithm.ECDSA384((ECPublicKey) readPublicKeyFromFile(PUBLIC_KEY_FILE_384, "EC"), (ECPrivateKey) readPrivateKeyFromFile(PRIVATE_KEY_FILE_384, "EC"));
    String content384 = "eyJhbGciOiJFUzM4NCJ9.eyJpc3MiOiJhdXRoMCJ9";

    for (int i = 0; i < 10; i++) {
        byte[] signature = algorithm384.sign(content384.getBytes());
        String signature384 = Base64.encodeBase64URLSafeString((signature));

        String token  = content384 + "." + signature384;
        JWT jwt = JWT.require(algorithm384).withIssuer("auth0").build();
        DecodedJWT decoded = jwt.decode(token);
        algorithm384.verify(decoded, EncodeType.Base64);
    }
}