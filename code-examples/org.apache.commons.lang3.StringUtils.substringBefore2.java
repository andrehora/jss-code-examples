public void testSubstringBefore_StringString() {
	assertEquals("foo", StringUtils.substringBefore("fooXXbarXXbaz", "XX"));

	assertEquals(null, StringUtils.substringBefore(null, null));
	assertEquals(null, StringUtils.substringBefore(null, ""));
	assertEquals(null, StringUtils.substringBefore(null, "XX"));
	assertEquals("", StringUtils.substringBefore("", null));
	assertEquals("", StringUtils.substringBefore("", ""));
	assertEquals("", StringUtils.substringBefore("", "XX"));

	assertEquals("foo", StringUtils.substringBefore("foo", null));
	assertEquals("foo", StringUtils.substringBefore("foo", "b"));
	assertEquals("f", StringUtils.substringBefore("foot", "o"));
	assertEquals("", StringUtils.substringBefore("abc", "a"));
	assertEquals("a", StringUtils.substringBefore("abcba", "b"));
	assertEquals("ab", StringUtils.substringBefore("abc", "c"));
	assertEquals("", StringUtils.substringBefore("abc", ""));
}