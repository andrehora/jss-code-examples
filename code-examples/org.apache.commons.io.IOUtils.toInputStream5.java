public class StringToIOApache {

    public static void main(String[] args) throws IOException {

        String inputString = "This is a String to demo as how to convert it to input stream using Apache Commons IO";

        InputStream inputStream = IOUtils.toInputStream(inputString, StandardCharsets.UTF_8);

    }
}