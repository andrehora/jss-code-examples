public void visitStyleSheet(StyleSheetTree tree) {
  List<String> lines;
  try {
    lines = Files.readLines(getContext().getFile(), charset);
  } catch (IOException e) {
    throw new IllegalStateException("Check css:" + this.getClass().getAnnotation(Rule.class).key()
      + ": Error while reading " + getContext().getFile().getName(), e);
  }
  for (String line : lines) {
    if (line.contains("\t")) {
      addFileIssue("Replace all tab characters in this file by sequences of whitespaces.");
      break;
    }
  }
  super.visitStyleSheet(tree);
}