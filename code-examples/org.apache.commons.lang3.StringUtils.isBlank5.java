public class CheckEmptyString {
    public static void main(String[] args) {
        String var1 = null;
        String var2 = "";
        String var3 = "    ttt";
        String var4 = "Hello World";

        System.out.println("var1 is blank? = " + StringUtils.isBlank(var1));
        System.out.println("var2 is blank? = " + StringUtils.isBlank(var2));
        System.out.println("var3 is blank? = " + StringUtils.isBlank(var3));
        System.out.println("var4 is blank? = " + StringUtils.isBlank(var4));

        System.out.println("var1 is not blank? = " + StringUtils.isNotBlank(var1));
        System.out.println("var2 is not blank? = " + StringUtils.isNotBlank(var2));
        System.out.println("var3 is not blank? = " + StringUtils.isNotBlank(var3));
        System.out.println("var4 is not blank? = " + StringUtils.isNotBlank(var4));

        System.out.println("var1 is empty? = " + StringUtils.isEmpty(var1));
        System.out.println("var2 is empty? = " + StringUtils.isEmpty(var2));
        System.out.println("var3 is empty? = " + StringUtils.isEmpty(var3));
        System.out.println("var4 is empty? = " + StringUtils.isEmpty(var4));

        System.out.println("var1 is not empty? = " + StringUtils.isNotEmpty(var1));
        System.out.println("var2 is not empty? = " + StringUtils.isNotEmpty(var2));
        System.out.println("var3 is not empty? = " + StringUtils.isNotEmpty(var3));
        System.out.println("var4 is not empty? = " + StringUtils.isNotEmpty(var4));
    }
}