class Util
{
	public static void main(String[] args)
	{
		String string = "Techie Delight";

		// encode string using Base64 encoder
		byte[] encodedBytes = Base64.encodeBase64(string.getBytes());
		System.out.println("Encoded Data: " + new String(encodedBytes));

		// decode the encoded data
		String decodedString = new String(Base64.decodeBase64(encodedBytes));
		System.out.println("Decoded Data: " + decodedString);
	}
}