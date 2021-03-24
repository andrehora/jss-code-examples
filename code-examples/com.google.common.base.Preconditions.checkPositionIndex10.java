int getEntryAt(int pos) {
  Preconditions.checkPositionIndex(pos, entries.length,
      "Invalid position for AclEntry");
  return entries[pos];
}