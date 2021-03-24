public class ListContainsExample {
 
    public static void main(String[] args) {
 
        //make a sample Array List
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("five");
 
        System.out.println("The list contains one " + list.contains("one"));
        System.out.println("The list contains two " + list.contains("two"));
        System.out.println("The list contains four " + list.contains("four"));
 
        //make a sample Linked List
        List<Integer> integerList = new LinkedList<Integer>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(5);
 
        System.out.println("The list contains 1 " + integerList.contains(1));
        System.out.println("The list contains 2 " + integerList.contains(2));
        System.out.println("The list contains 4 " + integerList.contains(4));
 
    }
}