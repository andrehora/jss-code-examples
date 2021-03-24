public class ArrayListDemo {
    public static void main(String[] args) {
        System.out.println("Welcome to Java Program to find the length of array list");
        ArrayList < String > listOfBanks = new ArrayList < > ();
        int size = listOfBanks.size();
        System.out.println("size of array list after creating: " + size);
        listOfBanks.add("Citibank");
        listOfBanks.add("Chase");
        listOfBanks.add("Bank of America");
        size = listOfBanks.size();
        System.out.println("length of ArrayList after adding elements: " + size);
        listOfBanks.clear();
        size = listOfBanks.size();
        System.out.println("size of ArrayList after clearing elements: " + size);
    }
}

Read more: http://www.java67.com/2016/07/how-to-find-length-size-of-arraylist-in-java.html#ixzz5mVc9fKH3