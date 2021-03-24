public CSVFormat detectCSVFormat(String sampleText, boolean headerRow) throws IOException {
    CSVFormat format = CSVFormat.DEFAULT.withAllowMissingColumnNames();
    try (BufferedReader br = new BufferedReader(new StringReader(sampleText))) {
        List<LineStats> lineStats = generateStats(br);
        Character quote = guessQuote(lineStats);
        Character delim = guessDelimiter(lineStats, sampleText, quote, headerRow);
        if (delim == null) {
            throw new IOException("Unrecognized format");
        }
        format = format.withDelimiter(delim);
        format = format.withQuoteMode(QuoteMode.MINIMAL).withQuote(quote);
    }
    return format;
}