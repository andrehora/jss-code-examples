private void ensureFileInContentStore(File file)
{
    String fileNormalizedAbsoultePath = FilenameUtils.normalize(file.getAbsolutePath());
    String rootNormalizedAbsolutePath = FilenameUtils.normalize(rootAbsolutePath);
    
    if (!fileNormalizedAbsoultePath.startsWith(rootNormalizedAbsolutePath))
    {
        throw new ContentIOException("Access to files outside of content store root is not allowed: " + file);
    }
}