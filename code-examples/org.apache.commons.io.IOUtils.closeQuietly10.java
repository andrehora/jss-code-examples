public synchronized void releaseBuffer(ByteBuffer buffer) {
  if (buffer == EMPTY_BUFFER) return;
  Object val = getExtendedReadBuffers().remove(buffer);
  if (val == null) {
    throw new IllegalArgumentException("tried to release a buffer " +
        "that was not created by this stream, " + buffer);
  }
  if (val instanceof ClientMmap) {
    IOUtils.closeQuietly((ClientMmap)val);
  } else if (val instanceof ByteBufferPool) {
    ((ByteBufferPool)val).putBuffer(buffer);
  }
}