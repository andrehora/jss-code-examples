private static String getName(Long param, HashMap hm) {
    if (param == null) return null;
    if (!hm.containsValue(param)) return null;

    for (Iterator it = hm.keySet().iterator(); it.hasNext(); ) {
        String key = (String) it.next();
        if (hm.get(key).equals(param)) return key;
    }

    //should not get normally here .... but who knows :)
    return null;
}