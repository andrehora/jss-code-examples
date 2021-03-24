public static void main(String[] args) {
	int foo[] = {1,2,3,4,5};
	Iterable<Integer> fooBar = Ints.asList(foo);
	for(Integer i : fooBar) {
    		System.out.println(i);
	}
}