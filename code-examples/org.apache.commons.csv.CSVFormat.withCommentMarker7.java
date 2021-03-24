private static CSVFormat getCSVStrategyFromConfiguration() {
  char fieldDelimiter = getCharValueFromConfiguration(
      "any23.extraction.csv.field",
      DEFAULT_FIELD_DELIMITER
  );
  char commentDelimiter = getCharValueFromConfiguration(
      "any23.extraction.csv.comment",
      DEFAULT_COMMENT_DELIMITER
  );
  return CSVFormat.DEFAULT.withDelimiter(fieldDelimiter).withCommentMarker(commentDelimiter);
}