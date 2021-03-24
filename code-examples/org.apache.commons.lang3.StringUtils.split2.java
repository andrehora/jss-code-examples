public class SplitString {
    public static void main(String[] args) {
        //Split a String into an Array using # as seperator.
        String [] splitArr=StringUtils.split("AB#CD#EF#GH", "#");
        
        for(int i=0; i<splitArr.length; i++ ) {
            System.out.println( i + ") "+ splitArr[i]);
        }
    }
}