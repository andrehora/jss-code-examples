class GFG { 
  
    // Driver's code 
    public static void main(String[] args) 
    { 
  
        // Creating a List of Integers 
        List<Integer> 
            myList = Arrays.asList(1, 2, 3, 4, 5); 
  
        // Using Ints.toArray() method to convert 
        // a List or Set of Integer to an array 
        // of Int 
        int[] arr = Ints.toArray(myList); 
  
        // Displaying an array containing each 
        // value of collection, 
        // converted to a int value 
        System.out.println("Array from given List: "
                           + Arrays.toString(arr)); 
    } 
}