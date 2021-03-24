public List<Set<Expression>> enumerateGroupingSets()
{
  return ImmutableList.copyOf(Sets.powerSet(columns.stream()
      .map(QualifiedNameReference::new)
      .collect(toSet())));
}