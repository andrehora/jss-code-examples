public class solution { 
    public static void main(String args[]) 
    { 
  
        // try-catch block to handle exceptions 
        try { 
  
            // Create a file object 
            File f = new File("program.txt"); 
  
            // Get the absolute path of file f 
            String absolute = f.getAbsolutePath(); 
  
            // Display the file path of the file object 
            // and also the file path of absolute file 
            System.out.println("Original  path: "
                               + f.getPath()); 
            System.out.println("Absolute  path: "
                               + absolute); 
        } 
        catch (Exception e) { 
            System.err.println(e.getMessage()); 
        } 
    } 
}