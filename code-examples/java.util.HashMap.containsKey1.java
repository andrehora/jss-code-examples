public class NewClass 
{ 
    public static void main(String args[]) 
    { 
        // 1   Creation of HashMap 
        HashMap<String, String> Geeks = new HashMap<>(); 
  
        // 2   Adding values to HashMap as ("keys", "values") 
        Geeks.put("Language", "Java"); 
        Geeks.put("Platform", "Geeks For geeks"); 
        Geeks.put("Code", "HashMap"); 
        Geeks.put("Learn", "More"); 
  
        // 3  containsKey() method is to check the presence 
        //    of a particluar key 
        // Since 'Code' key present here, the condition is true 
        if (Geeks.containsKey("Code")) 
            System.out.println("Testing .containsKey : " + 
                                           Geeks.get("Code")); 
  
        // 4 keySet() method returns all the keys in HashMap 
        Set<String> Geekskeys = Geeks.keySet(); 
        System.out.println("Initial keys  : " + Geekskeys); 
  
  
        // 5  values() method return all the values in HashMap 
        Collection<String> Geeksvalues = Geeks.values(); 
        System.out.println("Initial values : " + Geeksvalues); 
  
        // Adding new set of key-value 
        Geeks.put("Search", "JavaArticle"); 
  
        // Again using .keySet() and .values() methods 
        System.out.println("New Keys : " + Geekskeys); 
        System.out.println("New Values: " + Geeksvalues); 
    } 
}