public class ReadFile_Guava_Files_ReadLines {
  public static void main(String[] args) throws IOException {
    String fileName = "c:\\temp\\sample-10KB.txt";
    File file = new File(fileName);

    List fileLinesList = Files.readLines(file, Charsets.UTF_8);
    
    for(String line : fileLinesList) {
      System.out.println(line);
    }
  }
}