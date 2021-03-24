private Iterable<List<Object>> buildCartesianProduct(Set<?>... sets) {
  List<Set<Optional<?>>> optionalSets = Lists.newArrayListWithExpectedSize(sets.length);
  for (Set<?> set : sets) {
    Set<Optional<?>> optionalSet =
        Sets.newLinkedHashSet(Iterables.transform(set, NULLABLE_TO_OPTIONAL));
    optionalSets.add(optionalSet);
  }
  Set<List<Optional<?>>> cartesianProduct = Sets.cartesianProduct(optionalSets);
  return Iterables.transform(cartesianProduct,
      new Function<List<Optional<?>>, List<Object>>() {
        @Override public List<Object> apply(List<Optional<?>> objs) {
          return Lists.transform(objs, OPTIONAL_TO_NULLABLE);
        }
      });
}