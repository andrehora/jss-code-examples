public static void main(String[] args)  {
	List<String> letters = ImmutableList.of("a", "b", "c");
	List<String> reverseView = Lists.reverse(letters); 
	System.out.println(reverseView); // [c, b, a]
}