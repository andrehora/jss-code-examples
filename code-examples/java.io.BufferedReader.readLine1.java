public class BufferedReaderDemo {
   public static void main(String[] args) throws Exception {
      String thisLine = null;
      
      try {
         // open input stream test.txt for reading purpose.
         BufferedReader br = new BufferedReader("c:/test.txt");
         
         while ((thisLine = br.readLine()) != null) {
            System.out.println(thisLine);
         }       
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}