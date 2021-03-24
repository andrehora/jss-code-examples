class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
        // Creating first set 
        Set<String> 
            set1 = Sets.newHashSet("G", "e", "e", "k", "s"); 
  
        // Creating second set 
        Set<String> 
            set2 = Sets.newHashSet("g", "f", "G", "e"); 
  
        // Using Guava's Sets.union() method 
        Set<String> 
            answer = Sets.union(set1, set2); 
  
        // Displaying the union of set set1 and set2 
        System.out.println("Set 1: "
                           + set1); 
        System.out.println("Set 2: "
                           + set2); 
        System.out.println("Set 1 union Set 2: "
                           + answer); 
    } 
}