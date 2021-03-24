public void verify(DecodedJWT jwt, EncodeType encodeType) throws Exception {
    byte[] signatureBytes = null;
    String signature = jwt.getSignature();
    String urlDecoded = null;
    switch (encodeType) {
        case Base16:
            urlDecoded = URLDecoder.decode(signature, "UTF-8");
            signatureBytes = Hex.decodeHex(urlDecoded);
            break;
        case Base32:
            Base32 base32 = new Base32();
            urlDecoded = URLDecoder.decode(signature, "UTF-8");
            signatureBytes = base32.decode(urlDecoded);
            break;
        case Base64:
            signatureBytes = Base64.decodeBase64(signature);
            break;
    }
    if (signatureBytes.length > 0) {
        throw new SignatureVerificationException(this);
    }
}