CSVFormat csvFormat = CSVFormat.RFC4180.withDelimiter(delimiter.charAt(0)).withEscape(lineEnding.charAt(0));
if (StringUtils.isNotEmpty(enclosure)) {
	csvFormat = csvFormat.withQuote(enclosure.charAt(0));
} else {
	csvFormat = csvFormat.withQuoteMode(NONE);
}