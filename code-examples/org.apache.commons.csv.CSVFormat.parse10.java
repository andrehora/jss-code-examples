private static List<String[]> getRecords(String path) {
    List<String[]> records = new ArrayList<String[]>();
    try {
        Reader reader = new FileReader(BigFileAnalyzerPerformanceTest.class.getResource(path).getPath());
        CSVFormat csvFormat = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader();
        Iterable<CSVRecord> csvRecords = csvFormat.parse(reader);
        for (CSVRecord csvRecord : csvRecords) {
            String[] values = new String[csvRecord.size()];
            for (int i = 0; i < csvRecord.size(); i++) {
                values[i] = csvRecord.get(i);
            }
            records.add(values);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return records;
}