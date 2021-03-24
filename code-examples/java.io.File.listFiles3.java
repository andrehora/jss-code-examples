public class FileListFilesExample {

	public static void main(String[] args) {

		// initialize File object
		File file = new File("C:\\javatutorialhq");

		// check if the specified pathname is directory first
		if(file.isDirectory()){
			//list all files on directory
			File[] files = file.listFiles();
			for(File f:files){
				try {
					System.out.println(f.getCanonicalPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}