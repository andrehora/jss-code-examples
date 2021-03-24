public class encodeBase64 {

	public static void main(String[] args) {

		String string = "Javacodegeeks";

		// Get bytes from string

		byte[] byteArray = Base64.encodeBase64(string.getBytes());

		// Print the encoded byte array

		System.out.println(Arrays.toString(byteArray));

		// Print the encoded string

		String encodedString = new String(byteArray);

		System.out.println(string + " = " + encodedString);
	}
}