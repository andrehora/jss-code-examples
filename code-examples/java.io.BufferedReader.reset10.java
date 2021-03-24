static JBigInt parseNumber(BufferedReader reader) throws IOException {
    skipSpace(reader);
    StringBuilder sb = new StringBuilder();
    while (true) {
    	reader.mark(1);
        int c = reader.read();
        if (c >= '0' && c <= '9' || c == '.' || c == '-') {
            sb.append((char)c);
        } else {
        	reader.reset();
            break;
        }
    }
    return new JBigInt(sb.toString());
}