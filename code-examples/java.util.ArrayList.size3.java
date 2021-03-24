public class GFG1 {
	public static void main(String[] argv) throws Exception {
		try {

			// Creating object of ArrayList<Integer>
			ArrayList<Integer> arrlist = new ArrayList<Integer>();

			// Populating arrlist1
			arrlist.add(1);
			arrlist.add(2);
			arrlist.add(3);
			arrlist.add(4);
			arrlist.add(5);

			// print arrlist
			System.out.println("Before operation: " + arrlist);

			// getting total size of arrlist
			// using size() method
			int size = arrlist.size();

			// print the size of arrlist
			System.out.println("Size of list = " + size);
		}

		catch (IndexOutOfBoundsException e) {

			System.out.println("Exception thrown: " + e);
		}
	}
}