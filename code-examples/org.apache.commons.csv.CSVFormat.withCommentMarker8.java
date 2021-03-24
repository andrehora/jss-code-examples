public CSVEncoder() {
  final char escapeCharacter = '\\';
  final char quoteCharacter = '"';
  final char columnSeparator = ';';
  final String lineEnding = System.getProperty("line.separator");
  csvFormat = CSVFormat.newFormat(columnSeparator).withCommentMarker('#').withQuote(quoteCharacter).withEscape(escapeCharacter)
      .withRecordSeparator(lineEnding);
}