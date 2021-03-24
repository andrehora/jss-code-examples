public DataSet(final Reader reader, final CSVFormat input_format) {

    this();

    try (CSVParser parser = new CSVParser(reader, input_format.withHeader())) {

        labels.addAll(getColumnLabels(parser));

        for (final CSVRecord record : parser) {

            final List<String> items = csvRecordToList(record);
            final int size = items.size();

            // Don't add row if the line was empty.
            if (size > 1 || (size == 1 && items.get(0).length() > 0)) {
                records.add(items);
            }
        }

        reader.close();
    } catch (final IOException e) {
        throw new RuntimeException(e);
    }
}