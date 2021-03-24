public L getAt(int index) {
  if (size != Integer.MAX_VALUE) {
    Preconditions.checkElementIndex(index, size());
  } // else no check necessary, all index values are valid
  ArrayReference<? extends L> existingRef = locks.get(index);
  L existing = existingRef == null ? null : existingRef.get();
  if (existing != null) {
    return existing;
  }
  L created = supplier.get();
  ArrayReference<L> newRef = new ArrayReference<L>(created, index, queue);
  while (!locks.compareAndSet(index, existingRef, newRef)) {
    // we raced, we need to re-read and try again
    existingRef = locks.get(index);
    existing = existingRef == null ? null : existingRef.get();
    if (existing != null) {
      return existing;
    }
  }
  drainQueue();
  return created;
}