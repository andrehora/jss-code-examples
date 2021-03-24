public class BufferedReaderDemo {
   public static void main(String[] args) throws Exception {
      InputStream is = null; 
      InputStreamReader isr = null;
      BufferedReader br = null;

      try {
         // open input stream test.txt for reading purpose.
         is = new FileInputStream("c:/test.txt");
         
         // create new input stream reader
         isr = new InputStreamReader(is);
         
         // create new buffered reader
         br = new BufferedReader(isr);
      
         int value = 0;
         
         // reads to the end of the stream 
         while((value = br.read()) != -1) {
         
            // converts int to character
            char c = (char)value;
            
            // prints character
            System.out.println(c);
         }
         
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         // releases resources associated with the streams
         if(is!=null)
            is.close();
         if(isr!=null)
            isr.close();
         if(br!=null)
            br.close();
      }
   }
}