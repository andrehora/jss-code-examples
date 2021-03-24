protected void copyStreamToJar(InputStream zin, ZipOutputStream out, String currentName, long fileTime) throws IOException {
    // Create new entry for zip file.

    ZipEntry newEntry = new ZipEntry(currentName);
    // Make sure there is date and time set.
    if (fileTime != -1) {
        newEntry.setTime(fileTime); // If found set it into output file.
    }
    out.putNextEntry(newEntry);
    if (zin != null) {
        IOUtils.copy(zin, out);
    }
    IOUtils.closeQuietly(zin);

}