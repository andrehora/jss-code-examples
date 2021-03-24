private void createInputTestFiles(List<File> spoolDirs, int numFiles, int startNum)
    throws IOException {
  int numSpoolDirs = spoolDirs.size();
  for (int dirNum = 0; dirNum < numSpoolDirs; dirNum++) {
    File spoolDir = spoolDirs.get(dirNum);
    for (int fileNum = startNum; fileNum < numFiles; fileNum++) {
      // Stage the files on what is almost certainly the same FS partition.
      File tmp = new File(spoolDir.getParent(), UUID.randomUUID().toString());
      Files.append(getTestString(dirNum, fileNum), tmp, Charsets.UTF_8);
      File dst = new File(spoolDir, String.format("test-file-%03d", fileNum));
      // Ensure we move them into the spool directory atomically, if possible.
      assertTrue(String.format("Failed to rename %s to %s", tmp, dst),
          tmp.renameTo(dst));
    }
  }
}