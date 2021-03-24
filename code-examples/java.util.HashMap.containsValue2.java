public class HashMapDemo {
   public static void main(String args[]) {
      
      // create hash map
      HashMap newmap = new HashMap();

      // populate hash map
      newmap.put(1, "tutorials");
      newmap.put(2, "point");
      newmap.put(3, "is best"); 

      // check existence of value 'point'
      System.out.println("Check if value 'point' exists: " + 
      newmap.containsValue("point"));
   }    
}