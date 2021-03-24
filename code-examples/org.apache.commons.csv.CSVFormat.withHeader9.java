public static CsvMarshaller create(CSVFormat format, CsvDataFormat dataFormat) {
    // If we don't want the header record, clear it
    if (format.getSkipHeaderRecord()) {
        format = format.withHeader((String[]) null);
    }

    String[] fixedColumns = dataFormat.getHeader();
    if (fixedColumns != null && fixedColumns.length > 0) {
        return new FixedColumnsMarshaller(format, fixedColumns);
    }
    return new DynamicColumnsMarshaller(format);
}