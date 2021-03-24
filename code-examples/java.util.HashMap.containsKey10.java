public SrlgGraphSearch(Map<E, Object> grouping) {
    if (grouping == null) {
        useSuurballe = true;
        return;
    }
    numGroups = 0;
    HashMap<Object, Integer> tmpMap = new HashMap<>();
    riskGrouping = new HashMap<>();
    for (E key: grouping.keySet()) {
        Object value = grouping.get(key);
        if (!tmpMap.containsKey(value)) {
            tmpMap.put(value, numGroups);
            numGroups++;
        }
        riskGrouping.put(key, tmpMap.get(value));
    }
}