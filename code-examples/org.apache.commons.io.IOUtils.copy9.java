private static void processFolder(final File folder, final ZipOutputStream zipOutputStream, final int prefixLength)
        throws IOException {
    for (final File file : folder.listFiles()) {
        if (file.isFile()) {
            final ZipEntry zipEntry = new ZipEntry(file.getPath().substring(prefixLength));
            zipOutputStream.putNextEntry(zipEntry);
            try (FileInputStream inputStream = new FileInputStream(file)) {
                IOUtils.copy(inputStream, zipOutputStream);
            }
            zipOutputStream.closeEntry();
        } else if (file.isDirectory()) {
            processFolder(file, zipOutputStream, prefixLength);
        }
    }
}