public static File createTempDir() {
    File tempDir = Files.createTempDir();
    tempDir.deleteOnExit();
    return tempDir;
}