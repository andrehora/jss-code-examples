public void testCheckState_complexMessage_failure() {
	try {
		Preconditions.checkState(false, FORMAT, 5);
		fail("no exception thrown");
	} catch (IllegalStateException expected) {
		verifyComplexMessage(expected);
	}
}