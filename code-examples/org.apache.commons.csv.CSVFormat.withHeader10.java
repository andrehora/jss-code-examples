public void setUp()
  throws Exception {
 FileUtils.forceMkdir(TEMP_DIR);
 try (FileWriter fileWriter = new FileWriter(DATA_FILE);
   CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(COLUMNS))) {
  for (Object[] record : RECORDS) {
   csvPrinter.printRecord(record[0],
     StringUtils.join((int[]) record[1], CSVRecordReaderConfig.DEFAULT_MULTI_VALUE_DELIMITER));
  }
 }
}