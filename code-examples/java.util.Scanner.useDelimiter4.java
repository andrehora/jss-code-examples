public class ScannerUseDelimiterExample1 {    
     public static void main(String args[]){   
           String str = "JavaTpoint! 13 + 13.0 = 26.0 false ";  
         //Create scanner with the specified String Object  
         Scanner scanner = new Scanner(str);  
         //Print String  
         System.out.println("String: " + scanner.nextLine());  
         //Change the delimiter of this scanner  
         scanner.useDelimiter("vaT");  
         //Display the new delimiter  
         System.out.println("New delimiter: " +scanner.delimiter());  
         scanner.close();  
         }    
}