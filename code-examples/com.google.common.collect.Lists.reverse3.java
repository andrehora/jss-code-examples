class ListUtils
{
	// Java program to demonstrate Guava's Lists.reverse() method
	public static void main(String[] args)
	{
		List<Integer> mutableList = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> reverse = Lists.reverse(mutableList);
		System.out.println(reverse);
	}
}