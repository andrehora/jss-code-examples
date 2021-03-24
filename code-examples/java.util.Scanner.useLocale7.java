public In(URL url) {
    if (url == null) throw new NullPointerException("argument is null");
    try {
        URLConnection site = url.openConnection();
        InputStream is     = site.getInputStream();
        scanner            = new Scanner(new BufferedInputStream(is), CHARSET_NAME);
        scanner.useLocale(LOCALE);
    }
    catch (IOException ioe) {
        throw new IllegalArgumentException("Could not open " + url);
    }
}