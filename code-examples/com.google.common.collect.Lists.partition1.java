class ListUtils
{
	// Java program to demonstrate Guava's Lists.partition() method
	public static void main(String[] args)
	{
		List<Integer> mutableList = Arrays.asList(1, 2, 3, 4, 5);

		List<List<Integer>> lists = Lists.partition(mutableList, 2);

		for (List<Integer> sublist: lists)
			System.out.println(sublist);
	}
}