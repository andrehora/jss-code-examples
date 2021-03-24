private static void assertWontGrow(
    int size, HashMap<Object, Object> map1, HashMap<Object, Object> map2) throws Exception {
  // Only start measuring table size after the first element inserted, to
  // deal with empty-map optimization.
  map1.put(0, null);

  int initialBuckets = bucketsOf(map1);

  for (int i = 1; i < size; i++) {
    map1.put(i, null);
  }
  assertThat(bucketsOf(map1))
      .named("table size after adding " + size + " elements")
      .isEqualTo(initialBuckets);

  /*
   * Something slightly different happens when the entries are added all at
   * once; make sure that passes too.
   */
  map2.putAll(map1);
  assertThat(bucketsOf(map1))
      .named("table size after adding " + size + " elements")
      .isEqualTo(initialBuckets);
}