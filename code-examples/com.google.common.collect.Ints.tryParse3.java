public void conversion() {
	/**
	 * We can also convert objects from one type to another. Note that if parsing fails, they're no exceptions which is thrown but the returned result is
	 * null.
	 */
	Double price = Doubles.tryParse("19.30");
	assertTrue("Parsed price should be 19.30 but is "+ price.doubleValue(), price.doubleValue() == 19.30d);
	Integer age = Ints.tryParse("eighteen");
	assertTrue("'eighteen' shouldn't be parsed to Integer, null was expected but "+age+" was received", age == null);

	/**
	 * Another method to convert from String to Java's primitive is stringConverter() method from each wrapper. Note that, unlinke tryParse, it throws an exception if
	 * given String can't be parsed.
	 */
	Double normalPrice = Doubles.stringConverter().convert("19.32");
	assertTrue("normalPrice should be 19.32 but is "+normalPrice.doubleValue(), normalPrice.doubleValue() == 19.32d);
	try {
		// this test should fail
		Doubles.stringConverter().convert("xyz");
		fail("The test should not pass here: 'xyz' isn't convertissable String");
	} catch (Exception e) {
		assertTrue("Exception should be NumberFormatExceptions but is "+e.getClass(), e.getClass() == NumberFormatException.class);
	}
}