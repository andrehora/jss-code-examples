public class ScannerNextLine {

	public static void main(String[] args) throws FileNotFoundException {
		// Declare File object
		File file = new File("E:/tmp/java/tutorial/scanner/example.txt");
		// initialize the scanner
		Scanner scan = new Scanner(file);
		// iterate through the file line by line
		while(scan.hasNextLine()){
			// print the contents of a file by line
			System.out.println(scan.nextLine());
		}
		// close the scanner object;
		scan.close();

	}
}