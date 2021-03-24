public class PutAllMethodHashMapExample 
{
    public static void main(String args[])
    {
        // create an empty HashMap
        HashMap<Integer,String> hashMap1 = new HashMap<Integer,String>();
        HashMap<Integer,String> hashMap2 = new HashMap<Integer,String>();
        
        // use put() method to put elements to the HashMap1
        hashMap1.put(1,"Element1");
        hashMap1.put(2,"Element2");
        hashMap1.put(3,"Element3");
        hashMap1.put(4,"Element4");
        hashMap1.put(5,"Element5");
        
        System.out.println("**Elements of hashMap1 before putAll()**");
        
        //Print the elements of hashMap1
        for (Map.Entry<Integer,String> entry : hashMap1.entrySet())
        {
            System.out.println("Key : "+entry.getKey()+" Value : "+entry.getValue());
        }
        
        // use put() method to put elements to the HashMap2
        hashMap2.put(10,"Element10");
        hashMap2.put(11,"Element11");
        hashMap2.put(12,"Element12");
        hashMap2.put(13,"Element13");
        hashMap2.put(14,"Element14");
        
        //Put all the elements of hashMap2 to hashMap1
        hashMap1.putAll(hashMap2);
        
        System.out.println("**Elements of hashMap1 after putAll()**");
        //Print the elements of hashMap1
        for (Map.Entry<Integer,String> entry : hashMap1.entrySet())
        {
            System.out.println("Key : "+entry.getKey()+" Value : "+entry.getValue());
        }
    }
}