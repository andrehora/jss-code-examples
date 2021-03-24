public void whenReverseList_thenReversed() {
    List<String> names = Lists.newArrayList("John", "Adam", "Jane");
 
    List<String> reversed = Lists.reverse(names);
    assertThat(reversed, contains("Jane", "Adam", "John"));
}