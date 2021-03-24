public class GFG1 { 
    public static void main(String[] argv) 
        throws Exception 
    { 
  
        String s = "Geeksforgeeks has Scanner Class Methods"; 
  
        // create a new scanner 
        // with the specified String Object 
        Scanner scanner = new Scanner(s); 
  
        // print a line of the scanner 
        System.out.println("Scanner String: \n"
                           + scanner.nextLine()); 
  
        // display the old delimiter 
        System.out.println("Old delimiter: "
                           + scanner.delimiter()); 
  
        // change the delimiter of this scanner 
        scanner.useDelimiter(Pattern.compile(".ll.")); 
  
        // display the new delimiter 
        System.out.println("New delimiter: "
                           + scanner.delimiter()); 
  
        // close the scanner 
        scanner.close(); 
    } 
}