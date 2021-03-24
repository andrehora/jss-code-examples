public void numeric() {
	/**
	 * Sometimes we need to find the biggest and the smallest value of given array. With min() and max() methods of Ints we can achieve it simply.
	 * 
	 * Another numeric wrappers (Floats, Doubles, Longs, Shorts) and Chars also provide min and max methods.
	 */
	int[] testedInt = new int[]{1930, 1940, 1950, 1960, 1970, 1980, 1990, 2000};
	int min = Ints.min(testedInt);
	int max = Ints.max(testedInt);
	assertTrue("Expected min value is 1930 but "+min+" was returned", min == 1930);
	assertTrue("Expected max value is 2000 but "+max+" was returned", max == 2000);

	/**
	 * We can also work with saturated casts which returns the nearest number to the long specified in the method. We test with max Long value which is bigger than the Integer one
	 * (
	 */
	int intCasted = Ints.saturatedCast(Long.MAX_VALUE);
	assertTrue("intCates should be "+Integer.MAX_VALUE+" but is "+intCasted, intCasted == Integer.MAX_VALUE);

	/**
	 * They're also checked casts which allows to cast one value to another one. Some exceptions can be thrown here, for example when casted value is bigger than the
	 * value that can be accepted by to cast class.
	 * 
	 * checkedCast(long value) exists also for Shorts wrapper.
	 */
	try {
		Ints.checkedCast(Long.MAX_VALUE);
	} catch (Exception e) {
		assertTrue("Unexpected exceptions was thrown (IllegalArgumentException expected, "+e.getClass()+ " got)", e.getClass() == IllegalArgumentException.class && e.getMessage().contains("Out of range"));
	}
}