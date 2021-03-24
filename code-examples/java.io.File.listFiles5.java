public class App {
 
    public static void main(String[] args) {
 
        File directory = new File("C:\\technicalkeeda");
 
        File[] files = directory.listFiles();
        for (File file: files) {
            try {
 
                System.out.println(file.getCanonicalPath());
 
            } catch (IOException e) {
                e.printStackTrace();
 
            }
        }
    }
}