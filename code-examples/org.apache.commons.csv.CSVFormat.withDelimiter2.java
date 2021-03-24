static void processFile(final File file) {
    FileReader filereader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(filereader);
    bufferedReader.readLine();// try-catch omitted
    final CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';');
    CSVParser parser = new CSVParser(bufferedReader, format);
    final List<CSVRecord> records = parser.getRecords();
    //stuff
}