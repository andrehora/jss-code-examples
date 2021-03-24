public static void main(String[] args) {
	int[] arr = {1, 2, 3, 4, 5};
	List<Integer> list = Ints.asList(arr);
	Assert.assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
}