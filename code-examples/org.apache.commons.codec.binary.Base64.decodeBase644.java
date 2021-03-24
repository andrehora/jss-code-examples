public static void encodingDecodingApacheCommons() {
  // ---Encode Data---
  byte[] encoded = Base64.encodeBase64(sampleText.getBytes());
  String encodedText =  new String(encoded);

  // ---Decode Data---
  byte[] decoded = Base64.decodeBase64(encodedText.getBytes());
  String decodedText =  new String(decoded);

  System.out.println("Base64 Encoding/Decoding - Apache Commons");
  System.out.println("-----------------------------------------");
  System.out.println("SampleText......: " + sampleText);
  System.out.println("EncodedText.....: " + encodedText);
  System.out.println("DecodedText.....: " + decodedText);
  System.out.println();
 }