public void testSaturatedCast() {
	for (int value : VALUES) {
		assertEquals(value, Ints.saturatedCast((long) value));
	}
	assertEquals(GREATEST, Ints.saturatedCast(GREATEST + 1L));
	assertEquals(LEAST, Ints.saturatedCast(LEAST - 1L));
	assertEquals(GREATEST, Ints.saturatedCast(Long.MAX_VALUE));
	assertEquals(LEAST, Ints.saturatedCast(Long.MIN_VALUE));
}