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
         
         // releases any system resources associated with reader
         br.close();
         
         // creates error
         br.read();
         
      } catch(IOException e) {
         // IO error
         System.out.println("The buffered reader is closed");
      } finally {
         // releases any system resources associated
         if(is!=null)
            is.close();
         if(isr!=null)
            isr.close();
         if(br!=null)
            br.close();
      }
   }
}