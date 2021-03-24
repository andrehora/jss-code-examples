public void testCheckNotNull_simple_failure() {
	try {
		Preconditions.checkNotNull(null);
		fail("no exception thrown");
	} catch (NullPointerException expected) {
	}
}