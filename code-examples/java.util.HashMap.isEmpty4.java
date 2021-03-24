public class HashMapEmptyExample {
    public static void main(String args[]) {
        
    // Creating a HashMap of int keys and String values
    HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
 
    // Checking whether HashMap is empty or not
    /* isEmpty() method signature and description -
     * public boolean isEmpty(): Returns true if this map 
     * contains no key-value mappings.
     */
    System.out.println("Is HashMap Empty? "+hashmap.isEmpty());
    
    
    // Adding Key and Value pairs to HashMap
    hashmap.put(11,"Apple");
    hashmap.put(22,"Banana");
    hashmap.put(33,"Mango");
    hashmap.put(44,"Pear");
    hashmap.put(55,"PineApple");
     // Checking again whether HashMap is Empty or not
    System.out.println("Is HashMap Empty? "+hashmap.isEmpty());
 
    }
}