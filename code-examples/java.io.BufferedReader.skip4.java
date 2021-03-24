public class Main {
  public static void main(String[] args) throws Exception {

    String s = "from java2s.com";

    // create and assign a new string reader
    StringReader sr = new StringReader(s);

    // create new buffered reader
    BufferedReader br = new BufferedReader(sr);

    // reads and prints BufferedReader
    int value = 0;
    while ((value = br.read()) != -1) {
      // skips a character
      br.skip(1);
      System.out.print((char) value);
    }

  }
}