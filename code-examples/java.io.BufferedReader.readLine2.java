class cat {

	public static void main(String args[]) {

		String thisLine;

		// Loop across the arguments
		for (int i = 0; i < args.length; i++) {

			// Open the file for reading
			try {
				BufferedReader br = new BufferedReader(new FileReader(args[i]));
				while ((thisLine = br.readLine()) != null) { // while loop begins here
					System.out.println(thisLine);
				} // end while
			} // end try
			catch (IOException e) {
				System.err.println("Error: " + e);
			}
		} // end for

	} // end main
}