public List<Object> deserialize(ByteBuffer ser) {
    // If this flag is true, return null.
    if (returnNull) {
        return null;
    }

    // Probably a better way to do this juggling.
    if (ser == null) {
        return null;
    }
    ser.rewind();
    byte[] bytes = new byte[ser.remaining()];
    ser.get(bytes, 0, bytes.length);

    return Lists.newArrayList(new String(bytes, Charsets.UTF_8));
}