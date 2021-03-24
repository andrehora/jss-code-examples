public class test {
   public static void main(String[] args) {
      
    // create an empty array list with an initial capacity
    ArrayList<String> color_list = new ArrayList<String>(5);

    // use add() method to add values in the list
    color_list.add("White");
    color_list.add("Black");
    color_list.add("Red");
    color_list.add("White");
	color_list.add("Yellow");
	    
	// Print out the colors in the ArrayList.
    for (int i = 0; i < 5; i++)
      {
         System.out.println(color_list.get(i).toString());
      }
  }
}