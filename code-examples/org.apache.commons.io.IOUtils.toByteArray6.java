public static final byte[] get(String url, Map<String, String> headers) {
	try {
		URLConnection conn = new URL(url).openConnection();
		if (headers != null) {
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				conn.setRequestProperty(entry.getKey(), entry.getValue());
			}
		}
		InputStream is = conn.getInputStream();
		byte[] result = IOUtils.toByteArray(is);
		is.close();
		List<String> header = conn.getHeaderFields().get("Content-Disposition");
		if (header != null && header.size() > 0) {
			headers.put("Content-Disposition", header.get(0));
		}
		return result;
	} catch (Exception e) {
		throw new RuntimeException(e);
	}
}