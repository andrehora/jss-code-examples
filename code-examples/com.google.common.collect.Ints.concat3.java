public void join_two_primitive_arrays_in_java_with_guava () {

    int[] allStateCapitalsByIndex = Ints.concat(firstHalfStateCapitalByIndex, secondHalfStateCapitalByIndex);

    Arrays.toString(allStateCapitalsByIndex);
    assertEquals(50, allStateCapitalsByIndex.length);
}