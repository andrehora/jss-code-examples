class ArrayUtils
{
	// Java program to demonstrate Guava's Ints.toArray() method
	public static void main(String args[])
	{
		List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);

		int[] primitive = Ints.toArray(ints);
		System.out.println(Arrays.toString(primitive));
	}
}