private static void export(final Configuration configuration,
    final TableInfo table) throws IOException {

  warnOnMultipleScans(configuration, table);
  final List<Attribute> attributes = CommonObjects.getTableToAttribute().get(table);
  final List<List<Attribute>> groups = Lists.partition(attributes, configuration.getOpenFileNr());

  int startIndex = 0;
  for (final List<Attribute> group : groups) {
    final List<Writer> writers = writeToDisk(configuration, table, group, startIndex);
    uniqueAndSort(configuration, writers);
    startIndex += group.size();
  }
}