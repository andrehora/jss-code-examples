public static void main (String[] args) {
	CSVParser parsed = CSVParser.parse(csvData, 
   		CSVFormat.newFormat('\t').withQuote('"').withHeader());
}