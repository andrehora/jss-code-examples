public static void main(String[] args) {
	// max value of long is too large for int
	// thus it'll cast to the nearest int
	// which's the max int value
 
	int saturatedCast = Ints.saturatedCast(Long.MAX_VALUE);
	System.out.println(saturatedCast);
	//2147483647
	System.out.println(saturatedCast == Integer.MAX_VALUE); // true
}