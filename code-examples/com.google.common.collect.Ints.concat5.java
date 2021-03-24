public static void main(String[] args) { 
	int[] concatResult = Ints.concat(new int[]{1, 2, 3, 4, 5, 6, 7},
	new int[]{8, 9, 10}, new int[]{11, 12, 13, 14});
	System.out.println(Ints.join("|", concatResult));

	// 1|2|3|4|5|6|7|8|9|10|11|12|13|14
}