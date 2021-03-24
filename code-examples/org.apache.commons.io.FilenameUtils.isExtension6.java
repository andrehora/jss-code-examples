private void copyValidClasspathEntries(Collection<URL> source, Set<URL> destination) {
    String fileName;
    boolean isJarFile;
    boolean isDirectory;

    for (URL url : source) {
        if(destination.contains(url)) {
            continue;
        }

        fileName = url.getFile();
        isJarFile = FilenameUtils.isExtension(fileName, "jar");
        isDirectory = new File(fileName).isDirectory();

        if (isJarFile || isDirectory) {
            destination.add(url);
        } else if (logger.isDebugEnabled()) {
            logger.debug("Ignored classpath entry: " + fileName);
        }
    }
}