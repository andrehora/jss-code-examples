public enum Headers {
    ID, CustomerNo, Name
}
Reader in = new FileReader("path/to/file.csv");
Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader(Headers.class).parse(in);
for (CSVRecord record : records) {
    String id = record.get(Headers.ID);
    String customerNo = record.get(Headers.CustomerNo);
    String name = record.get(Headers.Name);
}