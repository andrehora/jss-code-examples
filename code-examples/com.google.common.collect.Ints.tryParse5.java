public static void main(String[] args) { 
	Integer a = Ints.tryParse("42");
	Assert.assertEquals(Integer.valueOf(42), a);

	// If long value is passed it returns null
	Integer b = Ints.tryParse("87179869184");
	Assert.assertTrue(b == null);
}