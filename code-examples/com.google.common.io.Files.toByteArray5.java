public static byte[] getFileRequestContent(String fieldName, String filename, boolean finalize) throws IOException {
    String content = "--" + CONTENT_BOUNDARY + "\r\n" + "Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + filename + "\"\r\n"+
            "Content-Type: application/octet-stream;\r\n\r\n";
 
    File f = new File(filename);
    byte[] bytes = Files.toByteArray(f);
 
    ByteArrayOutputStream stream = new ByteArrayOutputStream2();
    stream.write(content.getBytes());
 
    stream.write(bytes);
 
    String finish = "\r\n";
    if (finalize)
        finish += "--" + CONTENT_BOUNDARY + "--\r\n\r\n";
 
    stream.write(finish.getBytes());
    stream.flush();
 
    return stream.toByteArray();
}