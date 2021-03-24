public void makeNewCollectionsInline() {
	{
		// Don't need to specify generic types on right hand side
		List<String> names = Lists.newArrayList();
		names.add("Joe");
	}

	{
		// Empty immutable list
		List<String> names = ImmutableList.of();
	}

	{
		// Immutable list built in one line of code
		List<String> names = ImmutableList.of("Joe", "Tom");
	}

	{
		// Convenient map creation
		Map<Integer, String> people = ImmutableMap.of(1, "Joe",
				2, "Tom");
	}
}