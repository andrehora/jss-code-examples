public class FileDemo {
   public static void main(String[] args) {      
      File f = null;
      boolean bool = false;
      
      try {
         // create new files
         f = new File("test.txt");
         
         // create new file in the system
         f.createNewFile();
         
         // tests if file exists
         bool = f.exists();
         
         // prints
         System.out.println("File exists: "+bool);
         
         if(bool == true) {
            // delete() invoked
            f.delete();
            System.out.println("delete() invoked");
         }
         
         // tests if file exists
         bool = f.exists();
         
         // prints
         System.out.print("File exists: "+bool);
         
      } catch(Exception e) {
         // if any error occurs
         e.printStackTrace();
      }
   }
}