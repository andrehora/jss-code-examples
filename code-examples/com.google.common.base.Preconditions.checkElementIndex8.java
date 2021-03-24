public L getAt(int index) {
  if (size != Integer.MAX_VALUE) {
    Preconditions.checkElementIndex(index, size());
  } // else no check necessary, all index values are valid
  L existing = locks.get(index);
  if (existing != null) {
    return existing;
  }
  L created = supplier.get();
  existing = locks.putIfAbsent(index, created);
  return MoreObjects.firstNonNull(existing, created);
}