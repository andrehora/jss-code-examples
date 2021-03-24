public void decode(InputStream in, List<String> headers, Consumer<DataSample<T>> mapToResult) throws IOException, DecodingDataFromAdapterException {
    try (Profiler ignored = Profiler.start("Building time series from csv data", logger::trace)) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in, encoding))) {
            CSVFormat csvFormat = CSVFormat.DEFAULT
                    .withAllowMissingColumnNames(false)
                    .withFirstRecordAsHeader()
                    .withSkipHeaderRecord()
                    .withDelimiter(delimiter);
            Iterable<CSVRecord> records = csvFormat.parse(reader);

            for (CSVRecord csvRecord : records) {
                ZonedDateTime timeStamp = dateParser.apply(csvRecord.get(0));
                DataSample<T> tRecord = new DataSample<>(timeStamp);
                for (String h : headers) {
                    tRecord.getCells().put(h, numberParser.apply(csvRecord.get(h)));
                }
                mapToResult.accept(tRecord);
            }
        }
    }
}