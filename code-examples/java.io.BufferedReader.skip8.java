private TextFileReader(FileSystem fs, Path file, Map<String, Object> conf, TextFileReader.Offset startOffset)
  throws IOException {
  super(fs, file);
  offset = startOffset;
  FSDataInputStream in = fs.open(file);
  String charSet = (conf == null || !conf.containsKey(CHARSET)) ? "UTF-8" : conf.get(CHARSET).toString();
  int buffSz =
    (conf == null || !conf.containsKey(BUFFER_SIZE)) ? DEFAULT_BUFF_SIZE : Integer.parseInt(conf.get(BUFFER_SIZE).toString());
  reader = new BufferedReader(new InputStreamReader(in, charSet), buffSz);
  if (offset.charOffset > 0) {
    reader.skip(offset.charOffset);
  }
}