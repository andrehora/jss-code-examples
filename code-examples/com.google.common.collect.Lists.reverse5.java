class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
        // Creating a List of Characters 
        List<Character> myList 
            = Arrays.asList('H', 'E', 'L', 'L', 'O'); 
  
        // Using Lists.reverse() method to get a 
        // reversed view of the specified list. Any 
        // changes in the returned list are reflected 
        // in the original list and vice-versa 
        List<Character> reverse = Lists.reverse(myList); 
  
        // Displaying the reversed view of specified List 
        System.out.println(reverse); 
    } 
}