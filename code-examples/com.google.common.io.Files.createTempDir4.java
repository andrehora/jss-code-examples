class M {
    void foo(java.net.URL url, Charset charset, java.io.OutputStream stream, String resourceName, Class<?> contextClass,
            LineProcessor<Object> callback, int fileThreshold, boolean resetOnFinalize) throws Exception {

        Files.createTempDir(); // Questionable
        Files.fileTreeTraverser(); // Questionable (removed from public API in Guava 25.0)
        Files.fileTraverser(); // Questionable
        MoreFiles.directoryTreeTraverser(); // Questionable (removed from public API in Guava 25.0)
        MoreFiles.fileTraverser(); // Questionable
        Resources.asByteSource(url); // Questionable
        Resources.asCharSource(url, charset); // Questionable
        Resources.copy(url, stream); // Questionable
        Resources.getResource(contextClass, resourceName); // Questionable
        Resources.getResource(resourceName); // Questionable
        Resources.readLines(url, charset); // Questionable
        Resources.readLines(url, charset, callback); // Questionable
        Resources.toByteArray(url); // Questionable
        Resources.toString(url, charset); // Questionable

        // these OutputStreams creates files
        new FileBackedOutputStream(fileThreshold); // Questionable
        new FileBackedOutputStream(fileThreshold, resetOnFinalize); // Questionable
    }
}