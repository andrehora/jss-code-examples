public class IOUtilsReadLinesWithInputStreamExample {

    public static void main(String... args) {
        String fileName = "D:\\data\\sample.txt";
        try(InputStream inputStream = new FileInputStream(fileName)){
            List<String> fileContent = IOUtils.readLines(inputStream, "UTF-8");
            for(String line: fileContent) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}