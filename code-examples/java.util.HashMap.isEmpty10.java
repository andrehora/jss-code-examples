private String createCanonicalParameterString(HashMap<String, String> params) {
    String paramString = "";
    if (params != null && !params.isEmpty()) {
        TreeMap<String, String> sortedMap = new TreeMap<String, String>(params);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            paramString = paramString + entry.getKey() + "=" + entry.getValue();
            if (!sortedMap.lastKey().equals(entry.getKey())) {
                paramString = paramString + "&";
            }
        }
    }
    return paramString;
}