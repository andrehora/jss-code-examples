public class HashMapContainsValueExample {

	public static void main(String args[]) throws InterruptedException {

		// initialize the hashmap object with Integer as key and String as value
		HashMap<Integer, String> mapStudent = new HashMap<Integer, String>();
		
		// populate the student map
		mapStudent.put(13215, "Steve Atkins");
		mapStudent.put(17891, "Albert Travis");
		mapStudent.put(98412, "Paolo Quintos");
		
		// get the user input of student name
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Student Name:");
		String name = scan.nextLine();
		
		// check if the student name were in student HashMap
		if(mapStudent.containsValue(name)){
			System.out.println("Student "+name +" found on the database");			
		}
		else{
			System.out.println("Student "+name +" not found");
		}
		
		// close the scanner object to avoid memory leak
		scan.close();			

	}
}