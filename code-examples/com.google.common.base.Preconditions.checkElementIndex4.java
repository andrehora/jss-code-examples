public void testCheckElementIndex_ok() {
	assertEquals(0, Preconditions.checkElementIndex(0, 1));
	assertEquals(0, Preconditions.checkElementIndex(0, 2));
	assertEquals(1, Preconditions.checkElementIndex(1, 2));
}