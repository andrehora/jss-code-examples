private void tryToDeleteFromFile(final RegionByOffset regionByOffset) throws IOException {
  writeUntilOffsetReached(regionByOffset.getOffset());
  reader.skip(regionByOffset.getLength());
  currentPosition = regionByOffset.getOffsetAfterEnding();
}