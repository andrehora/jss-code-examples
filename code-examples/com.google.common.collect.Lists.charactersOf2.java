class ListUtils
{
	public static void main(String[] args)
	{
		String string = "Guava's Lists Class";

		// immutable list of Character values
		List<Character> chars = Lists.charactersOf(string);
		System.out.println(chars);
	}
}