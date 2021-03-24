public File getChild(File parent, String fileName) {
    if (fileName.startsWith("\\")
        && !fileName.startsWith("\\\\")
        && isFileSystem(parent)) {

        //Path is relative to the root of parent's drive
        String path = parent.getAbsolutePath();
        if (path.length() >= 2
            && path.charAt(1) == ':'
            && Character.isLetter(path.charAt(0))) {

            return createFileObject(path.substring(0, 2) + fileName);
        }
    }
    return super.getChild(parent, fileName);
}