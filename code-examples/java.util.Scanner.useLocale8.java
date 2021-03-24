public In(File file) {
    if (file == null) throw new NullPointerException("argument is null");
    try {
        // for consistency with StdIn, wrap with BufferedInputStream instead of use
        // file as argument to Scanner
        FileInputStream fis = new FileInputStream(file);
        scanner = new Scanner(new BufferedInputStream(fis), CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }
    catch (IOException ioe) {
        throw new IllegalArgumentException("Could not open " + file);
    }
}