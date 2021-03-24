public class GFG1 {
	public static void main(String[] argv) throws Exception {

		String s = "Gfg \n Geeks \n GeeksForGeeks";

		// create a new scanner
		// with the specified String Object
		Scanner scanner = new Scanner(s);

		// print the next line
		System.out.println(scanner.nextLine());

		// print the next line again
		System.out.println(scanner.nextLine());

		// print the next line again
		System.out.println(scanner.nextLine());

		scanner.close();
	}
}