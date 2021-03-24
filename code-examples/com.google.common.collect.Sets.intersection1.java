public void whenCalculatingSetIntersection_thenCorrect() {
    Set<Character> first = ImmutableSet.of('a', 'b', 'c');
    Set<Character> second = ImmutableSet.of('b', 'c', 'd');
 
    Set<Character> intersection = Sets.intersection(first, second);
    assertThat(intersection, containsInAnyOrder('b', 'c'));
}