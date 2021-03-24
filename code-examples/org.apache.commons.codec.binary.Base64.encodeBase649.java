public void setStartArguments(String[] startArguments) {
	
	if (startArguments.length==0) {
		this.startArguments = null;
		return;
	}
	String[] startArgumentsEncoded = new String[startArguments.length];
	String encodedArgument = null;
	try {
		for (int i = 0; i < startArguments.length; i++) {
			encodedArgument = new String(Base64.encodeBase64(startArguments[i].getBytes("UTF8")));
			startArgumentsEncoded[i] = encodedArgument;
		}
		
	} catch (UnsupportedEncodingException e) {
		e.printStackTrace();
	}
	this.startArguments = startArgumentsEncoded;
}