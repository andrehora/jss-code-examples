public class ScannerUseLocaleDemo {

	public static void main(String[] args) {

		// Initialize Scanner object
		Scanner scan = new Scanner("William Hectre/Male/24");
		// initialize the string delimiter
		scan.useDelimiter("/");
		// Printing the delimiter used
		System.out.println("The delimiter used is "+scan.delimiter());
		// set the locale to be used
		Locale locale = Locale.ENGLISH;
		// set the locale to the scanner object
		scan.useLocale(locale);
		// Printing the tokenized Strings
		while(scan.hasNext()){
			System.out.println(scan.next());
		}
		// closing the scanner stream
		scan.close();

	}

}