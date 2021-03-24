public void givenCSVFile_whenRead_thenContentsAsExpected() throws IOException {
    Reader in = new FileReader("book.csv");
    Iterable<CSVRecord> records = CSVFormat.DEFAULT
      .withHeader(HEADERS)
      .withFirstRecordAsHeader()
      .parse(in);
    for (CSVRecord record : records) {
        String author = record.get("author");
        String title = record.get("title");
        assertEquals(AUTHOR_BOOK_MAP.get(author), title);
    }
}