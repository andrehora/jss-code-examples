public class BufferedReaderReadLine {

	public static void main(String[] args) {
		System.out.print("What is your name? ");
		// declare the BufferedReader Class
		// used the InputStreamReader to read the console input
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String readVal;
		// catch the possible IOException by the readLine() method
		try {
			// assign the return value of the readLine() method to a variable
			readVal = reader.readLine();
			// print the text read by the BufferedReader
			System.out.println("String read from console input:" + readVal);			
			// close the BufferedReader object
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}