public static boolean isAdoc(String filename) {
    return FilenameUtils.isExtension(filename, new String[]{Format.adoc.name(), Format.asciidoc.name()});
}