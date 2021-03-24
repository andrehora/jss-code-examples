public class MyHashMapKeySearch {

 public static void main(String a[]){
 HashMap<String, String> hm = new HashMap<String, String>();
 //add key-value pair to hashmap
 hm.put("first", "FIRST INSERTED");
 hm.put("second", "SECOND INSERTED");
 hm.put("third","THIRD INSERTED");
 System.out.println(hm);
 if(hm.containsKey("first")){
 System.out.println("The hashmap contains key first");
 } else {
 System.out.println("The hashmap does not contains key first");
 }
 if(hm.containsKey("fifth")){
 System.out.println("The hashmap contains key fifth");
 } else {
 System.out.println("The hashmap does not contains key fifth");
 }
 }
}