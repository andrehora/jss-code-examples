public class App {
 
    public static void main(String[] args) {
 
        try {
 
            InputStream inputStream = new FileInputStream("C:\\technicalkeeda\\hello.txt");
 
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
 
            int i;
            while ((i = bufferedReader.read()) != -1) {
 
                char c = (char) i;
                bufferedReader.skip(1);
 
                System.out.print(c + " ");
            }
 
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
}