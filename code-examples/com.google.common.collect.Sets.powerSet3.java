class SetUtils
{
	// Java program to demonstrate Guava's Sets.powerSet() method
	public static void main(String[] args)
	{
		Set<Integer> set = Sets.newHashSet(1, 2, 3);
		Set<Set<Integer>> powerSet = Sets.powerSet(set);

		for (Set<Integer> s: powerSet)
			System.out.println(s);
	}
}