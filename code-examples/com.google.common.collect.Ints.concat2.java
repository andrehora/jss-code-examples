class ArrayUtils
{
	// Java program to demonstrate Guava's Ints.concat() method
	public static void main(String[] args)
	{
		int[] first = { 1, 2, 3 };
		int[] second = { 4, 5 };
		int[] third = { 6, 7, 8 };

		int[] ints = Ints.concat(first, second, third);
		System.out.println(Arrays.toString(ints));
	}
}