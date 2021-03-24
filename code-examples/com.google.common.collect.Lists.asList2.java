class ListUtils
{
	public static void main(String[] args)
	{
		int first = 10;
		int second = 20;

		Integer[] rest = { 30, 40, 50 };

		// List contains 'first' element followed by elements of 
		// the 'rest' array
		List<Integer> firstList = Lists.asList(first, rest);
		System.out.println(firstList);

		// List contains 'first' and 'second' element followed by 
		// elements of the 'rest' array
		List<Integer> secondList = Lists.asList(first, second, rest);
		System.out.println(secondList);

		// List contains elements of the 'rest' array
		List<Integer> list = Lists.asList(null, rest)
				                  .subList(1, rest.length + 1);
		System.out.println(list);
	}
}