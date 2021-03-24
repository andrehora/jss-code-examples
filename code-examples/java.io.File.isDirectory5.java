public class IsDirectoryExample {

    public static void main(String... args) throws IOException {
        Path dirPath = Files.createTempDirectory("test-dir");
        System.out.println("path: " + dirPath);
        boolean directory = Files.isDirectory(dirPath);
        System.out.println("dir: " + directory);

        Path filePath = Files.createTempFile("test-dir", ".txt");
        System.out.println("path: " + filePath);
        directory = Files.isDirectory(filePath);
        System.out.println("dir: " + directory);
    }
}