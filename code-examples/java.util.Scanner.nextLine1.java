public class ScannerDemo {
   public static void main(String[] args) {

      String s = "Hello World! \n 3 + 3.0 = 6.0 true ";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // print the next line
      System.out.println("" + scanner.nextLine());

      // print the next line again
      System.out.println("" + scanner.nextLine());

      // close the scanner
      scanner.close();
   }
}