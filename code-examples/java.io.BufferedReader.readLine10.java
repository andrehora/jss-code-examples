private static String getReceive(HttpURLConnection con) throws IOException {
	InputStream is = null;
	try {
		is = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,
				defaulEncoding));
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null)
			sb.append(line);
		return sb.toString();
	} finally {
		if (null != is)
			is.close();
	}
}