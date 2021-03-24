public class StreamToByteArray2IOUtils {
   public static void main(String args[]) throws IOException{    
      File file = new File("data");
      FileInputStream fis = new FileInputStream(file);
      byte [] byteArray = IOUtils.toByteArray(fis);
      String s = new String(byteArray);
      System.out.println("Contents of the byte stream are :: "+ s);
   }  
}