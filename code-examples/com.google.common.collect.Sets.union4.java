public class SetsUnionTest {
  public static void main(String[] args) {
    ImmutableSet<String> stringSet = ImmutableSet.of("ONE", "TWO", "THREE");
    System.out.println(stringSet);
    
    ImmutableSet<String> stringSet2 = ImmutableSet.of("TWO", "THREE", "FOUR");
    System.out.println(stringSet2);
    
    Set<String> resultSet = Sets.union(stringSet, stringSet2);
    System.out.println(resultSet);
  }

}