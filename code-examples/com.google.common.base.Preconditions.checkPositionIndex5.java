public void testCheckPositionIndex_withDesc_negative() {
	try {
		Preconditions.checkPositionIndex(-1, 1, "foo");
		fail();
	} catch (IndexOutOfBoundsException expected) {
		assertThat(expected).hasMessage("foo (-1) must not be negative");
	}
}