private String readLine(BufferedReader reader) throws IOException {
  resBuffer.setLength(0);
  reader.mark(maxJobDelimiterLineLength);
  for(String line = reader.readLine();
            line != null; line = reader.readLine()) {
    if(isEndOfJobLog(line)) {
      if(resBuffer.length() == 0)
        resBuffer.append(line);
      else
        reader.reset();
      break;
    }
    if(resBuffer.length() == 0)
      resBuffer.append(line);
    else if(resBuffer.length() < 32000)
      resBuffer.append(line);
    if(line.endsWith(" .") || line.endsWith("\" ")) {
      break;
    }
    reader.mark(maxJobDelimiterLineLength);
  }
  String result = resBuffer.length() == 0 ? null : resBuffer.toString();
  resBuffer.setLength(0);
  return result;
}