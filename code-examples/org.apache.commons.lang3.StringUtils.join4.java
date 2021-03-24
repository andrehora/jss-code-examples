public class JoinTest {

	public static void main(String[] args) throws IOException {

		String[] strArray = { "string1", "string2", "string3" };
		System.out.println("Joining array of strings");
		System.out.println(StringUtils.join(strArray));
		System.out.println(StringUtils.join(strArray, " "));

		System.out.println("\nJoining list of strings");
		List<String> strList = Arrays.asList(strArray);
		System.out.println(StringUtils.join(strList, null));
		System.out.println(StringUtils.join(strList, " "));
	}
}