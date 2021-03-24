class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
        // Creating a List of Integers 
        List<Integer> myList 
            = Arrays.asList(1, 2, 3, 4, 5); 
  
        // Using Lists.reverse() method to get a 
        // reversed view of the specified list. Any 
        // changes in the returned list are reflected 
        // in the original list and vice-versa 
        List<Integer> reverse = Lists.reverse(myList); 
  
        // Displaying the reversed view of specified List 
        System.out.println(reverse); 
    } 
}