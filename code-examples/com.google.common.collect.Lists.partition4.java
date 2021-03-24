public void givenListPartitioned_whenOriginalListIsModified_thenPartitionsChangeAsWell() {
    // Given
    List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
    List<List<Integer>> subSets = Lists.partition(intList, 3);
 
    // When
    intList.add(9);
 
    // Then
    List<Integer> lastPartition = subSets.get(2);
    List<Integer> expectedLastPartition = Lists.<Integer> newArrayList(7, 8, 9);
    assertThat(lastPartition, equalTo(expectedLastPartition));
}