public class FileMkdirsExample {

	public static void main(String[] args) {
		
		// initialize File object
		File file = new File("C:\\javatutorialhq\\test_folder\\input\\test1");		
		// check if the pathname already exists
		// if not create it
		if(!file.exists()){
			// create the full path name
			boolean result = file.mkdirs();
			if(result){
				System.out.println("Successfully created "+file.getAbsolutePath());
			}
			else{
				System.out.println("Failed creating "+file.getAbsolutePath());
			}
		}else{
			System.out.println("Pathname already exists");
		}
	}
}