public void testContainsAll() {
 ImmutableSortedSet<Integer> set = ContiguousSet.create(Range.closed(1, 3), integers());
 for (Set<Integer> subset : Sets.powerSet(ImmutableSet.of(1, 2, 3))) {
  assertTrue(set.containsAll(subset));
 }
 for (Set<Integer> subset : Sets.powerSet(ImmutableSet.of(1, 2, 3))) {
  assertFalse(set.containsAll(Sets.union(subset, ImmutableSet.of(9))));
 }
 assertFalse(set.containsAll((Collection<?>) ImmutableSet.of("blah")));
}