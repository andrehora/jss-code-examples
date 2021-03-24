public static void mkdirForHyperParameterConfig() {
    final String homeDir = System.getProperty("user.home");
    final String logDir = "hyper" + new LocalDateTime().toString();
    mHyperParameterConfigDirPath = FilenameUtils.concat(homeDir, logDir);
    try {
        FileUtils.forceMkdir(new File(mHyperParameterConfigDirPath));
    } catch (final IOException e) {
        throw new IllegalStateException(e);
    }
}