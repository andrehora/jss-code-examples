public class Base64Decode {
    public static void main(String[] args) {
        String hello = "SGVsbG8gV29ybGQ=";

        // Decode a previously encoded string using decodeBase64 method and
        // passing the byte[] of the encoded string.
        byte[] decoded = Base64.decodeBase64(hello.getBytes());

        // Print the decoded array
        System.out.println(Arrays.toString(decoded));

        // Convert the decoded byte[] back to the original string and print
        // the result.
        String decodedString = new String(decoded);
        System.out.println(hello + " = " + decodedString);
    }
}