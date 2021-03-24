private static String decodeBase64(String base64String) {
  Base64 decoder = new Base64(0, null, true);
  byte[] data = decoder.decode(base64String);
  return new String(data);
}