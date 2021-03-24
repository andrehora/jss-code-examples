class GFG { 
    // Driver method 
    public static void main(String[] args) 
    { 
        int arr[] = { 5, 10, 15, 20, 25 }; 
  
        // Using Ints.asList() method which wraps 
        // the primitive integer array as List of 
        // integer Type 
        List<Integer> myList = Ints.asList(arr); 
  
        // Displaying the elements 
        System.out.println(myList); 
    } 
}