public class Main {

   public static void main(String[] args) {

      String s = "java2s.com 1 + 1 = 2.0 ";

      Scanner scanner = new Scanner(s);

      // check if next token is "java"
      System.out.println(scanner.hasNext("java"));

      // find the last match and print it
      System.out.println(scanner.match());

      System.out.println(scanner.nextLine());

      scanner.close();
   }
}