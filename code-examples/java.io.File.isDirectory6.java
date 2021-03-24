public static void moveFileToDirectory(File srcFile, File destDir, boolean createDestDir) throws IOException {
    if (srcFile == null) {
        throw new NullPointerException("Source must not be null");
    }
    if (destDir == null) {
        throw new NullPointerException("Destination directory must not be null");
    }
    if (!destDir.exists() && createDestDir) {
        destDir.mkdirs();
    }
    if (!destDir.exists()) {
        throw new FileNotFoundException("Destination directory '" + destDir +
                "' does not exist [createDestDir=" + createDestDir +"]");
    }
    if (!destDir.isDirectory()) {
        throw new IOException("Destination '" + destDir + "' is not a directory");
    }
    moveFile(srcFile, new File(destDir, srcFile.getName()));
}