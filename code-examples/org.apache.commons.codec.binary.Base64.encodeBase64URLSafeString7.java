public void shouldDoRSA256SigningWithProvidedPrivateKey() throws Exception {
    RSAKeyProvider provider = mock(RSAKeyProvider.class);
    PrivateKey privateKey = readPrivateKeyFromFile(PRIVATE_KEY_FILE, "RSA");
    PublicKey publicKey = readPublicKeyFromFile(PUBLIC_KEY_FILE, "RSA");
    when(provider.getPrivateKey()).thenReturn((RSAPrivateKey) privateKey);
    when(provider.getPublicKeyById(null)).thenReturn((RSAPublicKey) publicKey);
    Algorithm algorithm = Algorithm.RSA256(provider);
    String jwtContent = String.format("%s.%s", RS256Header, auth0IssPayload);
    byte[] contentBytes = jwtContent.getBytes(StandardCharsets.UTF_8);
    byte[] signatureBytes = algorithm.sign(contentBytes);
    String jwtSignature = Base64.encodeBase64URLSafeString(signatureBytes);
    String token = String.format("%s.%s", jwtContent, jwtSignature);

    assertThat(signatureBytes, is(notNullValue()));
    JWT jwt = JWT.require(algorithm).withIssuer("auth0").build();
    DecodedJWT decoded = jwt.decode(token);
    algorithm.verify(decoded, EncodeType.Base64);
}