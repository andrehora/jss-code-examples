static void rollForwardByApplyingLogs(
    RemoteEditLogManifest manifest,
    FSImage dstImage,
    FSNamesystem dstNamesystem) throws IOException {
  NNStorage dstStorage = dstImage.getStorage();

  List<EditLogInputStream> editsStreams = Lists.newArrayList();    
  for (RemoteEditLog log : manifest.getLogs()) {
    if (log.getEndTxId() > dstImage.getLastAppliedTxId()) {
      File f = dstStorage.findFinalizedEditsFile(
          log.getStartTxId(), log.getEndTxId());
      editsStreams.add(new EditLogFileInputStream(f, log.getStartTxId(), 
                                                  log.getEndTxId(), true));
    }
  }
  LOG.info("Checkpointer about to load edits from " +
      editsStreams.size() + " stream(s).");
  dstImage.loadEdits(editsStreams, dstNamesystem);
}