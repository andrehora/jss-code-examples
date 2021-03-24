public void ensembles() {
	Set<String> chiffres = Sets.newHashSet("1", "2", "3");
	Set<String> lettres = Sets.newHashSet("A", "B", "C");
	Set<String> voyelles= Sets.newHashSet("A", "E", "I", "O", "U", "Y");
 
	// Cartesian Product
	Set<List<String>> combinations = Sets.cartesianProduct(chiffres, lettres);
	assertEquals(9, combinations.size());
 
	// Difference
	Sets.SetView<String> difference = Sets.difference(lettres, voyelles);
	assertEquals(2, difference.size());
	assertTrue(difference.containsAll(Sets.newHashSet("B", "C")));
 
	// Intersection
	Sets.SetView<String> intersection = Sets.intersection(lettres, voyelles);
	assertEquals(1, intersection.size());
	assertEquals("A", intersection.iterator().next());
 
	// Union
	Sets.SetView<String> union = Sets.union(lettres, voyelles);
	assertEquals(8, union.size());
	assertTrue(union.containsAll(Sets.newHashSet("A", "B", "C", "E", "I", "O", "U", "Y")));
}