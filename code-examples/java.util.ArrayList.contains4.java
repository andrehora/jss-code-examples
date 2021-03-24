public class test {
  public static void main(String[] args) {
 
   // ArrayList with Capacity 4
      ArrayList<String> StudentList = new ArrayList<String>(4);
      //Added 4 elements
       StudentList.add("David");
       StudentList.add("Tom");
       StudentList.add("Rohit");
       StudentList.add("Paul");
      
       System.out.println("Students in the list are : ");
       System.out.println(StudentList);
  
       System.out.print("Is list contains the student Tom?");
       System.out.println(StudentList.contains("Tom"));
       System.out.print("Is list contains the student Sudhir?");
       System.out.println(StudentList.contains("Sudhir"));
   }
}