public static File[] listFiles(String antInclude) {
	Objects.requireNonNull(antInclude, "antInclude must not be null");

	String includeNormalized = FilenameUtils.separatorsToUnix(antInclude);
	PathInfo pathInfo = separatePath(includeNormalized);

	return listFiles(new File(pathInfo.getPathToBaseDir()), pathInfo.getPattern());
}