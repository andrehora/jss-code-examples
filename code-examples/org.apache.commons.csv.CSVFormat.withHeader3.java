public void createCSVFile() throws IOException {
    FileWriter out = new FileWriter("book_new.csv");
    try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
      .withHeader(HEADERS))) {
        AUTHOR_BOOK_MAP.forEach((author, title) -> {
            printer.printRecord(author, title);
        });
    }
}