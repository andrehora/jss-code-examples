public static void main(String[] args) {
	Set<String> s1 = Sets.newHashSet("1","2","3");
	Set<String> s2 = Sets.newHashSet("2","3","4");
	Sets.difference(s1,s2);
}