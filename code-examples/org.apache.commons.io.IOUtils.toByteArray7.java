public synchronized byte[] getFlowContent(final String bucketId, final String flowId, final int version) throws FlowPersistenceException {
    final File snapshotFile = getSnapshotFile(bucketId, flowId, version);
    if (LOGGER.isDebugEnabled()) {
        LOGGER.debug("Retrieving snapshot with filename {}", new Object[] {snapshotFile.getAbsolutePath()});
    }

    if (!snapshotFile.exists()) {
        return null;
    }

    try (final InputStream in = new FileInputStream(snapshotFile)){
        return IOUtils.toByteArray(in);
    } catch (IOException e) {
        throw new FlowPersistenceException("Error reading snapshot file: " + snapshotFile.getAbsolutePath(), e);
    }
}