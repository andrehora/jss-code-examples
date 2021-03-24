public String getToken() {
	String content = String.format("%s.%s", b64(jsonMinify(getHeaderJson())), b64(jsonMinify((getPayloadJson()))));

	String signatureEncoded = Base64.encodeBase64URLSafeString(this.signature);

	return String.format("%s.%s", content, signatureEncoded);
}