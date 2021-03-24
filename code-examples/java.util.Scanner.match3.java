public class ScannerMatchDemo {

	public static void main(String[] args) {

		// Initialize Scanner object
		Scanner scan = new Scanner("A E 4 1 3");
		// Printing the delimiter used
		System.out.println("Delimiter:"+scan.delimiter());
		scan.useRadix(16);
		// Print the radix the Scanner object is using
		System.out.println("Radix:"+scan.radix());
		// Printing the tokenized Strings
		while(scan.hasNextInt()){
			scan.nextInt();
			// printing the index where the delimiter has been found
			System.out.println("Pattern match at index:"+scan.match().start());
		}

		// closing the scanner stream
		scan.close();

	}

}