public static void main(String[] args) {
	// Given sets
	Set<Character> ab = ImmutableSet.of('a', 'b');
	Set<Character> bc = ImmutableSet.of('b', 'c');
 
	// Difference of two sets
	Sets.difference(ab, bc); // -> [a]
}