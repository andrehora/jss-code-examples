public void testDate_Part() throws Exception {
  final String query = "select date_part('year', date '2008-2-23') as col \n" +
      "from cp.`tpch/region.parquet` \n" +
      "limit 0";

  List<Pair<SchemaPath, MajorType>> expectedSchema = Lists.newArrayList();
  MajorType majorType = Types.required(MinorType.BIGINT);
  expectedSchema.add(Pair.of(SchemaPath.getSimplePath("col"), majorType));

  testBuilder()
      .sqlQuery(query)
      .schemaBaseLine(expectedSchema)
      .build()
      .run();
}