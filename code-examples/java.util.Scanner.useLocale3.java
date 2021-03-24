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
  
        // display the previous locale 
        System.out.println("Current Lcoale: "
                           + scanner.locale()); 
  
        // change the locale of the scanner 
        scanner.useLocale(Locale.ENGLISH); 
        System.out.println("Changing Locale to ENGLISH"); 
  
        // display the new locale 
        System.out.println("Updated Locale: "
                           + scanner.locale()); 
  
        // close the scanner 
        scanner.close(); 
    } 
}