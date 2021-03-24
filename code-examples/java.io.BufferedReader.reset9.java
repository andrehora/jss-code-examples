public static boolean sessionAlreadyImported(File xmlImportFile, File xmlSessionFile) throws IOException {
	BufferedReader br1 = new BufferedReader(new FileReader(xmlSessionFile)); //sessionfile
	BufferedReader br2 = new BufferedReader(new FileReader(xmlImportFile)); //desktop import
	String s1, s2;
	
	s1 = br1.readLine();
	s2 = br2.readLine();
	s2 = br2.readLine();
	br2.mark(2000);;
	while(s1 != null) {		
		while (s1 != null && s2 != null && s1.equals(s2)) {
			s1 = br1.readLine();
			s2 = br2.readLine();
			if (s2 == null) {
				br1.close();
				br2.close();
				return true;
			}
		}
		br2.reset();
		s1 = br1.readLine();
	}
	br1.close();
	br2.close();
	return false;
}