public static void readURL() throws MalformedURLException, IOException {
	InputStream in = new URL("http://commons.apache.org").openStream();
	try {
		System.out.println(IOUtils.toString(in));
	} finally {
		IOUtils.closeQuietly(in);
	}
}