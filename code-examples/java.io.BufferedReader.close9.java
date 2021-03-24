public static String streamToString(InputStream is) throws IOException {
	String str  = "";
	
	if (is != null) {
		StringBuilder sb = new StringBuilder();
		String line;
		
		try {
			BufferedReader reader 	= new BufferedReader(new InputStreamReader(is));
			
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
		} finally {
			is.close();
		}
		
		str = sb.toString();
	}
	
	return str;
}