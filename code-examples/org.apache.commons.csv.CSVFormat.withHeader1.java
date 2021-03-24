final URL url = ...;
final Reader reader = new InputStreamReader(new BOMInputStream(url.openStream()), "UTF-8");
final CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
try {
    for (final CSVRecord record : parser) {
        final String string = record.get("SomeColumn");
        ...
    }
} finally {
    parser.close();
    reader.close();
}