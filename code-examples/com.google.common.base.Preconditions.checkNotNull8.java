public final byte[] toByteArray(boolean shrink) {
  ByteBuffer buffer = ByteBuffer.allocate(size());
  buffer.order(ByteOrder.LITTLE_ENDIAN);
  buffer.putShort((short) headerSize());
  buffer.putShort((short) flags());
  buffer.putInt(keyIndex());
  if (isComplex()) {
    buffer.putInt(parentEntry());
    buffer.putInt(values().size());
    for (Map.Entry<Integer, ResourceValue> entry : values().entrySet()) {
      buffer.putInt(entry.getKey());
      buffer.put(entry.getValue().toByteArray(shrink));
    }
  } else {
    ResourceValue value = value();
    Preconditions.checkNotNull(value, "A non-complex TypeChunk entry must have a value.");
    buffer.put(value.toByteArray());
  }
  return buffer.array();
}