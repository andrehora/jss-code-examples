public class BufferedReaderSkip {

	public static void main(String[] args) {
		System.out.print("Enter a sample string: ");
		// declare the BufferedReader Class
		// used the InputStreamReader to read the console input
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		// catch the possible IOException by the read() method
		try {
			// skip 8 characters on the input stream
			reader.skip(8);
			// print what is remaining on the input stream
			System.out.println("Output:"+reader.readLine());

			// close the BufferedReader object
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}