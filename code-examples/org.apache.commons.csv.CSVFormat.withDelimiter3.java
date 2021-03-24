CSVParser csvParser = CSVFormat.DEFAULT.withDelimiter(',').withQuote('"').parse(new StringReader(
        "\"[\"\"54bb051e-3d12-11e5-91cd-b8f6b11b7feb\"\",\"\"472a9748-3d12-11e5-91cd-b8f6b11b7feb\"\"]\",Hallo,114058,Leon,31,\"     \",8400,bar,FOO"));
System.out.println(csvParser.getRecords().get(0).get(0));