public void testIsBlank() {
	assertTrue(StringUtils.isBlank(null));
	assertTrue(StringUtils.isBlank(""));
	assertTrue(StringUtils.isBlank(StringUtilsTest.WHITESPACE));
	assertFalse(StringUtils.isBlank("foo"));
	assertFalse(StringUtils.isBlank("  foo  "));
}