public Collection<EditLogInputStream> selectInputStreams(
    long fromTxId, long toAtLeastTxId, MetaRecoveryContext recovery,
    boolean inProgressOk) throws IOException {

  List<EditLogInputStream> streams = new ArrayList<EditLogInputStream>();
  synchronized(journalSetLock) {
    Preconditions.checkState(journalSet.isOpen(), "Cannot call " +
        "selectInputStreams() on closed FSEditLog");
    selectInputStreams(streams, fromTxId, inProgressOk);
  }

  try {
    checkForGaps(streams, fromTxId, toAtLeastTxId, inProgressOk);
  } catch (IOException e) {
    if (recovery != null) {
      // If recovery mode is enabled, continue loading even if we know we
      // can't load up to toAtLeastTxId.
      LOG.error(e);
    } else {
      closeAllStreams(streams);
      throw e;
    }
  }
  return streams;
}