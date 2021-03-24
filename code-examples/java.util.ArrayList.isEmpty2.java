public class ArrayListDemo {
   public static void main(String[] args) {
      
      // create an empty array deque with an initial capacity
      ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

      // use add() method to add elements in the deque
      arrlist.add(25);
      arrlist.add(10);
      arrlist.add(20);
      arrlist.add(35);        
              
      boolean retval = arrlist.isEmpty();
      if (retval == true) {
         System.out.println("list is empty");
      } else {
         System.out.println("list is not empty");
      }
         
      // printing all the elements available in list
      for (Integer number : arrlist) {
         System.out.println("Number = " + number);
      }
   }
}