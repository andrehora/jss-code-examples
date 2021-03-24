public class ArrayListDemo {
   public static void main(String[] args) {
      
      // create an empty arraylist with an initial capacity
      ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

      // use add() method to add elements in the list
      arrlist.add(15);
      arrlist.add(20);
      arrlist.add(25);
      arrlist.add(22);

      // let us print all the elements available in list
      for (Integer number : arrlist) {
         System.out.println("Number = " + number);
      }

      // this will print the size of this list
      int retval = arrlist.size();
      System.out.println("Size of list = " + retval); 
   }
}