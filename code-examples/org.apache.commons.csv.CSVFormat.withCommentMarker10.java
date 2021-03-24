CSVFormat getActiveFormat() {
    CSVFormat answer = format;

    if (commentMarkerDisabled) {
        answer = answer.withCommentMarker(null); // null disables the comment marker
    } else if (commentMarker != null) {
        answer = answer.withCommentMarker(commentMarker);
    }

    if (delimiter != null) {
        answer = answer.withDelimiter(delimiter);
    }

    if (escapeDisabled) {
        answer = answer.withEscape(null); // null disables the escape
    } else if (escape != null) {
        answer = answer.withEscape(escape);
    }

    if (headerDisabled) {
        answer = answer.withHeader((String[]) null); // null disables the header
    } else if (header != null) {
        answer = answer.withHeader(header);
    }

    if (allowMissingColumnNames != null) {
        answer = answer.withAllowMissingColumnNames(allowMissingColumnNames);
    }

    if (ignoreEmptyLines != null) {
        answer = answer.withIgnoreEmptyLines(ignoreEmptyLines);
    }

    if (ignoreSurroundingSpaces != null) {
        answer = answer.withIgnoreSurroundingSpaces(ignoreSurroundingSpaces);
    }

    if (nullStringDisabled) {
        answer = answer.withNullString(null); // null disables the null string replacement
    } else if (nullString != null) {
        answer = answer.withNullString(nullString);
    }

    if (quoteDisabled) {
        answer = answer.withQuote(null); // null disables quotes
    } else if (quote != null) {
        answer = answer.withQuote(quote);
    }

    if (quoteMode != null) {
        answer = answer.withQuoteMode(quoteMode);
    }

    if (recordSeparatorDisabled) {
        answer = answer.withRecordSeparator(null); // null disables the record separator
    } else if (recordSeparator != null) {
        answer = answer.withRecordSeparator(recordSeparator);
    }

    if (skipHeaderRecord != null) {
        answer = answer.withSkipHeaderRecord(skipHeaderRecord);
    }

    return answer;
}