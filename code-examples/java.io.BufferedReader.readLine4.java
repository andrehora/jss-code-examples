public class App {
 
    public static void main(String[] args) {
 
        try {
 
            InputStream inputStream = new FileInputStream("C:\\technicalkeeda\\hello.txt");
 
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
 
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
 
            String line = null;
 
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
 
            bufferedReader.close();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}