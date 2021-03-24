public class ScannerHasNextLine {

	public static void main(String[] args) throws FileNotFoundException {
		// Declare File object
		File file = new File("E:/tmp/java/tutorial/scanner/example.txt");
		// initialize the scanner
		Scanner scan = new Scanner(file);
		// iterate through the file line by line
		while(scan.hasNextLine()){
			// print the token
			System.out.println(scan.next());
		}
		scan.close();
	}
}