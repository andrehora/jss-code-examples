public static void main(String[] args) { 
	Set<String> animals = ImmutableSet.of("gerbil", "hamster");
	Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");

	Set<List<String>> product = Sets.cartesianProduct(animals, fruits);
	// {{"gerbil", "apple"}, {"gerbil", "orange"}, {"gerbil", "banana"},
	//  {"hamster", "apple"}, {"hamster", "orange"}, {"hamster", "banana"}}
}