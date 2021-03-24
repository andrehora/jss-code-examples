public static BeamRecord csvLine2BeamRecord(
    CSVFormat csvFormat,
    String line,
    BeamRecordSqlType beamRecordSqlType) {
  List<Object> fieldsValue = new ArrayList<>(beamRecordSqlType.getFieldCount());
  try (StringReader reader = new StringReader(line)) {
    CSVParser parser = csvFormat.parse(reader);
    CSVRecord rawRecord = parser.getRecords().get(0);

    if (rawRecord.size() != beamRecordSqlType.getFieldCount()) {
      throw new IllegalArgumentException(String.format(
          "Expect %d fields, but actually %d",
          beamRecordSqlType.getFieldCount(), rawRecord.size()
      ));
    } else {
      for (int idx = 0; idx < beamRecordSqlType.getFieldCount(); idx++) {
        String raw = rawRecord.get(idx);
        fieldsValue.add(autoCastField(beamRecordSqlType.getFieldTypeByIndex(idx), raw));
      }
    }
  } catch (IOException e) {
    throw new IllegalArgumentException("decodeRecord failed!", e);
  }
  return new BeamRecord(beamRecordSqlType, fieldsValue);
}