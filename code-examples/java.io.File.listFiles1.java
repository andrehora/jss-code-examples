public class FileDemo {
   public static void main(String[] args) {      
      File f = null;
      File[] paths;
      
      try {  
      
         // create new file
         f = new File("c:/test");
         
         // returns pathnames for files and directory
         paths = f.listFiles();
         
         // for each pathname in pathname array
         for(File path:paths) {
         
            // prints file and directory paths
            System.out.println(path);
         }
         
      } catch(Exception e) {
         // if any error occurs
         e.printStackTrace();
      }
   }
}