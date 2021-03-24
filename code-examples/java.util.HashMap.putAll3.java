public class App {
 
    public static void main(String[] args) {
 
        HashMap < Integer, String > colours = new HashMap < Integer, String > ();
 
        colours.put(1, "Red");
        colours.put(2, "Blue");
        colours.put(3, "Green");
 
        HashMap < Integer, String > fruits = new HashMap < Integer, String > ();
 
        fruits.put(4, "Apple");
        fruits.put(5, "Banana");
        fruits.put(6, "Mango");
 
        HashMap < Integer, String > coloursAndFruits = new HashMap < Integer, String > ();
 
        coloursAndFruits.putAll(colours);
        coloursAndFruits.putAll(fruits);
 
        for (Map.Entry < Integer, String > entry: coloursAndFruits.entrySet()) {
            System.out.println("Key :- " + entry.getKey() + " Value :- " + entry.getValue());
 
        }
 
    }
 
}