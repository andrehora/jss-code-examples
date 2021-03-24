public class MainClass {
  public static void main(String args[]) throws IOException {

    FileWriter fout = new FileWriter("test.txt");
    fout.write("2, 3.4,    5,6, 7.4, 9.1, 10.5, done");
    fout.close();

    FileReader fin = new FileReader("Test.txt");
    Scanner src = new Scanner(fin);
    // Set delimiters to space and comma.
    // ", *" tells Scanner to match a comma and zero or more spaces as
    // delimiters.

    src.useDelimiter(", *");

    // Read and sum numbers.
    while (src.hasNext()) {
      if (src.hasNextDouble()) {
        System.out.println(src.nextDouble());
      } else {
        break;
      }
    }
    fin.close();
  }
}