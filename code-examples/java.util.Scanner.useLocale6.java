public In(Socket socket) {
    if (socket == null) throw new NullPointerException("argument is null");
    try {
        InputStream is = socket.getInputStream();
        scanner = new Scanner(new BufferedInputStream(is), CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }
    catch (IOException ioe) {
        throw new IllegalArgumentException("Could not open " + socket);
    }
}