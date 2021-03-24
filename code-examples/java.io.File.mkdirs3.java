public class GFG { 
  
    public static void main(String args[]) 
    { 
  
        // create an abstract pathname (File object) 
        File f = new File("F:\\program"); 
  
        // check if the directory can be created 
        // using the abstract path name 
        if (f.mkdirs()) { 
  
            // display that the directory is created 
            // as the function returned true 
            System.out.println("Directory is created"); 
        } 
        else { 
  
            // display that the directory cannot be created 
            // as the function returned false 
            System.out.println("Directory cannot be created"); 
        } 
    } 
}