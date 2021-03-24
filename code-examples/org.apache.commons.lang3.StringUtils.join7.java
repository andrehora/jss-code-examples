protected String convertQueryComponentToQueryFragment(QueryComponent queryComponent) {
    if (!queryComponent.isFieldedQuery()) {
        return queryComponent.getQuery();
    }

    String field = this.getEncodedFieldName(queryComponent.getField());
    if (field == null) {
        throw new SearchException("Unable to build query string - there is no field named '%s' on %s", queryComponent.getField(), type.getSimpleName());
    }
    String operation = IsSymbols.get(queryComponent.getIs());
    if (queryComponent.isCollectionQuery()) {
        List<String> values = convertValuesToString(field, queryComponent.getCollectionValue());
        String stringValue = StringUtils.join(values, " OR ");
        return String.format("%s:(%s)", field, stringValue);
    } else {
        String value = convertValueToString(field, queryComponent.getValue());
        return String.format("%s%s%s", field, operation, value);
    }
}