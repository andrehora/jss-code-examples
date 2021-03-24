public int sum(Integer a, Integer b) {
	a = Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
	b = Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");

	return a+b;
}