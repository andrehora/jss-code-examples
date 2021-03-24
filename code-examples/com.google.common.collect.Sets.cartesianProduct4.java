public static void main(String[] args) { 
	List<Set<String>> interimList = new ArrayList<Set<String>>();
	//converting List<List<String>> to List<Set<String>>
	for (List<String> tmp : allLists) { 
    		Set<String> interimSet   = new HashSet<String>(tmp);
    		interimList.add(interimSet);
	}
	System.out.println(interimList);
	Sets.cartesianProduct(interimList);
}