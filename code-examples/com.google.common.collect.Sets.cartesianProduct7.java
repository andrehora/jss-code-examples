public void testCartesianProductTooBig() {
 Set<Integer> set = ContiguousSet.create(Range.closed(0, 10000), DiscreteDomain.integers());
 try {
  Sets.cartesianProduct(set, set, set, set, set);
  fail("Expected IAE");
 } catch (IllegalArgumentException expected) {
 }
}