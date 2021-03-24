public class FileExample {
 
	public static void main(String[] args) throws Exception {
 
		try {
 
			File folder = new File("C:\sandbox\testFolder\sub1\sub2");
			if (!folder.exists()) {
				if (folder.mkdirs()) {
					System.out.println("Folders created!");
				} else {
					System.out.println("Failed to create folders!");
				}
			} else {
				System.out.println("Folder already exists!");
			}
 
		} catch (Exception e) {
			System.err.println("Things went wrong: " + e.getMessage());
			e.printStackTrace();
 
		} finally {
 
		}
	}
}