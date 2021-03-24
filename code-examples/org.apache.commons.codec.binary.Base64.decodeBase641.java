String originalInput = "test input";
String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
String decodedString = new String(Base64.decodeBase64(encodedString.getBytes()));