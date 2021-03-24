public static void parse (
        final List <NameValuePair> parameters,
        final Scanner scanner,
        final String charset) {
    scanner.useDelimiter(PARAMETER_SEPARATOR);
    while (scanner.hasNext()) {
        String name = null;
        String value = null;
        String token = scanner.next();
        int i = token.indexOf(NAME_VALUE_SEPARATOR);
        if (i != -1) {
            name = decodeFormFields(token.substring(0, i).trim(), charset);
            value = decodeFormFields(token.substring(i + 1).trim(), charset);
        } else {
            name = decodeFormFields(token.trim(), charset);
        }
        parameters.add(new BasicNameValuePair(name, value));
    }
}