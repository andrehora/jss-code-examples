public void map(Text key, BytesWritable value, Context context) throws IOException, InterruptedException {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(value.getBytes());
    int n = value.getLength();
    byte[] bytes = new byte[n];
    inputStream.read(bytes, 0, n);
    CSVParser parser = CSVParser.parse(new String(bytes), CSVFormat.DEFAULT);
    try {
        for (CSVRecord csvRecord : parser) {
            for (String string : csvRecord) {
                word.set(string);
                context.write(word, one);
                Counter counter = context.getCounter(CountersEnum.class.getName(), CountersEnum.INPUT_WORDS.toString());
                counter.increment(1);
            }
        }
    } catch (Exception e) {
    }
}