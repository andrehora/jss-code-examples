public void testTrimToNull() {
	String FOO = "foo";
	assertEquals(FOO, StringUtils.trimToNull(FOO + "  "));
	assertEquals(FOO, StringUtils.trimToNull(" " + FOO + "  "));
	assertEquals(FOO, StringUtils.trimToNull(" " + FOO));
	assertEquals(FOO, StringUtils.trimToNull(FOO + ""));
	assertEquals(null, StringUtils.trimToNull(" \t\r\n\b "));
	assertEquals(null, StringUtils.trimToNull(StringUtilsTest.TRIMMABLE));
	assertEquals(StringUtilsTest.NON_TRIMMABLE, StringUtils.trimToNull(StringUtilsTest.NON_TRIMMABLE));
	assertEquals(null, StringUtils.trimToNull(""));
	assertEquals(null, StringUtils.trimToNull(null));
}