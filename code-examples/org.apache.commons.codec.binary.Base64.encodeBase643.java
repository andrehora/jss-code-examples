public static void encodingDecodingApacheCommonsUTF() {

  // ---Encode Data---

  byte[] encoded = Base64.encodeBase64(sampleText
                            .getBytes(StandardCharsets.UTF_8));

  String encodedText =  new String(encoded, StandardCharsets.UTF_8);

  // ---Decode Data---

  byte[] decoded = Base64.decodeBase64(encodedText

                            .getBytes(StandardCharsets.UTF_8));

  String decodedText =  new String(decoded, StandardCharsets.UTF_8);

 

  System.out.println("Base64 Encoding/Decoding - Apache (UTF_8)");
  System.out.println("-----------------------------------------");
  System.out.println("SampleText......: " + sampleText);
  System.out.println("EncodedText.....: " + encodedText);
  System.out.println("DecodedText.....: " + decodedText);
  System.out.println();

 }

}