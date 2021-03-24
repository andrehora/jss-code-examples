Reader in = new FileReader("path/to/file.csv");
Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
for (CSVRecord record : records) {
    String columnOne = record.get(0);
    String columnTwo = record.get(1);
}