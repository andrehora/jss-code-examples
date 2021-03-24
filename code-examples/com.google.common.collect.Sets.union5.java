public static void main(String[] args) {
	Set<int> a = Sets.newHashSet(1, 2, 3, 4);
	Set<int> b = Sets.newHashSet(2, 3, 4, 5);
	Sets.setView sv = Sets.union(a, b);
	// sv = {1, 2, 3, 4, 5}
}