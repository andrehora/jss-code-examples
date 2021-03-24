public class solution { 
    public static void main(String args[]) 
    { 
  
        // Get the file 
        File f = new File("F:\\program"); 
  
        // Check if the specified path 
        // is a directory or not 
        if (f.isDirectory()) 
            System.out.println("Directory"); 
        else
            System.out.println("is not Directory"); 
    } 
}