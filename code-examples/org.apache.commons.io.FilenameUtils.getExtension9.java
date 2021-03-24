private void generateChannelApk(final File inputFile, final File outputDir, final String channel, final String alias, final Map<String, String> extraInfo) {
    final String channelName = alias == null ? channel : alias;
    final String name = FilenameUtils.getBaseName(inputFile.getName());
    final String extension = FilenameUtils.getExtension(inputFile.getName());
    final String newName = name + "_" + channelName + "." + extension;
    final File channelApk = new File(outputDir, newName);
    try {
        FileUtils.copyFile(inputFile, channelApk);
        ChannelWriter.put(channelApk, channel, extraInfo);
    } catch (IOException | SignatureNotFoundException e) {
        e.printStackTrace();
    }
}