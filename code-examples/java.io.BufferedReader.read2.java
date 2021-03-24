public class BufferedReaderReadMethod {

	public static void main(String[] args) {
		System.out.println("Do you want to Continue? ");
		// declare the BufferedReader Class
		// used the InputStreamReader to read the console input
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int readVal;
		// catch the possible IOException by the read() method
		try {
			// assign the return value of the read() method to a variable
			readVal = reader.read();
			// print the read char converted in int
			System.out.println("Character from console in int:" + readVal);
			// print the char read from console input 
			// by the BufferedReader class
			System.out.println("Character from console in char:"
					+ (char) readVal);
			// close the BufferedReader object
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}