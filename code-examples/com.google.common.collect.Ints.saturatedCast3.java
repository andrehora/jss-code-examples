public static void main(String[] args) {
	long lVal = 3_147_483_648L;
	int iVal = Ints.saturatedCast(lVal);
	int result = Ints.saturatedCast(lVal);
	Assert.assertEquals(Integer.MAX_VALUE, result);
}