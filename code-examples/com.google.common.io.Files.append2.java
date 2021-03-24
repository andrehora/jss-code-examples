public static void main (String args[]) {
	https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
	File to = new File("C:/test/test.csv");

	for (int i = 0; i < 42; i++) {
    		CharSequence from = "some string" + i + "\n";
    		Files.append(from, to, Charsets.UTF_8);
	}
}