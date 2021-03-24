public class GFG { 
    public static void main(String[] args) 
    { 
  
        // creating an Empty Integer ArrayList 
        ArrayList<Integer> arr = new ArrayList<Integer>(4); 
  
        // using add() to initialize values 
        // [10, 20, 30, 40] 
        arr.add(10); 
        arr.add(20); 
        arr.add(30); 
        arr.add(40); 
  
        System.out.println("List: " + arr); 
        // element at index 2 
        int element = arr.get(2); 
  
        System.out.println("the element at index 2 is " + element); 
    } 
}