private void processSubFiles(File file, ProcessSubAIDLFileCallback callback) {
    if (file == null) {
        return;
    }
    if (file.isDirectory()) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                processSubFiles(f, callback);
            }
        }
    } else {
        if (callback.matchFile(file)) {
            callback.processFile(file);
        }
    }
}