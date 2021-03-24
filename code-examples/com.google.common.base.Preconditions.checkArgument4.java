public void testCheckArgument_complexMessage_failure() {
	try {
		Preconditions.checkArgument(false, FORMAT, 5);
		fail("no exception thrown");
	} catch (IllegalArgumentException expected) {
		verifyComplexMessage(expected);
	}
}