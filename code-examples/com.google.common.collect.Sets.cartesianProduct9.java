public RoutingResult route() {
  RoutingResult result = new RoutingResult();
  for (Entry<String, Set<String>> entry : getDataSourceLogicTablesMap().entrySet()) {
    List<Set<String>> actualTableGroups = getActualTableGroups(entry.getKey(), entry.getValue());
    List<Set<RoutingTable>> routingTableGroups = toRoutingTableGroups(entry.getKey(), actualTableGroups);
    result.getTableUnits().getTableUnits().addAll(getTableUnits(entry.getKey(), Sets.cartesianProduct(routingTableGroups)).getTableUnits());
  }
  return result;
}