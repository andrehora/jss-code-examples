public void testTryParse() {
	tryParseAndAssertEquals(0, "0");
	tryParseAndAssertEquals(0, "-0");
	tryParseAndAssertEquals(1, "1");
	tryParseAndAssertEquals(-1, "-1");
	tryParseAndAssertEquals(8900, "8900");
	tryParseAndAssertEquals(-8900, "-8900");
	tryParseAndAssertEquals(GREATEST, Integer.toString(GREATEST));
	tryParseAndAssertEquals(LEAST, Integer.toString(LEAST));
	assertNull(Ints.tryParse(""));
	assertNull(Ints.tryParse("-"));
	assertNull(Ints.tryParse("+1"));
	assertNull(Ints.tryParse("9999999999999999"));
	assertNull("Max integer + 1",
			Ints.tryParse(Long.toString(((long) GREATEST) + 1)));
	assertNull("Max integer * 10",
			Ints.tryParse(Long.toString(((long) GREATEST) * 10)));
	assertNull("Min integer - 1",
			Ints.tryParse(Long.toString(((long) LEAST) - 1)));
	assertNull("Min integer * 10",
			Ints.tryParse(Long.toString(((long) LEAST) * 10)));
	assertNull("Max long", Ints.tryParse(Long.toString(Long.MAX_VALUE)));
	assertNull("Min long", Ints.tryParse(Long.toString(Long.MIN_VALUE)));
	assertNull(Ints.tryParse("\u0662\u06f3"));
}