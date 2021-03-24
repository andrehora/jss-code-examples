public static CsvUnmarshaller create(CSVFormat format, CsvDataFormat dataFormat) {
    // If we want to use maps, thus the header must be either fixed or automatic
    if (dataFormat.isUseMaps() && format.getHeader() == null) {
        format = format.withHeader();
    }
    // If we want to skip the header record it must automatic otherwise it's not working
    if (format.getSkipHeaderRecord() && format.getHeader() == null) {
        format = format.withHeader();
    }

    if (dataFormat.isLazyLoad()) {
        return new StreamCsvUnmarshaller(format, dataFormat);
    }
    return new BulkCsvUnmarshaller(format, dataFormat);
}