public static McTemplate get(String fileName) throws IllegalAccessException, IOException {
    File templateFile = FileUtils.getFile(AppProperties.getInstance().getTemplatesLocation() + fileName);
    return McTemplate.builder().extension(FilenameUtils.getExtension(templateFile.getCanonicalPath())).canonicalPath(templateFile.getCanonicalPath()).name(templateFile.getCanonicalPath()).lastModified(templateFile.lastModified()).size(templateFile.length()).build();
}