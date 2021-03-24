public class GFG1 { 
    public static void main(String[] argv) 
        throws Exception 
    { 
  
        String s = "gfg 2 geeks!"; 
  
        // new scanner with the 
        // specified String Object 
        Scanner scanner = new Scanner(s); 
  
        // use US locale to interpret Lines in a string 
        scanner.useLocale(Locale.US); 
  
        // iterate till end 
        while (scanner.hasNextLine()) { 
  
            // print what is scanned 
            System.out.println(scanner.nextLine()); 
        } 
  
        // close the scanner 
        scanner.close(); 
    } 
}