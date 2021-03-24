class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
  
        // Creating 2 Integer arrays 
        int[] arr1 = { 1, 2, 3, 4, 5 }; 
        int[] arr2 = { 6, 2, 7, 0, 8 }; 
  
        // Using Ints.concat() method to combine 
        // elements from both arrays into a single array 
        int[] res = Ints.concat(arr1, arr2); 
  
        // Displaying the single combined array 
        System.out.println("Combined Array: "
                           + Arrays.toString(res)); 
    } 
}