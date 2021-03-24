public String readAllCharsOneByOne(BufferedReader reader) throws IOException {
    StringBuilder content = new StringBuilder();
         
    int value;
    while ((value = reader.read()) != -1) {
        content.append((char) value);
    }
         
    return content.toString();
}