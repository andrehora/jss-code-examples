public class BufferedReaderReset {

	public static void main(String[] args) {
		System.out.print("Enter Characters: ");
		// declare the BufferedReader Class
		// used the InputStreamReader to read the console input
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		// catch the possible IOException by the read() method
		try {
			// read characters from the stream
			System.out.println((char)reader.read());
			System.out.println((char)reader.read());
			// mark the stream
			reader.mark(1);
			System.out.println("Printing char after mark");
			System.out.println((char)reader.read());
			// reset the stream
			reader.reset();
			System.out.println("Printing characters after reset");
			System.out.println((char)reader.read());
			System.out.println((char)reader.read());
			System.out.println((char)reader.read());

			// close the BufferedReader object
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}