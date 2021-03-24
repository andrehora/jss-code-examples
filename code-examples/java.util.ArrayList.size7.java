private static void a(Context context, JSONObject jSONObject, ArrayList<JSONArray> arrayList) {
	if (arrayList.size() <= 0) {
		b(context);
	}
	JSONArray jSONArray = new JSONArray();
	for (int i = 0; i < arrayList.size(); i++) {
		JSONArray jSONArray2 = (JSONArray) arrayList.get(i);
		for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
			if (jSONArray2.optJSONObject(i2) != null) {
				jSONArray.put(jSONArray2.optJSONObject(i2));
			}
		}
	}
	try {
		jSONObject.put(z[6], jSONArray);
	} catch (JSONException e) {
	}
	a = jSONObject;
	a(context, z[11], jSONObject);
}