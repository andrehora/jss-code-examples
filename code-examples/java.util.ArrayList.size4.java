public class GetSizeOfArrayList {

	public static void main(String[] args) {

		// Create an ArrayList and populate it with elements
		ArrayList arrayList = new ArrayList();
		arrayList.add("element_1");
		arrayList.add("element_2");
		arrayList.add("element_3");

		int elementsCount = arrayList.size();

		System.out.println("Elements in Array :");
		for(int i=0; i < elementsCount; i++)

			System.out.println(arrayList.get(i));

	}
}