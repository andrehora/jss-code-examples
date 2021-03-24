public class BufferedReaderDemo {
   public static void main(String[] args) throws Exception {
      String s ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      StringReader sr = null; 
      BufferedReader br = null;

      try {
         // create and assign a new string reader
         sr = new StringReader(s);
         
         // create  new buffered reader
         br = new BufferedReader(sr);

         // reads and prints BufferedReader
         int value = 0;
         
         while((value = br.read()) != -1) {
         
            // skips a character
            br.skip(1);
            System.out.print((char)value);
         }
         
      } catch (Exception e) {
         // exception occurred.
         e.printStackTrace();
      } finally {
         // releases any system resources associated with the stream
         if(sr!=null)
            sr.close();
         if(br!=null)
            br.close();
      }
   }
}