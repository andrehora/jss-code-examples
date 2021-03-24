public class FileExample {
 
	public static void main(String[] args) throws Exception {
 
		try {
 
			File file = new File("test/.././file.txt");
			System.out.println(file.getPath());
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getCanonicalPath());
 
		} catch (Exception e) {
			System.err.println("Things went wrong: " + e.getMessage());
			e.printStackTrace();
 
		} finally {
 
		}
	}
}