protected ArrayList<Object> collectCells() {
	ArrayList<Object> cells = new ArrayList<Object>();

	Platform[] platforms = ShareSDK.getPlatformList();
	if (platforms == null) {
		platforms = new Platform[0];
	}
	HashMap<String, String> hides = getHiddenPlatforms();
	if (hides == null) {
		hides = new HashMap<String, String>();
	}
	for (Platform p : platforms) {
		if (!hides.containsKey(p.getName())) {
			cells.add(p);
		}
	}

	ArrayList<CustomerLogo> customers = getCustomerLogos();
	if (customers != null && customers.size() > 0) {
		cells.addAll(customers);
	}

	return cells;
}