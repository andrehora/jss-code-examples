public static int validatePosIndexAndGetValue(int[] array, int pos) {
	checkPositionIndex(pos, array.length);
	return array[pos -1];
}