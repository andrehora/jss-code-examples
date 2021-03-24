public static String getRuleSetClasspath(RuleSet ruleset) {
  final String RESOURCES_PATH = "/resources/";
  String filename = FilenameUtils.normalize(StringUtils.chomp(ruleset.getFileName()), true);
  int startIndex = filename.lastIndexOf(RESOURCES_PATH);
  if (startIndex > -1) {
    return filename.substring(startIndex + RESOURCES_PATH.length());
  } else {
    return filename;
  }
}