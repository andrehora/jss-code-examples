public static String getReaderString(BufferedReader reader) {
  StringBuffer out = new StringBuffer();
  char[] c = new char[8192];
  try {
    for (int n; (n = reader.read(c, 0, c.length)) != -1;) {
      out.append(c, 0, n);
    }
    reader.close();
  } catch (IOException e) {
    e.printStackTrace();
    return null;
  }
  return out.toString();
}