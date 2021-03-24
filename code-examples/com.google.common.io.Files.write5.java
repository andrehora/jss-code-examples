private static void writeFile() {

	String content = "hello";
	File file = new File("/Users/dxm/Documents/test.txt");

	try {
		Files.write(content.getBytes(Charsets.UTF_8),file);
	} catch (IOException e) {
		e.printStackTrace();
	}
	System.out.println("end");
}