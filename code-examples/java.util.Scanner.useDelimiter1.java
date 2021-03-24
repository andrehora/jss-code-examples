public class ScannerDemo {
   public static void main(String[] args) {

      String s = "Hello World! 3 + 3.0 = 6.0 true ";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // print a line of the scanner
      System.out.println("" + scanner.nextLine());

      // change the delimiter of this scanner
      scanner.useDelimiter("Wor");

      // display the new delimiter
      System.out.println("" + scanner.delimiter());

      // close the scanner
      scanner.close();
   }
}