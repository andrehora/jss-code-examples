public class HashMapDemo {
   public static void main(String args[]) {
      
      // create hash map
      HashMap newmap = new HashMap();

      // populate hash map
      newmap.put(1, "tutorials");
      newmap.put(2, "point");
      newmap.put(3, "is best"); 

      // check existence of key 2
      System.out.println("Check if key 2 exists: " + newmap.containsKey(2));
   }    
}