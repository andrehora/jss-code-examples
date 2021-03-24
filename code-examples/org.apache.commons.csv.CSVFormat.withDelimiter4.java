private void parse() throws Exception {
  FileReader reader = new FileReader("example.csv");
  reader.readLine(); // Read the first/current line.

  Iterable <CSVRecord> records = CSVFormat.EXCEL.withQuote('"').withDelimiter(';').parse(reader);
  for (CSVRecord csvRecord: records) {
    // do something
  }
}