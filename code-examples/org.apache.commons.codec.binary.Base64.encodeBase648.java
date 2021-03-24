private String computeAccessSignature(String timestamp, HttpMethod method, String urlTxt, ByteBuffer body)
        throws GeneralSecurityException {
    if (conn == null) {
        throw new IllegalStateException("cannot generate exchange request post-disconnect()");
    }

    String prehash = timestamp + method.name() + urlTxt;

    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(signingKey);
    mac.update(prehash.getBytes());
    if (body != null) {
        mac.update(body);
    }
    return new String(Base64.encodeBase64(mac.doFinal()));
}