public class ScannerDemo {
   public static void main(String[] args) {

      String s = "Hello World! 3 + 3.0 = 6.0 true ";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // print a line of the scanner
      System.out.println("" + scanner.nextLine());

      // change the locale of the scanner
      scanner.useLocale(Locale.ENGLISH);

      // display the new locale
      System.out.println("" + scanner.locale());

      // close the scanner
      scanner.close();
   }
}