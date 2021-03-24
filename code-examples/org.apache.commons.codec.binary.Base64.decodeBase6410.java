public static String bucketFromBase64URN(String base64URN) {
	String modelURN = "";
	if (base64URN.toLowerCase().startsWith( "urn:" ) )
	{
		base64URN = base64URN.substring( 4 ).trim();
	}
	modelURN = new String(Base64.decodeBase64( base64URN.getBytes() ) );
	return bucketFromModelURN( modelURN );
}