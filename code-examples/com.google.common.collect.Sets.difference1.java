class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
  
        // Creating first set named set1 
        Set<String> 
            set1 = Sets 
                       .newHashSet("H", "E", "L", "L", "O", "G"); 
  
        // Creating second set named set2 
        Set<String> 
            set2 = Sets 
                       .newHashSet("L", "I", "K", "E", "G"); 
  
        // Using Guava's Sets.difference() method 
        Set<String> 
            diff = Sets.difference(set1, set2); 
  
        // Displaying the unmodifiable view of 
        // the difference of two sets. 
        System.out.println("Set 1: "
                           + set1); 
        System.out.println("Set 2: "
                           + set2); 
        System.out.println("Difference between "
                           + "Set 1 and Set 2: "
                           + diff); 
    } 
}