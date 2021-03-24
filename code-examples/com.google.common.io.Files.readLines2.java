public class ReadLineProcessorTest {

  public static void main(String[] args) throws IOException {
    File file = new File("C:\\abcd.txt");
    String first4lines = Files.readLines(file, Charsets.UTF_8, new SimpleLineProcessor());
    System.out.println(first4lines);
  }
}