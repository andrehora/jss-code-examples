public class FileIsDirectoryExample {

	public static void main(String[] args) {

		// initialize File object
		File file = new File("C:\\javatutorialhq\\input");
		// check if the file is a directory
		boolean result = file.isDirectory();
		if (result) {
			System.out.println(file.getAbsolutePath() + " is a directory");
			System.out.println("***** Listing all files on the directory *****");
			// listing the files
			String[] list = file.list();
			for (String s : list) {
				System.out.println(s);
			}
		}
	}
}