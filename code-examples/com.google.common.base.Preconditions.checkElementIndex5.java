public void testCheckElementIndex_withDesc_tooHigh() {
	try {
		Preconditions.checkElementIndex(1, 1, "foo");
		fail();
	} catch (IndexOutOfBoundsException expected) {
		assertThat(expected).hasMessage("foo (1) must be less than size (1)");
	}
}