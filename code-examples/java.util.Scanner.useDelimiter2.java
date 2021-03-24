public class ScannerUseDelimiterDemo {

	public static void main(String[] args) {

		// Initialize Scanner object
		Scanner scan = new Scanner("Anna Mills/Female/18");
		// initialize the string delimiter
		scan.useDelimiter("/");
		// Printing the delimiter used
		System.out.println("The delimiter use is "+scan.delimiter());
		// Printing the tokenized Strings
		while(scan.hasNext()){
			System.out.println(scan.next());
		}
		// closing the scanner stream
		scan.close();

	}

}