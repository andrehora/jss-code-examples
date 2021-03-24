class ListUtils
{
	// Iterate over characters of a String using Guava's 
	// Lists.charactersOf() method
	public static void main (String[] args)
	{
		String s = "Techie Delight";

		// using for-each loop
		for (Character ch : Lists.charactersOf(s)) {
			System.out.print(ch);
		}

		System.out.println();

		// Java 8 - listIterator
		Lists.charactersOf(s)       // List<Characters>
				.listIterator()     // or iterator()
				.forEachRemaining(System.out::print);
	}
}