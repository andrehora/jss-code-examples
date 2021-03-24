public class BufferedTest {

 /**
  * @param args
  */
 public static void main(String[] args) {
  File f = new File("file2.txt");
  try {
   FileWriter fw = new FileWriter(f);
   BufferedWriter bw = new BufferedWriter(fw);
   bw.write("abcd");
   bw.newLine();
   bw.write("def");
   bw.newLine();
   bw.flush();
   bw.close();
  } catch (IOException e) {
   e.printStackTrace();
  }

  try {
   BufferedReader br = new BufferedReader(new FileReader(f));
   System.out.println("br.markSupported():" + br.markSupported());
   String line = null;
   System.out.println("Contents of file");
   br.mark(1);
   while ((line = br.readLine()) != null) {
    System.out.print(line);
   }
   System.out.println("Contents of file");
   while ((line = br.readLine()) != null) {
    System.out.print(line);
   }
   br.reset();
   System.out.println("Contents of file");
   while ((line = br.readLine()) != null) {
    System.out.print(line);
   }
   br.close();
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }

 }
}