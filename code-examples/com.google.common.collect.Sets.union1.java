public void whenCalculatingUnionOfSets_thenCorrect() {
    Set<Character> first = ImmutableSet.of('a', 'b', 'c');
    Set<Character> second = ImmutableSet.of('b', 'c', 'd');
 
    Set<Character> union = Sets.union(first, second);
    assertThat(union, containsInAnyOrder('a', 'b', 'c', 'd'));
}