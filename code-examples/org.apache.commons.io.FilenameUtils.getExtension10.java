public boolean accept(File file) {
    if (file.isDirectory()) {
        return true;
    }
    String extension = FilenameUtils.getExtension(file.getName());
    if (!extension.isEmpty()) {
        for (FileType ft : fileType) {
            if (ft.contains(extension))
                return true;
        }
    }
    return false;
}