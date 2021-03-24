public class ArrayListEgTwo
{

  public static void main ( String[] args)
  {
    // Create an ArrayList that holds references to String
    ArrayList<String> names = new ArrayList<String>();

    // Capacity starts at 10, but size starts at 0
    System.out.println("initial size: " + names.size() );

    // Add three String references
    names.add("Amy");
    names.add("Bob");
    names.add("Cindy");
    System.out.println("new size: " + names.size() );
       
    // Access and print out the Objects
    for ( int j=0; j<names.size(); j++ )
      System.out.println("element " + j + ": " + names.get(j) );
  }
}