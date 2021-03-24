public class ScannerHasNextLineExample1 {    
    public static void main(String args[]){       
          String str = "Facebook.com \n 1 + 1 = 2.0 \n JavaTpoint.com ";  
        Scanner scanner = new Scanner(str);  
        //Print the next line  
        System.out.println(scanner.nextLine());  
        //Check if there is a next line again  
        System.out.println(scanner.hasNextLine());  
        System.out.println(scanner.nextLine());  
        //Check if there is a next line again  
        System.out.println(scanner.hasNextLine());  
        System.out.println(scanner.nextLine());  
        //Check if there is a next line again  
        System.out.println(scanner.hasNextLine());  
        scanner.close();  
      }    
}