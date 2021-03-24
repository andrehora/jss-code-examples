protected JSONObject getChartData() {
    JSONObject data = new JSONObject();
    JSONObject values = new JSONObject();
    HashMap<String, Integer> map = getValues(new HashMap<String, Integer>());
    if (map == null || map.isEmpty()) {
        // Null = skip the chart
        return null;
    }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        JSONArray categoryValues = new JSONArray();
        categoryValues.add(entry.getValue());
        values.put(entry.getKey(), categoryValues);
    }
    data.put("values", values);
    return data;
}