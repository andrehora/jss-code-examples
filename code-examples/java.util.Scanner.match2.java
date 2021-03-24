public class GFG1 { 
    public static void main(String[] argv) 
        throws Exception 
    { 
  
        String s = "GFG Geeks!"; 
  
        // create a new scanner 
        // with the specified String Object 
        Scanner scanner = new Scanner(s); 
  
        // check if next token is "GFG" 
        System.out.println("" + scanner.hasNext("GFG")); 
  
        // find the last match and print it 
        System.out.println("" + scanner.match()); 
  
        // print the line 
        System.out.println("" + scanner.nextLine()); 
  
        // close the scanner 
        scanner.close(); 
    } 
}