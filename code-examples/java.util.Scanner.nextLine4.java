public class ScannerNextLineExample1 {    
     public static void main(String args[]){   
             Scanner scan = new Scanner(System.in);  
             System.out.print("Enter Item ID: ");  
         String itemID = scan.nextLine();  
         System.out.print("Enter Item price: ");  
         String priceStr = scan.nextLine();  
         double price = Double.valueOf(priceStr);         
         System.out.println("Price of Item "+itemID + " is $"+price);  
             scan.close();  
           }    
}