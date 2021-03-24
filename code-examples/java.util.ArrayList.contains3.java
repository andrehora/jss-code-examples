public class ArrayListContains {
    public static void main(String[] args) {
 
        ArrayList <String> colors = new ArrayList <String> ();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("White");
        colors.add("Pink");
 
        System.out.println("colors List contains Pink ? " + colors.contains("Pink"));
        System.out.println("colors List contains Yellow ? " + colors.contains("Yellow"));
 
    }
}