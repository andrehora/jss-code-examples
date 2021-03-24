public static void corruptFile(File file,
    byte[] stringToCorrupt,
    byte[] replacement) throws IOException {
  Preconditions.checkArgument(replacement.length == stringToCorrupt.length);
  if (!file.isFile()) {
    throw new IllegalArgumentException(
        "Given argument is not a file:" + file);
  }
  byte[] data = Files.toByteArray(file);
  int index = Bytes.indexOf(data, stringToCorrupt);
  if (index == -1) {
    throw new IOException(
        "File " + file + " does not contain string " +
        new String(stringToCorrupt));
  }

  for (int i = 0; i < stringToCorrupt.length; i++) {
    data[index + i] = replacement[i];
  }
  Files.write(data, file);
}