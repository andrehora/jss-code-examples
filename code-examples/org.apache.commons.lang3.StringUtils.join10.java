private String getCensoringEventsQuery(Criteria[] censoringCriteria)
{
  ArrayList<String> criteriaQueries = new ArrayList<>();
  for (Criteria c : censoringCriteria)    
  {
    String criteriaQuery = c.accept(this);
    criteriaQueries.add(StringUtils.replace(CENSORING_QUERY_TEMPLATE, "@criteriaQuery", criteriaQuery));
  }
  
  return StringUtils.join(criteriaQueries,"\nUNION ALL\n");
}