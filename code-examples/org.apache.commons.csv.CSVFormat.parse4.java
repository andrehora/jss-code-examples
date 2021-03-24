Reader in = new FileReader("path/to/file.csv");
Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
for (CSVRecord record : records) {
    String id = record.get("ID");
    String customerNo = record.get("CustomerNo");
    String name = record.get("Name");
}