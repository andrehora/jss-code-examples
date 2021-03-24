private DataParser createParser(String id, OverrunReader reader, long offset) throws DataParserException {
	Utils.checkState(reader.getPos() == 0, Utils.formatL("reader must be in position '0', it is at '{}'", reader.getPos()));
	CSVFormat csvFormat = getSettings().getMode(CsvMode.class).getFormat();
	if (getSettings().getMode(CsvMode.class) == CsvMode.CUSTOM) {
		csvFormat = CSVFormat.DEFAULT.withDelimiter((char) getSettings().getConfig(DelimitedDataConstants.DELIMITER_CONFIG)).withEscape((char) getSettings().getConfig(DelimitedDataConstants.ESCAPE_CONFIG)).withQuote((char) getSettings().getConfig(DelimitedDataConstants.QUOTE_CONFIG));
	}
	try {
		return new DelimitedCharDataParser(getSettings().getContext(), id, reader, offset, (Integer) getSettings().getConfig(DelimitedDataConstants.SKIP_START_LINES), csvFormat, getSettings().getMode(CsvHeader.class), getSettings().getMaxRecordLen(), getSettings().getMode(CsvRecordType.class));
	} catch (IOException ex) {
		throw new DataParserException(Errors.DELIMITED_PARSER_00, id, offset, ex.toString(), ex);
	}
}