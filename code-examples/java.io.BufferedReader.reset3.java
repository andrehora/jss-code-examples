public class Main {
  public static void main(String[] args) throws Exception {

    String s = "from java2s.com";

    StringReader sr = new StringReader(s);

    BufferedReader br = new BufferedReader(sr);

    // reads and prints BufferedReader
    System.out.println((char) br.read());
    System.out.println((char) br.read());

    // mark invoked at this position
    br.mark(0);
    System.out.println("mark() invoked");
    System.out.println((char) br.read());
    System.out.println((char) br.read());

    // reset() repositioned the stream to the mark
    br.reset();
    System.out.println("reset() invoked");
    System.out.println((char) br.read());
    System.out.println((char) br.read());

  }
}