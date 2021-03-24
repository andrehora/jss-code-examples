public static void main(String[] args) { 
	Set<String> animals = ImmutableSet.of("gerbil", "hamster");
	Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");

	Set<Set<String>> animalSets = Sets.powerSet(animals);
	// {{}, {"gerbil"}, {"hamster"}, {"gerbil", "hamster"}}
}