public class StringUtilsTrial {
  public static void main(String[] args) {

    // Join all Strings in the Array into a Single String, separated by $#$
    System.out.println("7) Join Strings using separator >>>"
        + StringUtils.join(new String[] { "AB", "CD", "EF" }, "$#$"));
  }
}