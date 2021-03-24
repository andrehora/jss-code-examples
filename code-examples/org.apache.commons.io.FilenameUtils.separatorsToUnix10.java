private String getPathName(Path parentFolder, Path fileToAppend) {
    Path relativePath = parentFolder.relativize(fileToAppend);
    return FilenameUtils.separatorsToUnix(relativePath.toString());
}