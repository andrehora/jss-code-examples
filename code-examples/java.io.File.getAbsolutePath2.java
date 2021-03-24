public class FileGetAbsolutePathExample {

	public static void main(String[] args) {

		// initialize File object
		File file = new File("input\\test.txt");

		boolean result;
		// check if file exists
		result=file.exists();
		if(result){
			// print message that file exists
			System.out.println(file.getAbsolutePath() + " exists");
		}
		else{
			//print message that the file does not exist
			System.out.println(file.getAbsolutePath()+" does not exists");
		}
	}
}