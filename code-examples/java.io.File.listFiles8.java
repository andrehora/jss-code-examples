private void run(final String prefix, final MessageDigest messageDigest) throws IOException {
    if (inputs == null) {
        println(prefix, DigestUtils.digest(messageDigest, System.in));
        return;
    }
    for(final String source : inputs) {
        final File file = new File(source);
        if (file.isFile()) {
            println(prefix, DigestUtils.digest(messageDigest, file), source);
        } else if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            if (listFiles != null) {
                run(prefix, messageDigest, listFiles);
            }
        } else {
            // use the default charset for the command-line parameter
            final byte[] bytes = source.getBytes(Charset.defaultCharset());
            println(prefix, DigestUtils.digest(messageDigest, bytes));
        }
    }
}