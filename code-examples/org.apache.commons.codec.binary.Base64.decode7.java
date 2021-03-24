private static void decodeWritable(Writable obj, 
                                   String newValue) throws IOException {
  Base64 decoder = new Base64(0, null, true);
  DataInputBuffer buf = new DataInputBuffer();
  byte[] decoded = decoder.decode(newValue);
  buf.reset(decoded, decoded.length);
  obj.readFields(buf);
}