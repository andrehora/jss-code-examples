public static void main(final String[] args) {
	final Concept a = new Concept("Dog");
	final Concept b = new Concept("Tree");
	final Concept c= new Concept("Dog");
	final Set<Concept> set1 = Sets.newHashSet(a);
	final Set<Concept> set2 = Sets.newHashSet(b, c);

	final SetView<Concept> inter = Sets.intersection(set1, set2);
	System.out.println(inter); // => [Concept [data=Dog]]
}