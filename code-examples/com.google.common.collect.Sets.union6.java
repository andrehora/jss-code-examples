public ViewChanges droppingAlso(Collection<View> extraViewsToDrop) {
  Set<String> extraViewNames = ImmutableSet.copyOf(Collections2.transform(extraViewsToDrop, viewToName()));

  // -- In case we have any new obsolete views in here, we need to make sure they're in the index...
  //
  Map<String, View> newIndex = new HashMap<>();
  newIndex.putAll(uniqueIndex(extraViewsToDrop, viewToName()));
  newIndex.putAll(viewIndex);

  return new ViewChanges(allViews,
    Sets.union(dropSet, extraViewNames),
    Sets.union(deploySet, Sets.intersection(extraViewNames, knownSet)),
    newIndex);
}