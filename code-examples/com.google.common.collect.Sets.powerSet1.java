public void whenCalculatingPowerSet_thenCorrect() {
    Set<Character> chars = ImmutableSet.of('a', 'b');
 
    Set<Set<Character>> result = Sets.powerSet(chars);
 
    Set<Character> empty =  ImmutableSet.<Character> builder().build();
    Set<Character> a = ImmutableSet.of('a');
    Set<Character> b = ImmutableSet.of('b');
    Set<Character> aB = ImmutableSet.of('a', 'b');
 
    assertThat(result, contains(empty, a, b, aB));
}