try {
    // write to bw.
    bw.close(); // throw IOException if an error occurs.

} finally {
    // don't clobber a previous IOException
    IOUtils.closeQuietly(bw);
}