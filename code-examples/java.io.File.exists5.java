public class TemporaryFileExample
{
   public static void main(String[] args)
   {
      File temp;
      try
      {
         temp = File.createTempFile("myTempFile", ".txt");
          
         boolean exists = temp.exists();
          
         System.out.println("Temp file exists : " + exists);
      } catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}