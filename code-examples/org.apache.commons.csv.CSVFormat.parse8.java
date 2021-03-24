public List<String> getDataColumnHeaders(InputStream in) throws IOException, DecodingDataFromAdapterException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, encoding))) {
        CSVFormat csvFormat = CSVFormat.DEFAULT
                .withAllowMissingColumnNames(false)
                .withDelimiter(delimiter);
        Iterable<CSVRecord> records = csvFormat.parse(reader);
        return this.parseColumnHeaders(records.iterator().next());
    }
}