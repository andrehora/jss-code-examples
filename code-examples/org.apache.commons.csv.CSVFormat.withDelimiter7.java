public DataGenerator getGenerator(OutputStream os) throws IOException {
    CSVFormat csvFormat = getSettings().getMode(CsvMode.class).getFormat();
    if (getSettings().getMode(CsvMode.class) == CsvMode.CUSTOM) {
        csvFormat = CSVFormat.DEFAULT.withDelimiter((char) getSettings().getConfig(DelimitedDataConstants.DELIMITER_CONFIG)).withEscape((char) getSettings().getConfig(DelimitedDataConstants.ESCAPE_CONFIG)).withQuote((char) getSettings().getConfig(DelimitedDataConstants.QUOTE_CONFIG));
    }
    return new DelimitedCharDataGenerator(createWriter(os), csvFormat, header, headerKey, valueKey, replaceNewLines ? replaceNewLinesString : null);
}