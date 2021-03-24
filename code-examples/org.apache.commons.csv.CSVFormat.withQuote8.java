public CSVFormat build() {
    CSVFormat format = newFormat(delimiter = initDelimiter());
    format = format.withEscape(escape = initEscape());
    format = format.withCommentMarker(commentMarker = initCommentMarker());
    format = format.withRecordSeparator(lineSeparator = initLineSeparator());
    quote = initQuote();
    quoting = initQuoting();
    if (quoting) {
        format = format.withQuoteMode(QuoteMode.MINIMAL);
        format = format.withQuote(quote);
    }
    return format;
}