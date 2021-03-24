public class Main {
  public static void main(String[] args) throws Exception {
    InputStream is = new FileInputStream("c:/test.txt");

    InputStreamReader isr = new InputStreamReader(is);

    BufferedReader br = new BufferedReader(isr);

    char[] cbuf = new char[is.available()];

    br.read(cbuf, 2, 10);

    for (char c : cbuf) {
      if (c == (char) 0) {
        c = '*';
      }
      // prints characters
      System.out.print(c);
    }
  }
}