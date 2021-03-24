public class FileAppendTest {

  public static void main(String[] args) throws IOException {
    File file = new File("C:\\abcd.txt");
    Files.append("\nBE THE CODER", file, Charsets.UTF_8);
  }
}