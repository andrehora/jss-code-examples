public class Hash_Map_Demo { 
    public static void main(String[] args) 
    { 
  
        // Creating an empty HashMap 
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>(); 
  
        // Mapping int values to string keys 
        hash_map.put("Geeks", 10); 
        hash_map.put("4", 15); 
        hash_map.put("Geeks", 20); 
        hash_map.put("Welcomes", 25); 
        hash_map.put("You", 30); 
  
        // Displaying the HashMap 
        System.out.println("The Mappings are: " + hash_map); 
  
        // Checking for the emptiness of Map 
        System.out.println("Is the map empty? " + hash_map.isEmpty()); 
    } 
}