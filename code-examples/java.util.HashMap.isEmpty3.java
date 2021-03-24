public class HashMapIsEmptyOrNot {
 
    public static void main(String[] args) {
 
        // creating empty HashMap object of type <String, String>
        HashMap<String, String> hashMap = new HashMap<String, String>();
 
        // checking empty even before adding any Key-Value pairs
        boolean isEmpty1 = hashMap.isEmpty();
 
        System.out.println("1. Checking Empty"
                + " before adding any entries : " + isEmpty1);
 
        // adding key-value pairs to HashMap object
        hashMap.put("Google", "Sundar Pichai");
        hashMap.put("Facebook", "Mark Zuckerberg");
        hashMap.put("LinkedIn", "Reid Hoffman");
        hashMap.put("Apple", "Steve Jobs");
        hashMap.put("Microsoft", "Bill Gates");
 
        // checking empty adding few entries
        boolean isEmpty2 = hashMap.isEmpty();
 
        System.out.println("\n2. Checking Empty"
                + " before adding any entries : " + isEmpty2);
    }
}