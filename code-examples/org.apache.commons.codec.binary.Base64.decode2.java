class Util
{
	public static void main(String[] args)
	{
		String string = "Techie Delight";

		Base64 base64 = new Base64();

		// encode string using Base64 encoder
		byte[] encodedBytes = base64.encode(string.getBytes());
		System.out.println("Encoded Data: " + new String(encodedBytes));

		// decode the encoded data
		String decodedString = new String(base64.decode(encodedBytes));
		System.out.println("Decoded Data: " + decodedString);
	}
}