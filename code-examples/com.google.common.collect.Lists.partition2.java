class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
        // Creating a List of Integers  
        List<Integer> myList 
            = Arrays.asList(1, 2, 3, 4, 5); 
  
        // Using Lists.partition() method to divide 
        // the original list into sublists of the same 
        // size, which are just views of the original list. 
        // The final list may be smaller. 
        List<List<Integer> > lists 
            = Lists.partition(myList, 2); 
  
        // Displaying the sublists 
        for (List<Integer> sublist: lists) 
            System.out.println(sublist); 
    } 
}