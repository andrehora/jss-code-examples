public class ContainsValueMethodHashMapExample 
{
    public static void main(String args[])
    {
        // create an empty HashMap
        HashMap<Integer,String>  hashMap1 = new HashMap<Integer,String>();
        
        // use put() method to put elements to the HashMap
        hashMap1.put(1,"Element1");
        hashMap1.put(2,"Element2");
        hashMap1.put(3,"Element3");
        hashMap1.put(4,"Element4");
        hashMap1.put(5,"Element5");
        
        //Check if the hashmap1 contains value "Element3"
        System.out.println("Does \"hashMap1\" contains value \"Element3\" : "+hashMap1.containsValue("Element3"));
    }
}