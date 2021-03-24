private static String renderParams(JoinPoint joinPoint, String[] params, String[] includeParamNames,
                                   String[] excludeParamNames, boolean inputCollectionAware) {

    Set<String> includeSet = prepareNameSet(includeParamNames);
    Set<String> excludeSet = prepareNameSet(excludeParamNames);
    List<String> requestList = new ArrayList<>();

    Map<String, Object> paramMap = joinPointToParamMap(joinPoint, params);

    if (!includeSet.isEmpty()) {
        includeSet
            .stream().filter(paramMap::containsKey)
            .forEach(key -> requestList.add(buildParam(key, paramMap.get(key), inputCollectionAware)));
    } else if (!excludeSet.isEmpty()) {
        paramMap.forEach((key, value) -> {
            if (!excludeSet.contains(key)) {
                requestList.add(buildParam(key, value, inputCollectionAware));
            }
        });
    } else {
        paramMap.forEach((key, value) -> requestList.add(buildParam(key, value, inputCollectionAware)));
    }

    return StringUtils.join(requestList, ',');
}