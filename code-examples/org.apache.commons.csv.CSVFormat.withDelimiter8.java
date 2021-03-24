private CSVFormat getFormat() {
    CSVFormat format = getFormatFromConfig().withDelimiter(getDelimiterFromConfig());
    String[] header = getHeaderFromConfig();
    if (header != null) {
        format = format.withHeader(header);
    } else {
        format = format.withHeader();
    }
    return format;
}