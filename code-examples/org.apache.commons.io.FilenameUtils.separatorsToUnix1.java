private static void separators_() {

	System.out.println("*** Separator conversion ***");

	String filename = "X:\\JCG\\articles\\org.apache.commons.io.FilenameUtils Example\\notes.txt";
	System.out.println("File name: " + filename);
	filename = FilenameUtils.separatorsToUnix(filename);
	System.out.println("File name after separatorsToUnix(): " + filename);

	filename = "/JCG/articles/org.apache.commons.io.FilenameUtils Example/notes.txt";
	System.out.println("File name: " + filename);
	filename = FilenameUtils.separatorsToSystem(filename);
	System.out.println("File name after separatorsToSystem(): " + filename);
}