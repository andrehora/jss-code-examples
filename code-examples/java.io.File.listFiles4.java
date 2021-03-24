public class listFilesExample { // public class FileExample {
 
	public static void main(String[] args) throws Exception {
 
		File file = null;
		File[] paths;
 
		try {
 
			file = new File("c:\sandbox");
 
			// list of file objects
			paths = file.listFiles();
 
			// for each name in the path array
			for (File path : paths) {
				// prints file name or directory name
				if (path.isDirectory()) {
					System.out.println("Directory " + path);
				} else {
					System.out.println("File " + path);
				}
			}
 
		} catch (Exception e) {
			System.err.println("Things went wrong: " + e.getMessage());
			e.printStackTrace();
		}
	}
}