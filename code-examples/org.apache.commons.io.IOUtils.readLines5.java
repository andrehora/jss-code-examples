public LineFile(InputStream in) {
	try {
		lines = IOUtils.readLines(in);
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
}