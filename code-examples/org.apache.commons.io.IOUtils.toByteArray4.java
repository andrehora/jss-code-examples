class Util
{
	public static byte[] toByteArray(InputStream in) throws IOException {

		byte[] bytes = IOUtils.toByteArray(in);
		return bytes;
	}

	public static void main(String[] args) throws IOException
	{
		// input stream
		InputStream in = new ByteArrayInputStream("Techie Delight"
										.getBytes(StandardCharsets.UTF_8));

		// byte array
		byte[] bytes = toByteArray(in);
		System.out.println(new String(bytes));
	}
}