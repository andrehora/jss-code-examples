public static String getRelativePath(String targetPath, String basePath, String pathSeparator) {
        File baseFile = new File(basePath);
        if (baseFile.isFile() || !baseFile.exists() && !basePath.endsWith("/") && !basePath.endsWith("\\"))
            basePath = baseFile.getParent();

        String target = separatorsToUnix(normalizeNoEndSeparator(targetPath));
        String base = separatorsToUnix(normalizeNoEndSeparator(basePath));

        String commonPrefix = getCommonPrefix(target, base);
        if (isBlank(commonPrefix))
            return targetPath.replaceAll("/", pathSeparator);

        target = target.replaceFirst(commonPrefix, "");
        base = base.replaceFirst(commonPrefix, "");

        List<String> result = new ArrayList<>();
        if (isNotEmpty(base))
            result.addAll(nCopies(base.split("/").length, ".."));
        result.addAll(asList(target.replaceFirst("^/", "").split("/")));

        return join(result, pathSeparator);
}