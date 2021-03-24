protected void processLine(String line) {
    if (!line.contains("=") || line.isEmpty()) {
        return;
    }
    //use a second Scanner to parse the content of each line
    Scanner lineScanner = new Scanner(line);
    lineScanner.useDelimiter("=");
    if (lineScanner.hasNext()) {
        String key = lineScanner.next();
        String value = "";
        if (lineScanner.hasNext()) {
            value = lineScanner.next();
        }
        map.put(key, value);
    }
    //no need to call lineScanner.close(), since the source is a String
}