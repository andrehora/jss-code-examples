class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
  
        // Creating a set 
        Set<Integer> 
            set = Sets.newHashSet(1, 2, 3); 
  
        // powerSet to store all subsets of a set 
        Set<Set<Integer> > 
            powerSet = Sets.powerSet(set); 
  
        // Displaying all possible subsets of a set 
        for (Set<Integer> s : powerSet) 
            System.out.println(s); 
    } 
}