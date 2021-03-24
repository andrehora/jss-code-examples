public class decodeBase64 {
     
    public static void main(String[] args) {
     
        String string = "SmF2YWNvZGVnZWVrcw==";
  
 
  // Get bytes from string
 
  byte[] byteArray = Base64.decodeBase64(string.getBytes());
  
 
  // Print the decoded array
 
  System.out.println(Arrays.toString(byteArray));
  
 
  // Print the decoded string 
 
  String decodedString = new String(byteArray);
 
  System.out.println(string + " = " + decodedString);
    }
}