public static void main(String[] args) { 
	// Given sets
	Set<Character> ab = ImmutableSet.of('a', 'b');
	Set<Character> bc = ImmutableSet.of('b', 'c');
 
	// Union of two sets
	Sets.union(ab, bc);                 // -> [a, b, c]
}