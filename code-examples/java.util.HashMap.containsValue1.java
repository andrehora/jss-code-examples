public class Hash_Map_Demo { 
    public static void main(String[] args) 
    { 
  
        // Creating an empty HashMap 
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>(); 
  
        // Mapping string values to int keys 
        hash_map.put(10, "Geeks"); 
        hash_map.put(15, "4"); 
        hash_map.put(20, "Geeks"); 
        hash_map.put(25, "Welcomes"); 
        hash_map.put(30, "You"); 
  
        // Displaying the HashMap 
        System.out.println("Initial Mappings are: " + hash_map); 
  
        // Checking for the Value 'Geeks' 
        System.out.println("Is the value 'Geeks' present? " +  
        hash_map.containsValue("Geeks")); 
  
        // Checking for the Value 'World' 
        System.out.println("Is the value 'World' present? " +  
        hash_map.containsValue("World")); 
    } 
}