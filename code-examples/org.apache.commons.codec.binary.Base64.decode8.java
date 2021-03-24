public static String decode64AsString(String cs)
{
	Base64 base64 = new Base64();
	byte[] arrBytes = cs.getBytes();
	byte[] tOut = base64.decode(arrBytes);
	String csOut = new String(tOut);
	return csOut;
}