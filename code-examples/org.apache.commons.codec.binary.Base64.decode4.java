Base64 base64 = new Base64();
String valueToDecode = "aHR0cHM6Ly9zaW1wbGVzb2x1dGlvbi5kZXYv";
byte[] decodedBytes = base64.decode(valueToDecode);
String decodedString = new String(decodedBytes);