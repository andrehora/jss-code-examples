void close() {
  String suffix = "";
  
  Preconditions.checkState(refCount == 0,
      "tried to close replica with refCount %d: %s", refCount, this);
  refCount = -1;
  Preconditions.checkState(purged,
      "tried to close unpurged replica %s", this);
  if (hasMmap()) {
    munmap();
    if (LOG.isTraceEnabled()) {
      suffix += "  munmapped.";
    }
  }
  IOUtils.cleanup(LOG, dataStream, metaStream);
  if (slot != null) {
    cache.scheduleSlotReleaser(slot);
    if (LOG.isTraceEnabled()) {
      suffix += "  scheduling " + slot + " for later release.";
    }
  }
  if (LOG.isTraceEnabled()) {
    LOG.trace("closed " + this + suffix);
  }
}