public ImmutableList<Character> subList(int fromIndex, int toIndex) {
 checkPositionIndexes(fromIndex, toIndex, size()); // for GWT
 return charactersOf(string.substring(fromIndex, toIndex));
}