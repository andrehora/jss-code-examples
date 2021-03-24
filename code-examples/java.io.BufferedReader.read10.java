private String consumeResponse(InputStream inputStr, Charset encoding) {
  StringBuilder body = new StringBuilder();
  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStr, encoding));
  try {
    int i;
    char[] cbuf = new char[BUFFER_SIZE];
    while ((i = reader.read(cbuf)) > 0) {
      if (body == null) {
        continue;
      }
      if (body.length() + i >= MAX_RESP_LENGTH) {
        body = null;
      } else {
        body.append(cbuf, 0, i);
      }
    }
  } catch (IOException e) {
    LOGGER.error("Error reading response", e);
  }
  return body == null ? "Response too long" : body.toString();
}