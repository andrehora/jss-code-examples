private void addNewFiles(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	String artifactRelPath;
	artifactRelPath = request.getRequestURI().substring(request.getServletPath().length() + 1 );
	File destination = new File(FilenameUtils.normalize(this.saveDir + artifactRelPath));
	if (destination.exists()) {
		LOG.info("File to be added already exist: " + destination.getPath());
		response.setContentType("application/json");
		response.getWriter().append(String.format("{ \"error\": \"already exists %s\"}", destination.getPath()));
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return;
	}
	// Expected: one part containing zip
	try{
		Part part = request.getParts().iterator().next();
		WSChangeObserver changeObserver = new WSChangeObserver(ChangeType.CHANGE_CREATED, lspDestPath);
		if (extract(part.getInputStream(), changeObserver)) {
			changeObserver.notifyLSP();
			response.setContentType("application/json");
			response.getWriter().append(String.format("{ \"created\": \"%s\"}", artifactRelPath));
			response.setStatus(HttpServletResponse.SC_CREATED);
		} else {
			response.setContentType("application/json");
			response.getWriter().append(String.format("{ \"error\": \"conflict %s\"}", artifactRelPath));
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
	} catch (NoSuchElementException ePart) {
		response.setContentType("application/json");
		response.getWriter().append(String.format("{ \"error\": \"exception for %s\"}", artifactRelPath));
		response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
	}
}