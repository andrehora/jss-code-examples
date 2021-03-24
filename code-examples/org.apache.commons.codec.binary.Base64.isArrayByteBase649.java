public static String decodeBase64(String pEncodedString) {
  try {
    byte[] encodedBytes = pEncodedString.getBytes("UTF-8");
    // this is only a low protection, and don't say that the given bytes really base64.
    if (Base64.isArrayByteBase64(encodedBytes)) {
      return new String(Base64.decodeBase64(encodedBytes), "UTF-8");
    }
    // is not base 64 encoded
    return pEncodedString;
  } catch (UnsupportedEncodingException e) {
    throw new IllegalStateException("UTF-8 encoding unknown!", e);
  }
}