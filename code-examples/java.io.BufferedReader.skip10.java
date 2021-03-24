private void commonInit(Path filePath, Configuration conf) throws IOException {
  readerPosition = start;
  FileSystem fs = filePath.getFileSystem(conf);
  inputReader = new BufferedReader(new InputStreamReader(fs.open(filePath)));
  if (start != 0) {
    // split starts inside the json
    inputReader.skip(start);
    moveToRecordStart();
  }
}