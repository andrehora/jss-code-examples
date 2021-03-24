public class TestMap {

    public static void main(String[] args) {

        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 1);
        fruits.put("orange", 2);
        fruits.put("banana", 3);
        fruits.put("watermelon", null);

        System.out.println("1. Is key 'apple' exists?");
        if (fruits.containsKey("apple")) {
            //key exists
            System.out.println("yes! - " + fruits.get("apple"));
        } else {
            //key does not exists
            System.out.println("no!");
        }

        System.out.println("\n2. Is key 'watermelon' exists?");
        if (fruits.containsKey("watermelon")) {
            System.out.println("yes! - " + fruits.get("watermelon"));
        } else {
            System.out.println("no!");
        }


    }

}