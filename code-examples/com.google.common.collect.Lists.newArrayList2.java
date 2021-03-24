class ListUtils
{
	// Java program to creates a mutable ArrayList instance using 
	// Guava's Lists.newArrayList() method
	public static void main(String[] args)
	{
		// 1. create an empty mutable ArrayList
		List<Integer> emptyList = Lists.newArrayList();
		System.out.println(emptyList);

		// 2. create a mutable ArrayList from elements of the given array
		Integer[] ints = { 1, 2, 3 };
		List<Integer> list = Lists.newArrayList(ints);
		System.out.println(list);

		// 3. create a mutable ArrayList from elements of the given iterable
		Iterable<Integer> iterable = Arrays.asList(1, 2, 3, 4);
		List<Integer> collection = Lists.newArrayList(iterable);
		System.out.println(collection);
		
		// 4. create a mutable ArrayList from given Iterator
		Iterator<Integer> itr = Arrays.asList(1, 2, 3, 4, 5).iterator();
		List<Integer> mutableList = Lists.newArrayList(itr);
		System.out.println(mutableList);
	}
}