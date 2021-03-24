public class HashMapIsEmptyExample {

	public static void main(String args[]) throws InterruptedException {

		// declare the hashmap
		HashMap<String, String> mapStudent = new HashMap<>();

		// put contents of our HashMap
		mapStudent.put("12487912", "Shyra Travis");
		mapStudent.put("45129987", "Sharon Wallace");

		// check if the HashMap is empty or not
		if (!mapStudent.isEmpty()) {

			// printing the key value pairs available
			// if the hashmap is not empty
			for (String s : mapStudent.keySet()) {
				System.out.println("Student with id # " + s + " is " + mapStudent.get(s));
			}
		}
	}
}