public static Collection<File> listAllFilesWithExt(File file, final String extension) {
    return FileUtils.listFiles(file, new IOFileFilter() {

        @Override
        public boolean accept(File file) {
            return FilenameUtils.isExtension(file.getName(), extension);
        }

        @Override
        public boolean accept(File dir, String name) {
            return FilenameUtils.isExtension(name, extension);
        }
    }, TrueFileFilter.INSTANCE);
}