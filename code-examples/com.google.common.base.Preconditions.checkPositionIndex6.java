static <T> UnmodifiableListIterator<T> forArray(
    final T[] array, final int offset, int length, int index) {
  checkArgument(length >= 0);
  int end = offset + length;

  // Technically we should give a slightly more descriptive error on overflow
  Preconditions.checkPositionIndexes(offset, end, array.length);
  Preconditions.checkPositionIndex(index, length);
  if (length == 0) {
    return emptyListIterator();
  }
  return new ArrayItr<T>(array, offset, length, index);
}