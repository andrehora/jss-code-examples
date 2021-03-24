public void openFile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("name");
	name=decode(name);
	ProcessProvider targetProvider=ProcessProviderUtils.getProcessProvider(name);
	if(targetProvider==null){
		throw new RuntimeException("Unsupport file : "+name);
	}
	InputStream inputStream=targetProvider.loadProcess(name);
	try{
		byte[] bytes=IOUtils.toByteArray(inputStream);
		ProcessDefinition process=ProcessParser.parseProcess(bytes, 0, true);
		writeObjectToJson(resp, process);
	}catch(Exception ex){
		throw new RuntimeException(ex);
	}finally{
		IOUtils.closeQuietly(inputStream);
	}
}