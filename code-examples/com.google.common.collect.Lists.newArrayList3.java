public void staticFactoryMethodsOfCollections() {
	// Generic collections without Guava
	List<Integer> list1 = new ArrayList<Integer>();
	Set<String> set1 = new HashSet<String>();
	Map<Integer, String> map1 = new HashMap<Integer, String>();

	// Generic collections with Guava
	List<Integer> list2 = newArrayList();
	Set<String> set2 = newHashSet();
	Map<Integer, String> map2 = newHashMap();
	// Don't need to retype the generic anymore

	// Prepopulated collections without Guava
	List<Integer> ints1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

	// Prepopulated collections with Guava
	List<Integer> ints2 = newArrayList(1, 2, 3);

	// Immutable collections without Guava
	List<String> strs1 =
			unmodifiableList(new ArrayList<String>(Arrays.asList("A", "B", "C")));
	@SuppressWarnings("serial")
	Map<Integer, String> int2Str1 =
	unmodifiableMap(new HashMap<Integer, String>() {

		{
			put(1, "a");
			put(2, "b");
			put(3, "c");
		}
	});

	// Immutable collections with Guava
	List<String> strs2 = ImmutableList.of("A", "B", "C");
	Map<Integer, String> int2Str2 = ImmutableMap.of(1, "a", 2, "b", 3, "c");
}