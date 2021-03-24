public class TempDirTest {

  public static void main(String[] args) throws IOException {
    File tmpDir = Files.createTempDir();
    System.out.println(tmpDir);
  }

}