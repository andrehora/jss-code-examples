public class Main {
   public static void main(String args[]) {
      HashMap<Integer, String> newmap = new HashMap<Integer, String>();      
      
      // populate hash map
      newmap.put(1, "tutorials");
      newmap.put(2, "from");
      newmap.put(3, "java2s.com");
      
      // check existence of value 'point'
      System.out.println("Check if value 'point' exists: " + 
      newmap.containsValue("point"));
   }    
}