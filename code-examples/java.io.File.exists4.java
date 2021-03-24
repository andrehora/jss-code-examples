public class FileExistsExample {

	public static void main(String[] args) {

		// initialize File object
		File file = new File("C:\\javatutorialhq\\input\\test_file.txt");

		boolean result;
		//
		result=file.exists();
		if(result){
			// if file exists, read the contents
			System.out.println("File exists... reading the contents");
			Scanner s;
			try {
				s = new Scanner(file);
				//print the contents of the file
				while(s.hasNextLine()){
					System.out.println(s.nextLine());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		else{
			//print message that the file does not exist
			System.out.println("File does not exists");
		}
	}
}