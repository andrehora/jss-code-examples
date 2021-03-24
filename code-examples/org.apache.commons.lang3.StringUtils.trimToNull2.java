public static void main(String[] args) {
	System.out.println(StringUtils.trimToNull(null));
	System.out.println(StringUtils.trimToNull(""));
	System.out.println(StringUtils.trimToNull(" "));
	System.out.println(StringUtils.trimToNull(" BTC     "));
}