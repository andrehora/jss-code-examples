public void shouldDoECDSA512SigningWithBothKeys() throws Exception {
    Algorithm algorithm = Algorithm.ECDSA512((ECPublicKey) readPublicKeyFromFile(PUBLIC_KEY_FILE_512, "EC"), (ECPrivateKey) readPrivateKeyFromFile(PRIVATE_KEY_FILE_512, "EC"));
    String jwtContent = String.format("%s.%s", ES512Header, auth0IssPayload);
    byte[] contentBytes = jwtContent.getBytes(StandardCharsets.UTF_8);
    byte[] signatureBytes = algorithm.sign(contentBytes);
    String jwtSignature = Base64.encodeBase64URLSafeString(signatureBytes);
    String token = String.format("%s.%s", jwtContent, jwtSignature);

    assertThat(signatureBytes, is(notNullValue()));
    JWT jwt = JWT.require(algorithm).withIssuer("auth0").build();
    DecodedJWT decoded = jwt.decode(token);
    algorithm.verify(decoded, EncodeType.Base64);
}