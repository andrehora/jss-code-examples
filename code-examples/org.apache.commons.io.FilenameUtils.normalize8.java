private static File normalize(File file) {
    String path = file.getAbsolutePath();
    return new File(FilenameUtils.normalize(path));
}