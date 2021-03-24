public static byte[] exportAsCSV(QueryResult result) {
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final CSVPrinter csvPrinter;
    try {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.NON_NUMERIC);
        csvPrinter = new CSVPrinter(new PrintWriter(out), format);
        csvPrinter.printRecord(result.getMetadata().stream().map(SchemaField::getName).collect(Collectors.toList()));
        csvPrinter.printRecords(Iterables.transform(result.getResult(),  input -> Iterables.transform(input,  input1 -> {
            if (input1 instanceof List || input1 instanceof Map) {
                return JsonHelper.encode(input1);
            }
            if (input1 instanceof byte[]) {
                return DatatypeConverter.printBase64Binary((byte[]) input1);
            }
            return input1;
        })));
        csvPrinter.flush();
    } catch (IOException e) {
        throw Throwables.propagate(e);
    }
    return out.toByteArray();
}