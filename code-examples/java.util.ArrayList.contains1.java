public class ArrayListDemo {
   public static void main(String[] args) {
      
      // create an empty array list with an initial capacity
      ArrayList<Integer> arrlist = new ArrayList<Integer>(8);

      // use add() method to add elements in the list
      arrlist.add(20);
      arrlist.add(25);
      arrlist.add(10);
      arrlist.add(15);        
          
      // let us print all the elements available in list
      for (Integer number : arrlist) {
         System.out.println("Number = " + number);
      }

      // list contains element 10
      boolean retval = arrlist.contains(10); 
        
      if (retval == true) {
         System.out.println("element 10 is contained in the list");
      } else {
         System.out.println("element 10 is not contained in the list");
      }
         
      // list does not contain element 30
      boolean retval2 = arrlist.contains(30);
        
      if (retval2 == true) {
         System.out.println("element 30 is contained in the list");
      } else {
         System.out.println("element 30 is not contained in the list");    
      }
   }
}