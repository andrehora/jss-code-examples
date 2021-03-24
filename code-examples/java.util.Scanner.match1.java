public class ScannerDemo {
   public static void main(String[] args) {

      String s = "Hello World! 3 + 3.0 = 6 ";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // check if next token is "Hello"
      System.out.println("" + scanner.hasNext("Hello"));

      // find the last match and print it
      System.out.println("" + scanner.match());

      // print the line
      System.out.println("" + scanner.nextLine());

      // close the scanner
      scanner.close();
   }
}