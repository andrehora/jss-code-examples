public class FileWriteTest {

  public static void main(String[] args) throws IOException {
    File file = new File("C:\\abcd.txt");
    //Creates a new file if it doesn't exist 
    //Overwrites the file if already available
    Files.write("BE THE CODER", file, Charsets.UTF_8);
    System.out.println("Successfully written the file");
  }

}