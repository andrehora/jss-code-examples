protected String buildQueryString(List<QueryComponent> queryComponents) {
    List<String> stringQueryComponents = new ArrayList<>();
    for (QueryComponent queryComponent : queryComponents) {
        String fragmentString = convertQueryComponentToQueryFragment(queryComponent);
        stringQueryComponents.add(fragmentString);
    }
    return StringUtils.join(stringQueryComponents, " ");
}