public class Main {

   public static void main(String[] args) {

      String s = "java2s.com 1 + 1 = 2.0 true ";

      Scanner scanner = new Scanner(s);

      System.out.println(scanner.nextLine());

      // change the locale of the scanner
      scanner.useLocale(Locale.ENGLISH);

      // display the new locale
      System.out.println(scanner.locale());

      scanner.close();
   }
}