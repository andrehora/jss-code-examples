public void respond() throws Exception {
	BufferedReader br =	new BufferedReader(new InputStreamReader(sock.getInputStream()));
	BufferedWriter bw =	new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
	String line = "";
	while ((line = br.readLine()) != null) {
		Chat.log("Receieved: " + line);
		// line: Name:ID,Players,Status
		
		ServerStatus.fromString(line);
		bw.write("1");
		bw.newLine();
		bw.flush();
	}

	bw.close();
	br.close();
	sock.close();
}