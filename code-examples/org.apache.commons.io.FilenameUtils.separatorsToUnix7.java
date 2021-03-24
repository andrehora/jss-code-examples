private JarEntry createJarEntry(Path source) throws IOException {
    String entryName = FilenameUtils.separatorsToUnix(mtaAssemblyDir.relativize(source).toString());
    if (Files.isDirectory(source) && !entryName.endsWith(Constants.UNIX_PATH_SEPARATOR)) {
        entryName += Constants.UNIX_PATH_SEPARATOR;
    }

    JarEntry entry = new JarEntry(entryName);
    entry.setTime(Files.getLastModifiedTime(source).toMillis());
    return entry;
}