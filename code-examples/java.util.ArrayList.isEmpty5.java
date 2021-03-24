public class ArrayListExample
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
         
        System.out.println(list.isEmpty());     //true
         
        list.add("A");
         
        System.out.println(list.isEmpty());     //false
         
        list.clear();
         
        System.out.println(list.isEmpty());     //true
    }
}