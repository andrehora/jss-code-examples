public CSVFormat getCSVFormat() {
  return CSVFormat.DEFAULT
    .withDelimiter(delimiter)
    .withRecordSeparator(recordSeparator)
    .withNullString(nullString)
    .withEscape(escapeCharacter)
    .withQuote(quoteCharacter)
    .withQuoteMode(quoteMode);
}