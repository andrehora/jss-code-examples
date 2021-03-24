private void writeBody(final BufferedReader bufferedReader) throws IOException {
    char[] buffer = new char[BUFFER_LENGTH];
    StringBuilder inputStringBuilder = new StringBuilder("Response Body : ");
    bufferedReader.mark(MARK_LENGTH);
    int len = bufferedReader.read(buffer);
    String line = new String(buffer);
    int curLen = 0;
    while (!StringUtils.isEmpty(line) && curLen > -1 && len < MARK_LENGTH) {
        inputStringBuilder.append(line);
        curLen = bufferedReader.read(buffer);
        len += curLen;
        line = new String(buffer);
    }
    if (len == MARK_LENGTH) {
        inputStringBuilder.append("...");
    }
    bufferedReader.reset();
    log(inputStringBuilder.toString());
}