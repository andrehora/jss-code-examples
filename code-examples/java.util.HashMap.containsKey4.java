public class KeySearchDemo {
 public static void main(String args[]) {
  
  // our sample map
  Map < Integer, String > idToName = new HashMap < Integer, String > () {
   {
    put(101, "Johnny");
    put(102, "Root");
    put(103, "Shane");
   }
  };
  System.out.println(idToName);
  
  // checking if a key exists in Map
  Scanner scnr = new Scanner(System.in);
  System.out.println("Please enter a key to check in Map?");
  int key = scnr.nextInt();
  
  // checking if key exists in HashMap
  if (idToName.containsKey(key)) {
   System.out.println("Congrats, given key exits in Map");
  } else {
   System.out.println("Sorry, given key doesn't exists in Map");
  }
  scnr.close();
 }
}