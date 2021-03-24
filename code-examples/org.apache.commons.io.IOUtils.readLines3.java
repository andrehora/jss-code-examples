String value = "This is my string";
 
System.out.println("string before conversion = " + value);
InputStream inputStream = IOUtils.toInputStream(value);
 
try {
    List<String> readLines = IOUtils.readLines(inputStream);
    readLines.forEach(x -> System.out.println("string after conversion = " + x));
} catch (IOException e) {
    e.printStackTrace();
}