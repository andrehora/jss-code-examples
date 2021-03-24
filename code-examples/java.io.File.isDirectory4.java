public class FileExample {
 
	public static void main(String[] args) throws Exception {
 
		File file = null;
		File parent = null;
		boolean isDir;
		boolean isFile;
		try {
 
			System.out.println("-- file --");
			file = new File("C:\sandbox\test.txt");
 
			// check if the file object is a directory
			isDir = file.isDirectory();
			System.out.println("Is '" + file.getAbsolutePath() + "' a directory? " + isDir);
 
			// check if the file object is a file
			isFile = file.isFile();
			System.out.println("Is '" + file.getAbsolutePath() + "' a file? " + isFile);
 
			System.out.println("-- parent --");
			parent = file.getParentFile();
 
			// check if the file object is a directory
			isDir = parent.isDirectory();
			System.out.println("Is '" + parent.getAbsolutePath() + "' a directory? " + isDir);
 
			// check if the file object is a file
			isFile = parent.isFile();
			System.out.println("Is '" + parent.getAbsolutePath() + "' a file? " + isFile);
 
		} catch (Exception e) {
			System.err.println("Things went wrong: " + e.getMessage());
			e.printStackTrace();
 
		}
	}
}