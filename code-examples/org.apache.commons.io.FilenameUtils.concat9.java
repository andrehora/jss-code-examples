public String getDownloadUrl(String id) {
    String filename = FilenameUtils.getName(id);
    String path = FilenameUtils.getFullPath(id);
    String escapedFullPath = FilenameUtils.concat(path, UrlEscapers.urlFragmentEscaper().escape(filename));
    return cloudStorage.generateSignedUrl(gcsDefaultBucket, escapedFullPath, DEFAULT_LINK_EXPIRY_DURATION);
}