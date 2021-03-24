Iterable<CSVRecord> records = CSVFormat.DEFAULT
  .withHeader("author", "title").parse(in);
for (CSVRecord record : records) {
    String author = record.get("author");
    String title = record.get("title");
}