public static void main(String[] args) {
         
         
        String encodedString = "This is Base64 encoding and decoding example";
        Base64 base64 = new Base64();
         
        String encodedVersion = new String(base64.encode(encodedString.getBytes()));
         
        System.out.println("Encoded Version is " + encodedVersion);
         
        String decodedVersion = new String(base64.decode(encodedVersion.getBytes()));
         
        System.out.println("Decoded version is "+ decodedVersion);
         
         
        Base64 binaryBase64 = new Base64();
        Random binaryRandomData = new Random();
        byte[] binaryRandomBytes = new byte[32];
        binaryRandomData.nextBytes(binaryRandomBytes);
         
         
        String dataInternalVersion =  new String(binaryBase64.encodeBase64(binaryRandomBytes));
         
        System.out.println("Encoded version of binary data is " + dataInternalVersion);
         
        String decodedData = new String(binaryBase64.decodeBase64(dataInternalVersion));
}