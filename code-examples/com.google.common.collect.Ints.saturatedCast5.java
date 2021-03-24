public static void main(String[] args) {
	// 0 is available in int range [-2147483648, 2147483647]
	// so the nearest value to cast
	// is itself in int
 
	saturatedCast = Ints.saturatedCast(0L);
	System.out.println(saturatedCast);
	System.out.println(saturatedCast == 0); // true
}