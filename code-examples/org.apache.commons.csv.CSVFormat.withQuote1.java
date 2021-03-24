public class Test {

    public static void main(String[] args) throws IOException {
        String DATA = "\"a\";12";
        CSVParser csvParser =    
        CSVFormat.EXCEL
            .withIgnoreEmptyLines()
            .withIgnoreHeaderCase()
            .withRecordSeparator('\n').withQuote('"')
            .withEscape('\\').withDelimeter(';').withTrim()
            .parse(new StringReader(DATA));
}