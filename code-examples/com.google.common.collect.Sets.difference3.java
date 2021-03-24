public class SetsDifferenceTest {

  public static void main(String[] args) {
    ImmutableSet<String> stringSet = ImmutableSet.of("ONE", "TWO", "THREE");
    System.out.println(stringSet);
    
    ImmutableSet<String> stringSet2 = ImmutableSet.of("TWO", "THREE", "FOUR");
    System.out.println(stringSet2);
    
    //Returns a set containing all elements that are contained by set1 and
    //not contained by set2
    Set<String> resultSet = Sets.difference(stringSet, stringSet2);
    System.out.println(resultSet);
  }

}