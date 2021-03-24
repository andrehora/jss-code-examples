public class ScannerDemo {
   public static void main(String[] args) {

      String s = "Hello World! \n 3 + 3.0 = 6 ";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // print the next line
      System.out.println("" + scanner.nextLine());

      // check if there is a next line again
      System.out.println("" + scanner.hasNextLine());

      // print the next line
      System.out.println("" + scanner.nextLine());

      // check if there is a next line again
      System.out.println("" + scanner.hasNextLine());

      // close the scanner
      scanner.close();
   }
}