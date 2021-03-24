private void sendFavicon(HttpServletResponse response) throws IOException
{
	InputStream fis = null;
	OutputStream out = null;
	try
	{
		response.setContentType("image/x-icon");
		fis = WebServlet.class.getResourceAsStream("/resources/icon.ico");
		out = response.getOutputStream();
		IOUtils.copy(fis, out);
	}
	finally
	{
		IOUtils.closeQuietly(out);
		IOUtils.closeQuietly(fis);
	}
	return;
}