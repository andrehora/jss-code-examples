public class HashMapDemo {
   public static void main(String args[]) {
      
      // create hash map
      HashMap newmap = new HashMap();

      // populate hash map
      newmap.put(1, "tutorials");
      newmap.put(2, "point");
      newmap.put(3, "is best");

      // check if map is empty
      boolean val = newmap.isEmpty();

      // check the boolean value
      System.out.println("Is hash map empty: " + val);
   }    
}