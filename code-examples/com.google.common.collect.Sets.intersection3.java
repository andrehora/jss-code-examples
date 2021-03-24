public static void main(String[] args) {
	// Given sets
	Set<Character> ab = ImmutableSet.of('a', 'b');
	Set<Character> bc = ImmutableSet.of('b', 'c');

	// Intersection of two sets
	Sets.intersection(ab, bc);			// -> [b]
}