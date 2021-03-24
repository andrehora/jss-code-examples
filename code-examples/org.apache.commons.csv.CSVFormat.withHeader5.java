enum BookHeaders {
    author, title
}
Iterable<CSVRecord> records = CSVFormat.DEFAULT
  .withHeader(BookHeaders.class).parse(in);
for (CSVRecord record : records) {
    String author = record.get(BookHeaders.author);
    String title = record.get(BookHeaders.title);
}