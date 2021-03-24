private Set<String> getItems(final String rawValue) {
	final Set<String> result = new HashSet<>();
	for (final String rawItem : StringUtils.split(StringUtils.trimToEmpty(rawValue), ',')) {
		result.add(StringUtils.trim(rawItem));
	}
	return result;
}