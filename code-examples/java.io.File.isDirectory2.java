public class FileDemo {
   public static void main(String[] args) {      
      File f = null;
      String path;
      boolean bool = false;
      
      try {
         // create new file
         f = new File("c:");
            
         // true if the file path is directory, else false
         bool = f.isDirectory();
         
         // get the path
         path = f.getPath();
         
         // prints
         System.out.println(path+" is directory? "+ bool);
               
         // create new file
         f = new File("c:/test.txt");
         
         // true if the file path is directory, else false
         bool = f.isDirectory();
         
         // get the path
         path = f.getPath();
         
         // prints
         System.out.print(path+" is directory? "+bool);
         
      } catch(Exception e) {
         // if any error occurs
         e.printStackTrace();
      }
   }
}