class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
        // Creating first set 
        Set<Integer> 
            set1 = Sets.newHashSet(10, 20, 30, 40, 50); 
  
        // Creating second set 
        Set<Integer> 
            set2 = Sets.newHashSet(30, 50, 70, 90); 
  
        // Using Guava's Sets.intersection() method 
        Set<Integer> 
            answer = Sets.intersection(set1, set2); 
  
        // Displaying the intersection of set1 and set2 
        System.out.println("Set 1: "
                           + set1); 
        System.out.println("Set 2: "
                           + set2); 
        System.out.println("Set 1 intersection Set 2: "
                           + answer); 
    } 
}