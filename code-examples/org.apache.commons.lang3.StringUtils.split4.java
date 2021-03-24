String str="It is Java Code Geeks";
System.out.println(str);
System.out.println("Splitting str:-");
String[] strs=StringUtils.split(str," ");
for(String s:strs) {
    System.out.println(s);
}