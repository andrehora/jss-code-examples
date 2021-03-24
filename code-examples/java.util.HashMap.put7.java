public Map<String, String> getHeaders() {
	Map<String, List<String>> map = con.getHeaderFields();
	HashMap<String, String> res = new HashMap<String, String>(map.size());
	for (String key : map.keySet()) {
		List<String> list = map.get(key);
		StringBuilder tmp = new StringBuilder();
		int n = 0;
		if (list.size() == 1) {
			res.put(key, list.get(0));
			continue;
		}
		if (list.size() == 0) {
			res.put(key, "");
			continue;
		}
		for (String one : list) {
			if (n > 0)
				tmp.append(";");
			tmp.append(one);
			n++;
		}
		res.put(key, tmp.toString());
	}
	return res;
}